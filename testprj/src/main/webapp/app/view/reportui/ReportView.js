Ext.define('Testprj.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testprj.view.reportui.querycriteria.QueryCriteriaView',
			'Testprj.view.reportui.datachart.DataChartViewTab',
			'Testprj.view.reportui.datachart.DataChartViewPanel',
			'Testprj.view.reportui.ReportViewController' ,
			'Testprj.view.fw.MainDataPointPanel',
			'Testprj.view.googlemaps.map.MapPanel'
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
