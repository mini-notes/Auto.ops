package hydro.auto.ops.utils;

import hydro.auto.ops.logger.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeFormat {
    private static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";

    public static String format(Date date) {
        String dateStr = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_FORMAT);
            dateStr = formatter.format(date);
        }
        catch (Exception ex) {
            Logger.addErrorLog(ex);
        }
        return dateStr;
    }

    public static String format(Date date, String format) {
        String dateStr = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            dateStr = formatter.format(date);
        }
        catch (Exception ex) {
            Logger.addErrorLog(ex);
        }
        return dateStr;
    }

    public static Date parse(String dateTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat(DEFAULT_FORMAT).parse(dateTime);
        } catch (ParseException ignored) {

        }
        return date;
    }

    public static Date parse(String dateTime, String format) {
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(dateTime);
        } catch (ParseException ignored) {

        }
        return date;
    }


    public static String convertTimezone(String dateTime, String format, TimeZone source, TimeZone target){
        String dateStr = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            df.setTimeZone(source);
            Date date = df.parse(dateTime);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            df.setTimeZone(target);
            dateStr = df.format(calendar.getTime());
        } catch (ParseException ignored){

        }
        return dateStr;
    }
}
