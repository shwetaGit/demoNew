Ext.define('Testone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testone.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
