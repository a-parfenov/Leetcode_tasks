package ru.parfenov.leetcode.medium;

public class SearchInRotatedSortedArray_33 {

    public static void main(String[] args) {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(search(new int[] {1}, 0)); // -1
        System.out.println(search(new int[] {1}, 1)); // 0
        System.out.println(search(new int[] {5, 1, 3}, 5)); // 0
        System.out.println(search(new int[] {1, 3, 5}, 5)); // 2
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;

        while (l <= r) {
            mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[l] <= nums[mid]) { // left sorted portion
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else { // right sorted portion
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
