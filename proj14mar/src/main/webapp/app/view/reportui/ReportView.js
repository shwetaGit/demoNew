Ext.define('Proj14mar.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Proj14mar.view.reportui.querycriteria.QueryCriteriaView',
			'Proj14mar.view.reportui.datachart.DataChartViewTab',
			'Proj14mar.view.reportui.datachart.DataChartViewPanel',
			'Proj14mar.view.reportui.ReportViewController' ,
			'Proj14mar.view.fw.MainDataPointPanel',
			'Proj14mar.view.googlemaps.map.MapPanel'
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
