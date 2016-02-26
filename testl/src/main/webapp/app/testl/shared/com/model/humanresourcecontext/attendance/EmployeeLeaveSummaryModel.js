Ext.define('Testl.testl.shared.com.model.humanresourcecontext.attendance.EmployeeLeaveSummaryModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "empLeaveStatusId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "empid",
          "reference": "EmpInformation",
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
          "name": "privilegeTaken",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "casualLeaveTaken",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "sickLeaveTaken",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "maternityLeaveTaken",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "year",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "lop",
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