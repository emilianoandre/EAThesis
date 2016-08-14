// Controller for the list view
app.controller("ListController", ["$scope", "predictions", "filterService", "$location",
                                  function($scope, predictions, filterService, $location) {
	// Initialize the predictions list
	$scope.predictions = predictions;

	// Filter method
	$scope.filter = function() {
		filterService.setFiltered(true);
		$scope.filteredPredictions = [];
		
		if ($scope.nameFilter)
			filterService.setFilterName($scope.nameFilter);
		
		if ($scope.familyFilter)
			filterService.setFilterFamily($scope.familyFilter);
		
		if ($scope.seasonFilter)
			filterService.setFilterSeason($scope.seasonFilter);
		
		if ($scope.episodeFilter)
			filterService.setFilterEpisode($scope.episodeFilter);
		
		// Iterate through the prediction list and filter using the defined values
		angular.forEach(predictions, function(item, index) {
			if ((!filterService.getFilterName() || filterService.getFilterName().trim().toUpperCase() == item.name.trim().toUpperCase()) && 
					(!filterService.getFilterFamily() || filterService.getFilterFamily().trim().toUpperCase() == item.family.trim().toUpperCase()) &&
					(!filterService.getFilterSeason() || filterService.getFilterSeason() == item.season) &&
					(!filterService.getFilterEpisode() || filterService.getFilterEpisode() == item.episode)) {
				$scope.filteredPredictions.push(item);
			}
		});
	}
	
	// Fills the filter fields with the correct data after changing screens
	$scope.fillFilter = function() {
		$scope.nameFilter = filterService.getFilterName();
		$scope.familyFilter  = filterService.getFilterFamily();
		$scope.seasonFilter = filterService.getFilterSeason();
		$scope.episodeFilter = filterService.getFilterEpisode();
	}

	// Clear the filter and display the full list
	$scope.clearFilter = function() {		
		// Clean the filter fields in the filterService
		filterService.setFiltered(true);
		filterService.setFilterName("");
		filterService.setFilterFamily("");
		filterService.setFilterSeason("");
		filterService.setFilterEpisode("");
		
		// Fill the values in the fields
		$scope.fillFilter();
		
		$scope.filteredPredictions = predictions;
	}		

	if (!filterService.getFiltered()) {
		// When no filter has been applied load the original list
		$scope.filteredPredictions = predictions;	
	} else {
		// In case the filter has been applied add the filter to the list
		$scope.fillFilter();
		$scope.filter();
	}

}
])