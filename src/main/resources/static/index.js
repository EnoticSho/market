angular.module('app', ['ngStorage']).controller('indexController', function ($scope, $http, $localStorage) {

    const contextPath = 'http://localhost:8080/api/v1';

    $scope.tryToAuth = function () {
        $http.post('http://localhost:8080/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.marketUser = {username: $scope.user.username, token: response.data.token};

                    $scope.user.username = null;
                    $scope.user.password = null;
                }
            }, function errorCallback(responce) {
            });
    };

    $scope.tryToLogout = function () {
        $scope.clearUser();
        $scope.user = null;
    };

    $scope.clearUser = function () {
        delete $localStorage.marketUser;
        $http.defaults.headers.common.Authorization = '';
    };

    $scope.isUserLoggedIn = function () {
        if ($localStorage.marketUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.checkAuth = function () {
        $http.get('http://localhost:8080/auth_check').then(function (response) {
            alert(response.data.value);
        });
    };

    if ($localStorage.marketUser) {
        try {
            let jwt = $localStorage.marketUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime() / 1000);
            if (currentTime > payload.exp) {
                console.log("Token is expired!");
                delete $localStorage.marketUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }
        $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.marketUser.token;
    }

    $scope.loadProducts = function () {
        $http.get('http://localhost:8080/api/v1/products/').then(function (response) {
            $scope.productList = response.data;
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8080/api/v1/products/' + productId).then(function () {
            $scope.loadProducts();
        });
    }

    $scope.addToCart = function (productId) {
        $http.post('http://localhost:8080/api/v1/cart/' + productId).then(function () {
            $scope.loadProductsInCart();
        });
    }

    $scope.loadProductsInCart = function () {
        $http.get('http://localhost:8080/api/v1/cart/').then(function (response) {
            $scope.cart = response.data;
        });
    }

    $scope.deleteProductFromCart = function (productId) {
        $http.delete('http://localhost:8080/api/v1/cart/' + productId).then(function () {
            $scope.loadProductsInCart();
        });
    }

    $scope.clearTheCart = function () {
        $http.delete('http://localhost:8080/api/v1/cart/').then(function () {
            $scope.loadProductsInCart();
        });
    }

    $scope.incrementQuantity = function (productId, delta) {
        $http({
            url: contextPath + '/cart/increment',
            method: 'Put',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function () {
            $scope.loadProductsInCart();
        });
    }

    $scope.createOrder = function () {
        $http({
            url: contextPath + '/purchase',
            method: 'POST',
            // params: {
            //     productId: productId
            // }
        }).then(function () {
            $scope.clearTheCart();
            $scope.loadProductsInCart();
        });
    }

    $scope.loadProductsInCart();
    $scope.loadProducts();
});