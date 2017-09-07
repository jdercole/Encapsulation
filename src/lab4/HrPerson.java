
package lab4;

import java.util.Date;

/**
 *
 * @author Jenna
 */
public class HrPerson { 
    // Use constants for numbers or Strings that are repeated 
    // (all are called 'magic numbers', which are evil). This makes editing
    // these values easier -- one place to do it.
    
    private final String REQUIRED_MSG = " is mandatory ";
    private final String CRLF = "\n"; // carriage return line feed
    
    private Employee employee;
    private Company company;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private EmployeeReportService reportService;
    private DateUtilities dateService;
    private String cubeId;
   
    
    public HrPerson(Employee e) {
        this.employee = e;
    }
        /*
        This method is public because it must be available to other classes in
        this project. Notice that it controls the order in which the helper methods
        are called. Order isn't always an issue, but here it obviously is, which
        may be an important requirement.
    */
    public void doFirstTimeOrientation(Employee e) {
        meetWithHrForBenefitAndSalryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle();
    }
    
        // The following methods may be public or private, depending on whether
    // they need to be called from other classes independently.

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    // doFirtTimeOrientation()
    private final void meetWithHrForBenefitAndSalryInfo() {
        metWithHr = true;
        reportService.addData(employee.getFirstName() + " " + employee.getLastName() + " met with Hr on "
            + dateService.getFormattedDate(employee.getOrientationDate()) + CRLF);
    }
    
     // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired. If that were true, this
    // method should not be public. It should only be available to this class
    // and should only be called as part of the larger task of:
    // doFirtTimeOrientation()
    private final void meetDepartmentStaff() {
        metDeptStaff = true;
        reportService.addData(employee.getFirstName() + " " + employee.getLastName() + " met with Dept. Staff on "
            + dateService.getFormattedDate(employee.getOrientationDate()) + CRLF);
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public final void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        reportService.addData(employee.getFirstName() + " " + employee.getLastName() + " reviewed Dept policies on "
            + dateService.getFormattedDate(employee.getOrientationDate()) + CRLF);
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
            throw new IllegalArgumentException("cube id" + REQUIRED_MSG);
        }
        this.cubeId = cubeId;
    }
    
        // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public final void moveIntoCubicle() {
        this.movedIn = true;
        reportService.addData(employee.getFirstName() + " " + employee.getLastName() + " moved into cubicle "
                + getCubeId() + " on " + dateService.getFormattedDate(employee.getOrientationDate()) + CRLF);
    }
    
    public final EmployeeReportService getReportService() {
        return reportService;
    }

    public final void setReportService(EmployeeReportService reportService) {
        this.reportService = reportService;
    }
}
