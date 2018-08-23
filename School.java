package dict415ipa1;

import java.util.ArrayList;

public class School {

    // Data member
    String schoolName;
    ArrayList<Module> moduleList;
    ArrayList<Student> studentList;

    // Constructor
    public School(String schName) {
        schoolName = schName;
        moduleList = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    // Member functions
    /**
     * This method accepts a Student object and adds it to the studentList.
     *
     * @param std
     */
    public void addStudent(Student std) {
        studentList.add(std);
    }

    /**
     * This method accepts a Module object and adds it to the moduleList
     * collection.
     *
     * @param mod
     */
    public void addModule(Module mod) {
        moduleList.add(mod);
    }

    /**
     * This method accepts an int representing the studentID and searches for
     * the student within the collection of students. It returns the student if
     * found, otherwise it returns a null value.
     *
     * @param stdId
     * @return
     */
    public Student searchStudent(int stdId) {
        int loopCounter;
        Student currStudent;

        // loop through the student list 
        for (loopCounter = 0; loopCounter < studentList.size(); loopCounter++) {
            currStudent = (Student) studentList.get(loopCounter);

            // check if this is the student we want
            if (currStudent.studentId == stdId) { // found the student
                return currStudent;               // return the student
            }
        }

        return null;    // return NULL if cannot find the student
    }

    /**
     * This method accepts a int representing the studentID and searches for the
     * student within the studentList collection. It returns true when the
     * student is found, and removed from the studentList. Otherwise it returns
     * false.
     *
     * @param stdId
     * @return
     */
    public boolean removeStudent(int stdId) {
        Student currStudent;

        currStudent = searchStudent(stdId);

        if (currStudent != null) {
            studentList.remove(currStudent);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method accepts an int representing the moduleID and searches for the
     * module within the collection of modules. It returns the module if found,
     * otherwise it returns a null value.
     *
     * @param modId
     * @return
     */
    public Module searchModule(int modId) {
        int loopCounter;
        Module currModule;

        // loop through the module list 
        for (loopCounter = 0; loopCounter < moduleList.size(); loopCounter++) {
            currModule = (Module) moduleList.get(loopCounter);

            // check if this is the module we want
            if (currModule.moduleId == modId) { // found the module
                return currModule;               // return the module
            }
        }

        return null;    // return NULL if cannot find the student
    }

    /**
     * This method accepts a int representing the moduleID and searches for the
     * module within the moduleList collection. It returns true when the module
     * is found, and removed from the moduleList. Otherwise it returns false.
     *
     * @param modId
     * @return
     */
    public boolean removeModule(int modId) {
        Module currModule;

        currModule = searchModule(modId);

        if (currModule != null) {
            moduleList.remove(currModule);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method goes through the collection of the modules and displays all
     * the information of each module in the moduleList.
     */
    public void listModules() {
        int loopCounter;
        int currModId;
        Module currModule;

        System.out.println("\nList of modules: ");
        for (loopCounter = 0; loopCounter < moduleList.size(); loopCounter++) {
            currModule = (Module) moduleList.get(loopCounter);
            System.out.println(currModule.toString());
        }
        System.out.println(loopCounter + " module(s) listed.");
        System.out.println("End of module list.\n");
    }

    /**
     * This method goes through the collection of the students and displays all
     * the information of each student in the studentList.
     */
    public void listStudents() {
        int loopCounter;
        Student currStudent;

        System.out.println("List of students: ");
        // Loop through the school's collection list of students
        for (loopCounter = 0; loopCounter < studentList.size(); loopCounter++) {
            currStudent = (Student) studentList.get(loopCounter);
            System.out.println(currStudent.toString());
        }
        System.out.println("End of student list.\n");
    }

    /**
     * classFull - accepts a moduleID (int) and checks if the classLimit for the
     * module has been reached.
     *
     * @param modId
     * @return
     */
    public boolean classFull(int modId) {
        Module currModule;

        // Search the module
        currModule = searchModule(modId);

        // Check if the module is found
        if (currModule != null) { // Module is found
            return (currModule.isFull());
        } else { // Module is not found
            System.out.println("Module " + modId + " is not found!\n");
            return false;
        }
    } // end of classFull

    /**
     * isOfferedInSem - accepts a moduleID (int) and a sem (int). It checks if
     * the module is offered in the semester sem.
     *
     * @param modId
     * @param sem
     * @return
     */
    public boolean isOfferedInSem(int modId, int sem) {
        Module currModule;

        // Seach the module
        currModule = searchModule(modId);

        // Check if the module is found
        if (currModule != null) { // Module is found
            return (currModule.isOfferedInSem(sem));
        } else { // Module is not found
            System.out.println("Module " + modId + " is not found!\n");
            return false;
        } // end if
    } // End of isOfferedInSem

    /**
     * ListModulesTaken – This method accepts a studentID (int) and display a
     * list of modules taken by the student in the format shown below.
     *
     * @param stuId
     */
    public void listModuleTaken(int stuId) {
        Student currStudent;

        // Search the school's student collection list for the specified student
        currStudent = searchStudent(stuId);

        // Check if the student is found
        if (currStudent != null) { // Student is found
            System.out.println(currStudent.toString());
            currStudent.listModuleTaken();
        } else {
            System.out.println("Student " + stuId + " is not found!");
        }

    } // End of listModuleTaken

    /**
     * registerModule – This method accepts a studentID (int), a moduleID (int)
     * and a semester (int). Returns true when the module is added to the module
     * list in the Student object. Otherwise it returns false.
     *
     * @param stuId
     * @param modId
     * @param sem
     * @return
     */
    public boolean registerModule(int stuId, int modId, int sem) {
        Student currStudent;
        Module currModule;
        boolean isOfferedInSemester;
        boolean isFull;
        boolean isNotTakenYet;

        // Search the school's student list for the student
        currStudent = searchStudent(stuId);
        // Check if Student is found 
        if (currStudent == null) { // Student is not found
            System.out.println("Student " + stuId
                    + " is not found.");
        }

        // Search the school's module list for the module
        currModule = searchModule(modId);
        // Check if module is found
        if (currModule == null) { // Module is not found
            System.out.println("Module " + modId
                    + " is not found.");
        }

        // Check if module is offered in the specified semester
        isOfferedInSemester = currModule.isOfferedInSem(sem);
        // Check if module is offered in the current semester
        if (isOfferedInSemester == false) {
            System.out.println("Module " + modId
                    + " is not offered in semester " + sem);
        }

        // Check if class is not full
        isFull = currModule.isFull();
        // Check if class is full
        if (isFull == true) {
            System.out.println("Module " + modId
                    + " is full.");
        }

        // Check if student is already taking the specified module
        isNotTakenYet = currStudent.isAlreadyTaken(modId);
        // Check if student is already taking the module
        if (isNotTakenYet == true) {
            System.out.println("Student " + stuId
                    + " has already taken the module "
                    + modId);
        }

        /*
         // For testing only
         System.out.println("currStudent: " + currStudent.toString());
         System.out.println("currModule: " + currModule.toString());
         System.out.println("isOfferedInSemester: " + isOfferedInSemester);
         System.out.println("isFull: " + isFull);
         System.out.println("isNotTakenYet: " + isNotTakenYet);
         */
        if (isOfferedInSemester && !isFull && !isNotTakenYet) { // can add
            currStudent.currentModule.add(currModule);
            currModule.population++;
            System.out.println("Module " + currModule.moduleId
                    + ", " + currModule.moduleName + " has been added to "
                    + "student " + currStudent.toString() + ".");
            return true;
        } else { // cannot add
            System.out.println("Module is not added successfully.");
            return false;
        }
    }
}
