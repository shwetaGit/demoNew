Ext.define('Testprj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testprj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testprj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
