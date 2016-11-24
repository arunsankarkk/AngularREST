/**
 * 
 */

myApp.controller("employeeController",[ 'empService', '$state', function(empService, $state){
	
		var employee = this;
		
		employee.updateForm = false;
		employee.deleteForm = false;
		employee.empToUpdate = false;
		employee.empToDelete = false;
		
		employee.searchEmployee = '';
		employee.searchEmployeeToUpdate = '';
		employee.message = '';
		employee.savemessage = '';
		
		employee.employeeList = [];
		employee.retrievedEmployee = {};
		
		
		employee.newEmployee = {
			"name" : "",
			"designation" : "",
			"salary" : "",
			"address" : {
				"doorNo" : "",
				"street" : "",
				"location" : "",
				"city" : ""
			}
		};
		
		employee.saveEmployee = saveEmployee;
		employee.getAllEmployees = getAllEmployees;
		employee.getEmployeeDetail = getEmployeeDetail;
		employee.findEmployee = findEmployee;
		employee.addEmployee = addEmployee;
		employee.getEmployeeToUpdate = getEmployeeToUpdate;
		employee.deleteEmployee = deleteEmployee;
		employee.findEmployeeToDelete = findEmployeeToDelete;
		employee.findEmployeeToUpdate = findEmployeeToUpdate;
		employee.addMultipleEmployee = addMultipleEmployee;
		
		// navigate to find employee page
		function findEmployee(){
			employee.empToUpdate = false;
			employee.empToDelete = false;
			clearErrorMEssages();
			$state.go('findEmployee');
		}
		
		// navigate to add employee page
		function addEmployee(){
			resetButtons(false, false);
			employee.newEmployee = {};
			clearErrorMEssages();
			$state.go('addEmployee');
		}
		
		function addMultipleEmployee(){
			resetButtons(false, false);
			employee.newEmployee = {};
			clearErrorMEssages();
			$state.go('addMultipleEmployee');
		}
		
		// navigate to update employee page
		function findEmployeeToUpdate(){
			resetButtons(true, false);
			clearErrorMEssages();
			$state.go('findEmployee');
		}
		
		// navigate to delete employee page
		function findEmployeeToDelete(){
			resetButtons(false, true);
			clearErrorMEssages();
			$state.go('findEmployee');
		}
		
		// to get all the employees present in the database
		function getAllEmployees() {
			var getEmployee = empService.getAllEmployees();
				
			 getEmployee.then(
	            function (response) {
	            	employee.employeeList = response;
	            	$state.go('getAllEmployees');
	            },
	            function(errResponse){
	            	employee.message = "Error occured, Check log for error";
	            });
			
		}
		
		//to get Employee Detail
		function getEmployeeDetail() {
			var fetchEmployee = empService.getEmployeeDetails(employee.searchEmployee);
			
			fetchEmployee.then(
	            function (response) {
	            	if(response.data !== '') {
	            		employee.retrievedEmployee = response.data;
	            		$state.go('getEmployeeDetail');
	            	} else {
	            		employee.message = "No records find for this Id"
	            	}
	            },
	            function(errResponse){
	            	employee.message = "Error occured, Check log for error";
	            });
		}
		
		function getEmployeeToUpdate() {
			var employeeToUpdate = empService.getEmployeeDetails(employee.searchEmployeeToUpdate);
			
			employeeToUpdate.then(
	            function (response) {
	            	if(response.data !== '') {
	            		employee.newEmployee = response.data;
	            		employee.updateForm = true;
	            		$state.go('addEmployee');
	            	} else {
	            		employee.message = "No records find for this Id"
	            	}
	            },
	            function(errResponse){
	            	employee.message = "Error occured, Check log for error";
	            });
		}
		
		// to save and update an Employee
		function saveEmployee() {
			var saveEmployee = '';
			var saveMessage = '';
			if(employee.newEmployee.id == undefined){
				saveEmployee = empService.saveEmployee(employee.newEmployee);
				saveMessage = "saved";
			} else{
				employee.newEmployee.id = JSON.stringify(employee.newEmployee.id);
				saveEmployee = empService.updateEmployee(employee.newEmployee);
				saveMessage = "updated";
			}
			saveEmployee.then(
	            function (response) {
	            	employee.message = "Employee record "+ saveMessage+ " successfully "
	            	$state.go('message');
	            },
	            function(errResponse){
	            	employee.message = "Error occured, Check log for error";
	            });
		}
		
		//to delete an employee
		function deleteEmployee(){
			var saveEmployee = empService.deleteEmployee(employee.retrievedEmployee);
			
			saveEmployee.then(
	            function (response) {
	            	employee.message = "Employee record deleted successfully "
	            	employee.updateForm = false;
	            	$state.go('message');
	            },
	            function(errResponse){
	            	employee.message = "Error occured, Check log for error";
	            });
		}
		
		//clear error messages
		var clearErrorMEssages = function(){
			employee.message ='';
			employee.savemessage = '';
		}
		
		var resetButtons = function(update, del) {
			employee.empToUpdate = update;
			employee.empToDelete = del;
			employee.updateForm = update;
			employee.deleteForm = del;
		}
	}
]);