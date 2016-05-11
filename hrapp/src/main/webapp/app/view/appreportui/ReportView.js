Ext.define('Hrapp.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Hrapp.view.appreportui.ReportViewController',
	            'Hrapp.view.appreportui.datagrid.DataGridPanel',
	            'Hrapp.view.appreportui.datagrid.DataGridView',
	            'Hrapp.view.appreportui.querycriteria.QueryCriteriaView',
	            'Hrapp.view.appreportui.chart.ChartView',
	            'Hrapp.view.appreportui.datapoint.DataPointView',
	            'Hrapp.view.googlemaps.map.MapPanel',
	            'Hrapp.view.appreportui.chartpoint.ChartPointView'
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
