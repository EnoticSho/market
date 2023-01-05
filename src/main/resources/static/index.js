angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8080/api/v1/products/').then(function (response) {
            $scope.productList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get('http://localhost:8080/api/v1/products/' + productId).then(function (response) {
            alert(response.data());
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.get('http://localhost:8080/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});