//        3217. Delete Nodes From Linked List Present in Array: You are given an array of integers nums and the head of a linked list. Return the head of the modified linked list after removing all nodes from the linked list that have a value that exists in nums.
//
//        Example 1:
//        Input: nums = [1,2,3], head = [1,2,3,4,5]
//        Output: [4,5]
//        Explanation: Remove the nodes with values 1, 2, and 3.
//
//        Example 2:
//        Input: nums = [1], head = [1,2,1,2,1,2]
//        Output: [2,2,2]
//        Explanation: Remove the nodes with value 1.

//-------------------------------------------------------------------------------------------------------------------------------------------

package Java.problem_solving;

import java.util.HashSet;
import java.util.Set;

public class DeleteSelectedNodesLL {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> hashSet = new HashSet<>();
        for(int num: nums){
            hashSet.add(num);
        }

        while(head != null && hashSet.contains(head.val)){
            head = head.next;
        }

        ListNode ret = head;

        while (head.next != null) {
            if (hashSet.contains(head.next.val)) {
                head.next = head.next.next;
            } else{
                head = head.next;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        DeleteSelectedNodesLL obj = new DeleteSelectedNodesLL();
        int[] nums = {1,2,3};
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode ret = obj.modifiedList(nums, head);
        while(ret != null){
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }
}
