angular.module("AppMod", ["ngRoute"])
	.controller("AppCtrl", ['$http','$routeParams', function($http, $routeParams) {
		var self = this;
		self.id=$routeParams.studentId;
		
				self.studentHide=function(student){
				student.vis=true;
			};

		$http.get('http://localhost:8080/student')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});
		
		$http.get('http://localhost:8080/student/'+self.id)
			.then(function(resp){
				self.student = resp.data;
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

		}).when('/student/:studentId', {
			templateUrl: 'views/detail.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'
			
		}).when('/about', {
			templateUrl: 'views/about.html'

		})
		.otherwise({redirectTo: '/'});

	}]); // end config