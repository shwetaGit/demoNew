Ext.define('Oct16last.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Oct16last.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Oct16last.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
