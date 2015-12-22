Ext.define('Project1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Project1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Project1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
