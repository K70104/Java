

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    public ListNode head;

    public void adsLast(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
        }else {
            ListNode cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    // 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public void creatLoop() {
        ListNode cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = head.next.next;
    }

    public ListNode detectCycle() {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast;
    }

    // 给定一个链表，判断链表中是否有环
    public boolean hasCycle() {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
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
            pl = pl.next;
            lenA++;
        }
        pl = headA;
        while(ps != null) {
            ps = ps.next;
            lenB++;
        }
        ps = headB;
        int len = lenA - lenB;
        if(len < 0) {
            pl = headB;
            ps = headA;
            len = lenB - lenA;
        }
        while(len != 0) {
            pl = pl.next;
            len--;
        }
        while(pl != ps) {
            pl = pl.next;
            ps = ps.next;
        }
        return pl;
    }

    // 链表的回文结构
    public boolean chkPalindrome() {
        if(head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
