var migModule = angular.module("sudokuManagerApp", [
                                  'ngResource']);
migModule.factory('Sudoku', function($resource){
	return $resource(":username/notes",{username: '@username'});
}) 

migModule.controller("sudokuManagerController", function($scope, Sudoku) {
	
	var url = function() {
		return {username: 'Rakesh'};
	}
    
	var sudokuArray = Sudoku.query(url());
	console.log(sudokuArray);
});

