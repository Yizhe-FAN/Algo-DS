package algo;


public class FindDuplicateNum {

    /*
      Require
      Time complexity < O(n^2)
      Space complexity O(1)
      Array ReadOnly
      Only one number duplicate but could be more than once
      */

    /*
      Basic : O(n^2) nested loop to compare
      In place
      Quick sort ?
      Merge sort ?
      Insertion sort ?
      Selection sort ?
      Heap sort ?
       >> ?
      */

    /**
     * n + 1
     * 1 ~ n
     * Switch
     * */

    // NOT GOOD, modify array !
    public int findDuplicate(int[] nums) {
        int locTmp;
        while (true) {
            locTmp = nums[0];
            if (locTmp == nums[locTmp]) {
                return nums[locTmp];
            }
            nums[0] = nums[locTmp];
            nums[locTmp] = locTmp;
        }
    }
}
