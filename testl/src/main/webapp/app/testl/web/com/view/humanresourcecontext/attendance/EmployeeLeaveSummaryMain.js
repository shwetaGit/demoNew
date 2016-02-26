Ext.define('Testl.testl.web.com.view.humanresourcecontext.attendance.EmployeeLeaveSummaryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "EmployeeLeaveSummaryMainController",
     "restURL": "/EmployeeLeaveSummary",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.web.com.controller.humanresourcecontext.attendance.EmployeeLeaveSummaryMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.attendance.EmployeeLeaveSummaryViewModel"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "EmployeeLeaveSummaryFormGridContainer",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "region": "center",
               "layout": "border",
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "EmployeeLeaveSummaryViewModel",
                    "xtype": "form",
                    "displayName": "Employee Leave Summary",
                    "title": "Employee Leave Summary",
                    "name": "EmployeeLeaveSummary",
                    "itemId": "EmployeeLeaveSummary",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "empLeaveStatusId",
                         "itemId": "empLeaveStatusId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "attendenceId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "attendenceId<font color='red'> *<\/font>",
                         "fieldId": "C08521AF-21F2-4FF0-B1F2-49EB49BDB9D6",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "empLeaveStatusId",
                         "bind": "{empLeaveStatusId}"
                    }, {
                         "name": "empId",
                         "itemId": "empId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Employee",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Employee<font color='red'> *<\/font>",
                         "fieldId": "9C5D4961-2F91-4612-BFE7-05DDC55105E0",
                         "restURL": "EmpInformation",
                         "bindable": "empId",
                         "bind": "{empId}"
                    }, {
                         "name": "privilege",
                         "itemId": "privilege",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Privilege Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Privilege Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B384EB20-A834-4150-82C9-56C358CA8B92",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "privilege",
                         "bind": "{privilege}"
                    }, {
                         "name": "casualLeave",
                         "itemId": "casualLeave",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Casual Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Casual Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CC6D0922-81BC-4D7F-B053-3FB79AF923C9",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "casualLeave",
                         "bind": "{casualLeave}"
                    }, {
                         "name": "sickLeave",
                         "itemId": "sickLeave",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sick Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sick Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2679B9B3-38F3-4F86-B3EE-B63631F81D6D",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "sickLeave",
                         "bind": "{sickLeave}"
                    }, {
                         "name": "maternityLeave",
                         "itemId": "maternityLeave",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Maternity Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Maternity Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C40A76D6-723E-4DA4-99AE-FCCBD485D29A",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "maternityLeave",
                         "bind": "{maternityLeave}"
                    }, {
                         "name": "privilegeTaken",
                         "itemId": "privilegeTaken",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Privilege Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Privilege Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A1CF6CB7-AC47-4448-B7FC-CDD7AFB8C974",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "privilegeTaken",
                         "bind": "{privilegeTaken}"
                    }, {
                         "name": "casualLeaveTaken",
                         "itemId": "casualLeaveTaken",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Casual Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Casual Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F5F84583-FFAB-4DEE-A8C4-342B86C83E04",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "casualLeaveTaken",
                         "bind": "{casualLeaveTaken}"
                    }, {
                         "name": "sickLeaveTaken",
                         "itemId": "sickLeaveTaken",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sick Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sick Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8C5E32A7-5FD0-4423-9BF4-A5F55F1C6029",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "sickLeaveTaken",
                         "bind": "{sickLeaveTaken}"
                    }, {
                         "name": "maternityLeaveTaken",
                         "itemId": "maternityLeaveTaken",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Maternity Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Maternity Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "23B08B9F-8789-45DE-BB36-27212A0F231F",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "maternityLeaveTaken",
                         "bind": "{maternityLeaveTaken}"
                    }, {
                         "name": "year",
                         "itemId": "year",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Financial Year",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Financial Year<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "65774B6D-DC9D-4976-934F-7F0BD0FFB257",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "year",
                         "bind": "{year}"
                    }, {
                         "name": "lop",
                         "itemId": "lop",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Loss Of Pay",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Loss Of Pay<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7FCCC59E-90DE-4546-BD69-03E115DBF7F0",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "lop",
                         "bind": "{lop}"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "AC306F3F-162D-4620-BB9D-825DBE7B0BF1",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 210,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 210,
                              "customId": 874
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 210,
                              "customId": 875,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 210,
                              "customId": 876,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "panel",
                    "layout": "border",
                    "customWidgetType": "vdPanel",
                    "title": "Details Grid",
                    "columns": [{
                         "header": "attendenceId",
                         "dataIndex": "empLeaveStatusId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Employee",
                         "dataIndex": "empId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Privilege Leave",
                         "dataIndex": "privilege",
                         "flex": 1
                    }, {
                         "header": "Casual Leave",
                         "dataIndex": "casualLeave",
                         "flex": 1
                    }, {
                         "header": "Sick Leave",
                         "dataIndex": "sickLeave",
                         "flex": 1
                    }, {
                         "header": "Maternity Leave",
                         "dataIndex": "maternityLeave",
                         "flex": 1
                    }, {
                         "header": "Privilege Leave",
                         "dataIndex": "privilegeTaken",
                         "flex": 1
                    }, {
                         "header": "Casual Leave",
                         "dataIndex": "casualLeaveTaken",
                         "flex": 1
                    }, {
                         "header": "Sick Leave",
                         "dataIndex": "sickLeaveTaken",
                         "flex": 1
                    }, {
                         "header": "Maternity Leave",
                         "dataIndex": "maternityLeaveTaken",
                         "flex": 1
                    }, {
                         "header": "Financial Year",
                         "dataIndex": "year",
                         "flex": 1
                    }, {
                         "header": "Loss Of Pay",
                         "dataIndex": "lop",
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
                    "items": [{
                         "xtype": "form",
                         "title": "Advance Search",
                         "region": "west",
                         "width": "20%",
                         "margin": "0 5 0 0",
                         "collapsible": true,
                         "collapsed": true,
                         "customWidgetType": "vdFormpanel",
                         "itemId": "queryPanel",
                         "dockedItems": [{
                              "xtype ": "toolbar",
                              "customWidgetType": "vdBBar",
                              "dock": "bottom",
                              "isDockedItem": true,
                              "items": [{
                                   "xtype": "tbfill",
                                   "customWidgetType": "vdTbFill"
                              }, {
                                   "xtype": "button",
                                   "customWidgetType": "vdButton",
                                   "text": "Filter",
                                   "name": "filterButton",
                                   "handler": "onFilterClick"
                              }]
                         }],
                         "items": [{
                              "name": "empId",
                              "itemId": "empId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Employee",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel"
                              },
                              "fieldLabel": "Employee",
                              "fieldId": "9C5D4961-2F91-4612-BFE7-05DDC55105E0",
                              "restURL": "EmpInformation",
                              "bindable": "empId"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "Employee Leave Summary",
                         "name": "EmployeeLeaveSummaryGrid",
                         "itemId": "EmployeeLeaveSummaryGrid",
                         "restURL": "/EmployeeLeaveSummary",
                         "store": [],
                         "bodyPadding": 10,
                         "dockedItems": [{
                              "xtype": "toolbar",
                              "dock": "top",
                              "items": [{
                                   "xtype": "triggerfield",
                                   "emptyText": "search",
                                   "triggerCls": "",
                                   "listeners": {
                                        "change": "onTriggerfieldChange",
                                        "buffer": 250
                                   }
                              }]
                         }],
                         "columns": [{
                              "header": "attendenceId",
                              "dataIndex": "empLeaveStatusId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "primaryDisplay",
                              "dataIndex": "primaryDisplay",
                              "hidden": true
                         }, {
                              "header": "primaryKey",
                              "dataIndex": "primaryKey",
                              "hidden": true
                         }, {
                              "header": "Employee",
                              "dataIndex": "empId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Privilege Leave",
                              "dataIndex": "privilege",
                              "flex": 1
                         }, {
                              "header": "Casual Leave",
                              "dataIndex": "casualLeave",
                              "flex": 1
                         }, {
                              "header": "Sick Leave",
                              "dataIndex": "sickLeave",
                              "flex": 1
                         }, {
                              "header": "Maternity Leave",
                              "dataIndex": "maternityLeave",
                              "flex": 1
                         }, {
                              "header": "Privilege Leave",
                              "dataIndex": "privilegeTaken",
                              "flex": 1
                         }, {
                              "header": "Casual Leave",
                              "dataIndex": "casualLeaveTaken",
                              "flex": 1
                         }, {
                              "header": "Sick Leave",
                              "dataIndex": "sickLeaveTaken",
                              "flex": 1
                         }, {
                              "header": "Maternity Leave",
                              "dataIndex": "maternityLeaveTaken",
                              "flex": 1
                         }, {
                              "header": "Financial Year",
                              "dataIndex": "year",
                              "flex": 1
                         }, {
                              "header": "Loss Of Pay",
                              "dataIndex": "lop",
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
                         }
                    }],
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
               "customWidgetType": "vdFormpanel",
               "viewModel": "EmployeeLeaveSummaryViewModel",
               "xtype": "form",
               "displayName": "Employee Leave Summary",
               "title": "Employee Leave Summary",
               "name": "EmployeeLeaveSummary",
               "itemId": "EmployeeLeaveSummary",
               "bodyPadding": 10,
               "items": [{
                    "name": "empLeaveStatusId",
                    "itemId": "empLeaveStatusId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "attendenceId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "attendenceId<font color='red'> *<\/font>",
                    "fieldId": "C08521AF-21F2-4FF0-B1F2-49EB49BDB9D6",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "empLeaveStatusId",
                    "bind": "{empLeaveStatusId}"
               }, {
                    "name": "empId",
                    "itemId": "empId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Employee",
                    "margin": "5 5 5 5",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Employee<font color='red'> *<\/font>",
                    "fieldId": "9C5D4961-2F91-4612-BFE7-05DDC55105E0",
                    "restURL": "EmpInformation",
                    "bindable": "empId",
                    "bind": "{empId}"
               }, {
                    "name": "privilege",
                    "itemId": "privilege",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Privilege Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Privilege Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B384EB20-A834-4150-82C9-56C358CA8B92",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "privilege",
                    "bind": "{privilege}"
               }, {
                    "name": "casualLeave",
                    "itemId": "casualLeave",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Casual Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Casual Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CC6D0922-81BC-4D7F-B053-3FB79AF923C9",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "casualLeave",
                    "bind": "{casualLeave}"
               }, {
                    "name": "sickLeave",
                    "itemId": "sickLeave",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Sick Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Sick Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2679B9B3-38F3-4F86-B3EE-B63631F81D6D",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "sickLeave",
                    "bind": "{sickLeave}"
               }, {
                    "name": "maternityLeave",
                    "itemId": "maternityLeave",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Maternity Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Maternity Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C40A76D6-723E-4DA4-99AE-FCCBD485D29A",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "maternityLeave",
                    "bind": "{maternityLeave}"
               }, {
                    "name": "privilegeTaken",
                    "itemId": "privilegeTaken",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Privilege Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Privilege Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A1CF6CB7-AC47-4448-B7FC-CDD7AFB8C974",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "privilegeTaken",
                    "bind": "{privilegeTaken}"
               }, {
                    "name": "casualLeaveTaken",
                    "itemId": "casualLeaveTaken",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Casual Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Casual Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F5F84583-FFAB-4DEE-A8C4-342B86C83E04",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "casualLeaveTaken",
                    "bind": "{casualLeaveTaken}"
               }, {
                    "name": "sickLeaveTaken",
                    "itemId": "sickLeaveTaken",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Sick Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Sick Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8C5E32A7-5FD0-4423-9BF4-A5F55F1C6029",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "sickLeaveTaken",
                    "bind": "{sickLeaveTaken}"
               }, {
                    "name": "maternityLeaveTaken",
                    "itemId": "maternityLeaveTaken",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Maternity Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Maternity Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "23B08B9F-8789-45DE-BB36-27212A0F231F",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "maternityLeaveTaken",
                    "bind": "{maternityLeaveTaken}"
               }, {
                    "name": "year",
                    "itemId": "year",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Financial Year",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Financial Year<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "65774B6D-DC9D-4976-934F-7F0BD0FFB257",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "year",
                    "bind": "{year}"
               }, {
                    "name": "lop",
                    "itemId": "lop",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Loss Of Pay",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Loss Of Pay<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7FCCC59E-90DE-4546-BD69-03E115DBF7F0",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "lop",
                    "bind": "{lop}"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "AC306F3F-162D-4620-BB9D-825DBE7B0BF1",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 210,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 210,
                         "customId": 874
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 210,
                         "customId": 875,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 210,
                         "customId": 876,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});