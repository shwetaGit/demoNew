Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.projectmanager.ProjectRolesMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProjectRolesMainController",
     "restURL": "/ProjectRoles",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectRolesModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.projectmanager.ProjectRolesMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueVisibilityModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.projectmanager.ProjectRolesViewModel"],
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
               "displayName": "Project Roles",
               "name": "ProjectRolesTreeContainer",
               "itemId": "ProjectRolesTreeContainer",
               "restURL": "/ProjectRoles",
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
                    "itemId": "ProjectRolesTree",
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
                    "displayName": "Project Roles",
                    "title": "Project Roles",
                    "name": "ProjectRoles",
                    "itemId": "ProjectRolesForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "prjRoleId",
                         "itemId": "prjRoleId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Role Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Role Id<font color='red'> *<\/font>",
                         "fieldId": "A04634CE-E12C-4993-B27F-BB56CBE053A7",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "prjRoleId"
                    }, {
                         "name": "roleName",
                         "itemId": "roleName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Role Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Role Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0E66944F-D9B8-46B9-8762-1490436CA8A7",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "roleName",
                         "columnWidth": 0.5
                    }, {
                         "name": "issueVisibilityCode",
                         "itemId": "issueVisibilityCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Issue Visiblity Code",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueVisibilityModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Issue Visiblity Code<font color='red'> *<\/font>",
                         "fieldId": "C5F4171B-FCA0-4D09-845B-AD0A069C340C",
                         "restURL": "IssueVisibility",
                         "bindable": "issueVisibilityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "canAssignRole",
                         "itemId": "canAssignRole",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "Can Assign Role",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "Can Assign Role",
                         "fieldId": "205497DC-2F28-420C-8A00-7FF6B224A560",
                         "bindable": "canAssignRole",
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
                         "fieldId": "A203AEF8-6061-499A-A4EC-592D9DE12E42",
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
                         "customId": 519,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 519,
                              "customId": 4
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 519,
                              "customId": 5,
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
                              "parentId": 519,
                              "customId": 6,
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
                    "displayName": "Project Roles",
                    "title": "Details Grid",
                    "name": "ProjectRolesGrid",
                    "itemId": "ProjectRolesGrid",
                    "restURL": "/ProjectRoles",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Role Id",
                         "dataIndex": "prjRoleId",
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
                         "header": "Role Name",
                         "dataIndex": "roleName",
                         "flex": 1
                    }, {
                         "header": "Issue Visiblity Code",
                         "dataIndex": "issueVisibilityCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Can Assign Role",
                         "dataIndex": "canAssignRole",
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
               "displayName": "Project Roles",
               "title": "Project Roles",
               "name": "ProjectRoles",
               "itemId": "ProjectRolesForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "prjRoleId",
                    "itemId": "prjRoleId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Role Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Role Id<font color='red'> *<\/font>",
                    "fieldId": "A04634CE-E12C-4993-B27F-BB56CBE053A7",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "prjRoleId"
               }, {
                    "name": "roleName",
                    "itemId": "roleName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Role Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Role Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0E66944F-D9B8-46B9-8762-1490436CA8A7",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "roleName",
                    "columnWidth": 0.5
               }, {
                    "name": "issueVisibilityCode",
                    "itemId": "issueVisibilityCode",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Issue Visiblity Code",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.IssueVisibilityModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Issue Visiblity Code<font color='red'> *<\/font>",
                    "fieldId": "C5F4171B-FCA0-4D09-845B-AD0A069C340C",
                    "restURL": "IssueVisibility",
                    "bindable": "issueVisibilityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "canAssignRole",
                    "itemId": "canAssignRole",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "Can Assign Role",
                    "margin": "5 5 5 5",
                    "value": "0",
                    "inputValue": true,
                    "fieldLabel": "Can Assign Role",
                    "fieldId": "205497DC-2F28-420C-8A00-7FF6B224A560",
                    "bindable": "canAssignRole",
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
                    "fieldId": "A203AEF8-6061-499A-A4EC-592D9DE12E42",
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
                    "customId": 519,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 519,
                         "customId": 4
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 519,
                         "customId": 5,
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
                         "parentId": 519,
                         "customId": 6,
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