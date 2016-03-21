Ext.define('Newol.newol.web.com.view.shoppingcontext.onlineshopping.OrderTransactionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "OrderTransactionMainController",
     "restURL": "/OrderTransaction",
     "defaults": {
          "split": true
     },
     "requires": ["Newol.newol.shared.com.model.shoppingcontext.onlineshopping.OrderTransactionModel", "Newol.newol.web.com.controller.shoppingcontext.onlineshopping.OrderTransactionMainController", "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.OrderMainModel", "Newol.newol.shared.com.viewmodel.shoppingcontext.onlineshopping.OrderTransactionViewModel"],
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
               "displayName": "OrderTransaction",
               "name": "OrderTransactionTreeContainer",
               "itemId": "OrderTransactionTreeContainer",
               "restURL": "/OrderTransaction",
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
                    "itemId": "OrderTransactionTree",
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
                    "items": [{
                         "name": "orderId",
                         "itemId": "orderId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Order Id",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.OrderMainModel"
                         },
                         "fieldLabel": "Order Id",
                         "fieldId": "020201D7-5C53-48B5-89CD-B2B06ADAAB31",
                         "restURL": "OrderMain",
                         "bindable": "orderId"
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
                    "xtype": "form",
                    "displayName": "OrderTransaction",
                    "title": "OrderTransaction",
                    "name": "OrderTransaction",
                    "itemId": "OrderTransactionForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "orderTransactionId",
                         "itemId": "orderTransactionId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Order Transaction Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Order Transaction Id<font color='red'> *<\/font>",
                         "fieldId": "67AC5478-BE15-4A2E-9525-73923E410969",
                         "hidden": true,
                         "value": "",
                         "bindable": "orderTransactionId"
                    }, {
                         "name": "orderId",
                         "itemId": "orderId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Order Id",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.OrderMainModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Order Id<font color='red'> *<\/font>",
                         "fieldId": "020201D7-5C53-48B5-89CD-B2B06ADAAB31",
                         "restURL": "OrderMain",
                         "bindable": "orderId",
                         "columnWidth": 0.5
                    }, {
                         "name": "transactionId",
                         "itemId": "transactionId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Transaction Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Transaction Id<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "EFEB883F-C04D-4CAF-B77B-C21A1243AC28",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "transactionId",
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
                         "fieldId": "11BC005B-344A-423A-955A-B6D493EF6832",
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
                         "customId": 554,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 554,
                              "customId": 483
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 554,
                              "customId": 484,
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
                              "parentId": 554,
                              "customId": 485,
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
                    "displayName": "OrderTransaction",
                    "title": "Details Grid",
                    "name": "OrderTransactionGrid",
                    "itemId": "OrderTransactionGrid",
                    "restURL": "/OrderTransaction",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Order Transaction Id",
                         "dataIndex": "orderTransactionId",
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
                         "header": "Order Id",
                         "dataIndex": "orderId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Transaction Id",
                         "dataIndex": "transactionId",
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
               "displayName": "OrderTransaction",
               "title": "OrderTransaction",
               "name": "OrderTransaction",
               "itemId": "OrderTransactionForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "orderTransactionId",
                    "itemId": "orderTransactionId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Order Transaction Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Order Transaction Id<font color='red'> *<\/font>",
                    "fieldId": "67AC5478-BE15-4A2E-9525-73923E410969",
                    "hidden": true,
                    "value": "",
                    "bindable": "orderTransactionId"
               }, {
                    "name": "orderId",
                    "itemId": "orderId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Order Id",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.OrderMainModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Order Id<font color='red'> *<\/font>",
                    "fieldId": "020201D7-5C53-48B5-89CD-B2B06ADAAB31",
                    "restURL": "OrderMain",
                    "bindable": "orderId",
                    "columnWidth": 0.5
               }, {
                    "name": "transactionId",
                    "itemId": "transactionId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Transaction Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Transaction Id<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "EFEB883F-C04D-4CAF-B77B-C21A1243AC28",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "transactionId",
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
                    "fieldId": "11BC005B-344A-423A-955A-B6D493EF6832",
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
                    "customId": 554,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 554,
                         "customId": 483
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 554,
                         "customId": 484,
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
                         "parentId": 554,
                         "customId": 485,
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