/**
 * 
 * @author: EAndre
 * Log in and Log out controllers
 * 
 */
angular.module('controllers', []).controller('loginController', ["$scope", "$window", "$http", 'sharedProperties', function($scope, $window, $http, sharedProperties) {

	$scope.submitFunction = function() {

		var username = $scope.userName;
		var password = $scope.password;

		//Try to log in to account
		$http({method: "POST", url: '../voyager/Login/login',
			headers: {'Content-Type': 'application/json', 'userName': username, 'password': password},
			data: {'userName': username, 'password': password}
		}).success(function(data, status, headers, config) {
			$window.location.href = "dashboard.html";

		}).error(function(data, status, headers, config) {
			$window.alert("Wrong username/password. Please try again");
		});
	}
}]).controller('logoutController', ["$scope", "$window", "$http", function($scope, $window, $http) {

	$scope.makeLogoutCall = function() {

		$http({method: "GET", url: '../voyager/Login/logout',
		}).success(function(data, status, headers, config) {
			$window.location.href = "index.html";
		}).
		error(function(data, status, headers, config) {
			$window.alert("Log out error");
		});
	}
}]).controller('loginModalController', function ($scope) {

	this.cancel = $scope.$dismiss;

	this.submit = function (email, password) {
		loginController.submitFunction(email, password).then(function (user) {
			$scope.$close(user);
		});
	};

});
