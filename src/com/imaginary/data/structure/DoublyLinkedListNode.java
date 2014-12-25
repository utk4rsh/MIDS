package com.imaginary.data.structure;

public class DoublyLinkedListNode<T> {

	public final T val;

	public DoublyLinkedListNode<T> previous;
	public DoublyLinkedListNode<T> next;

	public DoublyLinkedListNode(T value) {
		val = value;
	}

	public T getVal() {
		return val;
	}

}
