import javax.swing.*;
import java.util.List;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode (int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public ListNode head;

    public void creatList() {
        ListNode listMode1 = new ListNode(12);
        ListNode listMode2 = new ListNode(23);
        ListNode listMode3 = new ListNode(34);
        ListNode listMode4 = new ListNode(45);
        ListNode listMode5 = new ListNode(56);

        listMode1.next = listMode2;
        listMode2.next = listMode3;
        listMode3.next = listMode4;
        listMode4.next = listMode5;

        this.head = listMode1;
    }

    public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //查找关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
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
        while(cur != null) {
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
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head.next == null) {
            this.head = node;
            return;
        }
        ListNode cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }


    /**
     * 找到index-1 的位置的节点的地址
     *
     * @param index
     * @return
     */
    public ListNode findIndex(int index) {
        ListNode cur = this.head;
        while (index-1 != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if(index < 0 || index > size()) {
            System.out.println("index 位置不合法");
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
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
        ListNode cur = this.head;
        while(cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head == null) {
            System.out.println("空");
            return;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        ListNode cur = searchPerv(key);
        if(cur == null) {
            System.out.println("无此要删除的数");
            return;
        }
        ListNode del = cur.next;
        cur.next = del.next;

    }

    //删除所有值为key的节点，返回删除后链表的head --> 遍历链表一遍
    public ListNode removeAllKey(int key) {
        if(this.head == null) return null;
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while(cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
              prev = cur;
              cur = cur.next;
            }
        }
        if(this.head.val == key) {
            this.head = this.head.next;
        }
        return this.head;
    }

    public void clear() {
        //this.head = null;

        while(this.head != null) {
            ListNode curNext = this.head.next;
            this.head.next = null;
            this.head = curNext;
        }
    }
}
