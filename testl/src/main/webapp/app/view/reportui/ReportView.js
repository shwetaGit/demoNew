Ext.define('Testl.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testl.view.reportui.querycriteria.QueryCriteriaView',
			'Testl.view.reportui.datachart.DataChartViewTab',
			'Testl.view.reportui.datachart.DataChartViewPanel',
			'Testl.view.reportui.ReportViewController' ,
			'Testl.view.fw.MainDataPointPanel',
			'Testl.view.googlemaps.map.MapPanel'
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
