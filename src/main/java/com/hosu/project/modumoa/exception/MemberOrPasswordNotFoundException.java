package com.hosu.project.modumoa.exception;

public class MemberOrPasswordNotFoundException extends Throwable {
    public MemberOrPasswordNotFoundException(String message){
        super(message);
    }

    public MemberOrPasswordNotFoundException(){
        super("회원정보가 없거나 정보가 일치하지 않습니다.");
    }
}
