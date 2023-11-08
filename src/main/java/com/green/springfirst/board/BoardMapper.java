package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //빈 등록
public interface BoardMapper {
    List<BoardVo> selBoardList();  //Mapper.xml 의 id 로 구분
    BoardDetailVo selBoardById(int iboard);
}
