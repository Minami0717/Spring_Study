package com.green.boardview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardViewController {
    private final BoardViewService service;

    @Autowired
    public BoardViewController(BoardViewService service) {
        this.service = service;
    }

    @GetMapping("/write")
    public String writeBoard() {
        return "writeBoard";
    }

    @PostMapping("/write")
    public String writeBoard(Model model, BoardViewEntity entity) {
        service.writeBoard(entity);
        return selBoardAll(model);
    }

    @GetMapping
    public String selBoardAll(Model model) {
        model.addAttribute("boardList", service.selBoardAll());
        return "boardList";
    }

    @GetMapping("/{iboard}")
    public String boardDetail(@PathVariable int iboard, Model model) {
        model.addAttribute("board", service.selBoardById(setEntityById(iboard)));
        return "boardDetail";
    }

    @GetMapping("/modify/{iboard}")
    public String modBoard(@PathVariable int iboard, Model model) {
        model.addAttribute("board", service.selBoardById(setEntityById(iboard)));
        return "modifyBoard";
    }

    @PostMapping("/modify")
    public String modBoard(BoardViewEntity entity, Model model) {
        service.modBoard(entity);
        return boardDetail(entity.getIboard(), model);
    }

    @GetMapping("/delete/{iboard}")
    public String delBoard(@PathVariable int iboard, Model model) {
        service.delBoard(setEntityById(iboard));
        return selBoardAll(model);
    }

    public BoardViewEntity setEntityById(int iboard) {
        BoardViewEntity entity = new BoardViewEntity();
        entity.setIboard(iboard);
        return entity;
    }
}
