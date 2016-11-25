/**
 * Created by tanghanyi on 2016/11/25.
 */

public class Integer_to_Roman {
    static class Solution {
        public static String intToRoman(int num) {

            int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

            StringBuilder sb = new StringBuilder();

            for(int i=0;i<values.length;i++) {
                while(num >= values[i]) {
                    num -= values[i];
                    sb.append(strs[i]);
                }
            }
            return sb.toString();
        }

    }

    public static void main(String args[]){

        System.out.println(Solution.intToRoman(30));

    }
}