package lab3;

/**
 *
 * @author jlombardo
 */
public class OutputService {
    
    public final void simpleOutput(String msg) {
        System.out.println(msg);
    }
    
    public final void completeOutput(String msg) {
        System.out.println(msg);
    }
    
    private Employee employee;
    
    public OutputService(Employee e) {
        employee = e;
    }
    
    public void outputHrInfomation() {
        System.out.println(employee.getLastName() + "completed orientation");
    }
}
