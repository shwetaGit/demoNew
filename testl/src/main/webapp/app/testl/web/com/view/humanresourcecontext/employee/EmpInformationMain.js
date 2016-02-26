Ext.define('Testl.testl.web.com.view.humanresourcecontext.employee.EmpInformationMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "EmpInformationMainController",
     "restURL": "/EmpInformation",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.web.com.controller.humanresourcecontext.employee.EmpInformationMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.DepartmentTypeModel", "Testl.testl.shared.com.model.humanresourcecontext.employee.DesignationTypeModel", "Testl.testl.shared.com.model.humanresourcecontext.employee.JobTypeModel", "Testl.testl.shared.com.model.humanresourcecontext.employee.VisaModel", "Testl.testl.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.employee.EmpInformationViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "Emp Information",
               "name": "EmpInformationTreeContainer",
               "itemId": "EmpInformationTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "EmpInformationTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
                    }],
                    "items": [{
                         "name": "deptTypeCode",
                         "itemId": "deptTypeCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Department",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.DepartmentTypeModel"
                         },
                         "fieldLabel": "Department",
                         "fieldId": "39BF6CF2-A0D2-406F-9C6A-D621C1D64D3B",
                         "restURL": "DepartmentType",
                         "bindable": "deptTypeCode"
                    }, {
                         "name": "designatnTypeCode",
                         "itemId": "designatnTypeCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Designation",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.DesignationTypeModel"
                         },
                         "fieldLabel": "Designation",
                         "fieldId": "C51629E0-4300-430D-BBDF-BDC35FB239E8",
                         "restURL": "DesignationType",
                         "bindable": "designatnTypeCode"
                    }, {
                         "name": "reportingOfficer",
                         "itemId": "reportingOfficer",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Reporting Officer",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Reporting Officer",
                         "fieldId": "3B4E212C-96B5-4800-BE97-878EE135B6CE",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "reportingOfficer"
                    }, {
                         "name": "jobCode",
                         "itemId": "jobCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Job Type",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.JobTypeModel"
                         },
                         "fieldLabel": "Job Type",
                         "fieldId": "23F8F4AE-E47D-4D0E-AC74-E84D51DEE2E9",
                         "restURL": "JobType",
                         "bindable": "jobCode"
                    }, {
                         "name": "visaCode",
                         "itemId": "visaCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Visa Type",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.VisaModel"
                         },
                         "fieldLabel": "Visa Type",
                         "fieldId": "82D64DAD-967D-4108-99D0-CAE6FA0EC1C8",
                         "restURL": "Visa",
                         "bindable": "visaCode"
                    }, {
                         "name": "pAN",
                         "itemId": "pAN",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "PAN",
                         "margin": "5 5 5 5",
                         "fieldLabel": "PAN",
                         "fieldId": "32B508D5-5E34-4960-8A84-C15D4BAF4052",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "pAN"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "Emp Information",
                    "name": "EmpInformation",
                    "itemId": "EmpInformationForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "empId",
                                   "itemId": "empId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Employee",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Employee<font color='red'> *<\/font>",
                                   "fieldId": "41BE62FC-DD74-4BFB-BAA7-8EFE6A3D71A4",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "empId",
                                   "bind": "{empId}"
                              }, {
                                   "name": "deptTypeCode",
                                   "itemId": "deptTypeCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Department",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.DepartmentTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Department<font color='red'> *<\/font>",
                                   "fieldId": "39BF6CF2-A0D2-406F-9C6A-D621C1D64D3B",
                                   "restURL": "DepartmentType",
                                   "bindable": "deptTypeCode",
                                   "columnWidth": 0.5,
                                   "bind": "{deptTypeCode}"
                              }, {
                                   "name": "designatnTypeCode",
                                   "itemId": "designatnTypeCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Designation",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.DesignationTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Designation<font color='red'> *<\/font>",
                                   "fieldId": "C51629E0-4300-430D-BBDF-BDC35FB239E8",
                                   "restURL": "DesignationType",
                                   "bindable": "designatnTypeCode",
                                   "columnWidth": 0.5,
                                   "bind": "{designatnTypeCode}"
                              }, {
                                   "name": "reportingOfficer",
                                   "itemId": "reportingOfficer",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Reporting Officer",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Reporting Officer<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "3B4E212C-96B5-4800-BE97-878EE135B6CE",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "bindable": "reportingOfficer",
                                   "columnWidth": 0.5,
                                   "bind": "{reportingOfficer}"
                              }, {
                                   "name": "jobCode",
                                   "itemId": "jobCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Job Type",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.JobTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Job Type<font color='red'> *<\/font>",
                                   "fieldId": "23F8F4AE-E47D-4D0E-AC74-E84D51DEE2E9",
                                   "restURL": "JobType",
                                   "bindable": "jobCode",
                                   "columnWidth": 0.5,
                                   "bind": "{jobCode}"
                              }, {
                                   "name": "visaCode",
                                   "itemId": "visaCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Visa Type",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.VisaModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Visa Type<font color='red'> *<\/font>",
                                   "fieldId": "82D64DAD-967D-4108-99D0-CAE6FA0EC1C8",
                                   "restURL": "Visa",
                                   "bindable": "visaCode",
                                   "columnWidth": 0.5,
                                   "bind": "{visaCode}"
                              }, {
                                   "name": "pAN",
                                   "itemId": "pAN",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "PAN",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "PAN<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "32B508D5-5E34-4960-8A84-C15D4BAF4052",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "pAN",
                                   "columnWidth": 0.5,
                                   "bind": "{pAN}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "0387FAFD-55FD-4C01-8CF3-DF7B0AF39E40",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }, {
                                   "xtype": "combo",
                                   "name": "CoreContacts",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "margin": 5,
                                   "bindable": "coreContacts.contactId",
                                   "typeAhead": true,
                                   "columnWidth": 0.5,
                                   "queryMode": "local",
                                   "minChars": 1,
                                   "fieldLabel": "Core Contacts<font color='red'> *<\/font>",
                                   "title": "Core Contacts",
                                   "itemId": "coreContacts",
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                                   }
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "viewModel": "EmpInformationViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Emp Information",
                    "title": "Details Grid",
                    "name": "EmpInformationGrid",
                    "itemId": "EmpInformationGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Employee",
                         "dataIndex": "empId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Department",
                         "dataIndex": "deptTypeCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Designation",
                         "dataIndex": "designatnTypeCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Reporting Officer",
                         "dataIndex": "reportingOfficer",
                         "flex": 1
                    }, {
                         "header": "Job Type",
                         "dataIndex": "jobCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Visa Type",
                         "dataIndex": "visaCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "PAN",
                         "dataIndex": "pAN",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "Emp Information",
               "name": "EmpInformation",
               "itemId": "EmpInformationForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "empId",
                              "itemId": "empId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Employee",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Employee<font color='red'> *<\/font>",
                              "fieldId": "41BE62FC-DD74-4BFB-BAA7-8EFE6A3D71A4",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "empId",
                              "bind": "{empId}"
                         }, {
                              "name": "deptTypeCode",
                              "itemId": "deptTypeCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Department",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.DepartmentTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Department<font color='red'> *<\/font>",
                              "fieldId": "39BF6CF2-A0D2-406F-9C6A-D621C1D64D3B",
                              "restURL": "DepartmentType",
                              "bindable": "deptTypeCode",
                              "columnWidth": 0.5,
                              "bind": "{deptTypeCode}"
                         }, {
                              "name": "designatnTypeCode",
                              "itemId": "designatnTypeCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Designation",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.DesignationTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Designation<font color='red'> *<\/font>",
                              "fieldId": "C51629E0-4300-430D-BBDF-BDC35FB239E8",
                              "restURL": "DesignationType",
                              "bindable": "designatnTypeCode",
                              "columnWidth": 0.5,
                              "bind": "{designatnTypeCode}"
                         }, {
                              "name": "reportingOfficer",
                              "itemId": "reportingOfficer",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Reporting Officer",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Reporting Officer<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "3B4E212C-96B5-4800-BE97-878EE135B6CE",
                              "minLength": "0",
                              "maxLength": "128",
                              "bindable": "reportingOfficer",
                              "columnWidth": 0.5,
                              "bind": "{reportingOfficer}"
                         }, {
                              "name": "jobCode",
                              "itemId": "jobCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Job Type",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.JobTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Job Type<font color='red'> *<\/font>",
                              "fieldId": "23F8F4AE-E47D-4D0E-AC74-E84D51DEE2E9",
                              "restURL": "JobType",
                              "bindable": "jobCode",
                              "columnWidth": 0.5,
                              "bind": "{jobCode}"
                         }, {
                              "name": "visaCode",
                              "itemId": "visaCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Visa Type",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.VisaModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Visa Type<font color='red'> *<\/font>",
                              "fieldId": "82D64DAD-967D-4108-99D0-CAE6FA0EC1C8",
                              "restURL": "Visa",
                              "bindable": "visaCode",
                              "columnWidth": 0.5,
                              "bind": "{visaCode}"
                         }, {
                              "name": "pAN",
                              "itemId": "pAN",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "PAN",
                              "margin": "5 5 5 5",
                              "fieldLabel": "PAN<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "32B508D5-5E34-4960-8A84-C15D4BAF4052",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "pAN",
                              "columnWidth": 0.5,
                              "bind": "{pAN}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "0387FAFD-55FD-4C01-8CF3-DF7B0AF39E40",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }, {
                              "xtype": "combo",
                              "name": "CoreContacts",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "margin": 5,
                              "bindable": "coreContacts.contactId",
                              "typeAhead": true,
                              "columnWidth": 0.5,
                              "queryMode": "local",
                              "minChars": 1,
                              "fieldLabel": "Core Contacts<font color='red'> *<\/font>",
                              "title": "Core Contacts",
                              "itemId": "coreContacts",
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                              }
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "viewModel": "EmpInformationViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});