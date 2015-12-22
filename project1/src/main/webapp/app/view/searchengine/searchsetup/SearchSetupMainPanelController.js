/**
 * 
 */
Ext.define
(
	'Project1.view.searchengine.searchsetup.SearchSetupMainPanelController',
	{
		extend : 'Ext.app.ViewController',
		alias : 'controller.searchsetupcontroller',
		
		onSelectOfConfigName : function(combo, records, eOpts)
		{
			Ext.Msg.alert('Select of config', 'Called');
		}
		
	}
);