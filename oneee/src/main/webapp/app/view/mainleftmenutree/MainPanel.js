Ext.define('Oneee.view.mainleftmenutree.MainPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'mainPanelWithLeftMenu',

	requires : [ 'Oneee.view.resource.ResourcePanel',
			'Oneee.view.mainleftmenutree.TopPanel.TopPanel',
			'Ext.layout.container.Accordion', 'Ext.Img', 'Ext.button.Split',
			'Oneee.view.resource.DockedResourcePanel','Oneee.view.fw.mainViewPanel.MainPanelController' ],

	controller:'mainViewPanelController',
	layout : 'border',
	anchor : '100% 100%',

	items : [ /*{
		region : 'north',
		xtype : 'panel',
		items : [ {
			xtype : 'menuTopPanel'
		} ]
	},*/ {
		region : 'west',
		width : '16%', 
		itemId : 'westPanel',
		xtype : 'resourcePanel',
		placeholder : {
			xtype : 'dockedResourcePanel'
		},		
		placeholderCollapseHideMode : Ext.Element.DISPLAY, 
		collapsible : true,
		hideCollapseTool : true,
		titleCollapse : true,
	}, {
		
		region : 'center',
		xtype : 'tabpanel',
		itemId : 'appMainTabPanel',
		id : 'appMainTabPanel',
		
		dockedItems : [{
			xtype : 'menuTopPanel'
		}]
		
	}/*, {
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
	} */],
	listeners:{
		scope:'controller',
		afterrender:'afterRender'
	}
});
