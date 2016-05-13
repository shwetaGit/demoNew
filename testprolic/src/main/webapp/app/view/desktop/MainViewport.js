Ext.define('Testprolic.view.desktop.MainViewport', {
		extend:'Ext.container.Viewport',
		bodyPadding : 5,
		closable : false,
		xtype : 'mainViewport',
		id:'mainViewport',
		autoDestroy : true,
		requires : ['Testprolic.view.desktop.design.drawer.main.MainPanel'],
		layout:'fit',
		title:'Viewport',
		items:[{
			xtype:'mainPanel'
		}]
});