Ext.define('Testprojectlinc.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testprojectlinc.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testprojectlinc.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
