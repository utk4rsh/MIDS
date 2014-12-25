package com.imaginary.data.structure;

import java.util.Random;

public class MyImaginaryDataStructureTest {

	/**
	 * Main program to run all test cases
	 * 
	 * @param args
	 * @throws AssertionError
	 */
	public static void main(String[] args) throws AssertionError {
		getRandomFilledMids();
		testRecent();
		testUniqueness();
		testDelete();
		testContains();

	}

	/**
	 * Random test Cases to test contains returns correctly
	 */
	private static void testContains() {
		System.out.println("==testContains==begins==");
		MyImaginaryDataStructureImpl<Integer> mids = new MyImaginaryDataStructureImpl<Integer>();
		Random random = new Random();
		int base = 200;
		for (int i = 0; i < 20; i++) {
			int toAdd = random.nextInt(base);
			if (mids.add(toAdd)) {
				if (!mids.contains(toAdd)) {
					System.out.println("Contains Case Failed");
					throw new RuntimeException();
				}
			}
		}
		System.out.println("==testContains==ends==");
		System.out.println();
	}

	/**
	 * Random test Cases to test uniqueness returns correctly.
	 * 
	 */
	private static void testUniqueness() {
		System.out.println("==testUniqueness==begins==");
		MyImaginaryDataStructureImpl<Integer> mids = new MyImaginaryDataStructureImpl<Integer>();
		Random random = new Random();
		int base = 200;
		for (int i = 0; i < 20; i++) {
			int toAdd = random.nextInt(base);
			mids.add(toAdd);
			if (mids.add(toAdd)) {
					System.out.println("Uniqueness Case Failed");
					throw new RuntimeException();
				}
		}
		System.out.println("==testUniqueness==ends==");
		System.out.println();
	}

	/**
	 * Random test Cases to test delete returns correctly
	 */
	private static void testDelete() {
		System.out.println("==testDelete==begins==");
		MyImaginaryDataStructureImpl<Integer> mids = getRandomFilledMids();
		Random random = new Random();
		int[] added = new int[20];
		int base = 200;
		for (int i = 0; i < 20;) {
			int toAdd = random.nextInt(base);
			if (mids.add(toAdd))
				added[i++] = toAdd;
		}
		for (int i = 0; i < 20; i++) {
			mids.delete(added[i]);
			if (mids.contains(added[i])) {
				System.out.println("Delete Test Case Failed");
				throw new RuntimeException();
			}
		}
		System.out.println("==testDelete==ends==");
		System.out.println();
	}

	/**
	 * Random test Cases to test recently added element returns correctly
	 */
	private static void testRecent() {
		System.out.println("==testRecent==begins==");
		MyImaginaryDataStructureImpl<Integer> mids = getRandomFilledMids();
		Random random = new Random();
		int base = 200;
		for (int i = 0; i < 20; i++) {
			int toAdd = random.nextInt(base);
			if (mids.add(toAdd)) {
				if (mids.getMostRecent() != toAdd) {
					System.out.println("Most Recent Test Case Failed");
					throw new RuntimeException();
				}
			}
		}
		System.out.println("==testRecent==ends==");
		System.out.println();
	}

	/**
	 * Utility function to get random filled datastructure.
	 * @return
	 */
	private static MyImaginaryDataStructureImpl<Integer> getRandomFilledMids() {
		MyImaginaryDataStructureImpl<Integer> mids = new MyImaginaryDataStructureImpl<Integer>();
		Random random = new Random();
		int base = 100;
		for (int i = 0; i < 10; i++) {
			mids.add(random.nextInt(base));
		}
		return mids;
	}
}
