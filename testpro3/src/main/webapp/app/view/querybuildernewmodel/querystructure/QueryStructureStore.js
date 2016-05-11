Ext.define('Testpro3.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro3.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testpro3.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
