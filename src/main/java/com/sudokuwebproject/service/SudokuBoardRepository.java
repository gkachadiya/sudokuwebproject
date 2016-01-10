package com.sudokuwebproject.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sudokuwebproject.domain.SudokuBoard;

@RepositoryRestResource(collectionResourceRel = "sudokus", path = "sudokus")
public interface SudokuBoardRepository extends CrudRepository<SudokuBoard, Integer> {

}