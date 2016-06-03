Ext.define('Testbp.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testbp.view.appreportui.ReportViewController',
	            'Testbp.view.appreportui.datagrid.DataGridPanel',
	            'Testbp.view.appreportui.datagrid.DataGridView',
	            'Testbp.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testbp.view.appreportui.chart.ChartView',
	            'Testbp.view.appreportui.datapoint.DataPointView',
	            'Testbp.view.googlemaps.map.MapPanel',
	            'Testbp.view.appreportui.chartpoint.ChartPointView'
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
		boxready : 'fetchReportData',
		added:'onReportAdded'
	}
});
