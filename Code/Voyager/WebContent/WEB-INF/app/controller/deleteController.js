//Controller for the delete action
app.controller("DeleteController", ["$scope", "$routeParams", "predictions", "$location",
                                    function($scope, $routeParams, predictions, $location) {
	
	// Look for the selected item and remove it from the list
	angular.forEach(predictions, function(item, index) {
		if (item.id == $routeParams.id) {
			predictions.splice(index, 1);
			$location.path('/');
		}
	});

}
])