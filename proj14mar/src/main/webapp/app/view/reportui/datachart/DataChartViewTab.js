Ext.define('Proj14mar.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Proj14mar.view.reportui.datachart.DataChartTController',
	             'Proj14mar.view.reportui.datachart.datagrid.DataGridView',
	             'Proj14mar.view.reportui.datachart.chart.ChartTabView',
	             'Proj14mar.view.reportui.datachart.ChartPointView' ],
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