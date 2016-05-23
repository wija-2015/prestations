/**
 * Created by abenouhoud on 21/03/2016.
 */
(function () {
    'use strict';
    angular.module('app.table').service('BalayageSitaSerive', ['$http', '$q', BalayageSitaSerive])

    function BalayageSitaSerive($http, $q) {

        var deferBalayageSita, deferSumBalayagesSita, deferDaysOfMonth;
		        //Récuperer les jours d'un mois
				this.getPromiseTabDaysOfMonth= function (myDate) {
                    var promise = $http({
                        method: 'GET',
                        url: 'http://localhost:8080/balayage/tabDaysOfMonth?dateString='+myDate,
                        headers: {
                            'Content-Type': 'application/json; charset=utf-8'
                        }
                    })
                    deferDaysOfMonth = deferDaysOfMonth || $q.defer();

                    promise.then(
                        function (answer) {
                            deferDaysOfMonth.resolve(answer.data);
                            var item = answer.data;
                            return item;
                        },
                        function (reason) {
                            deferDaysOfMonth.reject(reason);
                        });

                    return deferDaysOfMonth.promise;
                };
		        //Les bayalayages effectués par sita dans un mois
                this.getPromiseBalayageSita= function (myDate) {
                    var promise = $http({
                        method: 'GET',
                        url: 'http://localhost:8080/balayage/balayagesSita?dateString='+myDate,
                        headers: {
                            'Content-Type': 'application/json; charset=utf-8'
                        }
                    })
                    deferBalayageSita = deferBalayageSita || $q.defer();

                    promise.then(
                        // OnSuccess function
                        function (answer) {
                            // This code will only run if we have a successful promise.
                            deferBalayageSita.resolve(answer.data);
                            var item = answer.data;
                            return item;
                        },
                        // OnFailure function
                        function (reason) {
                            // This code will only run if we have a failed promise.
                            deferBalayageSita.reject(reason);
                        });

                    return deferBalayageSita.promise;
                };
				//La somme des balayages 
				this.getPromiseSumBalayageSita= function (myDate) {
                    var promise = $http({
                        method: 'GET',
                        url: 'http://localhost:8080/balayage/sumBalayagesSita?dateString='+myDate,
                        headers: {
                            'Content-Type': 'application/json; charset=utf-8'
                        }
                    })
                    deferSumBalayagesSita = deferSumBalayagesSita || $q.defer();

                    promise.then(
                        function (answer) {
                            deferSumBalayagesSita.resolve(answer.data);
                            var item = answer.data;
                            return item;
                        },
                        function (reason) {
                            deferSumBalayagesSita.reject(reason);
                        });

                    return deferSumBalayagesSita.promise;
                };
				
            };
})();