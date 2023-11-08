package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardInsDto;
import com.green.springfirst.board.model.BoardUpdDto;
import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service    //빈 등록
@RequiredArgsConstructor // 생성자 만들어줌.
public class BoardService {     //로직 담당.
    private final BoardMapper mapper;

    public int insBoardData(BoardInsDto dto) {
        return mapper.insBoard(dto);
    }

    public List<BoardVo> getBoard() {
        return mapper.selBoardList();
    }

    public BoardDetailVo getBoardDetail(int iboard) {
        return mapper.selBoardById(iboard);
    }

    public int delBoard(int iboard) {
        return mapper.delBoard(iboard);
    }

    public int putBoard(BoardUpdDto dto) {
        return mapper.updBoard(dto);
    }
}
