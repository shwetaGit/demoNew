Ext.define('Testpro3.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro3.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testpro3.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
