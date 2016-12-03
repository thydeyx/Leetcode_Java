package Maximum_XOR_of_Two_Numbers_in_an_Array;

/**
 * Created by tanghanyi on 2016/12/3.
 */
public class Solution {
    class Trie {
        Trie[] children = new Trie[2];
    }

    private Trie createTrie(int[] nums) {
        Trie root = new Trie();
        for (int num : nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (curNode.children[curBit] == null)
                    curNode.children[curBit] = new Trie();
                curNode = curNode.children[curBit];
            }
        }
        return root;
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length == 0) return 0;
        int ret = 0;
        Trie root = this.createTrie(nums);
        Trie curNode = null;
        int curMax = 0;
        for (int num : nums) {
            curNode = root;
            curMax = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >> i) & 1;
                if (curNode.children[curBit ^ 1] != null) {
                    curMax += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            ret = Math.max(ret, curMax);
        }
        return ret;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int []nums = {3, 10, 5, 25, 2, 8};
        System.out.println(s.findMaximumXOR(nums));
    }
}
