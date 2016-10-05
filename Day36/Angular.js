angular.module("AppMod", [])
    .controller("AppCtrl", ["$http", function($http) {
        var self = this;
        
      
		 
			self.studentHide=function(student){
				student.vis=false;
			};
			
 $http.get("http://localhost:8080/student/120")
			.then(function(resp) {
				self.students = resp.data;
				console.log(self.students.first_name);
				var firstNameString = "<tr><td>First Name:</td><td><input type='text' id='uname' name='uname' value='" + self.students.first_name + "'></td></tr>"
				var lastNameString = "<tr><td>Last Name:</td><td><input type='text' id='uname' name='uname' value='" + self.students.last_name + "'></td></tr>"
				var gpaNameString = "<tr><td>GPA:</td><td><input type='text' id='uname' name='uname' value='" + self.students.gpa + "'></td></tr>"
				var satNameString = "<tr><td>SAT:</td><td><input type='text' id='uname' name='uname' value='" + self.students.sat + "'></td></tr>"

				console.log(firstNameString);
				$("#studentTable").append(firstNameString);
				$("#studentTable").append(lastNameString);
				$("#studentTable").append(gpaNameString);
				$("#studentTable").append(satNameString);

	//			for(var s of self.students){
	//				s.vis = true;
	//				}
	//			}, function(err){
				});
			 
		//					self.students = [
		//	{id:100,firstname:"Eric",lastname:"Ephram",gpa:3.0,sat:1200,majorid:1,vis:true}
//];
			
		}]);  // end controller