package com.patika.healthtourism.model.enums;

public enum SpecializationEnum {
        CARDIOLOGY("Cardiology"),
        ORTHOPEDICS("Orthopedics"),
        DERMATOLOGY("Dermatology"),
        NEUROLOGY("Neurology"),
        Pulmonology("Pulmonology"),
        InternalMedicine("Internal Medicine"),
        Pediatrics("Pediatrics"),
        Ophthalmology("Ophthalmology"),
        Otorhinolaryngology("Otorhinolaryngology"),
        Surgery("Surgery"),
        Gynecology("Gynecology"),
        Urology("Urology"),
        Radiology("Radiology"),
        Psychiatry("Psychiatry"),
        Dentistry("Dentistry");

        private final String displayName;

        SpecializationEnum(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
}


