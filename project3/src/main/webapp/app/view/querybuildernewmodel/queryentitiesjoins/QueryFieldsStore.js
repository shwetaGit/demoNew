Ext.define('Project3.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Project3.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Project3.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
