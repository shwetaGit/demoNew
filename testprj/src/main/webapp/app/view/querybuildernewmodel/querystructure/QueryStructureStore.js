Ext.define('Testprj.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testprj.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testprj.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
