package com.green.boardview;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardViewMapper {
    int writeBoard(BoardViewEntity entity);
    List<BoardViewEntity> selBoardAll();
    BoardViewEntity selBoardById(BoardViewEntity entity);
    int modBoard(BoardViewEntity entity);
    int delBoard(BoardViewEntity entity);
}
