package Templates;


import InputInformation.Input;

public class Credit {
    private static final String[] templateCredit =
            {"СУММА_ДОЛГА",
                    "НОМЕР_ДОГОВОРА",
                    "ДАТА_ДОГОВОРА",
                    "ДАТА_ПОГАШЕНИЯ",
                    "ГОСПОШЛИНА",
                    "МИКРОЗАЙМ_НА_СУММУ",
                    "ЗАЙМ_НА_СУММУ_ЧИСЛОМ",
                    "ОСНОВНОЙ_ДОЛГ",
                    "ПРОЦЕНТ",
                    "ПРОЦЕНТ_ЧИСЛОМ"};
    private static String[] credit = Input.getCredit();

    public static String[] getTemplateCredit() {
        return templateCredit;
    }

    public static String[] getCredit() {
        return credit;
    }
}
