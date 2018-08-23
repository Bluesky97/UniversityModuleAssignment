package dict415ipa1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    // Data member
    String schoolName;
    int mainMenuOption,
            studentMatterSubMenuOption,
            moduleMatterSubmenuOption;

    // Constructor
    public Menu(String schName) {
        schoolName = schName;
        mainMenuOption = 0;
        studentMatterSubMenuOption = 0;
        moduleMatterSubmenuOption = 0;
    }

    // Member functions
    public int mainMenu() {
        Scanner scn = new Scanner(System.in);

        // Display the menu
        do {
            try {
                System.out.println("\tStudent Registration System");
                System.out.println("\t\t Main Menu");
                System.out.println("\t\t" + schoolName + "\n");
                System.out.println("\t1. Module Matter");
                System.out.println("\t2. Student Matter");
                System.out.println("\t9. Quit\n");
                System.out.print("Select your option: ");
                mainMenuOption = scn.nextInt();
                // check if option entered is valid
                if (mainMenuOption != 1 && mainMenuOption != 2 && mainMenuOption != 9) {
                    System.out.println("Invalid option. Please enter only 1, 2 or 9.");
                    System.out.println("Please try again!");
                }
            } catch (InputMismatchException inputMismatchExp) {
                System.out.println("Type mismatch. Please enter only 1, 2 or 9.");
                System.out.println("Please try again!");
                scn.nextLine();
            } // end InputMismatchException
        } while (mainMenuOption != 1 && mainMenuOption != 2 && mainMenuOption != 9);
        return mainMenuOption;
    } // end main Menu

    // Module Matter Menu
    public int moduleMatterSubmenu() {
        Scanner scn = new Scanner(System.in);

        // Display the module matter submenu
        do {
            try {
                System.out.println("\tStudent Registration System");
                System.out.println("\t   Module Matter Submenu");
                System.out.println("\t\t" + schoolName + "\n");
                System.out.println("\t1. Add a module");
                System.out.println("\t2. Remove a module");
                System.out.println("\t3. Display module list");
                System.out.println("\t4. Register module(s) for a student");
                System.out.println("\t9. Quit\n");
                System.out.print("Select your option: ");
                moduleMatterSubmenuOption = scn.nextInt();
                // check if option entered is valid
                if (moduleMatterSubmenuOption < 1 || moduleMatterSubmenuOption > 4
                        && moduleMatterSubmenuOption != 9) {
                    System.out.println("Invalid option. Please enter only 1, 2, 3, 4 or 9.");
                    System.out.println("Please try again!");
                }
            } catch (InputMismatchException inputMismatchExp) {
                System.out.println("Type mismatch. Please enter only 1, 2, 3, 4 or 9.");
                System.out.println("Please try again!");
                scn.nextLine();
            } // end InputMismatchException
        } while (moduleMatterSubmenuOption < 1 || moduleMatterSubmenuOption > 4
                && moduleMatterSubmenuOption != 9);
        return moduleMatterSubmenuOption;
    } // end module matter submenu

    // Module Matter Menu
    public int studentMatterSubmenu() {
        Scanner scn = new Scanner(System.in);

        // Display the student matter submenu
        do {
            try {
                System.out.println("\tStudent Registration System");
                System.out.println("\t   Student Matter Submenu");
                System.out.println("\t\t" + schoolName + "\n");
                System.out.println("\t1. Add a student");
                System.out.println("\t2. Remove a student");
                System.out.println("\t3. Display student list");
                System.out.println("\t4. Display module(s) taken by a student");
                System.out.println("\t9. Quit\n");
                System.out.print("Select your option: ");
                studentMatterSubMenuOption = scn.nextInt();
                // check if option entered is valid
                if (studentMatterSubMenuOption < 1 || studentMatterSubMenuOption > 4
                        && studentMatterSubMenuOption != 9) {
                    System.out.println("Invalid option. Please enter only 1, 2, 3, 4 or 9.");
                    System.out.println("Please try again!");
                }
            } catch (InputMismatchException inputMismatchExp) {
                System.out.println("Type mismatch. Please enter only 1, 2, 3, 4 or 9.");
                System.out.println("Please try again!");
                scn.nextLine();
            } // end InputMismatchException
        } while (studentMatterSubMenuOption < 1 || studentMatterSubMenuOption > 4
                && studentMatterSubMenuOption != 9);
        return studentMatterSubMenuOption;
    } // end student matter submenu
}
