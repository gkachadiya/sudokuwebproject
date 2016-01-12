package com.sudokuwebproject.dto;

import java.util.Arrays;

public class SudokuBoard {
	
	private int[][] sudokuArray;
	private int number;
	private int indexI;
	private int indexJ;
	private String message;
	private String status;

	public int[][] getSudokuArray() {
		return sudokuArray;
	}

	public void setSudokuArray(int[][] sudokuArray) {
		this.sudokuArray = sudokuArray;
	}

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getIndexI() {
		return indexI;
	}

	public int getIndexJ() {
		return indexJ;
	}

	public void setIndexI(int indexI) {
		this.indexI = indexI;
	}

	public void setIndexJ(int indexJ) {
		this.indexJ = indexJ;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + indexI;
		result = prime * result + indexJ;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + number;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + Arrays.deepHashCode(sudokuArray);
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
		SudokuBoard other = (SudokuBoard) obj;
		if (indexI != other.indexI)
			return false;
		if (indexJ != other.indexJ)
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
		if (!Arrays.deepEquals(sudokuArray, other.sudokuArray))
			return false;
		return true;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
