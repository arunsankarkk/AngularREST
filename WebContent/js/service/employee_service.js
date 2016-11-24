/**
 * author :Arunsankar
 * Service call for all REST based HTTP operations
 */

myApp.service("empService", ['httpService', '$state', '$q', function(httpService, $state, $q){
	
	var URL_Constant = 'http://localhost:8080/RestfulProject/rest/Employee';
	
		this.saveEmployee = function(newEmployee) {
			var deferred = $q.defer();
			var http = httpService.post(URL_Constant+'/saveEmployee', newEmployee );
			http.then(
	            function (response) {
	                deferred.resolve(response);
	            },
	            function(errResponse){
	                deferred.reject(errResponse);
	            });
			return deferred.promise;
		}
		
		this.getAllEmployees = function() {
			var deferred = $q.defer();
			var http = httpService.get(URL_Constant+'/getAllEmployees');
			http.then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                deferred.reject(errResponse);
	            });
			return deferred.promise;
		}
		
		this.getEmployeeDetails = function(empId) {
			
			var deferred = $q.defer();
			var http = httpService.get(URL_Constant+'/getEmployeeDetail/'+empId);
			
			http.then(
	            function (response) {
	            	deferred.resolve(response);
	            },
	            function(errResponse){
	                deferred.reject(errResponse);
	            });
			return deferred.promise;
		}
		
		this.updateEmployee = function(updatedEmployee) {
			
			var deferred = $q.defer();
			var http = httpService.put(URL_Constant+'/updateEmployee', updatedEmployee);
			
			http.then(
	            function (response) {
	            	deferred.resolve(response);
	            },
	            function(errResponse){
	                deferred.reject(errResponse);
	            });
			return deferred.promise;
		}
		
		this.deleteEmployee = function(emp) {
			var empId = JSON.stringify(emp.id);
			var deferred = $q.defer();
			var http = httpService.del(URL_Constant+'/deleteEmployee/'+empId);
			
			http.then(
	            function (response) {
	            	deferred.resolve(response);
	            },
	            function(errResponse){
	                deferred.reject(errResponse);
	            });
			return deferred.promise;
		}
		
		this.saveMultipleEmployee = function(employeeList) {
			
			var deferred = $q.defer();
			var http = httpService.post(URL_Constant+'/saveMultipleEmployee/'+employeeList);
			
			http.then(
	            function (response) {
	            	deferred.resolve(response);
	            },
	            function(errResponse){
	                deferred.reject(errResponse);
	            });
			return deferred.promise;
		}
		
}]);