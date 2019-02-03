package com.cft.shift.partysharing.partysharing.types;


public enum InterestType {
    SEX("Секс"),
    DRUGS("Наркотики"),
    ROCK_N_ROLL("Rock'n'roll"),
    AUTO("Автомобили"),
    BISNESS("Бизнес"),
    PARTIES("Вечеринки"),
    ART("Искусство"),
    HISTORY("История"),
    IT("IT и технологии"),
    FILMS("Кино"),
    MUSIC("Музыка"),
    SPORT("Спорт"),
    PHOTO("Фото"),
    HUMOR("Юмор");

    private String formattedName;

    InterestType(String formattedName) {
        this.formattedName = formattedName;
    }

    public static String [] getAllNames() {
        return new String[] {
                "Секс",
                "Наркотики",
                "Rock'n'roll",
                "Автомобили",
                "Бизнес",
                "Вечеринки",
                "Искусство",
                "IT и технологии",
                "Кино",
                "Музыка",
                "Спорт",
                "Фото",
                "Юмор"
        };
    }

}