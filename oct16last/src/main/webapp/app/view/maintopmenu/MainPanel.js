Ext.define('Oct16last.view.maintopmenu.MainPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'mainPanelWithTopMenu',

	requires : ['Oct16last.view.maintopmenu.TopPanel',
				'Ext.layout.container.Accordion', 
				'Ext.Img',
				'Ext.button.Split',
				'Oct16last.view.fw.mainViewPanel.MainPanelController' ],

	controller:'mainViewPanelController',
	layout : 'border',
	anchor : '100% 100%',

	tbar : {
		xtype : 'topToolbar',
		itemId : 'topToolbar'
	},
	
	items : [{
		region : 'center',
		xtype : 'tabpanel',
		itemId : 'appMainTabPanel',
		id : 'appMainTabPanel',
	}, {
		region : 'east',
		title : 'Help',
		split : true,
		collapsible : true,
		width : '20%',
		collapsed : true,
		plugins : 'responsive',
		responsiveConfig : {
			tall : {
				region : 'south',
			},
			wide : {
				region : 'east',
			}
		},
		items : [ {

			html : 'The page is under construction.....'

		} ]
	} ],
	listeners:{
		scope:'controller',
		afterrender:'afterRender'
	}
});
