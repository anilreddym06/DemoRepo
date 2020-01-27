package framework;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class UtilityMethods {
	
	public static  String formatnumber(String number) {
		double dblnum=Double.parseDouble(number);
		int intnum=(int)dblnum;
		return String.valueOf(intnum);
	}
	public static String formatLongNumber(String number) {
		double dblnum=Double.parseDouble(number);
		long intnum=(long)dblnum;
		return String.valueOf(intnum);
		
	}
	public static String getCurrentTimeStamp() {
		Date dt=new Date();
		Calendar c=Calendar.getInstance();
		c.setTime(dt);
		int hour=c.get(Calendar.HOUR);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DAY_OF_MONTH);
		String timestamp =""+hour+minute+second+month+day;
		return timestamp;
	}
	
	public static String formatdate(Date dt, String dateformat) {
		SimpleDateFormat sdf=new SimpleDateFormat(dateformat);
		String formatedate=sdf.format(dt);
		return dateformat;
	}
	
	
	public static HashMap<String, String> getDateparts(Date dt){
		HashMap<String, String> dateparts=new HashMap<>();
		Calendar c=Calendar.getInstance();
		c.setTime(dt);
		dateparts.put("MONTH_NUMBER", String.valueOf(c.get(Calendar.MONTH)+1));
		dateparts.put("MONTH_NAME", c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		dateparts.put("YEAR", String.valueOf(c.get(Calendar.YEAR)));
		dateparts.put("DAY_NUMBER", String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
		dateparts.put("DAY_NAME", c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
		return dateparts;
	}

	
	

}
