Ext.define('Oct16last.view.fw.mainViewPanel.MainPanelController', {
	extend : 'Ext.app.ViewController',
	requires : ['Ext.util.Cookies',
	            'Oct16last.view.login.ChangePasswordScreen'],
	alias : 'controller.mainViewPanelController',
	
	afterRender:function()
	{
		debugger;
		var cookieChangePwd = Ext.util.Cookies.get('changePwd');
		var pathName= location.pathname;
		var initialPath=pathName.slice(0,pathName.lastIndexOf("/"));
		Ext.util.Cookies.clear('changePwd',initialPath);
		if(cookieChangePwd=="true"){
			 var component = Ext.create("Oct16last.view.login.ChangePasswordScreen",
							{
								modal:true,
							});
			 component.show();
		}
	}
});