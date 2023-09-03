package com.tourismcorp.healthtourism.exceptions;

public class EntityNotFoundByUUID extends RuntimeException{
    public EntityNotFoundByUUID() {
        super("Entity not found.");
    }
}
