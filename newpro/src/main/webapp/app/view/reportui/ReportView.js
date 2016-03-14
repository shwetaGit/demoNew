Ext.define('Newpro.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Newpro.view.reportui.querycriteria.QueryCriteriaView',
			'Newpro.view.reportui.datachart.DataChartViewTab',
			'Newpro.view.reportui.datachart.DataChartViewPanel',
			'Newpro.view.reportui.ReportViewController' ,
			'Newpro.view.fw.MainDataPointPanel',
			'Newpro.view.googlemaps.map.MapPanel'
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
