angular.module('cmsApp').controller("workOrderCtrl", function($scope, $http, $location, $timeout, $q, $log){
	
	$scope.workOrders = [];
	$scope.users = [];

	$scope.newWorkOrder = {};
	$scope.newWorkOrder.brojMesta = "";
	$scope.newWorkOrder.cenaKarte = "";
	$scope.newWorkOrder.vremePolaska = "";
	$scope.newWorkOrder.destinacija = "";

	$scope.newWorkOrder.userId = "";
	
	$scope.searchParams = {};
	$scope.searchParams.userName = "";
// $scope.searchParams.prevoznikId = "";
// $scope.searchParams.cenaKarte = "";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	var workOrdersUrl = "/api/workorders";
	var userUrl = "/api/users";
	
	// dont need all users...
//	var getUsers = function(){
//		
//		var config = { params: {} };		
//
//		// one field search for customer
//		if($scope.searchParams.userName != ""){
//			config.params.userName = $scope.searchParams.userName;
//		}
//		
//		config.params.pageNum = $scope.pageNum;
//		
//		$http.get(userUrl, config).then(
//			function success(res){
//				$scope.users = res.data;
//				$scope.totalPages = res.headers("totalPages");
//				console.log(res);
//			},
//			function error(){
//				alert("Neupešno dobavljanje users.");
//			}
//		);
//	}
//	
//	getUsers();
	
	// for input field when search users
	$scope.change = function(text) {
		valtosend = $scope.searchParams.username;
		$http.get(userUrl+"?userName=" + valtosend).then(function(result){
			$scope.users = result.data;
			console.log(result);
			}
		);
	}
	// for auto complete field
//	$scope.query = function(searchText) {
//	    return $http
//	      .get(userUrl + '?userName=' + searchText)
//	      .then(function(data) {
//	        // Map the response object to the data object.
//	    	  $scope.users = result.data;
//	    	  console.log(result);
////	    	  return users;
//	      });
//	  };

//	function () {
//		  'use strict';
//		  angular
//		      .module('autocompleteDemo', ['ngMaterial'])
//		      .controller('DemoCtrl', DemoCtrl);

		
		    var self = this;

		    self.simulateQuery = false;
		    self.isDisabled    = false;

		    // list of `state` value/display objects
		    self.states        = loadAll();
		    self.querySearch   = querySearch;
		    self.selectedItemChange = selectedItemChange;
		    self.searchTextChange   = searchTextChange;

		    self.newState = newState;

		    function newState(state) {
		      alert("Sorry! You'll need to create a Constitution for " + state + " first!");
		    }

		    // ******************************
		    // Internal methods
		    // ******************************

		    /**
		     * Search for states... use $timeout to simulate
		     * remote dataservice call.
		     */
		    function querySearch (query) {
		      var results = query ? self.states.filter(createFilterFor(query)) : self.states,
		          deferred;
		      if (self.simulateQuery) {
		        deferred = $q.defer();
		        $timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
		        return deferred.promise;
		      } else {
		        return results;
		      }
		    }

		    function searchTextChange(text) {
		      $log.info('Text changed to ' + text);
		    }

		    function selectedItemChange(item) {
		      $log.info('Item changed to ' + JSON.stringify(item));
		    }

		    /**
		     * Build `states` list of key/value pairs
		     */
		    function loadAll() {
		      var allStates = 'Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware,\
		              Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana,\
		              Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana,\
		              Nebraska, Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina,\
		              North Dakota, Ohio, Oklahoma, Oregon, Pennsylvania, Rhode Island, South Carolina,\
		              South Dakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington, West Virginia,\
		              Wisconsin, Wyoming';

		      return allStates.split(/, +/g).map(function (state) {
		        return {
		          value: state.toLowerCase(),
		          display: state
		        };
		      });
		    }

		    /**
		     * Create filter function for a query string
		     */
		    function createFilterFor(query) {
		      var lowercaseQuery = query.toLowerCase();

		      return function filterFn(state) {
		        return (state.value.indexOf(lowercaseQuery) === 0);
		      };

		    }
	
	
	
	
	
//    $scope.addList = function($location, , WatchlistService) {
    	var getAddList = function() {
//	// [2] Initialize variables
    		
//	$scope.watchlist = {};
//	var addListModal = $modal({
//		scope : $scope,
//		template : '/app/html/listOfItemInWorkOrder.html',
//		show : false
//	});
//	// [3] Bind model from service to this scope
//	$scope.watchlists = WatchlistService.query();
//	// [4] Display addlist modal
//	$scope.showModal = function() {
//		addListModal.$promise.then(addListModal.show);
//	};
	// [5] Create a new list from fields in modal
	$scope.createList = function() {
		WatchlistService.save($scope.watchlist);
		addListModal.hide();
		$scope.watchlist = {};
	};
//	// [6] Delete desired list and redirect to home
//	$scope.deleteList = function(list) {
//		WatchlistService.remove(list);
//		$location.path('/');
//				};
//			}
		};
		getAddList();
//});
	
	$scope.doAdd = function(){
		
		$http.post(linijeUrl, $scope.newLinija).then(
			function success(){
				getLinije();
				
				$scope.newLinija = {};
				$scope.newLinija.brojMesta = "";
				$scope.newLinija.cenaKarte = "";
				$scope.newLinija.vremePolaska = "";
				$scope.newLinija.destinacija = "";

				$scope.prevoznikId = "";
			},
			function error(){
				alert("Neuspešno čuvanje linije!");
			}
		);
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(linijeUrl + "/" + id);
		promise.then(
			function success(){
				getLinije();
			},
			function error(){
				alert("Neuspešno brisanje linije.");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/linije/edit/" + id);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getLinije();
	}
	
	$scope.doSearch = function(){
		$scope.pageNum = 0;
		getLinije();
	}
	
	$scope.doReserve = function(id){
		var promise = $http.post(linijeUrl + "/" + id);
		promise.then(
			function success(){
				alert("Uspešno rezervisano mesto.")
				getLinije();
			},
			function error(){
				alert("Neuspešna rezervacija.");
				getLinije();
			}
		);
	}
	
});