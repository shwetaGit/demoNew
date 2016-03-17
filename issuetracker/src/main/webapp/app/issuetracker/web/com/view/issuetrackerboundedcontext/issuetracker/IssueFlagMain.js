Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.issuetracker.IssueFlagMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueFlagMainController",
     "restURL": "/IssueFlag",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.issuetracker.IssueFlagMainController", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.issuetracker.IssueFlagViewModel"],
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
               "displayName": "Issue Flag",
               "name": "IssueFlagTreeContainer",
               "itemId": "IssueFlagTreeContainer",
               "restURL": "/IssueFlag",
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
                    "itemId": "IssueFlagTree",
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
                         "name": "issueFlagName",
                         "itemId": "issueFlagName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Flag",
                         "fieldId": "F3461E44-5EB5-4741-9DE0-3F517084424F",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Flag",
                         "bindable": "issueFlagName"
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
                    "displayName": "Issue Flag",
                    "title": "Issue Flag",
                    "name": "IssueFlag",
                    "itemId": "IssueFlagForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueFlagCode",
                         "itemId": "issueFlagCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Flag Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Flag Code<font color='red'> *<\/font>",
                         "fieldId": "3045C426-0DA0-4AA4-BB52-A721D2179E83",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueFlagCode"
                    }, {
                         "name": "issueFlagName",
                         "itemId": "issueFlagName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Flag<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F3461E44-5EB5-4741-9DE0-3F517084424F",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Flag",
                         "bindable": "issueFlagName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueFlagDesc",
                         "itemId": "issueFlagDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Issue Flag Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Flag Description",
                         "fieldId": "7A21919E-D831-44ED-BD86-3036B95E670C",
                         "bindable": "issueFlagDesc",
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
                         "fieldId": "F3C6C423-C000-437B-BF9D-EB0486B12AD6",
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
                         "customId": 805,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 805,
                              "customId": 623
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 805,
                              "customId": 624,
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
                              "parentId": 805,
                              "customId": 625,
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
                    "displayName": "Issue Flag",
                    "title": "Details Grid",
                    "name": "IssueFlagGrid",
                    "itemId": "IssueFlagGrid",
                    "restURL": "/IssueFlag",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Issue Flag Code",
                         "dataIndex": "issueFlagCode",
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
                         "header": "Issue Flag",
                         "dataIndex": "issueFlagName",
                         "flex": 1
                    }, {
                         "header": "Issue Flag Description",
                         "dataIndex": "issueFlagDesc",
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
               "displayName": "Issue Flag",
               "title": "Issue Flag",
               "name": "IssueFlag",
               "itemId": "IssueFlagForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueFlagCode",
                    "itemId": "issueFlagCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Flag Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Flag Code<font color='red'> *<\/font>",
                    "fieldId": "3045C426-0DA0-4AA4-BB52-A721D2179E83",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueFlagCode"
               }, {
                    "name": "issueFlagName",
                    "itemId": "issueFlagName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Flag<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F3461E44-5EB5-4741-9DE0-3F517084424F",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid Flag",
                    "bindable": "issueFlagName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueFlagDesc",
                    "itemId": "issueFlagDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Issue Flag Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Flag Description",
                    "fieldId": "7A21919E-D831-44ED-BD86-3036B95E670C",
                    "bindable": "issueFlagDesc",
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
                    "fieldId": "F3C6C423-C000-437B-BF9D-EB0486B12AD6",
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
                    "customId": 805,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 805,
                         "customId": 623
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 805,
                         "customId": 624,
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
                         "parentId": 805,
                         "customId": 625,
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