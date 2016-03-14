// Controller for the add form
app.controller("AddController", ["$scope", "$routeParams", "predictions", "$location",
                              function($scope, $routeParams, predictions, $location) {
	// Loads the item data in the fields 
	// readonly is not being currently used but can be used to disable all fields in the form and hide the save button
	angular.forEach(predictions, function(item, index) {
		if (item.id == $routeParams.id) {
			$scope.prediction = item;
			$scope.action = 'Add New Prediction'
			$scope.readonly = 'false';
		}
	});

	// Adds the new item to the list and goes back to the list view
	$scope.submitForm = function() {
		if ($scope.predictionForm.$valid) {
			newId = predictions[predictions.length-1].id + 1;
			$scope.prediction.id = newId;
			predictions.push($scope.prediction);
			$location.path('/');
		} else {
			$scope.predictionForm.submitted = true;
		}
	}
}
])