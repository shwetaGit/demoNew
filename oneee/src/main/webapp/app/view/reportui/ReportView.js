Ext.define('Oneee.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Oneee.view.reportui.querycriteria.QueryCriteriaView',
			'Oneee.view.reportui.datachart.DataChartViewTab',
			'Oneee.view.reportui.datachart.DataChartViewPanel',
			'Oneee.view.reportui.ReportViewController' ,
			'Oneee.view.fw.MainDataPointPanel',
			'Oneee.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
