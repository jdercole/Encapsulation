
package lab4;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author jlombardo
 */
public class DateUtilities {
    public String getFormattedDate(LocalDate date) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy");
        return sdf.format(date);
    }
}
