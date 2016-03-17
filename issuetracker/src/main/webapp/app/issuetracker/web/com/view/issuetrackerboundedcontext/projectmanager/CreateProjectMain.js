Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.projectmanager.CreateProjectMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CreateProjectMainController",
     "restURL": "/CreateProject",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.CreateProjectModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.projectmanager.CreateProjectMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsModel", "Issuetracker.view.fw.component.Grids", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.projectmanager.CreateProjectViewModel"],
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
               "displayName": "Create Project",
               "name": "CreateProjectTreeContainer",
               "itemId": "CreateProjectTreeContainer",
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
                    "itemId": "CreateProjectTree",
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
                    "displayName": "Create Project",
                    "name": "CreateProject",
                    "itemId": "CreateProjectForm",
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
                                   "name": "projectId",
                                   "itemId": "projectId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "projectId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "projectId<font color='red'> *<\/font>",
                                   "fieldId": "B15E65B7-0371-495F-A3B4-3A50E51B8EC9",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "projectId"
                              }, {
                                   "name": "projectName",
                                   "itemId": "projectName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "8AF3D859-DF4E-4DD5-BDCD-6A70E03C581A",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "errorMessage": "Please enter valid Project",
                                   "bindable": "projectName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectShortName",
                                   "itemId": "projectShortName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Short Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Short Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D45FADA5-6E00-4C6D-8810-C5405D241BD0",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "projectShortName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectDescription",
                                   "itemId": "projectDescription",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Project Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Description<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "B97EBCB3-A245-4B0E-B1F2-8F3812014129",
                                   "bindable": "projectDescription",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectURL",
                                   "itemId": "projectURL",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project URL",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project URL",
                                   "fieldId": "1296F14A-33DC-4362-AFDA-8AADFF563BFF",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "projectURL",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "projectAccessCode",
                                   "itemId": "projectAccessCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Access Code",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Access Code<font color='red'> *<\/font>",
                                   "fieldId": "AA42F53F-7D1B-4D8C-8AE1-D3C3BD208A00",
                                   "restURL": "ProjectAccessRights",
                                   "bindable": "projectAccessCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "version",
                                   "itemId": "version",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Version",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Version",
                                   "fieldId": "4BBA0952-789E-4F72-87B7-261646C1BF23",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "version",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "build",
                                   "itemId": "build",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Project Build",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Project Build",
                                   "fieldId": "7B7A97D0-7BC3-4F82-88DF-9CECBCBD1456",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "build",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "dateOfCreation",
                                   "itemId": "dateOfCreation",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Project Creation Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Project Creation Date",
                                   "fieldId": "B92BAC3E-5420-4E6C-9C0D-F50E50ACB243",
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
                                   "fieldId": "9D93EAD7-EFE5-4471-B678-BF495EB955BC",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Project User Mapping",
                         "title": "Project User Mapping",
                         "name": "ProjectUserMapping",
                         "itemId": "ProjectUserMappingForm",
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
                                        "fieldId": "E514B983-33CE-4F22-9DD1-7130FCEBE33B",
                                        "restURL": "CoreContacts",
                                        "bindable": "projectUserMapping.contactId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "isAdmin",
                                        "itemId": "isAdmin",
                                        "xtype": "checkbox",
                                        "customWidgetType": "vdCheckbox",
                                        "displayName": "Is Project Admin",
                                        "margin": "5 5 5 5",
                                        "value": "0",
                                        "inputValue": true,
                                        "fieldLabel": "Is Project Admin",
                                        "fieldId": "9D47C444-B1D8-41EB-A0FA-EB14CCA3385E",
                                        "bindable": "projectUserMapping.isAdmin",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 253,
                              "text": "Add ProjectUserMapping",
                              "handler": "addProjectUserMapping"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "ProjectUserMapping",
                              "columnWidth": 1,
                              "itemId": "ProjectUserMappingGrid",
                              "fieldLabel": "List",
                              "bindLevel": "projectUserMapping",
                              "bindable": "projectUserMapping",
                              "listeners": {
                                   "select": "onProjectUserMappingGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Project Pk",
                                   "text": "Project Pk",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "prjUserId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "User",
                                   "text": "User",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "contactId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Is Project Admin",
                                   "text": "Is Project Admin",
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
                    "displayName": "Create Project",
                    "title": "Details Grid",
                    "name": "CreateProjectGrid",
                    "itemId": "CreateProjectGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "projectId",
                         "dataIndex": "projectId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Project Name",
                         "dataIndex": "projectName",
                         "flex": 1
                    }, {
                         "header": "Project Short Name",
                         "dataIndex": "projectShortName",
                         "flex": 1
                    }, {
                         "header": "Project Description",
                         "dataIndex": "projectDescription",
                         "flex": 1
                    }, {
                         "header": "Project URL",
                         "dataIndex": "projectURL",
                         "flex": 1
                    }, {
                         "header": "Access Code",
                         "dataIndex": "projectAccessCode",
                         "flex": 1
                    }, {
                         "header": "Project Version",
                         "dataIndex": "version",
                         "flex": 1
                    }, {
                         "header": "Project Build",
                         "dataIndex": "build",
                         "flex": 1
                    }, {
                         "header": "Project Creation Date",
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
               "displayName": "Create Project",
               "name": "CreateProject",
               "itemId": "CreateProjectForm",
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
                              "name": "projectId",
                              "itemId": "projectId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "projectId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "projectId<font color='red'> *<\/font>",
                              "fieldId": "B15E65B7-0371-495F-A3B4-3A50E51B8EC9",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "projectId"
                         }, {
                              "name": "projectName",
                              "itemId": "projectName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "8AF3D859-DF4E-4DD5-BDCD-6A70E03C581A",
                              "minLength": "0",
                              "maxLength": "128",
                              "errorMessage": "Please enter valid Project",
                              "bindable": "projectName",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectShortName",
                              "itemId": "projectShortName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Short Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Short Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "D45FADA5-6E00-4C6D-8810-C5405D241BD0",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "projectShortName",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectDescription",
                              "itemId": "projectDescription",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Project Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Description<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "B97EBCB3-A245-4B0E-B1F2-8F3812014129",
                              "bindable": "projectDescription",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectURL",
                              "itemId": "projectURL",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project URL",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project URL",
                              "fieldId": "1296F14A-33DC-4362-AFDA-8AADFF563BFF",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "projectURL",
                              "columnWidth": 0.5
                         }, {
                              "name": "projectAccessCode",
                              "itemId": "projectAccessCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Access Code",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Access Code<font color='red'> *<\/font>",
                              "fieldId": "AA42F53F-7D1B-4D8C-8AE1-D3C3BD208A00",
                              "restURL": "ProjectAccessRights",
                              "bindable": "projectAccessCode",
                              "columnWidth": 0.5
                         }, {
                              "name": "version",
                              "itemId": "version",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Version",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Version",
                              "fieldId": "4BBA0952-789E-4F72-87B7-261646C1BF23",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "version",
                              "columnWidth": 0.5
                         }, {
                              "name": "build",
                              "itemId": "build",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Project Build",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Project Build",
                              "fieldId": "7B7A97D0-7BC3-4F82-88DF-9CECBCBD1456",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "build",
                              "columnWidth": 0.5
                         }, {
                              "name": "dateOfCreation",
                              "itemId": "dateOfCreation",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Project Creation Date",
                              "margin": "5 5 5 5",
                              "format": "d-m-Y",
                              "submitFormat": "d-m-Y",
                              "fieldLabel": "Project Creation Date",
                              "fieldId": "B92BAC3E-5420-4E6C-9C0D-F50E50ACB243",
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
                              "fieldId": "9D93EAD7-EFE5-4471-B678-BF495EB955BC",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Project User Mapping",
                    "title": "Project User Mapping",
                    "name": "ProjectUserMapping",
                    "itemId": "ProjectUserMappingForm",
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
                                   "fieldId": "E514B983-33CE-4F22-9DD1-7130FCEBE33B",
                                   "restURL": "CoreContacts",
                                   "bindable": "projectUserMapping.contactId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "isAdmin",
                                   "itemId": "isAdmin",
                                   "xtype": "checkbox",
                                   "customWidgetType": "vdCheckbox",
                                   "displayName": "Is Project Admin",
                                   "margin": "5 5 5 5",
                                   "value": "0",
                                   "inputValue": true,
                                   "fieldLabel": "Is Project Admin",
                                   "fieldId": "9D47C444-B1D8-41EB-A0FA-EB14CCA3385E",
                                   "bindable": "projectUserMapping.isAdmin",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 253,
                         "text": "Add ProjectUserMapping",
                         "handler": "addProjectUserMapping"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "ProjectUserMapping",
                         "columnWidth": 1,
                         "itemId": "ProjectUserMappingGrid",
                         "fieldLabel": "List",
                         "bindLevel": "projectUserMapping",
                         "bindable": "projectUserMapping",
                         "listeners": {
                              "select": "onProjectUserMappingGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Project Pk",
                              "text": "Project Pk",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "prjUserId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "User",
                              "text": "User",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "contactId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Is Project Admin",
                              "text": "Is Project Admin",
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