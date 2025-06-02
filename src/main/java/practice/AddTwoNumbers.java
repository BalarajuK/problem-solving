package practice;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode t = head;
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            t.next = new ListNode(sum%10);
            carry = sum/10;

            t = t.next;
            l1= l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int sum = l1.val+carry;
            t.next = new ListNode(sum%10);
            carry = sum/10;
            t = t.next;
            l1= l1.next ;
        }

        while(l2!=null){
            int sum = l2.val+carry;
            t.next = new ListNode(sum%10);
            carry = sum/10;
            t = t.next;
            l2= l2.next ;
        }
        if(carry>0){
            t.next = new ListNode(carry);
        }

        return head.next;


    }


     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
