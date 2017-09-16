package lab4;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * As with the previous lab you should focus on CLASS Encapsulation and the 
 * Single Responsibility Principle (SRP). However what makes this lab DIFFERENT
 * is that in a real program you would need more than just an Employee class 
 * and a EmployeeResportService class. Remember what you learned about OOA/D and 
 * finding the Conceptual Objects in the Problem Domain.
 * 
 * Pay special attention to the following issues:
 *    1. You will need additional classes to simulate the real world. To keep
 *       things simple you should think about adding two more classes. Think
 *       about how employees are hired, who does the hiring and who do those
 *       people work for. Think about the Nouns used in business with respect
 *       to hiring employees and commanding them to go through orientation.
 * 
 *    2. When adding these classes think about the Single Responsibility 
 *       Principle and Class Encapsulation -- hiding classes inside other
 *       classes, similar to what you did with the report service which was
 *       hidden inside the Employee class.
 * 
 *    3. For those who struggle with this final lab a solution is provided.
 *       However, you should not look at the solution unless absolutely 
 *       necessary if you are stuck. Try to do as much of this lab on your 
 *       own by doing critical thinking about the classes you need and the 
 *       responsibilities you are giving each class.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    private final String REQUIRED_MSG = " is mandatory ";
    private final String CRLF = "\n"; // carriage return line feed
    
    private String firstName;
    private String lastName;
    private String ssn;
    private String cubeId;
    private LocalDate orientationDate;
    /*
        Notice we force certain mandatory properties by using a custom
        constructor. But we use the setter method to peform validation.
    */
    public Employee(String firstName, String lastName, String ssn) {
        // Using setter method guarantees validation will be performed
        // Ignore the warning messages for now. Will be explained later
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }
    
    /* 
        This should be private because it is useful only to this class and then,
        only as a helper method to other methods. This is method hiding - a type 
        of encapsulation where we put frequently used code in one place for for
        easy editing later if necessary.
    */

    public final String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation. Throwing ane exception is the best
    // practice when validation fails. Don't do a System.out.println()
    // to display an error message -- not the job of this class!
    public final void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("first name" + REQUIRED_MSG);
        }
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("last name" + REQUIRED_MSG);
        }
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public final void setSsn(String ssn) {
        if(ssn == null || ssn.length() < 9 || ssn.length() > 11) {
            throw new IllegalArgumentException("ssn"  + REQUIRED_MSG 
                    + "and must be between 9 and 11 characters (if hyphens are used)");
        }
        this.ssn = ssn;
    }

    public final LocalDate getOrientationDate() {
        return orientationDate;
    }

     public final void setOrientationDate(LocalDate orientationDate) {
        if(orientationDate == null) {
            throw new IllegalArgumentException("Orientation date is required!");
        }
        this.orientationDate = orientationDate;
    }

}


