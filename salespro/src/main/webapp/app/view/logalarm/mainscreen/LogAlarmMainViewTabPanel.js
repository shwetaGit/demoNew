/**
 * 
 */
Ext.define('Salespro.view.logalarm.mainscreen.LogAlarmMainViewTabPanel', {
	extend : 'Ext.tab.Panel',
	xtype : 'logAlarmMainViewTabPanel',
	
	requires : ['Salespro.view.logalarm.mainscreen.LogAlarmMainViewTabPanelController', 'Ext.ux.TabReorderer','Salespro.view.logalarm.mainscreen.AddLogAlarm'],
	
	controller : 'logAlarmMainViewTabPanelController',
	defaults: {
        bodyPadding: 10,
        autoScroll : true,
    },
});