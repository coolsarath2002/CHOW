package com.codechallenge.api;

import com.codechallenge.api.facts.ZipcodeDetails;

/**
 * ZipcodeDetailsHelper class for the sorting the list of objects
 * 
 * @author sarathbabu
 *
 */
public class ZipcodeDetailsHelper {

	/**
	 * Merge the zipcodeDetails in asc order.
	 * 
	 * @param headNode
	 * @return
	 */
	public ZipcodeDetails mergesort(ZipcodeDetails headNode) {
		if (headNode == null || headNode.next == null) {
			return headNode;
		}
		// get the middle node of the linked list from the provided headNode
		ZipcodeDetails middleNode = getMiddleNode(headNode);
		// get the next zipcode range from the middlenode
		ZipcodeDetails nextTomiddleNode = middleNode.next;
		middleNode.next = null;
		// recursively call the mergesort on the lefthalf
		ZipcodeDetails leftHalf = mergesort(headNode);
		// recursively call the mergesort on the righthalf
		ZipcodeDetails rightHalf = mergesort(nextTomiddleNode);
		// merge the left and right half of the linked list
		ZipcodeDetails sortedList = merge(leftHalf, rightHalf);
		return sortedList;

	}

	/**
	 * Get the middle node from the linkedList
	 * 
	 * @param headNode
	 * @return
	 */
	private ZipcodeDetails getMiddleNode(ZipcodeDetails headNode) {
		if (headNode == null) {
			return headNode;
		}

		ZipcodeDetails slowIndexer, fastIndexer;
		slowIndexer = headNode;
		fastIndexer = headNode;
		// Have 2 pointer for the ZipcodeDetails linkedList. FastIndexer runs 2 pointer
		// ahead
		// slow pointer runs on the next node. Until we reach a point when the fast
		// indexer.next.next is exhausted
		while (fastIndexer.next != null && fastIndexer.next.next != null) {
			slowIndexer = slowIndexer.next;
			fastIndexer = fastIndexer.next.next;
		}
		return slowIndexer;
	}

	/**
	 * Compare the left and right half of the ZipcodeDetails.
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	private ZipcodeDetails merge(ZipcodeDetails node1, ZipcodeDetails node2) {
		ZipcodeDetails current = null;

		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		// Check if the lowerLimit of node1 is less than node2, then return the current
		// node.
		if (node1.lowerLimit <= node2.lowerLimit) {
			current = node1;
			current.next = merge(node1.next, node2);
			node1 = null;
		} else {
			current = node2;
			current.next = merge(node1, node2.next);
			node2 = null;
		}

		return current;
	}

	void printList(ZipcodeDetails list) {
		ZipcodeDetails temp = null;
		if (list != null) {
			temp = list;
			while (temp != null) {
				System.out.println(temp.lowerLimit + " " + temp.upperLimit);
				temp = temp.next;
			}
			System.out.println("done");
		}

	}
}