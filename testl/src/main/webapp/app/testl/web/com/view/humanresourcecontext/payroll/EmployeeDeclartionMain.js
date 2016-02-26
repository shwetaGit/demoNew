Ext.define('Testl.testl.web.com.view.humanresourcecontext.payroll.EmployeeDeclartionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "EmployeeDeclartionMainController",
     "restURL": "/EmployeeDeclartion",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.web.com.controller.humanresourcecontext.payroll.EmployeeDeclartionMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.payroll.EmployeeDeclartionViewModel"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "EmployeeDeclartionFormGridContainer",
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
                    "viewModel": "EmployeeDeclartionViewModel",
                    "xtype": "form",
                    "displayName": "Employee Declartion",
                    "title": "Employee Declartion",
                    "name": "EmployeeDeclartion",
                    "itemId": "EmployeeDeclartion",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "empDecId",
                         "itemId": "empDecId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "empDecId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "empDecId<font color='red'> *<\/font>",
                         "fieldId": "17D4903C-9ED1-49CE-93F9-C74D58246A35",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "empDecId",
                         "bind": "{empDecId}"
                    }, {
                         "name": "empId",
                         "itemId": "empId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "empId",
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
                         "fieldLabel": "empId<font color='red'> *<\/font>",
                         "fieldId": "8CF5B5F8-745F-4B3F-9602-EA5BB9065BF8",
                         "restURL": "EmpInformation",
                         "bindable": "empId",
                         "bind": "{empId}"
                    }, {
                         "name": "hRA",
                         "itemId": "hRA",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "HRA",
                         "margin": "5 5 5 5",
                         "fieldLabel": "HRA<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "37A892BF-51B2-4BBC-ADB8-132D50AAE7CA",
                         "minValue": "0",
                         "bindable": "hRA",
                         "bind": "{hRA}"
                    }, {
                         "name": "eightyC",
                         "itemId": "eightyC",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "80C",
                         "margin": "5 5 5 5",
                         "fieldLabel": "80C<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C63FC724-A3E3-4119-944F-F11C64A377F3",
                         "minValue": "0",
                         "bindable": "eightyC",
                         "bind": "{eightyC}"
                    }, {
                         "name": "eightyD",
                         "itemId": "eightyD",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "80D",
                         "margin": "5 5 5 5",
                         "fieldLabel": "80D<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CE916689-AB17-41E4-BE10-81B71D8683C4",
                         "minValue": "0",
                         "bindable": "eightyD",
                         "bind": "{eightyD}"
                    }, {
                         "name": "eightyG",
                         "itemId": "eightyG",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "80G",
                         "margin": "5 5 5 5",
                         "fieldLabel": "80G<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "53AB26FF-287F-4C74-A9C3-498EA64BDF4B",
                         "minValue": "0",
                         "bindable": "eightyG",
                         "bind": "{eightyG}"
                    }, {
                         "name": "eightyE",
                         "itemId": "eightyE",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "80E",
                         "margin": "5 5 5 5",
                         "fieldLabel": "80E<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C1C98FC0-6670-4ACF-BEDE-7FB0DC885F2C",
                         "minValue": "0",
                         "bindable": "eightyE",
                         "bind": "{eightyE}"
                    }, {
                         "name": "year",
                         "itemId": "year",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Year",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Year<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "71706A8F-E330-4299-A8B1-B73C1D273104",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "year",
                         "bind": "{year}"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "C18BB934-FB77-4A07-BC52-420082ECD9C8",
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
                         "customId": 592,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 592,
                              "customId": 470
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 592,
                              "customId": 471,
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
                              "parentId": 592,
                              "customId": 472,
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
                         "header": "empDecId",
                         "dataIndex": "empDecId",
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
                         "header": "empId",
                         "dataIndex": "empId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "HRA",
                         "dataIndex": "hRA",
                         "flex": 1
                    }, {
                         "header": "80C",
                         "dataIndex": "eightyC",
                         "flex": 1
                    }, {
                         "header": "80D",
                         "dataIndex": "eightyD",
                         "flex": 1
                    }, {
                         "header": "80G",
                         "dataIndex": "eightyG",
                         "flex": 1
                    }, {
                         "header": "80E",
                         "dataIndex": "eightyE",
                         "flex": 1
                    }, {
                         "header": "Year",
                         "dataIndex": "year",
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
                              "displayName": "empId",
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
                              "fieldLabel": "empId",
                              "fieldId": "8CF5B5F8-745F-4B3F-9602-EA5BB9065BF8",
                              "restURL": "EmpInformation",
                              "bindable": "empId"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "Employee Declartion",
                         "name": "EmployeeDeclartionGrid",
                         "itemId": "EmployeeDeclartionGrid",
                         "restURL": "/EmployeeDeclartion",
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
                              "header": "empDecId",
                              "dataIndex": "empDecId",
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
                              "header": "empId",
                              "dataIndex": "empId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "HRA",
                              "dataIndex": "hRA",
                              "flex": 1
                         }, {
                              "header": "80C",
                              "dataIndex": "eightyC",
                              "flex": 1
                         }, {
                              "header": "80D",
                              "dataIndex": "eightyD",
                              "flex": 1
                         }, {
                              "header": "80G",
                              "dataIndex": "eightyG",
                              "flex": 1
                         }, {
                              "header": "80E",
                              "dataIndex": "eightyE",
                              "flex": 1
                         }, {
                              "header": "Year",
                              "dataIndex": "year",
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
               "viewModel": "EmployeeDeclartionViewModel",
               "xtype": "form",
               "displayName": "Employee Declartion",
               "title": "Employee Declartion",
               "name": "EmployeeDeclartion",
               "itemId": "EmployeeDeclartion",
               "bodyPadding": 10,
               "items": [{
                    "name": "empDecId",
                    "itemId": "empDecId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "empDecId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "empDecId<font color='red'> *<\/font>",
                    "fieldId": "17D4903C-9ED1-49CE-93F9-C74D58246A35",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "empDecId",
                    "bind": "{empDecId}"
               }, {
                    "name": "empId",
                    "itemId": "empId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "empId",
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
                    "fieldLabel": "empId<font color='red'> *<\/font>",
                    "fieldId": "8CF5B5F8-745F-4B3F-9602-EA5BB9065BF8",
                    "restURL": "EmpInformation",
                    "bindable": "empId",
                    "bind": "{empId}"
               }, {
                    "name": "hRA",
                    "itemId": "hRA",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "HRA",
                    "margin": "5 5 5 5",
                    "fieldLabel": "HRA<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "37A892BF-51B2-4BBC-ADB8-132D50AAE7CA",
                    "minValue": "0",
                    "bindable": "hRA",
                    "bind": "{hRA}"
               }, {
                    "name": "eightyC",
                    "itemId": "eightyC",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "80C",
                    "margin": "5 5 5 5",
                    "fieldLabel": "80C<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C63FC724-A3E3-4119-944F-F11C64A377F3",
                    "minValue": "0",
                    "bindable": "eightyC",
                    "bind": "{eightyC}"
               }, {
                    "name": "eightyD",
                    "itemId": "eightyD",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "80D",
                    "margin": "5 5 5 5",
                    "fieldLabel": "80D<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CE916689-AB17-41E4-BE10-81B71D8683C4",
                    "minValue": "0",
                    "bindable": "eightyD",
                    "bind": "{eightyD}"
               }, {
                    "name": "eightyG",
                    "itemId": "eightyG",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "80G",
                    "margin": "5 5 5 5",
                    "fieldLabel": "80G<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "53AB26FF-287F-4C74-A9C3-498EA64BDF4B",
                    "minValue": "0",
                    "bindable": "eightyG",
                    "bind": "{eightyG}"
               }, {
                    "name": "eightyE",
                    "itemId": "eightyE",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "80E",
                    "margin": "5 5 5 5",
                    "fieldLabel": "80E<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C1C98FC0-6670-4ACF-BEDE-7FB0DC885F2C",
                    "minValue": "0",
                    "bindable": "eightyE",
                    "bind": "{eightyE}"
               }, {
                    "name": "year",
                    "itemId": "year",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Year",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Year<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "71706A8F-E330-4299-A8B1-B73C1D273104",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "year",
                    "bind": "{year}"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "C18BB934-FB77-4A07-BC52-420082ECD9C8",
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
                    "customId": 592,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 592,
                         "customId": 470
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 592,
                         "customId": 471,
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
                         "parentId": 592,
                         "customId": 472,
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