import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static boolean isSorted = true;
	private static ArrayList<Integer> expenses = new ArrayList<Integer>();
	final static String[] arr = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
			"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
			"5. I wish to search for a particular expenditure", "6. Close the application" };
	static ArrayList<Integer> arrlist = new ArrayList<Integer>();
	final static int[] arr1 = { 1, 2, 3, 4, 5, 6 };
	static {
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
		expenses.addAll(arrlist);
	}

	public static void main(String[] args) {
		/* System.out.println("Hello World!"); */
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");
		optionsSelection();

	}

	private static void optionsSelection() {
		try {
			for (int i = 0; i < arr1.length; i++) {
				System.out.println(arr[i]);
				// display the all the Strings mentioned in the String array
			}
			System.out.println("\nEnter your choice:\t");
			Scanner sc = new Scanner(System.in);
			int options = sc.nextInt();
			for (int j = 1; j <= arr1.length; j++) {
				if (options == j) {
					switch (options) {
					case 1:
						System.out.println("Your saved expenses are listed below: \n");
						System.out.println(expenses + "\n");
						optionsSelection();
						break;
					case 2:
						System.out.println("Enter the expense you need to add:\t");
						int value = sc.nextInt();
						expenses.add(value);
						System.out.println("Your value is updated\n");
						expenses.addAll(arrlist);
						isSorted = false;
						System.out.println(expenses + "\n");
						optionsSelection();

						break;
					case 3:
						System.out.println(
								"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
						int con_choice = sc.nextInt();
						if (con_choice == options) {
							expenses.clear();
							System.out.println(expenses + "\n");
							System.out.println("All your expenses are erased!\n");
						} else {
							System.out.println("Oops... try again!");
						}
						optionsSelection();
						break;
					case 4:
						sortExpenses();
						optionsSelection();
						break;
					case 5:
						System.out.println("Enter the expense you need to search:\t");
						int searchString = sc.nextInt();
						searchExpenses(searchString);
						optionsSelection();
						break;
					case 6:
						closeApp();
						break;
					default:
						System.out.println("You have made an invalid choice!");
						optionsSelection();
						break;
					}
				}
			}
		} catch (InputMismatchException e) {
			optionsSelection();
		}

	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
	}

	private static int searchExpenses(Integer searchValue) {
		// Complete the method

		for (int i = 0; i < expenses.size(); i++) {
			if (expenses.get(i).equals(searchValue)) {
				System.out.println(searchValue + " is available in expenses List");
				return i;
			}

		}

		System.out.println(searchValue + " is not available in expenses List");
		return -1;
	}

	private static void sortExpenses() {
		if (!isSorted) {
			isSorted = true;
			Collections.sort(expenses);
		}
		System.out.println("Your value is updated\n");
		System.out.println(expenses + "\n");

	}
}
