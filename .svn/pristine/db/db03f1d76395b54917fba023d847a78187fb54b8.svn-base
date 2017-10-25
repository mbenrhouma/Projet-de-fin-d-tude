package com.cynapsys.utils;

import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@ManagedBean(name = "utilities")
public class Utilities<T> {
	private static String DATE_FORMAT_FR = "dd/MM/yyyy";
	private static String DATE_FORMAT_US = "yyyy-MM-dd";
	public static ExternalContext ec = null;
	public static FacesContext fc = null;
	private WebApplicationContext ctx = null;
	public final static String FR = "FR";
	public final static String GC = "GC";
	static String stx = FR;
	public static int nombrethread = 0;
	public static String traitementEncours;

	public static boolean oneTreatment;

	public static Integer parseInteger(String s) {
		try {
			int value = Integer.parseInt(s);
			return new Integer(value);
		} catch (Exception ex) {
			return null;
		}
	}

	public static Long parseLong(String s) {
		try {
			long value = Long.parseLong(s);
			return new Long(value);
		} catch (Exception ex) {
			return null;
		}
	}

	public static int parseInt(String s) {
		try {
			int value = Integer.parseInt(s);
			return value;
		} catch (Exception ex) {
			return 0;
		}
	}

	
	public static String customFormatDate(Date date) {
		   if (date != null) {
		       DateFormat format = new SimpleDateFormat(datePattern());
		       return format.format(date);
		    }
		   return "";
		}
	
	 public static String datePattern() {
		   return "dd/MM/yyyy";
		 }
	
	public static SimpleDateFormat getDateFormatter(Locale locale) {
		if (locale.toString() == "fr")
			return new SimpleDateFormat(DATE_FORMAT_FR);
		else if (locale == Locale.US)
			return new SimpleDateFormat(DATE_FORMAT_US);

		else
			return new SimpleDateFormat(DATE_FORMAT_FR);
	}

	public static int parseInt(String s, int intDefaut) {
		try {
			int value = Integer.parseInt(s);
			return value;
		} catch (Exception ex) {
			return intDefaut;
		}
	}

