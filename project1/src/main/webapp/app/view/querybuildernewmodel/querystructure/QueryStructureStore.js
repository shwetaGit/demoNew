Ext.define('Project1.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Project1.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Project1.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
