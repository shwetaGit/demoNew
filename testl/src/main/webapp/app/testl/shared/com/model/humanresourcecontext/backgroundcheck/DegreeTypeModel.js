Ext.define('Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.DegreeTypeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "degreeCode",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "degreeDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "degreeHelp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "degreeIcon",
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