Ext.define('Salespro.salespro.shared.com.model.defaultcontext.defaultdomain.LoginPageEnModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "firstName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "loginUuid",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "lastName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "companyName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "localAddress",
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