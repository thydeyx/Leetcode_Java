/**
 * Created by tanghanyi on 2016/11/25.
 */
class Solution {
    private int getNum(int[][] matrix, int mid){
        int ret = 0;
        int n = matrix.length, j = 0;
        int i = n - 1;
        while(i >= 0 && j < n){
            if(matrix[i][j] > mid){
                i--;
            }else{
                j++;
                ret += (i + 1);
            }
        }
        return ret;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 0)return 0;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while(l <= r){
            int mid = (l + r) >> 1;
            int num = getNum(matrix, mid);
            if(num < k){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l;
    }
}

public class Kth_Smallest_Element_in_a_Sorted_Matrix {

    public static void main(String args[]) {
        Solution s = new Solution();
        int [][]matrix = {{ 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;
        System.out.println(s.kthSmallest(matrix, k));
    }
}
