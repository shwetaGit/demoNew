Ext.define('Oct16last.view.mobileview.reportui.datachart.ChartPointView', {
	extend : 'Ext.panel.Panel',
	requires:['Oct16last.view.mobileview.reportui.datachart.ChartPointController'],
	xtype : 'chart-point',
	controller : 'chartPointController',
	//bodyStyle : 'background:#D8D8D8',
	itemId:"chartpoint",
	
	defualtHeight:100,
	layout : {
		type : 'hbox',
	}
});

