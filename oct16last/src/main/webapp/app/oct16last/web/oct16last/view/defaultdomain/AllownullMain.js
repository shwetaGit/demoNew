Ext.define('Oct16last.oct16last.web.oct16last.view.defaultdomain.AllownullMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AllownullMainController",
     "restURL": "/Allownull",
     "defaults": {
          "split": true
     },
     "requires": ["Oct16last.oct16last.shared.oct16last.model.defaultdomain.AllownullModel", "Oct16last.oct16last.web.oct16last.controller.defaultdomain.AllownullMainController", "Oct16last.oct16last.shared.oct16last.viewmodel.defaultdomain.AllownullViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "allownull",
               "name": "AllownullTreeContainer",
               "itemId": "AllownullTreeContainer",
               "restURL": "/Allownull",
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
                    "itemId": "AllownullTree",
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
                    "viewModel": "AllownullViewModel",
                    "xtype": "form",
                    "displayName": "allownull",
                    "title": "allownull",
                    "name": "Allownull",
                    "itemId": "Allownull",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "a1",
                         "itemId": "a1",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "a1",
                         "margin": "5 5 5 5",
                         "inputValue": true,
                         "fieldLabel": "a1",
                         "fieldId": "5D89A7FC-7E05-4F88-9133-5035BB7B2546",
                         "bind": "{a1}",
                         "columnWidth": 0.5
                    }, {
                         "name": "a2",
                         "itemId": "a2",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "a2",
                         "margin": "5 5 5 5",
                         "inputValue": true,
                         "fieldLabel": "a2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "57FC3795-E32F-431E-94AC-8742EBBFD3E3",
                         "bind": "{a2}",
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
                         "customId": 445,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 445,
                              "customId": 425
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 445,
                              "customId": 426,
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
                              "parentId": 445,
                              "customId": 427,
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
                    "displayName": "allownull",
                    "title": "Details Grid",
                    "name": "AllownullGrid",
                    "itemId": "AllownullGrid",
                    "restURL": "/Allownull",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "pk1",
                         "dataIndex": "pk1",
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
                         "header": "a1",
                         "dataIndex": "a1",
                         "flex": 1
                    }, {
                         "header": "a2",
                         "dataIndex": "a2",
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
               "viewModel": "AllownullViewModel",
               "xtype": "form",
               "displayName": "allownull",
               "title": "allownull",
               "name": "Allownull",
               "itemId": "Allownull",
               "bodyPadding": 10,
               "items": [{
                    "name": "a1",
                    "itemId": "a1",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "a1",
                    "margin": "5 5 5 5",
                    "inputValue": true,
                    "fieldLabel": "a1",
                    "fieldId": "5D89A7FC-7E05-4F88-9133-5035BB7B2546",
                    "bind": "{a1}",
                    "columnWidth": 0.5
               }, {
                    "name": "a2",
                    "itemId": "a2",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "a2",
                    "margin": "5 5 5 5",
                    "inputValue": true,
                    "fieldLabel": "a2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "57FC3795-E32F-431E-94AC-8742EBBFD3E3",
                    "bind": "{a2}",
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
                    "customId": 445,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 445,
                         "customId": 425
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 445,
                         "customId": 426,
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
                         "parentId": 445,
                         "customId": 427,
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