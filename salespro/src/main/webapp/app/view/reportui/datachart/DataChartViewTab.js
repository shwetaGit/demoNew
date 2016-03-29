Ext.define('Salespro.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Salespro.view.reportui.datachart.DataChartTController',
	             'Salespro.view.reportui.datachart.datagrid.DataGridView',
	             'Salespro.view.reportui.datachart.chart.ChartTabView',
	             'Salespro.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});