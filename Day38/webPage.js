angular.module("AppMod", ["ngRoute"])
	.controller("AppCtrl", ['$http', function($http) {
		var self = this;
		
				self.studentHide=function(student){
				student.vis=true;
			};

		$http.get('http://localhost:8080/student')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});

	}])
	.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'views/home.html'

		}).when('/student', {
			templateUrl: 'views/student.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'

		}).when('/about', {
			templateUrl: 'views/about.html'

		})
		.otherwise({redirectTo: '/'});

	}]); // end config