package com.imaginary.data.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * In order to do all operations in O(1), this datastructure should be backed by
 * hashmap which will store the references of all the elements, while the
 * elements themselves are stored in doubly linked list. Doubly linked list is
 * chosen so that delete is O(1).
 * 
 * @author Utkarsh
 *
 * @param <T>
 */
public class MyImaginaryDataStructureImpl<T> implements MyImaginaryDataStructure<T> {

	private Map<T, DoublyLinkedListNode<T>> midsMap = new HashMap<T, DoublyLinkedListNode<T>>();
	private DoublyLinkedListNode<T> head;
	private DoublyLinkedListNode<T> tail;

	/**
	 * Add element to the map with key as element to be added and value as new
	 * doubly linked list node. Also, head should become the new node with
	 * existing list added to the tail. Uniqueness check is done to restrict
	 * duplicates. O(1)
	 */
	@Override
	public boolean add(T element) {
		DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>(element);
		if (!midsMap.containsKey(element)) {
			midsMap.put(element, newNode);
			resetHead(newNode);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Utility method to rest head and add elements to tail for any new node.
	 * 
	 * @param newNode
	 */
	private void resetHead(DoublyLinkedListNode<T> newNode) {
		newNode.next = head;
		newNode.previous = null;
		if (head != null) {
			head.previous = newNode;
		}

		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
	}

	/**
	 * Delete an exiting node from list and delete the key entry from the map
	 * too. O(1)
	 */
	@Override
	public void delete(T element) {
		DoublyLinkedListNode<T> nodeToDelete = midsMap.get(element);
		DoublyLinkedListNode<T> cur = nodeToDelete;
		DoublyLinkedListNode<T> pre = cur.previous;
		DoublyLinkedListNode<T> post = cur.next;

		if (pre != null) {
			pre.next = post;
		} else {
			head = post;
		}

		if (post != null) {
			post.previous = pre;
		} else {
			tail = pre;
		}
		midsMap.remove(element);
	}

	/**
	 * Contains from map would return whether the element exists or not in the
	 * datastructure O(1)
	 */
	@Override
	public boolean contains(T element) {
		return midsMap.containsKey(element);
	}

	/**
	 * Get a random key from the keyset of map, and return value using random.
	 * Considering hash map maintains the keyset as keys are added in the map.
	 * This operation would take O(1). This can be optimized here itself as
	 * mentioned in last method comment. O(1)
	 */
	@Override
	public T getRandom() {
		Random random = new Random();
		List<T> keys = new ArrayList<T>(midsMap.keySet());
		T randomKey = keys.get(random.nextInt(keys.size()));
		return midsMap.get(randomKey).getVal();
	}

	/**
	 * Since this is a head first doubly linked list. Head will be the most
	 * recent
	 */
	@Override
	public T getMostRecent() {
		return head.getVal();
	}

	@Override
	public T getRandomOptimized() {
		/**
		 * Another supplementary storage to store all elements in array is
		 * needed, so that random fetch is fast and is in O(1). There are few
		 * tradeoffs too wrt getting O(1). Since its array backed datastructure
		 * overflows and resizing needs to be handled too. initial capacity also
		 * needs to be taken as input. Leaving the implementation.
		 */
		return null;
	}

	/**
	 * Utility method
	 */
	@Override
	public void display() {
		DoublyLinkedListNode<T> nodesToDisplay = head;
		while (nodesToDisplay != null) {
			System.out.print(nodesToDisplay.getVal().toString() + " --> ");
			nodesToDisplay = nodesToDisplay.next;
		}
		System.out.println();
	}

}
