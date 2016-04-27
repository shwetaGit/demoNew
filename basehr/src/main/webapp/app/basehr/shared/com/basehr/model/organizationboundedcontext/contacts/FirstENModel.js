Ext.define('Basehr.basehr.shared.com.basehr.model.organizationboundedcontext.contacts.FirstENModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "fname",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "fid",
          "type": "string",
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