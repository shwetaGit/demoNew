Ext.define('Proj515mar.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Proj515mar.view.reportui.datachart.DataChartTController',
	             'Proj515mar.view.reportui.datachart.datagrid.DataGridView',
	             'Proj515mar.view.reportui.datachart.chart.ChartTabView',
	             'Proj515mar.view.reportui.datachart.ChartPointView' ],
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