package hydro.auto.ops.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Util {
    public static long currentTime() {
        TimeZone tz = TimeZone.getDefault();
        return System.currentTimeMillis() - tz.getRawOffset();
    }

    public static Date getGMT(long inputTime) {
        TimeZone tz = TimeZone.getDefault();
        long time = inputTime - tz.getRawOffset();
        Date d = new Date(time);
        return d;
    }

    public static Date getGMTTime() {
        Date d = new Date(currentTime());
        return d;
    }

    public static Date getCurrentTime(){
        Date d = new Date();
        return d;
    }

    public static Date addSeconds(Date date, Integer seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);
        return cal.getTime();
    }

    public static Date addMinutes(Date date, Integer minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static long getDifferentTimeInMilliseconds(Date d1, Date d2){
        long result = d1.getTime() - d2.getTime();
        result = Math.abs(result);
        return result;
    }
}
