package com.green.boardview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardViewService {
    private final BoardViewMapper mapper;

    @Autowired
    public BoardViewService(BoardViewMapper mapper) {
        this.mapper = mapper;
    }

    public int writeBoard(BoardViewEntity entity) {
        return mapper.writeBoard(entity);
    }

    public List<BoardViewEntity> selBoardAll() {
        return mapper.selBoardAll();
    }

    public BoardViewEntity selBoardById(BoardViewEntity entity) {
        return mapper.selBoardById(entity);
    }

    public int modBoard(BoardViewEntity entity) {
        return mapper.modBoard(entity);
    }

    public int delBoard(BoardViewEntity entity) {
        return mapper.delBoard(entity);
    }
}
