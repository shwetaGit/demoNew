Ext.define('Testpro.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testpro.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
