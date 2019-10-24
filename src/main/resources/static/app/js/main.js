var cmsApp = angular.module("cmsApp", ['ngRoute']);

cmsApp.controller("homeCtrl", function($scope){
	$scope.message = "Hello CMS Software!";
});

cmsApp.controller("registerCtrl", function($scope, $http, $location) {
		
	var registerUrl = "/api/users";
	$scope.newUser = {};
	$scope.newUser.exampleFirstName = "";
	$scope.newUser.exampleLastName = "";
	$scope.newUser.exampleInputEmail = "";
	$scope.newUser.exampleUserName = "";
	$scope.newUser.exampleInputPassword = "";
	$scope.newUser.exampleRepeatPassword = "";
	
	$scope.doAdd = function(){
		
		$http.post(registerUrl, $scope.newUser).then(
			function success(){
				alert("We will send email confirmation")
			},
			function error(){
				alert("Neuspešno čuvanje linije!");
			}
		);
	}
	
});

cmsApp.controller("itemCtrl", function($scope, $http, $location){
	
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
	//Ako bismo želeli da radimo kaskadiranje radi omogućavanja ng-selected odabira prevoznika,
	//onda bismo ovo morali da prebacimo u success callback pod getPrevoznici. Tu je izostavljen
	//taj mehanizam radi jednostavnosti.
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
		.when('/forgot-password', {
			templateUrl : '/app/html/forgot-password.html'
		})
		.when('/linije', {
			templateUrl : '/app/html/linije.html'
		})
		.when('/linije/edit/:id', {
			templateUrl : '/app/html/edit-linija.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);