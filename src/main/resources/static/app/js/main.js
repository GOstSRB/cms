var cmsApp = angular.module("cmsApp", ['ngRoute']);

cmsApp.controller("homeCtrl", function($scope){
	$scope.message = "Hello CMS Software!";
});

cmsApp.controller("userCtrl", function($scope, $http, $location){
	
	$scope.users = [];
	
	$scope.newUser = {};
	$scope.newUser.firstName = "";
	$scope.newUser.lastName = "";
	$scope.newUser.email = "";
	$scope.newUser.userName = "";
	$scope.newUser.password = "";
	$scope.newUser.passwordConfirm = "";
	
	$scope.searchParams = {};
	$scope.searchParams.firstname = "";
	$scope.searchParams.lastname = "";
	$scope.searchParams.username = "";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	var usersUrl = "/api/users";
	
		var getUsers = function(){
		var config = { params: {} };		
		
		if($scope.searchParams.firstname != ""){
			config.params.firstname = $scope.searchParams.firstname;
		}
		
		if($scope.searchParams.lastname != ""){
			config.params.lastname = $scope.searchParams.lastname;
		}
// look fields!!!!!!!!!!!!!!!!!!!!
		if($scope.searchParams.username != ""){
			config.params.maksCena = $scope.searchParams.cenaKarte;
		}
		if($scope.searchParams.cenaKarte != ""){
			config.params.maksCena = $scope.searchParams.cenaKarte;
		}
		
		config.params.pageNum = $scope.pageNum;
		
		$http.get(usersUrl, config).then(
			function success(res){
				$scope.users = res.data;
				$scope.totalPages = res.headers("totalPages");
// console.log(res);
			},
			function error(){
				alert("Unsuccessful geting users.");
			}
		);
	}
	
	getUsers();
// console.log($scope.users);
		
	$scope.doDelete = function(id){
		var promise = $http.delete(usersUrl + "/" + id);
		promise.then(
			function success(){
				getUsers();
			},
			function error(){
				alert("Neuspešno brisanje linije.");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/users/edit/" + id);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getUsers();
	}
	
	$scope.doSearch = function(){
		$scope.pageNum = 0;
		getUsers();
	}	
});

cmsApp.controller("registerCtrl", function($scope, $http, $location, $routeParams) {
		
	var registerUrl = "/api/users";
	$scope.newUser = {};
	$scope.newUser.firstName = "";
	$scope.newUser.lastName = "";
	$scope.newUser.email = "";
	$scope.newUser.userName = "";
	$scope.newUser.password = "";
	$scope.newUser.passwordConfirm = "";
	
	$scope.doAdd = function(){
		
		$http.post(registerUrl, $scope.newUser).then(
			function success(){
				$location.path("/home")
				alert("We will send email confirmation")
				
			},
			function error(){
				alert("Unsuccessful save of user!");
			}
		);
	}
	
});
cmsApp.controller("editUserCtrl", function($scope, $http, $location, $routeParams) {
	
	var url = "/api/users/"+ $routeParams.id;
	
	$scope.user = {};
	$scope.user.firstname = "";
	$scope.user.lastname = "";
	$scope.user.email = "";
	$scope.user.username = "";
	$scope.user.typeOfUser = "";
// $scope.user.password = "";
// $scope.user.passwordConfirm = "";
	$scope.user.phone = "";
	$scope.user.misc1 = "";
	$scope.user.misc2 = "";
	$scope.user.misc3 = "";
	$scope.user.teamMemberSince = "";
	$scope.user.currentWageHr = "";
	$scope.user.currentWageAnnual = "";
	$scope.user.vacation = "";
	$scope.user.sick = "";
	
	
	var getUser = function() {
		var promise = $http.get(url);
		promise.then(
				function succes(res){
					$scope.user = res.data;
// console.log(res);
				},
				function error() {
					alert("Couldn't fetch user.")
				}
		);
	}
	getUser();
	
	
	$scope.doEdit = function(){
		
		$http.put(url, $scope.user).then(
			function success(){
				$location.path("/users");				
			},
			function error(){
				alert("Unsuccessful save of user!");
			}
		);
	}
	
});

cmsApp.controller("itemCtrl", function($scope, $http, $location){
	
	$scope.items = [];
	
	$scope.item = {};
	$scope.item.partType = "";
	$scope.item.partName = "";
	$scope.item.partNumber = "";
	$scope.item.partPrice = "";
	$scope.item.quantity = "";

// $scope.newLinija.prevoznikId = "";
	
	$scope.searchParams = {};
	$scope.searchParams.destinacija = "";
	$scope.searchParams.prevoznikId = "";
	$scope.searchParams.cenaKarte = "";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	var itemUrl = "/api/items";
		
	var getItems = function(){
		
		var config = { params: {} };		
		
		if($scope.searchParams.destinacija != ""){
			config.params.destinacija = $scope.searchParams.destinacija;
		}
		
		if($scope.searchParams.prevoznikId != ""){
			config.params.prevoznikId = $scope.searchParams.prevoznikId;
		}
		
		if($scope.searchParams.cenaKarte != ""){
			config.params.maksCena = $scope.searchParams.cenaKarte;
		}
		
		config.params.pageNum = $scope.pageNum;
		
		$http.get(itemUrl, config).then(
			function success(res){
				$scope.items = res.data;
				$scope.totalPages = res.headers("totalPages");
// console.log(res);
			},
			function error(){
				alert("Neupešno dobavljanje item.");
			}
		);
	}
	
	getItems();
	
	$scope.doAdd = function(){
		
		$http.post(itemUrl, $scope.item).then(
			function success(){
				getItems();
				
				$scope.item = {};
				$scope.item.partType = "";
				$scope.item.partName = "";
				$scope.item.partNumber = "";
				$scope.item.partPrice = "";
				$scope.item.quantity = "";
			},
			function error(){
				alert("Neuspešno čuvanje item!");
			}
		);
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(itemUrl + "/" + id);
		promise.then(
			function success(){
				getItems();
			},
			function error(){
				alert("Neuspešno brisanje item.");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/items/edit/" + id);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
	getItems();
	}
	
	$scope.doSearch = function(){
		$scope.pageNum = 0;
	getItems();
	}
	

	
});

cmsApp.controller("editItemCtrl", function($scope, $http, $location, $routeParams) {
	
	var url = "/api/items/"+ $routeParams.id;
	
	$scope.item = {};
	$scope.item.partType = "";
	$scope.item.partName = "";
	$scope.item.partNumber = "";
	$scope.item.partPrice = "";
	$scope.item.quantity = "";
	
	
	var getItem = function() {
		var promise = $http.get(url);
		promise.then(
				function succes(res){
					$scope.item = res.data;
// console.log(res);
				},
				function error() {
					alert("Couldn't fetch item.")
				}
		);
	}
	getItem();
	
	
	$scope.doEdit = function(){
		
		$http.put(url, $scope.item).then(
			function success(){
				$location.path("/items");				
			},
			function error(){
				alert("Unsuccessful save of item!");
			}
		);
	}
	
});

// ctrl for listdropdown in workOrder.html VARIANT II
cmsApp.controller("ListCtrl", function($scope, $http, $location, $timeout, $q, $log){
	
	$scope.items = [];
	
	var itemsUrl = "/api/items";
	var _selected;
	
	// when add new item in workOrders and search for items
	$scope.change = function(text) {
		valtosend = $scope.query;
		$http.get(itemsUrl+"?partName=" + valtosend).then(function(result){
			$scope.items = result.data;
			console.log(result);
			}
		);
	}
	
});

//ctrl for autocomplite in workOrder.html VARIANT IV
//function () {
//	  'use strict';
//	  angular
//	      .module('autocompleteDemo', ['ngMaterial'])
//	      .controller('DemoCtrl', DemoCtrl);
//
//	  function DemoCtrl ($timeout, $q, $log) {
//	    var self = this;
//
//	    self.simulateQuery = false;
//	    self.isDisabled    = false;
//
//	    // list of `state` value/display objects
//	    self.states        = loadAll();
//	    self.querySearch   = querySearch;
//	    self.selectedItemChange = selectedItemChange;
//	    self.searchTextChange   = searchTextChange;
//
//	    self.newState = newState;
//
//	    function newState(state) {
//	      alert("Sorry! You'll need to create a Constitution for " + state + " first!");
//	    }
//
//	    // ******************************
//	    // Internal methods
//	    // ******************************
//
//	    /**
//	     * Search for states... use $timeout to simulate
//	     * remote dataservice call.
//	     */
//	    function querySearch (query) {
//	      var results = query ? self.states.filter(createFilterFor(query)) : self.states,
//	          deferred;
//	      if (self.simulateQuery) {
//	        deferred = $q.defer();
//	        $timeout(function () { deferred.resolve(results); }, Math.random() * 1000, false);
//	        return deferred.promise;
//	      } else {
//	        return results;
//	      }
//	    }
//
//	    function searchTextChange(text) {
//	      $log.info('Text changed to ' + text);
//	    }
//
//	    function selectedItemChange(item) {
//	      $log.info('Item changed to ' + JSON.stringify(item));
//	    }
//
//	    /**
//	     * Build `states` list of key/value pairs
//	     */
//	    function loadAll() {
//	      var allStates = 'Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware,\
//	              Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana,\
//	              Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana,\
//	              Nebraska, Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina,\
//	              North Dakota, Ohio, Oklahoma, Oregon, Pennsylvania, Rhode Island, South Carolina,\
//	              South Dakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington, West Virginia,\
//	              Wisconsin, Wyoming';
//
//	      return allStates.split(/, +/g).map(function (state) {
//	        return {
//	          value: state.toLowerCase(),
//	          display: state
//	        };
//	      });
//	    }
//
//	    /**
//	     * Create filter function for a query string
//	     */
//	    function createFilterFor(query) {
//	      var lowercaseQuery = query.toLowerCase();
//
//	      return function filterFn(state) {
//	        return (state.value.indexOf(lowercaseQuery) === 0);
//	      };
//
//	    }
//	  }
//	});
	
	
cmsApp.controller("workOrderCtrl", function($scope, $http, $location, $timeout, $q, $log){
	
	$scope.workOrders = [];
	$scope.users = [];
	$scope.items = [];

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
	
	$scope.newItemDescription = "";
	$scope.newItemQty = "";
	$scope.newItemUnitPrice = "";
	$scope.newItemTotal = "";
	
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
		
	var workOrdersUrl = "/api/workorders";
	var userUrl = "/api/users";
	var itemsUrl = "/api/items";
	
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
	// not in use
	// for drop down of search field customer
	 $scope.ngModelOptionsSelected = function(value) {
		    if (arguments.length) {
		      _selected = value;
		    } else {
		      return _selected;
		    }
		  };
	// not in use	  
	// for drop down of search field customer
	 $scope.modelOptions = {
			    debounce: {
			      default: 500,
			      blur: 250
			    },
			    getterSetter: true
			  };
	 
	 $scope.addItem = function() {
			
			var itemNew = {};
			
			itemNew.description = $scope.newItemDescription;
			itemNew.qty = $scope.newItemQty;
			itemNew.unitPrice = $scope.newItemUnitPrice;
			itemNew.total =  $scope.newItemTotal;
			
			$scope.items.push(itemNew);
			
			$scope.newItemDescription = "";
			$scope.newItemQty = "";
			$scope.newItemUnitPrice = "";
			$scope.newItemTotal = "";
		};
		
	// not working
	// for auto complete field
	$scope.getItems = function(val) {
	    return $http
	      .get(itemsUrl, {
	          params: {
	        	  partName: val,
	              sensor: false
	            }
	      }).then(function(response) {
	        // Map the response object to the data object.
	    	  return response.data.result.map(function(it){
	    		  return it.ok;
	    	  });
	    	
	      });
	  };

	
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











cmsApp.controller("linijaCtrl", function($scope, $http, $location){
	
	$scope.linije = [];
	$scope.prevoznici = [];

	$scope.newLinija = {};
	$scope.newLinija.brojMesta = "";
	$scope.newLinija.cenaKarte = "";
	$scope.newLinija.vremePolaska = "";
	$scope.newLinija.destinacija = "";

	$scope.newLinija.prevoznikId = "";
	
	$scope.searchParams = {};
	$scope.searchParams.destinacija = "";
	$scope.searchParams.prevoznikId = "";
	$scope.searchParams.cenaKarte = "";
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	var linijeUrl = "/api/linije";
	var prevozniciUrl = "/api/prevoznici";
	
	var getLinije = function(){
		
		var config = { params: {} };		
		
		if($scope.searchParams.destinacija != ""){
			config.params.destinacija = $scope.searchParams.destinacija;
		}
		
		if($scope.searchParams.prevoznikId != ""){
			config.params.prevoznikId = $scope.searchParams.prevoznikId;
		}
		
		if($scope.searchParams.cenaKarte != ""){
			config.params.maksCena = $scope.searchParams.cenaKarte;
		}
		
		config.params.pageNum = $scope.pageNum;
		
		$http.get(linijeUrl, config).then(
			function success(res){
				$scope.linije = res.data;
				$scope.totalPages = res.headers("totalPages");
			},
			function error(){
				alert("Neupešno dobavljanje linija.");
			}
		);
	}
	
	getLinije();
	
	
	var getPrevoznici = function(){
		$http.get(prevozniciUrl).then(
			function success(res){
				$scope.prevoznici = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje prevoznika.");
			}
		);
	}
	
	getPrevoznici();
	
	
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


cmsApp.controller("editLinijaCtrl", function($scope, $http, $routeParams, $location){
	
	var linijaUrl = "/api/linije/" + $routeParams.id;
	var prevozniciUrl = "/api/prevoznici";

	$scope.prevoznici = [];
	
	$scope.linija = {};
	$scope.linija.brojMesta = "";
	$scope.linija.cenaKarte = "";
	$scope.linija.vremePolaska = "";
	$scope.linija.destinacija = "";

	$scope.prevoznikId = "";
	
	var getPrevoznici = function(){
		$http.get(prevozniciUrl).then(
			function success(res){
				$scope.prevoznici = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje prevoznika.");
			}
		);
	}
	
	getPrevoznici();
	
	
	var getLinija = function(){
		$http.get(linijaUrl).then(
			function success(res){
				$scope.linija = res.data;
			},
			function error(){
				alert("Neuspešno dobavljanje linije.");
			}
		);
	}
	// Ako bismo želeli da radimo kaskadiranje radi omogućavanja ng-selected
	// odabira prevoznika,
	// onda bismo ovo morali da prebacimo u success callback pod getPrevoznici.
	// Tu je izostavljen
	// taj mehanizam radi jednostavnosti.
	getLinija();
	
	
	$scope.doEdit = function(){
		$http.put(linijaUrl, $scope.linija).then(
			function success(){
				$location.path("/linije");
			},
			function error(){
				alert("Neuspešno čuvanje linije.");
			}
		);
	}
});




cmsApp.controller("dashboardCtrl", function($scope, $http, $location){
	
	// url
	var baseUrlWorkOrder = "/api/workorders";
	$scope.pageNum = 0;
	$scope.totalPages = 0;
	$scope.workOrder = [];
	
	var getWorkOrder = function(){
		var config = {params: {}};
		config.params.pageNum = $scope.pageNum;
		
		$http.get(baseUrlWorkOrder, config)
		.then(
				function uspeh(res){
				$scope.workOrder = res.data;
				$scope.totalPages = res.headers('totalPages');
				console.log(res);
				},
				function neuspeh(res){
					alert("Cant find workorder");
				}
		);
	};
	getWorkOrder();
	
	// NAZAD-BUTTON(copy-paste)
	$scope.nazad = function(){
	    if($scope.pageNum > 0) {
	        $scope.pageNum = $scope.pageNum - 1;
	        getWorkOrder();
	    }
	};

	// NAPRED-BUTTON(copy-paste)
	$scope.napred = function(){
	    if($scope.pageNum < $scope.totalPages - 1){
	        $scope.pageNum = $scope.pageNum + 1;
	        getWorkOrder();
	    }
	};
	
});



cmsApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html',
			controller: 'homeCtrl'
		})
		.when('/login', {
			templateUrl : '/app/html/login.html'
		})
		.when('/register', {
			templateUrl : '/app/html/register.html'
		})
		.when('/users', {
			templateUrl : '/app/html/users.html'
		})
		.when('/users/edit/:id', {
			templateUrl : '/app/html/edit-user.html'
		})
		.when('/forgot-password', {
			templateUrl : '/app/html/forgot-password.html'
		})
		.when('/items', {
			templateUrl : '/app/html/items.html'
		})
		.when('/workOrders', {
			templateUrl : '/app/html/workorder.html'
		})
		.when('/items/edit/:id', {
			templateUrl : '/app/html/edit-item.html'
		})
		.when('/linije', {
			templateUrl : '/app/html/linije.html'
		})
		.when('/linije/edit/:id', {
			templateUrl : '/app/html/edit-linija.html'
		})
		.when('/dashboard', {
			templateUrl : '/app/html/dashboard.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}
]);