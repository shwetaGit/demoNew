Ext.define('Oct16last.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Oct16last.view.reportui.querycriteria.QueryCriteriaView',
			'Oct16last.view.reportui.datachart.DataChartViewTab',
			'Oct16last.view.reportui.datachart.DataChartViewPanel',
			'Oct16last.view.reportui.ReportViewController' ,
			'Oct16last.view.fw.MainDataPointPanel',
			'Oct16last.view.googlemaps.map.MapPanel'
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
