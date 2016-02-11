Ext.define('Testone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testone.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
