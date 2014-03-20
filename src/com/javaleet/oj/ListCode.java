package com.javaleet.oj;

import java.util.ArrayList;

import com.javaleet.entity.ListNode;

public class ListCode {
	private ListNode getLast(ListNode head) {
		ListNode tail = head;
		if (head != null && head.next != null) {
			head = head.next;
			while (head.next != null) {
				tail = tail.next;
				head = head.next;
			}
			tail.next = null;
			return head;
		} else return null;
	}
	public void reorderList1(ListNode head) {
		ListNode node;
        while (head != null && head.next != null) {
        	if ((node = getLast(head.next)) != null) {
        		node.next = head.next;
        		head.next = node;
        		head = head.next.next;
        	} else return;
        }
    }
	public void reorderList(ListNode head) {
		if (head == null) return;
		ArrayList<ListNode> a = new ArrayList<ListNode>();
		ListNode node, root = head;
		for ( ; head != null;  head = head.next) {
			a.add(head);
		}
		int i = 0, j = 0;
		for (i = 0, j = a.size() - 1; i < j; i++, j--) {
			head = a.get(i); node = a.get(j);
			node.next = head.next;
			head.next = node;	
		}
		a.get(i).next = null;

    }
	public ListNode detectCycle(ListNode head) {
        ListNode node1 = head, node2 = head, meet;
		while (node2 != null && node2.next != null) {
			node1 = node1.next;
			node2 = node2.next.next;
			if (node1 == node2) break;
		}
		if (node2 == null || node2.next == null) return null;
		node1 = head;
		while (true) {
		    if (node1 == node2) break;
			node1 = node1.next; node2 = node2.next;
		}
		return node1;
    }
	public boolean hasCycle(ListNode head) {
		ListNode node1 = head, node2 = head;
		while (node2 != null && node2.next != null) {
			node1 = node1.next;
			node2 = node2.next.next;
			if (node1 == node2) return true;
		}
		return false;
    }
}
