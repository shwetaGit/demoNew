Ext.define('Testpro3.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testpro3.view.reportui.querycriteria.QueryCriteriaView',
			'Testpro3.view.reportui.datachart.DataChartViewTab',
			'Testpro3.view.reportui.datachart.DataChartViewPanel',
			'Testpro3.view.reportui.ReportViewController' ,
			'Testpro3.view.fw.MainDataPointPanel',
			'Testpro3.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
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
