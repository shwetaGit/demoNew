Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.issuetracker.IssueStatusMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueStatusMainController",
     "restURL": "/IssueStatus",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.issuetracker.IssueStatusMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.issuetracker.IssueStatusViewModel"],
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
               "displayName": "Issue Status",
               "name": "IssueStatusTreeContainer",
               "itemId": "IssueStatusTreeContainer",
               "restURL": "/IssueStatus",
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
                    "itemId": "IssueStatusTree",
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
                         "fieldLabel": "Issue Stage Code",
                         "fieldId": "5C26B52C-218D-401D-82AE-BE531060F616",
                         "restURL": "IssueStage",
                         "bindable": "issueStageCode"
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
                    "displayName": "Issue Status",
                    "title": "Issue Status",
                    "name": "IssueStatus",
                    "itemId": "IssueStatusForm",
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
                         "fieldId": "5C26B52C-218D-401D-82AE-BE531060F616",
                         "restURL": "IssueStage",
                         "bindable": "issueStageCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStatusCode",
                         "itemId": "issueStatusCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Status Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status Code<font color='red'> *<\/font>",
                         "fieldId": "A6AB404E-11D5-4DC6-83DA-F84A228B7013",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueStatusCode"
                    }, {
                         "name": "issueStatusId",
                         "itemId": "issueStatusId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Status Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status Id<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A45630BC-DE5E-4721-82B5-4EA22F410D95",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "issueStatusId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStatusName",
                         "itemId": "issueStatusName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Status",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "298B71BF-BF7C-4AD9-9CAB-B1506166A2F6",
                         "minLength": "0",
                         "maxLength": "256",
                         "errorMessage": "Please enter valid Issue Status",
                         "bindable": "issueStatusName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStatusDesc",
                         "itemId": "issueStatusDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Issue Status Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Status Description",
                         "fieldId": "2BA1C692-DC6A-47CC-B531-78C31103B5C8",
                         "bindable": "issueStatusDesc",
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
                         "fieldId": "82978EC0-44A3-4356-816A-72BA8CCFADBA",
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
                         "customId": 981,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 981,
                              "customId": 547
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 981,
                              "customId": 548,
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
                              "parentId": 981,
                              "customId": 549,
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
                    "displayName": "Issue Status",
                    "title": "Details Grid",
                    "name": "IssueStatusGrid",
                    "itemId": "IssueStatusGrid",
                    "restURL": "/IssueStatus",
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
                         "header": "Issue Status Id",
                         "dataIndex": "issueStatusId",
                         "flex": 1
                    }, {
                         "header": "Issue Status",
                         "dataIndex": "issueStatusName",
                         "flex": 1
                    }, {
                         "header": "Issue Status Description",
                         "dataIndex": "issueStatusDesc",
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
               "displayName": "Issue Status",
               "title": "Issue Status",
               "name": "IssueStatus",
               "itemId": "IssueStatusForm",
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
                    "fieldId": "5C26B52C-218D-401D-82AE-BE531060F616",
                    "restURL": "IssueStage",
                    "bindable": "issueStageCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStatusCode",
                    "itemId": "issueStatusCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Status Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status Code<font color='red'> *<\/font>",
                    "fieldId": "A6AB404E-11D5-4DC6-83DA-F84A228B7013",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueStatusCode"
               }, {
                    "name": "issueStatusId",
                    "itemId": "issueStatusId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Status Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status Id<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A45630BC-DE5E-4721-82B5-4EA22F410D95",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "issueStatusId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStatusName",
                    "itemId": "issueStatusName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Status",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "298B71BF-BF7C-4AD9-9CAB-B1506166A2F6",
                    "minLength": "0",
                    "maxLength": "256",
                    "errorMessage": "Please enter valid Issue Status",
                    "bindable": "issueStatusName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStatusDesc",
                    "itemId": "issueStatusDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Issue Status Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Status Description",
                    "fieldId": "2BA1C692-DC6A-47CC-B531-78C31103B5C8",
                    "bindable": "issueStatusDesc",
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
                    "fieldId": "82978EC0-44A3-4356-816A-72BA8CCFADBA",
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
                    "customId": 981,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 981,
                         "customId": 547
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 981,
                         "customId": 548,
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
                         "parentId": 981,
                         "customId": 549,
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