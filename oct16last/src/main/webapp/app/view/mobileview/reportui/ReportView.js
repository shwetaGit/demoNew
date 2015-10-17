Ext.define('Oct16last.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Oct16last.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Oct16last.view.mobileview.reportui.datachart.DataChartViewTab',
			'Oct16last.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Oct16last.view.mobileview.reportui.ReportViewController' ,
			'Oct16last.view.mobileview.fw.DataPointPanel',
			'Oct16last.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
