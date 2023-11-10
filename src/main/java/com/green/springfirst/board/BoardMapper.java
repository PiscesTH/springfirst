package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardInsDto;
import com.green.springfirst.board.model.BoardUpdDto;
import com.green.springfirst.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //빈 등록
public interface BoardMapper {
    int insBoard(BoardInsDto dto);   //Mapper.xml 의 id 로 구분
    List<BoardVo> selBoardList();
    BoardDetailVo selBoardById(int iboard);
    int updBoard(BoardUpdDto dto);
    int delBoard(int iboard);
}

