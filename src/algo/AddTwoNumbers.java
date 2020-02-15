package algo;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    
    int promo = 0;
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        int sum = l1.val + l2.val + promo;
        promo = sum / 10;
        int newVal = sum % 10;
        res = new ListNode(newVal);
        if (l1.next != null && l2.next != null) {
            res.next = addTwoNumbers(l1.next, l2.next);
            return res;
        } else if (l1.next == null && l2.next != null){
            copyRestToList (l2.next, res, promo);
            return res;
        } else if (l2.next == null && l1.next != null){
            copyRestToList (l1.next, res, promo);
            return res;
        } else {
            if (promo != 0) {
                res.next = new ListNode(promo);
            }
            return res;
        }
    }
    
    private void copyRestToList (ListNode ToCopyListNode, ListNode targetListNode, int promo) {
        int sum = ToCopyListNode.val + promo;
        int newPromo = sum / 10;
        int newVal = sum % 10;
        targetListNode.next = new ListNode(newVal);
        if (ToCopyListNode.next != null) {
            copyRestToList(ToCopyListNode.next, targetListNode.next, newPromo);
        } else {
            if (newPromo != 0) {
                targetListNode.next.next = new ListNode(newPromo);
            }
        }
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}