Ext.define('Testpro.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testpro.view.reportui.querycriteria.QueryCriteriaView',
			'Testpro.view.reportui.datachart.DataChartViewTab',
			'Testpro.view.reportui.datachart.DataChartViewPanel',
			'Testpro.view.reportui.ReportViewController' ,
			'Testpro.view.fw.MainDataPointPanel',
			'Testpro.view.googlemaps.map.MapPanel'
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
