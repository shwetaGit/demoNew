Ext.define('Testproject1.testproject1.web.com.view.contacts.ContactTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ContactTypeMainController",
     "restURL": "/ContactType",
     "defaults": {
          "split": true
     },
     "requires": ["Testproject1.testproject1.shared.com.model.contacts.ContactTypeModel", "Testproject1.testproject1.web.com.controller.contacts.ContactTypeMainController", "Testproject1.testproject1.shared.com.viewmodel.contacts.ContactTypeViewModel"],
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
               "displayName": "Contact Type",
               "name": "ContactTypeTreeContainer",
               "itemId": "ContactTypeTreeContainer",
               "restURL": "/ContactType",
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
                    "itemId": "ContactTypeTree",
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
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type",
                         "fieldId": "8C4E3451-2A69-46A5-AD16-77B5EBF0481B",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type"
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
                    "viewModel": "ContactTypeViewModel",
                    "xtype": "form",
                    "displayName": "Contact Type",
                    "title": "Contact Type",
                    "name": "ContactType",
                    "itemId": "ContactType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "contactTypeId",
                         "itemId": "contactTypeId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Id<font color='red'> *<\/font>",
                         "fieldId": "E74958D1-E774-491B-815F-2B0DFEAA2237",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "contactTypeId",
                         "bind": "{contactTypeId}"
                    }, {
                         "name": "contactType",
                         "itemId": "contactType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8C4E3451-2A69-46A5-AD16-77B5EBF0481B",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter contact type",
                         "bindable": "contactType",
                         "bind": "{contactType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeDesc",
                         "itemId": "contactTypeDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Contact Type Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Description",
                         "fieldId": "7BFCF487-4F36-4BFF-992F-42DFE27A06DE",
                         "bindable": "contactTypeDesc",
                         "bind": "{contactTypeDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactTypeIcon",
                         "itemId": "contactTypeIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Contact Type Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact Type Icon",
                         "fieldId": "F3C98E68-9B6E-46CF-8B54-5ED2053E2415",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "contactTypeIcon",
                         "bind": "{contactTypeIcon}",
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
                         "fieldId": "FD61771F-2CDB-44C2-ABB4-37326C3FC69A",
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
                         "customId": 947,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 947,
                              "customId": 400
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 947,
                              "customId": 401,
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
                              "parentId": 947,
                              "customId": 402,
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
                    "displayName": "Contact Type",
                    "title": "Details Grid",
                    "name": "ContactTypeGrid",
                    "itemId": "ContactTypeGrid",
                    "restURL": "/ContactType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Contact Type Id",
                         "dataIndex": "contactTypeId",
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
                         "header": "Contact Type",
                         "dataIndex": "contactType",
                         "flex": 1
                    }, {
                         "header": "Contact Type Description",
                         "dataIndex": "contactTypeDesc",
                         "flex": 1
                    }, {
                         "header": "Contact Type Icon",
                         "dataIndex": "contactTypeIcon",
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
               "viewModel": "ContactTypeViewModel",
               "xtype": "form",
               "displayName": "Contact Type",
               "title": "Contact Type",
               "name": "ContactType",
               "itemId": "ContactType",
               "bodyPadding": 10,
               "items": [{
                    "name": "contactTypeId",
                    "itemId": "contactTypeId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Id<font color='red'> *<\/font>",
                    "fieldId": "E74958D1-E774-491B-815F-2B0DFEAA2237",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "contactTypeId",
                    "bind": "{contactTypeId}"
               }, {
                    "name": "contactType",
                    "itemId": "contactType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8C4E3451-2A69-46A5-AD16-77B5EBF0481B",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter contact type",
                    "bindable": "contactType",
                    "bind": "{contactType}",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeDesc",
                    "itemId": "contactTypeDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Contact Type Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Description",
                    "fieldId": "7BFCF487-4F36-4BFF-992F-42DFE27A06DE",
                    "bindable": "contactTypeDesc",
                    "bind": "{contactTypeDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "contactTypeIcon",
                    "itemId": "contactTypeIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Contact Type Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact Type Icon",
                    "fieldId": "F3C98E68-9B6E-46CF-8B54-5ED2053E2415",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "contactTypeIcon",
                    "bind": "{contactTypeIcon}",
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
                    "fieldId": "FD61771F-2CDB-44C2-ABB4-37326C3FC69A",
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
                    "customId": 947,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 947,
                         "customId": 400
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 947,
                         "customId": 401,
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
                         "parentId": 947,
                         "customId": 402,
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