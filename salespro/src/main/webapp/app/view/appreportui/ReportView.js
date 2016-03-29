Ext.define('Salespro.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Salespro.view.appreportui.ReportViewController',
	            'Salespro.view.appreportui.datagrid.DataGridPanel',
	            'Salespro.view.appreportui.datagrid.DataGridView',
	            'Salespro.view.appreportui.querycriteria.QueryCriteriaView',
	            'Salespro.view.appreportui.chart.ChartView',
	            'Salespro.view.appreportui.datapoint.DataPointView',
	            'Salespro.view.googlemaps.map.MapPanel',
	            'Salespro.view.appreportui.chartpoint.ChartPointView'
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
