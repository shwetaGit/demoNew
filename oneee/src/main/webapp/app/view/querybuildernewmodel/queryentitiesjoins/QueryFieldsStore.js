Ext.define('Oneee.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Oneee.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Oneee.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
