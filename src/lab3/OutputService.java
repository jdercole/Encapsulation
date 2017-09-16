package lab3;

import javax.swing.JOptionPane;

/**
 *
 * @author jlombardo
 */
public class OutputService {
    
    public final void simpleOutput(String msg) {
        JOptionPane.showMessageDialog(null, msg);
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
