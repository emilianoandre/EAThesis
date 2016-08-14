/**
 * 
 * @author: EAndre
 * Routes file
 * 
 */

app.config(function ($stateProvider) {

  $stateProvider
    .state('welcome', {
      url: '../view/index.html',
      // ...
      data: {
        requireLogin: false
      }
    })
    .state('app', {
      abstract: true,
      data: {
        requireLogin: true // this property will apply to all children of 'app'
      }
    })
    .state('app.dashboard', {
      // child state of `app`
      // requireLogin === true
    })

});