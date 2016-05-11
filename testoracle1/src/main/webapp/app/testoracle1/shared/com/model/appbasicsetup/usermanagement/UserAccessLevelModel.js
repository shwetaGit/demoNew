Ext.define('Testoracle1.testoracle1.shared.com.model.appbasicsetup.usermanagement.UserAccessLevelModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "userAccessLevelId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "userAccessLevel",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "levelName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelHelp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "levelIcon",
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