package com.hosu.project.modumoa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 유저 관련 ErrorCode
    DUPLICATED_USERNAME(BAD_REQUEST, "중복된 email 입니다."),
    NOT_MATCH_INFORMATION(BAD_REQUEST, "회원정보가 일치하지 않습니다."),
    INVALID_FORMAT(BAD_REQUEST, "email, password의 형식이 올바르지 않습니다."),
    NOT_FOUND_USER(BAD_REQUEST, "회원을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
