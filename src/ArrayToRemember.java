/**
 * Exercise: An Array to Remember
 * Type in the names of the last ten presidents in the order they were elected.
 * When you are done, enter the word history.
 * Your program should display their names starting with the most recent.
 * <p>
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * * * * * * * * * * * * * * * * *       PSEUDOCODE    * * * * * * * * * * * * * * * * * * *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Start
 * //INPUT
 * instantiate scanner object
 * declare string vairable to store the data to be entered
 * declare and initialize it true of boolean variable to control while loop
 * prompt user to insert ten names (separated by comma) and finally to add the word history
 * // PROCESS
 * assign entered String to the variable
 * 	WHILE LOOP (as far as control is equal to true)
 * 		split the string into words or names using comma regex and assign it to a string of names array declared over here
 * 		declare and initialize integer varaible to store array length of recently populated name array
 * 		declare and initialize boolean variables to check if user entered the word history correctly, or with space infront or not
 * 			IF (user inserted ten names + the word history and (either or there is space bar before the word history))
 * // OUTPUT
 * 				print notification of the output
 * 					FOR LOOP ( index to be two lesser than the array length to truncate the word history at the last index)
 *
 * 						IF ( index is equal to the last name's)
 * 							print curly bracing opening symbol
 * 						END IF
 * 						IF ( index is less than length - 2)
 * 							print comma and space // formating is essential part of output
 * 						END IF
 * 						print names array for current index
 * 							IF (index equals to zero)
 * 								print currly bracing closing symbol
 * 							END IF
 * 					EDN FOR LOOP
 * 		assign while loop control to false
 * 			ELSE
 * 				print entered names is not as per the instruction
 * 				prompt user to his (n/N) to quit or any key to again try
 * 					IF (the key user  hit is not (n/N))
 * 						assing while loop control true
 * 					ELSE
 * 						assign while loop contorl false
 * 					END IF
 * 			END IF
 * 	END WHILE
 * close scanner object
 * end
 *
 * * * * * * * * * * * * * * * * *       TEST DATA-1    * * * * * * * * * * * * * * * * * * *
 *
 *
 *
 * Enter ten names of Presidents sparated by comma and
 * (write the word 'history' at the end.)
 * Johnson, Nixon, Ford, Carter, Reagan, Bush, Clinton, Bush, Obama, Trump, history
 *
 * Name of US Presidents:
 * ----------------------
 * { Trump,  Obama,  Bush,  Clinton,  Bush,  Reagan,  Carter,  Ford,  Nixon, Johnson}
 *
 * * * * * * * * * * * * * * * * *       TEST DATA-2    * * * * * * * * * * * * * * * * * * *
 *
 *Enter ten names of Presidents sparated by comma and
 * (write the word 'history' at the end.)
 * Johnson, Nixon, Ford, Carter, Reagan, Bush, Clinton, Bush, Obama, Trump
 *
 * String not entered properly.
 * Please follow the instruction
 * enter (n/N) to quit or any key to continue?
 *
 * * * * * * * * * * * * * * * * *       TEST DATA-2    * * * * * * * * * * * * * * * * * * *
 * 
 * Enter ten names of Presidents sparated by comma and
 * (write the word 'history' at the end.)
 * Johnson, Nixon, Ford, Carter, Reagan, Bush, Clinton, Bush, Obama
 *
 * String not entered properly.
 * Please follow the instruction
 * enter (n/N) to quit or any key to continue? n
 *
 */

import java.util.Scanner;

public class ArrayToRemember {

    public static void main(String[] args) {
        //INPUT
        // instantiate scanner object
        Scanner keyboard = new Scanner(System.in);

        // declare String variable to store data entered
        String str_entered;
        boolean cont = true;

        // prompt user to insert ten names and finally the word history
        System.out.println("Enter ten names of Presidents sparated by comma and ");
        System.out.println("(write the word \'history\' at the end.)");

        // PROCESS
        // scan and assign the whole String
        str_entered = keyboard.nextLine();

        // OUTPUT
        while (cont == true) {
            // split each name separately using comma as regex
            String[] names = str_entered.split(",");
            int n = names.length;

            boolean b = names[n - 1].equalsIgnoreCase(" history");  // if user type space after last comma
            boolean c = names[n - 1].equalsIgnoreCase("history");   // or user didn't hit space after the last comma

            // validate the input if it has ten names + the word history at the end
            if (n == 11 && (b || c)) {
                // make sure to drop the word history
                System.out.println("\nName of US Presidents: ");
                System.out.println("----------------------");

                // index starts from the bigger boundry to print the names in reverse order
                for (int i = n - 2; i >= 0; i--) {
                    // print open curly brace at first for readable output
                    if (i == n - 2) {
                        System.out.printf("{");
                    }

                    // print comma and space after each name
                    if (i < n - 2) {
                        System.out.printf(", ");
                    }

                    // print the name
                    System.out.print(names[i]);

                    if (i == 0) {
                        // print currly brace closing symbol
                        System.out.printf("}");
                    }
                }
                // while loop control
                cont = false;
            }
            else {
                System.out.println("\nString not entered properly.");
                System.out.println("Please follow the instruction");
                System.out.print("enter (n/N) to quit or any key to continue? ");
                String str_cont = keyboard.nextLine();
                if(!str_cont.equalsIgnoreCase("n")){
                    cont = true;
                }
                else{
                    cont = false;
                }
            }
        }   // end of while loop
        keyboard.close();
    }   // end of main()
}   // end of class
