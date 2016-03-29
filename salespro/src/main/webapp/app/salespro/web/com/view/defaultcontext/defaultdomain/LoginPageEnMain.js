Ext.define('Salespro.salespro.web.com.view.defaultcontext.defaultdomain.LoginPageEnMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "LoginPageEnMainController",
     "restURL": "/LoginPageEn",
     "defaults": {
          "split": true
     },
     "requires": ["Salespro.salespro.shared.com.model.defaultcontext.defaultdomain.LoginPageEnModel", "Salespro.salespro.web.com.controller.defaultcontext.defaultdomain.LoginPageEnMainController", "Salespro.salespro.shared.com.viewmodel.defaultcontext.defaultdomain.LoginPageEnViewModel"],
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
               "displayName": "LoginPageEn",
               "name": "LoginPageEnTreeContainer",
               "itemId": "LoginPageEnTreeContainer",
               "restURL": "/LoginPageEn",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "LoginPageEnTree",
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
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
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
                    "xtype": "form",
                    "displayName": "LoginPageEn",
                    "title": "LoginPageEn",
                    "name": "LoginPageEn",
                    "itemId": "LoginPageEnForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "firstName",
                         "itemId": "firstName",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "First Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "First Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E147A59C-79F5-4840-858F-317C55955224",
                         "bindable": "firstName",
                         "columnWidth": 0.5
                    }, {
                         "name": "loginUuid",
                         "itemId": "loginUuid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "loginUuid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "loginUuid<font color='red'> *<\/font>",
                         "fieldId": "A7782073-C4C1-41C6-947F-ADB703553358",
                         "hidden": true,
                         "value": "",
                         "bindable": "loginUuid"
                    }, {
                         "name": "lastName",
                         "itemId": "lastName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Last Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Last Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "EB164A57-B32C-4F96-9E98-F4E4A3FD0EEE",
                         "minLength": "1",
                         "maxLength": "256",
                         "errorMessage": "Please Enter Last Name",
                         "bindable": "lastName",
                         "columnWidth": 0.5
                    }, {
                         "name": "companyName",
                         "itemId": "companyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Compnay Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Compnay Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BACA35A4-788D-4011-AEDF-4C9AD1BA44D7",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "companyName",
                         "columnWidth": 0.5
                    }, {
                         "name": "localAddress",
                         "itemId": "localAddress",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Address",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Address<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E2CEE2AE-037B-4F01-9FA3-17DBE80E9CC6",
                         "errorMessage": "Enter Address",
                         "bindable": "localAddress",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "9DD36B42-8C27-4406-B367-8D7E73F13010",
                         "bindable": "versionId",
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
                         "customId": 692,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 692,
                              "customId": 398
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 692,
                              "customId": 399,
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
                              "parentId": 692,
                              "customId": 400,
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
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "LoginPageEn",
                    "title": "Details Grid",
                    "name": "LoginPageEnGrid",
                    "itemId": "LoginPageEnGrid",
                    "restURL": "/LoginPageEn",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "First Name",
                         "dataIndex": "firstName",
                         "flex": 1
                    }, {
                         "header": "loginUuid",
                         "dataIndex": "loginUuid",
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
                         "header": "Last Name",
                         "dataIndex": "lastName",
                         "flex": 1
                    }, {
                         "header": "Compnay Name",
                         "dataIndex": "companyName",
                         "flex": 1
                    }, {
                         "header": "Address",
                         "dataIndex": "localAddress",
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
               "xtype": "form",
               "displayName": "LoginPageEn",
               "title": "LoginPageEn",
               "name": "LoginPageEn",
               "itemId": "LoginPageEnForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "firstName",
                    "itemId": "firstName",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "First Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "First Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E147A59C-79F5-4840-858F-317C55955224",
                    "bindable": "firstName",
                    "columnWidth": 0.5
               }, {
                    "name": "loginUuid",
                    "itemId": "loginUuid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "loginUuid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "loginUuid<font color='red'> *<\/font>",
                    "fieldId": "A7782073-C4C1-41C6-947F-ADB703553358",
                    "hidden": true,
                    "value": "",
                    "bindable": "loginUuid"
               }, {
                    "name": "lastName",
                    "itemId": "lastName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Last Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Last Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "EB164A57-B32C-4F96-9E98-F4E4A3FD0EEE",
                    "minLength": "1",
                    "maxLength": "256",
                    "errorMessage": "Please Enter Last Name",
                    "bindable": "lastName",
                    "columnWidth": 0.5
               }, {
                    "name": "companyName",
                    "itemId": "companyName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Compnay Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Compnay Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BACA35A4-788D-4011-AEDF-4C9AD1BA44D7",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "companyName",
                    "columnWidth": 0.5
               }, {
                    "name": "localAddress",
                    "itemId": "localAddress",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Address",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Address<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E2CEE2AE-037B-4F01-9FA3-17DBE80E9CC6",
                    "errorMessage": "Enter Address",
                    "bindable": "localAddress",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "9DD36B42-8C27-4406-B367-8D7E73F13010",
                    "bindable": "versionId",
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
                    "customId": 692,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 692,
                         "customId": 398
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 692,
                         "customId": 399,
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
                         "parentId": 692,
                         "customId": 400,
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