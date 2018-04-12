var indexApp = angular.module('indexApp', []);

indexApp.controller('IndexController', function PhoneListController($scope) {
    $scope.submitLetters = function () {
        var send;
        var input = $("#letterInput").val();
        var result;
        if (true) {
            send = {
                characters: input
            };
            $.ajax({
                url: 'sendIt',
                data: send,
                type: 'GET',
                cache: false,
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    $scope.tokens = JSON.parse(JSON.parse(data));
                    $("#letterInput").val("");
                    $scope.$apply();
                },
                error: function () {
                    alert('error');
                }
            });
        } else {
            window.alert("You must enter an integer.");
        }
    };
});