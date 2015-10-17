Ext.define('Oct16last.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Oct16last.view.art.masterform.MasterFormModel','Oct16last.view.art.masterform.MasterFormViewModel','Oct16last.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	