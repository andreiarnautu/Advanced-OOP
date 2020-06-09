package Services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AuditHandler {
    public AuditHandler() {

    }

    public static void printAction(String actionName, String threadName) throws IOException {
        FileWriter writer = new FileWriter("data/audit.csv", true);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();

        writer.append(actionName + ",    "  + threadName + ",    " + dateFormat.format(new Date()) + "\n");
        writer.close();
    }
}
