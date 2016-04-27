/**
 * 
 */
Ext.define('Basehr.view.logalarm.mainscreen.LogAlarmMainViewTabPanel', {
	extend : 'Ext.tab.Panel',
	xtype : 'logAlarmMainViewTabPanel',
	
	requires : ['Basehr.view.logalarm.mainscreen.LogAlarmMainViewTabPanelController', 'Ext.ux.TabReorderer','Basehr.view.logalarm.mainscreen.AddLogAlarm'],
	
	controller : 'logAlarmMainViewTabPanelController',
	defaults: {
        bodyPadding: 10,
        autoScroll : true,
    },
});