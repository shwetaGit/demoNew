Ext.define('Testpro.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testpro.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
