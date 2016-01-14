Ext.define('Testpro.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testpro.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
