package Templates;

import InputInformation.Input;

public class Name {
    private static String fullName = Input.getFullName();
    private static String shortName = getShortName(fullName);
    private static String genitiveName = genitive(fullName);

    private static final String[] templateName = {"МУЖЧИНА",
            "МУЖЧИНЫ",
            "МУЖ"};

    private static String[] name =
            {fullName + " ",
                    genitiveName + " ",
                    shortName + " "};

    /**
     * Получаем ФИО человека, типа Петров В А
     */
    public static String getShortName(String fullName) {
        StringBuilder shortName = new StringBuilder();
        String[] fullNameList = fullName.split(" ");

        for (int i = 0; i < fullNameList.length; i++) {
            if (i == 0) {
                String surname = fullNameList[0];
                // сли фамилия заканчивается на О, значит так и оставляем
                if (surname.substring(surname.length() - 1, surname.length()).equalsIgnoreCase("о")) {
                    shortName.append(surname.substring(0, surname.length()));
                } else {
                    shortName.append(surname.substring(0, surname.length()) + "а");
                }
            } else {
                shortName.append(" " + fullNameList[i].substring(0, 1));
            }
        }
        return shortName.toString();
    }

    /**
     * Получаем полное ФИО в Родительном Падеже
     *
     * @param fullName - полное Фамилия Имя Отчество в Именительном падеже
     * @return - полное Фамилия Имя Отчество в Родительном Падеже
     */
    public static String genitive(String fullName) {
        // Петренко Андрея(й) Борисовича
        // Иванова Ивана Кирилловича
        StringBuilder genitiveName = new StringBuilder();
        String[] splittedName = fullName.split(" ");
        String surname = splittedName[0];
        String name = splittedName[1];
        String patronymic = splittedName[2];

        if (surname.substring(surname.length() - 1, surname.length()).equalsIgnoreCase("о")) {
            genitiveName.append(surname);
        } else {
            genitiveName.append(surname + "а");
        }

        if (name.substring(name.length() - 1, name.length()).equalsIgnoreCase("й")) {
            genitiveName.append(" " + name.substring(0, name.length() - 1) + "я");
        } else {
            genitiveName.append(" " + name + "а");
        }

        genitiveName.append(" " + patronymic + "а");

        return genitiveName.toString();
    }

    public static String[] getTemplateName() {
        return templateName;
    }

    public static String[] getName() {
        return name;
    }
}