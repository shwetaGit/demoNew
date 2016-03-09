Ext.define('Testpro.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Testpro.view.reportui.datachart.DataChartTController',
	             'Testpro.view.reportui.datachart.datagrid.DataGridView',
	             'Testpro.view.reportui.datachart.chart.ChartTabView',
	             'Testpro.view.reportui.datachart.ChartPointView' ],
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