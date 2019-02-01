package com.cft.shift.partysharing.partysharing.types;

public enum InterestType {
    SEX("Секс"),
    DRUGS("Наркотики"),
    ROCK_N_ROLL("Rock'n'roll");

    private String formattedName;

    InterestType(String formattedName) {
        this.formattedName = formattedName;
    }

    public static String [] getNames() {
        return new String[] {
                "SEX",
                "DRUGS",
                "ROCK_N_ROLL"
        };
    }
}