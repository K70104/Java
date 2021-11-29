

public class TestDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);

        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast(13);
        myLinkedList2.addLast(24);
        myLinkedList2.addLast(30);

        ListNode ret = myLinkedList.mergeTwoLists(myLinkedList.head, myLinkedList2.head);
        myLinkedList.display2(ret); // 12 13 23 24 30 34 45
    }

    public static void main3(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(56);
        myLinkedList.display();

        ListNode ret = myLinkedList.findKthToTail(3);
        System.out.println(ret.val); // 34
    }

    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.display();

        ListNode even = myLinkedList.middleNode(); // 偶数第二个
        System.out.println(even.val); // 34
        ListNode even2 = myLinkedList.middleNode1(); // 偶数第一个
        System.out.println(even2.val); // 23
        myLinkedList.addLast(56);
        ListNode odd = myLinkedList.middleNode(); // 奇数
        System.out.println(odd.val); // 34
    }

    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.display();

        ListNode ret = myLinkedList.reverseList();
        myLinkedList.display2(ret); // 56 45 34 23 12
    }

}
