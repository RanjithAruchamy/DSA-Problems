package scaler.linkedlist;

public class LongestPalindromicList {

    /**
     * Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
     * A palindrome list is a list that reads the same backward and forward.
     *
     * Expected memory complexity : O(1)
     *
     * Input 1:
     *  2 -> 3 -> 3 -> 3
     * Input 2:
     *  2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
     *
     * Output 1:
     *  3
     * Output 2:
     *  5
     */

     class ListNode {
       public int val;
       public ListNode next;

       ListNode(int x) { val = x; next = null; }
     }

    public int solve(ListNode A) {
        if (A == null) return 0;

        int ans = 0;

        // Reverse first part
        ListNode curr = A;
        ListNode prev = null;
        while (curr != null ) {
            ListNode next = curr.next;
            curr.next = prev;

            int oddLen = countCommonElements(prev, next) + 1;
            ans = Math.max(ans, oddLen);

            int evenLen = countCommonElements(curr, next);
            ans = Math.max(ans, evenLen);

            prev = curr;
            curr = next;
        }

        return ans;
    }

    // Count common elements to find the length of palindrome
    private int countCommonElements(ListNode first, ListNode second) {
        int count = 0;
        while (first != null && second != null && first.val == second.val) {
            first = first.next;
            second = second.next;
            count++;
        }
        return 2 * count;
    }
}
