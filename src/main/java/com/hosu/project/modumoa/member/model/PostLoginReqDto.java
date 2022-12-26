package com.hosu.project.modumoa.member.model;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PostLoginReqDto {

    private String email;
    private String password;
}
