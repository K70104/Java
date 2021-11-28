
// 链表2 力扣OJ
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

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 从指定头节点开始打印
     * @param newHead
     */
    public void display2(ListNode newHead) {
        ListNode cur = newHead;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    // 反转一个单链表
    public ListNode reverseList() {
        if(this.head == null)  {
            return null;
        }
        ListNode prev = null;
        ListNode cur = this.head;

        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    //  给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    // 偶数第二个
    public ListNode middleNode() {
        if(this.head == null) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 偶数第一个
    public ListNode middleNode1() {
        if(this.head == null) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            if(fast == null) {
                return slow;
            }
            slow = slow.next;
        }
        return slow;
    }

    // 输入一个链表，输出该链表中倒数第k个结点
    public ListNode findKthToTail(int k) {
        if(k < 0 || head == null) {
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(k-1 != 0) {
            fast = fast.next;
            if(fast == null) {
                return null;
            }
            k--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(headA != null && headB != null) {
            if (headA.val < headB.val) {
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            } else {
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }

    // 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(int x) {
        ListNode bs = null;
        ListNode be = null;
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = this.head;
        while (cur != null) {
            if(cur.val < x) {
                // 第一次
                if(bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    // 非首次
                    be.next = cur;
                    be = be.next;
                }
            }else {
                // 第一次
                if(as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    // 非首次
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        // 预防第一个段为空
        if(bs == null) {
            return as;
        }
        // 串
        be.next = as;
        // 预防第二个段中的数据 最后一个节点不是空
        if(as != null) {
            ae.next = null;
        }

        return bs;
    }

    // 删除链表重复节点
    public ListNode deleteDuplication() {
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        // 防止最后一个节点也是重复 将最后一个不重复的节点置为空
        tmp.next = null;
        return newHead.next;
    }

}
