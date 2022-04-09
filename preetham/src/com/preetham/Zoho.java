package com.preetham;

public class Zoho {
    public static void main(String[] args) {
        print(3);
    }

    static void print(int n) {
        int i = 1;
        for (int row = 0; row < n; row++) {
            for (int sp = 0; sp < row; sp++) {
                System.out.print(" ");
            }
            for (int col = 0; col < n - row; col++) {
                System.out.print(i++);
//                for (int x=0; x<col; x++){
//                    System.out.print(x);
//                }
//                System.out.print(col);
            }
            System.out.println();
        }
    }

//    static void upperhalf(int n) {
//        int mid = (n + 1) / 2;
//
//        for (int row = 0; row < mid; row++) {
//
//            for (int col = 0; col < n; col++) {
//                if (col > row && col < n-row-1){
//                    System.out.print(" ");
//                }else{
//                    System.out.print("*");
//                }
//
//            }
//            System.out.println(" ");
//        }
//    }
//
//    static void lowerhalf(int n) {
//        int mid = (n + 1) / 2;
//
//        for (int row = mid; row < n; row++) {
//
//            for (int col = n; col > 0; col--) {
//                if (col < row+1 && col > n-row){
//                    System.out.print(" ");
//                }else{
//                    System.out.print("*");
//                }
//
//            }
//            System.out.println(" ");
//        }
//    }

//    static void leftOp(int n) {
//        int mid = (n + 1) / 2;
//        for (int row = 0; row < mid; row++) {
//            for (int col = 0; col <= row; col++) {
//                System.out.print("*");
//            }
//            System.out.println(" ");
//        }
//        for (int row = mid; row < n; row++) {
//            for (int col = n - mid; col > 0; col--) {
//                System.out.print("*");
//            }
//            System.out.println(" ");
//        }
//    }
}

/*
//        Scanner scanner = new Scanner(System.in);
//        String inp = scanner.nextLine();
//
//        int inpLen = inp.length();
//
//        if (inpLen / 2 == 0) {
//            System.out.println("not possible");
//        } else {
//            printDiagonal(inp);
//            lowerDiagonal(inp);
//        }
        printDiagonal("racecar");
        lowerDiagonal("racecar");
    }

    static void lowerDiagonal(String inp) {
        int n = (inp.length() + 1) / 2;
        int firstIndex = 1;
        int lastIndex = inp.length() - 2;

        for (int row = 0; row < n; row++) {
            for (int sp = 0; sp < row; sp++) {
                System.out.print("  ");
            }
            for (int col = n - 1; col > row; col--) {
                if (col == n - 1) {
                    System.out.print(" " + inp.charAt(firstIndex++) + " ");
                } else if (col == row + 1) {
                    System.out.print(" " + inp.charAt(lastIndex--) + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
    }

    static void printDiagonal(String inp) {
//        int n = inp.length();
        int n = (inp.length() + 1) / 2;
        int midIndex = (inp.length() / 2);
//        System.out.println("mid"+inp.charAt(midIndex));
        int leftIndex = midIndex - 1;
        int rightIndex = midIndex + 1;
        for (int row = 0; row < n; row++) {
            for (int sp = 0; sp < n - row; sp++) {
                System.out.print(" ");
            }

            for (int col = 0; col <= row; col++) {
                if (row == 0) {
                    System.out.print(inp.charAt(midIndex));
                    break;
                }
                if (col == 0) {
                    System.out.print(inp.charAt(leftIndex--) + " ");
                } else if (col == row) {
                    System.out.print(inp.charAt(rightIndex++) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println(" ");
        }
    }

}

* */
/*
                    if (col == 0) {
                        System.out.print(inp.charAt(midIndex) + " ");
                    } else if (col == row) {
                        System.out.print(inp.charAt(midIndex) + " ");
 */