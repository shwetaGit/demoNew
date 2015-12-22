Ext.define('Oct16last.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Oct16last.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Oct16last.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
