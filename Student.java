package dict415ipa1;

import java.util.ArrayList;

public class Student {

    // Data member
    int studentId;
    String studentName;
    ArrayList<Module> currentModule;

    // Constructor
    public Student(int stdId, String stdName) {
        studentId = stdId;
        studentName = stdName;
        currentModule = new ArrayList<>();
    }

    // Member function
    /**
     * List personal details of student
     *
     * @return
     */
    @Override
    public String toString() {
        String output;
        output = studentId + "\t" + studentName;
        return output;
    }

    // List module taken by student
    /**
     * List module taken by a student
     */
    public void listModuleTaken() {
        int loopCounter;
        Module currModule;
        String output;

        System.out.println("\nList of module taken: ");
        // Loop through the moduleTaken list of the student object
        for (loopCounter = 0; loopCounter < currentModule.size(); loopCounter++) {
            currModule = (Module) currentModule.get(loopCounter);
            output = currModule.moduleId + "\t" + currModule.moduleName;
            System.out.println(output);
        }
        System.out.println(loopCounter + " module(s) listed.");
        System.out.println("End of list.\n");
    } // End listModuleTaken

    /**
     * isAlreadyTaken: This method accepts the module Id (int) and check if the
     * student has already taken the module. If Yes, return true, otherwise
     * return false.
     *
     * @param modId
     * @return
     */
    public boolean isAlreadyTaken(int modId) {
        int loopCounter;
        Module currModule;

        // Loop through the module taken list to check for the module
        for (loopCounter = 0; loopCounter < currentModule.size(); loopCounter++) {
            currModule = (Module) currentModule.get(loopCounter);
            // Check if the module id is the same
            if (currModule.moduleId == modId) { // Module is already taken
                return true;
            }
        }
        // otherwise, the module is not taken yet
        return false;
    }

    /**
     * reduceModulePopulation: This methods go through the currentModule list
     * and remove all modules
     */
    public void reduceModulePopulation() {
        int loopCounter;
        Module currModule;

        // Loop through the current Module list
        for (loopCounter = 0; loopCounter < currentModule.size(); loopCounter++) {
            currModule = (Module) currentModule.get(loopCounter);
            currModule.population--;
            // Module remove = currentModule.remove(loopCounter);
        }
    }
}
