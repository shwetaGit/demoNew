Ext.define('Oct16last.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Oct16last.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Oct16last.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
