Ext.define('Oneee.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Oneee.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Oneee.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
