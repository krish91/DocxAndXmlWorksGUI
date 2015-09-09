package Templates;

import InputInformation.Input;

public class RegistrationInfo {
    private static final String[] templatePassportInfo =
            {"МЕСТО_ДАТА_РОЖДЕНИЯ",
                    "СЕРИЯ_ПАСП",
                    "НОМЕР_ПАСП",
                    "ВЫДАН_ПАСП",
                    "ЗАРЕГИСТРИРОВАН_И_ПРОЖИВАЕТ"};

    private static String[] passportInfo = Input.getPassportInfo();

    public static String[] getTemplatePassportInfo() {
        return templatePassportInfo;
    }

    public static String[] getPassportInfo() {
        return passportInfo;
    }
}
