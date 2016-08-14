//Service that contains the filtering logic and methods
app.service("filterService", function() {
	
	var filtered = false;
	var filterName;
	var filterFamily;
	var filterSeason;
	var filterEpisode;

	// Getters and Setters
	this.setFiltered = function(filterApplied) {
		filtered = filterApplied;
	};
	
	this.getFiltered = function() {
		return filtered;
	};
	
	this.setFilterName = function(name) {
		filterName = name;
	};
	
	this.getFilterName = function() {
		return filterName;
	};
	
	this.setFilterFamily = function(family) {
		filterFamily = family;
	};
	
	this.getFilterFamily = function() {
		return filterFamily;
	};
	
	this.setFilterSeason = function(season) {
		filterSeason = season;
	};
	
	this.getFilterSeason = function() {
		return filterSeason;
	};
	
	this.setFilterEpisode = function(episode) {
		filterEpisode = episode;
	};
	
	this.getFilterEpisode = function() {
		return filterEpisode;
	};
})