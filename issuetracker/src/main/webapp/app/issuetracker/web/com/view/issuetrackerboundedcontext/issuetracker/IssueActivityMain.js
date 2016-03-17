Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.issuetracker.IssueActivityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueActivityMainController",
     "restURL": "/IssueActivity",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.issuetracker.IssueActivityMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.issuetracker.IssueActivityViewModel"],
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
               "displayName": "Issue Activity",
               "name": "IssueActivityTreeContainer",
               "itemId": "IssueActivityTreeContainer",
               "restURL": "/IssueActivity",
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
                    "itemId": "IssueActivityTree",
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
                    "displayName": "Issue Activity",
                    "title": "Issue Activity",
                    "name": "IssueActivity",
                    "itemId": "IssueActivityForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueStageCode",
                         "itemId": "issueStageCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Stage Code",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStageModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Issue Stage Code<font color='red'> *<\/font>",
                         "fieldId": "6A68D7D5-56D4-4FCB-8534-3F819BDC3127",
                         "restURL": "IssueStage",
                         "bindable": "issueStageCode",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onIssueStageCodeChange"
                         }
                    }, {
                         "name": "issueStatusCode",
                         "itemId": "issueStatusCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Status Code",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Issue Status Code<font color='red'> *<\/font>",
                         "fieldId": "1E2B8F50-F4D4-463D-80B9-90544589C303",
                         "restURL": "IssueStatus",
                         "bindable": "issueStatusCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueActivityCode",
                         "itemId": "issueActivityCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Activity Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Activity Code<font color='red'> *<\/font>",
                         "fieldId": "71FCD972-BD6B-438D-9EC4-42B4B4543B67",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueActivityCode"
                    }, {
                         "name": "issueActivityId",
                         "itemId": "issueActivityId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Activity Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Activity Id<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A0366D2B-BE56-4DE6-A649-25870D4760E4",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "issueActivityId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueActivityName",
                         "itemId": "issueActivityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Activity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Activity<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4A82D827-2172-4CB7-8439-CE3842AA4BC9",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Issue Activity",
                         "bindable": "issueActivityName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueActivityDesc",
                         "itemId": "issueActivityDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Issue Activity Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Activity Description",
                         "fieldId": "2EEED573-5457-42F4-94CE-069EB59FE667",
                         "bindable": "issueActivityDesc",
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
                         "fieldId": "D16D44D7-FD6B-4B88-BECE-6E0B29A77D0A",
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
                         "customId": 915,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 915,
                              "customId": 309
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 915,
                              "customId": 310,
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
                              "parentId": 915,
                              "customId": 311,
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
                    "displayName": "Issue Activity",
                    "title": "Details Grid",
                    "name": "IssueActivityGrid",
                    "itemId": "IssueActivityGrid",
                    "restURL": "/IssueActivity",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Issue Stage Code",
                         "dataIndex": "issueStageCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Status Code",
                         "dataIndex": "issueStatusCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Activity Code",
                         "dataIndex": "issueActivityCode",
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
                         "header": "Issue Activity Id",
                         "dataIndex": "issueActivityId",
                         "flex": 1
                    }, {
                         "header": "Issue Activity",
                         "dataIndex": "issueActivityName",
                         "flex": 1
                    }, {
                         "header": "Issue Activity Description",
                         "dataIndex": "issueActivityDesc",
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
               "displayName": "Issue Activity",
               "title": "Issue Activity",
               "name": "IssueActivity",
               "itemId": "IssueActivityForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueStageCode",
                    "itemId": "issueStageCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Stage Code",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStageModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Issue Stage Code<font color='red'> *<\/font>",
                    "fieldId": "6A68D7D5-56D4-4FCB-8534-3F819BDC3127",
                    "restURL": "IssueStage",
                    "bindable": "issueStageCode",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onIssueStageCodeChange"
                    }
               }, {
                    "name": "issueStatusCode",
                    "itemId": "issueStatusCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Status Code",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Issue Status Code<font color='red'> *<\/font>",
                    "fieldId": "1E2B8F50-F4D4-463D-80B9-90544589C303",
                    "restURL": "IssueStatus",
                    "bindable": "issueStatusCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issueActivityCode",
                    "itemId": "issueActivityCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Activity Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Activity Code<font color='red'> *<\/font>",
                    "fieldId": "71FCD972-BD6B-438D-9EC4-42B4B4543B67",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueActivityCode"
               }, {
                    "name": "issueActivityId",
                    "itemId": "issueActivityId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Activity Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Activity Id<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A0366D2B-BE56-4DE6-A649-25870D4760E4",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "issueActivityId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueActivityName",
                    "itemId": "issueActivityName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Activity",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Activity<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4A82D827-2172-4CB7-8439-CE3842AA4BC9",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid Issue Activity",
                    "bindable": "issueActivityName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueActivityDesc",
                    "itemId": "issueActivityDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Issue Activity Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Activity Description",
                    "fieldId": "2EEED573-5457-42F4-94CE-069EB59FE667",
                    "bindable": "issueActivityDesc",
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
                    "fieldId": "D16D44D7-FD6B-4B88-BECE-6E0B29A77D0A",
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
                    "customId": 915,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 915,
                         "customId": 309
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 915,
                         "customId": 310,
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
                         "parentId": 915,
                         "customId": 311,
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