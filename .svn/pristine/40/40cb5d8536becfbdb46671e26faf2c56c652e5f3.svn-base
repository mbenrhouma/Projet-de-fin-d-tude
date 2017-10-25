package com.cynapsys.test;


import java.text.DecimalFormat;

class ArabicNumberToWords {
  private static final String[] dizaineNames = {
    "",
    "",
    "عشرون",
    "ثلاثون",
    "أربعون",
    "خمسون",
    "ستون",
    "سبعون",
    "ثمانون",
    "تسعون"
  };

  private static final String[] uniteNames1 = {
    "",
    "واحد",
    "إثنان",
    "ثلاث",
    "أربعة",
    "خمسة",
    "ستة",
    "سبعة",
    "ثمانية",
    "تسعة",
    "عشرة",
    "إحدى عشر",
    "اثنى عشر",
    "ثلاثة عشر",
    "أربعة  عشر",
    "خمسة عشر",
    "ستة عشر",
    "سبعة عشر",
    "ثمانية عشر",
    "تسعة عشر"
  };

  private static final String[] uniteNames2 = {
    "",
    "واحد",
    "إثنان",
    "ثلاث",
    "أربعة",
    "خمسة",
    "ستة",
    "سبعة",
    "ثمانية",
    "تسعة",
    "عشرة"
  };

  private ArabicNumberToWords() {}

  private static String convertZeroToHundred(int number) {

    int laDizaine = number / 10;
    int lUnite = number % 10;
    String resultat = "";

    switch (laDizaine) {
    case 1 :
    case 7 :
    case 9 :
      lUnite = lUnite + 10;
      break;
    default:
    }

    // séparateur "-" "et"  ""
    String laLiaison = "";
    if (laDizaine > 1) {
      laLiaison = "-";
    }
    // cas particuliers
    switch (lUnite) {
    case 0:
      laLiaison = "";
      break;
    case 1 :
      if (laDizaine == 8) {
        laLiaison = "-";
      }
      else {
        laLiaison = " et ";
      }
      break;
    case 11 :
      if (laDizaine==7) {
        laLiaison = " et ";
      }
      break;
    default:
    }

    // dizaines en lettres
    switch (laDizaine) {
    case 0:
      resultat = uniteNames1[lUnite];
      break;
    case 8 :
      if (lUnite == 0) {
        resultat = dizaineNames[laDizaine];
      }
      else {
        resultat = dizaineNames[laDizaine]
                                + laLiaison + uniteNames1[lUnite];
      }
      break;
    default :
      resultat = dizaineNames[laDizaine]
                              + laLiaison + uniteNames1[lUnite];
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
    case 1 :
      if (leReste > 0) {
        resultat = "مئة " + sReste;
      }
      else {
        resultat = "مئة";
      }
      break;
    default :
      if (leReste > 0) {
        resultat = uniteNames2[lesCentaines] + " مئة " + sReste;
      }
      else {
        resultat = uniteNames2[lesCentaines] + " مئة";
      }
    }
    return resultat;
  }

  public static String convert(long number) {
    // 0 à 999 999 999 999
    if (number == 0) { return "صفر"; }

    String snumber = Long.toString(number);

    // pad des "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);

    // XXXnnnnnnnnn
    int lesMilliards = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int lesMillions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int lesCentMille = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int lesMille = Integer.parseInt(snumber.substring(9,12));

    String tradMilliards;
    switch (lesMilliards) {
    case 0:
      tradMilliards = "";
      break;
    case 1 :
      tradMilliards = convertLessThanOneThousand(lesMilliards)
         + " مليار ";
      break;
    default :
      tradMilliards = convertLessThanOneThousand(lesMilliards)
         + " مليارات ";
    }
    String resultat =  tradMilliards;

    String tradMillions;
    switch (lesMillions) {
    case 0:
      tradMillions = "";
      break;
    case 1 :
      tradMillions = convertLessThanOneThousand(lesMillions)
         + " مليون ";
      break;
    default :
      tradMillions = convertLessThanOneThousand(lesMillions)
         + " ملايين ";
    }
    resultat =  resultat + tradMillions;

    String tradCentMille;
    switch (lesCentMille) {
    case 0:
      tradCentMille = "";
      break;
    case 1 :
      tradCentMille = "ألف ";
      break;
    default :
      tradCentMille = convertLessThanOneThousand(lesCentMille)
         + " ألاف ";
    }
    resultat =  resultat + tradCentMille;

    String tradMille;
    tradMille = convertLessThanOneThousand(lesMille);
    resultat =  resultat + tradMille;

    return resultat;
  }

  public static void main(String[] args) {
    System.out.println(" " + ArabicNumberToWords.convert(20*10*10*10*10*10*10*10));
	
    /*
     *** OUTPUT
     *** zéro
     *** neuf
     *** dix-neuf
     *** vingt et un
     *** vingt-huit
     *** soixante et onze
     *** soixante-douze
     *** quatre-vingt
     *** quatre-vingt-un
     *** quatre-vingt-neuf
     *** quatre-vingt-dix
     *** quatre-vingt-onze
     *** quatre-vingt-dix-sept
     *** cent
     *** cent un
     *** cent dix
     *** cent vingt
     *** deux cents
     *** deux cent un
     *** deux cent trente-deux
     *** neuf cent quatre-vingt-dix-neuf
     *** mille
     *** mille un
     *** dix mille
     *** dix mille un
     *** cent mille
     *** deux millions
     *** trois milliards
     *** deux milliards cent quarante-sept millions
     **          quatre cent quatre-vingt-trois mille six cent quarante-sept
     */
  }
}