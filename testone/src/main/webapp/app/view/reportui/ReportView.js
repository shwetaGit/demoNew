Ext.define('Testone.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testone.view.reportui.querycriteria.QueryCriteriaView',
			'Testone.view.reportui.datachart.DataChartViewTab',
			'Testone.view.reportui.datachart.DataChartViewPanel',
			'Testone.view.reportui.ReportViewController' ,
			'Testone.view.fw.MainDataPointPanel',
			'Testone.view.googlemaps.map.MapPanel'
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
