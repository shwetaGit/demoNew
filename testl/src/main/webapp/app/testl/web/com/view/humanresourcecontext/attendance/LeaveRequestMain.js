Ext.define('Testl.testl.web.com.view.humanresourcecontext.attendance.LeaveRequestMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "LeaveRequestMainController",
     "restURL": "/LeaveRequest",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.web.com.controller.humanresourcecontext.attendance.LeaveRequestMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.attendance.LeaveRequestViewModel"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "LeaveRequestFormGridContainer",
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
                    "viewModel": "LeaveRequestViewModel",
                    "xtype": "form",
                    "displayName": "Leave Request",
                    "title": "Leave Request",
                    "name": "LeaveRequest",
                    "itemId": "LeaveRequest",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "leaveRequestId",
                         "itemId": "leaveRequestId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "leaveCategoryId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "leaveCategoryId<font color='red'> *<\/font>",
                         "fieldId": "ACF38A1B-D23C-4EDE-A9A6-45912C6E702F",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "leaveRequestId",
                         "bind": "{leaveRequestId}"
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
                         "fieldId": "21F5D972-2F00-4943-B3CF-ACD4D361BD71",
                         "restURL": "EmpInformation",
                         "bindable": "empId",
                         "bind": "{empId}"
                    }, {
                         "name": "fromDate",
                         "itemId": "fromDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "From Date",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "From Date<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E97CBD0D-3F82-42A7-99BD-C015B75773C9",
                         "bindable": "fromDate",
                         "bind": "{fromDate}"
                    }, {
                         "name": "toDate",
                         "itemId": "toDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "To Date",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "To Date<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "620ABE65-01D3-42F0-9337-5B40DC1575DD",
                         "bindable": "toDate",
                         "bind": "{toDate}"
                    }, {
                         "name": "privilege",
                         "itemId": "privilege",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Privilege Leave",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Privilege Leave<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6E2DB7B7-9C65-45B9-8482-E398D3ADC0DC",
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
                         "fieldId": "B2E275B4-2328-49D7-B992-9BD655201214",
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
                         "fieldId": "CBDF803F-1D2B-4EEF-BB6A-CBC2EF65A664",
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
                         "fieldId": "835196A6-92BA-4F0C-84C2-761FC33C8208",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "maternityLeave",
                         "bind": "{maternityLeave}"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "412D53AE-90BF-4F06-8C39-BF39BC5024EE",
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
                         "customId": 963,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 963,
                              "customId": 778
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 963,
                              "customId": 779,
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
                              "parentId": 963,
                              "customId": 780,
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
                         "header": "leaveCategoryId",
                         "dataIndex": "leaveRequestId",
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
                         "header": "From Date",
                         "dataIndex": "fromDate",
                         "flex": 1
                    }, {
                         "header": "To Date",
                         "dataIndex": "toDate",
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
                              "fieldId": "21F5D972-2F00-4943-B3CF-ACD4D361BD71",
                              "restURL": "EmpInformation",
                              "bindable": "empId"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "Leave Request",
                         "name": "LeaveRequestGrid",
                         "itemId": "LeaveRequestGrid",
                         "restURL": "/LeaveRequest",
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
                              "header": "leaveCategoryId",
                              "dataIndex": "leaveRequestId",
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
                              "header": "From Date",
                              "dataIndex": "fromDate",
                              "flex": 1
                         }, {
                              "header": "To Date",
                              "dataIndex": "toDate",
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
               "viewModel": "LeaveRequestViewModel",
               "xtype": "form",
               "displayName": "Leave Request",
               "title": "Leave Request",
               "name": "LeaveRequest",
               "itemId": "LeaveRequest",
               "bodyPadding": 10,
               "items": [{
                    "name": "leaveRequestId",
                    "itemId": "leaveRequestId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "leaveCategoryId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "leaveCategoryId<font color='red'> *<\/font>",
                    "fieldId": "ACF38A1B-D23C-4EDE-A9A6-45912C6E702F",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "leaveRequestId",
                    "bind": "{leaveRequestId}"
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
                    "fieldId": "21F5D972-2F00-4943-B3CF-ACD4D361BD71",
                    "restURL": "EmpInformation",
                    "bindable": "empId",
                    "bind": "{empId}"
               }, {
                    "name": "fromDate",
                    "itemId": "fromDate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "From Date",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "From Date<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E97CBD0D-3F82-42A7-99BD-C015B75773C9",
                    "bindable": "fromDate",
                    "bind": "{fromDate}"
               }, {
                    "name": "toDate",
                    "itemId": "toDate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "To Date",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "To Date<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "620ABE65-01D3-42F0-9337-5B40DC1575DD",
                    "bindable": "toDate",
                    "bind": "{toDate}"
               }, {
                    "name": "privilege",
                    "itemId": "privilege",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Privilege Leave",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Privilege Leave<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6E2DB7B7-9C65-45B9-8482-E398D3ADC0DC",
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
                    "fieldId": "B2E275B4-2328-49D7-B992-9BD655201214",
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
                    "fieldId": "CBDF803F-1D2B-4EEF-BB6A-CBC2EF65A664",
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
                    "fieldId": "835196A6-92BA-4F0C-84C2-761FC33C8208",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "maternityLeave",
                    "bind": "{maternityLeave}"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "412D53AE-90BF-4F06-8C39-BF39BC5024EE",
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
                    "customId": 963,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 963,
                         "customId": 778
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 963,
                         "customId": 779,
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
                         "parentId": 963,
                         "customId": 780,
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