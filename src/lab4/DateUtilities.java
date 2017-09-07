
package lab4;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jlombardo
 */
public class DateUtilities {
    public String getFormattedDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yy");
        return sdf.format(date);
    }
}
