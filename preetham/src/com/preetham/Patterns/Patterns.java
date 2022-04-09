package com.preetham.Patterns;

public class Patterns {
    public static void main(String[] args) {
        pattern31(9);
        System.out.println();
//        pattern31sample2(4);
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
//                for (int col = n; col >= row ; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;
            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;

            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print(col + " ");
//                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern30(int n) {
        for (int row = 1; row <= n; row++) {
            for (int s = 1; s <= n - row; s++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
//                System.out.print("*");
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int row = 1; row < 2 * n; row++) {

            int c = row > n ? 2 * n - row : row;

            for (int s = 0; s < n - c; s++) {
                System.out.print("  ");
            }
            for (int col = c; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }


            System.out.println();
        }
    }

    static void pattern31sample(int n) {
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int value = Math.min(Math.min(row, col), Math.min(n - col, n - row));
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static void pattern31sample2(int n){
        int originalN = n;
        n = 2*n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int value = originalN - Math.min(Math.min(row, col), Math.min(n - col, n - row));
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static void pattern31(int n){
        int originalN = n;
        n = 2*n;
        for (int row = 1; row <= n - 1; row++) {
            for (int col = 1; col <= n - 1; col++) {
                int value = originalN - Math.min(Math.min(row - 1, n - 1 - row), Math.min(n - 1 - col, col - 1));
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

/*
    static void pattern17(int n) {
        for (int row = 1; row < 2 * n; row++) {

            int cc = row > n ? 2 * n - row : row;

            for (int g = 0; g < n-cc; g++) {
                System.out.print(" ");
            }

            for (int col = cc; col >= 1; col--) {
                System.out.print(col);
            }

            for (int col = 2; col <= cc; col++) {
                System.out.print(col);
            }

            System.out.println();
        }
    }

    static void pattern17Long(int n) {
        for (int row = 1; row < 2 * n; row++) {

            int gc = (row <= n) ? n - row : row - n;

            for (int g = 0; g < gc; g++) {
                System.out.print(" ");
            }
            if (row <= n) {
                for (int col = row; col >= 1; col--) {
                    System.out.print(col);
                }
                for (int col = 2; col <= row; col++) {
                    System.out.print(col);
                }
            } else {
                for (int col = 2 * n - row; col >= 1; col--) {
                    System.out.print(col);
                }
                for (int col = 2; col <= 2 * n - row; col++) {
                    System.out.print(col);
                }
            }
            System.out.println();
        }
    }

    static void pattern16(int n) { // work here
        for (int row = 1; row <= n; row++) {
            for (int g = 0; g < n - row; g++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= row; col++) {
                if (col == row) {
                    System.out.print("1 ");
                } else {
                    System.out.print(col + " ");
                }
            }
            System.out.println();
        }
    }

    static void pattern15(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int gc = (row <= n) ? (n - row) : (row - n);
            // int cc = (row <= n) ? row :
            for (int g = 0; g < gc; g++) {
                System.out.print(" ");
            }
            if (row <= n) {
                for (int col = row; col >= 1; col--) {
                    if (col == row || col == 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            } else if (row > n) {
                for (int col = (2 * n - row - 1); col >= 0; col--) {
                    if (col == (2 * n - row - 1) || col == 0) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }

    static void pattern14(int n) {
        for (int i = 1; i < 2 * n; i++) {
            System.out.print("*");
        }
        System.out.println();

        for (int row = 1; row < n; row++) {
            for (int g = 0; g <= row - 1; g++) {
                System.out.print(" ");
            }

            for (int col = n - row; col > 0; col--) {
                if (col == n - row || col == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    static void pattern14X(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        for (int row = 1; row < n; row++) {
            for (int g = 0; g <= row - 1; g++) {
                System.out.print(" ");
            }

            for (int col = n - row; col > 0; col--) {
                if (col == n - row || col == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    static void pattern13(int n) {
        for (int row = 1; row < n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                if (col == row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int col = 2; col <= row; col++) {

                if (col == row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i < 2 * n; i++) {
            System.out.print("*");
        }
    }

    static void pattern13x(int n) {
        for (int row = 1; row < n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                if (col == row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int col = 2; col <= row; col++) {

                if (col == row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
    }

    static void pattern13Num(int n) {
        for (int row = 1; row < n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print(" ");
            }

            for (int col = row; col >= 1; col--) {
                if (col == row) {
                    System.out.print(col);
                } else {
                    System.out.print(" ");
                }
            }
            for (int col = 2; col <= row; col++) {

                if (col == row) {
                    System.out.print(col);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
        }
    }

    static void pattern12(int n) {
        for (int row = 1; row <= n; row++) {

            for (int g = 0; g < row - 1; g++) {
                System.out.print(" ");
            }

            for (int col = n; col >= row; col--) {
                System.out.print("* ");
            }

            System.out.println();
        }

        for (int row = 1; row <= n; row++) {

            for (int g = 0; g < n - row; g++) {
                System.out.print(" ");
            }

            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern11(int n) {
        for (int row = 0; row < n; row++) {
            for (int g = 0; g < row; g++) {
                System.out.print(" ");
            }
            for (int col = n; col > row; col--) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    static void pattern10(int n) {
        for (int row = 0; row < n; row++) {
            for (int g = 0; g < n - row; g++) {
                System.out.print(" ");
            }
            for (int col = 0; col <= row; col++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    static void pattern9Num(int n) {
        for (int row = 1; row <= 5; row++) {
            for (int g = 0; g < row - 1; g++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= n + 1 - row; col++) {
                System.out.print(col);
            }
            for (int col = n - row; col >= 1; col--) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern9(int n) {
        for (int row = 1; row <= 5; row++) {
            for (int g = 0; g < row - 1; g++) {
                System.out.print(" ");
            }
            for (int col = 1; col < 2 * (n - row); col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern8Num(int n) {
        for (int row = 1; row <= n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    static void pattern8(int n) {
        for (int row = 0; row < n; row++) {
            for (int g = 0; g < n - row; g++) {
                System.out.print(" ");
            }
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    static void pattern7(int n) {
        for (int row = 0; row < n; row++) {
            for (int g = 0; g <= row - 1; g++) {
                System.out.print(" ");
            }
            for (int col = n; col > row; col--) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }

    static void pattern6(int n) {
        for (int row = 0; row < n; row++) {
            for (int g = 0; g < n - row; g++) {
                System.out.print(" ");
            }
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = (row > n) ? (2 * n - row) : row;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1 - i; j >= 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print('*');
            }
            System.out.println("*");
        }
    }

    static void printAlphabets() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);
        }

        System.out.println(builder.toString());
        System.out.println(builder.reverse().toString());
    }

    static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;

    }
 */