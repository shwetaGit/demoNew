Ext.define('Testproject1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testproject1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testproject1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
