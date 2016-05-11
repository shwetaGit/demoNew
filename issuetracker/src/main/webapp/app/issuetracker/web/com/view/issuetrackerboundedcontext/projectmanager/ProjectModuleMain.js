Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.projectmanager.ProjectModuleMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProjectModuleMainController",
     "restURL": "/ProjectModule",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.projectmanager.ProjectModuleMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.view.fw.component.Grids", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.projectmanager.ProjectModuleViewModel"],
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
               "displayName": "Project Module",
               "name": "ProjectModuleTreeContainer",
               "itemId": "ProjectModuleTreeContainer",
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
                    "itemId": "ProjectModuleTree",
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
                    "displayName": "Project Module",
                    "name": "ProjectModule",
                    "itemId": "ProjectModuleForm",
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
                                   "name": "moduleId",
                                   "itemId": "moduleId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Module Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Module Id<font color='red'> *<\/font>",
                                   "fieldId": "2CF6D1F9-B88D-4E4F-A7EC-E39598FF2E6D",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "moduleId"
                              }, {
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Project Id",
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
                                   "fieldLabel": "Project Id<font color='red'> *<\/font>",
                                   "fieldId": "F903DC7D-DAEE-4651-8EF8-49407FD17BEF",
                                   "restURL": "CreateProject",
                                   "bindable": "projectId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "moduleName",
                                   "itemId": "moduleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Module Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Module Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "DF0363A0-D881-4C08-958B-7FD1FD0E586B",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "errorMessage": "Please enter valid project module",
                                   "bindable": "moduleName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "moduleShortName",
                                   "itemId": "moduleShortName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Module Short Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Module Short Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "DE73EE5E-5024-4E7E-B110-E6961CCBDD33",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "moduleShortName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "moduleDescription",
                                   "itemId": "moduleDescription",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Module Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Module Description<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "105AD965-02C7-4ECA-8481-122EAA78FA3F",
                                   "bindable": "moduleDescription",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "version",
                                   "itemId": "version",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Module Version",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Module Version",
                                   "fieldId": "1F4FBFE8-05BB-4E43-909E-A56BC2A651FE",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "version",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "build",
                                   "itemId": "build",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Module Build",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Module Build",
                                   "fieldId": "9CB16512-2FF8-4C7C-B1E8-1B0A3FF66E8E",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "build",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateOfCreation",
                                   "itemId": "dateOfCreation",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Module Creation Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Module Creation Date",
                                   "fieldId": "68724D41-6BCD-4DC7-8EE7-D307C714A66C",
                                   "bindable": "dateOfCreation",
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
                                   "fieldId": "95A257F9-1C59-409D-B2F4-BD7EE0F367F9",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Module User Mapping",
                         "title": "Module User Mapping",
                         "name": "ModuleUserMapping",
                         "itemId": "ModuleUserMappingForm",
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
                                        "name": "projectId",
                                        "itemId": "projectId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Project",
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
                                        "fieldLabel": "Project<font color='red'> *<\/font>",
                                        "fieldId": "DC48E719-0DFA-4787-8406-571CB43DB78E",
                                        "restURL": "CreateProject",
                                        "bindable": "moduleUserMapping.projectId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onProjectIdChange"
                                        }
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
                                        "allowBlank": false,
                                        "fieldLabel": "User<font color='red'> *<\/font>",
                                        "fieldId": "AAE54F89-A26C-484A-A64D-1608875FCF6B",
                                        "restURL": "CoreContacts",
                                        "bindable": "moduleUserMapping.contactId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "isAdmin",
                                        "itemId": "isAdmin",
                                        "xtype": "checkbox",
                                        "customWidgetType": "vdCheckbox",
                                        "displayName": "Is Module Admin",
                                        "margin": "5 5 5 5",
                                        "value": "0",
                                        "inputValue": true,
                                        "fieldLabel": "Is Module Admin",
                                        "fieldId": "74B5E925-68F5-4794-83B8-7908E20A289C",
                                        "bindable": "moduleUserMapping.isAdmin",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 242,
                              "text": "Add ModuleUserMapping",
                              "handler": "addModuleUserMapping"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "ModuleUserMapping",
                              "columnWidth": 1,
                              "itemId": "ModuleUserMappingGrid",
                              "fieldLabel": "List",
                              "bindLevel": "moduleUserMapping",
                              "bindable": "moduleUserMapping",
                              "listeners": {
                                   "select": "onModuleUserMappingGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Module Pk",
                                   "text": "Module Pk",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "modUserId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Project",
                                   "text": "Project",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "projectId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "User",
                                   "text": "User",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "contactId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Is Module Admin",
                                   "text": "Is Module Admin",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "isAdmin",
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
                    "displayName": "Project Module",
                    "title": "Details Grid",
                    "name": "ProjectModuleGrid",
                    "itemId": "ProjectModuleGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Module Id",
                         "dataIndex": "moduleId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Project Id",
                         "dataIndex": "projectId",
                         "flex": 1
                    }, {
                         "header": "Module Name",
                         "dataIndex": "moduleName",
                         "flex": 1
                    }, {
                         "header": "Module Short Name",
                         "dataIndex": "moduleShortName",
                         "flex": 1
                    }, {
                         "header": "Module Description",
                         "dataIndex": "moduleDescription",
                         "flex": 1
                    }, {
                         "header": "Module Version",
                         "dataIndex": "version",
                         "flex": 1
                    }, {
                         "header": "Module Build",
                         "dataIndex": "build",
                         "flex": 1
                    }, {
                         "header": "Module Creation Date",
                         "dataIndex": "dateOfCreation",
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
               "displayName": "Project Module",
               "name": "ProjectModule",
               "itemId": "ProjectModuleForm",
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
                              "name": "moduleId",
                              "itemId": "moduleId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Module Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Module Id<font color='red'> *<\/font>",
                              "fieldId": "2CF6D1F9-B88D-4E4F-A7EC-E39598FF2E6D",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "moduleId"
                         }, {
                              "name": "projectId",
                              "itemId": "projectId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Project Id",
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
                              "fieldLabel": "Project Id<font color='red'> *<\/font>",
                              "fieldId": "F903DC7D-DAEE-4651-8EF8-49407FD17BEF",
                              "restURL": "CreateProject",
                              "bindable": "projectId",
                              "columnWidth": 0.5
                         }, {
                              "name": "moduleName",
                              "itemId": "moduleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Module Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Module Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "DF0363A0-D881-4C08-958B-7FD1FD0E586B",
                              "minLength": "0",
                              "maxLength": "128",
                              "errorMessage": "Please enter valid project module",
                              "bindable": "moduleName",
                              "columnWidth": 0.5
                         }, {
                              "name": "moduleShortName",
                              "itemId": "moduleShortName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Module Short Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Module Short Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "DE73EE5E-5024-4E7E-B110-E6961CCBDD33",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "moduleShortName",
                              "columnWidth": 0.5
                         }, {
                              "name": "moduleDescription",
                              "itemId": "moduleDescription",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Module Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Module Description<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "105AD965-02C7-4ECA-8481-122EAA78FA3F",
                              "bindable": "moduleDescription",
                              "columnWidth": 0.5
                         }, {
                              "name": "version",
                              "itemId": "version",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Module Version",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Module Version",
                              "fieldId": "1F4FBFE8-05BB-4E43-909E-A56BC2A651FE",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "version",
                              "columnWidth": 0.5
                         }, {
                              "name": "build",
                              "itemId": "build",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Module Build",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Module Build",
                              "fieldId": "9CB16512-2FF8-4C7C-B1E8-1B0A3FF66E8E",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "build",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateOfCreation",
                              "itemId": "dateOfCreation",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Module Creation Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Module Creation Date",
                              "fieldId": "68724D41-6BCD-4DC7-8EE7-D307C714A66C",
                              "bindable": "dateOfCreation",
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
                              "fieldId": "95A257F9-1C59-409D-B2F4-BD7EE0F367F9",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Module User Mapping",
                    "title": "Module User Mapping",
                    "name": "ModuleUserMapping",
                    "itemId": "ModuleUserMappingForm",
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
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Project",
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
                                   "fieldLabel": "Project<font color='red'> *<\/font>",
                                   "fieldId": "DC48E719-0DFA-4787-8406-571CB43DB78E",
                                   "restURL": "CreateProject",
                                   "bindable": "moduleUserMapping.projectId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onProjectIdChange"
                                   }
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
                                   "allowBlank": false,
                                   "fieldLabel": "User<font color='red'> *<\/font>",
                                   "fieldId": "AAE54F89-A26C-484A-A64D-1608875FCF6B",
                                   "restURL": "CoreContacts",
                                   "bindable": "moduleUserMapping.contactId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "isAdmin",
                                   "itemId": "isAdmin",
                                   "xtype": "checkbox",
                                   "customWidgetType": "vdCheckbox",
                                   "displayName": "Is Module Admin",
                                   "margin": "5 5 5 5",
                                   "value": "0",
                                   "inputValue": true,
                                   "fieldLabel": "Is Module Admin",
                                   "fieldId": "74B5E925-68F5-4794-83B8-7908E20A289C",
                                   "bindable": "moduleUserMapping.isAdmin",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 242,
                         "text": "Add ModuleUserMapping",
                         "handler": "addModuleUserMapping"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "ModuleUserMapping",
                         "columnWidth": 1,
                         "itemId": "ModuleUserMappingGrid",
                         "fieldLabel": "List",
                         "bindLevel": "moduleUserMapping",
                         "bindable": "moduleUserMapping",
                         "listeners": {
                              "select": "onModuleUserMappingGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Module Pk",
                              "text": "Module Pk",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "modUserId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Project",
                              "text": "Project",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "projectId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "User",
                              "text": "User",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "contactId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Is Module Admin",
                              "text": "Is Module Admin",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "isAdmin",
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