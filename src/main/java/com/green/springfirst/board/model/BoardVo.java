package com.green.springfirst.board.model;

import lombok.Getter;
import lombok.Setter;

@Getter //getter 메서드 자동 생성
@Setter //setter 메서드 자동 생성
public class BoardVo {
    private int iboard;
    private String title;
    private String writer;
    private String createdAt;
}
