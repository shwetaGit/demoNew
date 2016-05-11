Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.issuetracker.IssueStageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueStageMainController",
     "restURL": "/IssueStage",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.issuetracker.IssueStageMainController", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.issuetracker.IssueStageViewModel"],
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
               "displayName": "Issue Stage",
               "name": "IssueStageTreeContainer",
               "itemId": "IssueStageTreeContainer",
               "restURL": "/IssueStage",
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
                    "itemId": "IssueStageTree",
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
                         "name": "issueStageName",
                         "itemId": "issueStageName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Stage",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Stage",
                         "fieldId": "5C15EE57-795B-48EA-853A-EBC95DBFD716",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Issue stage",
                         "bindable": "issueStageName"
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
                    "displayName": "Issue Stage",
                    "title": "Issue Stage",
                    "name": "IssueStage",
                    "itemId": "IssueStageForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueStageCode",
                         "itemId": "issueStageCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Stage Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Stage Code<font color='red'> *<\/font>",
                         "fieldId": "17F9AE0F-78E2-4589-95B4-22534416936E",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueStageCode"
                    }, {
                         "name": "issueStageId",
                         "itemId": "issueStageId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Stage Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Stage Id<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3280853B-7872-458A-BF45-98DB321D17FE",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "issueStageId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStageName",
                         "itemId": "issueStageName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Stage",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Stage<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5C15EE57-795B-48EA-853A-EBC95DBFD716",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Issue stage",
                         "bindable": "issueStageName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStageDesc",
                         "itemId": "issueStageDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Issue Stage Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Stage Description",
                         "fieldId": "426F2C56-B31E-4236-AC5D-4C49927FE98B",
                         "bindable": "issueStageDesc",
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
                         "fieldId": "B98A1BDD-584B-42BA-AB08-4676CA938EFB",
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
                         "customId": 129,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 129,
                              "customId": 419
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 129,
                              "customId": 420,
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
                              "parentId": 129,
                              "customId": 421,
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
                    "displayName": "Issue Stage",
                    "title": "Details Grid",
                    "name": "IssueStageGrid",
                    "itemId": "IssueStageGrid",
                    "restURL": "/IssueStage",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Issue Stage Code",
                         "dataIndex": "issueStageCode",
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
                         "header": "Issue Stage Id",
                         "dataIndex": "issueStageId",
                         "flex": 1
                    }, {
                         "header": "Issue Stage",
                         "dataIndex": "issueStageName",
                         "flex": 1
                    }, {
                         "header": "Issue Stage Description",
                         "dataIndex": "issueStageDesc",
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
               "displayName": "Issue Stage",
               "title": "Issue Stage",
               "name": "IssueStage",
               "itemId": "IssueStageForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueStageCode",
                    "itemId": "issueStageCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Stage Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Stage Code<font color='red'> *<\/font>",
                    "fieldId": "17F9AE0F-78E2-4589-95B4-22534416936E",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueStageCode"
               }, {
                    "name": "issueStageId",
                    "itemId": "issueStageId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Stage Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Stage Id<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3280853B-7872-458A-BF45-98DB321D17FE",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "issueStageId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStageName",
                    "itemId": "issueStageName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Stage",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Stage<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5C15EE57-795B-48EA-853A-EBC95DBFD716",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid Issue stage",
                    "bindable": "issueStageName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStageDesc",
                    "itemId": "issueStageDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Issue Stage Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Stage Description",
                    "fieldId": "426F2C56-B31E-4236-AC5D-4C49927FE98B",
                    "bindable": "issueStageDesc",
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
                    "fieldId": "B98A1BDD-584B-42BA-AB08-4676CA938EFB",
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
                    "customId": 129,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 129,
                         "customId": 419
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 129,
                         "customId": 420,
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
                         "parentId": 129,
                         "customId": 421,
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