package com.cynapsys.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ArabicNumberToWords {
	private static final String[] dizaineNames = { "", "عشرة", "عشرون", "ثلاثون", "أربعون", "خمسون", "ستون", "سبعون",
			"ثمانون", "تسعون" };

	private static final String[] uniteNames1 = { "", "واحد", "إثنا", "ثلاث", "أربع", "خمس", "ست", "سبع", "ثمان",
			"تسع", "عشرة", "إحدى عشر", "اثنى عشر", "ثلاث عشر", "أربع  عشر", "خمس عشر", "ست عشر", "سبع عشر", "ثمان عشر",
			"تسع عشر" };

	private static final String[] uniteNamesAnne = { "سنة", "سنة", "سنتين", "ثلاث سنوات", "أربعة سنوات", "سنوات خمسة",
			"ستة سنوات", "سبعة سنوات", "ثمانية سنوات", "تسعة سنوات", "عشرة سنوات", "إحدى عشر سنة", "اثنى عشر سنة",
			"ثلاثة عشر سنة", "أربعة عشر سنة", "خمسة عشر سنة", "سنة ستة عشر", "سبعة عشر سنة", "ثمانية عشر سنة",
			"تسعة عشر سنة" };

	private static final String[] uniteNames2 = { "", "واحد", "إثنان", "ثلاث", "أربع", "خمس", "ست", "سبع", "ثمان",
			"تسعة", "عشرة" };

	private ArabicNumberToWords() {
	}

	private static String convertZeroToHundred(int number) {
		int laDizaine = number / 10;
		int lUnite = number % 10;
		String resultat = "";
		// séparateur "-" "et" ""
		String laLiaison = " ";

		if (number > 20) {
			laLiaison = " و ";
		}

		// dizaines en lettres
		if (laDizaine == 0) {
			resultat = uniteNames1[lUnite];
		} else {
			if (lUnite == 0) {
				resultat = dizaineNames[laDizaine];
			} else if (number < 20) {
				resultat = uniteNames1[lUnite] + laLiaison + dizaineNames[laDizaine];
			} else {
				resultat = uniteNames1[lUnite] + laLiaison + dizaineNames[laDizaine];
			}
		}

		return resultat;
	}

	private static String convertZeroToHundredAnne(int number) {
		int laDizaine = number / 10;
		int lUnite = number % 10;
		String resultat = "";
		// séparateur "-" "et" ""
		String laLiaison = " ";

		if (number > 20) {
			laLiaison = " و ";
		}

		// dizaines en lettres
		if (laDizaine == 0) {
			resultat = uniteNamesAnne[lUnite];
		} else {
			if (lUnite == 0) {
				resultat = dizaineNames[laDizaine];
			} else if (number < 20) {
				resultat = uniteNamesAnne[lUnite];
			} else {
				resultat = uniteNames1[lUnite] + laLiaison + dizaineNames[laDizaine] + " سنة ";
			}
		}

		return resultat;
	}

	private static String convertLessThanOneThousand(int number) {
		int lesCentaines = number / 100;
		int leReste = number % 100;
		String sReste = convertZeroToHundred(leReste);

		String resultat;
		switch (lesCentaines) {
		case 0:
			resultat = sReste;
			break;
		case 1:
			if (leReste > 0) {
				resultat = "مئة و" + sReste;
			} else {
				resultat = "مئة";
			}
			break;
		case 2:
			if (leReste > 0) {
				resultat = "مئتين و" + sReste;
			} else {
				resultat = "مئتين";
			}
			break;

		default:
			if (leReste > 0) {
				resultat = uniteNames2[lesCentaines] + " مئة و" + sReste;
			} else {
				resultat = uniteNames2[lesCentaines] + " مئة";
			}
		}
		return resultat;
	}

	public static String convert(long number) {
		// 0 à 999 999 999 999
		if (number == 0) {
			return "صفر";
		}

		String snumber = Long.toString(number);

		// pad des "0"
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);

		// XXXnnnnnnnnn
		int lesMilliards = Integer.parseInt(snumber.substring(0, 3));
		// nnnXXXnnnnnn
		int lesMillions = Integer.parseInt(snumber.substring(3, 6));
		// nnnnnnXXXnnn
		int lesCentMille = Integer.parseInt(snumber.substring(6, 9));
		// nnnnnnnnnXXX
		int lesMille = Integer.parseInt(snumber.substring(9, 12));

		String tradMilliards;
		switch (lesMilliards) {
		case 0:
			tradMilliards = "";
			break;
		case 1:
			tradMilliards = convertLessThanOneThousand(lesMilliards) + " مليار ";
			break;
		default:
			tradMilliards = convertLessThanOneThousand(lesMilliards) + " مليارات ";
		}
		String resultat = tradMilliards;

		String tradMillions;
		switch (lesMillions) {
		case 0:
			tradMillions = "";
			break;
		case 1:
			tradMillions = convertLessThanOneThousand(lesMillions) + " مليوناً ";
			break;
		default:
			tradMillions = convertLessThanOneThousand(lesMillions) + " مليوناً ";
		}
		resultat = resultat + tradMillions;

		String tradCentMille;
		switch (lesCentMille) {
		case 0:
			tradCentMille = "";
			break;
		case 1:
			tradCentMille = " ألف و ";
			break;
		default:
			tradCentMille = convertLessThanOneThousand(lesCentMille) + " ألفاً و ";
		}
		resultat = resultat + tradCentMille;

		String tradMille;
		tradMille = convertLessThanOneThousand(lesMille);
		resultat = resultat + tradMille;

		return resultat;
	}

	public static int getDecimalValue(double value) {
		BigDecimal decimal = new BigDecimal(value).setScale(3, RoundingMode.HALF_UP);
		String valueString = decimal.toString();
		int indexPoint = valueString.indexOf(".");
		int intValue = 0;
		if (indexPoint > -1) {
			String subValue = valueString.substring(indexPoint + 1);
			intValue = Integer.parseInt(subValue);
		}
		return intValue;
	}

	public static String convertToDinars(double value) {
		String result = "";
		int intValue = (int) value;
		int decimalValue = getDecimalValue(value);
		if (value < 10) {
			result = ArabicNumberToWords.convert(intValue) + " دنانير " + "و " + decimalValue + " مليم";
		} else {
			result = ArabicNumberToWords.convert(intValue) + " دينار " + "و " + decimalValue + " مليم";
		}
		return result;
	}

	public static String convertToAnnee(Integer value) {
		String result = "";
		int intValue = value != null ? (int) value : 0;
		result = ArabicNumberToWords.convertZeroToHundredAnne(intValue);
		return result;
	}
}