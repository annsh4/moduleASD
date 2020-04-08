package me.salmonmoses;

import java.util.*;

public class Task1 implements Task {
	private Scanner input;
	private int[] firstArray;
	private int[] secondArray;

	public Task1(Scanner input) {
		this.input = input;
	}

	@Override
	public String title() {
		return "Common factors";
	}

	@Override
	public void solve() {
		try {
			int firstArrayLength = Prompts.promptInt("Enter first array length: ", 1, 10);
			firstArray = new int[firstArrayLength];
			int secondArrayLength = Prompts.promptInt("Enter second array length: ", 1, 10);
			secondArray = new int[secondArrayLength];
			if (Prompts.promptBoolean("Do you want to fill arrays manually [n]? ")) {
				fillArraysManually();
			} else {
				fillArraysRandom();
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input! Abort!");
			input.next();
			return;
		} catch (AnswerOutOfBoundsException e) {
			System.out.println("Invalid input! Abort!");
			return;
		}
		System.out.println("First array = " + Arrays.toString(firstArray));
		System.out.println("Second array = " + Arrays.toString(secondArray));
		ArrayList<Integer> common = new ArrayList<>();
		for (int i = firstArray[firstArray.length - 1]; i < secondArray[0]; ++i) {
			if (isDividendOfTheFirstArray(i) && isDividerOfTheSecondArray(i)) {
				common.add(i);
			}
		}
		System.out.println("Found numbers that fit task's conditions: " + Arrays.toString(common.toArray(Integer[]::new)));
	}

	private void fillArraysManually() {
		System.out.println("First array: ");
		for (int i = 0; i < firstArray.length; ++i) {
			try {
				firstArray[i] = Prompts.promptInt("\t" + i + ". ", 1, 100);
			} catch (AnswerOutOfBoundsException e) {
				System.out.println("\tValue must be between 1 and 100!");
				--i;
			}
		}
		Arrays.sort(firstArray);
		int maxValueInFirstArray = firstArray[firstArray.length - 1];
		System.out.println("Second array: ");
		for (int i = 0; i < secondArray.length; ++i) {
			try {
				secondArray[i] = Prompts.promptInt("\t" + i + ". ", maxValueInFirstArray + 1, 100);
			} catch (AnswerOutOfBoundsException e) {
				System.out.println("\tValue must be greater than max value in first array and less than 100!");
				--i;
			}
		}
		Arrays.sort(secondArray);
	}

	private void fillArraysRandom() {
		Random r = new Random();
		for (int i = 0; i < firstArray.length; ++i) {
			firstArray[i] = r.nextInt(75) + 1; // просто чтобы дать больший вариант разброса между первым и вторым
			// массивом
		}
		Arrays.sort(firstArray);
		int maxValueInFirstArray = firstArray[firstArray.length - 1];
		for (int i = 0; i < secondArray.length; ++i) {
			secondArray[i] = r.nextInt((100 - maxValueInFirstArray + 1) + 1) + maxValueInFirstArray;
		}
		Arrays.sort(secondArray);
	}

	private boolean isDividendOfTheFirstArray(int toCheck) {
		for (int i : firstArray) {
			if (toCheck % i != 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isDividerOfTheSecondArray(int toCheck) {
		for (int i : secondArray) {
			if (i % toCheck != 0) {
				return false;
			}
		}
		return true;
	}
}
