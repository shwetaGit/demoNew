Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.projectmanager.ProjectFeatureMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProjectFeatureMainController",
     "restURL": "/ProjectFeature",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectFeatureModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.projectmanager.ProjectFeatureMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.view.fw.component.Grids", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectModuleModel", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.projectmanager.ProjectFeatureViewModel"],
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
               "displayName": "Project Feature",
               "name": "ProjectFeatureTreeContainer",
               "itemId": "ProjectFeatureTreeContainer",
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
                    "itemId": "ProjectFeatureTree",
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
                    "displayName": "Project Feature",
                    "name": "ProjectFeature",
                    "itemId": "ProjectFeatureForm",
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
                                   "name": "featureId",
                                   "itemId": "featureId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Feature Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Id<font color='red'> *<\/font>",
                                   "fieldId": "85D74048-FA5D-4046-ADDA-1809BDC63605",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "featureId"
                              }, {
                                   "name": "moduleId",
                                   "itemId": "moduleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Module Id",
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
                                   "fieldLabel": "Module Id<font color='red'> *<\/font>",
                                   "fieldId": "082A13CD-8FCB-4A54-B77F-BAD3069E9413",
                                   "restURL": "ProjectModule",
                                   "bindable": "moduleId",
                                   "columnWidth": 0.5
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
                                   "fieldId": "3528B53C-991F-4D80-A5A6-B988522DADEC",
                                   "restURL": "CreateProject",
                                   "bindable": "projectId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onProjectIdChange"
                                   }
                              }, {
                                   "name": "featureName",
                                   "itemId": "featureName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Feature Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C5DDBB40-9A50-47C7-BFDE-9EC4691622C7",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "errorMessage": "Please enter valid project feature",
                                   "bindable": "featureName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "featureShortName",
                                   "itemId": "featureShortName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Feature Short Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Short Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "06AE4E2B-6F9B-4203-94FD-44555B848321",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "featureShortName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "featureDescription",
                                   "itemId": "featureDescription",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Feature Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Description<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "6B1D5520-358B-4959-A784-0565EF59385A",
                                   "bindable": "featureDescription",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "version",
                                   "itemId": "version",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Feature Version",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Version<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "774600C5-199D-4802-BE68-DD470B772519",
                                   "minValue": "0",
                                   "maxValue": "11",
                                   "bindable": "version",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "build",
                                   "itemId": "build",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Feature Build",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Feature Build<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "1D97FF46-5119-4407-AADB-3896AC6F00AB",
                                   "minValue": "0",
                                   "maxValue": "11",
                                   "bindable": "build",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateOfCreation",
                                   "itemId": "dateOfCreation",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Feature Creation Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Feature Creation Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "20F1A531-0EED-4579-86C2-CBD2769B37C9",
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
                                   "fieldId": "C94A37BA-ECC0-46CF-A254-34905C9FCFD2",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Feature User Mapping",
                         "title": "Feature User Mapping",
                         "name": "FeatureUserMapping",
                         "itemId": "FeatureUserMappingForm",
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
                                        "name": "isAdmin",
                                        "itemId": "isAdmin",
                                        "xtype": "checkbox",
                                        "customWidgetType": "vdCheckbox",
                                        "displayName": "Is Feature Admin",
                                        "margin": "5 5 5 5",
                                        "value": "0",
                                        "inputValue": true,
                                        "fieldLabel": "Is Feature Admin",
                                        "fieldId": "E5357F7F-FC71-4B4A-93C6-656AFE31C177",
                                        "bindable": "featureUserMapping.isAdmin",
                                        "columnWidth": 0.5
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
                                        "fieldId": "3ED958A3-EDF1-473E-8F0B-2EFC73B66798",
                                        "restURL": "CreateProject",
                                        "bindable": "featureUserMapping.projectId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onProjectIdChange"
                                        }
                                   }, {
                                        "name": "moduleId",
                                        "itemId": "moduleId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Module Id",
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
                                        "fieldLabel": "Module Id<font color='red'> *<\/font>",
                                        "fieldId": "3831C410-C6BF-4D1C-B8DF-9F44B91C8456",
                                        "restURL": "ProjectModule",
                                        "bindable": "featureUserMapping.moduleId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onModuleIdChange"
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
                                        "fieldId": "AADC1F71-B2F9-489F-A26A-D71B366E91A2",
                                        "restURL": "CoreContacts",
                                        "bindable": "featureUserMapping.contactId",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 253,
                              "text": "Add FeatureUserMapping",
                              "handler": "addFeatureUserMapping"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "FeatureUserMapping",
                              "columnWidth": 1,
                              "itemId": "FeatureUserMappingGrid",
                              "fieldLabel": "List",
                              "bindLevel": "featureUserMapping",
                              "bindable": "featureUserMapping",
                              "listeners": {
                                   "select": "onFeatureUserMappingGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Is Feature Admin",
                                   "text": "Is Feature Admin",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "isAdmin",
                                   "flex": 1
                              }, {
                                   "header": "Feature Pk",
                                   "text": "Feature Pk",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "feaUserId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Project Id",
                                   "text": "Project Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "projectId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Module Id",
                                   "text": "Module Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "moduleId",
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
                    "displayName": "Project Feature",
                    "title": "Details Grid",
                    "name": "ProjectFeatureGrid",
                    "itemId": "ProjectFeatureGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Feature Id",
                         "dataIndex": "featureId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Module Id",
                         "dataIndex": "moduleId",
                         "flex": 1
                    }, {
                         "header": "Project Id",
                         "dataIndex": "projectId",
                         "flex": 1
                    }, {
                         "header": "Feature Name",
                         "dataIndex": "featureName",
                         "flex": 1
                    }, {
                         "header": "Feature Short Name",
                         "dataIndex": "featureShortName",
                         "flex": 1
                    }, {
                         "header": "Feature Description",
                         "dataIndex": "featureDescription",
                         "flex": 1
                    }, {
                         "header": "Feature Version",
                         "dataIndex": "version",
                         "flex": 1
                    }, {
                         "header": "Feature Build",
                         "dataIndex": "build",
                         "flex": 1
                    }, {
                         "header": "Feature Creation Date",
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
               "displayName": "Project Feature",
               "name": "ProjectFeature",
               "itemId": "ProjectFeatureForm",
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
                              "name": "featureId",
                              "itemId": "featureId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Feature Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Id<font color='red'> *<\/font>",
                              "fieldId": "85D74048-FA5D-4046-ADDA-1809BDC63605",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "featureId"
                         }, {
                              "name": "moduleId",
                              "itemId": "moduleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Module Id",
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
                              "fieldLabel": "Module Id<font color='red'> *<\/font>",
                              "fieldId": "082A13CD-8FCB-4A54-B77F-BAD3069E9413",
                              "restURL": "ProjectModule",
                              "bindable": "moduleId",
                              "columnWidth": 0.5
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
                              "fieldId": "3528B53C-991F-4D80-A5A6-B988522DADEC",
                              "restURL": "CreateProject",
                              "bindable": "projectId",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onProjectIdChange"
                              }
                         }, {
                              "name": "featureName",
                              "itemId": "featureName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Feature Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C5DDBB40-9A50-47C7-BFDE-9EC4691622C7",
                              "minLength": "0",
                              "maxLength": "128",
                              "errorMessage": "Please enter valid project feature",
                              "bindable": "featureName",
                              "columnWidth": 0.5
                         }, {
                              "name": "featureShortName",
                              "itemId": "featureShortName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Feature Short Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Short Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "06AE4E2B-6F9B-4203-94FD-44555B848321",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "featureShortName",
                              "columnWidth": 0.5
                         }, {
                              "name": "featureDescription",
                              "itemId": "featureDescription",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Feature Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Description<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "6B1D5520-358B-4959-A784-0565EF59385A",
                              "bindable": "featureDescription",
                              "columnWidth": 0.5
                         }, {
                              "name": "version",
                              "itemId": "version",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Feature Version",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Version<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "774600C5-199D-4802-BE68-DD470B772519",
                              "minValue": "0",
                              "maxValue": "11",
                              "bindable": "version",
                              "columnWidth": 0.5
                         }, {
                              "name": "build",
                              "itemId": "build",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Feature Build",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Feature Build<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "1D97FF46-5119-4407-AADB-3896AC6F00AB",
                              "minValue": "0",
                              "maxValue": "11",
                              "bindable": "build",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateOfCreation",
                              "itemId": "dateOfCreation",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Feature Creation Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Feature Creation Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "20F1A531-0EED-4579-86C2-CBD2769B37C9",
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
                              "fieldId": "C94A37BA-ECC0-46CF-A254-34905C9FCFD2",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Feature User Mapping",
                    "title": "Feature User Mapping",
                    "name": "FeatureUserMapping",
                    "itemId": "FeatureUserMappingForm",
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
                                   "name": "isAdmin",
                                   "itemId": "isAdmin",
                                   "xtype": "checkbox",
                                   "customWidgetType": "vdCheckbox",
                                   "displayName": "Is Feature Admin",
                                   "margin": "5 5 5 5",
                                   "value": "0",
                                   "inputValue": true,
                                   "fieldLabel": "Is Feature Admin",
                                   "fieldId": "E5357F7F-FC71-4B4A-93C6-656AFE31C177",
                                   "bindable": "featureUserMapping.isAdmin",
                                   "columnWidth": 0.5
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
                                   "fieldId": "3ED958A3-EDF1-473E-8F0B-2EFC73B66798",
                                   "restURL": "CreateProject",
                                   "bindable": "featureUserMapping.projectId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onProjectIdChange"
                                   }
                              }, {
                                   "name": "moduleId",
                                   "itemId": "moduleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Module Id",
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
                                   "fieldLabel": "Module Id<font color='red'> *<\/font>",
                                   "fieldId": "3831C410-C6BF-4D1C-B8DF-9F44B91C8456",
                                   "restURL": "ProjectModule",
                                   "bindable": "featureUserMapping.moduleId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onModuleIdChange"
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
                                   "fieldId": "AADC1F71-B2F9-489F-A26A-D71B366E91A2",
                                   "restURL": "CoreContacts",
                                   "bindable": "featureUserMapping.contactId",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 253,
                         "text": "Add FeatureUserMapping",
                         "handler": "addFeatureUserMapping"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "FeatureUserMapping",
                         "columnWidth": 1,
                         "itemId": "FeatureUserMappingGrid",
                         "fieldLabel": "List",
                         "bindLevel": "featureUserMapping",
                         "bindable": "featureUserMapping",
                         "listeners": {
                              "select": "onFeatureUserMappingGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Is Feature Admin",
                              "text": "Is Feature Admin",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "isAdmin",
                              "flex": 1
                         }, {
                              "header": "Feature Pk",
                              "text": "Feature Pk",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "feaUserId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Project Id",
                              "text": "Project Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "projectId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Module Id",
                              "text": "Module Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "moduleId",
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