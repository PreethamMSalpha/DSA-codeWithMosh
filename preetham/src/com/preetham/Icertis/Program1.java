package com.preetham.Icertis;

import java.util.HashMap;

public class Program1 {
    public static void main(String[] args) {
        int[] C = {3,10,5,25,2,8};
        int[] B = {14,70,53,83,49,91,36,80,92,51,66,70};
        int[] A = {1,2,3,4,5,6,7,8};
        int res = maximum_xor_sum(A);
        System.out.println(res);
    }

    public static int maximum_xor_sum(int[] nums) {
        Trie trie = new Trie();
        trie.insert(nums);

        int max = 0;

        for(int num : nums) {
            Node curr = trie.root;
            int currSum = 0;
            for(int i=31;i>=0;i--) {
                int requiredBit = 1-((num >> i) & 1);
                if(curr.children.containsKey(requiredBit)) {
                    currSum |= (1<<i);
                    curr = curr.children.get(requiredBit);
                } else {
                    curr = curr.children.get(1-requiredBit);
                }
            }
            max = Math.max(max, currSum);
        }
        return max;
    }
}

class Node {
    HashMap<Integer, Node> children;
    Node() {
        this.children = new HashMap<>();
    }
}

class Trie {
    Node root;

    Trie() {
        this.root = new Node();
    }

    public void insert(int[] A) {
        for(int num : A) {
            Node curr = this.root;
            for(int i=31;i>=0;i--) {
                int currBit = (num >> i) & 1;
                if(!curr.children.containsKey(currBit))
                    curr.children.put(currBit, new Node());
                curr = curr.children.get(currBit);
            }
        }
    }
}
