angular.module('plunker', [ 'ui.bootstrap' ]);
var ModalDemoCtrl = function($scope, $modal, $log) {

	$scope.items = [ 'item1', 'item2', 'item3' ];

	$scope.open = function() {

		var modalInstance = $modal.open({
			templateUrl : 'myModalContent.html',
			controller : ModalInstanceCtrl,
			resolve : {
				items : function() {
					return $scope.items;
				},
				selected : function() {
					return $scope.selected;
				}
			}
		});

		modalInstance.result.then(function(selectedItem) {
			$scope.selected = selectedItem;
		}, function() {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};
};
angular.module('plunker').factory('dataService', function() {
	return {
		getAddressType : function() {
			var addressData = [ {
				'id' : '1',
				'desc' : 'Home is at btm'
			}, {
				'id' : '2',
				'desc' : 'Office is at southend'
			} ];
			return addressData;
		}
	}
});
var ModalInstanceCtrl = function($scope, $modalInstance, items, selected,
		dataService) {

	$scope.items = items;
	$scope.selected = {
		item : selected || items[0]
	};
	$scope.addressList = dataService.getAddressType();
	$scope.addressmodelType = '2';
	$scope.ok = function() {
		$modalInstance.close($scope.selected.item);
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
};
