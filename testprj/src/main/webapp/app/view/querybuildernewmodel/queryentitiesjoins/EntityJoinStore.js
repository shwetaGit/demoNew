Ext.define('Testprj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testprj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testprj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
