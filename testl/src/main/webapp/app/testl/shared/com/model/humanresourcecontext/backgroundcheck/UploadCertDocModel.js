Ext.define('Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.UploadCertDocModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "certDocPk",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "certpk",
          "reference": "CertificationDetails",
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