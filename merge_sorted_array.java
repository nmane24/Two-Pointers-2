/*

Time Complexity: O(m+n)
Space : O(1)


 Leet code Explanation 
 https://leetcode.com/problems/merge-sorted-array/description/
 
 You are given two integer arrays nums1 and nums2, 
 sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.


 Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 *
 * Code  Explanation 
 * 
 * 
 * Brute force Approach: 
 * 
 * Time Complexity: (m+n) log(m+n)
 * 
 * Take all the elements of 2nd array and replace them in place of zeroes and then sort the complete array
 * 
 * 
 * Optimized Approach: 
 * We use pointer approach method, p1 ptr pointing to one array and p2 ptr pointing to another array. 
 * The p1 ptr is pointing just before the 0's start and p2 ptr is poiting at the last index of 2nd array. 
 * The p3 ptr is pointing at the last index of 1st array. Now we compare p1 and p2 ptr and whichever is higher is replaced with the ptr3
 * The ptr3 is decresed and the whichever ptr gave me the bigger element , we will decrease that ptr.
 * We do this untill one of the ptr goes out of bounds.
 * 
 * If p2 ptr goes out of bound, we dont do anything, but  if p1 ptr goes out of bound & we have elements in p1 array all the elements 
 * from the p2 array have to be shifted to p1 array.
 * 
 * Also , if the ptrs are taken at beginning it would not work.
 * 
 */

public class merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m -1;
        int p2 = n -1;
        int idx = m+n-1;

        while(p1 >=0 && p2 >=0){ // to check if it does not go out of bound
            if(nums1[p1] > nums2[p2]){
                nums1[idx] = nums1[p1];
                p1--;
            }
            else{
                nums1[idx] = nums2[p2];
                p2--;
            }
            idx--;
        }
        while(p2 >= 0){  // elements still exist in p2 array.
            nums1[idx] = nums2[p2];
            idx--;
            p2--;
        }
    }
}
