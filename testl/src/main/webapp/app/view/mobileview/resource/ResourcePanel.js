Ext.define('Testl.view.mobileview.resource.ResourcePanel', {
	extend : 'Ext.panel.Panel',
    xtype : 'resourcePanel',
    itemId :'resourcePanel',
    layout: 'accordion', //mbremove
    requires: ['Testl.view.mobileview.resource.ResourcePanelController'],
    controller:'resourcePanelController',
    items: [],
    listeners:{
    	scope:'controller',
    	afterrender:'onResourcePanelAfterRender',
    	hide:'onHide',
    	show:'onShow'
    }
});
