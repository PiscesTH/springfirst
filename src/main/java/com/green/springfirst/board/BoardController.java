package com.green.springfirst.board;

import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller : 백엔드에서 화면 만들 때 사용 ?
@RestController     // JSON 리턴 할 때 사용
@RequiredArgsConstructor    //빈 등록 : 객체생성 스프링 컨테이너가 함. 싱글톤으로 만들어줌
public class BoardController {
//  @Autowired : 빈 등록 된 것들 중에서 찾아서 주소값 받아옴. 대신 들어올 수 있는게 유일해야 한다.
    private final BoardService service; //주소값 받을 수 있으면 받아다준다 ?

    @GetMapping("/board")
    public List<BoardVo> getBoard(){
        return service.getBoard();
    }
}
