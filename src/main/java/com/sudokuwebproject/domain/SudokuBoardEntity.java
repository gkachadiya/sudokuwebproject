package com.sudokuwebproject.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="sudoku_board")
public class SudokuBoardEntity {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  @OneToMany(mappedBy="sudokuBoard")
  private List<SudokuMatrixRowEntity> sudokuMatrixRow;
  
  @Column
  private int index;
  
  @Column
  private int number;
  
  @Column
  private String status;
  
  @Column
  private String message;

  public int getId() {
    return id;
  }

  public List<SudokuMatrixRowEntity> getSudokuMatrixRow() {
	return sudokuMatrixRow;
}

public void setSudokuMatrixRow(List<SudokuMatrixRowEntity> sudokuMatrixRow) {
	this.sudokuMatrixRow = sudokuMatrixRow;
}

public void setId(int id) {
    this.id = id;
  }

public int getIndex() {
	return index;
}

public int getNumber() {
	return number;
}

public String getStatus() {
	return status;
}

public String getMessage() {
	return message;
}

public void setIndex(int index) {
	this.index = index;
}

public void setNumber(int number) {
	this.number = number;
}

public void setStatus(String status) {
	this.status = status;
}

public void setMessage(String message) {
	this.message = message;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + index;
	result = prime * result + ((message == null) ? 0 : message.hashCode());
	result = prime * result + number;
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((sudokuMatrixRow == null) ? 0 : sudokuMatrixRow.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SudokuBoardEntity other = (SudokuBoardEntity) obj;
	if (id != other.id)
		return false;
	if (index != other.index)
		return false;
	if (message == null) {
		if (other.message != null)
			return false;
	} else if (!message.equals(other.message))
		return false;
	if (number != other.number)
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (sudokuMatrixRow == null) {
		if (other.sudokuMatrixRow != null)
			return false;
	} else if (!sudokuMatrixRow.equals(other.sudokuMatrixRow))
		return false;
	return true;
}

}
