package com.testfolder.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty(message = "ユーザー名を入力してください。")
    private String username;
    @NotEmpty(message = "パスワードを入力してください。")
    @Size(min = 6, max = 10, message = "パスワードは６文字以上１０文字以下を入力してください。")
    private String password;
}