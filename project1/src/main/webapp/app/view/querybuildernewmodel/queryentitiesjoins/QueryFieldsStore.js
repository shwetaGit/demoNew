Ext.define('Project1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Project1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Project1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
