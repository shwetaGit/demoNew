Ext.define('Project1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project1.view.reportui.querycriteria.QueryCriteriaView',
			'Project1.view.reportui.datachart.DataChartViewTab',
			'Project1.view.reportui.datachart.DataChartViewPanel',
			'Project1.view.reportui.ReportViewController' ,
			'Project1.view.fw.MainDataPointPanel',
			'Project1.view.googlemaps.map.MapPanel'
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
