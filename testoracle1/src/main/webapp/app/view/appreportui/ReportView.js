Ext.define('Testoracle1.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testoracle1.view.appreportui.ReportViewController',
	            'Testoracle1.view.appreportui.datagrid.DataGridPanel',
	            'Testoracle1.view.appreportui.datagrid.DataGridView',
	            'Testoracle1.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testoracle1.view.appreportui.chart.ChartView',
	            'Testoracle1.view.appreportui.datapoint.DataPointView',
	            'Testoracle1.view.googlemaps.map.MapPanel',
	            'Testoracle1.view.appreportui.chartpoint.ChartPointView'
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
