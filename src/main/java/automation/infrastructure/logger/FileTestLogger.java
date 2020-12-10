package automation.infrastructure.logger;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTestLogger implements TestLogger {

    public String date (){
        SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss:SSS");
        return sdt.format(new Date());
    }

    @Override
    public void log(String message) {
        try {
            FileWriter fw = new FileWriter("log.txt", true);
            fw.write(date() + " [" + Thread.currentThread().getName() + "]: " + message + "\n");
            fw.close();
        }
        catch (Exception ex) {}
    }
}
