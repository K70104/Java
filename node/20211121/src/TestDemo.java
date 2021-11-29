

public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(3);
        myLinkedList.addLast(5);
        myLinkedList.addLast(5);
        myLinkedList.addLast(78);
        myLinkedList.addFirst(5);
        myLinkedList.addIndex(3, 100);
        myLinkedList.display();

        myLinkedList.remove(78);

        myLinkedList.removeAllKey(5);
        myLinkedList.display();
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.contains(78));

        myLinkedList.clear();
        System.out.println("=============");
    }
}
