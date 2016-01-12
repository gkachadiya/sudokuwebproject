package com.sudokuwebproject.rest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.sudokuwebproject.dto.SudokuBoard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SudokuTestContext.class})
@WebAppConfiguration
public class SudokuBoardControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private SudokuBoardController sudokuBoardController;
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Test
	public void checkSudokuBoardTest() throws Exception {
		SudokuBoard sudokuBoard = new SudokuBoard();
		sudokuBoard.setIndexI(1);
		sudokuBoard.setIndexJ(2);
		sudokuBoard.setNumber(12);
		sudokuBoard.setMessage("Test");
		sudokuBoard.setStatus("SUCCESS");
		sudokuBoard.setSudokuArray(null);
		
		when(sudokuBoardController.checkSudokuBoard(sudokuBoard)).thenReturn(sudokuBoard);
		
		mockMvc.perform(get("sudokuboard/values"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON_UTF8));
		
		verify(sudokuBoardController, times(1)).checkSudokuBoard(sudokuBoard);
        verifyNoMoreInteractions(sudokuBoardController);
	}

}
