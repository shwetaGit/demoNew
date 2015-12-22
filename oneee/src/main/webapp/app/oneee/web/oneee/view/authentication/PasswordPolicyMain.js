Ext.define('Oneee.oneee.web.oneee.view.authentication.PasswordPolicyMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "PasswordPolicyMainController",
     "restURL": "/PasswordPolicy",
     "defaults": {
          "split": true
     },
     "requires": ["Oneee.oneee.shared.oneee.model.authentication.PasswordPolicyModel", "Oneee.oneee.web.oneee.controller.authentication.PasswordPolicyMainController", "Oneee.oneee.shared.oneee.viewmodel.authentication.PasswordPolicyViewModel", "Ext.form.field.CustomDateField"],
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
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Password Policy",
               "name": "PasswordPolicyTreeContainer",
               "itemId": "PasswordPolicyTreeContainer",
               "restURL": "/PasswordPolicy",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "PasswordPolicyTree",
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
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "policyName",
                         "itemId": "policyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "7D031873-E14F-4E92-B378-0FF66AF115FE",
                         "minLength": "0",
                         "maxLength": "256"
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
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "PasswordPolicyViewModel",
                    "xtype": "form",
                    "displayName": "Password Policy",
                    "title": "Password Policy",
                    "name": "PasswordPolicy",
                    "itemId": "PasswordPolicy",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "policyName",
                         "itemId": "policyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7D031873-E14F-4E92-B378-0FF66AF115FE",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{policyName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "policyDescription",
                         "itemId": "policyDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "policyDescription",
                         "margin": "5 5 5 5",
                         "fieldLabel": "policyDescription",
                         "fieldId": "3E4A1C0C-A09B-4EA1-99F7-A0802689CA98",
                         "bind": "{policyDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "maxPwdLength",
                         "itemId": "maxPwdLength",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "maxPwdLength",
                         "margin": "5 5 5 5",
                         "fieldLabel": "maxPwdLength",
                         "fieldId": "86376FCB-D036-4F29-B6E8-040BB8FC6ECB",
                         "minValue": "0",
                         "maxValue": "32",
                         "bind": "{maxPwdLength}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minPwdLength",
                         "itemId": "minPwdLength",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minPwdLength",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minPwdLength<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6FF692BC-478A-4024-9B03-C4DAE57E2D74",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minPwdLength}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minCapitalLetters",
                         "itemId": "minCapitalLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minCapitalLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minCapitalLetters",
                         "fieldId": "DB2A0CD6-303F-4DDB-B23E-45A8953CA815",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minCapitalLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minSmallLetters",
                         "itemId": "minSmallLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minSmallLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minSmallLetters",
                         "fieldId": "C0F204C3-9D36-4981-A1E8-295B359B56C1",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minSmallLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minNumericValues",
                         "itemId": "minNumericValues",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minNumericValues",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minNumericValues",
                         "fieldId": "78CB98DA-D2DD-40AA-AAAB-747EBADF6337",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minNumericValues}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minSpecialLetters",
                         "itemId": "minSpecialLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minSpecialLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minSpecialLetters",
                         "fieldId": "C2E553D7-5FFF-4F91-AE6D-DC5ECA07D2FA",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{minSpecialLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "allowedSpecialLetters",
                         "itemId": "allowedSpecialLetters",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "allowedSpecialLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "allowedSpecialLetters",
                         "fieldId": "97D95DC1-2D93-46DA-B037-58E6E6E437C7",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{allowedSpecialLetters}",
                         "columnWidth": 0.5
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
                         "customId": 479,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 479,
                              "customId": 799
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 479,
                              "customId": 800,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 479,
                              "customId": 801,
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
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Password Policy",
                    "title": "Details Grid",
                    "name": "PasswordPolicyGrid",
                    "itemId": "PasswordPolicyGrid",
                    "restURL": "/PasswordPolicy",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Policy Id",
                         "dataIndex": "policyId",
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
                         "header": "Name",
                         "dataIndex": "policyName",
                         "flex": 1
                    }, {
                         "header": "policyDescription",
                         "dataIndex": "policyDescription",
                         "flex": 1
                    }, {
                         "header": "maxPwdLength",
                         "dataIndex": "maxPwdLength",
                         "flex": 1
                    }, {
                         "header": "minPwdLength",
                         "dataIndex": "minPwdLength",
                         "flex": 1
                    }, {
                         "header": "minCapitalLetters",
                         "dataIndex": "minCapitalLetters",
                         "flex": 1
                    }, {
                         "header": "minSmallLetters",
                         "dataIndex": "minSmallLetters",
                         "flex": 1
                    }, {
                         "header": "minNumericValues",
                         "dataIndex": "minNumericValues",
                         "flex": 1
                    }, {
                         "header": "minSpecialLetters",
                         "dataIndex": "minSpecialLetters",
                         "flex": 1
                    }, {
                         "header": "allowedSpecialLetters",
                         "dataIndex": "allowedSpecialLetters",
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
               "customWidgetType": "vdFormpanel",
               "viewModel": "PasswordPolicyViewModel",
               "xtype": "form",
               "displayName": "Password Policy",
               "title": "Password Policy",
               "name": "PasswordPolicy",
               "itemId": "PasswordPolicy",
               "bodyPadding": 10,
               "items": [{
                    "name": "policyName",
                    "itemId": "policyName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7D031873-E14F-4E92-B378-0FF66AF115FE",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{policyName}",
                    "columnWidth": 0.5
               }, {
                    "name": "policyDescription",
                    "itemId": "policyDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "policyDescription",
                    "margin": "5 5 5 5",
                    "fieldLabel": "policyDescription",
                    "fieldId": "3E4A1C0C-A09B-4EA1-99F7-A0802689CA98",
                    "bind": "{policyDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "maxPwdLength",
                    "itemId": "maxPwdLength",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "maxPwdLength",
                    "margin": "5 5 5 5",
                    "fieldLabel": "maxPwdLength",
                    "fieldId": "86376FCB-D036-4F29-B6E8-040BB8FC6ECB",
                    "minValue": "0",
                    "maxValue": "32",
                    "bind": "{maxPwdLength}",
                    "columnWidth": 0.5
               }, {
                    "name": "minPwdLength",
                    "itemId": "minPwdLength",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minPwdLength",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minPwdLength<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6FF692BC-478A-4024-9B03-C4DAE57E2D74",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minPwdLength}",
                    "columnWidth": 0.5
               }, {
                    "name": "minCapitalLetters",
                    "itemId": "minCapitalLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minCapitalLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minCapitalLetters",
                    "fieldId": "DB2A0CD6-303F-4DDB-B23E-45A8953CA815",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minCapitalLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "minSmallLetters",
                    "itemId": "minSmallLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minSmallLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minSmallLetters",
                    "fieldId": "C0F204C3-9D36-4981-A1E8-295B359B56C1",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minSmallLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "minNumericValues",
                    "itemId": "minNumericValues",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minNumericValues",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minNumericValues",
                    "fieldId": "78CB98DA-D2DD-40AA-AAAB-747EBADF6337",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minNumericValues}",
                    "columnWidth": 0.5
               }, {
                    "name": "minSpecialLetters",
                    "itemId": "minSpecialLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minSpecialLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minSpecialLetters",
                    "fieldId": "C2E553D7-5FFF-4F91-AE6D-DC5ECA07D2FA",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{minSpecialLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "allowedSpecialLetters",
                    "itemId": "allowedSpecialLetters",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "allowedSpecialLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "allowedSpecialLetters",
                    "fieldId": "97D95DC1-2D93-46DA-B037-58E6E6E437C7",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{allowedSpecialLetters}",
                    "columnWidth": 0.5
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
                    "customId": 479,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 479,
                         "customId": 799
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 479,
                         "customId": 800,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 479,
                         "customId": 801,
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
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});