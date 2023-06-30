package ityeji.hello.spring4.dao;

import ityeji.hello.spring4.model.Board;

import java.util.List;

public interface BoardDAO {
    List<Board> selectBoard(int snum);
}
