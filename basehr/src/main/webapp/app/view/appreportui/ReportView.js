Ext.define('Basehr.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Basehr.view.appreportui.ReportViewController',
	            'Basehr.view.appreportui.datagrid.DataGridPanel',
	            'Basehr.view.appreportui.datagrid.DataGridView',
	            'Basehr.view.appreportui.querycriteria.QueryCriteriaView',
	            'Basehr.view.appreportui.chart.ChartView',
	            'Basehr.view.appreportui.datapoint.DataPointView',
	            'Basehr.view.googlemaps.map.MapPanel',
	            'Basehr.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
