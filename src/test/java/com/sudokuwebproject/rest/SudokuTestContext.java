package com.sudokuwebproject.rest;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SudokuTestContext {
	
	@Bean
    public SudokuBoardController todoService() {
        return Mockito.mock(SudokuBoardController.class);
    }

}
