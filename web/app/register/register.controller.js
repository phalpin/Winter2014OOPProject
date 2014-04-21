pizzaShopControllers.controller('RegisterCtrl',

    /**
     * Registration controller.
     * @param $scope
     */
    function($scope){
        $scope.user = {
            firstname:'',
            middlename:'',
            lastname:'',
            username:'',
            emailaddress:'',
            password:''
        };
        
        $scope.confirmpassword = '';
        
        $scope.strength = 0;
        
        $scope.strengthCalc = function(){
            var strength = 0;

            if ($scope.user.password == null || $scope.user.password.length == 0) return strength;

            // award every unique letter until 5 repetitions
            var letters = new Object();
            for (var i = 0; i < $scope.user.password.length; i++) {
                letters[$scope.user.password[i]] = (letters[$scope.user.password[i]] || 0) + 1;
                strength += 5.0 / letters[$scope.user.password[i]];
            }

            //Check for variation.
            var variations = {
                digits: /\d/.test($scope.user.password),
                lower: /[a-z]/.test($scope.user.password),
                upper: /[A-Z]/.test($scope.user.password),
                nonWords: /\W/.test($scope.user.password),
            };

            variationCount = 0;
            for (var check in variations) {
                variationCount += (variations[check] == true) ? 1 : 0;
            }
            strength += (variationCount - 1) * 10;

            var str = parseInt(strength);
            var pct = (str / 72) * 100;
            pct = pct > 100 ? 100 : pct;
            $scope.strength = pct;
        };
        
        $scope.passwordStrength = function(){
            $scope.strengthCalc();
            return {
                width: $scope.strength + '%'
            };
        };
        
        $scope.progressType = function(){
            if($scope.strength <= 33.3){
                return "progress-bar-danger";
            }
            else if($scope.strength <= 66.6){
                return "progress-bar-warning";
            }
            else{
                return "progress-bar-success";
            }
        };
        
        $scope.passwordsMatch = function(){
            return $scope.confirmpassword === $scope.user.password;
        };
        
        $scope.disableSubmit = function(){
            return !(
                $scope.user.firstname !== '' && $scope.user.middlename !== '' &&
                $scope.user.lastname !== ''  && $scope.user.username !== '' &&
                $scope.user.emailaddress !== '' && $scope.user.password !== '' &&
                $scope.passwordsMatch());
        };
        
        $scope.submitRegistration = function(){
            if(!$scope.disableSubmit()){
                alert('Provide registration implementation');
            }
        }
        
    }
);