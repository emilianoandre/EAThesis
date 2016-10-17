var myApp = angular.module('voyager', ["ui.router", "ui.bootstrap", "services", "controllers"]);

myApp.service('sharedProperties', function() {
	var apiKey = "";
	var apiSecret = "";
	var encodedAuth = "";
	var oauthToken = "";
	var userName = "";

	return {
		getApiKey: function() {
			return apiKey;
		},
		setApiKey: function(value) {
			apiKey = value;
		},
		getApiSecret: function() {
			return apiSecret;
		},
		setApiSecret: function(value) {
			apiSecret = value;
		},
		getEncodedAuth: function() {
			return encodedAuth;
		},
		setEncodedAuth: function(value) {
			encodedAuth = value;
		},
		getOauthToken: function() {
			return oauthToken;
		},
		setOauthToken: function(value) {
			oauthToken = value;
		},
		getUsername: function() {
			return userName;
		},
		setUsername: function(value) {
			userName = value;
		}
	};
});

myApp.run(function ($rootScope, $state, loginModalService) {

	  $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
	    var requireLogin = toState.data.requireLogin;

	    if (requireLogin && typeof $rootScope.currentUser === 'undefined') {
	      event.preventDefault();

	      loginModalService()
	        .then(function () {
	          return $state.go(toState.name, toParams);
	        })
	        .catch(function () {
	          return $state.go('welcome');
	        });
	    }
	  });

	});

myApp.config(function ($httpProvider) {

	  $httpProvider.interceptors.push(function ($timeout, $q, $injector) {
	    var loginModal, $http, $state;

	    // this trick must be done so that we don't receive
	    // `Uncaught Error: [$injector:cdep] Circular dependency found`
	    $timeout(function () {
	    	loginModalService = $injector.get('loginModalService');
	      $http = $injector.get('$http');
	      $state = $injector.get('$state');
	    });

	    return {
	      responseError: function (rejection) {
	        if (rejection.status !== 401) {
	          return rejection;
	        }

	        var deferred = $q.defer();

	        loginModalService()
	          .then(function () {
	            deferred.resolve( $http(rejection.config) );
	          })
	          .catch(function () {
	            $state.go('welcome');
	            deferred.reject(rejection);
	          });

	        return deferred.promise;
	      }
	    };
	  });

	});