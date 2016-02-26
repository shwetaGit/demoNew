Ext.define('Testpro.testpro.shared.com.model.salesboundedcontext.sales.BrandModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "brandcode",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "branddesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "categoryid",
          "reference": "Category",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});