package com.leoncarraro.realmeetservice.exception;

public class RoomNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 3799479127935428322L;

    public RoomNotFoundException(String message) {
        super(message);
    }
}
