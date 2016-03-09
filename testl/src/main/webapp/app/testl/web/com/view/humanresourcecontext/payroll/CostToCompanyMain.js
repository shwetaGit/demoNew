Ext.define('Testl.testl.web.com.view.humanresourcecontext.payroll.CostToCompanyMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "CostToCompanyMainController",
     "restURL": "/CostToCompany",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.web.com.controller.humanresourcecontext.payroll.CostToCompanyMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.payroll.CostToCompanyViewModel"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "CostToCompanyFormGridContainer",
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
                    "viewModel": "CostToCompanyViewModel",
                    "xtype": "form",
                    "displayName": "Cost To Company",
                    "title": "Cost To Company",
                    "name": "CostToCompany",
                    "itemId": "CostToCompany",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "salaryId",
                         "itemId": "salaryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Applicant Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Applicant Id<font color='red'> *<\/font>",
                         "fieldId": "25CB81D5-43B1-4C84-ADA9-62B7C036514B",
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
                         "fieldId": "98F21C73-03BC-4AE2-AD11-D9E1E157CC31",
                         "restURL": "EmpInformation",
                         "bindable": "empId",
                         "bind": "{empId}"
                    }, {
                         "name": "totalCTC",
                         "itemId": "totalCTC",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Total CTC",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Total CTC<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "77B573B4-4B53-4D04-A670-2E95E3C95296",
                         "minValue": "0",
                         "bindable": "totalCTC",
                         "bind": "{totalCTC}"
                    }, {
                         "name": "basic",
                         "itemId": "basic",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Basic",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Basic<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7A6BDFF4-62C2-4E92-902E-12B3F465DD18",
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
                         "fieldId": "93274D72-4E9C-4A89-9F83-FD57D04D7E12",
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
                         "fieldId": "555E4DF4-57D6-4213-82F8-01CE4E7BB1F4",
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
                         "fieldId": "1E1BBA40-3B8E-45E3-B258-3E8FC8A33359",
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
                         "fieldId": "89A4B9DE-DC90-4106-B7A3-80C48A3F2075",
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
                         "fieldId": "E27A9957-B179-45EC-9850-CD3DE1F4B5A6",
                         "minValue": "0",
                         "bindable": "specailAllowance",
                         "bind": "{specailAllowance}"
                    }, {
                         "name": "takeHome",
                         "itemId": "takeHome",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Take Home",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Take Home<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "633947B7-CBA2-47B4-80D8-EE0F71060539",
                         "minValue": "0",
                         "bindable": "takeHome",
                         "bind": "{takeHome}"
                    }, {
                         "name": "perk",
                         "itemId": "perk",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Take Home",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Take Home<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B593187F-8950-40C9-AA24-B6F193567F76",
                         "minValue": "0",
                         "bindable": "perk",
                         "bind": "{perk}"
                    }, {
                         "name": "year",
                         "itemId": "year",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Year",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Year<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "544ECC1F-FDAD-4FDC-AB37-50CE8C71DFF1",
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
                         "fieldId": "1A6002FD-9759-49AF-8763-F304E1B5B4A1",
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
                         "customId": 729,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 729,
                              "customId": 262
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 729,
                              "customId": 263,
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
                              "parentId": 729,
                              "customId": 264,
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
                         "header": "Total CTC",
                         "dataIndex": "totalCTC",
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
                         "header": "Take Home",
                         "dataIndex": "takeHome",
                         "flex": 1
                    }, {
                         "header": "Take Home",
                         "dataIndex": "perk",
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
                              "fieldId": "98F21C73-03BC-4AE2-AD11-D9E1E157CC31",
                              "restURL": "EmpInformation",
                              "bindable": "empId"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "Cost To Company",
                         "name": "CostToCompanyGrid",
                         "itemId": "CostToCompanyGrid",
                         "restURL": "/CostToCompany",
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
                              "header": "Total CTC",
                              "dataIndex": "totalCTC",
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
                              "header": "Take Home",
                              "dataIndex": "takeHome",
                              "flex": 1
                         }, {
                              "header": "Take Home",
                              "dataIndex": "perk",
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
               "viewModel": "CostToCompanyViewModel",
               "xtype": "form",
               "displayName": "Cost To Company",
               "title": "Cost To Company",
               "name": "CostToCompany",
               "itemId": "CostToCompany",
               "bodyPadding": 10,
               "items": [{
                    "name": "salaryId",
                    "itemId": "salaryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Applicant Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Applicant Id<font color='red'> *<\/font>",
                    "fieldId": "25CB81D5-43B1-4C84-ADA9-62B7C036514B",
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
                    "fieldId": "98F21C73-03BC-4AE2-AD11-D9E1E157CC31",
                    "restURL": "EmpInformation",
                    "bindable": "empId",
                    "bind": "{empId}"
               }, {
                    "name": "totalCTC",
                    "itemId": "totalCTC",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Total CTC",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Total CTC<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "77B573B4-4B53-4D04-A670-2E95E3C95296",
                    "minValue": "0",
                    "bindable": "totalCTC",
                    "bind": "{totalCTC}"
               }, {
                    "name": "basic",
                    "itemId": "basic",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Basic",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Basic<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7A6BDFF4-62C2-4E92-902E-12B3F465DD18",
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
                    "fieldId": "93274D72-4E9C-4A89-9F83-FD57D04D7E12",
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
                    "fieldId": "555E4DF4-57D6-4213-82F8-01CE4E7BB1F4",
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
                    "fieldId": "1E1BBA40-3B8E-45E3-B258-3E8FC8A33359",
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
                    "fieldId": "89A4B9DE-DC90-4106-B7A3-80C48A3F2075",
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
                    "fieldId": "E27A9957-B179-45EC-9850-CD3DE1F4B5A6",
                    "minValue": "0",
                    "bindable": "specailAllowance",
                    "bind": "{specailAllowance}"
               }, {
                    "name": "takeHome",
                    "itemId": "takeHome",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Take Home",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Take Home<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "633947B7-CBA2-47B4-80D8-EE0F71060539",
                    "minValue": "0",
                    "bindable": "takeHome",
                    "bind": "{takeHome}"
               }, {
                    "name": "perk",
                    "itemId": "perk",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Take Home",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Take Home<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B593187F-8950-40C9-AA24-B6F193567F76",
                    "minValue": "0",
                    "bindable": "perk",
                    "bind": "{perk}"
               }, {
                    "name": "year",
                    "itemId": "year",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Year",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Year<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "544ECC1F-FDAD-4FDC-AB37-50CE8C71DFF1",
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
                    "fieldId": "1A6002FD-9759-49AF-8763-F304E1B5B4A1",
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
                    "customId": 729,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 729,
                         "customId": 262
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 729,
                         "customId": 263,
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
                         "parentId": 729,
                         "customId": 264,
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