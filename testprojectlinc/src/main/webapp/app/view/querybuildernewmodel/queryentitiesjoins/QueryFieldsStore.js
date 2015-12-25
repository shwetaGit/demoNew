Ext.define('Testprojectlinc.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testprojectlinc.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testprojectlinc.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
