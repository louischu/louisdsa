package algomons.binarySearch;

public class VanillaBinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 5, 6, 7, 8, 14, 20, 100};
        System.out.println("Find Target: " + findTarget(sortedArray, 5));
        boolean[] sortedBooleans = {false, false, false, false, true, true};
        System.out.println("FIRST TRUE: " + findFirstTrue(sortedBooleans));

        System.out.println("First First is not smaller: " + findFirstIsNotSmallerThanTarget(sortedArray, 9));
        int[] sortedDupArray = {1, 3, 3, 3, 3, 6, 10, 10, 10, 100};
        System.out.println("FIRST target DUP: " + findFirstInSortedDuplicated(sortedDupArray, 10));

        System.out.println("Find SquareRoot: " + findSquareRoot(10));

        int[] minSorted = {30, 40, 50, 10, 20};
        System.out.println("Find Min Sorted iN ROtate: " + findMinInRotatedSortedArray(minSorted));

        //int[] peakArr = {0, 1, 2, 3, 2, 1, 0};
        int[] peakArr = {0, 1, 2, 3, 4, 5, 9, 3, 2, 1, 0};
        System.out.println("Find peak mountain: " + findPeakMountain(peakArr));

        System.out.println(5 / 3);
        System.out.println(Math.ceil(5 / 3));
        findStartingAndPosition(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    //Input: nums = [3,3,7,7,10,11,11] Output: 10
    public static int returnSingleAppear(int[] nums) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toTheLeft(mid, nums)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return nums[ans];
    }

    static boolean toTheLeft(int idx, int[] nums) {
        if (idx == nums.length - 1) {
            return true;
        } else if (idx % 2 != 0) {
            return nums[idx] != nums[idx - 1];
        } else {
            return nums[idx] != nums[idx + 1];
        }
    }

    //Input: nums = [5,7,7,8,8,10], target = 8
    //Output: [3,4]
    // find the starting and ending position
    public static int[] findStartingAndPosition(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        int lastPost = -1;
        int[] returnValue = {-1, -1};
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                lastPost = mid;
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Last POST: " + lastPost);
        return returnValue;
    }

    //0 1 2 3 2 1 0
    public static int findPeakMountain(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int found = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else {
                found = mid;
                left = mid + 1;
            }
        }
        return found;
    }

    //30, 40, 50, 10, 20
    public static int findMinInRotatedSortedArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int found = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= array[array.length - 1]) {
                found = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return found;
    }

    public static int findSquareRoot(int x) {
        int left = 0;
        int right = x;
        int found = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sr = x / mid;
            if (mid == sr) {
                return mid;
            } else if (mid > sr) {
                found = sr;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return found;
    }

    public static int findFirstInSortedDuplicated(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        int found = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == target) {
                found = mid;
                right = mid - 1;
            } else if (sortedArray[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return found;
    }

    public static int findFirstIsNotSmallerThanTarget(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        int found = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] >= target) {
                found = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return found;
    }

    //The left section consists of all false, and the right section consists of all true
    public static int findFirstTrue(boolean[] sortedArray) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid]) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //VanillaBinary Search
    public static int findTarget(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArray[mid] == target) {
                return mid;
            } else if (sortedArray[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
