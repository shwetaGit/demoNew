Ext.define('Testl.testl.shared.com.model.documentboundedcontext.documentmanager.DocumentListModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "docId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "doctypecode",
          "reference": "DocumentType",
          "defaultValue": ""
     }, {
          "name": "docName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "docFile",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "docDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "docDate",
          "type": "auto",
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