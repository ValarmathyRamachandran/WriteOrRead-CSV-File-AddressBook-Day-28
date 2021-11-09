package bridgelabzAddressBook;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

	public class AddressBookMain{
		
		public static void mainMenu() {
			System.out.println(" \n ---------------Welcome to Address Book---------------");
			System.out.println();
			System.out.println("^^^^^^^^^^^ Please enter your choice ^^^^^^^^^^^");
			System.out.println();
			System.out.println("              1.Show Address Books           ");
			System.out.println("              2.Create New Address Book");
		}
		
		public static void menu() {
			System.out.println("Please select your choice: \n");
			System.out.println("3.Add a new contact to your address book.");
			System.out.println("4.Edit a contact from your address book.");
			System.out.println("5.Delete a contact from your address book.");
			System.out.println("6.Print out information of your contacts.");
			System.out.println("7.Quit.");
			System.out.println("8.Go to Main Menu");
			System.out.println("9.Print Sorted list By City or State Name");
			System.out.println("10.Write ContactInformations to File");
			System.out.println("0.Search By City or State Name \n");
			System.out.println("Enter your menu choice:");
			
	    }
		public static void main(String[] args) throws IOException  {
			
			
			mainMenu();
			Scanner scan = new Scanner(System.in);
			int mainMenuChoice = scan.nextInt();
			ListOfOperations listOfoperations = new ListOfOperations() ;
			
			while(mainMenuChoice<=2)
			{
				switch(mainMenuChoice) {
				
				case 1:
				{
					listOfoperations.showAddressBook(mainMenuChoice);
					mainMenu();
					mainMenuChoice=scan.nextInt();
					break;
				}
				case 2:
				{
					listOfoperations.createNewAddressBook(mainMenuChoice);
					menu();
					int choice=scan.nextInt();
	    		
	    		while (choice<=10) {
	    			switch(choice) {
	    			case 3://check duplicate and allow only when it is unique to add contact
	    				listOfoperations.checkDuplicateAndAdd();
	    				menu();
						choice = scan.nextInt();
	    				break;
	    			case 4:
	    				listOfoperations.editContactInfo();
	    				menu();
						choice = scan.nextInt();
	    				break;
	    			case 5:
	    				listOfoperations.deleteContactInfo();
	    				menu();
						choice = scan.nextInt();
	    				break;
	    			case 6:
	    				listOfoperations.printContactInfo();
	    				menu();
						choice = scan.nextInt();
	    				break;
	    			case 7:
	    				System.out.println("You have successfully existed the Address Book");
	    				System.exit(0);
	    				break;
	    			case 0:
						listOfoperations.searchCity();
						menu();
						choice = scan.nextInt();
						break;
	    			case 9:
	    				listOfoperations.sortCity();
	    				menu();
						choice = scan.nextInt();		
	    				break;
	    			case 8:
	    				mainMenu();
	    				mainMenuChoice=scan.nextInt();
	    				choice=11; //to break from inner while
	    				break;
	    			case 10:
	    				listOfoperations.WriteToCSVFile();
	    				System.out.println("-----------------");
	    				System.out.println("::::::Reading from CSV File:::::");
	    				listOfoperations.ReadFromCSVFile();
	    				menu();
						choice = scan.nextInt();		
	    				break;
	    				
	    			default:
	    				System.out.println("Invalid Entry, please select another choice\n");
	    				break;
	    			}			
	    		}
	    		break;
	    		}
			}	
		
		}
	}
}


