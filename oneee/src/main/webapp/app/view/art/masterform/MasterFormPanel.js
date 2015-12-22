Ext.define('Oneee.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Oneee.view.art.masterform.MasterFormModel','Oneee.view.art.masterform.MasterFormViewModel','Oneee.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	