Ext.define('Salespro.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Salespro.view.reportui.querycriteria.QueryCriteriaView',
			'Salespro.view.reportui.datachart.DataChartViewTab',
			'Salespro.view.reportui.datachart.DataChartViewPanel',
			'Salespro.view.reportui.ReportViewController' ,
			'Salespro.view.fw.MainDataPointPanel',
			'Salespro.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
