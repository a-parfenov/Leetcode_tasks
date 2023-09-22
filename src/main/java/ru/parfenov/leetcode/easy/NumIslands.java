package ru.parfenov.leetcode.easy;

public class NumIslands  {
    public static void main(String[] args) {
        int[][] arr1 = {
                {1,0,0,1},
                {0,1,1,1},
                {0,0,0,0}
        };
        int[][] arr2 = {
                {1,0,0,1,1},
                {0,1,1,1,0},
                {1,0,0,0,1},
                {1,0,1,0,0}
        };
        int[][] arr3 = {
                {1, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0},
        };
        System.out.println(numIslands(arr1));
        System.out.println(numIslands(arr2));
        System.out.println(numIslands(arr3));
    }

    private static int numIslands(int[][] arr1) {
        if (arr1.length == 0 || arr1[0].length == 0) {
            return 0;
        }

        int count = 0;
        int arrLen = arr1.length;
        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] == 1) {
                    count++;
                    dfs(arr1, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] arr1, int i, int j) {
        if (i < 0 || i >= arr1.length || j < 0 || j >= arr1[0].length || arr1[i][j] == 0) {
            return;
        }
        arr1[i][j] = 0;
        dfs(arr1, i + 1, j);
        dfs(arr1, i - 1, j);
        dfs(arr1, i, j + 1);
        dfs(arr1, i, j - 1);
    }
}
