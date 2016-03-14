//Creating the app
var app = angular.module("gotApp", ["ngRoute"])

//Adding the global variables, view constants and routing logic
app.value("predictions", [{
	id: 0,
	name: 'Ned Stark',
	family: 'Stark',
	season: 1,
	episode: 9
}, {
	id: 1,
	name: 'Sansa Stark',
	family: 'Stark',
	season: 2,
	episode: 1
}, {
	id: 2,
	name: 'Tyrion Lannister',
	family: 'Lannister',
	season: 7,
	episode: 6
}])
.constant("VIEWS", {
	listView: "app/view/listView.html",
	formView: "app/view/formView.html",
	homeView: "app/view/homeView.html",
	detailView: "app/view/detailView.html"
}).config(["$routeProvider", "VIEWS", function($routeProvider, VIEWS) {
	$routeProvider.when("/", {
		controller: "ListController",
		templateUrl: VIEWS.listView
	}).when("/edit/:id", {
		controller: "EditController",
		templateUrl: VIEWS.formView
	}).when("/delete/:id", {
		controller: "DeleteController",
		templateUrl: VIEWS.listView
	}).when("/add", {
		controller: "AddController",
		templateUrl: VIEWS.formView
	}).when("/home", {              
		templateUrl: VIEWS.homeView
	}).when("/detail/:id", {
		controller: "DetailController",
		templateUrl: VIEWS.detailView
	}).otherwise({
		redirectTo: "/"
	});	
}])