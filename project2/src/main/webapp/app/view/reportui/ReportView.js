Ext.define('Project2.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project2.view.reportui.querycriteria.QueryCriteriaView',
			'Project2.view.reportui.datachart.DataChartViewTab',
			'Project2.view.reportui.datachart.DataChartViewPanel',
			'Project2.view.reportui.ReportViewController' ,
			'Project2.view.fw.MainDataPointPanel',
			'Project2.view.googlemaps.map.MapPanel'
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
