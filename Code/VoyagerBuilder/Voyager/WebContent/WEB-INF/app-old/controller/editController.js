// Controller for the edit view
app.controller("EditController", ["$scope", "$routeParams", "predictions", "$location",
                                    function($scope, $routeParams, predictions, $location) {
	
	// Loads the item data in the fields 
	// readonly is not being currently used but can be used to disable all fields in the form and hide the save button
	angular.forEach(predictions, function(item, index) {
		if (item.id == $routeParams.id) {
			$scope.prediction = item;
			$scope.action = 'Edit Prediction'
			$scope.readonly = 'false';
		}
	});

	// Saves the changes done to the prediction and goes back to the list view
	$scope.submitForm = function() {
		angular.forEach(predictions, function(item, index) {
			if (item.id == $routeParams.id) {
				predictions[index] = $scope.prediction;
				$location.path('/');
			}
		});
	}
}
])