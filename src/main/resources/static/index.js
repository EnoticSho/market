angular.module('app', []).controller('indexController', function ($scope, $http) {

    const contextPath = 'http://localhost:8189/shop/api/v1';

    $scope.tryToAuth = function () {
        $http.post('http://localhost:8189/shop/auth', $scope.user)
            .then(function successCallback(response) {
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.winterMarketUser = {username: $scope.user.username, token: response.data.token};

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
        delete $localStorage.winterMarketUser;
        $http.defaults.headers.common.Authorization = '';
    };
    $scope.isUserLoggedIn = function () {
        if ($localStorage.winterMarketUser) {
            return true;
        } else {
            return false;
        }
    };

    $scope.checkAuth = function () {
        $http.get('http://localhost:8189/shop/auth_check').then(function (response) {
            alert(response.data.value);
        });
    };

    if ($localStorage.winterMarketUser) {
        try {
            let jwt = $localStorage.winterMarketUser.token;
            let payload = JSON.parse(atob(jwt.split('.')[1]));
            let currentTime = parseInt(new Date().getTime() / 100);
            if (currentTime > payload.exp) {
                console.log("Token is expired!");
                delete $localStorage.winterMarketUser;
                $http.defaults.headers.common.Authorization = '';
            }
        } catch (e) {
        }
        $http.defaults.headers.common.Autorization = 'Bearer ' + $localStorage.winterMarketUser.token;
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
            $scope.loadProductsInCart()
        });
    }

    $scope.loadProductsInCart = function () {
        $http.get('http://localhost:8080/api/v1/cart/').then(function (response) {
            $scope.cart = response.data;
        });
    }

    $scope.deleteProductFromCart = function (productId) {
        $http.delete('http://localhost:8080/api/v1/cart/' + productId).then(function () {
            $scope.loadProductsInCart()
        });
    }

    $scope.clearTheCart = function () {
        $http.delete('http://localhost:8080/api/v1/cart/').then(function () {
            $scope.loadProductsInCart()
        });
    }

    $scope.incrementQuantity = function (productId) {
        $http.put('http://localhost:8080/api/v1/cart/increment/' + productId).then(function () {
            $scope.loadProductsInCart()
        });
    }

    $scope.decrementQuantity = function (productId) {
        $http.put('http://localhost:8080/api/v1/cart/decrement/' + productId).then(function () {
            $scope.loadProductsInCart()
        });
    }

    $scope.createOrder = function (productId) {
        $http({
            url: contextPath + '/orders/create_order',
            method: 'POST',
            params: {
                productId: productId
            }
        }).then(function () {
            $scope.clearCart();
            $scope.loadCart();
        });
    }

    $scope.loadProductsInCart()
    $scope.loadProducts();
});