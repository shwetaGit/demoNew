Ext.define('Oneee.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Oneee.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Oneee.view.mobileview.reportui.datachart.DataChartViewTab',
			'Oneee.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Oneee.view.mobileview.reportui.ReportViewController' ,
			'Oneee.view.mobileview.fw.DataPointPanel',
			'Oneee.view.mobileview.googlemaps.map.MapPanel'
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
