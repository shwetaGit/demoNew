Ext.define('Oct16last.oct16last.web.oct16last.view.defaultdomain.TestingMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestingMainController",
     "restURL": "/Testing",
     "defaults": {
          "split": true
     },
     "requires": ["Oct16last.oct16last.shared.oct16last.model.defaultdomain.TestingModel", "Oct16last.oct16last.web.oct16last.controller.defaultdomain.TestingMainController", "Oct16last.oct16last.shared.oct16last.viewmodel.defaultdomain.TestingViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "testing",
               "name": "TestingTreeContainer",
               "itemId": "TestingTreeContainer",
               "restURL": "/Testing",
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
                    "itemId": "TestingTree",
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
                    "viewModel": "TestingViewModel",
                    "xtype": "form",
                    "displayName": "testing",
                    "title": "testing",
                    "name": "Testing",
                    "itemId": "Testing",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "checktest",
                         "itemId": "checktest",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "checktest",
                         "margin": "5 5 5 5",
                         "fieldLabel": "checktest",
                         "fieldId": "FABFBC3D-7C94-48B6-8881-3B023B9FD20B",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{checktest}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stringvalue",
                         "itemId": "stringvalue",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "stringvalue",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "inputValue": true,
                         "fieldLabel": "stringvalue",
                         "fieldId": "A3E3E7E7-5602-4042-91C0-19500112D5DD",
                         "bind": "{stringvalue}",
                         "columnWidth": 0.5
                    }, {
                         "name": "male",
                         "itemId": "male",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "male",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "male",
                         "fieldId": "5E0D58FF-26ED-4FE3-A601-0EE9062A341D",
                         "bind": "{male}",
                         "columnWidth": 0.5
                    }, {
                         "name": "female",
                         "itemId": "female",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "female",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "inputValue": true,
                         "fieldLabel": "female",
                         "fieldId": "49A802A5-D906-4DCB-88BE-CF9841B43A8B",
                         "bind": "{female}",
                         "columnWidth": 0.5
                    }, {
                         "name": "student",
                         "itemId": "student",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "student",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "student",
                         "fieldId": "6C0602D8-6EA6-4D36-9D2F-96EC30C5ADD4",
                         "bind": "{student}",
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
                         "customId": 949,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 949,
                              "customId": 300
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 949,
                              "customId": 301,
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
                              "parentId": 949,
                              "customId": 302,
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
                    "displayName": "testing",
                    "title": "Details Grid",
                    "name": "TestingGrid",
                    "itemId": "TestingGrid",
                    "restURL": "/Testing",
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
                         "header": "checktest",
                         "dataIndex": "checktest",
                         "flex": 1
                    }, {
                         "header": "stringvalue",
                         "dataIndex": "stringvalue",
                         "flex": 1
                    }, {
                         "header": "male",
                         "dataIndex": "male",
                         "flex": 1
                    }, {
                         "header": "female",
                         "dataIndex": "female",
                         "flex": 1
                    }, {
                         "header": "student",
                         "dataIndex": "student",
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
               "viewModel": "TestingViewModel",
               "xtype": "form",
               "displayName": "testing",
               "title": "testing",
               "name": "Testing",
               "itemId": "Testing",
               "bodyPadding": 10,
               "items": [{
                    "name": "checktest",
                    "itemId": "checktest",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "checktest",
                    "margin": "5 5 5 5",
                    "fieldLabel": "checktest",
                    "fieldId": "FABFBC3D-7C94-48B6-8881-3B023B9FD20B",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{checktest}",
                    "columnWidth": 0.5
               }, {
                    "name": "stringvalue",
                    "itemId": "stringvalue",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "stringvalue",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "inputValue": true,
                    "fieldLabel": "stringvalue",
                    "fieldId": "A3E3E7E7-5602-4042-91C0-19500112D5DD",
                    "bind": "{stringvalue}",
                    "columnWidth": 0.5
               }, {
                    "name": "male",
                    "itemId": "male",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "male",
                    "margin": "5 5 5 5",
                    "value": "0",
                    "inputValue": true,
                    "fieldLabel": "male",
                    "fieldId": "5E0D58FF-26ED-4FE3-A601-0EE9062A341D",
                    "bind": "{male}",
                    "columnWidth": 0.5
               }, {
                    "name": "female",
                    "itemId": "female",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "female",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "inputValue": true,
                    "fieldLabel": "female",
                    "fieldId": "49A802A5-D906-4DCB-88BE-CF9841B43A8B",
                    "bind": "{female}",
                    "columnWidth": 0.5
               }, {
                    "name": "student",
                    "itemId": "student",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "student",
                    "margin": "5 5 5 5",
                    "value": "0",
                    "inputValue": true,
                    "fieldLabel": "student",
                    "fieldId": "6C0602D8-6EA6-4D36-9D2F-96EC30C5ADD4",
                    "bind": "{student}",
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
                    "customId": 949,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 949,
                         "customId": 300
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 949,
                         "customId": 301,
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
                         "parentId": 949,
                         "customId": 302,
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