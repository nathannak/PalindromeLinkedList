public class Main {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
//        listNode.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(listNode));

    }

    static class ListNode {
        int val=0;
        ListNode next=null;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {

//        FINDING MIDDLE NODE - METHOD 1
//        ListNode p1 = head;
//        ListNode p2 = head;
//        ListNode head_copy = head;
//
//        int count=0;
//        while(head != null){
//                head = head.next;
//                count++;
//        }
//
//        while(p1 != null && p1.next != null){
//            p1 = p1.next.next;
//            p2 = p2.next;
//        }
//
//        if (count%2 !=0){
//            p2=p2.next;
//        }

//      FINDING MIDDLE NODE - METHOD 2
        int count = 0;
        ListNode head_copy = head;

        ListNode p2 = head;
        while (head != null){

            if(count%2 !=0){
                p2 = p2.next;
            }

            count++;
            head = head.next;
        }

        //reverse Linkedlist start from p2
        ListNode next = null;
        ListNode prev = null;
        ListNode current = p2;

        while(current != null){
            next = current.next;
            current.next = prev;

            prev= current;
            current = next;
        }

        //'PREV' is noe head of reversed Linkedlist of second part

        //now compare the second list with first
        while( prev != null ){

            if(head_copy.val != prev.val){return false;}

            head_copy = head_copy.next;
            prev = prev.next;

        }

        return true;

    }

}
