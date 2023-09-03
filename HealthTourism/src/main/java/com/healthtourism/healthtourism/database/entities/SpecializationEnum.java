package com.healthtourism.healthtourism.database.entities;

public enum SpecializationEnum {
    CARDIOLOGY ("CARDIOLOGY"),
    DERMATOLOGY("DERMATOLOGY"),
    NEUROLOGY("NEUROLOGY"),
    UROLOGY("UROLOGY"),
    GASTROENTEROLOGY("GASTROENTEROLOGY"),
    ENDOCRINOLOGY("ENDOCRINOLOGY");
    private final String value;

    SpecializationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
