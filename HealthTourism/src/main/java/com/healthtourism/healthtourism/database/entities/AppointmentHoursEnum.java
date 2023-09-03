package com.healthtourism.healthtourism.database.entities;

public enum AppointmentHoursEnum {
    NINE_TO_TEN("NINE_TO_TEN"),
    TEN_TO_ELEVEN("TEN_TO_ELEVEN"),
    ELEVEN_TO_TWELVE(" ELEVEN_TO_TWELVE"),
    TWELVE_TO_FOUR(" TWELVE_TO_FOUR");

    private final String value;

    AppointmentHoursEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}