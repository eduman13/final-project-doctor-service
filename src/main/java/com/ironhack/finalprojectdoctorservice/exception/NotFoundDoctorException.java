package com.ironhack.finalprojectdoctorservice.exception;

public class NotFoundDoctorException extends  Exception {

    public NotFoundDoctorException(String errorMessage) {
        super(errorMessage);
    }
}
