Ext.define('Testl.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Testl.view.reportui.datachart.DataChartTController',
	             'Testl.view.reportui.datachart.datagrid.DataGridView',
	             'Testl.view.reportui.datachart.chart.ChartTabView',
	             'Testl.view.reportui.datachart.ChartPointView' ],
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