package com.imaginary.data.structure;

/**
 * 
 * @author Utkarsh
 *
 * @param <T>
 * 
 */
public interface MyImaginaryDataStructure<T> {

	/**
	 * Better to have return type boolean to know if element was added, in case
	 * of duplicate return value will be false. Exception can also be thrown if
	 * needed
	 * 
	 * @param element
	 * @return
	 */
	boolean add(T element);

	/**
	 * 
	 * @param element
	 */
	void delete(T element);

	/**
	 * 
	 * @param element
	 * @return
	 */
	boolean contains(T element);

	/**
	 * 
	 * @return
	 */
	T getRandom();

	/**
	 * 
	 * @return
	 */
	T getMostRecent();

	/**
	 * 
	 */
	void display();
	
	/**
	 * 
	 * @return
	 */
	T getRandomOptimized();
	
}
