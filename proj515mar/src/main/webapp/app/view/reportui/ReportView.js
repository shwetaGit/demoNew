Ext.define('Proj515mar.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Proj515mar.view.reportui.querycriteria.QueryCriteriaView',
			'Proj515mar.view.reportui.datachart.DataChartViewTab',
			'Proj515mar.view.reportui.datachart.DataChartViewPanel',
			'Proj515mar.view.reportui.ReportViewController' ,
			'Proj515mar.view.fw.MainDataPointPanel',
			'Proj515mar.view.googlemaps.map.MapPanel'
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
