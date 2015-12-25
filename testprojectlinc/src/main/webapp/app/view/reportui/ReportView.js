Ext.define('Testprojectlinc.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testprojectlinc.view.reportui.querycriteria.QueryCriteriaView',
			'Testprojectlinc.view.reportui.datachart.DataChartViewTab',
			'Testprojectlinc.view.reportui.datachart.DataChartViewPanel',
			'Testprojectlinc.view.reportui.ReportViewController' ,
			'Testprojectlinc.view.fw.MainDataPointPanel',
			'Testprojectlinc.view.googlemaps.map.MapPanel'
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
