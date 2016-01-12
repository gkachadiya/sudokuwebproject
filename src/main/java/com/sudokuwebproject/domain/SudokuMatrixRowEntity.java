package com.sudokuwebproject.domain;

import java.util.List;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="sudoku_board")
public class SudokuMatrixRowEntity {

	@Id
    private long id;

    @ManyToOne
    private SudokuBoardEntity sudokuBoard;

    @ElementCollection
    private List<BigDecimal> row;

 
}
