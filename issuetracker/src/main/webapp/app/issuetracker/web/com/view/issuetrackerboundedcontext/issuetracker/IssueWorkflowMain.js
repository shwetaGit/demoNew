Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.issuetracker.IssueWorkflowMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "IssueWorkflowMainController",
     "restURL": "/IssueWorkflow",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueWorkflowModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.issuetracker.IssueWorkflowMainController", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueCategoryModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.FeatureCategoryModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueSeverityModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssuePriorityModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueFlagModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStageModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueStatusModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.issuetracker.IssueActivityModel", "Issuetracker.view.fw.component.Grids", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.issuetracker.IssueWorkflowViewModel"],
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
               "displayName": "Issue Workflow",
               "name": "IssueWorkflowTreeContainer",
               "itemId": "IssueWorkflowTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "IssueWorkflowTree",
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
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
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
                    "xtype": "form",
                    "displayName": "Issue Workflow",
                    "name": "IssueWorkflow",
                    "itemId": "IssueWorkflowForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "issueId",
                                   "itemId": "issueId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Issue Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Issue Id<font color='red'> *<\/font>",
                                   "fieldId": "A3E88C3F-B7CA-4269-9DEA-2A2E6ABEC8EA",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "issueId"
                              }, {
                                   "name": "issueTitle",
                                   "itemId": "issueTitle",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Issue Title",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Issue Title<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "81F00C3C-7039-466D-8B7B-54808CA02AA1",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "issueTitle",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "issueDescription",
                                   "itemId": "issueDescription",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Issue Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Issue Description<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "F0560FF2-DF83-4A65-BCFE-6BF623DA2C3C",
                                   "bindable": "issueDescription",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "stepsToReproduce",
                                   "itemId": "stepsToReproduce",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Steps To Reproduce",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Steps To Reproduce",
                                   "fieldId": "7480A50C-4D53-46AC-B6D4-9EA585C91583",
                                   "bindable": "stepsToReproduce",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "creatorContactId",
                                   "itemId": "creatorContactId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Issue Created By",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Created By<font color='red'> *<\/font>",
                                   "fieldId": "BCC97C94-411C-4C88-A10E-F2B1ABE6D803",
                                   "restURL": "CoreContacts",
                                   "bindable": "creatorContactId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateCreated",
                                   "itemId": "dateCreated",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Created Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Created Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C6ED02C6-0C81-4641-A458-9EBD8DF6DE29",
                                   "bindable": "dateCreated",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Project Name",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Project Name<font color='red'> *<\/font>",
                                   "fieldId": "6AFC3EDE-8603-4FF2-8FB5-64FE47738E00",
                                   "restURL": "CreateProject",
                                   "bindable": "projectId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onProjectIdChange"
                                   }
                              }, {
                                   "name": "moduleId",
                                   "itemId": "moduleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Module Name",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Module Name<font color='red'> *<\/font>",
                                   "fieldId": "86E1DBEB-2E36-4263-8AC3-CE960605DC5F",
                                   "restURL": "ProjectModule",
                                   "bindable": "moduleId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onModuleIdChange"
                                   }
                              }, {
                                   "name": "featureId",
                                   "itemId": "featureId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Feature Name",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                                   "fieldId": "3B47F555-2BF5-4A66-A0F5-E09425BA0942",
                                   "restURL": "ProjectFeature",
                                   "bindable": "featureId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "browser",
                                   "itemId": "browser",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Browser",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Browser",
                                   "fieldId": "7DEA5F9A-72C7-44F3-BFD5-978F03315269",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "browser",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "oS",
                                   "itemId": "oS",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "OS",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "OS",
                                   "fieldId": "1BEFD3EC-1CB6-415A-9F9C-B1F20607963A",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "oS",
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
                                   "fieldId": "8BCD9412-306A-41AF-AF34-7B703A31EDC3",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Issue Assignment",
                         "title": "Issue Assignment",
                         "name": "IssueAssignment",
                         "itemId": "IssueAssignmentForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
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
                                        "allowBlank": false,
                                        "fieldLabel": "User<font color='red'> *<\/font>",
                                        "fieldId": "458A1E04-D7F0-4D74-824C-989038DA287C",
                                        "restURL": "CoreContacts",
                                        "bindable": "issueAssignment.contactId",
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
                                        "fieldLabel": "Date Of Issue<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "6FD0E619-5BB9-4BA1-9A77-B19F1321FC6F",
                                        "bindable": "issueAssignment.issueDate",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "startTime",
                                        "itemId": "startTime",
                                        "xtype": "datefield",
                                        "customWidgetType": "vdDatefield",
                                        "displayName": "Start Date",
                                        "margin": "5 5 5 5",
                                        "format": "d-m-Y",
                                        "submitFormat": "d-m-Y",
                                        "fieldLabel": "Start Date<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "FB940381-5D52-42B3-844C-04DDE0BE059F",
                                        "bindable": "issueAssignment.startTime",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "endTime",
                                        "itemId": "endTime",
                                        "xtype": "datefield",
                                        "customWidgetType": "vdDatefield",
                                        "displayName": "End Date",
                                        "margin": "5 5 5 5",
                                        "format": "d-m-Y",
                                        "submitFormat": "d-m-Y",
                                        "fieldLabel": "End Date",
                                        "fieldId": "341549E7-407C-4954-BDBB-E2D528DDCFC3",
                                        "bindable": "issueAssignment.endTime",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "comments",
                                        "itemId": "comments",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Comments",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Comments<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "C41EEBBC-3DE2-4ED8-9553-A28DB2260777",
                                        "bindable": "issueAssignment.comments",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Issue Headers",
                         "title": "Issue Headers",
                         "name": "IssueHeaders",
                         "itemId": "IssueHeadersForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Category<font color='red'> *<\/font>",
                                        "fieldId": "06505E9D-A201-48B7-ABBF-8E751FBE33E4",
                                        "restURL": "IssueCategory",
                                        "bindable": "issueHeaders.issueCategoryCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Feature Category<font color='red'> *<\/font>",
                                        "fieldId": "94B3F7BA-98DF-448B-B49D-5B1C71F9073D",
                                        "restURL": "FeatureCategory",
                                        "bindable": "issueHeaders.featureCategoryCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Severity<font color='red'> *<\/font>",
                                        "fieldId": "0F48B628-C65C-4061-BC31-8C16FACB1D3B",
                                        "restURL": "IssueSeverity",
                                        "bindable": "issueHeaders.issueSeverityCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Priority<font color='red'> *<\/font>",
                                        "fieldId": "04BAB16F-D0E4-430B-A1D6-27528E343D38",
                                        "restURL": "IssuePriority",
                                        "bindable": "issueHeaders.issuePriorityCode",
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
                                        "fieldLabel": "Effort Estimate<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "C4D727AD-B383-4F11-BF63-4785A8B24620",
                                        "bindable": "issueHeaders.effortEstimate",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Flag<font color='red'> *<\/font>",
                                        "fieldId": "B80151C7-AAA3-4DD1-9BE2-D396F9F942DC",
                                        "restURL": "IssueFlag",
                                        "bindable": "issueHeaders.issueFlagCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Stage<font color='red'> *<\/font>",
                                        "fieldId": "5130BD8C-8509-4436-AABB-4C6FB66CFAA6",
                                        "restURL": "IssueStage",
                                        "bindable": "issueHeaders.issueStageCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                                        "fieldId": "0F94E3C7-4E1A-4122-8CEE-7FDC65055525",
                                        "restURL": "IssueStatus",
                                        "bindable": "issueHeaders.issueStatusCode",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Issue Activity<font color='red'> *<\/font>",
                                        "fieldId": "41336641-72A7-439B-B84D-36D4A18BAEFA",
                                        "restURL": "IssueActivity",
                                        "bindable": "issueHeaders.issueActivityCode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "comments",
                                        "itemId": "comments",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Comments",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Comments<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "5300BF04-8195-411E-A9C9-B1346224CFF4",
                                        "bindable": "issueHeaders.comments",
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
                                        "fieldLabel": "Last Updated On<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "D9355ED9-BAA7-437A-89E1-402AD84AF9B1",
                                        "bindable": "issueHeaders.lastUpdated",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Add Watchers",
                         "title": "Add Watchers",
                         "name": "AddWatchers",
                         "itemId": "AddWatchersForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "contactId",
                                        "itemId": "contactId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Contact Id",
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
                                        "allowBlank": false,
                                        "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                        "fieldId": "2ED38431-0C41-4832-8BA1-53AF0BE8583E",
                                        "restURL": "CoreContacts",
                                        "bindable": "addWatchers.contactId",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 176,
                              "text": "Add AddWatchers",
                              "handler": "addAddWatchers"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "AddWatchers",
                              "columnWidth": 1,
                              "itemId": "AddWatchersGrid",
                              "fieldLabel": "List",
                              "bindLevel": "addWatchers",
                              "bindable": "addWatchers",
                              "listeners": {
                                   "select": "onAddWatchersGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Watch Id",
                                   "text": "Watch Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "watchId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Contact Id",
                                   "text": "Contact Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "contactId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Issue Workflow",
                    "title": "Details Grid",
                    "name": "IssueWorkflowGrid",
                    "itemId": "IssueWorkflowGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Issue Id",
                         "dataIndex": "issueId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Issue Title",
                         "dataIndex": "issueTitle",
                         "flex": 1
                    }, {
                         "header": "Issue Description",
                         "dataIndex": "issueDescription",
                         "flex": 1
                    }, {
                         "header": "Steps To Reproduce",
                         "dataIndex": "stepsToReproduce",
                         "flex": 1
                    }, {
                         "header": "Issue Created By",
                         "dataIndex": "creatorContactId",
                         "flex": 1
                    }, {
                         "header": "Created Date",
                         "dataIndex": "dateCreated",
                         "flex": 1
                    }, {
                         "header": "Project Name",
                         "dataIndex": "projectId",
                         "flex": 1
                    }, {
                         "header": "Module Name",
                         "dataIndex": "moduleId",
                         "flex": 1
                    }, {
                         "header": "Feature Name",
                         "dataIndex": "featureId",
                         "flex": 1
                    }, {
                         "header": "Browser",
                         "dataIndex": "browser",
                         "flex": 1
                    }, {
                         "header": "OS",
                         "dataIndex": "oS",
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
               "xtype": "form",
               "displayName": "Issue Workflow",
               "name": "IssueWorkflow",
               "itemId": "IssueWorkflowForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "issueId",
                              "itemId": "issueId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Issue Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Issue Id<font color='red'> *<\/font>",
                              "fieldId": "A3E88C3F-B7CA-4269-9DEA-2A2E6ABEC8EA",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "issueId"
                         }, {
                              "name": "issueTitle",
                              "itemId": "issueTitle",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Issue Title",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Issue Title<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "81F00C3C-7039-466D-8B7B-54808CA02AA1",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "issueTitle",
                              "columnWidth": 0.5
                         }, {
                              "name": "issueDescription",
                              "itemId": "issueDescription",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Issue Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Issue Description<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F0560FF2-DF83-4A65-BCFE-6BF623DA2C3C",
                              "bindable": "issueDescription",
                              "columnWidth": 0.5
                         }, {
                              "name": "stepsToReproduce",
                              "itemId": "stepsToReproduce",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Steps To Reproduce",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Steps To Reproduce",
                              "fieldId": "7480A50C-4D53-46AC-B6D4-9EA585C91583",
                              "bindable": "stepsToReproduce",
                              "columnWidth": 0.5
                         }, {
                              "name": "creatorContactId",
                              "itemId": "creatorContactId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Issue Created By",
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
                              "allowBlank": false,
                              "fieldLabel": "Issue Created By<font color='red'> *<\/font>",
                              "fieldId": "BCC97C94-411C-4C88-A10E-F2B1ABE6D803",
                              "restURL": "CoreContacts",
                              "bindable": "creatorContactId",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateCreated",
                              "itemId": "dateCreated",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Created Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Created Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C6ED02C6-0C81-4641-A458-9EBD8DF6DE29",
                              "bindable": "dateCreated",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectId",
                              "itemId": "projectId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Project Name",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Project Name<font color='red'> *<\/font>",
                              "fieldId": "6AFC3EDE-8603-4FF2-8FB5-64FE47738E00",
                              "restURL": "CreateProject",
                              "bindable": "projectId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onProjectIdChange"
                              }
                         }, {
                              "name": "moduleId",
                              "itemId": "moduleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Module Name",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Module Name<font color='red'> *<\/font>",
                              "fieldId": "86E1DBEB-2E36-4263-8AC3-CE960605DC5F",
                              "restURL": "ProjectModule",
                              "bindable": "moduleId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onModuleIdChange"
                              }
                         }, {
                              "name": "featureId",
                              "itemId": "featureId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Feature Name",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                              "fieldId": "3B47F555-2BF5-4A66-A0F5-E09425BA0942",
                              "restURL": "ProjectFeature",
                              "bindable": "featureId",
                              "columnWidth": 0.5
                         }, {
                              "name": "browser",
                              "itemId": "browser",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Browser",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Browser",
                              "fieldId": "7DEA5F9A-72C7-44F3-BFD5-978F03315269",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "browser",
                              "columnWidth": 0.5
                         }, {
                              "name": "oS",
                              "itemId": "oS",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "OS",
                              "margin": "5 5 5 5",
                              "fieldLabel": "OS",
                              "fieldId": "1BEFD3EC-1CB6-415A-9F9C-B1F20607963A",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "oS",
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
                              "fieldId": "8BCD9412-306A-41AF-AF34-7B703A31EDC3",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Issue Assignment",
                    "title": "Issue Assignment",
                    "name": "IssueAssignment",
                    "itemId": "IssueAssignmentForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
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
                                   "allowBlank": false,
                                   "fieldLabel": "User<font color='red'> *<\/font>",
                                   "fieldId": "458A1E04-D7F0-4D74-824C-989038DA287C",
                                   "restURL": "CoreContacts",
                                   "bindable": "issueAssignment.contactId",
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
                                   "fieldLabel": "Date Of Issue<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "6FD0E619-5BB9-4BA1-9A77-B19F1321FC6F",
                                   "bindable": "issueAssignment.issueDate",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "startTime",
                                   "itemId": "startTime",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Start Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Start Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "FB940381-5D52-42B3-844C-04DDE0BE059F",
                                   "bindable": "issueAssignment.startTime",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "endTime",
                                   "itemId": "endTime",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "End Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "End Date",
                                   "fieldId": "341549E7-407C-4954-BDBB-E2D528DDCFC3",
                                   "bindable": "issueAssignment.endTime",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "comments",
                                   "itemId": "comments",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Comments",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Comments<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C41EEBBC-3DE2-4ED8-9553-A28DB2260777",
                                   "bindable": "issueAssignment.comments",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Issue Headers",
                    "title": "Issue Headers",
                    "name": "IssueHeaders",
                    "itemId": "IssueHeadersForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Category<font color='red'> *<\/font>",
                                   "fieldId": "06505E9D-A201-48B7-ABBF-8E751FBE33E4",
                                   "restURL": "IssueCategory",
                                   "bindable": "issueHeaders.issueCategoryCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Feature Category<font color='red'> *<\/font>",
                                   "fieldId": "94B3F7BA-98DF-448B-B49D-5B1C71F9073D",
                                   "restURL": "FeatureCategory",
                                   "bindable": "issueHeaders.featureCategoryCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Severity<font color='red'> *<\/font>",
                                   "fieldId": "0F48B628-C65C-4061-BC31-8C16FACB1D3B",
                                   "restURL": "IssueSeverity",
                                   "bindable": "issueHeaders.issueSeverityCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Priority<font color='red'> *<\/font>",
                                   "fieldId": "04BAB16F-D0E4-430B-A1D6-27528E343D38",
                                   "restURL": "IssuePriority",
                                   "bindable": "issueHeaders.issuePriorityCode",
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
                                   "fieldLabel": "Effort Estimate<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C4D727AD-B383-4F11-BF63-4785A8B24620",
                                   "bindable": "issueHeaders.effortEstimate",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Flag<font color='red'> *<\/font>",
                                   "fieldId": "B80151C7-AAA3-4DD1-9BE2-D396F9F942DC",
                                   "restURL": "IssueFlag",
                                   "bindable": "issueHeaders.issueFlagCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Stage<font color='red'> *<\/font>",
                                   "fieldId": "5130BD8C-8509-4436-AABB-4C6FB66CFAA6",
                                   "restURL": "IssueStage",
                                   "bindable": "issueHeaders.issueStageCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Status<font color='red'> *<\/font>",
                                   "fieldId": "0F94E3C7-4E1A-4122-8CEE-7FDC65055525",
                                   "restURL": "IssueStatus",
                                   "bindable": "issueHeaders.issueStatusCode",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Issue Activity<font color='red'> *<\/font>",
                                   "fieldId": "41336641-72A7-439B-B84D-36D4A18BAEFA",
                                   "restURL": "IssueActivity",
                                   "bindable": "issueHeaders.issueActivityCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "comments",
                                   "itemId": "comments",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Comments",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Comments<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "5300BF04-8195-411E-A9C9-B1346224CFF4",
                                   "bindable": "issueHeaders.comments",
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
                                   "fieldLabel": "Last Updated On<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D9355ED9-BAA7-437A-89E1-402AD84AF9B1",
                                   "bindable": "issueHeaders.lastUpdated",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Add Watchers",
                    "title": "Add Watchers",
                    "name": "AddWatchers",
                    "itemId": "AddWatchersForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "contactId",
                                   "itemId": "contactId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Contact Id",
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
                                   "allowBlank": false,
                                   "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                   "fieldId": "2ED38431-0C41-4832-8BA1-53AF0BE8583E",
                                   "restURL": "CoreContacts",
                                   "bindable": "addWatchers.contactId",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 176,
                         "text": "Add AddWatchers",
                         "handler": "addAddWatchers"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "AddWatchers",
                         "columnWidth": 1,
                         "itemId": "AddWatchersGrid",
                         "fieldLabel": "List",
                         "bindLevel": "addWatchers",
                         "bindable": "addWatchers",
                         "listeners": {
                              "select": "onAddWatchersGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Watch Id",
                              "text": "Watch Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "watchId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Contact Id",
                              "text": "Contact Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "contactId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});