
package lab4;

/**
 *
 * @author Jenna
 */
public class Company {
    private HrPerson hrPerson;
    private Employee employee;
    
    public Company(HrPerson hrPerson) {
        this.hrPerson = hrPerson;
    }
    
    public void hireEmployee(Employee e) {
        hrPerson.doFirstTimeOrientation(e);
    }
}
