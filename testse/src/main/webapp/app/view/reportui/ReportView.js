Ext.define('Testse.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testse.view.reportui.querycriteria.QueryCriteriaView',
			'Testse.view.reportui.datachart.DataChartViewTab',
			'Testse.view.reportui.datachart.DataChartViewPanel',
			'Testse.view.reportui.ReportViewController' ,
			'Testse.view.fw.MainDataPointPanel',
			'Testse.view.googlemaps.map.MapPanel'
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
