package dict415ipa1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class DICT415IPA1 {

    // Declare a new menu with a school name
    static Menu appMenu = new Menu("Bogus School");
    static School sch = new School("Bogus School");
    static Scanner scn = new Scanner(System.in);
    static Scanner sct = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        processMainMenu();
    }

// Process main menu
    /**
     *
     */
    public static void processMainMenu() {
        // loop until user quit
        do {
            // Call the main menu
            appMenu.mainMenuOption = appMenu.mainMenu();

            // Switch statement to decide which option to perform
            switch (appMenu.mainMenuOption) {
                case 1: // Module matter
                    processModuleMatter();
                    break;
                case 2: // Student matter
                    processStudentMatter();
                case 9: // Quit
                    System.out.println("Thank you and bye bye!");
                    break;
            }
        } while (appMenu.mainMenuOption != 9);
    } // end of processMainMenu

    /**
     * getStudentId
     *
     * @return
     */
    public static int getStudentId() {
        boolean cannotCont = true;
        int newStdId = 0;

        // Get new student Id
        do {
            try {
                // Display message to prompt user to enter the new student id and name
                System.out.print("Please enter a student identification number: ");
                newStdId = scn.nextInt();
                cannotCont = false;
            } catch (InputMismatchException inputMismatchEx) {
                System.out.println("Type mismatch! Please enter only numeric number.");
                scn.nextLine();
            }
        } while (cannotCont);
        return newStdId;
    }

    /**
     * getModuleId This method gets the module Id from user
     *
     * @return
     */
    public static int getModuleId() {

        boolean cannotCont = true;
        int newModId = 0;

        // Get new module Id
        do {
            try {
                // Display message to prompt user to enter the new module id
                System.out.print("Please enter a module Id: ");
                newModId = scn.nextInt();
                cannotCont = false;
            } catch (InputMismatchException inputMismatchEx) {
                System.out.println("Type mismatch! Please enter only numeric number.");
                scn.nextLine();
            }
        } while (cannotCont);
        return newModId;
    } // End getModuleId

    /**
     * getSemester
     *
     * @return
     */
    public static int getSemester() {
        int currSemester;
        boolean cannotCont = true;

        // Get the semester
        do {
            System.out.print("Please enter a semester (1 or 2): ");
            currSemester = scn.nextInt();
            cannotCont = false;
            if (currSemester != 1 && currSemester != 2) {
                System.out.println("Please enter only 1 or 2.");
            }
        } while (cannotCont
                || (currSemester != 1 && currSemester != 2));

        return currSemester;
    }

    /**
     * getModuleDetail This method gets as its parameter a module Id and get the
     * module description, class limit and semester from user. The semester must
     * be only 1 or 2. (According to assignment specification.) The method
     * return a Module object.
     *
     * @param modId
     * @return
     */
    public static Module getModuleDetail(int modId) {
        Module currModule;
        boolean cannotCont = true;

        currModule = new Module(modId, null, 0, 0);

        // Get the module description
        System.out.println("\nPlease enter the module description: ");
        currModule.moduleName = sct.nextLine();

        // Get the class limit
        do {
            try {
                System.out.print("\nPlease enter the class limit: ");
                currModule.classLimit = scn.nextInt();
                cannotCont = false;
            } catch (InputMismatchException inputMisMatchEx) {
                System.out.println("Type mismatch. Please enter only numeric value.");
                scn.nextLine();
            }
        } while (cannotCont);

        // Get the semester
        currModule.semester = getSemester();

        // set population to 0
        currModule.population = 0;

        return currModule;
    } // End of getModuleDetail

    // Process module matters
    /**
     *
     */
    public static void processModuleMatter() {
        // loop until user quit
        do {
            appMenu.moduleMatterSubmenu();
            //System.out.println("modSubmenuOption: "
            //        + appMenu.moduleMatterSubmenuOption);
            // Switch statement to decide which option to process
            switch (appMenu.moduleMatterSubmenuOption) {
                case 1: // add module
                    //System.out.println("Add module: "
                    //        + appMenu.moduleMatterSubmenuOption);
                    addModule();
                    break;
                case 2: // remove module
                    //System.out.println("Remove module: "
                    //        + appMenu.moduleMatterSubmenuOption);
                    removeModule();
                    break;
                case 3: // display module list
                    //System.out.println("Display module list: "
                    //        + appMenu.moduleMatterSubmenuOption);
                    displayModuleList();
                    break;
                case 4: // register module(s) for a student
                    // System.out.println("Register module(s) for a student: ");
                    registerModuleForStudent();
                    break;
                case 9: // quit
                    break;
            }
        } while (appMenu.moduleMatterSubmenuOption != 9);
    } // end of process module matter

    /**
     * addModule Prompts the user for the relevant input to create a Module
     * object. It should check if there is any duplicate before the object is
     * created. If there is no duplicate, the Module object is created and added
     * into the collection of the ModuleList (ArrayList) within the School class
     * using the addModule method.
     */
    public static void addModule() {
        int newModId;
        String proceed;
        Module currModule, existingModule;

        newModId = getModuleId();

        existingModule = sch.searchModule(newModId);

        // Check if module Id has already exist
        if (existingModule != null) { // Module is found
            System.out.println("\nModule " + newModId + ", "
                    + existingModule.moduleName
                    + " has already exist. Cannot add.");
        } else { // Module is not found
            currModule = getModuleDetail(newModId);
            System.out.println("Module detail -> "
                    + currModule.moduleName + ", "
                    + currModule.classLimit + ", "
                    + currModule.semester + ".");
            System.out.print("Proceed to add new module? (Y/N):");
            proceed = sct.nextLine();
            if (proceed.equals("y") || proceed.equals("Y")) {
                sch.addModule(currModule);
                System.out.println("Module "
                        + newModId + ", "
                        + currModule.moduleName
                        + " has been added successfully.");
            } else {
                System.out.println("Add module cancelled.");
            }
        }
    } // End addModule

    /**
     * Prompts the user for a moduleID. Allows the user to remove the module
     * only when no students are currently taking the module,
     */
    public static void removeModule() {
        int currModId;
        Module currModule;

        // Get the module Id
        currModId = getModuleId();

        // Search if module exist
        currModule = sch.searchModule(currModId);

        // Check if module exist
        if (currModule != null) { // Module is found
            if (currModule.population == 0) { // Module has no student
                sch.removeModule(currModId);
                System.out.println("Module " + currModId
                        + currModule.moduleName + " has been removed.");
            } else { // Module has student
                System.out.println("Module " + currModId
                        + " has " + currModule.population
                        + " students registered in it. Cannot remove.");
            }
        } else { // Module is not found
            System.out.println("Module " + currModId
                    + " is not found. Cannot remove.");
        }
    } // End remove Module

    /**
     * displayModuleList It searches through the collection of modules and
     * displays all information about the module.
     */
    public static void displayModuleList() {
        sch.listModules();
    } // End displayModuleList

    /**
     * registerModuleForStudent This option allows administrator to register
     * student to take a particular module. The user specifies the studentID,
     * moduleID and semester. It checks whether the module has currently being
     * registered. On top of this, it verifies that the class limit for that
     * module has not been reached and the module is offered in the semester.
     * Given all the verification is successful, the module is added to the
     * collection of modules in Student class.
     */
    public static void registerModuleForStudent() {
        int newStdId, newModId, newSem;

        // Get new student Id from user
        newStdId = getStudentId();

        // Get new module Id from user
        newModId = getModuleId();

        // Get semester from user
        newSem = getSemester();

        sch.registerModule(newStdId, newModId, newSem);
    } // End registerModuleForStudent

    // Process student matters
    /**
     *
     */
    public static void processStudentMatter() {
        // Do until user quit
        do {
            appMenu.studentMatterSubmenu();
            // Switch statement to decide which option to process
            switch (appMenu.studentMatterSubMenuOption) {
                case 1: // add student
                    //System.out.println("Add student: "
                    //        + appMenu.studentMatterSubMenuOption);
                    addStudent();
                    break;
                case 2: // remove student
                    //System.out.println("Remove student: "
                    //        + appMenu.studentMatterSubMenuOption);
                    removeStudent();
                    break;
                case 3: // display student list
                    //System.out.println("Display student list: "
                    //        + appMenu.studentMatterSubMenuOption);
                    displayStudentList();
                    break;
                case 4: // display module(s) taken by a student
                    //System.out.println("Display module(s) taken by a student: "
                    //        + appMenu.studentMatterSubMenuOption);
                    displayModuleTaken();
                    break;
                case 9: // quit
                    break;
            }
        } while (appMenu.studentMatterSubMenuOption != 9);
    } // end of process module matter

    /**
     * Prompts user for the relevant input to create a new student object, It
     * should check if there is any duplicate before the student is created, If
     * there is no duplicate, the new student object is created and added into
     * studentList within the School class using the addStudent method.
     */
    public static void addStudent() {
        // Declare variables for new student id, name and new student object
        int newStdId;
        String newStdName;
        Student newStudent, existingStudent;
        boolean cannotCont = true;

        // Get new student Id
        newStdId = getStudentId();

        // Get new student name
        System.out.print("Please enter a student name: ");
        newStdName = sct.nextLine();

        // Instantiate a new student object
        newStudent = new Student(newStdId, newStdName);

        // Check if student is already exist in the school's list
        existingStudent = sch.searchStudent(newStdId);
        if (existingStudent != null) { // Student found
            System.out.println("Student " + newStdId
                    + " is already exist. Cannot add.");
        } else { // Student is not found -> new student
            sch.studentList.add(newStudent);
            System.out.println("Student " + newStdId + ", " + newStdName
                    + " is added successfully.");
        }
    }

    /**
     * displayStudentList: Go through the studentList and displays the studentID
     * and name for each student.
     */
    public static void displayStudentList() {
        int loopCounter;
        Student currStudent;

        System.out.println("List of students: ");
        // Loop through the school's student collection list
        for (loopCounter = 0; loopCounter < sch.studentList.size(); loopCounter++) {
            currStudent = (Student) sch.studentList.get(loopCounter);
            System.out.println(currStudent.toString());
        }
        System.out.println(loopCounter + " student(s) listed.");
        System.out.println("End of student list.");
    } // end of displayStudentList

    /**
     * removeStudent: Prompts the user for a student ID. For simplicity no check
     * is required to remove the student.
     */
    public static void removeStudent() {
        int stdId;
        String stdName;
        Student currStudent;

        // Get new student Id
        stdId = getStudentId();

        currStudent = sch.searchStudent(stdId);

        if (currStudent != null) { // Student is found
            stdName = currStudent.studentName;
            currStudent.reduceModulePopulation();
            sch.studentList.remove(currStudent);
            System.out.println("Student " + stdId + ", " + stdName
                    + " has been removed successfully!");
        } else {
            System.out.println("Student " + stdId
                    + " is not found. Remove failed.");
        }

    } // end of removeStudent

    /**
     * This method accepts a studentID (int) and display a list of modules taken
     * by the student in the format shown below.
     */
    public static void displayModuleTaken() {
        Student currStudent;

        int currStdId;

        // Get student Id
        currStdId = getStudentId();

        // Seach the student from school's collection of student list
        currStudent = sch.searchStudent(currStdId);

        // Check if student exist
        if (currStudent != null) { // Student is found
            // Display student personal particular
            System.out.print(currStudent.toString());

            // Display the list of module taken
            currStudent.listModuleTaken();
        } else { // Student is not found
            System.out.println("Student " + currStdId
                    + " is not found.");
        }
    } // End displayModuleTaken
}
