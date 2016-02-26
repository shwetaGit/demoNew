Ext.define('Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.WorkExpDocModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "expDocPk",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "workpk",
          "reference": "WorkExperience",
          "defaultValue": ""
     }, {
          "name": "docid",
          "reference": "DocumentList",
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