Ext.define('Testl.testl.web.com.view.humanresourcecontext.employee.EmpIdProofMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "controller": "EmpIdProofMainController",
     "restURL": "/EmpIdProof",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.web.com.controller.humanresourcecontext.employee.EmpIdProofMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.model.humanresourcecontext.employee.IdProofInformationModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.employee.EmpIdProofViewModel"],
     "tabPosition": "bottom",
     "communicationLog": [],
     "itemId": "EmpIdProofFormGridContainer",
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
                    "viewModel": "EmpIdProofViewModel",
                    "xtype": "form",
                    "displayName": "EmpId Proof",
                    "title": "EmpId Proof",
                    "name": "EmpIdProof",
                    "itemId": "EmpIdProof",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "empIdpk",
                         "itemId": "empIdpk",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "empIdpk",
                         "margin": "5 5 5 5",
                         "fieldLabel": "empIdpk<font color='red'> *<\/font>",
                         "fieldId": "FA3C2BD8-047D-4501-84C6-906ED0916B13",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "empIdpk",
                         "bind": "{empIdpk}"
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
                         "fieldId": "BC46B840-10F8-4C83-B7BD-2F43052DB12C",
                         "restURL": "EmpInformation",
                         "bindable": "empId",
                         "bind": "{empId}"
                    }, {
                         "name": "idCode",
                         "itemId": "idCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Id Proof Type",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.IdProofInformationModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Id Proof Type<font color='red'> *<\/font>",
                         "fieldId": "CAB1838C-F6A1-49F0-B35A-AD2469B4ED1A",
                         "restURL": "IdProofInformation",
                         "bindable": "idCode",
                         "bind": "{idCode}"
                    }, {
                         "name": "idData",
                         "itemId": "idData",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Id Proof Value",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Id Proof Value<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "746EEDD9-B48D-4823-B785-B59C3E0ADCA9",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "idData",
                         "bind": "{idData}"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "E0D6D276-D774-4066-A2C8-3689661F0F9C",
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
                         "customId": 242,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 242,
                              "customId": 830
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 242,
                              "customId": 831,
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
                              "parentId": 242,
                              "customId": 832,
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
                         "header": "empIdpk",
                         "dataIndex": "empIdpk",
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
                         "header": "Id Proof Type",
                         "dataIndex": "idCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Id Proof Value",
                         "dataIndex": "idData",
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
                              "fieldId": "BC46B840-10F8-4C83-B7BD-2F43052DB12C",
                              "restURL": "EmpInformation",
                              "bindable": "empId"
                         }, {
                              "name": "idCode",
                              "itemId": "idCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Id Proof Type",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.IdProofInformationModel"
                              },
                              "fieldLabel": "Id Proof Type",
                              "fieldId": "CAB1838C-F6A1-49F0-B35A-AD2469B4ED1A",
                              "restURL": "IdProofInformation",
                              "bindable": "idCode"
                         }, {
                              "name": "idData",
                              "itemId": "idData",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Id Proof Value",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Id Proof Value",
                              "fieldId": "746EEDD9-B48D-4823-B785-B59C3E0ADCA9",
                              "minLength": "0",
                              "maxLength": "128",
                              "bindable": "idData"
                         }]
                    }, {
                         "region": "center",
                         "xtype": "gridpanel",
                         "customWidgetType": "vdGrid",
                         "displayName": "EmpId Proof",
                         "name": "EmpIdProofGrid",
                         "itemId": "EmpIdProofGrid",
                         "restURL": "/EmpIdProof",
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
                              "header": "empIdpk",
                              "dataIndex": "empIdpk",
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
                              "header": "Id Proof Type",
                              "dataIndex": "idCode",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Id Proof Value",
                              "dataIndex": "idData",
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
               "viewModel": "EmpIdProofViewModel",
               "xtype": "form",
               "displayName": "EmpId Proof",
               "title": "EmpId Proof",
               "name": "EmpIdProof",
               "itemId": "EmpIdProof",
               "bodyPadding": 10,
               "items": [{
                    "name": "empIdpk",
                    "itemId": "empIdpk",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "empIdpk",
                    "margin": "5 5 5 5",
                    "fieldLabel": "empIdpk<font color='red'> *<\/font>",
                    "fieldId": "FA3C2BD8-047D-4501-84C6-906ED0916B13",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "empIdpk",
                    "bind": "{empIdpk}"
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
                    "fieldId": "BC46B840-10F8-4C83-B7BD-2F43052DB12C",
                    "restURL": "EmpInformation",
                    "bindable": "empId",
                    "bind": "{empId}"
               }, {
                    "name": "idCode",
                    "itemId": "idCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Id Proof Type",
                    "margin": "5 5 5 5",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.IdProofInformationModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Id Proof Type<font color='red'> *<\/font>",
                    "fieldId": "CAB1838C-F6A1-49F0-B35A-AD2469B4ED1A",
                    "restURL": "IdProofInformation",
                    "bindable": "idCode",
                    "bind": "{idCode}"
               }, {
                    "name": "idData",
                    "itemId": "idData",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Id Proof Value",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Id Proof Value<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "746EEDD9-B48D-4823-B785-B59C3E0ADCA9",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "idData",
                    "bind": "{idData}"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "E0D6D276-D774-4066-A2C8-3689661F0F9C",
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
                    "customId": 242,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 242,
                         "customId": 830
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 242,
                         "customId": 831,
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
                         "parentId": 242,
                         "customId": 832,
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