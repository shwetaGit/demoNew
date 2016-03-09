Ext.define('Project3.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Project3.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Project3.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
