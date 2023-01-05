angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8080/api/v1/products/').then(function (response) {
            $scope.productList = response.data;
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8080/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.addToCart = function (productId) {
        $http.post('http://localhost:8080/api/v1/cart/' + productId).then(function (response) {
            $scope.loadProductsInCart()
        });
    }

    $scope.loadProductsInCart = function () {
        $http.get('http://localhost:8080/api/v1/cart/').then(function (response) {
            $scope.productInCart = response.data;
        });
    }

    $scope.deleteProductFromCart = function (productId) {
        $http.delete('http://localhost:8080/api/v1/cart/' + productId).then(function (response) {
            $scope.loadProductsInCart()
        });
    }

    $scope.clearTheCart = function () {
        $http.delete('http://localhost:8080/api/v1/cart/').then(function (response) {
            $scope.loadProductsInCart()
        });
    }

    $scope.loadProductsInCart()
    $scope.loadProducts();
});