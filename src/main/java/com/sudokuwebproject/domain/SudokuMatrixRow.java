package com.sudokuwebproject.domain;

import java.util.List;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name="sudoku_board")
public class SudokuMatrixRow {

	@Id
    private long id;

    @ManyToOne
    private SudokuBoard sudokuBoard;

    @ElementCollection
    private List<BigDecimal> row;

 
}
