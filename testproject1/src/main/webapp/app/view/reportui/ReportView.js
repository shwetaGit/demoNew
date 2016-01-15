Ext.define('Testproject1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testproject1.view.reportui.querycriteria.QueryCriteriaView',
			'Testproject1.view.reportui.datachart.DataChartViewTab',
			'Testproject1.view.reportui.datachart.DataChartViewPanel',
			'Testproject1.view.reportui.ReportViewController' ,
			'Testproject1.view.fw.MainDataPointPanel',
			'Testproject1.view.googlemaps.map.MapPanel'
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
