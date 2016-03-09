Ext.define('Project3.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Project3.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Project3.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
