package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;

    public Employee(String firstName, String lastName, String ssn) {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }
    
    public void receiveOrientation(Employee e) throws NullPointerException {
        meetWithHrForBenefitAndSalaryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        try {
            moveIntoCubicle(e.getCubeId());
        } catch (NullPointerException npe) {
            throw new NullPointerException(npe.getMessage());
        }
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalaryInfo() {
        metWithHr = true;      
        doOutput(firstName, lastName, " met with HR on ");
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.:
    private void meetDepartmentStaff() {
        metDeptStaff = true;       
        doOutput(firstName, lastName, " met with department staff on ");
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        doOutput(firstName, lastName, " reviewed department policies on ");   
    }
    
    private void doOutput(String firstName, String lastName, String msg) {
        System.out.println(firstName + " " + lastName + " " + msg + " " + formatDate());
    }
    
    private String formatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(orientationDate);   
        return fmtDate;
    }

    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        this.cubeId = cubeId;
        this.movedIn = true;       
        doOutput(firstName, lastName, " moved into cubicle " + cubeId + " on ");
    }

    public final String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.
    
    public final void setFirstName(String firstName) {
       if ((firstName.length() >= 2) && (firstName.length() <= 30) && (firstName.contains("/^[A-z]+$/"))) {
            this.firstName = firstName;
       } else {
           throw new IllegalArgumentException("First name in invalid format!");
       }
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
       if ((lastName.length() >= 2) && (lastName.length() <= 30) && (lastName.contains("/^[A-z]+$/"))) {
            this.lastName = lastName;
        } else {
           throw new IllegalArgumentException("Last name in invalid format!");
       }
    }

    public final String getSsn() {
        return ssn;
    }

    public final void setSsn(String ssn) {
        if(isSsnValid(ssn)) {
            this.ssn = ssn;
        } else {
           throw new IllegalArgumentException("SSN in invalid format!");
       }
    }
    
    public boolean isSsnValid(String ssn){
        boolean isValid = false;
        String expression = "^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$";
        CharSequence inputStr = ssn;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

    public final boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    public final void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public final boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    public final void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public final boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public final void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public final boolean isMovedIn() {
        return movedIn;
    }

    public final void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public final String getCubeId() {
        return cubeId;
    }
    
    public final void setCubeId(String cubeId) {
        if(cubeId == null || cubeId.isEmpty()) {
            throw new IllegalArgumentException("CubeID in invalid format!");
        }
        this.cubeId = cubeId;
    }

    public final Date getOrientationDate() {
        return orientationDate;
    }

    public final void setOrientationDate(Date orientationDate) {
        if(orientationDate == null) {
            throw new IllegalArgumentException("Orientation date required!");
        }
        this.orientationDate = orientationDate;
    }}
