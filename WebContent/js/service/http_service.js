/** author : Arunsankar
 * generic class for Restful API calls
 */

'use strict';
myApp.factory('httpService', ['$http','$q', function($http,$q) {
	
		    
	var http_service = {
		post:post,
		get: get,
		put:put,
		del:del
	};
	
	return http_service;
	
	function post(url, paramObj){
		var deferred = $q.defer();
		$http({
		    method: 'POST',
		    url: url,
		    data: paramObj,
		    headers: {'Content-Type': 'application/json'}
		}).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	
	function get(url) {
		var deferred = $q.defer();
        $http.get(url)
            .then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	
	
	function put(url, paramObj){
		var deferred = $q.defer();
		$http({
		    method: 'PUT',
		    url: url,
		    data: paramObj,
		    headers: {'Content-Type': 'application/json'}
		}).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	
	function del(url, paramObj){
		var deferred = $q.defer();
		$http({
		    method: 'DELETE',
		    url: url,
		    data: paramObj,
		    headers: {'Content-Type': 'application/json'}
		}).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	
}]);