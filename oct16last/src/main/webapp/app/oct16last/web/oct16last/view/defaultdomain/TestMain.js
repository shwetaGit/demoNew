Ext.define('Oct16last.oct16last.web.oct16last.view.defaultdomain.TestMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestMainController",
     "restURL": "/Test",
     "defaults": {
          "split": true
     },
     "requires": ["Oct16last.oct16last.shared.oct16last.model.defaultdomain.TestModel", "Oct16last.oct16last.web.oct16last.controller.defaultdomain.TestMainController", "Oct16last.oct16last.shared.oct16last.viewmodel.defaultdomain.TestViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "test",
               "name": "TestTreeContainer",
               "itemId": "TestTreeContainer",
               "restURL": "/Test",
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
                    "itemId": "TestTree",
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
                         "name": "stringchk",
                         "itemId": "stringchk",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "stringchk",
                         "margin": "5 5 5 5",
                         "value": "helloffff",
                         "fieldLabel": "stringchk",
                         "fieldId": "41789DD8-427B-41FC-82E1-B5B9C9FA04B1",
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
                    "viewModel": "TestViewModel",
                    "xtype": "form",
                    "displayName": "test",
                    "title": "test",
                    "name": "Test",
                    "itemId": "Test",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "stringchk",
                         "itemId": "stringchk",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "stringchk",
                         "margin": "5 5 5 5",
                         "value": "helloffff",
                         "fieldLabel": "stringchk",
                         "fieldId": "41789DD8-427B-41FC-82E1-B5B9C9FA04B1",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{stringchk}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cc",
                         "itemId": "cc",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "integar",
                         "margin": "5 5 5 5",
                         "value": "1236565",
                         "fieldLabel": "integar",
                         "fieldId": "64A8DA7B-607E-4489-923B-E452CE60F8EA",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bind": "{cc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "floatchk",
                         "itemId": "floatchk",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "float",
                         "margin": "5 5 5 5",
                         "value": "162632",
                         "fieldLabel": "float",
                         "fieldId": "8E78FE23-5A86-4463-A797-71D372E454DA",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bind": "{floatchk}",
                         "columnWidth": 0.5
                    }, {
                         "name": "doublechk",
                         "itemId": "doublechk",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Doublechk",
                         "margin": "5 5 5 5",
                         "value": "415321.23",
                         "fieldLabel": "Doublechk",
                         "fieldId": "0C717AED-4EF1-4083-9981-310C7C11B835",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bind": "{doublechk}",
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
                         "customId": 89,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 89,
                              "customId": 557
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 89,
                              "customId": 558,
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
                              "parentId": 89,
                              "customId": 559,
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
                    "displayName": "test",
                    "title": "Details Grid",
                    "name": "TestGrid",
                    "itemId": "TestGrid",
                    "restURL": "/Test",
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
                         "header": "stringchk",
                         "dataIndex": "stringchk",
                         "flex": 1
                    }, {
                         "header": "integar",
                         "dataIndex": "cc",
                         "flex": 1
                    }, {
                         "header": "float",
                         "dataIndex": "floatchk",
                         "flex": 1
                    }, {
                         "header": "Doublechk",
                         "dataIndex": "doublechk",
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
               "viewModel": "TestViewModel",
               "xtype": "form",
               "displayName": "test",
               "title": "test",
               "name": "Test",
               "itemId": "Test",
               "bodyPadding": 10,
               "items": [{
                    "name": "stringchk",
                    "itemId": "stringchk",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "stringchk",
                    "margin": "5 5 5 5",
                    "value": "helloffff",
                    "fieldLabel": "stringchk",
                    "fieldId": "41789DD8-427B-41FC-82E1-B5B9C9FA04B1",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{stringchk}",
                    "columnWidth": 0.5
               }, {
                    "name": "cc",
                    "itemId": "cc",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "integar",
                    "margin": "5 5 5 5",
                    "value": "1236565",
                    "fieldLabel": "integar",
                    "fieldId": "64A8DA7B-607E-4489-923B-E452CE60F8EA",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bind": "{cc}",
                    "columnWidth": 0.5
               }, {
                    "name": "floatchk",
                    "itemId": "floatchk",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "float",
                    "margin": "5 5 5 5",
                    "value": "162632",
                    "fieldLabel": "float",
                    "fieldId": "8E78FE23-5A86-4463-A797-71D372E454DA",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bind": "{floatchk}",
                    "columnWidth": 0.5
               }, {
                    "name": "doublechk",
                    "itemId": "doublechk",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Doublechk",
                    "margin": "5 5 5 5",
                    "value": "415321.23",
                    "fieldLabel": "Doublechk",
                    "fieldId": "0C717AED-4EF1-4083-9981-310C7C11B835",
                    "minValue": "-9223372000000000000",
                    "maxValue": "9223372000000000000",
                    "bind": "{doublechk}",
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
                    "customId": 89,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 89,
                         "customId": 557
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 89,
                         "customId": 558,
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
                         "parentId": 89,
                         "customId": 559,
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