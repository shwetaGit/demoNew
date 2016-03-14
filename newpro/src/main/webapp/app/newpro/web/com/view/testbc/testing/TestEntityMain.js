Ext.define('Newpro.newpro.web.com.view.testbc.testing.TestEntityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestEntityMainController",
     "restURL": "/TestEntity",
     "defaults": {
          "split": true
     },
     "requires": ["Newpro.newpro.shared.com.model.testbc.testing.TestEntityModel", "Newpro.newpro.web.com.controller.testbc.testing.TestEntityMainController", "Newpro.newpro.shared.com.viewmodel.testbc.testing.TestEntityViewModel"],
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
               "displayName": "TestEntity",
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
                    "name": "entityTreePanel",
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
                    "displayName": "TestEntity",
                    "title": "TestEntity",
                    "name": "TestEntity",
                    "itemId": "TestEntityForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "testId",
                         "itemId": "testId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testId<font color='red'> *<\/font>",
                         "fieldId": "D51ACBC1-20C2-4C2C-BD51-52F2CFCCB251",
                         "hidden": true,
                         "value": "",
                         "bindable": "testId"
                    }, {
                         "name": "tDate",
                         "itemId": "tDate",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tDate",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tDate<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F200EADB-46F1-452C-B01F-F218B25809F6",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "tDate",
                         "columnWidth": 0.5
                    }, {
                         "name": "eType",
                         "itemId": "eType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "eType",
                         "margin": "5 5 5 5",
                         "fieldLabel": "eType<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "29BA9365-C5CD-4CFD-ADFA-D9A0640E1BC8",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "eType",
                         "columnWidth": 0.5
                    }, {
                         "name": "cardNo",
                         "itemId": "cardNo",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "cardNo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "cardNo<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B15C1E79-A985-41D9-8F12-F42A84025FBE",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "cardNo",
                         "columnWidth": 0.5
                    }, {
                         "name": "eTime",
                         "itemId": "eTime",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "eTime",
                         "margin": "5 5 5 5",
                         "fieldLabel": "eTime<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "62CC84D4-F2BC-44AD-89FF-AB8B98914877",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "eTime",
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
                         "fieldId": "53A3C033-715A-4A40-B30B-96AE3862BBB8",
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
                         "customId": 196,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 196,
                              "customId": 278
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 196,
                              "customId": 279,
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
                              "parentId": 196,
                              "customId": 280,
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
                    "displayName": "TestEntity",
                    "title": "Details Grid",
                    "name": "TestEntityGrid",
                    "itemId": "TestEntityGrid",
                    "restURL": "/TestEntity",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "testId",
                         "dataIndex": "testId",
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
                         "header": "tDate",
                         "dataIndex": "tDate",
                         "flex": 1
                    }, {
                         "header": "eType",
                         "dataIndex": "eType",
                         "flex": 1
                    }, {
                         "header": "cardNo",
                         "dataIndex": "cardNo",
                         "flex": 1
                    }, {
                         "header": "eTime",
                         "dataIndex": "eTime",
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
               "displayName": "TestEntity",
               "title": "TestEntity",
               "name": "TestEntity",
               "itemId": "TestEntityForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "testId",
                    "itemId": "testId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testId<font color='red'> *<\/font>",
                    "fieldId": "D51ACBC1-20C2-4C2C-BD51-52F2CFCCB251",
                    "hidden": true,
                    "value": "",
                    "bindable": "testId"
               }, {
                    "name": "tDate",
                    "itemId": "tDate",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tDate",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tDate<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F200EADB-46F1-452C-B01F-F218B25809F6",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "tDate",
                    "columnWidth": 0.5
               }, {
                    "name": "eType",
                    "itemId": "eType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "eType",
                    "margin": "5 5 5 5",
                    "fieldLabel": "eType<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "29BA9365-C5CD-4CFD-ADFA-D9A0640E1BC8",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "eType",
                    "columnWidth": 0.5
               }, {
                    "name": "cardNo",
                    "itemId": "cardNo",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "cardNo",
                    "margin": "5 5 5 5",
                    "fieldLabel": "cardNo<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B15C1E79-A985-41D9-8F12-F42A84025FBE",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "cardNo",
                    "columnWidth": 0.5
               }, {
                    "name": "eTime",
                    "itemId": "eTime",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "eTime",
                    "margin": "5 5 5 5",
                    "fieldLabel": "eTime<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "62CC84D4-F2BC-44AD-89FF-AB8B98914877",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "eTime",
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
                    "fieldId": "53A3C033-715A-4A40-B30B-96AE3862BBB8",
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
                    "customId": 196,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 196,
                         "customId": 278
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 196,
                         "customId": 279,
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
                         "parentId": 196,
                         "customId": 280,
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