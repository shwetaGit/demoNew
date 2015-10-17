Ext.define('Oct16last.oct16last.web.oct16last.view.defaultdomain.CheckboxTestMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CheckboxTestMainController",
     "restURL": "/CheckboxTest",
     "defaults": {
          "split": true
     },
     "requires": ["Oct16last.oct16last.shared.oct16last.model.defaultdomain.CheckboxTestModel", "Oct16last.oct16last.web.oct16last.controller.defaultdomain.CheckboxTestMainController", "Oct16last.oct16last.shared.oct16last.viewmodel.defaultdomain.CheckboxTestViewModel", "Ext.form.field.CustomDateField"],
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
               "displayName": "checkbox test",
               "name": "CheckboxTestTreeContainer",
               "itemId": "CheckboxTestTreeContainer",
               "restURL": "/CheckboxTest",
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
                    "itemId": "CheckboxTestTree",
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
                         "name": "a1",
                         "itemId": "a1",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "a1",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "a1",
                         "fieldId": "50DB9661-0F34-4A84-B815-D38E2BA47122"
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
                    "viewModel": "CheckboxTestViewModel",
                    "xtype": "form",
                    "displayName": "checkbox test",
                    "title": "checkbox test",
                    "name": "CheckboxTest",
                    "itemId": "CheckboxTest",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "a1",
                         "itemId": "a1",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "a1",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "a1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "50DB9661-0F34-4A84-B815-D38E2BA47122",
                         "bind": "{a1}",
                         "columnWidth": 0.5
                    }, {
                         "name": "a2",
                         "itemId": "a2",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "a2",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "inputValue": true,
                         "fieldLabel": "a2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D7671718-A8C9-4CD8-B42A-A04A8A661544",
                         "bind": "{a2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "a3",
                         "itemId": "a3",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "a3",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "a3",
                         "fieldId": "81E346CF-1EF8-4DA7-9E17-48CF51DA7954",
                         "bind": "{a3}",
                         "columnWidth": 0.5
                    }, {
                         "name": "a4",
                         "itemId": "a4",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "a4",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "inputValue": true,
                         "fieldLabel": "a4",
                         "fieldId": "21B68464-8F76-439E-BCBE-2F4EA294B738",
                         "bind": "{a4}",
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
                         "customId": 134,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 134,
                              "customId": 866
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 134,
                              "customId": 867,
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
                              "parentId": 134,
                              "customId": 868,
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
                    "displayName": "checkbox test",
                    "title": "Details Grid",
                    "name": "CheckboxTestGrid",
                    "itemId": "CheckboxTestGrid",
                    "restURL": "/CheckboxTest",
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
                         "header": "a1",
                         "dataIndex": "a1",
                         "flex": 1
                    }, {
                         "header": "a2",
                         "dataIndex": "a2",
                         "flex": 1
                    }, {
                         "header": "a3",
                         "dataIndex": "a3",
                         "flex": 1
                    }, {
                         "header": "a4",
                         "dataIndex": "a4",
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
               "viewModel": "CheckboxTestViewModel",
               "xtype": "form",
               "displayName": "checkbox test",
               "title": "checkbox test",
               "name": "CheckboxTest",
               "itemId": "CheckboxTest",
               "bodyPadding": 10,
               "items": [{
                    "name": "a1",
                    "itemId": "a1",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "a1",
                    "margin": "5 5 5 5",
                    "value": "0",
                    "inputValue": true,
                    "fieldLabel": "a1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "50DB9661-0F34-4A84-B815-D38E2BA47122",
                    "bind": "{a1}",
                    "columnWidth": 0.5
               }, {
                    "name": "a2",
                    "itemId": "a2",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "a2",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "inputValue": true,
                    "fieldLabel": "a2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D7671718-A8C9-4CD8-B42A-A04A8A661544",
                    "bind": "{a2}",
                    "columnWidth": 0.5
               }, {
                    "name": "a3",
                    "itemId": "a3",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "a3",
                    "margin": "5 5 5 5",
                    "value": "0",
                    "inputValue": true,
                    "fieldLabel": "a3",
                    "fieldId": "81E346CF-1EF8-4DA7-9E17-48CF51DA7954",
                    "bind": "{a3}",
                    "columnWidth": 0.5
               }, {
                    "name": "a4",
                    "itemId": "a4",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "a4",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "inputValue": true,
                    "fieldLabel": "a4",
                    "fieldId": "21B68464-8F76-439E-BCBE-2F4EA294B738",
                    "bind": "{a4}",
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
                    "customId": 134,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 134,
                         "customId": 866
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 134,
                         "customId": 867,
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
                         "parentId": 134,
                         "customId": 868,
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