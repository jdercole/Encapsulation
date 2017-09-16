
package lab4;

/**
 *
 * @author Jenna
 */
public class Company {
    private HrPerson hrPerson;
    
    public Company() {
        hrPerson = new HrPerson();
    }
    
    public void hireEmployee(String firstName, String lastName, String ssn) {
        hrPerson.hireEmployee(firstName, lastName, ssn);
    }

    public final HrPerson getHrPerson() {
        return hrPerson;
    }

    public final void setHrPerson(HrPerson hrPerson) {
        this.hrPerson = hrPerson;
    }
    
    
}
