/**
 * 
 */

var myApp = angular.module("app", ['ui.router']);

myApp.config(['$stateProvider', function($stateProvider) {

	$stateProvider
	.state('findEmployee', {
	    url: "/findEmployee",
	    views: {
	        "main": {
				templateUrl: "view/findEmployee.html",
	        }
	    }
	})
	.state('getEmployeeDetail', {
	    url: "/employee",
	    views: {
	        "main": {
				templateUrl: "view/employee.html",
	        }
	    }
	})
	.state('getAllEmployees', {
	    url: "/allEmployees",
	    views: {
	        "main": {
				templateUrl: "view/allEmployees.html",
	        }
	    }
	}).state('addEmployee', {
	    url: "/addEmployee",
	    views: {
	        "main": {
				templateUrl: "view/addEmployee.html",
	        }
	    }
	})
	.state('updateEmployee', {
	    url: "/addEmployee",
	    views: {
	        "main": {
				templateUrl: "view/addEmployee.html",
	        }
	    }
	})
	.state('message', {
	    url: "/message",
	    views: {
	        "main": {
				templateUrl: "view/message.html",
	        }
	    }
	})
	.state('multipleEmployee', {
	    url: "/message",
	    views: {
	        "main": {
				templateUrl: "view/message.html",
	        }
	    }
	});
	
	}
]);