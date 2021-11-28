

class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    public ListNode head = new ListNode(-1);
    public ListNode last;

    // 打印
    public void display() {
        ListNode cur = this.head.next; //
        while(cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 得到单链表的长度
    public int size() {
        ListNode cur = this.head.next; //
        int cnt = 0;
        while(cur != null) {
            cnt++;
            cur = cur.next;
        }
        return cnt;
    }

    // 查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head.next;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            this.last = node;
        } else {
            node.next = this.head.next;
            node.next.prev = node;
            node.prev = this.head;
            this.head.next = node;
        }
    }

    // 尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = last;
            this.last = node;
        }
    }

    public ListNode searchIndex(int index) {
        ListNode cur = this.head;
        while(index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    // 任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index < 0 || index > size()) {
            System.out.println("index 下标范围错误");
            return;
        }
        if(index == 0) {
            addFirst(data);
        } else if(index == size()) {
            addLast(data);
        } else {
            ListNode node = new ListNode(data);
            ListNode cur = searchIndex(index);
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
        }
    }

    // 删除第一次出现关键字为key的节点
    public void remove(int key){
        ListNode cur = this.head.next;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head.next) {
                    this.head.next = cur.next;
                    cur.next.prev = this.head;
                } else if (cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }

    // 删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head.next;
        while(cur != null) {
            if(cur.val == key) {
                if(cur == this.head.next) {
                    this.head.next = cur.next;
                    cur.next.prev = this.head;
                } else if (cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }

    // 清空
    public void clear() {
        ListNode cur = this.head.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        this.head = null;
        this.last = null;
    }
}
