Ext.define('Newol.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Newol.view.reportui.querycriteria.QueryCriteriaView',
			'Newol.view.reportui.datachart.DataChartViewTab',
			'Newol.view.reportui.datachart.DataChartViewPanel',
			'Newol.view.reportui.ReportViewController' ,
			'Newol.view.fw.MainDataPointPanel',
			'Newol.view.googlemaps.map.MapPanel'
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