	public static double parseDouble(String s) {
		try {
			if (s != null)
				return Double.parseDouble(s);
			else
				return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	public static Double parseObjDouble(String s) {
		try {
			return new Double(s);
		} catch (Exception e) {
			return new Double("0.00");
		}
	}

	public static double multiplie(String s1, String s2) {
		return (parseDouble(s1) * parseDouble(s2));
	}

	public static boolean equalsDouble(double value1, double value2) {
		double value = value1 - value2;

		if (value < 0) {
			value = value * -1;
		}

		return (value) < 0.0001;
	}

	public static int compareDouble(double value1, double value2) {
		double value = value1 - value2;

		if (value > 0.0001) {
			return 1;
		} else if (-value > 0.0001) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String prepareFiltreLike(String value) {
		return StringUtils.replaceApostrophes(value.toUpperCase().trim());
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param codeJournal
	 *            DOCUMENT ME!
	 * @param numJournal
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String getNumeroJournal(String codeJournal, Integer numJournal) {
		int longeur = 6;
		String zeros = "";

		for (int i = 0; i < (longeur - numJournal.toString().length()); i++) {
			zeros += "0";
		}

		return codeJournal + zeros + numJournal;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isNotNull(Float value) {
		return (value != null) && (value.floatValue() > 0);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isDoubleNotNull(Double value) {
		return (value != null) && (value.doubleValue() > 0);
	}

	public static boolean isNotNull(Double value) {
		return (value != null) && (value.doubleValue() != 0);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static Double testNull(Double value) {
		if (value == null) {
			return new Double(0);
		}

		return value;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isdoubleNull(double value) {
		return value == 0;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isValidInteger(Integer value) {
		//
		return (value != null) && (value.intValue() != 0);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isParseableToInt(String value) {
		try {
			Integer integ = new Integer(value);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param value
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isValidLong(Long value) {
		return (value != null) && (value.longValue() != 0);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param entier
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String addZero(int entier) {
		try {
			if (entier < 10) {
				return "0" + entier;
			} else {
				return "" + entier;
			}
		} catch (Exception e) {
			return "00";
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String calendarToStringJJMMAAAA(Date date) {
		String sdate = "";
		GregorianCalendar calendarDate = new GregorianCalendar();

		if (date != null) {
			calendarDate.setTime(date);

			if (calendarDate != null) {
				// int h = calendarDate.get(Calendar.HOUR_OF_DAY);
				int m = calendarDate.get(Calendar.MONTH) + 1;
				int d = calendarDate.get(Calendar.DAY_OF_MONTH);
				int y = calendarDate.get(Calendar.YEAR);
				// int hour = calendarDate.get(Calendar.HOUR_OF_DAY);
				// int minute = calendarDate.get(Calendar.MINUTE);

				sdate += (addZero(d) + "/" + addZero(m) + "/" + y);
			}
		}

		return sdate;
	}

	public static String calendarToStringJJMMA(Date date) {
		String sdate = "";
		GregorianCalendar calendarDate = new GregorianCalendar();

		if (date != null) {
			calendarDate.setTime(date);

			if (calendarDate != null) {
				// int h = calendarDate.get(Calendar.HOUR_OF_DAY);
				int m = calendarDate.get(Calendar.MONTH) + 1;
				int d = calendarDate.get(Calendar.DAY_OF_MONTH);
				int y = calendarDate.get(Calendar.YEAR);
				// int hour = calendarDate.get(Calendar.HOUR_OF_DAY);
				// int minute = calendarDate.get(Calendar.MINUTE);

				sdate += (addZero(d) + addZero(m) + String.valueOf(y)
						.substring(3));
			}
		}

		return sdate;
	}

	public static String getStringJJMMAAAFromDate(Date date, String separator) {
		StringBuilder sdate = new StringBuilder();
		GregorianCalendar calendarDate = new GregorianCalendar();

		if (date != null) {
			calendarDate.setTime(date);

			if (calendarDate != null) {
				// int h = calendarDate.get(Calendar.HOUR_OF_DAY);
				int m = calendarDate.get(Calendar.MONTH) + 1;
				int d = calendarDate.get(Calendar.DAY_OF_MONTH);
				int y = calendarDate.get(Calendar.YEAR);
				// int hour = calendarDate.get(Calendar.HOUR_OF_DAY);
				// int minute = calendarDate.get(Calendar.MINUTE);

				sdate.append(addZero(d));
				sdate.append(separator);
				sdate.append(addZero(m));
				sdate.append(separator);
				sdate.append(y);
			}
		}

		return sdate.toString();
	}

	public static String getStringAAAAMMJJFromDate(Date date, String separator) {
		StringBuilder sdate = new StringBuilder();
		GregorianCalendar calendarDate = new GregorianCalendar();
		if (date != null) {
			calendarDate.setTime(date);
			if (calendarDate != null) {
				// int h = calendarDate.get(Calendar.HOUR_OF_DAY);
				int m = calendarDate.get(Calendar.MONTH) + 1;
				int d = calendarDate.get(Calendar.DAY_OF_MONTH);
				int y = calendarDate.get(Calendar.YEAR);
				// int hour = calendarDate.get(Calendar.HOUR_OF_DAY);
				// int minute = calendarDate.get(Calendar.MINUTE);
				sdate.append(y);
				sdate.append(separator);
				sdate.append(addZero(m));
				sdate.append(separator);
				sdate.append(addZero(d));
			}
		}
		return sdate.toString();
	}

	public static boolean compareToTimesDates(Date date1, Date date2) {
		try {
			GregorianCalendar calendarDate = new GregorianCalendar();
			GregorianCalendar calendarDate2 = new GregorianCalendar();

			calendarDate.setTime(date1);
			int m = calendarDate.get(Calendar.MONTH) + 1;
			int d = calendarDate.get(Calendar.DAY_OF_MONTH);
			int y = calendarDate.get(Calendar.YEAR);

			calendarDate2.setTime(date2);

			int m2 = calendarDate2.get(Calendar.MONTH) + 1;
			int d2 = calendarDate2.get(Calendar.DAY_OF_MONTH);
			int y2 = calendarDate2.get(Calendar.YEAR);

			return (m == m2 && d == d2 && y == y2);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static String calendarToDateAndTime(Date date) {
		String sdate = "";
		GregorianCalendar calendarDate = new GregorianCalendar();

		if (date != null) {
			calendarDate.setTime(date);

			if (calendarDate != null) {
				int sec = calendarDate.get(Calendar.SECOND);
				int m = calendarDate.get(Calendar.MONTH) + 1;
				int d = calendarDate.get(Calendar.DAY_OF_MONTH);
				int y = calendarDate.get(Calendar.YEAR);
				int hour = calendarDate.get(Calendar.HOUR_OF_DAY);
				int min = calendarDate.get(Calendar.MINUTE);

				sdate += (addZero(d) + "/" + addZero(m) + "/" + y + " " + hour
						+ ":" + min + ":" + sec);
			}
		}

		return sdate;
	}

	public static String calendarToStringAAAAMMJJ(Date date) {
		String sdate = "";
		GregorianCalendar calendarDate = new GregorianCalendar();

		if (date != null) {
			calendarDate.setTime(date);

			if (calendarDate != null) {
				// int h = calendarDate.get(Calendar.HOUR_OF_DAY);
				int m = calendarDate.get(Calendar.MONTH) + 1;
				int d = calendarDate.get(Calendar.DAY_OF_MONTH);
				int y = calendarDate.get(Calendar.YEAR);
				// int hour = calendarDate.get(Calendar.HOUR_OF_DAY);
				// int minute = calendarDate.get(Calendar.MINUTE);

				sdate += (y + "-" + addZero(m) + "-" + addZero(d));
			}
		}

		return sdate;
	}

	public static String calendarToFormatedString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(date);
	}

	public static void createDirectory(String outputDirectory) {
		File rep = new File(outputDirectory);
		if (!rep.exists()) {
			rep.mkdirs();
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getJourDuMois(Date date) {
		Calendar dCal = Calendar.getInstance();
		dCal.setTime(date);

		return dCal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String getJour(Date date) {
		Calendar dCal = Calendar.getInstance();
		Calendar dCalImp = Calendar.getInstance();
		dCalImp.setTime(date);
		dCal.set(Calendar.YEAR, dCalImp.get(Calendar.YEAR));
		dCal.set(Calendar.MONTH, dCalImp.get(Calendar.MONTH));
		dCal.set(Calendar.DAY_OF_MONTH, dCalImp.get(Calendar.DAY_OF_MONTH));

		// Logger logger = Logger.getLogger(Utilities.class);

		// logger.info( dCal.getFirstDayOfWeek());
		switch (dCal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.MONDAY:
			return "lundi";

		case Calendar.TUESDAY:
			return "mardi";

		case Calendar.WEDNESDAY:
			return "mercredi";

		case Calendar.THURSDAY:
			return "jeudi";

		case Calendar.FRIDAY:
			return "vendredi";

		case Calendar.SATURDAY:
			return "samedi";

		case Calendar.SUNDAY:
			return "dimanche";

		default:
			return "";
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param mois
	 *            DOCUMENT ME!
	 * @param annee
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getMoisSuivant(int mois, int annee) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, mois);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.YEAR, annee);
		cal.add(Calendar.MONTH, +1);

		return cal.get(Calendar.MONTH);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static Integer getNumeroMoisSuivant(Date date) {
		Calendar dCal = Calendar.getInstance();
		dCal.setTime(date);
		dCal.add(Calendar.MONTH, +1);

		return new Integer(dCal.get(Calendar.MONTH));
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String getMois(Date date) {
		Calendar dCal = Calendar.getInstance();
		dCal.setTime(date);

		switch (dCal.get(Calendar.MONTH)) {
		case Calendar.JANUARY:
			return "janvier";

		case Calendar.FEBRUARY:
			return "fevrier";

		case Calendar.MARCH:
			return "mars";

		case Calendar.APRIL:
			return "avril";

		case Calendar.MAY:
			return "mai";

		case Calendar.JUNE:
			return "juin";

		case Calendar.JULY:
			return "juillet";

		case Calendar.AUGUST:
			return "ao�t";

		case Calendar.SEPTEMBER:
			return "septembre";

		case Calendar.OCTOBER:
			return "octobre";

		case Calendar.NOVEMBER:
			return "novembre";

		case Calendar.DECEMBER:
			return "decembre";

		default:
			return "";
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getNumeroMois(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getNumeroMoisCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal.get(Calendar.MONTH);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getNumeroDernierJourMois(Date date) {
		/* le jour devient le dernier jour du mois courant */
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, +1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);

		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int getAnnee(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal.get(Calendar.YEAR);
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param date
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String getDateComplete(Date date) {
		Calendar dCal = Calendar.getInstance();
		dCal.setTime(date);

		StringBuffer sb = new StringBuffer();
		sb.append(StringUtils.initCap(getJour(date)));
		sb.append(" ");
		sb.append(dCal.get(Calendar.DAY_OF_MONTH));
		sb.append(" ");
		sb.append(getMois(date));
		sb.append(" ");
		sb.append(dCal.get(Calendar.YEAR));

		return sb.toString();
	}

	public static String getDateCompletewithoutJour(Date date) {
		Calendar dCal = Calendar.getInstance();
		dCal.setTime(date);

		StringBuffer sb = new StringBuffer();
		sb.append(dCal.get(Calendar.DAY_OF_MONTH));
		sb.append(" ");
		sb.append(getMois(date));
		sb.append(" ");
		sb.append(dCal.get(Calendar.YEAR));

		return sb.toString();
	}

	public static Date getTodayDate() {
		return Utilities.createCalendarWithDate(new Date()).getTime();
	}

	public static Date getDateDuJour() {
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	public static Integer getDifferenceInDays(Date date1, Date date2) {
		Calendar d1 = Calendar.getInstance();
		Calendar d2 = Calendar.getInstance();
		d1.setTime(date1);
		d2.setTime(date2);
		Integer diff = null;
		if (d1 != null && d2 != null) {
			long timeDiff = Math.abs(d1.getTimeInMillis()
					- d2.getTimeInMillis());

			long remainder = timeDiff % 86400000;
			Long nbJour = (timeDiff - remainder) / 86400000;
			diff = nbJour.intValue();
		}
		return diff;
	}

	public static Integer getDifferenceInMonths(Date dateLast, Date dateTo) {
		Integer diffInMonths = null;
		if (dateLast != null && dateTo != null && !dateLast.after(dateTo)) {
			Calendar dl = Calendar.getInstance();
			dl.setTime(dateLast);
			Calendar dt = Calendar.getInstance();
			dt.setTime(dateTo);
			diffInMonths = -1;
			while (!dl.after(dt)) {
				dl.add(Calendar.MONTH, 1);
				diffInMonths++;
			}
		}
		return diffInMonths;
	}

	public static Calendar createCalendarWithDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	public static boolean equalsDates(Date date1, Date date2) {
		if (date1 == null && date2 == null)
			return true;
		if ((date1 == null && date2 != null)
				|| (date1 != null && date2 == null))
			return false;
		Calendar cal1 = createCalendarWithDate(date1);
		Calendar cal2 = createCalendarWithDate(date2);
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
				&& cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE);
	}

	public static boolean equalsMonthAndYear(Date date1, Date date2) {
		if (date1 == null && date2 == null)
			return true;
		if ((date1 == null && date2 != null)
				|| (date1 != null && date2 == null))
			return false;
		Calendar cal1 = createCalendarWithDate(date1);
		Calendar cal2 = createCalendarWithDate(date2);
		return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
	}

	public static boolean isAfterToday(Date date) {
		boolean res = false;

		// System.out.println("----------date du jour :: "+getDateDuJour());
		if (date == null || (date.compareTo(getDateDuJour()) > 0))
			res = true;

		return res;
	}

	public static boolean isBefore(Date dateFrom, Date dateTo) {

		return (dateTo == null || dateFrom == null || (dateTo.after(dateFrom)));
	}

	public static boolean isPeriodValid(Date startDate, Date endDate) {
		boolean res = false;
		if (startDate == null || endDate == null)
			res = true;
		else if (startDate.compareTo(endDate) < 0)
			res = true;

		return res;
	}

	public static boolean isPeriodValidEq(Date startDate, Date endDate) {
		boolean res = false;
		if (startDate == null || endDate == null)
			res = true;
		else if (startDate.compareTo(endDate) <= 0)
			res = true;

		return res;
	}

	public static boolean isValidIntergerSuperiorOrEqualOne(Object i) {
		if (i == null) {
			return true;
			/*
			 * Dans le cas ou l'�l�ment requis, comme "range" n'est pas
			 * obligatoire.
			 */
		} else {
			if (i instanceof Integer) {
				if ((Integer) i >= 1) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param list
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isValidCollection(Collection list) {
		boolean isValid = false;

		try {
			if ((list != null) && !list.isEmpty()) {
				isValid = true;
			}
		} catch (Exception e) {
			return false;
		}

		return isValid;
	}

	/**
	 * Convert a byte array to a String of hexadecimal digits and return it.
	 * <p>
	 * <strong>WARNING</strong>: This method is not part of TokenProcessor's
	 * public API. It's provided for backward compatibility only.
	 * </p>
	 * 
	 * @param buffer
	 *            The byte array to be converted
	 * @return DOCUMENT ME!
	 */
	public static String toHex(byte[] buffer) {
		StringBuffer sb = new StringBuffer();
		String s = null;

		for (int i = 0; i < buffer.length; i++) {
			s = Integer.toHexString((int) buffer[i] & 0xff);

			if (s.length() < 2) {
				sb.append('0');
			}

			sb.append(s);
		}

		return sb.toString();
	}

	public static Integer calculQuantiteSerieHexa(String numDebut, String numFin) {

		int numD = Integer.parseInt(numDebut, 16);
		int numF = Integer.parseInt(numFin, 16);
		if (numF >= numD)
			return new Integer(numF - numD + 1);
		else {
			Logger log = Logger.getLogger(Utilities.class);
			log.error("******** erreur calculQuantiteSerieHexa : s�rie invalide **********");
			return null;
		}

	}

	/**
	 * Retourne une String en hexa par rapport � une autre pass�e en parametre �
	 * laquelle on souhaite ajouter ou soustraire un nombre (typiquement pour
	 * recuperer la valeur pr�c�dente ou suivante)
	 * 
	 * @param stringHexa
	 * @param modificateur
	 *            (n�gatif pour une soustraction)
	 * @return nouvelle valeur hexadecimale
	 */
	public static String addStringHexa(String stringHexa, int modificateur) {

		try {
			int num = Integer.parseInt(stringHexa, 16);
			num = num + modificateur;
			// Mantis 1497 lignes mises en commentaires suite � cette anomalie
			// int longeur = stringHexa.length();
			String newHexa = (Integer.toString(num, 16)).toUpperCase();
			// 1497
			/*
			 * for (int i = 0; i < (longeur - newHexa.length()); i++) { newHexa
			 * = "0"+ newHexa; }
			 */
			return newHexa;
		} catch (NumberFormatException e) {
			Logger log = Logger.getLogger(Utilities.class);
			log.error("******** erreur addStringHexa : s�rie invalide **********");
			return stringHexa;
		}
	}

	public static String formatDouble(double number) {
		return new DecimalFormat("0.00").format(number);
	}

	/**
	 * Check if the string str is null or empty
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if ((str == null) || (str.equals("null")) || (str.length() == 0))
			return true;
		else
			return false;
	}

	/**
	 * Append spaces in the string
	 * 
	 * @param string
	 * @param longueur
	 * @param rightToLeft
	 * @return
	 */
	public static String completeBlank(String string, int longueur,
			boolean rightToLeft) {
		String result = null;

		if (string != null) {
			int size = string.length();
			int nbBlankToAdd = longueur - size;
			String s_blank = "";
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < nbBlankToAdd; i++) {
				buf.append(" ");
			}
			if (buf.length() > 0)
				s_blank = buf.toString();

			if (!rightToLeft)
				result = string.concat(s_blank).substring(0, longueur);
			else
				result = s_blank.concat(string).substring(0, longueur);
		} else {
			// int size = string.length();
			int nbBlankToAdd = longueur;
			String s_blank = "";
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < nbBlankToAdd; i++) {
				buf.append(" ");
			}
			if (buf.length() > 0)
				s_blank = buf.toString();
			result = s_blank;
		}

		return result;
	}

	/**
	 * Append zeros to the string
	 * 
	 * @param string
	 * @param longueur
	 * @param rightToLeft
	 * @return
	 */
	public static String completeZero(String string, int length,
			boolean rightToLeft) {
		String result = null;

		if (string != null) {
			int size = string.length();
			int nbZeroToAdd = length - size;
			String s_Zero = "";
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < nbZeroToAdd; i++) {
				buf.append("0");
			}
			if (buf.length() > 0)
				s_Zero = buf.toString();

			if (!rightToLeft)
				result = string.concat(s_Zero).substring(0, length);
			else
				result = s_Zero.concat(string).substring(0, length);
		} else {
			// int size = string.length();
			int nbZeroToAdd = length;
			String s_Zero = "";
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < nbZeroToAdd; i++) {
				buf.append("0");
			}
			if (buf.length() > 0)
				s_Zero = buf.toString();
			result = s_Zero;
		}

		return result;
	}

	public static boolean isDigitString(String string) {
		if (string == null || string.length() == 0)
			return false;
		boolean check = true;
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i)))
				check = false;
			break;
		}
		return check;
	}

	public static boolean isAlphaNumericString(String string) {
		if (string == null || string.length() == 0)
			return false;
		boolean check = true;
		for (int i = 0; i < string.length(); i++) {
			Character ch = string.charAt(i);
			if (!Character.isDigit(ch)
					&& !(Character.getNumericValue(Character.toUpperCase(string
							.charAt(i))) >= Character.getNumericValue('A') && Character
							.getNumericValue(Character.toUpperCase(string
									.charAt(i))) <= Character
							.getNumericValue('Z'))) {
				check = false;
				break;
			}
		}
		return check;
	}

	public static String replaceAccountNumberCharacters(String accountNumber) {
		String s = new String(accountNumber.toUpperCase());
		int v = 0;
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (Character.isLetter(ch)) {
				v = ((Character.getNumericValue(ch) - Character
						.getNumericValue('A')) % 9) + 1;
				if (Character.getNumericValue(ch) >= Character
						.getNumericValue('S'))
					v++;
				s = s.substring(0, i) + v + s.substring(i + 1, s.length());
			}
		}
		return s;
	}

	public static int calculateCheckDigit(int bank, int agency,
			int accountNumberFirstPart, int accountNumberSecondPart) {
		return 97 - ((89 * bank + 15 * agency + 76 * accountNumberFirstPart + 3 * accountNumberSecondPart) % 97);
	}

	/**
	 * Generate a date from strings
	 * 
	 * @param jour
	 * @param mois
	 * @param annee
	 * @return
	 */
	public static Calendar constructCalendar(String jour, String mois,
			String annee) {
		Calendar calendar = null;
		try {
			if (!isNull(jour) && !isNull(mois) && !isNull(annee)) {
				calendar = Calendar.getInstance();
				calendar.set(new Integer(annee).intValue(),
						new Integer(mois).intValue(),
						new Integer(jour).intValue(), 0, 0, 0);
			}
			return calendar;
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static Integer getNextToLastYear() {
		return Calendar.getInstance().get(Calendar.YEAR) - 1;
	}

	/**
	 * Teste si la chaine en entr�e est un num�rique
	 * 
	 * @return
	 * @param string
	 */
	public static boolean isNumeric(String string) {
		try {
			new Double(string);
			return true;
		} catch (Exception e) {
			e = null;
			return false;
		}
	}

	/**
	 * Teste si la chaine en entr�e est un num�rique
	 * 
	 * @param string
	 * @return boolean
	 */
	public static boolean isInteger(String string) {
		try {
			new Integer(string);
			return true;
		} catch (Exception e) {
			e = null;
			return false;
		}
	}

	/**
	 * Renvoie la partie enti�re d'une chaine
	 * 
	 * @param string
	 * @param separateur
	 * @return Integer
	 */
	public static Integer getIntegerPartValue(String string, String separateur) {
		Integer res = null;
		String str = null;
		if (string != null && separateur != null) {
			if (string.indexOf(separateur) != -1)
				str = string.substring(string.indexOf(separateur) + 1);
			if (isInteger(str))
				res = new Integer(str);
		}
		return res;
	}

	/**
	 * Transforme une chaine de caract�res en bool�en. chaine "true" --> booleen
	 * true chaine "false" --> booleen false
	 */
	public static boolean getBooleanValue(String chaine) {
		boolean result = false;
		if (!isNull(chaine)) {
			if (chaine.toUpperCase().equals("TRUE")) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Author PB - Retourne la premi�re lettre d'une String en la mettant en
	 * majuscule si addPoint est � true alors on rajoute un point derri�re
	 */
	public static String getFisrtLetterMAJ(String str, boolean addPoint) {
		String firstLetter = "";
		if (str != null && str.length() >= 1) {
			firstLetter = str.substring(0, 1).toUpperCase();
			if (addPoint)
				firstLetter = firstLetter + ".";
		}
		return firstLetter;
	}

	public static String toJoker(String s) {
		String sJoker = s;
		if (!isNull(s)) {
			sJoker = s.replace('*', '%');
			sJoker = sJoker.replace('?', '_');
		} else {
			sJoker = "%";
		}
		return sJoker;
	}

	public static String formatNoTelephone(String s) {
		if (s != null && parseLong(s) != null && s.length() == 10) {
			StringBuffer st = new StringBuffer();
			st.append(s.substring(0, 2));
			st.append(" ");
			st.append(s.substring(2, 4));
			st.append(" ");
			st.append(s.substring(4, 6));
			st.append(" ");
			st.append(s.substring(6, 8));
			st.append(" ");
			st.append(s.substring(8, 10));
			s = st.toString();
		}
		return s;
	}

	// ***** FPJ ***** : fonction de formatage de chaines de caract�res
	public static String StrFormat(String chaineDepart, boolean AligneADroite,
			char caractereDeRemplissage, int longeurDesiree) {
		String chaine = "";
		if (longeurDesiree <= chaineDepart.length()) {
			return chaineDepart;
		}
		for (int i = 0; i < (longeurDesiree - chaineDepart.length()); i++) {
			chaine = chaine + String.valueOf(caractereDeRemplissage);
		}
		if (AligneADroite) {
			chaine = chaine + chaineDepart;
		} else {
			chaine = chaineDepart + chaine;
		}
		return chaine;
	}

	/**
	 * get the direct way from way
	 * 
	 * @return
	 * @param way
	 */
	public static String getWayDirectFromWay(String way) {
		String result = null;
		if (way != null) {
			way = way.replaceAll("  ", " ");

			StringTokenizer token = new StringTokenizer(way, " ");
			while (token.hasMoreElements()) {
				result = token.nextToken();
			}
		}
		return result;
	}

	public static String getWayTypeFromWay(String way) {
		String result = null;
		if (StringUtils.isValid(way)) {
			way = way.replaceAll("  ", " ");

			StringTokenizer token = new StringTokenizer(way, " ");
			result = token.nextToken();

		}
		return result;
	}

	public static String getTokenedStringForRechercheVoie(String voie,
			String criteria, String operator, boolean exclusive) {
		voie = deleteJokers(voie);
		voie = voie.replaceAll("  ", " ");

		StringTokenizer token = new StringTokenizer(voie.toLowerCase(), " ");
		String buffer = null;
		String result = "(";
		boolean first = true;
		String appender = null;

		if (operator == null)
			operator = " = ";

		if (exclusive == true)
			appender = " AND ";
		else
			appender = " OR ";

		while (token.hasMoreElements()) {
			buffer = token.nextToken();

			if (operator.trim().toUpperCase().equals("LIKE"))
				buffer = "UPPER(" + criteria + ") " + operator + " UPPER('%"
						+ buffer.replaceAll("-", " ") + "%')";
			else
				buffer = criteria + " " + operator + " '" + buffer + "'";
			if (first == false)
				result = result + appender + buffer;
			else
				result = result + buffer;

			first = false;
		}
		result = result + ")";
		return result;
	}

	public static ArrayList<String> getStringArrayForRechercheVoie(String voie) {
		voie = deleteJokers(voie);
		voie = voie.replaceAll("  ", " ");

		StringTokenizer token = new StringTokenizer(voie.toLowerCase(), " ");
		String buffer = null;
		ArrayList<String> result = new ArrayList<String>();
		boolean first = true;

		while (token.hasMoreElements()) {
			buffer = token.nextToken();

			buffer = buffer.replaceAll("-", "_");

			result.add("%" + buffer + "%");

			first = false;
		}
		return result;
	}

	/**
	 * Supprime tous les jokers pr�sents dans une chaine
	 * 
	 * @return
	 * @param s
	 */
	public static String deleteJokers(String s) {
		String sJoker = s;
		if (!isNull(s)) {
			sJoker = s.replace('*', ' '); // Joker foctionnel
			sJoker = sJoker.replace('?', ' '); // Joker fonctionnel
			sJoker = sJoker.replace('%', ' '); // Joker SQL
			sJoker = sJoker.replace('_', ' '); // Joker SQL
		} else {
			sJoker = "";
		}
		return (sJoker.replaceAll("  ", " ")).trim();
	}

	/**
	 * Supprime tous les jokers pr�sents dans une chaine
	 * 
	 * @return
	 * @param s
	 */
	public static boolean existeJokers(String s) {
		boolean res = false;
		if (!isNull(s)) {
			if (s.indexOf('*') != -1 || s.indexOf('?') != -1
					|| s.indexOf('%') != -1 || s.indexOf('_') != -1)
				res = true;
		}
		return res;
	}

	public static Date parseToDate(String strDate) {
		Date parsedDate = null;
		String day = null;
		String month = null;
		String year = null;
		String separator = null;
		CharSequence cs = null;

		cs = "-";
		if (strDate.contains(cs)) {
			separator = "-";
		}
		cs = "/";
		if (strDate.contains(cs)) {
			separator = "/";
		}
		cs = " ";
		if (strDate.contains(cs)) {
			separator = " ";
		}

		if (strDate.length() == 10) {
			StringTokenizer sToken = new StringTokenizer(strDate, separator);
			if (sToken.countTokens() == 3) {
				String e1, e2, e3 = null;
				e1 = sToken.nextToken();
				e2 = sToken.nextToken();
				e3 = sToken.nextToken();

				if ((e1.length() == 4 && parseInt(e1) <= 9999)
						&& (e2.length() == 2 && parseInt(e2) <= 12)
						&& (e3.length() == 2 && parseInt(e3) <= 31)
						&& separator.equals("-")) {
					year = e1;
					month = e2;
					day = e3;
				} else if ((e1.length() == 2 && parseInt(e1) <= 31)
						&& (e2.length() == 2 && parseInt(e2) <= 12)
						&& (e3.length() == 4 && parseInt(e3) <= 9999)
						&& separator.equals("-")) {
					month = e2;
					day = e1;
					year = e3;
				} else if ((e1.length() == 2 && parseInt(e1) <= 31)
						&& (e2.length() == 2 && parseInt(e2) <= 12)
						&& (e3.length() == 4 && parseInt(e3) <= 9999)
						&& separator.equals("/")) {
					month = e2;
					day = e1;
					year = e3;
				} else if ((e1.length() == 2 && parseInt(e1) <= 31)
						&& (e2.length() == 2 && parseInt(e2) <= 12)
						&& (e3.length() == 4 && parseInt(e3) <= 9999)
						&& separator.equals(" ")) {
					month = e2;
					day = e1;
					year = e3;
				} else if ((e1.length() == 4 && parseInt(e1) <= 9999)
						&& (e2.length() == 2 && parseInt(e2) <= 12)
						&& (e3.length() == 2 && parseInt(e3) <= 31)
						&& separator.equals(" ")) {
					month = e2;
					day = e1;
					year = e3;
				}
				if (day != null && month != null && year != null)
					parsedDate = constructCalendar(day, month, year).getTime();
			}
		}

		return parsedDate;

	}

	public static String ParseDateFrToUs(String date) {
//		SimpleDateFormat formatFr = new SimpleDateFormat(DATE_FORMAT_FR,
//				"fr");
//		SimpleDateFormat formatUs = new SimpleDateFormat(DATE_FORMAT_US,
//				Locale.US);
		String strDateFr = null;
//		try {
//			Date d = formatFr.parse(date);
//			strDateFr = formatUs.format(d);
//		} catch (Exception e) {
//			System.out.println(e);
//			e.printStackTrace();
//		}
		return strDateFr;
	}

	public static String formatSimpleDate(Date date) {
		if (date != null) {
			SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
			return simpleFormat.format(date);
		} else {
			return null;
		}

	}

	/*
	 * Object Session/Request + manipulation
	 */
	public static void setObjectSession(String code, Object objet) {
		HttpSession ss = (HttpSession) getSession();
		ss.setAttribute(code, objet);
	}

	public static void setObjectRequest(String code, Object objet) {
		HttpServletRequest request = (HttpServletRequest) getRequest();
		request.setAttribute(code, objet);
	}

	public static HttpSession getSession() {
		fc = FacesContext.getCurrentInstance();
		ec = fc.getExternalContext();
		HttpSession ss = (HttpSession) ec.getSession(true);
		return ss;
	}

	public static HttpServletRequest getRequest() {
		fc = FacesContext.getCurrentInstance();
		ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		return request;
	}

	public static ServletContext getContext() {
		fc = FacesContext.getCurrentInstance();
		ec = fc.getExternalContext();
		ServletContext sc = (ServletContext) ec.getContext();
		return sc;
	}

	public static boolean isAttributeInRequest(String attributeName) {
		String name = null;
		boolean present = false;
		HttpServletRequest request = getRequest();
		for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
			name = (String) e.nextElement();

			if (name.equalsIgnoreCase(attributeName)
					&& request.getParameter(name) != null) {
				present = true;

				break;
			}
		}
		if (present) {
			return true;
		}

		return false;
	}

	public static boolean isAttributeInSession(String attributeName) {
		String name = null;
		boolean present = false;
		HttpSession session = getSession();
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			name = (String) e.nextElement();

			if (name.equalsIgnoreCase(attributeName)
					&& session.getAttribute(name) != null) {
				present = true;

				break;
			}
		}

		if (present) {
			return true;
		}

		return false;
	}

	public static void removeAttributeSession(String code) {
		HttpSession maSession = (HttpSession) getSession();
		maSession.removeAttribute(code);
	}

	public Object getService(String name) {
		if (ctx == null) {
			fc = FacesContext.getCurrentInstance();
			ec = fc.getExternalContext();
			ctx = WebApplicationContextUtils
					.getRequiredWebApplicationContext((ServletContext) ec
							.getContext());
		}
		return ctx.getBean(name);
	}

	public static Object getObjectSession(String code) {
		HttpSession ss = (HttpSession) getSession();
		return (Object) ss.getAttribute(code);
	}

	public static Object getObjectRequest(String code) {
		HttpServletRequest request = (HttpServletRequest) getRequest();
		return (Object) request.getAttribute(code);
	}

	/**
	 * @param= String resource (witch bundle to explore to find the ressource's
	 *         message)
	 * @param= String property (search for witch property in the bundle's
	 *         resource)
	 */
	public static String getMessage(String ressource, String property) {
		fc = FacesContext.getCurrentInstance();

		return fc.getApplication().getResourceBundle(fc, ressource)
				.getString(property);
	}

	/**
	 * @param= String resource (witch bundle to explore to find the ressource's
	 *         message)
	 * @param= String property (search for witch property in the bundle's
	 *         resource)
	 * @param= Object[] arguments used to format the message resource
	 */
	public static String getMessage(String ressource, String property,
			Object[] arguments) {
		String msgRessource = Utilities.getMessage(ressource, property);

		return MessageFormat.format(msgRessource, arguments);
	}

	public static Double getFormattedDouble(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');

		DecimalFormat myFormatter = new DecimalFormat("#.##");
		myFormatter.setDecimalFormatSymbols(dfs);

		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(2);
		myFormatter.setMinimumFractionDigits(2);

		return new Double(myFormatter.format(number));
	}

	public static String getStringFormattedDouble(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');

		DecimalFormat myFormatter = new DecimalFormat("#.##");
		myFormatter.setDecimalFormatSymbols(dfs);

		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(2);
		myFormatter.setMinimumFractionDigits(2);
		if(number==0.0d)
			return null;
		return myFormatter.format(number);
	}
	public static String getStringFormattedDouble3(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');

		DecimalFormat myFormatter = new DecimalFormat("#.###");
		myFormatter.setDecimalFormatSymbols(dfs);

		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(3);
		myFormatter.setMinimumFractionDigits(3);

		return myFormatter.format(number);
	}

	public static double roundDouble2d(double number) {
		return Math.floor((number + 0.005) * 100) / 100;
	}

	/**
	 * transform a collection to a Set
	 * 
	 * @param list
	 * @return
	 */
	public static Set transformCollectionToSet(Collection c) {
		Set newList = null;
		if (c != null) {
			newList = new HashSet(c);
		}
		return newList;
	}

	public static String getFileBaseName(String fichier) {
		String separator = new String();
		int index_ext = fichier.lastIndexOf(".");
		int index_slash = fichier.lastIndexOf(File.separator);
		separator = File.separator;
		if (separator.equalsIgnoreCase("/")) {
			// testtest =fichier.substring(0, index_ext);

			// try {
			// File v = new
			// File("/data/follow/OXFAM/OFAI/models/fileSeparatorTest.txt");
			// FileOutputStream file = new FileOutputStream(v);
			// byte[]n= new byte[40];
			// n= testtest.getBytes();
			// file.write(n);
			// file.close();
			// } catch (Exception e) {
			// System.out.println("Erreur: " + e.toString());
			// }
			return fichier.substring(0, index_ext);
		} else
			return fichier.substring(index_slash + 1, index_ext);

	}

	public static String getFileBaseName(String fichier, String dirSeparator) {
		int index_ext = fichier.lastIndexOf(".");
		int index_slash = fichier.lastIndexOf(dirSeparator);
		return fichier.substring(index_slash + 1, index_ext);

	}

	public static String getFileExtension(String fichier) {
		int index_ext = fichier.lastIndexOf(".");
		return fichier.substring(index_ext);
	}

	public static String getBasePath(String fichier) {
		return fichier.substring(0, fichier.lastIndexOf(File.separator));
	}

	public static float differenceDate(Date date1, Date date2) {

		long difference = Math.abs(date1.getTime() - date2.getTime());
		double result = (double) difference / (24.0 * 60.0 * 60.0 * 1000.0);

		return (float) result;

	}

	public static float differenceDateSigned(Date date1, Date date2) {

		long difference = date1.getTime() - date2.getTime();
		double result = (double) difference / (24.0 * 60.0 * 60.0 * 1000.0);

		return (float) result;

	}

	public static String getFormatDecimal(Double valeur_ini, int maxDecim,
			int minDecim, String model) {
		if (valeur_ini != null) {
			DecimalFormatSymbols dfs = new DecimalFormatSymbols();
			dfs.setDecimalSeparator('.');

			/** * model exemple : #.## ** */
			DecimalFormat myFormatter = new DecimalFormat(model);
			myFormatter.setDecimalFormatSymbols(dfs);

			// impose le nombre de digit � 2
			myFormatter.setMaximumFractionDigits(maxDecim);
			myFormatter.setMinimumFractionDigits(minDecim);

			return myFormatter.format(valeur_ini);
		} else {
			return "";
		}
	}

	public static String padLeft(String s, int nbChars) {
		String format = "%1$" + nbChars + "s";
		return String.format(format, new Object[] { s });
	}

	public static String padRight(String s, int nbChars) {
		String format = "%1$-" + nbChars + "s";
		return String.format(format, new Object[] { s });
	}

	public static void main(String[] args) {
		System.out.println(roundDouble2d(5.299999));

		String test = getFormatDecimal(new Double(12345.6 * 100), 0, 0,
				"0000000000000000");
		System.out.println(test);

		String t1 = "06050";
		String t2 = "00123465";
		String resu = getFormatDecimal(Double.parseDouble(t1), 0, 0, "00000");
		String resu2 = getFormatDecimal(Double.parseDouble(t2), 0, 0,
				"00000000000");

		System.out.println("");

		String testLeft = padLeft("pou pou pou", 16);
		String testRight = padRight("pou pou pou", 16);
		System.out.println("");
	}

	public static FacesContext getFc() {
		return FacesContext.getCurrentInstance();
	}

	// Transformation chiffre en lettre
	public static String convertirEnEuros(double nombre, String syntaxe) {
		String doubleEnString = String.format(java.util.Locale.FRENCH, "%.2f",
				nombre);
		String strEntiere = doubleEnString.substring(0,
				doubleEnString.length() - 3);
		String strFraction = doubleEnString.substring(
				doubleEnString.length() - 2, doubleEnString.length());

		String mot = "";

		try {
			if (!(strEntiere.equals("0")))
				mot = convertirEntier(Long.parseLong(strEntiere), syntaxe)
						+ " euro"
						+ ((Long.parseLong(strEntiere) > 1L) ? "s" : "")
						+ (!strFraction.equals("00") ? " et " : "");
			if (!(strFraction.equals("00")))
				mot = mot
						+ convertirEntier(Long.parseLong(strFraction), syntaxe)
						+ " cent"
						+ ((Long.parseLong(strFraction) > 1L) ? "s" : "");
		} catch (Exception e) {
			mot = e.getMessage();
		}
		return mot;
	}

	public static String convertirEntier(long nombre, String syntaxe) {
		stx = syntaxe;
		if (nombre > 999999999999L)
			return ("Le nombre demand� est trop grand...");
		else
			return entierEnLettres(String.valueOf(nombre));
	}

	/*
	 * transforme en lettres de z�ro à 999 milliards (syntaxe française)
	 */
	private static String entierEnLettres(String strNombre) {
		int longueur;
		String groupe;
		String chaineAConvertir;
		String mot = "";
		final String MILLIARD = " milliard";
		final String MILLION = " million";
		final String MILLE = " mille";

		while (strNombre.length() > 0) {

			longueur = strNombre.length();
			groupe = "";
			chaineAConvertir = "";

			if (longueur > 9)
				groupe = MILLIARD;

			else if (longueur > 6)
				groupe = MILLION;

			else if (longueur > 3)
				groupe = MILLE;

			else
				return (mot + dechiffrage(strNombre)).trim();

			long test = longueur;

			// Si le nombre de chiffres est multiple de 3
			if (((long) longueur % 3) == 0) {
				chaineAConvertir = strNombre.substring(0, 3);
				strNombre = strNombre.substring(3);

				if (Integer.parseInt(chaineAConvertir) > 1)
					mot = mot + dechiffrage(chaineAConvertir) + groupe
							+ (!groupe.equals(MILLE) ? "s" : "");

				else if (Integer.parseInt(chaineAConvertir) > 0)
					mot = mot + groupe;

			} else {
				if (((test - 1) % 3) == 0) {
					chaineAConvertir = strNombre.substring(0, 1);
					strNombre = strNombre.substring(1);

				} else {
					chaineAConvertir = strNombre.substring(0, 2);
					strNombre = strNombre.substring(2);
				}
				if (chaineAConvertir.equals("1") && groupe.equals(MILLE))
					mot = mot + groupe;
				else
					mot = mot
							+ sousDechiffrage(chaineAConvertir)
							+ groupe
							+ ((Integer.parseInt(chaineAConvertir) > 1)
									&& (!groupe.equals(MILLE)) ? "s" : "");
			}
		}
		return mot.trim();
	}

	/*
	 * Transforme en lettres de 0 à 999
	 */
	private static String dechiffrage(String strNombre) {

		String plu = "s";
		String mot = "";
		final String CENT = "cent";
		String chaineAConvertir = "";
		int longueur = strNombre.length();

		// Si le nombre de chiffres est multiple de 3
		if (((long) longueur % 3) == 0) {

			chaineAConvertir = strNombre.substring(0, 1);

			if (Integer.parseInt(chaineAConvertir) > 1)
				mot = mot + sousDechiffrage(chaineAConvertir);

			if (Integer.parseInt(chaineAConvertir) > 0)
				mot = mot
						+ " "
						+ CENT
						+
						// gestion du "s" de "CENT"
						((!(Integer.parseInt(strNombre.substring(1)) > 0))
								&& (Integer.parseInt(chaineAConvertir) > 1) ? "s"
								: "");

			strNombre = strNombre.substring(1);

			if (Integer.parseInt(strNombre) > 0)
				mot = mot + sousDechiffrage(strNombre);
		}

		// sinon il est plus petit que 100 mot direct
		else
			return sousDechiffrage(strNombre);

		return String.format("%s", mot);
	}

	/*
	 * transforme en lettres de zéro à 99 syntaxe française par défaut,
	 * remplacer "String stx = FR ;" par "String stx = GC ;" pour la syntaxe
	 * belge
	 */
	private static String sousDechiffrage(String nombre) {
		/*
		 * final String FR = "FR" ; final String GC = "GC" ; String stx = FR ;
		 */
		String mot = "";
		int longueur;
		String et = "";

		String[] tabnb = { "z�ro", "un", "deux", "trois", "quatre", "cinq",
				"six", "sept", "huit", "neuf", "dix", "onze", "douze",
				"treize", "quatorze", "quinze", "seize", "dix-sept",
				"dix-huit", "dix-neuf" };

		String[] tabdix = { "vingt", "trente", "quarante", "cinquante",
				// "soixante", "soixante", "quatre-vingt", "quatre-vingt" } ;
				"soixante", "septante", "quatre-vingt", "nonante" };

		while (nombre.length() > 0) {
			longueur = nombre.length();
			et = "";

			switch (longueur) {

			case 1:
				mot = mot + " " + tabnb[Integer.parseInt(nombre)] + et;
				nombre = "";
				break;

			case 2:
				if (Integer.parseInt(nombre) < 20) {
					mot = mot + " " + tabnb[Integer.parseInt(nombre)] + et;
					nombre = "";

				} else if (Integer.parseInt(nombre) >= 20) {

					// gestion du "et-un" au dessus de 20
					if ((Integer.parseInt(nombre.substring(1, 2)) == 1)
							&& (((Integer.parseInt(nombre) < 80) && stx
									.equals(FR)) || stx.equals(GC)))
						et = " et";

					// gestion du "s" de quatre vingts
					else if ((Integer.parseInt(nombre) == 80) && stx.equals(FR))
						et = "s";

					mot = mot
							+ " "
							+ tabdix[Integer.parseInt(nombre.substring(0, 1))
									// gestion du soixante (dix) et quatre-vingt
									// (dix)
									- (((Integer.parseInt(nombre
											.substring(0, 1)) == 7) || (Integer
											.parseInt(nombre.substring(0, 1)) == 9))
											&& stx.equals(FR) ? 3 : 2)] + et;

					if (((Integer.parseInt(nombre) < 70) && stx.equals(FR))
							|| stx.equals(GC))
						nombre = nombre.substring(1, 2);

					else if (Integer.parseInt(nombre) < 80)
						nombre = (Integer.parseInt(nombre) - 60) + "";

					else if (Integer.parseInt(nombre) < 100)
						nombre = (Integer.parseInt(nombre) - 80) + "";
				}
			}
		}
		// enlever le zéro inutile
		if (mot.trim().length() != tabnb[0].length())
			mot = mot.replaceFirst(" " + tabnb[0], "");

		// remplacer "quatre-vingt" par octante (quoi? t'as un blème ?)
		if (stx.equals(GC))
			mot = mot.replaceFirst(tabdix[6], "octante");

		return String.format("%s", mot);
	}

	// idcm

	public static Date getFirstDateOfYear(Integer year) {
		// Integer currYear = getCurrentYear();
		if (year == null)
			return null;
		Calendar cal = constructCalendar("1", "0", year.toString());
		return cal.getTime();
	}

	public static Date getLastDateOfYear(Integer year) {
		// Integer currYear = getCurrentYear();
		if (year == null)
			return null;
		Calendar cal = constructCalendar("31", "11", year.toString());
		return cal.getTime();
	}

	// idmcEnd
	public static String getStringFormattedDoubleWithGamma(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');

		DecimalFormat myFormatter = new DecimalFormat("##,##");
		myFormatter.setDecimalFormatSymbols(dfs);
		myFormatter.setDecimalSeparatorAlwaysShown(false);
		myFormatter.setGroupingUsed(false);
		myFormatter.setMinimumIntegerDigits(1);
		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(2);
		myFormatter.setMinimumFractionDigits(2);

		return myFormatter.format(number);
	}

	public static String getStringFormattedNumberWithGamma(Number number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');

		DecimalFormat myFormatter = new DecimalFormat("##,##");
		myFormatter.setDecimalFormatSymbols(dfs);
		myFormatter.setDecimalSeparatorAlwaysShown(false);
		myFormatter.setGroupingUsed(false);

		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(2);
		myFormatter.setMinimumFractionDigits(2);
		myFormatter.setParseBigDecimal(true);

		return myFormatter.format(number);
	}

	public static String getStringFormattedNumberWithoutGamma(Number number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');

		DecimalFormat myFormatter = new DecimalFormat("##,##");
		myFormatter.setDecimalFormatSymbols(dfs);
		myFormatter.setDecimalSeparatorAlwaysShown(false);
		myFormatter.setGroupingUsed(false);
		myFormatter.setParseIntegerOnly(true);

		return myFormatter.format(number);
	}

	public static boolean isFormattedDate(String string) {
		try {

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			df.parse(string);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isFormattedNumber(String string) {
		try {

			DecimalFormat myFormatter = new DecimalFormat("##,##");
			myFormatter.parse(string);
			return true;

		} catch (NumberFormatException ne) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static Date StringToDate(String string) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			return df.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Number StringToDouble(String string) {
		try {
			DecimalFormat myFormatter = new DecimalFormat("##,##");
			return myFormatter.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean matchesContainsChiffre(String s) {
		boolean find = false;
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			find = true;
			break;
		}
		return find;

	}

	public static boolean matchesContainsCararcterNonMot(String s) {
		boolean find = false;
		Pattern pattern = Pattern.compile("\\W");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			find = true;
			break;
		}
		return find;
	}

	public static boolean matchesContainsMot(String s) {
		boolean find = false;
		Pattern pattern = Pattern.compile("\\w");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			find = true;
			break;
		}
		return find;
	}

	public static boolean matchesContainsNonChiffre(String s) {
		boolean find = false;
		Pattern pattern = Pattern.compile("\\D");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			find = true;
			break;
		}
		return find;

	}

	public static boolean matchesContainsAlphabet(String s) {
		boolean find = false;
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			find = true;
			break;
		}
		return find;

	}

	public static boolean matchesContainsgamma(String s) {
		boolean find = false;
		Pattern pattern = Pattern.compile(",");
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			find = true;
			break;
		}
		return find;

	}

	public static int matchesIsSpaceChar(String s) {
		boolean find = false;
		int i = 0;
		while (i < s.length() - 1 && find == false) {
			if (Character.isSpaceChar(s.charAt(i))) {
				find = true;
			}
			i++;
		}

		if (find == false)
			return -1;

		return i - 1;

	}

	public static String replaceSpaceChar(String s) {

		int i = 0;
		String replacedString = "";
		while (i < s.length()) {
			if (!Character.isSpaceChar(s.charAt(i))) {
				replacedString = replacedString + s.charAt(i);
			}
			i++;
		}
		return replacedString;

	}

	public static double getFormattedDoubleWithGamma(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');

		DecimalFormat myFormatter = new DecimalFormat("##,##");
		myFormatter.setDecimalFormatSymbols(dfs);
		myFormatter.setDecimalSeparatorAlwaysShown(false);
		myFormatter.setGroupingUsed(false);

		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(2);
		myFormatter.setMinimumFractionDigits(2);

		return new Double(myFormatter.format(number));
	}

	public static String getStringFormattedDoubleWithGamma2(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');

		DecimalFormat myFormatter = new DecimalFormat("##,##");
		myFormatter.setDecimalFormatSymbols(dfs);
		myFormatter.setDecimalSeparatorAlwaysShown(true);
		myFormatter.setGroupingUsed(false);

		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(2);
		myFormatter.setMinimumFractionDigits(2);
		myFormatter.setMinimumIntegerDigits(1);

		return myFormatter.format(number);
	}

	public static String getAAAAMMJJHMS(Date date) {
		String sdate = "";
		GregorianCalendar calendarDate = new GregorianCalendar();

		if (date != null) {
			calendarDate.setTime(date);

			if (calendarDate != null) {
				int sec = calendarDate.get(Calendar.SECOND);
				int m = calendarDate.get(Calendar.MONTH) + 1;
				int d = calendarDate.get(Calendar.DAY_OF_MONTH);
				int y = calendarDate.get(Calendar.YEAR);
				int hour = calendarDate.get(Calendar.HOUR_OF_DAY);
				int min = calendarDate.get(Calendar.MINUTE);

				sdate += "" + y + "" + m + "" + d + "" + hour + "" + min + ""
						+ sec;
			}
		}

		return sdate;
	}

	public static String getDateCompleteJourMois(Date date) {
		Calendar dCal = Calendar.getInstance();
		dCal.setTime(date);

		StringBuffer sb = new StringBuffer();
		sb.append(dCal.get(Calendar.DAY_OF_MONTH));
		sb.append(" ");
		sb.append(getMois(date));

		return sb.toString();
	}

	public static String dateToString(Date date, String format) {

		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} else {
			return null;
		}
	}

	public static String detectExtension(String extension) {
		String number2 = null;
		try {
			String number = extension;
			/*
			 * if (number.indexOf(" BIS ")>=0){ extension="BIS"; } else if
			 * (number.indexOf(" TER ")>=0){ extension="TER"; } else if
			 * (number.indexOf(" QUATER ")>=0){ extension="QUATER"; } return
			 * extension;
			 */

			if (number.indexOf("BIS ") >= 0) {
				number2 = "BIS";
			} else if (number.indexOf("TER ") >= 0) {
				number2 = "TER";
			} else if (number.indexOf(" A ") >= 0) {
				number2 = "A";
			} else if (number.indexOf(" B ") >= 0) {
				number2 = "B";
			} else if (number.indexOf(" C ") >= 0) {
				number2 = "C";
			} else if (number.indexOf(" D ") >= 0) {
				number2 = "D";
			} else if (number.indexOf(" E ") >= 0) {
				number2 = "E";
			} else if (number.indexOf(" F ") >= 0) {
				number2 = "F";
			} else if (number.indexOf(" G ") >= 0) {
				number2 = "G";
			} else if (number.indexOf(" H ") >= 0) {
				number2 = "H";
			} else if (number.indexOf(" I ") >= 0) {
				number2 = "I";
			} else if (number.indexOf(" J ") >= 0) {
				number2 = "J";
			} else if (number.indexOf(" S ") >= 0) {
				number2 = "S";
			} else if (number.indexOf(" T ") >= 0) {
				number2 = "T";
			} else if (number.indexOf(" U ") >= 0) {
				extension = "U";
			} else if (number.indexOf(" V ") >= 0) {
				extension = "V";
			} else if (number.indexOf(" W ") >= 0) {
				extension = "W";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			String[] args = { extension };

		}
		return number2;
	}

	public static String firstLetterUpper(String aformater) {

		String formate = "";
		if (aformater.length() == 0) {
			aformater = "";
		}

		// System.out.println(aformater);

		while (aformater.length() > 0) {
			int pos = aformater.indexOf(' ');
			int pos2 = aformater.indexOf('-');

			if (pos2 > pos && pos != -1) {
				pos2 = -1;
			}
			if (pos > pos2 && pos2 != -1) {
				pos = -1;
			}

			// System.out.println(aformater.length());
			// System.out.println(pos2+1);
			if ((pos2 + 1) == aformater.length()) {
				pos2 = -1;
			}

			if ((pos2) == 0) {
				pos2 = -1;
			}

			if (pos2 >= 0) {

				formate = formate + " "
						+ aformater.substring(0, 1).toUpperCase()
						+ aformater.substring(1, pos2).toLowerCase() + "-";
				aformater = aformater.substring(pos2 + 1).trim();
			}
			if (pos >= 0) {

				formate = formate + " "
						+ aformater.substring(0, 1).toUpperCase()
						+ aformater.substring(1, pos).toLowerCase() + " ";
				aformater = aformater.substring(pos).trim();
			} else {
				formate = formate
						+ aformater.substring(0, 1).toUpperCase()
						+ aformater.substring(1, aformater.length())
								.toLowerCase();
				aformater = "";
			}

		}
		return formate.trim();
	}

	public static Date stringToDate(String sDate, String sFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);

		Date retour = null;
		try {
			retour = sdf.parse(sDate);
		} catch (Exception e) {
			// System.out.println("");

		}
		return retour;
	}

	public static Date stringToDatee(String d, String format) {
		Date date = null;
		try {
			if (d != null && !"".equals(d)) {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				date = sdf.parse(d);
			}
		} catch (Exception e) {
			// System.out.println("probl�me avec les dates");
		}

		return date;
	}

	public static String intToString(int sFormat) {

		String valeur = new Integer(sFormat).toString();
		return valeur;
	}

	public static String BigDecimalToString(BigDecimal sFormat) {

		String valeur = sFormat.toString();
		return valeur;
	}

	public static Double StringToDouble(String string, String format) {

		Double d = new Double(0);
		try {
			DecimalFormat myFormatter = new DecimalFormat(format);
			if (format.equalsIgnoreCase("00")) {
				format = "##00";
				myFormatter = new DecimalFormat(format);
				d = new Double((Long) myFormatter.parse(string) / 100);

			} else if (format.equalsIgnoreCase(",")) {
				format = "##,##";
				d = (Double) myFormatter.parse(string);
			} else if (format.equalsIgnoreCase(".")) {
				format = "##.##";
				d = (Double) myFormatter.parse(string);
			} else {
				d = (Double) myFormatter.parse(string);
			}
			// System.out.println(" montant format� "+d);
		} catch (Exception e) {
			String[] args = { string, format };

			return null;
		}
		return d;
	}

	public static Date getFirstMonthYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	public static Date getEndMonthYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, +1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);

		return cal.getTime();
	}

	public static String getNameFile(String path) {
		try {
			int lastSlash = path.lastIndexOf("/");
			int index_ext = path.length();
			String filename = path.substring(lastSlash + 1, index_ext);
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean verficationTraitmentEnCours() {
		nombrethread++;
		return (nombrethread == 1);
	}

	public static void setNombreThread(int nombre) {
		nombrethread = nombre;
	}

	/*
	 * format Wed Aug 01 00:00:00 CEST 2012 to String
	 */
	public static String formatDateToStringConverter(Object object) {
		String string = new String();
		string = object.toString();
		if (object.toString().length() == 10)
			return object.toString();
		if (!string.equals("")) {
			System.out.println("the object.toString() " + string);
			String formattedString = new String();
			String month = string.substring(4, 7);
			String monthNumber = new String();
			String dayNumber = new String();
			String yearNumber = new String();
			if (month.equals("Jan")) {
				monthNumber = "01";
			} else if (month.equals("Feb")) {
				monthNumber = "02";
			} else if (month.equals("Mar")) {
				monthNumber = "03";
			} else if (month.equals("Apr")) {
				monthNumber = "04";
			} else if (month.equals("May")) {
				monthNumber = "05";
			} else if (month.equals("Jun")) {
				monthNumber = "06";
			} else if (month.equals("Jul")) {
				monthNumber = "07";
			} else if (month.equals("Aug")) {
				monthNumber = "08";
			} else if (month.equals("Sep")) {
				monthNumber = "09";
			} else if (month.equals("Oct")) {
				monthNumber = "10";
			} else if (month.equals("Nov")) {
				monthNumber = "11";
			} else if (month.equals("Dec")) {
				monthNumber = "12";
			}
			dayNumber = string.substring(8, 10);
			yearNumber = string.substring(string.length() - 4);
			System.out.println(string);
			formattedString = dayNumber + "/" + monthNumber + "/" + yearNumber;
			return formattedString;
		}
		return "";

		// SimpleDateFormat df = new
		// SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		// return df.format(object.toString());
	}

	public static String formatDateToStringConverter(String object) {
		String string = new String();
		string = object;
		if (object.length() == 10)
			return object;
		if (!string.equals("")) {
			System.out.println("the object.toString() " + string);
			String formattedString = new String();
			String month = string.substring(4, 7);
			String monthNumber = new String();
			String dayNumber = new String();
			String yearNumber = new String();
			if (month.equals("Jan")) {
				monthNumber = "01";
			} else if (month.equals("Feb")) {
				monthNumber = "02";
			} else if (month.equals("Mar")) {
				monthNumber = "03";
			} else if (month.equals("Apr")) {
				monthNumber = "04";
			} else if (month.equals("May")) {
				monthNumber = "05";
			} else if (month.equals("Jun")) {
				monthNumber = "06";
			} else if (month.equals("Jul")) {
				monthNumber = "07";
			} else if (month.equals("Aug")) {
				monthNumber = "08";
			} else if (month.equals("Sep")) {
				monthNumber = "09";
			} else if (month.equals("Oct")) {
				monthNumber = "10";
			} else if (month.equals("Nov")) {
				monthNumber = "11";
			} else if (month.equals("Dec")) {
				monthNumber = "12";
			}
			dayNumber = string.substring(8, 10);
			yearNumber = string.substring(string.length() - 4);
			System.out.println(string);
			formattedString = dayNumber + "/" + monthNumber + "/" + yearNumber;
			return formattedString;
		}
		return "";
		// SimpleDateFormat df = new
		// SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
		// System.out.println("df.format(object.toString()"+df.format(object.toString()));
		// return df.format(object.toString());
	}

	public static String sansAccents(String source) {
		return Normalizer.normalize(source, Normalizer.Form.NFD).replaceAll(
				"[\u0300-\u036F]", "");
	}

	public static String getRandomNumber() {
		try {
			String currentTime = "" + System.currentTimeMillis();
			return currentTime.substring(1, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return completeZero("" + System.currentTimeMillis(), 9, false);
		}
	}

	public static String renameFile(String filePath) {

		int indexExtension = filePath.lastIndexOf(".");
		String extension = filePath.substring(indexExtension + 1);

		String fileName = filePath.substring(0, indexExtension);

		int i = 2;
		filePath = fileName + "_" + i + "_." + extension;
		File file = new File(filePath);

		while (file.exists()) {
			i++;
			filePath = fileName + "_" + i + "_." + extension;
			file = new File(filePath);
		}
		return filePath;
	}

	public static boolean copier(File source, File destination) { // Methode
																	// permettant
																	// la copie
																	// d'un
																	// fichier
		boolean resultat = false;

		// Declaration des flux
		java.io.FileInputStream sourceFile = null;
		java.io.FileOutputStream destinationFile = null;
		try {
			// Cr�ation du fichier :
			destination.createNewFile();
			// Ouverture des flux
			sourceFile = new java.io.FileInputStream(source);
			destinationFile = new java.io.FileOutputStream(destination);
			// Lecture par segment de 0.5Mo
			byte buffer[] = new byte[512 * 1024];
			int nbLecture;
			while ((nbLecture = sourceFile.read(buffer)) != -1) {
				destinationFile.write(buffer, 0, nbLecture);
			}

			// Copie r�ussie
			resultat = true;
		} catch (java.io.FileNotFoundException f) {
		} catch (java.io.IOException e) {
		} finally {
			// Quoi qu'il arrive, on ferme les flux
			try {
				sourceFile.close();
			} catch (Exception e) {
			}
			try {
				destinationFile.close();
			} catch (Exception e) {
			}
		}
		return (resultat);
	}

	public Date getDateAujourdui() {
		return new Date(System.currentTimeMillis());
	}
	public static String  getTrimestre(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String trimestre="T1";
		int mois= cal.get(Calendar.MONTH)+1;
		switch (mois) {
		case 1:	 trimestre="T1"; break;
		case 2:	 trimestre="T1"; break;
		case 3:	 trimestre="T1"; break;
		case 4:	 trimestre="T2"; break;
		case 5:	 trimestre="T2"; break;
		case 6:	 trimestre="T2"; break;
		case 7:	 trimestre="T3"; break;
		case 8:	 trimestre="T3"; break;
		case 9:	 trimestre="T3"; break;
		case 10:	 trimestre="T4"; break;
		case 11:	 trimestre="T4"; break;
		case 12:	 trimestre="T4"; break;

		default:
			break;
		}
		return trimestre;
	}
	public static int  getMoisInt(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int mois= cal.get(Calendar.MONTH)+1;//because months are zero-based
		return mois;
	}
	public static Date createCalendarWithDate(Date date,int nbremois) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//int current_month=cal.get(Calendar.MONTH);
		cal.add(Calendar.MONTH, nbremois);
		return cal.getTime();
	}
	public static Date createCalendarWithDateDecrement(Date date,int nbrejour) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.DAY_OF_MONTH, nbrejour);
		 return cal.getTime();
		
	}
	
	public static String getMois(int  nbre_mois) {
		switch (nbre_mois) {
		case 1:
			return "Janvier";

		case 2:
			return "Février";

		case 3:
			return "Mars";

		case 4:
			return "Avril";

		case 5:
			return "Mai";

		case 6:
			return "Juin";

		case 7:
			return "Juillet";

		case 8:
			return "Août";

		case 9:
			return "Septembre";

		case 10:
			return "Octobre";

		case 11:
			return "Novembre";

		case 12:
			return "Décembre";

		default:
			return "";
		}
	}
	public static Date createCalendarIncrementYear(Date date,int nbreAnnee) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.add(Calendar.YEAR, nbreAnnee);
		 return cal.getTime();
		
	}
	public static boolean isEmailAdress(String email){
		Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher(email.toUpperCase());
		return m.matches();
	}
	public static String getStringFormattedDouble3Gamma(double number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		//dfs.setGroupingSeparator('');
		DecimalFormat myFormatter = new DecimalFormat("####,###");
		myFormatter.setDecimalFormatSymbols(dfs);
		myFormatter.setGroupingUsed(false);
		// impose number � digits to 2
		myFormatter.setMaximumFractionDigits(3);
		myFormatter.setMinimumFractionDigits(3);

		return myFormatter.format(number);
	}
	public static Date createCalendarWithDateEcheance(Date date,int nbremois) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//int current_month=cal.get(Calendar.MONTH);
		cal.add(Calendar.MONTH, nbremois);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}
}
