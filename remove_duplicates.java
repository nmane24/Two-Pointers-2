


// Approach 1
// Time Complexity : O(n)             
// Space Complexity : O(n) 
//
// Approach 2
// Time Complexity : O(n)             
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leet code : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

Given an integer array nums sorted in non-decreasing order, 
remove some duplicates in-place such that each unique element appears at most twice. 
The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, 
you must instead have the result be placed in the first part of the array nums. 
More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. 
It does not matter what you leave beyond the first k elements.

 

Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores)


/*
Approach 1 : Using extras space
New array is created of same size as original array.
Element are copied to new array only if it is not repeated more than twice (that means 
elements is not equal to element at arr[i-2] location.)
Whenever we copy element, ptr used for tracking second array is incremented.

As we are starting the comparison from 3rd position, handle scenario where size is less than 2.

*/

/*
 * Brute Force - using extra space using hashmap 
 * Time Complexity - O(n) : used for 
 * Space Complexity - O(n) : used for storing into hashmap
 * 
 * 
 * 
 * 
 * 
 * 
 * Aprroach 2 - Coded where we optimize on the space
 * Time Complexity : O(n) ; n is the number of elements we have in the array
 * Space Complexity : O(1)
 * 
 * Maintain a count = 0 variable, we take two pointers : read ptr to read the elements, and another write ptr to write the elements. 
 * We can also call this slow & fast ptrs whatever is okay. We have used ith ptr and slow ptr. 
 * ith ptr is moved with the help of for loop and slow ptr is incremented. which is nothing but iptr is read ptr and slow is the write ptr
 * we check for condition if count <=k
 * WE start both the ptrs from index 0 and once we traverse for first time we increment the count variable and increment both the ptrs.
 * If the 2nd element is equal to the previous one, we will again increase the count by 1, now as count will become 2. Again we will move 
 * both the ptrs.
 * Now we check again with previous element, so we increment the count which becomes 3 now, we check the if condition as it is now greater 
 * than k we just increase our read pointer and keep write pointer as is.
 * Now as write pointer has moved ahead than read , we check again if its equal to previous element , no it is not we 
 * will reset the count to 1 and check if count < = k , it is then write the element at the index & move both the ptrs.
 * So whenever the read pts encounters a distinct element we reset the counter. 
 * The count variable if its less than  <k  then we  increment the read and write ptrs and if the count variable and copy the read element to write position
 * and if count > k then we only increment the read ptr.
 *  
 * 
 * 
 */

public class remove_duplicates {
    public int removeDuplicates (int[] nums){
        int n = nums.length;
        int slow = 0;
        int count = 0; // intialized at 0.
        for(int i = 0; i< n ; i++){ // read pointer i
            if(i == 0 || nums[i] == nums[i-1]){  // checking for the first index element
                 count ++; // increment to check against k
            }
            else{
                count = 1;  // reset the count value to 1 which indicates the distinct element is found.
            }
            if(count <= 2){
                nums[slow] = nums[i]; // replace at the write value .  O(1)
                slow ++;    // increment the slow here.
            }
        }
        return slow;
    }
}
