package com.green.springfirst.board;

import com.green.springfirst.ResVo;
import com.green.springfirst.board.model.BoardDetailVo;
import com.green.springfirst.board.model.BoardInsDto;
import com.green.springfirst.board.model.BoardUpdDto;
import com.green.springfirst.board.model.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller : 백엔드에서 화면 만들 때 사용 ? 요청에 응답할 수 있음. 기본값 HTML
@RestController     // JSON 리턴 할 때 사용. 응답할 수 있음. 기본값 JSON
//빈 등록 : 객체생성 스프링 컨테이너가 함. 기본적으로 싱글톤으로 만들어줌.
//클래스 위에 annotation 줘서 빈 등록 할 수 있음.  주소값 저장 & 전달.
@RequiredArgsConstructor
public class BoardController {      //로직 작업 X. 서비스를 호출하는 역할
    //  @Autowired : 빈 등록 된 것들 중에서 찾아서 주소값 받아옴. 대신 들어올 수 있는게 유일해야 한다.
    private final BoardService service; //주소값 받을 수 있으면 받아다준다 ?

    @GetMapping("/board") //get 요청받고 응답. 주소값이 같아도 요청에 따라 분기됨.
    public List<BoardVo> getBoard() {
        return service.getBoard();
    }

    @GetMapping("/board/{iboard}")
    public BoardDetailVo getBoardDetail(@PathVariable int iboard) { //@PathVariable (value = "iboard") int id >> 변수명 다르게 쓰고 싶을 때
        return service.getBoardDetail(iboard);
    }

    @PostMapping("/board") //post 요청받고 응답
    //@ResponseBody  //@Controller 였으면 이걸 사용해야함. HTML로 받은 데이터 JSON으로 바꿔주는..?
    public ResVo insBoard(@RequestBody BoardInsDto dto) { //JSON으로 받은 데이터 객체로 사용 ?
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
/*
<http - method 통신 메소드>
C - Insert - post : body에 데이터 담아서 요청
R - Select - get(multiple) : Query String 사용(필수) >> /board
             get(single)   :  경로 지정 >>/board/1 (Path Variable)
U - Update - put/patch : body에 데이터 담아서 요청
D - Delete - delete : Query String 사용
Query String : 글자 수 제한 존재.  ?~~ 형태
*/
