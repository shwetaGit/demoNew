Ext.define('Proj14mar.view.main.Main', {
    extend: 'Ext.container.Viewport',
    xtype: 'mainPanel',
    
    requires: ['Proj14mar.view.resource.ResourcePanel'],
    
    layout: {
        type: 'border'
    },
    height:'100%',
    width:'100%',
    items: [
	{
		region: 'west',
		title: 'Resources',
		split : true,
		collapsible : true,
		width:'20%',
		xtype: 'resourcePanel',
	},
	{
		region: 'center',
		xtype : 'tabpanel',
		itemId: 'appMainTabPanel',
		id: 'appMainTabPanel',
		items: [{
			title:'System Info..'
		}]
	},
	{
		region: 'east',
		title: 'Help',
		split : true,
		collapsible : true,
		width:'20%',
		collapsed:true,
	}]
});