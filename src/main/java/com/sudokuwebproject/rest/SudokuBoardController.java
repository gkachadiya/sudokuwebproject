package com.sudokuwebproject.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudokuwebproject.domain.SudokuBoard;

@RestController
public class SudokuBoardController {
	
	final static Logger logger = Logger.getLogger(SudokuBoardController.class);
	
	@RequestMapping(value="sudokuboard/values", method=RequestMethod.GET)
	public @ResponseBody List<SudokuBoard> checkSudokuBoard(@RequestParam("sudokuArray") String username, 
			@RequestParam("index") int index,
			@RequestParam("number") int number) {
		logger.info("SudokuBoardController [checkSudokuBoard]");
		
		String message = "Success";
		if(number < 1 || number > 9){
			message = "Error: Wrong number Entered";
		}
		
		List<SudokuBoard> sudokuBoards = new ArrayList<SudokuBoard>();
		
		SudokuBoard sudokuBoard = new SudokuBoard();
		sudokuBoard.setId(1);
		sudokuBoard.setIndex(index);
		sudokuBoard.setNumber(number);
		sudokuBoard.setMessage(message);
		
		sudokuBoards.add(sudokuBoard);
		return sudokuBoards;
	}
	
	
}
