/*

// Time Complexity : O(n + m)             
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


Leet code : https://leetcode.com/problems/search-a-2d-matrix-ii/

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

 * 
 * Code Explanation 
 * Brute force : read all the elements/iterated through the matrix and check with target
 * Time Complexity : O(m*n)
 * Space Complexity
 * 
 * Approach 2 - BS each row OR BS each column
 * Traverse through all the rows and check if element is present in the row by performing BS on each row
 * Time Complexity : O(m logn) : m is the number of rows
 * 
 * 
 *  Traverse through all the columns and check if element is present in the columns by performing BS on each column
 * Time Complexity : O(n logm) : n is the number of columns
 * 
 * If number of row is greather than column then take that in log term , which would help to reduce complexity
 * 
 *
 * Approach 3 - Start from the first row last column and if the element is greater than the target then move towards the smaller side,
 * if element is less than the target move towards higher side. SO if target is smaller than the element we move towards left and if target is 
 * greater than the element we move down. WE start from here(or this parituclar corners) as we can make decision which side to move.
 * But if we are in the last row last column, we do not have any decision to make. Same will happen at 1st row 1 column. 
 * But we can start at last row 1st column.
 * 
 * Time Complexity : O(m + n) 
 * 
 * Better complexity is O(m+n) ? or O(m logn)
 * 
 * m = 2, n = 6 
 * O(m+n) = O(8) ; O(2log6) = O(2*3) = O(6) , in this scenario Om(logn) is better
 * 
 * Worst case scenario m = 10^6, n = 10^6
 * 
 * O(m+n) = O(2*10^6) ; 10^6 *log 10^6 =  6*3*10^6 = 18*10^6 ; so in this secnario O(m+n) is better
 * And we are more concerned about the worst case, so O(m+n) is better.
 */
public class search_2d_matrix_II {

    // we started from first row last column
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length;          // rows
        int n  = matrix[0].length;      // columns
        int i = 0; int j = n-1 ; // starting from first row last column element

        while(i<m && j>=0){         // boundary condition
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target){
                j--;        // move left
            }else {
                i++;            //move down
            }
        }
        
        return false;
    }

    // we started from last row first column
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length;          // rows
        int n  = matrix[0].length;      // columns
        int i = m-1; int j=0 ; // starting from first row last column element

        while(i>=0 && j<n){         // boundary condition
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target){
                i--;        // move up
            }else {
                j++;            //move right
            }
        }
        
        return false;
    }
}
