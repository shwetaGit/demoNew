Ext.define('Testl.testl.web.com.view.humanresourcecontext.attendance.AttendenceSummaryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "AttendenceSummaryMainController",
     "restURL": "/AttendenceSummary",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.web.com.controller.humanresourcecontext.attendance.AttendenceSummaryMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.attendance.AttendenceSummaryViewModel"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "AttendenceSummaryFormGridContainer",
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
                    "viewModel": "AttendenceSummaryViewModel",
                    "xtype": "form",
                    "displayName": "Attendence Summary",
                    "title": "Attendence Summary",
                    "name": "AttendenceSummary",
                    "itemId": "AttendenceSummary",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "attendenceSummaryId",
                         "itemId": "attendenceSummaryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "attendenceId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "attendenceId<font color='red'> *<\/font>",
                         "fieldId": "BB1099F5-8E94-4622-92C8-3AF0A622F809",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "attendenceSummaryId",
                         "bind": "{attendenceSummaryId}"
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
                         "fieldId": "41AC4D1D-8012-40B3-AAB9-D3019F1843D1",
                         "restURL": "EmpInformation",
                         "bindable": "empId",
                         "bind": "{empId}"
                    }, {
                         "name": "present",
                         "itemId": "present",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "No of days present",
                         "margin": "5 5 5 5",
                         "fieldLabel": "No of days present<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4616FF76-C99F-4FB6-93E3-62705A1D5163",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "present",
                         "bind": "{present}"
                    }, {
                         "name": "absent",
                         "itemId": "absent",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "No of days absent",
                         "margin": "5 5 5 5",
                         "fieldLabel": "No of days absent<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0B007265-58D2-42F7-9FF0-529E78FD07CF",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "absent",
                         "bind": "{absent}"
                    }, {
                         "name": "privilege",
                         "itemId": "privilege",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "No of Privilege Leaves Take",
                         "margin": "5 5 5 5",
                         "fieldLabel": "No of Privilege Leaves Take<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "ADE7E015-DB35-4D86-AFE0-43F017CA6279",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "privilege",
                         "bind": "{privilege}"
                    }, {
                         "name": "casualLeave",
                         "itemId": "casualLeave",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "No of Casual Leaves Take",
                         "margin": "5 5 5 5",
                         "fieldLabel": "No of Casual Leaves Take<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "937F6BB5-E582-4374-B706-9844A033F166",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "casualLeave",
                         "bind": "{casualLeave}"
                    }, {
                         "name": "sickLeave",
                         "itemId": "sickLeave",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "No of Sick Leaves Take",
                         "margin": "5 5 5 5",
                         "fieldLabel": "No of Sick Leaves Take<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "38284EB3-DEC1-424D-A2DB-720BF21860A5",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "sickLeave",
                         "bind": "{sickLeave}"
                    }, {
                         "name": "maternityLeave",
                         "itemId": "maternityLeave",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "No of Maternity Leaves Take",
                         "margin": "5 5 5 5",
                         "fieldLabel": "No of Maternity Leaves Take<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D238CC17-B3A2-4E17-8F6E-8005D4BC3A8F",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "maternityLeave",
                         "bind": "{maternityLeave}"
                    }, {
                         "name": "year",
                         "itemId": "year",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Year",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Year<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "39DDA174-E024-43F3-9693-094BDBD8BBE3",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "year",
                         "bind": "{year}"
                    }, {
                         "name": "month",
                         "itemId": "month",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Month",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Month<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "60BBC0CE-AA6F-4004-9801-2EA8EDFEDB03",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "month",
                         "bind": "{month}"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "A796D97C-4900-4FE3-882A-DE86AE695E16",
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
                         "customId": 414,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 414,
                              "customId": 853
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 414,
                              "customId": 854,
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
                              "parentId": 414,
                              "customId": 855,
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
                         "dataIndex": "attendenceSummaryId",
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
                         "header": "No of days present",
                         "dataIndex": "present",
                         "flex": 1
                    }, {
                         "header": "No of days absent",
                         "dataIndex": "absent",
                         "flex": 1
                    }, {
                         "header": "No of Privilege Leaves Take",
                         "dataIndex": "privilege",
                         "flex": 1
                    }, {
                         "header": "No of Casual Leaves Take",
                         "dataIndex": "casualLeave",
                         "flex": 1
                    }, {
                         "header": "No of Sick Leaves Take",
                         "dataIndex": "sickLeave",
                         "flex": 1
                    }, {
                         "header": "No of Maternity Leaves Take",
                         "dataIndex": "maternityLeave",
                         "flex": 1
                    }, {
                         "header": "Year",
                         "dataIndex": "year",
                         "flex": 1
                    }, {
                         "header": "Month",
                         "dataIndex": "month",
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
                              "fieldId": "41AC4D1D-8012-40B3-AAB9-D3019F1843D1",
                              "restURL": "EmpInformation",
                              "bindable": "empId"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "Attendence Summary",
                         "name": "AttendenceSummaryGrid",
                         "itemId": "AttendenceSummaryGrid",
                         "restURL": "/AttendenceSummary",
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
                              "dataIndex": "attendenceSummaryId",
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
                              "header": "No of days present",
                              "dataIndex": "present",
                              "flex": 1
                         }, {
                              "header": "No of days absent",
                              "dataIndex": "absent",
                              "flex": 1
                         }, {
                              "header": "No of Privilege Leaves Take",
                              "dataIndex": "privilege",
                              "flex": 1
                         }, {
                              "header": "No of Casual Leaves Take",
                              "dataIndex": "casualLeave",
                              "flex": 1
                         }, {
                              "header": "No of Sick Leaves Take",
                              "dataIndex": "sickLeave",
                              "flex": 1
                         }, {
                              "header": "No of Maternity Leaves Take",
                              "dataIndex": "maternityLeave",
                              "flex": 1
                         }, {
                              "header": "Year",
                              "dataIndex": "year",
                              "flex": 1
                         }, {
                              "header": "Month",
                              "dataIndex": "month",
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
               "viewModel": "AttendenceSummaryViewModel",
               "xtype": "form",
               "displayName": "Attendence Summary",
               "title": "Attendence Summary",
               "name": "AttendenceSummary",
               "itemId": "AttendenceSummary",
               "bodyPadding": 10,
               "items": [{
                    "name": "attendenceSummaryId",
                    "itemId": "attendenceSummaryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "attendenceId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "attendenceId<font color='red'> *<\/font>",
                    "fieldId": "BB1099F5-8E94-4622-92C8-3AF0A622F809",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "attendenceSummaryId",
                    "bind": "{attendenceSummaryId}"
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
                    "fieldId": "41AC4D1D-8012-40B3-AAB9-D3019F1843D1",
                    "restURL": "EmpInformation",
                    "bindable": "empId",
                    "bind": "{empId}"
               }, {
                    "name": "present",
                    "itemId": "present",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "No of days present",
                    "margin": "5 5 5 5",
                    "fieldLabel": "No of days present<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4616FF76-C99F-4FB6-93E3-62705A1D5163",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "present",
                    "bind": "{present}"
               }, {
                    "name": "absent",
                    "itemId": "absent",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "No of days absent",
                    "margin": "5 5 5 5",
                    "fieldLabel": "No of days absent<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0B007265-58D2-42F7-9FF0-529E78FD07CF",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "absent",
                    "bind": "{absent}"
               }, {
                    "name": "privilege",
                    "itemId": "privilege",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "No of Privilege Leaves Take",
                    "margin": "5 5 5 5",
                    "fieldLabel": "No of Privilege Leaves Take<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "ADE7E015-DB35-4D86-AFE0-43F017CA6279",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "privilege",
                    "bind": "{privilege}"
               }, {
                    "name": "casualLeave",
                    "itemId": "casualLeave",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "No of Casual Leaves Take",
                    "margin": "5 5 5 5",
                    "fieldLabel": "No of Casual Leaves Take<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "937F6BB5-E582-4374-B706-9844A033F166",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "casualLeave",
                    "bind": "{casualLeave}"
               }, {
                    "name": "sickLeave",
                    "itemId": "sickLeave",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "No of Sick Leaves Take",
                    "margin": "5 5 5 5",
                    "fieldLabel": "No of Sick Leaves Take<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "38284EB3-DEC1-424D-A2DB-720BF21860A5",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "sickLeave",
                    "bind": "{sickLeave}"
               }, {
                    "name": "maternityLeave",
                    "itemId": "maternityLeave",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "No of Maternity Leaves Take",
                    "margin": "5 5 5 5",
                    "fieldLabel": "No of Maternity Leaves Take<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D238CC17-B3A2-4E17-8F6E-8005D4BC3A8F",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "maternityLeave",
                    "bind": "{maternityLeave}"
               }, {
                    "name": "year",
                    "itemId": "year",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Year",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Year<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "39DDA174-E024-43F3-9693-094BDBD8BBE3",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "year",
                    "bind": "{year}"
               }, {
                    "name": "month",
                    "itemId": "month",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Month",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Month<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "60BBC0CE-AA6F-4004-9801-2EA8EDFEDB03",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "month",
                    "bind": "{month}"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "A796D97C-4900-4FE3-882A-DE86AE695E16",
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
                    "customId": 414,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 414,
                         "customId": 853
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 414,
                         "customId": 854,
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
                         "parentId": 414,
                         "customId": 855,
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