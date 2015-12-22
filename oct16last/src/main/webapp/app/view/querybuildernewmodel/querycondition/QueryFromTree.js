Ext.define('Oct16last.view.querybuildernewmodel.querycondition.QueryFromTree', {
	extend : 'Ext.tree.TreePanel',
	requires:['Oct16last.view.querybuildernewmodel.querycondition.QueryFromController',
	          'Oct16last.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore','Ext.selection.CheckboxModel'],
	controller:'query-from',
	xtype : 'query-from',
	useArrows:true,
	rootVisible: false,
	loadMask :true,
	folderSort :true,
	checked:false,
    title: '',
    /*	selModel :Ext.create('Ext.selection.CheckboxModel',{
	    	mode: 'SIMPLE',
	        checkOnly: true,
	    	listeners:{}
	    }),*/
});
