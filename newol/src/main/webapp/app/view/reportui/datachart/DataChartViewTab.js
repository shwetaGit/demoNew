Ext.define('Newol.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Newol.view.reportui.datachart.DataChartTController',
	             'Newol.view.reportui.datachart.datagrid.DataGridView',
	             'Newol.view.reportui.datachart.chart.ChartTabView',
	             'Newol.view.reportui.datachart.ChartPointView' ],
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