Ext.define('Salespro.view.main.TopPanel.TopMenu', { 
	extend: 'Ext.toolbar.Toolbar',
    xtype: 'topMenu',
    requires:['Salespro.view.main.TopPanel.TopMenuController',/*'Salespro.view.main.ResourceWindow'*/],
    controller :'topMenuController',
    border:0,
    itemId:'topMenuPanel',
    autoScroll :true,
    items:[]
});