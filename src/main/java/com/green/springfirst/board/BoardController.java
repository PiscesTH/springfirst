package com.green.springfirst.board;

import com.green.springfirst.ResVo;
import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardInsDto;
import com.green.springfirst.board.model.BoardUpdDto;
import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @GetMapping("/board")
    public List<BoardVo> getBoard() {
        return service.getBoard();
    }

    @GetMapping("/board/{iboard}")
    public BoardDetailVo getBoardDetail(@PathVariable int iboard) { //@PathVariable (value = "iboard") int id >> 변수명 다르게 쓰고 싶을 때
        return service.getBoardDetail(iboard);
    }

    @PostMapping("/board")
    public ResVo insBoard(@RequestBody BoardInsDto dto) {
        int result = service.insBoardData(dto);
        return new ResVo(result);
    }

    @DeleteMapping("/board/{iboard}")
    public ResVo delBoard(@PathVariable int iboard) {
        int result = service.delBoard(iboard);
        return new ResVo(result);
    }
    @PutMapping("/board")
    public ResVo putBoard(@RequestBody BoardUpdDto dto){
        int result = service.putBoard(dto);
        return new ResVo(result);
    }
}

