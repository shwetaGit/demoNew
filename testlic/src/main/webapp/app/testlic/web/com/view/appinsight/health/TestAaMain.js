Ext.define('Testlic.testlic.web.com.view.appinsight.health.TestAaMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestAaMainController",
     "restURL": "/TestAa",
     "defaults": {
          "split": true
     },
     "requires": ["Testlic.testlic.shared.com.model.appinsight.health.TestAaModel", "Testlic.testlic.web.com.controller.appinsight.health.TestAaMainController", "Testlic.testlic.shared.com.viewmodel.appinsight.health.TestAaViewModel"],
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
               "displayName": "TestAa",
               "name": "TestAaTreeContainer",
               "itemId": "TestAaTreeContainer",
               "restURL": "/TestAa",
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
                    "itemId": "TestAaTree",
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
                    "displayName": "TestAa",
                    "title": "TestAa",
                    "name": "TestAa",
                    "itemId": "TestAaForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "tid",
                         "itemId": "tid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tid<font color='red'> *<\/font>",
                         "fieldId": "73C2455F-8D5C-48B7-96E4-4F3DCB442E7C",
                         "hidden": true,
                         "value": "",
                         "bindable": "tid"
                    }, {
                         "name": "tnm",
                         "itemId": "tnm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tnm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tnm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C413D292-AF8F-4828-A784-3ED1F9AB6F1A",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "tnm",
                         "columnWidth": 0.5
                    }, {
                         "name": "tno",
                         "itemId": "tno",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "tno",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tno<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B9DA3C1D-044B-47D2-8DE3-776C5502C016",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "tno",
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
                         "fieldId": "4E7DD502-775E-47F3-8E3D-BBD7CA710FA2",
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
                         "customId": 940,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 940,
                              "customId": 944
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 940,
                              "customId": 945,
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
                              "parentId": 940,
                              "customId": 946,
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
                    "displayName": "TestAa",
                    "title": "Details Grid",
                    "name": "TestAaGrid",
                    "itemId": "TestAaGrid",
                    "restURL": "/TestAa",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "tid",
                         "dataIndex": "tid",
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
                         "header": "tnm",
                         "dataIndex": "tnm",
                         "flex": 1
                    }, {
                         "header": "tno",
                         "dataIndex": "tno",
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
               "displayName": "TestAa",
               "title": "TestAa",
               "name": "TestAa",
               "itemId": "TestAaForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "tid",
                    "itemId": "tid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tid<font color='red'> *<\/font>",
                    "fieldId": "73C2455F-8D5C-48B7-96E4-4F3DCB442E7C",
                    "hidden": true,
                    "value": "",
                    "bindable": "tid"
               }, {
                    "name": "tnm",
                    "itemId": "tnm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tnm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tnm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C413D292-AF8F-4828-A784-3ED1F9AB6F1A",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "tnm",
                    "columnWidth": 0.5
               }, {
                    "name": "tno",
                    "itemId": "tno",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "tno",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tno<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B9DA3C1D-044B-47D2-8DE3-776C5502C016",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "tno",
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
                    "fieldId": "4E7DD502-775E-47F3-8E3D-BBD7CA710FA2",
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
                    "customId": 940,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 940,
                         "customId": 944
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 940,
                         "customId": 945,
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
                         "parentId": 940,
                         "customId": 946,
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