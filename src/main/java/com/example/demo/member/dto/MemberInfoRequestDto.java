package com.example.demo.member.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberInfoRequestDto {
    @Schema(description = "유저의 닉네임", example = "고기닭고기")
    private String nickname;

}
