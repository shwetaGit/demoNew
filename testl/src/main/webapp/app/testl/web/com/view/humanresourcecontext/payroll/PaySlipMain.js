Ext.define('Testl.testl.web.com.view.humanresourcecontext.payroll.PaySlipMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "PaySlipMainController",
     "restURL": "/PaySlip",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.web.com.controller.humanresourcecontext.payroll.PaySlipMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.payroll.PaySlipViewModel"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "PaySlipFormGridContainer",
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
                    "viewModel": "PaySlipViewModel",
                    "xtype": "form",
                    "displayName": "Pay Slip",
                    "title": "Pay Slip",
                    "name": "PaySlip",
                    "itemId": "PaySlip",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "salaryId",
                         "itemId": "salaryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Applicant Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Applicant Id<font color='red'> *<\/font>",
                         "fieldId": "6C591BD0-AC43-4A28-87C5-F4B7E5D53CB2",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "salaryId",
                         "bind": "{salaryId}"
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
                         "fieldId": "A5F17104-93C6-46E9-80A0-FCD3BD7F5A95",
                         "restURL": "EmpInformation",
                         "bindable": "empId",
                         "bind": "{empId}"
                    }, {
                         "name": "basic",
                         "itemId": "basic",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Basic",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Basic<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "424C8666-CCE2-4299-844C-2B9CB920B725",
                         "minValue": "0",
                         "bindable": "basic",
                         "bind": "{basic}"
                    }, {
                         "name": "hra",
                         "itemId": "hra",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "HRA",
                         "margin": "5 5 5 5",
                         "fieldLabel": "HRA<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9AF7C523-B252-45EA-A0DE-D1BD4B359276",
                         "minValue": "0",
                         "bindable": "hra",
                         "bind": "{hra}"
                    }, {
                         "name": "convenceAllowance",
                         "itemId": "convenceAllowance",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Convence Allowance",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Convence Allowance<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "44930838-6DDB-4549-8574-24914C1CA755",
                         "minValue": "0",
                         "bindable": "convenceAllowance",
                         "bind": "{convenceAllowance}"
                    }, {
                         "name": "medicalAllowance",
                         "itemId": "medicalAllowance",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Medical Allowance",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Medical Allowance<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E756A6CC-851A-4514-8FFE-9F3A4CC0F006",
                         "minValue": "0",
                         "bindable": "medicalAllowance",
                         "bind": "{medicalAllowance}"
                    }, {
                         "name": "educationalAllowance",
                         "itemId": "educationalAllowance",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Educational Allowance",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Educational Allowance<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "24BF5927-5ABD-4F8B-BF78-AE42E6E3714C",
                         "minValue": "0",
                         "bindable": "educationalAllowance",
                         "bind": "{educationalAllowance}"
                    }, {
                         "name": "specailAllowance",
                         "itemId": "specailAllowance",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Special Allowance",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Special Allowance<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5FAE2C62-4DFC-4717-A5A9-DE2EC0D42A1A",
                         "minValue": "0",
                         "bindable": "specailAllowance",
                         "bind": "{specailAllowance}"
                    }, {
                         "name": "tax",
                         "itemId": "tax",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Total Tax",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Total Tax<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "16A8CD0E-753D-4BF0-9EF2-84894E7DD74B",
                         "minValue": "0",
                         "bindable": "tax",
                         "bind": "{tax}"
                    }, {
                         "name": "takeHome",
                         "itemId": "takeHome",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Take Home",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Take Home<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F62DDDF7-AE8B-454E-B2C7-119C27B0CB4E",
                         "minValue": "0",
                         "bindable": "takeHome",
                         "bind": "{takeHome}"
                    }, {
                         "name": "year",
                         "itemId": "year",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Year",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Year<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BC396D54-B977-4F3A-8D76-1C9DF3B2873D",
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
                         "fieldId": "A940C768-9F2F-44C0-A250-FF2B67071FA8",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "month",
                         "bind": "{month}"
                    }, {
                         "name": "lop",
                         "itemId": "lop",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Loss Of Pay",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Loss Of Pay<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "DA4CD7CF-8225-481F-A139-AB493D76C364",
                         "minValue": "0",
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
                         "fieldId": "A8F68852-8A04-4D5D-A411-E2AF61E36E1C",
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
                         "customId": 499,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 499,
                              "customId": 632
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 499,
                              "customId": 633,
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
                              "parentId": 499,
                              "customId": 634,
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
                         "header": "Applicant Id",
                         "dataIndex": "salaryId",
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
                         "header": "Basic",
                         "dataIndex": "basic",
                         "flex": 1
                    }, {
                         "header": "HRA",
                         "dataIndex": "hra",
                         "flex": 1
                    }, {
                         "header": "Convence Allowance",
                         "dataIndex": "convenceAllowance",
                         "flex": 1
                    }, {
                         "header": "Medical Allowance",
                         "dataIndex": "medicalAllowance",
                         "flex": 1
                    }, {
                         "header": "Educational Allowance",
                         "dataIndex": "educationalAllowance",
                         "flex": 1
                    }, {
                         "header": "Special Allowance",
                         "dataIndex": "specailAllowance",
                         "flex": 1
                    }, {
                         "header": "Total Tax",
                         "dataIndex": "tax",
                         "flex": 1
                    }, {
                         "header": "Take Home",
                         "dataIndex": "takeHome",
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
                              "fieldId": "A5F17104-93C6-46E9-80A0-FCD3BD7F5A95",
                              "restURL": "EmpInformation",
                              "bindable": "empId"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "Pay Slip",
                         "name": "PaySlipGrid",
                         "itemId": "PaySlipGrid",
                         "restURL": "/PaySlip",
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
                              "header": "Applicant Id",
                              "dataIndex": "salaryId",
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
                              "header": "Basic",
                              "dataIndex": "basic",
                              "flex": 1
                         }, {
                              "header": "HRA",
                              "dataIndex": "hra",
                              "flex": 1
                         }, {
                              "header": "Convence Allowance",
                              "dataIndex": "convenceAllowance",
                              "flex": 1
                         }, {
                              "header": "Medical Allowance",
                              "dataIndex": "medicalAllowance",
                              "flex": 1
                         }, {
                              "header": "Educational Allowance",
                              "dataIndex": "educationalAllowance",
                              "flex": 1
                         }, {
                              "header": "Special Allowance",
                              "dataIndex": "specailAllowance",
                              "flex": 1
                         }, {
                              "header": "Total Tax",
                              "dataIndex": "tax",
                              "flex": 1
                         }, {
                              "header": "Take Home",
                              "dataIndex": "takeHome",
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
               "viewModel": "PaySlipViewModel",
               "xtype": "form",
               "displayName": "Pay Slip",
               "title": "Pay Slip",
               "name": "PaySlip",
               "itemId": "PaySlip",
               "bodyPadding": 10,
               "items": [{
                    "name": "salaryId",
                    "itemId": "salaryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Applicant Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Applicant Id<font color='red'> *<\/font>",
                    "fieldId": "6C591BD0-AC43-4A28-87C5-F4B7E5D53CB2",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "salaryId",
                    "bind": "{salaryId}"
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
                    "fieldId": "A5F17104-93C6-46E9-80A0-FCD3BD7F5A95",
                    "restURL": "EmpInformation",
                    "bindable": "empId",
                    "bind": "{empId}"
               }, {
                    "name": "basic",
                    "itemId": "basic",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Basic",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Basic<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "424C8666-CCE2-4299-844C-2B9CB920B725",
                    "minValue": "0",
                    "bindable": "basic",
                    "bind": "{basic}"
               }, {
                    "name": "hra",
                    "itemId": "hra",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "HRA",
                    "margin": "5 5 5 5",
                    "fieldLabel": "HRA<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9AF7C523-B252-45EA-A0DE-D1BD4B359276",
                    "minValue": "0",
                    "bindable": "hra",
                    "bind": "{hra}"
               }, {
                    "name": "convenceAllowance",
                    "itemId": "convenceAllowance",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Convence Allowance",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Convence Allowance<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "44930838-6DDB-4549-8574-24914C1CA755",
                    "minValue": "0",
                    "bindable": "convenceAllowance",
                    "bind": "{convenceAllowance}"
               }, {
                    "name": "medicalAllowance",
                    "itemId": "medicalAllowance",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Medical Allowance",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Medical Allowance<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E756A6CC-851A-4514-8FFE-9F3A4CC0F006",
                    "minValue": "0",
                    "bindable": "medicalAllowance",
                    "bind": "{medicalAllowance}"
               }, {
                    "name": "educationalAllowance",
                    "itemId": "educationalAllowance",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Educational Allowance",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Educational Allowance<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "24BF5927-5ABD-4F8B-BF78-AE42E6E3714C",
                    "minValue": "0",
                    "bindable": "educationalAllowance",
                    "bind": "{educationalAllowance}"
               }, {
                    "name": "specailAllowance",
                    "itemId": "specailAllowance",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Special Allowance",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Special Allowance<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5FAE2C62-4DFC-4717-A5A9-DE2EC0D42A1A",
                    "minValue": "0",
                    "bindable": "specailAllowance",
                    "bind": "{specailAllowance}"
               }, {
                    "name": "tax",
                    "itemId": "tax",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Total Tax",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Total Tax<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "16A8CD0E-753D-4BF0-9EF2-84894E7DD74B",
                    "minValue": "0",
                    "bindable": "tax",
                    "bind": "{tax}"
               }, {
                    "name": "takeHome",
                    "itemId": "takeHome",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Take Home",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Take Home<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F62DDDF7-AE8B-454E-B2C7-119C27B0CB4E",
                    "minValue": "0",
                    "bindable": "takeHome",
                    "bind": "{takeHome}"
               }, {
                    "name": "year",
                    "itemId": "year",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Year",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Year<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BC396D54-B977-4F3A-8D76-1C9DF3B2873D",
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
                    "fieldId": "A940C768-9F2F-44C0-A250-FF2B67071FA8",
                    "minValue": "0",
                    "maxValue": "10",
                    "bindable": "month",
                    "bind": "{month}"
               }, {
                    "name": "lop",
                    "itemId": "lop",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Loss Of Pay",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Loss Of Pay<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "DA4CD7CF-8225-481F-A139-AB493D76C364",
                    "minValue": "0",
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
                    "fieldId": "A8F68852-8A04-4D5D-A411-E2AF61E36E1C",
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
                    "customId": 499,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 499,
                         "customId": 632
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 499,
                         "customId": 633,
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
                         "parentId": 499,
                         "customId": 634,
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