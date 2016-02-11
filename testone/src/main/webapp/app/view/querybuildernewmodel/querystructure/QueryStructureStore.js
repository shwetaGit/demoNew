Ext.define('Testone.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testone.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testone.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
