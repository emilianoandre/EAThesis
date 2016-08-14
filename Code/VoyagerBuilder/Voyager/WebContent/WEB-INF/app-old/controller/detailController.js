//Controller for the detail view
app.controller("DetailController", ["$scope", "$routeParams", '$sce', "predictions", "DataService", "$location",
                                    function($scope, $routeParams, $sce, predictions, dataService, $location) {

	// Loads the item data in the fields 
	// readonly is not being currently used but can be used to disable all fields in the form and hide the save button
	angular.forEach(predictions, function(item, index) {
		if (item.id == $routeParams.id) {
			$scope.action = 'Prediction Details for ' + item.name;
			dataService.getInfo(item.name)
			.then(
				function(data) {
					$scope.image = data.thumbnail;
					$scope.info = $sce.trustAsHtml(data.extract);
				},
				function(error) {
					$scope.error = error;
				}
			);
		}
	});
}
])

// Get the info from wiki
app.factory("DataService", ["$http", "$q", function($http, $q) {

	return {
		getInfo: function(name) {
			var defered = $q.defer();

			var url = 'http://en.wikipedia.org/w/api.php?titles=' + name + '&action=query&format=json&callback=JSON_CALLBACK&prop=extracts|pageimages&piprop=thumbnail&pithumbsize=200&rvparse';

			$http.jsonp(url).then(function(response) {
				var pages = response.data.query.pages;
				Object.keys(pages).forEach(function(page) {
					defered.resolve(pages[page]);
				});				
			}, function(response) {
				defered.reject(response.data)
			});

			return defered.promise;
		}
	};
}])