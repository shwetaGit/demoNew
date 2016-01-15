Ext.define('Testproject1.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testproject1.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testproject1.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
