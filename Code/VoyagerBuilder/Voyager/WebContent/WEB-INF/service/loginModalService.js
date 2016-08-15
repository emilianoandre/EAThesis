// loginModalService.js

myApp.service('loginModal', function ($modal, $rootScope) {

  function assignCurrentUser (user) {
    $rootScope.currentUser = user;
    return user;
  }

  return function() {
    var instance = $modal.open({
      templateUrl: '../views/loginModal.html',
      controller: 'loginModalController',
      controllerAs: 'loginModalController'
    })

    return instance.result.then(assignCurrentUser);
  };

});