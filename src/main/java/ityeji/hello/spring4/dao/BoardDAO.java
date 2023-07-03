package ityeji.hello.spring4.dao;

import ityeji.hello.spring4.model.Board;

import java.util.List;

public interface BoardDAO {
    List<Board> selectBoard(int snum);
    Board selectOneBoard(String bno);

    int insertBoard(Board bd);      /* 함수를 쓰는 장점, 여러개를 넘길수 있고 캡슐화 가능 */
}
