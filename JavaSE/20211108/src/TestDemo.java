

public class TestDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.display(); // 1 2 2 2 3

        myLinkedList.remove(1);
        myLinkedList.display(); // 2 2 2 3

        // myLinkedList.removeAllKey(2);
        // myLinkedList.display(); // 3

        myLinkedList.addIndex(0, 99);
        myLinkedList.display(); // 99 2 2 2 3
        myLinkedList.addIndex(5, 99);
        myLinkedList.display(); // 99 2 2 2 3 99
        myLinkedList.addIndex(3, 99);
        myLinkedList.display(); // 99 2 2 99 2 3 99
    }

    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);

        System.out.println(myLinkedList.size()); // 4
        System.out.println(myLinkedList.contains(1)); // true
        myLinkedList.display(); // 4 3 2 1

        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        myLinkedList.display(); // 4 3 2 1 11 12
    }
}
