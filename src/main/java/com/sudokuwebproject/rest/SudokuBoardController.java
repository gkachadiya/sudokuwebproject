package com.sudokuwebproject.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudokuwebproject.domain.SudokuBoardEntity;
import com.sudokuwebproject.dto.SudokuBoard;

@RestController
public class SudokuBoardController {
	
	final static Logger logger = Logger.getLogger(SudokuBoardController.class);
	
	@RequestMapping(value="sudokuboard/test", method=RequestMethod.GET)
	public @ResponseBody List<SudokuBoardEntity> checkSudokuBoardTest(@RequestParam("sudokuBoard") SudokuBoard sudokuBoard, 
			@RequestParam("index") int index,
			@RequestParam("number") int number) {
		logger.info("SudokuBoardController [checkSudokuBoard]");
		
		String message = "Success";
		if(number < 1 || number > 9){
			message = "Error: Wrong number Entered";
		}
		
		List<SudokuBoardEntity> sudokuBoards = new ArrayList<SudokuBoardEntity>();
		
		SudokuBoardEntity sudokuBoardEntity = new SudokuBoardEntity();
		sudokuBoardEntity.setId(1);
		sudokuBoardEntity.setIndex(index);
		sudokuBoardEntity.setNumber(number);
		sudokuBoardEntity.setMessage(message);
		
		sudokuBoards.add(sudokuBoardEntity);
		return sudokuBoards;
	}
	
	/**
	 * Method take SudokuBoard as a JSON object.
	 * @param sudokuBoard
	 * @return
	 */
	@RequestMapping(value="sudokuboard/values", method=RequestMethod.POST, produces={"application/xml", "application/json"})
	public @ResponseBody SudokuBoard checkSudokuBoard(@RequestBody SudokuBoard sudokuBoard) {
		logger.info("SudokuBoardController [checkSudokuBoard]");
		logger.info("Number :"+ sudokuBoard);
		
		String message = "";
		String status = "";
		if(sudokuBoard.getNumber() < 1 || sudokuBoard.getNumber() > 9){
			message = "Error: Wrong number Entered";
			status = "FAILURE";
			
			sudokuBoard.setMessage(message);
			sudokuBoard.setStatus(status);
			return sudokuBoard;
		}
		
		int[][] sudokuArray = sudokuBoard.getSudokuArray();
		if(sudokuArray == null || sudokuArray.length != 81){
			message = "Invalid Sudoku Syntax, It should be 81 size";
			status = "FAILURE";
			
			sudokuBoard.setMessage(message);
			sudokuBoard.setStatus(status);
			return sudokuBoard;
		}
		
		if(!isValidSudoku(sudokuArray)){
			message = "Sudoku Syntax, It is not finished yet";
			status = "INCOMPLETE";
			
			sudokuBoard.setMessage(message);
			sudokuBoard.setStatus(status);
		} else {
			message = "The Sudoku Game is funished successfully";
			status = "SUCCESS";
			
			sudokuBoard.setMessage(message);
			sudokuBoard.setStatus(status);
		}
		
		return sudokuBoard;
	}
	
	/**
	 * The method return true, if the number is matching to sudoku rules.
	 * @param sudokuArray
	 * @return
	 */
	private boolean isValidSudoku(int[][] sudokuArray) {
		
		boolean flag = true;
		for (int row = 0; row <= 8; row++) {
			int count = 0;
			for (int column = 0; column <= 8; column++) {
				count = count + sudokuArray[row][column];
	                // SUDOKU LOGIC
	        }
			if(count != 45){
				flag = false;
				break;
			}
	     }
		
		for (int row = 0; row <= 8; row++) {
			int count = 0;
			for (int column = 0; column <= 8; column++) {
				count = count + sudokuArray[column][row];
	                // SUDOKU LOGIC
	        }
			if(count != 45){
				flag = false;
				break;
			}
	     }
		return flag;
	}
}
