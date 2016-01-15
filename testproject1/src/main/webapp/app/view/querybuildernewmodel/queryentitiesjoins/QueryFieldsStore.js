Ext.define('Testproject1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testproject1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testproject1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
