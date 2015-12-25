Ext.define('Testprojectlinc.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testprojectlinc.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testprojectlinc.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
