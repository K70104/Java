

public class TestDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(56);

        myLinkedList.creatLoop();
        System.out.println(myLinkedList.hasCycle()); // true
    }

    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(56);

        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addLast(13);
        myLinkedList1.addLast(23);
        myLinkedList1.addLast(30);

        myLinkedList.createCut(myLinkedList.head, myLinkedList1.head);
        ListNode ret = myLinkedList.getIntersectionNode(myLinkedList.head, myLinkedList1.head);
        System.out.println(ret.val); // 30
    }

    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(23);
        myLinkedList.addLast(12);

        System.out.println(myLinkedList.chkPalindrome()); // true
    }
}
