Ext.define('Testl.testl.shared.com.model.humanresourcecontext.attendance.AttendenceSummaryModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "attendenceSummaryId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "empid",
          "reference": "EmpInformation",
          "defaultValue": ""
     }, {
          "name": "present",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "absent",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "privilege",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "casualLeave",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "sickLeave",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "maternityLeave",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "year",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "month",
          "type": "int",
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