package com.cynapsys.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class StringUtils {
	Logger log = Logger.getLogger(StringUtils.class);
	/**
	 * DOCUMENT ME!
	 * 
	 * @param s
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public final static String dateRegex = "^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)+$";

	private static String accent = "������������������������������������";
	private static char accentReplace = '_';

	public static boolean isValid(String s) {
		return (s != null) && !s.trim().equals("");
	}

	public static boolean isStringBufferValid(StringBuffer s) {
		return (s != null) && s.length() > 0;
	}

	public static String replaceApostrophes(String s) {
		String retour = "";
		if (isValid(s)) {
			retour = s.replaceAll("'", "''");
		}
		return retour;
	}

	public static String cleanString(String s) {
		String str = testNull(s);
		// str = replaceApostrophes(str);
		return str.trim();
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param text
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String initCap(String text) {
		String maj = text.substring(0, 1).toUpperCase();
		String min = text.substring(1).toLowerCase();

		return (maj + min);
	}

	public static String initCapFirstName(String text) {
		String firstName = "";
		try {
			String[] subName = text.split("\\s+");

			for (String name : subName) {
				String maj = name.substring(0, 1).toUpperCase();
				String min = name.substring(1).toLowerCase();

				firstName += (maj + min) + " ";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();			
			return text;
		}

		return firstName.trim();
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param s
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static String testNull(String s) {
		if (!isValid(s)) {
			return "";
		} else {
			return s;
		}
	}

	public static String booleanToBit(Boolean value)
	{
		return (value==true)?"1":"0" ;
	}
	public static boolean stringToBoolean(String value)
	{
		return (value.equals("1"))?true:false ;
	}
	public static boolean charToBoolean(Character value)
	{
		return (value.equals('1'))?true:false ;
	}
	
	/**
	 * DOCUMENT ME!
	 * 
	 * @param str
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean isDateValide(String str) {
		String str1 = null;
		String str2 = null;
		String str3 = null;
		String str4 = null;
		String str5 = null;

		try {
			str1 = str.substring(0, 2);
			str2 = str.substring(3, 5);
			str3 = str.substring(6, 10);
			str4 = str.substring(2, 3);
			str5 = str.substring(5, 6);

			Calendar cDate = Calendar.getInstance();
			cDate.set(StringUtils.parseInt(str3),
					StringUtils.parseInt(str2) - 1, StringUtils.parseInt(str1));

			if (StringUtils.integerTest(str1)
					&& StringUtils.integerTest(str2)
					&& StringUtils.integerTest(str3)
					&& str4.equals("/")
					&& str5.equals("/")
					&& (str.length() == 10)
					&& (cDate.get(cDate.DAY_OF_MONTH) == StringUtils
							.parseInt(str1))
					&& ((cDate.get(cDate.MONTH) + 1) == StringUtils
							.parseInt(str2))
					&& (cDate.get(cDate.YEAR) == StringUtils.parseInt(str3))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param s
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static int parseInt(String s) {
		try {
			if (StringUtils.isValid(s)) {
				return Integer.parseInt(s);
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * DOCUMENT ME!
	 * 
	 * @param str
	 *            DOCUMENT ME!
	 * @return DOCUMENT ME!
	 */
	public static boolean integerTest(String str) {
		try {
			Integer.parseInt(str);

			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public static boolean longTest(String str) {
		try {
			Double.parseDouble(str);

			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Remplace dans une chaine un pattern par un autre.
	 * 
	 * @param str
	 *            la chaine o� modifier
	 * @param oldStr
	 *            le pattern � remplacer
	 * @param newStr
	 *            le pattern de remplacement
	 * @return la nouvelle chaine
	 */
	public static String stringReplace(String str, String oldStr, String newStr) {
		StringBuffer result = new StringBuffer();
		if (str != null) {
			while (str.indexOf(oldStr) != -1) {
				result.append(str.substring(0, str.indexOf(oldStr)));
				str = str.substring(str.indexOf(oldStr) + oldStr.length());
				result.append(newStr);
			}
		}
		result.append(str);
		return result.toString();
	}

	public static boolean isMatchingRegex(String StringToTest, String regex) {
		Pattern pattern;
		Matcher matcher;

		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(StringToTest);

		return matcher.matches();
	}

	public static String testNullVide(String string) {
		if (string.trim().length() == 0)
			string = null;
		return string;
	}

	public static String chronoMinMs(Date date) {
		StringBuffer sb = new StringBuffer();
		GregorianCalendar calendarDate = new GregorianCalendar();

		if (date != null) {
			calendarDate.setTime(date);

			if (calendarDate != null) {
				int min = calendarDate.get(Calendar.MINUTE);
				int ms = calendarDate.get(Calendar.MILLISECOND);

				sb.append(min);
				sb.append(ms);
			}
		}
		return sb.toString();
	}

	public static int customIndexOf(String source, String pattern, int index) {
		String temp = source;

		try {
			for (int i = 0; i < (index - 1); i++) {
				temp = source.substring(0, temp.lastIndexOf(pattern));
			}
		} catch (Exception e) {
			return -1;
		}

		return temp.lastIndexOf(pattern);
	}

	public static String deleteAccent(String s) {
		String result = "";
		if (StringUtils.isValid(s)) {
			result = new String(s);

			for (int i = 0; i < accent.length(); i++) {
				result = result.replace(accent.charAt(i), accentReplace);
			}
		}

		return result.replaceAll("'", "''");

	}

	public static String getContentTypeFromExtension(String extension) {
		String contentType = null;
		if (extension.equalsIgnoreCase("pdf")) {
			contentType = "application/pdf";

		}
		if (extension.equalsIgnoreCase("txt")) {
			contentType = "text/plain";

		}
		if (extension.equalsIgnoreCase("rtf")) {
			contentType = "application/rtf";

		}
		if (extension.equalsIgnoreCase("html")) {
			contentType = "text/html";

		}
		if (extension.equalsIgnoreCase("xml")) {
			contentType = "text/xml";

		}
		if (extension.equalsIgnoreCase("doc")
				|| extension.equalsIgnoreCase("docx")) {
			contentType = "application/word";
		}
		if (extension.equalsIgnoreCase("xls")
				|| extension.equalsIgnoreCase("xlsx")) {
			contentType = "application/vnd.ms-excel";
		}
		if (extension.equalsIgnoreCase("csv")) {
			contentType = "application/csv";

		}
		return contentType;
	}

	public static String getContentType(String extension) {
		String contentType = null;
		if (extension.equalsIgnoreCase("html")
				|| extension.equalsIgnoreCase("htm")) {
			contentType = "text/html";
		}
		if (extension.equalsIgnoreCase("txt")
				|| extension.equalsIgnoreCase("text")) {
			contentType = "text/plain";
		}
		if (extension.equalsIgnoreCase("gif")) {
			contentType = "image/gif";
		}
		if (extension.equalsIgnoreCase("ief")) {
			contentType = "image/ief";
		}
		if (extension.equalsIgnoreCase("jpeg")
				|| extension.equalsIgnoreCase("jpg")
				|| extension.equalsIgnoreCase("jpe")) {
			contentType = "image/jpeg";
		}
		if (extension.equalsIgnoreCase("tif")
				|| extension.equalsIgnoreCase("tiff")) {
			contentType = "image/tiff";
		}
		if (extension.equalsIgnoreCase("png")) {
			contentType = "image/png";
		}
		if (extension.equalsIgnoreCase("xwd")) {
			contentType = "image/x-xwindowdump";
		}
		if (extension.equalsIgnoreCase("ai")
				|| extension.equalsIgnoreCase("eps")
				|| extension.equalsIgnoreCase("ps")) {
			contentType = "application/postscript";
		}
		if (extension.equalsIgnoreCase("rtf")) {
			contentType = "application/rtf";
		}
		if (extension.equalsIgnoreCase("tex")) {
			contentType = "application/x-tex";
		}
		if (extension.equalsIgnoreCase("texinfo")
				|| extension.equalsIgnoreCase("texi")) {
			contentType = "application/x-texinfo";
		}
		if (extension.equalsIgnoreCase("t") || extension.equalsIgnoreCase("tr")
				|| extension.equalsIgnoreCase("roff")) {
			contentType = "application/x-troff";
		}
		if (extension.equalsIgnoreCase("au")) {
			contentType = "audio/basic";
		}
		if (extension.equalsIgnoreCase("midi")
				|| extension.equalsIgnoreCase("mid")) {
			contentType = "audio/midi";
		}
		if (extension.equalsIgnoreCase("aifc")) {
			contentType = "audio/x-aifc";
		}
		if (extension.equalsIgnoreCase("aif")
				|| extension.equalsIgnoreCase("aiff")) {
			contentType = "audio/x-aiff";
		}
		if (extension.equalsIgnoreCase("mpeg")
				|| extension.equalsIgnoreCase("mpg")) {
			contentType = "audio/x-mpeg";
		}
		if (extension.equalsIgnoreCase("wav")) {
			contentType = "audio/x-wav";
		}
		if (extension.equalsIgnoreCase("mpeg")
				|| extension.equalsIgnoreCase("mpg")
				|| extension.equalsIgnoreCase("mpe")) {
			contentType = "video/mpeg";
		}
		if (extension.equalsIgnoreCase("qt")
				|| extension.equalsIgnoreCase("mov")) {
			contentType = "video/quicktime";
		}

		if (extension.equalsIgnoreCase("avi")) {
			contentType = "video/x-msvideo";
		}
		if (extension.equalsIgnoreCase("pdf")) {
			contentType = "application/pdf";
		}
		if (extension.equalsIgnoreCase("doc")) {
			contentType = "application/msword";
		}
		if (extension.equalsIgnoreCase("csv")) {
			contentType = "text/comma-separated-values";
		}
		if (extension.equalsIgnoreCase("xls")) {
			contentType = "application/vnd.ms-excel";
		}
		if (extension.equalsIgnoreCase("docx")) {
			contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		}
		if (extension.equalsIgnoreCase("xlsx")) {
			contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		}
		System.out.println("--> contentType ::  "+contentType);
		return contentType;

	}
}
