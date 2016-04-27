/**
 * 
 */
Ext.define("Basehr.view.scheduleconfiguration.tab.ScheduleConfigTab", {
	extend : 'Ext.tab.Panel',
	xtype : 'schedulerConfigTab',
	requires : [ 'Basehr.view.scheduleconfiguration.tab.ScheduleConfigTabController' ],
	controller : 'schedulerConfigTabController'
});