Ext.define('Testpro.testpro.web.com.view.defaultdomain.TestEntityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestEntityMainController",
     "restURL": "/TestEntity",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro.testpro.shared.com.model.defaultdomain.TestEntityModel", "Testpro.testpro.web.com.controller.defaultdomain.TestEntityMainController", "Testpro.testpro.shared.com.viewmodel.defaultdomain.TestEntityViewModel"],
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
               "displayName": "Test Entity",
               "name": "TestEntityTreeContainer",
               "itemId": "TestEntityTreeContainer",
               "restURL": "/TestEntity",
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
                    "itemId": "TestEntityTree",
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
                    "viewModel": "TestEntityViewModel",
                    "xtype": "form",
                    "displayName": "Test Entity",
                    "title": "Test Entity",
                    "name": "TestEntity",
                    "itemId": "TestEntity",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "pk",
                         "itemId": "pk",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "pk",
                         "margin": "5 5 5 5",
                         "fieldLabel": "pk<font color='red'> *<\/font>",
                         "fieldId": "DA42195A-40ED-4B50-A769-2EF7250EC1B2",
                         "hidden": true,
                         "value": "",
                         "bindable": "pk",
                         "bind": "{pk}"
                    }, {
                         "name": "fName",
                         "itemId": "fName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "fName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "fName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0B1A8B83-CCE6-4E7B-B0DA-D44D70D9E9DC",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "fName",
                         "bind": "{fName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "lName",
                         "itemId": "lName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "lName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "lName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FA8A3E86-B666-41EF-A870-272B01FF55BB",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "lName",
                         "bind": "{lName}",
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
                         "fieldId": "B7B2571D-DD6C-4DB2-B643-A037D27B0758",
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
                         "customId": 764,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 764,
                              "customId": 826
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 764,
                              "customId": 827,
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
                              "parentId": 764,
                              "customId": 828,
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
                    "displayName": "Test Entity",
                    "title": "Details Grid",
                    "name": "TestEntityGrid",
                    "itemId": "TestEntityGrid",
                    "restURL": "/TestEntity",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "pk",
                         "dataIndex": "pk",
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
                         "header": "fName",
                         "dataIndex": "fName",
                         "flex": 1
                    }, {
                         "header": "lName",
                         "dataIndex": "lName",
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
               "viewModel": "TestEntityViewModel",
               "xtype": "form",
               "displayName": "Test Entity",
               "title": "Test Entity",
               "name": "TestEntity",
               "itemId": "TestEntity",
               "bodyPadding": 10,
               "items": [{
                    "name": "pk",
                    "itemId": "pk",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "pk",
                    "margin": "5 5 5 5",
                    "fieldLabel": "pk<font color='red'> *<\/font>",
                    "fieldId": "DA42195A-40ED-4B50-A769-2EF7250EC1B2",
                    "hidden": true,
                    "value": "",
                    "bindable": "pk",
                    "bind": "{pk}"
               }, {
                    "name": "fName",
                    "itemId": "fName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "fName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "fName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0B1A8B83-CCE6-4E7B-B0DA-D44D70D9E9DC",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "fName",
                    "bind": "{fName}",
                    "columnWidth": 0.5
               }, {
                    "name": "lName",
                    "itemId": "lName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "lName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "lName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FA8A3E86-B666-41EF-A870-272B01FF55BB",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "lName",
                    "bind": "{lName}",
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
                    "fieldId": "B7B2571D-DD6C-4DB2-B643-A037D27B0758",
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
                    "customId": 764,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 764,
                         "customId": 826
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 764,
                         "customId": 827,
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
                         "parentId": 764,
                         "customId": 828,
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