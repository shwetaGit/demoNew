Ext.define('Newpro.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Newpro.view.reportui.datachart.DataChartTController',
	             'Newpro.view.reportui.datachart.datagrid.DataGridView',
	             'Newpro.view.reportui.datachart.chart.ChartTabView',
	             'Newpro.view.reportui.datachart.ChartPointView' ],
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