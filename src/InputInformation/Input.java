package InputInformation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static String fullName = "Андрусенко Павел Викторович";
//    private String[] credit =
//            {"49627,23 рублей (сорок девять тысяч шестьсот двадцать семь руб 23 коп)",
//                    "844,41 рублей (восемьсот сорок четыре  руб 41 коп) ",
//                    "24000,00 (двадцать четыре тысячи рублей 00 копеек) ",
//                    "24000,00",
//                    "50471,64 рублей (пятьдесят тысяч четыреста семьдесят один руб 64 коп) ",
//                    "25627,23 (двадцать пять тысяч шестьсот двадцать семь руб 23 коп) ",
//                    "25627,23"};
    private static String amountDue = "49627,23 рублей (сорок девять тысяч шестьсот двадцать семь руб 23 коп)";
    private static String contractNumber = "НЧ00092-200/2014 ";
    private static String contractDate = "23.02.2014 ";
    private static String maturityDate = "25.03.14 ";
    private static String tax = "844,41 рублей (восемьсот сорок четыре  руб 41 коп) ";
    private static String creditSum = "24000,00 (двадцать четыре тысячи рублей 00 копеек) ";
    private static String creditSumNumber = returnOnlyNumbers(creditSum);
    private static String mainAmountDue = "50471,64 рублей (пятьдесят тысяч четыреста семьдесят один руб 64 коп) ";
    private static String percent = "25627,23 (двадцать пять тысяч шестьсот двадцать семь руб 23 коп) ";
    private static String percentNumber = returnOnlyNumbers(percent);

    //    {"МЕСТО_ДАТА_РОЖДЕНИЯ",
//            "СЕРИЯ_ПАСП",
//            "НОМЕР_ПАСП",
//            "ВЫДАН_ПАСП",
//            "ЗАРЕГИСТРИРОВАН_И_ПРОЖИВАЕТ"};
    private static String birthInfo = "с.Уйское Уйского района Челябинской области 14.09.1986 г.р.";
    private static String passpSerial = "75 05 ";
    private static String passpNumber = "906810 ";
    private static String passpIssued = "04.10.2006 Уйским РОВД Челябинской области ";
    private static String registeredAndLive = "Челябинская обл., с.Уйское, ул.Советская,д. 42 ";

    public static String returnOnlyNumbers(String fullString) {
        return fullString.substring(0, fullString.indexOf(" "));
    }

    public String[] returnFullName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().split(" ");
    }

    public static String getFullName() {
        return fullName;
    }

    public static String[] getCredit() {
         String [] credit =
            {amountDue,
                    contractNumber,
                    contractDate,
                    maturityDate,
                    tax,
                    creditSum,
                    creditSumNumber,
                    mainAmountDue,
                    percent,
                    percentNumber};
        return credit;
    }

    public static String[] getPassportInfo() {
        String[] passportInfo =
                {birthInfo,
                        passpSerial,
                        passpNumber,
                        passpIssued,
                        registeredAndLive};
        return passportInfo;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public String getTax() {
        return tax;
    }

    public String getCreditSum() {
        return creditSum;
    }

    public String getCreditSumNumbers() {
        return creditSumNumber;
    }

    public String getMainAmountDue() {
        return mainAmountDue;
    }

    public String getPercent() {
        return percent;
    }
}