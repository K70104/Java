

public class TestDemo {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(56);
        myLinkedList.display();

        myLinkedList.clear();
        System.out.println("xxxxxxxxx");
    }

    public static void main8(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(56);
        myLinkedList.display();

        myLinkedList.remove(12);
        myLinkedList.display(); // 删除12 --> 23 34 45 56
        myLinkedList.remove(56);
        myLinkedList.display(); // 删除56 --> 23 34 45
        myLinkedList.remove(34);
        myLinkedList.display(); // 删除34 --> 23 45
    }

    public static void main7(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addLast(23);
        myLinkedList.addLast(34);
        myLinkedList.addLast(45);
        myLinkedList.addLast(56);
        myLinkedList.display();
        // 12 23 34 45 56 尾插法 可与头插一起使用

        // 任意插入
        myLinkedList.addIndex(0, 99);
        myLinkedList.display(); // 99 12 23 34 45 56
        myLinkedList.addIndex(6, 99);
        myLinkedList.display(); // 99 12 23 34 45 56 99
        myLinkedList.addIndex(3, 99);
        myLinkedList.display(); // 99 12 23 99 34 45 56 99
    }

    public static void main5(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(12);
        myLinkedList.addFirst(23);
        myLinkedList.addFirst(34);
        myLinkedList.addFirst(45);
        myLinkedList.addFirst(56);
        myLinkedList.display();
        // 56 45 34 23 12 头插法 每次放在前面
    }

    public static void main3(String[] args) {
        // myLinkedList.java 无头单向非循环链表实现
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.creatList();
        myLinkedList.clear();

        myLinkedList.display();
        boolean flg = myLinkedList.contains(12);
        System.out.println(flg); // false

        System.out.println(myLinkedList.size()); // 5
    }

    public static void main2(String[] args) {
        // myLinkedList.java 创建链表 访问

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.creatList();
        myLinkedList.display();
        // 12 23 34 45 56
    }

    public static void main1(String[] args) {
        // 链表的结构非常多样，以下情况组合起来就有8种链表结构：
        /*
        单向、双向
        带头、不带头
        循环、非循环

        单向 带头 循环         双向 带头 循环
        单向 带头 非循环       双向 带头 非循环
        单向 不带头 循环       双向 不带头 循环
        *单向 不带头 非循环     *双向 不带头 非循环

        val：数据域
        next：下一个节点的地址
         */

        // myLinkedList.java 链表
    }
}
