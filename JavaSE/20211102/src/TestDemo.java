

public class TestDemo {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0, 11);
        myArrayList.add(1, 22);
        myArrayList.add(2, 33);
        myArrayList.display(); // 11 22 33

        System.out.println(myArrayList.contains(3)); // false

        System.out.println(myArrayList.getPos(1)); // 22

        myArrayList.setPos(0, 99);
        myArrayList.display(); // 99 22 33

        myArrayList.remove(99);
        myArrayList.display(); // 22 33

        System.out.println("==================");
        myArrayList.clear();
        myArrayList.display();
    }

    public static void main1(String[] args) {
        // 顺序表和链表
        /*
        1. 线性表
        线性表（linear list）是n个具有相同特性的数据元素的有限序列。 线性表是一种在实际中广泛使用的数据结构，常见
的线性表：顺序表、链表、栈、队列、字符串...
线性表在逻辑上是线性结构，也就说是连续的一条直线。但是在物理结构上并不一定是连续的，线性表在物理上存储
时，通常以数组和链式结构的形式存储
         */

        /*
        2. 顺序表
        顺序表是用一段物理地址连续的存储单元依次存储数据元素的线性结构，一般情况下采用数组存储。在数组上完成数
据的增删查改
为什么不直接用数组：写到类里，以后就可以面向对象
         */

        /*
            1、插入和删除元素，必须移动元素 O(N)
            2、扩容- 2倍，浪费空间
            能不能做到放1个，给1个空间，插入和删除不移动元素O(1)：链表
            为何会有这么多的数据结构：描述和组织数据的方式不一样
         */
    }
}
