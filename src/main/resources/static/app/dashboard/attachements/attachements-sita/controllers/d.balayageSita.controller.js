(function () {
    'use strict';

    angular.module('app')
        .controller('BalayageSitaCtrl', ['$scope','$http','$filter', '_', 'BalayageSitaSerive', 'contChartService', balayageSitaCtrl])
		.directive('datetimez', function() {
    return {
        restrict: 'A',
        require : 'ngModel',
        link: function(scope, element, attrs, ngModelCtrl) {
          element.datetimepicker({
           format: "yyyy-MM",
           viewMode: "months", 
            minViewMode: "months",
              pickTime: false,
          }).on('changeDate', function(e) {
            ngModelCtrl.$setViewValue(e.date);
            scope.$apply();
          });
        }
    };
});

    function balayageSitaCtrl($scope,$http,$filter, _, BalayageSitaSerive, contChartService) {
		$scope.date="2016-02-01 00:00:00";
	    $scope.tabDaysOfMonth=[];
			
			$scope.$watch('date', function(newVal,oldVal){
				newVal = $filter('date')(newVal, "yyyy-MM-dd hh:mm:ss");
				oldVal= $filter('date')(oldVal, "yyyy-MM-dd hh:mm:ss");	
				console.log(newVal,oldVal);
				$http.get("http://localhost:8080/balayage/tabDaysOfMonth?dateString="+newVal)
		                   .success(function(data){
		                         $scope.tabDaysOfMonth=data;
		                         console.log(data);
	            });
				
				$http.get("http://localhost:8080/balayage/balayagesSita?dateString="+newVal)
		                   .success(function(data){
		                         $scope.balayagesSita=data;
		                         console.log(data);
	            });
				$http.get("http://localhost:8080/balayage/sumBalayagesSita?dateString="+newVal)
		                   .success(function(data){
		                         $scope.sumBalayagesSita=data;
		                         console.log(data);
	            });
	            
			
		});
			/* BalayageSitaSerive.getPromiseTabDaysOfMonth(newVal).then(
		     function(answer) {
				 $scope.tabDaysOfMonth = answer;
				 console.log(answer) ;
				 //console.log($scope.tabDaysOfMonth);
            },
            function (reason) {
                $scope.name = reason;
            }
			); */
			/*BalayageSitaSerive.getPromiseSumBalayageSita($scope.date).then(
		     function(answer) {
             $scope.sumBalayagesSita = answer;
            },
            function (reason) {
                $scope.name = reason;

            }
			);
			BalayageSitaSerive.getPromiseBalayageSita($scope.date).then(
		     // OnSuccess function
		     function(answer) {
				 $scope.balayagesSita = answer;
            },
			 // OnFailure function
            function (reason) {
                $scope.name = reason;
            }
			);
			$scope.$watch($scope.tabDaysOfMonth, $scope.sumBalayagesSita);*/
			
        /* $scope.datePicker = {
            startDate: moment().subtract(1, "days"),
            endDate: moment()
        };

        $scope.applyDate = function (ev, picker) {
            dateD = $scope.datePicker.startDate.format(DATE_FORMAT);
            dateF = $scope.datePicker.endDate.format(DATE_FORMAT);
        }
 
		$scope.balayagesSita = [];
        $scope.radar1 = {};
        $scope.radarNettoiement = {};
        $scope.radarCollecte = {};
        $scope.chart = {};*/

        
/*         askForPromiseBalyageSita.then(
            // OnSuccess function
            function (answer) {
                $scope.radar1.options = contChartService.getOptionChart(answer);
            },
            // OnFailure function
            function (reason) {
                $scope.name = reason;

            }
        );
        /*Scoop Chart

         


       
var markers=[],paths=[];
        $scope.shapes = [];
        askForPromiseMakers.then(
            // OnSuccess function
            function (answer) {
                for (var i = 0; i < answer.length; i++) {
                       var properties={
                            lat:answer[i].lat,
                            lon:answer[i].lng,
                            label:{
                                message:"<div>"+answer[i].name+"</div>",
                                show:false,
                                showOnMouseClick:true
                            },
                           onClick:function(event,properties){

                           }
                        };
                    var coord=[[answer[i].lng, answer[i].lat]];

                    markers.push(properties);
                    paths.push(coord);
                }

                $scope.shapes.push({
                    path: paths,
                    strokeColor: '#4F639E',
                    strokeOpacity: 1,
                    strokeWeight:1
                });

            },
            // OnFailure function
            function (reason) {
                $scope.name = reason;

            }
        ) ;

        angular.extend($scope, {
            center: {
                lat: 33.573947,
                lon: -7.590533,
                zoom: 11
            },
            defaults:{
                controls: {
                    zoom: {
                        position: 'topright'
                    }
                }
            },

            markers: markers,
            paths:[],
            controls: [
                { name: 'zoom', active: true },
                { name: 'fullscreen', active: true }
            ]



        }); */

    }
})(); 