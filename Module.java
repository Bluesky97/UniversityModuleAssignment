package dict415ipa1;

public class Module {
    // Data members
    int moduleId;
    String moduleName;
    int classLimit;
    int population;
    int semester;
    
    // Constructor
    public Module (int modId, String modName, int clsLimit, int sem) {
        moduleId = modId;
        moduleName = modName;
        classLimit = clsLimit;
        population = 0;
        semester = sem;
    } // end constructor
    
    /** Returns true when classLimit has been reached, not allowed to register a
     *  student for this module when class size is full
     * @return 
    */
    public boolean isFull(){
        // return (classLimit == population);
        if (classLimit == population) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Returns true when the module is offered in the semester sem
     * @param sem
     * @return 
     */
    public boolean isOfferedInSem(int sem) {
        // return (semester == sem);
        if (semester == sem){
            return true;
        } else {
            return false;
        }
    }
    
    /** The toString method returns a String that contains all the property values in the form of
     * <moduleID><moduleName><semester> <Number of students taking it> <class limit>
     * 
     * @return 
     */
    @Override
    public String toString(){
        String output;
        
        // Form the string
        output = moduleId + "\t" +
                 moduleName + "\t" +
                 semester + "\t" +
                 population + "\t" +
                 classLimit;
        
        return output;
    }
}
