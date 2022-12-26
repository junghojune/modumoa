package com.hosu.project.modumoa.exception;

public class AlreadyRegisteredUserException extends Throwable {
    public AlreadyRegisteredUserException(String message) {
        super(message);
    }

    public AlreadyRegisteredUserException() {
        super("이미 등록되어 있는 유저입니다.");
    }
}
