package com.cft.shift.partysharing.partysharing.features.profile.domain.model;

public enum InterestType {
    SEX("Секс"),
    DRUGS("Наркотики"),
    ROCK_N_ROLL("Rock'n'roll");

    private String formattedName;

    InterestType(String formattedName) {
        this.formattedName = formattedName;
    }
}