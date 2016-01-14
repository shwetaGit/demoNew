Ext.define('Testprj.testprj.web.testprj.view.defaultdomain.PersonalInfoMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "PersonalInfoMainController",
     "restURL": "/PersonalInfo",
     "defaults": {
          "split": true
     },
     "requires": ["Testprj.testprj.shared.testprj.model.defaultdomain.PersonalInfoModel", "Testprj.testprj.web.testprj.controller.defaultdomain.PersonalInfoMainController", "Testprj.testprj.shared.testprj.viewmodel.defaultdomain.PersonalInfoViewModel"],
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
               "displayName": "Personal Info",
               "name": "PersonalInfoTreeContainer",
               "itemId": "PersonalInfoTreeContainer",
               "restURL": "/PersonalInfo",
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
                    "itemId": "PersonalInfoTree",
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
                    "viewModel": "PersonalInfoViewModel",
                    "xtype": "form",
                    "displayName": "Personal Info",
                    "title": "Personal Info",
                    "name": "PersonalInfo",
                    "itemId": "PersonalInfo",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "fname",
                         "itemId": "fname",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "fname",
                         "margin": "5 5 5 5",
                         "fieldLabel": "fname<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "25092B6F-573B-4E8A-A565-670D29D9773F",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "fname",
                         "bind": "{fname}",
                         "columnWidth": 0.5
                    }, {
                         "name": "lname",
                         "itemId": "lname",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "lname",
                         "margin": "5 5 5 5",
                         "fieldLabel": "lname<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "67D3EB8F-CD50-4750-9C93-1CCEF7431802",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "lname",
                         "bind": "{lname}",
                         "columnWidth": 0.5
                    }, {
                         "name": "dateoforder",
                         "itemId": "dateoforder",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "dateoforder",
                         "margin": "5 5 5 5",
                         "fieldLabel": "dateoforder<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CAA6E0CD-C8F2-4B07-9FC0-A5CDC95C8C11",
                         "bindable": "dateoforder",
                         "bind": "{dateoforder}",
                         "columnWidth": 0.5,
                         "format": "d-m-Y H:m:s",
                         "submitFormat": "d-m-Y H:m:s"
                    }, {
                         "name": "pk",
                         "itemId": "pk",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "pk",
                         "margin": "5 5 5 5",
                         "fieldLabel": "pk<font color='red'> *<\/font>",
                         "fieldId": "9B49C1E1-7041-4149-B5DE-14044DD67F1C",
                         "hidden": true,
                         "value": "",
                         "bindable": "pk",
                         "bind": "{pk}"
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "8AD15C85-9CF4-4F5C-9B6B-3212B3D21B4C",
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
                         "customId": 50,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 50,
                              "customId": 65
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 50,
                              "customId": 66,
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
                              "parentId": 50,
                              "customId": 67,
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
                    "displayName": "Personal Info",
                    "title": "Details Grid",
                    "name": "PersonalInfoGrid",
                    "itemId": "PersonalInfoGrid",
                    "restURL": "/PersonalInfo",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "fname",
                         "dataIndex": "fname",
                         "flex": 1
                    }, {
                         "header": "lname",
                         "dataIndex": "lname",
                         "flex": 1
                    }, {
                         "header": "dateoforder",
                         "dataIndex": "dateoforder",
                         "flex": 1
                    }, {
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
               "viewModel": "PersonalInfoViewModel",
               "xtype": "form",
               "displayName": "Personal Info",
               "title": "Personal Info",
               "name": "PersonalInfo",
               "itemId": "PersonalInfo",
               "bodyPadding": 10,
               "items": [{
                    "name": "fname",
                    "itemId": "fname",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "fname",
                    "margin": "5 5 5 5",
                    "fieldLabel": "fname<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "25092B6F-573B-4E8A-A565-670D29D9773F",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "fname",
                    "bind": "{fname}",
                    "columnWidth": 0.5
               }, {
                    "name": "lname",
                    "itemId": "lname",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "lname",
                    "margin": "5 5 5 5",
                    "fieldLabel": "lname<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "67D3EB8F-CD50-4750-9C93-1CCEF7431802",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "lname",
                    "bind": "{lname}",
                    "columnWidth": 0.5
               }, {
                    "name": "dateoforder",
                    "itemId": "dateoforder",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "dateoforder",
                    "margin": "5 5 5 5",
                    "fieldLabel": "dateoforder<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CAA6E0CD-C8F2-4B07-9FC0-A5CDC95C8C11",
                    "bindable": "dateoforder",
                    "bind": "{dateoforder}",
                    "columnWidth": 0.5,
                    "format": "d-m-Y H:m:s",
                    "submitFormat": "d-m-Y H:m:s"
               }, {
                    "name": "pk",
                    "itemId": "pk",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "pk",
                    "margin": "5 5 5 5",
                    "fieldLabel": "pk<font color='red'> *<\/font>",
                    "fieldId": "9B49C1E1-7041-4149-B5DE-14044DD67F1C",
                    "hidden": true,
                    "value": "",
                    "bindable": "pk",
                    "bind": "{pk}"
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "8AD15C85-9CF4-4F5C-9B6B-3212B3D21B4C",
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
                    "customId": 50,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 50,
                         "customId": 65
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 50,
                         "customId": 66,
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
                         "parentId": 50,
                         "customId": 67,
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