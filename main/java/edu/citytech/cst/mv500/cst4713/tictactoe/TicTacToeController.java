package edu.citytech.cst.mv500.cst4713.tictactoe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicTacToeController {

    @RequestMapping("/tictactoe")
    public String tictactoe() {
        return "TicTacToe.jsp";
    }
}
