// loginModalService.js

angular.module('services',['ui.bootstrap']).service("loginModalService", function ($uibModal, $rootScope) {

	  function assignCurrentUser (user) {
		    $rootScope.currentUser = user;
		    return user;
		  }

		  return function() {
		    var instance = $uibModal.open({
		      templateUrl: '../view/loginModal.html',
		      controller: 'loginModalController',
		      controllerAs: 'loginModalController'
		    })

		    return instance.result.then(assignCurrentUser);
		  };

});