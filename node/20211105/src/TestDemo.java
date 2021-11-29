

public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.creatList();
        myLinkedList.display(); // 12 23 34 45 56

        boolean flg = myLinkedList.contains(12);
        System.out.println(flg); // false

        System.out.println(myLinkedList.size()); // 5

        myLinkedList.addFirst(99);
        myLinkedList.display(); // 99 12 23 34 45 56

        myLinkedList.addLast(99);
        myLinkedList.display(); // 99 12 23 34 45 56 99

        System.out.println("=====================");
        myLinkedList.addIndex(0, 7);
        myLinkedList.display(); // 7 99 12 23 34 45 56 99
        myLinkedList.addIndex(8, 100);
        myLinkedList.display(); // 7 99 12 23 34 45 56 99 100
        myLinkedList.addIndex(3, 7);
        myLinkedList.display(); // 7 99 12 7 23 34 45 56 99 100

        System.out.println("=======================");
        myLinkedList.remove(7);
        myLinkedList.display(); // 99 12 7 23 34 45 56 99 100
        myLinkedList.remove(100);
        myLinkedList.display(); // 99 12 7 23 34 45 56 99
        myLinkedList.remove(23);
        myLinkedList.display(); // 99 12 7 34 45 56 99

        System.out.println("=========================");
        myLinkedList.removeAllKey(99);
        myLinkedList.display(); // 12 7 34 45 56
    }
}
