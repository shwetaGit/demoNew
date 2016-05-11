Ext.define('Testpro3.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testpro3.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testpro3.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
