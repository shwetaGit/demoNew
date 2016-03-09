Ext.define('Project2.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Project2.view.reportui.datachart.DataChartTController',
	             'Project2.view.reportui.datachart.datagrid.DataGridView',
	             'Project2.view.reportui.datachart.chart.ChartTabView',
	             'Project2.view.reportui.datachart.ChartPointView' ],
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