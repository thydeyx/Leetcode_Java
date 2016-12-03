package Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by tanghanyi on 2016/11/28.
 */
public class Solution {
    private List<Integer> ret = new ArrayList<Integer>();
    private int[] dfs(String input1, String input2) {
        int n1 = input1.length();
        int ret[] = new int[2];
        int i;
        for (i = 0;i < n1; i++) {
            if (input1.charAt(i) == '-' || input1.charAt(i) == '+' || input1.charAt(i) == '*') {
                int result[] = this.dfs(input1.substring(0, i), input1.substring(i + 1));
                switch (input1.charAt(i)) {
                    case '-':
                        ret[0] = result[0] - result[1];
                        break;
                    case '+':
                        ret[0] = result[0] + result[1];
                        break;
                    case '*':
                        ret[0] = result[0] * result[1];
                        break;
                }
                if (input2.equals("")) {
                    this.ret.add(ret[0]);
                }else {
                    break;
                }
            }
        }
        if (i == n1 && !input2.equals("")) {
            ret[0] = Integer.parseInt(input1);
        }

        int n2 = input2.length();
        List<Integer> tmp = new ArrayList<Integer>();
        for (i = 0; i < n2; i++) {
            if (input2.charAt(i) == '-' || input2.charAt(i) == '+' || input2.charAt(i) == '*') {
                int result[] = this.dfs(input2.substring(0, i), input2.substring(i + 1));
                switch (input2.charAt(i)) {
                    case '-':
                        ret[1] = result[0] - result[1];
                        break;
                    case '+':
                        ret[1] = result[0] + result[1];
                        break;
                    case '*':
                        ret[1] = result[0] * result[1];
                        break;
                }
                tmp.add(ret[1]);
            }
        }
        if (i == n2) {
            ret[1] = Integer.parseInt(input2);
        }


        return ret;
    }

    public List<Integer> diffWaysToCompute(String input) {
        try {
            this.ret.add(Integer.parseInt(input));
        } catch (Exception e) {
            this.dfs(input, "");
        } finally {
            return this.ret;
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        String input = "2*3-4*5";
        List<Integer> ret = s.diffWaysToCompute(input);
        for (Integer i:ret) {
            System.out.println(i);
        }
    }
}