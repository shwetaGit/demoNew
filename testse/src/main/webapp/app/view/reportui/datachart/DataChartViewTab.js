Ext.define('Testse.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Testse.view.reportui.datachart.DataChartTController',
	             'Testse.view.reportui.datachart.datagrid.DataGridView',
	             'Testse.view.reportui.datachart.chart.ChartTabView',
	             'Testse.view.reportui.datachart.ChartPointView' ],
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