package automation.infrastructure.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestLoggerOld {
    private int number = 0;

    public String date (){
        SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss:SSS");
        return sdt.format(new Date());
    }

    public void log(String message){
        number ++;
        System.out.println(number + ") " + date() + " [" + Thread.currentThread().getName() + "]: " +  message);

    }
}
