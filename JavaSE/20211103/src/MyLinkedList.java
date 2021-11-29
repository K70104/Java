

// 无头单向非循环链表实现
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public ListNode head;

    public void creatList() {
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(23);
        ListNode listNode3 = new ListNode(34);
        ListNode listNode4 = new ListNode(45);
        ListNode listNode5 = new ListNode(56);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        this.head = listNode1;
    }

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //得到单链表的长度
    public int size() {
        int cnt = 0;
        ListNode cur = this.head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;

        // 当链表没有元素时
        /*if(this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }*/
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }


    /**
     * 找到index-1 的位置的节点的地址
     *
     * @param index
     * @return
     */
    public ListNode findIndex(int index) {
        ListNode cur = this.head;
        while (index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("index 位置不合法！");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
    }


    /**
     * 找到要删除的key 的前驱
     *
     * @param key
     * @return
     */
    public ListNode searchPerv(int key) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("单链表为空，无法删除！");
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }

        ListNode cur = searchPerv(key);
        if (cur == null) {
            System.out.println("没有你要删除的节点！");
            return;
        }
        ListNode del = cur.next;
        cur.next = del.next;
    }

    //删除所有值为key的节点，返回删除后链表的head --> 遍历链表一遍
    public ListNode removeAllKey(int key) {
        if (this.head == null) return null;

        ListNode prev = this.head;
        ListNode cur = this.head.next;

        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        // 头节点是key：
        if (this.head.val == key) {
            this.head = this.head.next;
        }

        return this.head;
        // 删除链表中等于给定值 **val** 的所有节点。
        // [OJ链接](https://leetcode-cn.com/problems/removelinked-list-elements/description/)
    }

    public void clear() {
        // 粗暴方式
        // this.head = null;

        while(this.head != null) {
            ListNode curNext = head.next;
            this.head.next = null;
            this.head = curNext;
        }
    }
}


// 创建链表 访问

/*class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    // 成员变量 属于对象
    public ListNode head; // 链表的头引用

    public void creatList() {
        ListNode listNode1 = new ListNode(12);
        ListNode listNode2 = new ListNode(23);
        ListNode listNode3 = new ListNode(34);
        ListNode listNode4 = new ListNode(45);
        ListNode listNode5 = new ListNode(56);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        this.head = listNode1;
    }

        public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

        // 少打印一个 this.head.next != null
        *//*  while(this.head != null) {
            System.out.print(this.head.val+" ");
           this.head = this.head.next;
        } *//*
}*/



/*
class ListNode {
    public int val;
    public ListNode next;

    // 构造方法
    public ListNode(int val) {
        this.val = val;
    }
}

// 链表
public class MyLinkedList {

    public ListNode head; // 链表的头引用

    public static void main1(String[] args) {
        ListNode listNode = new ListNode(1);

        // 带头 / 不带头    循环 / 非循环
    }
}
*/
