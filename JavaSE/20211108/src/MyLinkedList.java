

// 无头双向链表
class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public ListNode head;//指向双向链表的头节点
    public ListNode last;//指向的是尾巴节点

    public void display() {
        //和单链表的打印方式是一样的
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
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

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null) {
            head = node;
            last = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }


    public ListNode searchIndex(int index) {
        // 返回index位置的地址
        ListNode cur = this.head;
        while(index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        ListNode node = new ListNode(data);
        if(index < 0 || index > size()) {
            System.out.println("index 位置不合法");
            return;
        }
        // 头插
        if(index == 0) {
            addFirst(data);
            return;
        }
        // 尾插
        if(index == size()) {
            addLast(data);
            return;
        }
        // 中间
        ListNode cur = searchIndex(index);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    this.head = head.next;
                    if(this.head != null) { //
                        this.head.prev = null;
                    }else {
                        this.last = null;
                    }
                }else if(cur == this.last){
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }

    public void remove1(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    this.head = head.next;
                    if(this.head != null) { //
                        this.head.prev = null;
                    }else {
                        this.last = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next != null) {
                        // 中间位置
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = this.last.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head) {
                    this.head = head.next;
                    if(this.head != null) { //
                        this.head.prev = null;
                    }else {
                        this.last = null;
                    }
                }else if(cur == this.last){
                    this.last = this.last.prev;
                    this.last.next = null;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                // return;
            }
            cur = cur.next;
        }
    }

    public void clear() {
        while(this.head != null) {
            ListNode curNext = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = curNext;
        }
        this.last = null;

        /*ListNode cur = this.head;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
        this.last = null;*/
    }

    /**
     总结：
     1.顺序表和链表的区别？
     2.数组和链表的区别？
     3.ArrayList和LinkedList的区别？
     共同点：对数据的组织方式和描述方法不同
     组织：
     1.顺序表底层是一个数组，逻辑上和物理上都是连续的
     2.链表是一个由若干节点组成的数据结构，逻辑上是连续的，但在物理上/内存上不一定连续
     操作：
     1.顺序表适合查找相关的操作，因为可以使用下标，直接获取到某个位置的元素
     2.链表适合频繁地插入和删除操作，不需要像顺序表一样移动元素。链表的插入，只需要修改指向
     3.顺序表满了需要扩容，扩容后不一定都能放完，所以空间上的利用率不高
     */

}