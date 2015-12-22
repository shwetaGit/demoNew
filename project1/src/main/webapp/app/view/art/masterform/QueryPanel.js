Ext.define('Project1.view.art.masterform.QueryPanel', {
	extend :'Ext.form.Panel',
	xtype: 'queryPanel',
	itemId: 'queryPanel',
	requires: ['Project1.view.art.masterform.QueryPanelController','Project1.view.art.masterform.QueryPanelViewModel'],
	controller: 'queryPanelController',
	viewModel:'queryPanelViewModel',
	serviceURL:null,
	buttons : [{
		text : 'Filter',
		listeners:{
			click:'submitQuery'
		}	
		
	}]	
});