Ext.define('Oneee.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Oneee.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Oneee.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
