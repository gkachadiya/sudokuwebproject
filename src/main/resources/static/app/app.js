var migModule = angular.module("sudokuManagerApp", [
                                  'ngResource']);
migModule.controller("sudokuManagerController", function ($scope, $http) {
	
	var urlBase="";
	$scope.statusFlag = false;
	
	$scope.updateSudoku = function updateSudoku() {
		
		var dataObj = {
				number : $scope.number,
				indexI : $scope.indexI,
				indexJ : $scope.indexJ,
				sudokuArray : $scope.sudokuArray
		};
		
		if($scope.number == ""){
			alert("Please provide sudoku number");
		}
		else{
		 $http.post(urlBase + '/sudokuboard/values',  dataObj).
         success(function(data, status, headers) {
        	 
        	 $scope.status = data.status;
        	 $scope.number = data.number;
        	 $scope.statusFlag = true;
			 console.log("Sudoku Value has been added"+JSON.stringify(data));
			 console.log("Status :"+$scope.status);
		    });
		}
	};
});
