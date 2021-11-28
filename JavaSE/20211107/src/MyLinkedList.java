

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public ListNode head;

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
        }else {
            ListNode cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val+' ');
            cur = cur.next;
        }
        System.out.println();
    }

    // 链表的回文结构
    public boolean chkPalindrome() {
        if(head == null) return true;
        // 找中间节点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow走到了中间位置
        // 反转
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next; // 记录cur下一个
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        // 判断回文
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            // 偶数
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }



    // 创建相交链表 测试
    public void createCut(ListNode headA, ListNode headB) {
        headA.next.next = headB.next.next;
    }

    // 输入两个链表，找出它们的第一个公共结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pl = headA;
        ListNode ps = headB;
        int lenA = 0;
        int lenB = 0;
        while(pl != null) {
            lenA++;
            pl = pl.next;
        }
        // pl==null
        pl = headA;
        while(ps != null) {
            lenB++;
            ps = ps.next;
        }
        // ps = null
        ps = headB;
        int len = lenA - lenB; // 差值步
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        // pl永远指向了最长的链表 ps永远指向了最短的链表 求了差值步len

        // 较长的链表 pl 走差值步
        while(len != 0) {
            pl = pl.next;
            len--;
        }
        // 同时走 直到相遇
        while(pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl; // 如果为空 直接返回就可
    }

    // 给定一个链表，判断链表中是否有环
    public boolean hasCycle() {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast .next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2() {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast .next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;
    }


    // 构建一个环
    public void creatLoop() {
        ListNode cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = head.next.next;
    }

    // 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public ListNode detectCycle() {
        // 判断是否有环
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast .next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        // 返回入口点
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
