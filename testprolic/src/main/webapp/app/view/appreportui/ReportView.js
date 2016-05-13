Ext.define('Testprolic.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testprolic.view.appreportui.ReportViewController',
	            'Testprolic.view.appreportui.datagrid.DataGridPanel',
	            'Testprolic.view.appreportui.datagrid.DataGridView',
	            'Testprolic.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testprolic.view.appreportui.chart.ChartView',
	            'Testprolic.view.appreportui.datapoint.DataPointView',
	            'Testprolic.view.googlemaps.map.MapPanel',
	            'Testprolic.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
