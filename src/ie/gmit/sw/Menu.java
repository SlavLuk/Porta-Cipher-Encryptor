package ie.gmit.sw;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	// declare instance variables
	private Scanner scan = new Scanner(System.in);
	private int choice;
	private String keyWord;
	private String fread;
	private String fwrite;
	private Parseable fileParser = null;

	// print menu on the screen
	public void printMenu() {

		try {// guarding against bad input

			System.out.println("Welcome to Porta Cipher");
			System.out.println("Please enter 1 to input a keyword\nPlease enter 2 to input"
					+ " a file name or URL(www.sample.com) to parse from\nPlease enter 3 to encrypt/decrypt a text and"
					+ " write into a file\nPlease enter -1 to exit");

			choice = scan.nextInt();

			while (choice != -1) {

				switch (choice) {

				case 1:

					System.out.println(" Please enter a keyword");

					keyWord = scan.next();// read in keyword

					break;

				case 2:
					// read in user's input
					System.out.println(" Please enter a file name or URL to read from");

					fread = scan.next();

					System.out.println(" Please enter a file name to write to");

					fwrite = scan.next();

					// check on user input determining if it is a file name or
					// url name
					if (fread.startsWith("www.") || fread.startsWith("http://")) {

						if (fread.startsWith("www.")) {

							fread = "http://" + fread;
						}

						fileParser = new UrlParser(fread, fwrite);// assigning
																	// url class
																	// to
																	// interface
																	// reference

					} else {

						fileParser = new FileParser(fread, fwrite);// assigning
																	// file
																	// class to
																	// interface
																	// reference
					}

					break;
				case 3:

					System.out.println("Please enter 1 to encrypt or 2 to decrypt");

					choice = scan.nextInt();

					if (choice == 1) {

						try {// in case Exception being thrown

							fileParser.encrypt(keyWord);// encrypting

						} catch (Exception e) {

							System.err.println("Exception occured ,Please try again...\n");

						}

					} else if (choice == 2) {

						try {// in case Exception being thrown

							fileParser.decrypt(keyWord);

						} catch (Exception e) {

							System.err.println("Exception occured ,Please try again...\n");

						}

					}

					break;

				default:

					System.out.println("Sorry invalid input...");

					break;
				}

				// user menu
				System.out.println("\nPlease enter 1 to input a keyword\nPlease enter 2 to input"
						+ " a file name or URL(www.sample.com) to parse from\nPlease enter 3 to encrypt/decrypt a text and"
						+ " write into a file\nPlease enter -1 to exit");

				choice = scan.nextInt();

			}

			scan.close();
			System.exit(0);

		} catch (InputMismatchException e) {

			System.err.println("There has been an InputMismatchException...app is terminating...");

		}

	}

}
