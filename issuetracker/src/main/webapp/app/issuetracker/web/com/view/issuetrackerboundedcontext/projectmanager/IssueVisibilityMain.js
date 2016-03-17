Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.projectmanager.IssueVisibilityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueVisibilityMainController",
     "restURL": "/IssueVisibility",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueVisibilityModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.projectmanager.IssueVisibilityMainController", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.projectmanager.IssueVisibilityViewModel"],
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
               "displayName": "Issue Visibility",
               "name": "IssueVisibilityTreeContainer",
               "itemId": "IssueVisibilityTreeContainer",
               "restURL": "/IssueVisibility",
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
                    "itemId": "IssueVisibilityTree",
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
                    "displayName": "Issue Visibility",
                    "title": "Issue Visibility",
                    "name": "IssueVisibility",
                    "itemId": "IssueVisibilityForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueVisibilityCode",
                         "itemId": "issueVisibilityCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Visibility Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Visibility Code<font color='red'> *<\/font>",
                         "fieldId": "C7DD1899-6013-4E1A-8BD5-8FA298714BCE",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueVisibilityCode"
                    }, {
                         "name": "issueVisibilityName",
                         "itemId": "issueVisibilityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Visibility",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Visibility<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9A4B9BEA-4167-487B-B256-9DFD3A44EC15",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid issue visibility type",
                         "bindable": "issueVisibilityName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueVisibilityDesc",
                         "itemId": "issueVisibilityDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Visibility Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Visibility Description",
                         "fieldId": "A333C497-578F-4136-8DE2-B677DBEE8B06",
                         "bindable": "issueVisibilityDesc",
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
                         "fieldId": "EDAFDB3B-5D0A-44D6-98E6-BE620354516A",
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
                         "customId": 908,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 908,
                              "customId": 176
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 908,
                              "customId": 177,
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
                              "parentId": 908,
                              "customId": 178,
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
                    "displayName": "Issue Visibility",
                    "title": "Details Grid",
                    "name": "IssueVisibilityGrid",
                    "itemId": "IssueVisibilityGrid",
                    "restURL": "/IssueVisibility",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Visibility Code",
                         "dataIndex": "issueVisibilityCode",
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
                         "header": "Issue Visibility",
                         "dataIndex": "issueVisibilityName",
                         "flex": 1
                    }, {
                         "header": "Visibility Description",
                         "dataIndex": "issueVisibilityDesc",
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
               "displayName": "Issue Visibility",
               "title": "Issue Visibility",
               "name": "IssueVisibility",
               "itemId": "IssueVisibilityForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueVisibilityCode",
                    "itemId": "issueVisibilityCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Visibility Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Visibility Code<font color='red'> *<\/font>",
                    "fieldId": "C7DD1899-6013-4E1A-8BD5-8FA298714BCE",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueVisibilityCode"
               }, {
                    "name": "issueVisibilityName",
                    "itemId": "issueVisibilityName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Visibility",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Visibility<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9A4B9BEA-4167-487B-B256-9DFD3A44EC15",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid issue visibility type",
                    "bindable": "issueVisibilityName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueVisibilityDesc",
                    "itemId": "issueVisibilityDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Visibility Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Visibility Description",
                    "fieldId": "A333C497-578F-4136-8DE2-B677DBEE8B06",
                    "bindable": "issueVisibilityDesc",
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
                    "fieldId": "EDAFDB3B-5D0A-44D6-98E6-BE620354516A",
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
                    "customId": 908,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 908,
                         "customId": 176
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 908,
                         "customId": 177,
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
                         "parentId": 908,
                         "customId": 178,
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