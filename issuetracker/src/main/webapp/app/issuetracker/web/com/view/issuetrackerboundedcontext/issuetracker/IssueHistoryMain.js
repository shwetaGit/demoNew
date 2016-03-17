Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.issuetracker.IssueHistoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueHistoryMainController",
     "restURL": "/IssueHistory",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueHistoryModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.issuetracker.IssueHistoryMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.issuetracker.IssueHistoryViewModel"],
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
               "displayName": "Issue History",
               "name": "IssueHistoryTreeContainer",
               "itemId": "IssueHistoryTreeContainer",
               "restURL": "/IssueHistory",
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
                    "itemId": "IssueHistoryTree",
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
                         "name": "issueHistId",
                         "itemId": "issueHistId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Hist Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Hist Id",
                         "fieldId": "527AA2E4-D785-457A-AF69-427CDC06E62E",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueHistId"
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
                    "displayName": "Issue History",
                    "title": "Issue History",
                    "name": "IssueHistory",
                    "itemId": "IssueHistoryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "issueHistId",
                         "itemId": "issueHistId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Issue Hist Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Issue Hist Id<font color='red'> *<\/font>",
                         "fieldId": "527AA2E4-D785-457A-AF69-427CDC06E62E",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "issueHistId"
                    }, {
                         "name": "issueId",
                         "itemId": "issueId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Id",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel"
                         },
                         "fieldLabel": "Issue Id",
                         "fieldId": "C2985292-08CC-4B4C-8572-1DE44EBBD027",
                         "restURL": "IssueWorkflow",
                         "bindable": "issueId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueCategoryCode",
                         "itemId": "issueCategoryCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel"
                         },
                         "fieldLabel": "Issue Category",
                         "fieldId": "321AD5F0-90DE-4336-99C4-187C3E427FB1",
                         "restURL": "IssueCategory",
                         "bindable": "issueCategoryCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "featureCategoryCode",
                         "itemId": "featureCategoryCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Feature Category",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel"
                         },
                         "fieldLabel": "Feature Category",
                         "fieldId": "8A502B5B-24D0-4688-BB63-52F157BDC7BF",
                         "restURL": "FeatureCategory",
                         "bindable": "featureCategoryCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueSeverityCode",
                         "itemId": "issueSeverityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Severity",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel"
                         },
                         "fieldLabel": "Issue Severity",
                         "fieldId": "17EAB7CD-A00B-4983-9610-C02614E1B50F",
                         "restURL": "IssueSeverity",
                         "bindable": "issueSeverityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issuePriorityCode",
                         "itemId": "issuePriorityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Priority",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel"
                         },
                         "fieldLabel": "Issue Priority",
                         "fieldId": "A2722EA4-488F-47BF-8BCB-118B005A236D",
                         "restURL": "IssuePriority",
                         "bindable": "issuePriorityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "effortEstimate",
                         "itemId": "effortEstimate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Effort Estimate",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Effort Estimate",
                         "fieldId": "586439BD-48A3-4868-8D6C-771AA502F1B6",
                         "bindable": "effortEstimate",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueFlagCode",
                         "itemId": "issueFlagCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Flag",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel"
                         },
                         "fieldLabel": "Issue Flag",
                         "fieldId": "11FBF8C1-637C-4707-9C95-C703449D83C6",
                         "restURL": "IssueFlag",
                         "bindable": "issueFlagCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueStageCode",
                         "itemId": "issueStageCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Stage",
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
                         "fieldLabel": "Issue Stage",
                         "fieldId": "AAB8EDAC-96E1-46A8-A89C-F5C6F854D459",
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
                         "displayName": "Issue Status",
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
                         "fieldLabel": "Issue Status",
                         "fieldId": "A6B900A7-C458-4C03-B708-AA2A0F325486",
                         "restURL": "IssueStatus",
                         "bindable": "issueStatusCode",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onIssueStatusCodeChange"
                         }
                    }, {
                         "name": "issueActivityCode",
                         "itemId": "issueActivityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Activity",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel"
                         },
                         "fieldLabel": "Issue Activity",
                         "fieldId": "931A7CE3-0FF6-44F6-90FD-BFC940B2FBD0",
                         "restURL": "IssueActivity",
                         "bindable": "issueActivityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "lastUpdated",
                         "itemId": "lastUpdated",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Last Updated On",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Last Updated On",
                         "fieldId": "CB84AFB4-8869-4EB2-8E92-E5C2E455D274",
                         "bindable": "lastUpdated",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactId",
                         "itemId": "contactId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "User",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                         },
                         "fieldLabel": "User",
                         "fieldId": "DE57C42D-4DAC-453E-847D-18722CA7AC7F",
                         "restURL": "CoreContacts",
                         "bindable": "contactId",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueDate",
                         "itemId": "issueDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Date Of Issue",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Date Of Issue",
                         "fieldId": "A2D7292E-27B0-478F-BA3F-B6BC9420078A",
                         "bindable": "issueDate",
                         "columnWidth": 0.5
                    }, {
                         "name": "startTime",
                         "itemId": "startTime",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Start Time",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "Start Time",
                         "fieldId": "52B8AC3E-F81B-4B85-86F7-EB5CEDAA067B",
                         "bindable": "startTime",
                         "columnWidth": 0.5
                    }, {
                         "name": "endTime",
                         "itemId": "endTime",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "End Time",
                         "margin": "5 5 5 5",
                         "format": "d-m-Y",
                         "submitFormat": "d-m-Y",
                         "fieldLabel": "End Time",
                         "fieldId": "5D2AB979-89C7-4ABA-B3C7-C654E4E59F30",
                         "bindable": "endTime",
                         "columnWidth": 0.5
                    }, {
                         "name": "comments",
                         "itemId": "comments",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Comments",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Comments",
                         "fieldId": "76256C0C-9F15-4512-BBB8-364925FB7E7B",
                         "bindable": "comments",
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
                         "fieldId": "9E1D44E1-FA81-47A1-8124-74029BC96E84",
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
                         "customId": 226,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 226,
                              "customId": 385
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 226,
                              "customId": 386,
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
                              "parentId": 226,
                              "customId": 387,
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
                    "displayName": "Issue History",
                    "title": "Details Grid",
                    "name": "IssueHistoryGrid",
                    "itemId": "IssueHistoryGrid",
                    "restURL": "/IssueHistory",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Issue Hist Id",
                         "dataIndex": "issueHistId",
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
                         "header": "Issue Id",
                         "dataIndex": "issueId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Category",
                         "dataIndex": "issueCategoryCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Feature Category",
                         "dataIndex": "featureCategoryCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Severity",
                         "dataIndex": "issueSeverityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Priority",
                         "dataIndex": "issuePriorityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Effort Estimate",
                         "dataIndex": "effortEstimate",
                         "flex": 1
                    }, {
                         "header": "Issue Flag",
                         "dataIndex": "issueFlagCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Stage",
                         "dataIndex": "issueStageCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Status",
                         "dataIndex": "issueStatusCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Issue Activity",
                         "dataIndex": "issueActivityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Last Updated On",
                         "dataIndex": "lastUpdated",
                         "flex": 1
                    }, {
                         "header": "User",
                         "dataIndex": "contactId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Date Of Issue",
                         "dataIndex": "issueDate",
                         "flex": 1
                    }, {
                         "header": "Start Time",
                         "dataIndex": "startTime",
                         "flex": 1
                    }, {
                         "header": "End Time",
                         "dataIndex": "endTime",
                         "flex": 1
                    }, {
                         "header": "Comments",
                         "dataIndex": "comments",
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
               "displayName": "Issue History",
               "title": "Issue History",
               "name": "IssueHistory",
               "itemId": "IssueHistoryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "issueHistId",
                    "itemId": "issueHistId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Issue Hist Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Issue Hist Id<font color='red'> *<\/font>",
                    "fieldId": "527AA2E4-D785-457A-AF69-427CDC06E62E",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "issueHistId"
               }, {
                    "name": "issueId",
                    "itemId": "issueId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Id",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel"
                    },
                    "fieldLabel": "Issue Id",
                    "fieldId": "C2985292-08CC-4B4C-8572-1DE44EBBD027",
                    "restURL": "IssueWorkflow",
                    "bindable": "issueId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueCategoryCode",
                    "itemId": "issueCategoryCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel"
                    },
                    "fieldLabel": "Issue Category",
                    "fieldId": "321AD5F0-90DE-4336-99C4-187C3E427FB1",
                    "restURL": "IssueCategory",
                    "bindable": "issueCategoryCode",
                    "columnWidth": 0.5
               }, {
                    "name": "featureCategoryCode",
                    "itemId": "featureCategoryCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Feature Category",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel"
                    },
                    "fieldLabel": "Feature Category",
                    "fieldId": "8A502B5B-24D0-4688-BB63-52F157BDC7BF",
                    "restURL": "FeatureCategory",
                    "bindable": "featureCategoryCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issueSeverityCode",
                    "itemId": "issueSeverityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Severity",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel"
                    },
                    "fieldLabel": "Issue Severity",
                    "fieldId": "17EAB7CD-A00B-4983-9610-C02614E1B50F",
                    "restURL": "IssueSeverity",
                    "bindable": "issueSeverityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issuePriorityCode",
                    "itemId": "issuePriorityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Priority",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel"
                    },
                    "fieldLabel": "Issue Priority",
                    "fieldId": "A2722EA4-488F-47BF-8BCB-118B005A236D",
                    "restURL": "IssuePriority",
                    "bindable": "issuePriorityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "effortEstimate",
                    "itemId": "effortEstimate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Effort Estimate",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Effort Estimate",
                    "fieldId": "586439BD-48A3-4868-8D6C-771AA502F1B6",
                    "bindable": "effortEstimate",
                    "columnWidth": 0.5
               }, {
                    "name": "issueFlagCode",
                    "itemId": "issueFlagCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Flag",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel"
                    },
                    "fieldLabel": "Issue Flag",
                    "fieldId": "11FBF8C1-637C-4707-9C95-C703449D83C6",
                    "restURL": "IssueFlag",
                    "bindable": "issueFlagCode",
                    "columnWidth": 0.5
               }, {
                    "name": "issueStageCode",
                    "itemId": "issueStageCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Stage",
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
                    "fieldLabel": "Issue Stage",
                    "fieldId": "AAB8EDAC-96E1-46A8-A89C-F5C6F854D459",
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
                    "displayName": "Issue Status",
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
                    "fieldLabel": "Issue Status",
                    "fieldId": "A6B900A7-C458-4C03-B708-AA2A0F325486",
                    "restURL": "IssueStatus",
                    "bindable": "issueStatusCode",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onIssueStatusCodeChange"
                    }
               }, {
                    "name": "issueActivityCode",
                    "itemId": "issueActivityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Activity",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel"
                    },
                    "fieldLabel": "Issue Activity",
                    "fieldId": "931A7CE3-0FF6-44F6-90FD-BFC940B2FBD0",
                    "restURL": "IssueActivity",
                    "bindable": "issueActivityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "lastUpdated",
                    "itemId": "lastUpdated",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Last Updated On",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Last Updated On",
                    "fieldId": "CB84AFB4-8869-4EB2-8E92-E5C2E455D274",
                    "bindable": "lastUpdated",
                    "columnWidth": 0.5
               }, {
                    "name": "contactId",
                    "itemId": "contactId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "User",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                    },
                    "fieldLabel": "User",
                    "fieldId": "DE57C42D-4DAC-453E-847D-18722CA7AC7F",
                    "restURL": "CoreContacts",
                    "bindable": "contactId",
                    "columnWidth": 0.5
               }, {
                    "name": "issueDate",
                    "itemId": "issueDate",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Date Of Issue",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Date Of Issue",
                    "fieldId": "A2D7292E-27B0-478F-BA3F-B6BC9420078A",
                    "bindable": "issueDate",
                    "columnWidth": 0.5
               }, {
                    "name": "startTime",
                    "itemId": "startTime",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "Start Time",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "Start Time",
                    "fieldId": "52B8AC3E-F81B-4B85-86F7-EB5CEDAA067B",
                    "bindable": "startTime",
                    "columnWidth": 0.5
               }, {
                    "name": "endTime",
                    "itemId": "endTime",
                    "xtype": "datefield",
                    "customWidgetType": "vdDatefield",
                    "displayName": "End Time",
                    "margin": "5 5 5 5",
                    "format": "d-m-Y",
                    "submitFormat": "d-m-Y",
                    "fieldLabel": "End Time",
                    "fieldId": "5D2AB979-89C7-4ABA-B3C7-C654E4E59F30",
                    "bindable": "endTime",
                    "columnWidth": 0.5
               }, {
                    "name": "comments",
                    "itemId": "comments",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Comments",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Comments",
                    "fieldId": "76256C0C-9F15-4512-BBB8-364925FB7E7B",
                    "bindable": "comments",
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
                    "fieldId": "9E1D44E1-FA81-47A1-8124-74029BC96E84",
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
                    "customId": 226,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 226,
                         "customId": 385
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 226,
                         "customId": 386,
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
                         "parentId": 226,
                         "customId": 387,
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