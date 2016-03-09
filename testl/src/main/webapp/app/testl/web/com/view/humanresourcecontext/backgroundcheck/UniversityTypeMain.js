Ext.define('Testl.testl.web.com.view.humanresourcecontext.backgroundcheck.UniversityTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "UniversityTypeMainController",
     "restURL": "/UniversityType",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.UniversityTypeModel", "Testl.testl.web.com.controller.humanresourcecontext.backgroundcheck.UniversityTypeMainController", "Testl.testl.shared.com.viewmodel.humanresourcecontext.backgroundcheck.UniversityTypeViewModel"],
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
               "displayName": "University Type",
               "name": "UniversityTypeTreeContainer",
               "itemId": "UniversityTypeTreeContainer",
               "restURL": "/UniversityType",
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
                    "itemId": "UniversityTypeTree",
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
                         "name": "unvDesc",
                         "itemId": "unvDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "University",
                         "margin": "5 5 5 5",
                         "fieldLabel": "University",
                         "fieldId": "F170476D-47E0-4B9F-9984-89C3AF36EFF1",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "unvDesc"
                    }, {
                         "name": "unvHelp",
                         "itemId": "unvHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "University Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "University Details",
                         "fieldId": "4E8E3CA9-09E2-4C11-A499-BFB3FCD81A9A",
                         "bindable": "unvHelp"
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
                    "viewModel": "UniversityTypeViewModel",
                    "xtype": "form",
                    "displayName": "University Type",
                    "title": "University Type",
                    "name": "UniversityType",
                    "itemId": "UniversityType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "unvCode",
                         "itemId": "unvCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "unvCode",
                         "margin": "5 5 5 5",
                         "fieldLabel": "unvCode<font color='red'> *<\/font>",
                         "fieldId": "4EA8AD17-F329-4AB0-820E-1904171272A2",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "unvCode",
                         "bind": "{unvCode}"
                    }, {
                         "name": "unvDesc",
                         "itemId": "unvDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "University",
                         "margin": "5 5 5 5",
                         "fieldLabel": "University<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F170476D-47E0-4B9F-9984-89C3AF36EFF1",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "unvDesc",
                         "bind": "{unvDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "unvHelp",
                         "itemId": "unvHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "University Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "University Details<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4E8E3CA9-09E2-4C11-A499-BFB3FCD81A9A",
                         "bindable": "unvHelp",
                         "bind": "{unvHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "unvIcon",
                         "itemId": "unvIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "unvIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "unvIcon",
                         "fieldId": "B2363E35-AE38-4655-8AAA-0256911C193B",
                         "minLength": "0",
                         "bindable": "unvIcon",
                         "bind": "{unvIcon}",
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
                         "fieldId": "2AA61BAB-405D-4B6D-AA80-B62650F549AF",
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
                         "customId": 519,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 519,
                              "customId": 549
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 519,
                              "customId": 550,
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
                              "parentId": 519,
                              "customId": 551,
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
                    "displayName": "University Type",
                    "title": "Details Grid",
                    "name": "UniversityTypeGrid",
                    "itemId": "UniversityTypeGrid",
                    "restURL": "/UniversityType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "unvCode",
                         "dataIndex": "unvCode",
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
                         "header": "University",
                         "dataIndex": "unvDesc",
                         "flex": 1
                    }, {
                         "header": "University Details",
                         "dataIndex": "unvHelp",
                         "flex": 1
                    }, {
                         "header": "unvIcon",
                         "dataIndex": "unvIcon",
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
               "viewModel": "UniversityTypeViewModel",
               "xtype": "form",
               "displayName": "University Type",
               "title": "University Type",
               "name": "UniversityType",
               "itemId": "UniversityType",
               "bodyPadding": 10,
               "items": [{
                    "name": "unvCode",
                    "itemId": "unvCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "unvCode",
                    "margin": "5 5 5 5",
                    "fieldLabel": "unvCode<font color='red'> *<\/font>",
                    "fieldId": "4EA8AD17-F329-4AB0-820E-1904171272A2",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "unvCode",
                    "bind": "{unvCode}"
               }, {
                    "name": "unvDesc",
                    "itemId": "unvDesc",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "University",
                    "margin": "5 5 5 5",
                    "fieldLabel": "University<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F170476D-47E0-4B9F-9984-89C3AF36EFF1",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "unvDesc",
                    "bind": "{unvDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "unvHelp",
                    "itemId": "unvHelp",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "University Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "University Details<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4E8E3CA9-09E2-4C11-A499-BFB3FCD81A9A",
                    "bindable": "unvHelp",
                    "bind": "{unvHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "unvIcon",
                    "itemId": "unvIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "unvIcon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "unvIcon",
                    "fieldId": "B2363E35-AE38-4655-8AAA-0256911C193B",
                    "minLength": "0",
                    "bindable": "unvIcon",
                    "bind": "{unvIcon}",
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
                    "fieldId": "2AA61BAB-405D-4B6D-AA80-B62650F549AF",
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
                    "customId": 519,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 519,
                         "customId": 549
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 519,
                         "customId": 550,
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
                         "parentId": 519,
                         "customId": 551,
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