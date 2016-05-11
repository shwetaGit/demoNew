Ext.define('Project3.view.login.SessionLoginController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.sessionLoginCtrll',
	
	onSessionLoginClick : function() {

		
		var form = this.lookupReference('form');
		var container = this.view.container;

		var currentObject = this;
		if (form.isValid()) {
			
			Ext.Ajax.request({
				url : "secure/Authentication/reauthenticate",
				method : 'POST',
				controller : currentObject,
				maskEnable: true,
				jsonData : {
					"loginId" : '',
					"password" : form.getValues().password
				},
				success : function(response, scope) {
					
					var jsonRespone = Ext.JSON.decode(response.responseText);

					if (jsonRespone.response.success) {
						
						sessionTimeOutFlag = false;
						
						/*if(scope.controller.view.currentController != null){
							scope.controller.view.currentController.renderTreeGridData();
						}*/
						
						form.up().close();
					} else {
						if (jsonResponse.response.changePassword == true) {
							Ext.Msg.confirm('Confirm', jsonResponse.response.message, function(id, value) {
								if (id == 'yes') {
									
									// show change password screen
									scope.container.removeAll();
									scope.container.add(Ext.create('Project3.view.login.ChangePasswordScreen'));
								}
							}, {
								controller : this,
								scope : scope
							});
						} else {
							Ext.Msg.alert({
								title : 'Info',
								msg : jsonResponse.response.message,
								icon : Ext.MessageBox.WARNING
							});
						}
					}
				},
				failure : function(response) {
					var jsonRespone = Ext.JSON.decode(response.responseText);
					Ext.Msg.alert('Authentication failed', jsonRespone.response.message);
				}
			});
		}
	}
});