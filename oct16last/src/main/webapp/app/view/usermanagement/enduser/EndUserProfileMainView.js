Ext.define('Oct16last.view.usermanagement.enduser.EndUserProfileMainView', {
	extend : 'Ext.tab.Panel',
	requires : ['Oct16last.view.usermanagement.enduser.UserProfile',
	            'Oct16last.view.usermanagement.enduser.ChangePwd'],
	xtype : 'endUserMainView',
	margin : '3 0 0 0',
	items:[{
				xtype:'userProfileView',
				title:'User Profile',
				iconCls:'editUserTabIcon',
				tooltip:'View/Edit your profile'
			},
			{
				xtype:'changePwdView',
				title:'Change Password',
				iconCls:'changePwdTabIcon',
				tooltip:'Change Password'
			}]
});