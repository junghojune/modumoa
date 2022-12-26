package com.hosu.project.modumoa.member.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostSignUpReqDto {

    @Email
    @NotBlank(message = "필수항목입니다.")
    private String email;

    @NotBlank(message = "필수항목입니다.")
    private String name;

    @Size(min = 8, max = 20, message = "비밀번호는 8 ~ 20자 사이입니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[#?!@$%^&*-]).{8,}$",
            message = "비밀번호 형식이 맞지 않습니다.")
    @NotBlank(message = "필수항목입니다.")
    private String password;

    private String birthday;

    private String phoneNumber;

    private boolean host = false;
}
