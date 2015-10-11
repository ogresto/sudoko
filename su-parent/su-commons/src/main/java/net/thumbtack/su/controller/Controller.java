package net.thumbtack.su.controller;

import net.thumbtack.su.entity.Board;
import net.thumbtack.su.entity.MoveResult;
import net.thumbtack.su.exception.SudokuException;
import net.thumbtack.su.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    MainService mainService;

    @RequestMapping("/")
    public String welcomeScreen() {
        return "Hello Sudokuer!";
    }

    @RequestMapping(value = "board", method = RequestMethod.GET)
    public Board getBoard() {
        return mainService.get();
    }

    @RequestMapping(value = "/validatemove", method = RequestMethod.POST)
    public MoveResult validateMove(@RequestParam("id") long id,
                                   @RequestParam("x") int x,
                                   @RequestParam("y") int y,
                                   @RequestParam("value") int value) throws SudokuException {
        return mainService.validateMove(id, x, y, value);
    }

    @ExceptionHandler(SudokuException.class)
    public ResponseEntity<Exception> handleException(
            SudokuException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception);

    }
}

