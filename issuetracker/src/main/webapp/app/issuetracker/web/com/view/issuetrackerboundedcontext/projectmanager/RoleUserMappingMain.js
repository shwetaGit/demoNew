Ext.define('Issuetracker.issuetracker.web.com.view.issuetrackerboundedcontext.projectmanager.RoleUserMappingMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "RoleUserMappingMainController",
     "restURL": "/RoleUserMapping",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.RoleUserMappingModel", "Issuetracker.issuetracker.web.com.controller.issuetrackerboundedcontext.projectmanager.RoleUserMappingMainController", "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectRolesModel", "Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Issuetracker.issuetracker.shared.com.viewmodel.issuetrackerboundedcontext.projectmanager.RoleUserMappingViewModel"],
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
               "displayName": "Role User Mapping",
               "name": "RoleUserMappingTreeContainer",
               "itemId": "RoleUserMappingTreeContainer",
               "restURL": "/RoleUserMapping",
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
                    "itemId": "RoleUserMappingTree",
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
                    "displayName": "Role User Mapping",
                    "title": "Role User Mapping",
                    "name": "RoleUserMapping",
                    "itemId": "RoleUserMappingForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "roleUserId",
                         "itemId": "roleUserId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Role User Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Role User Id<font color='red'> *<\/font>",
                         "fieldId": "0F4980E1-47A1-45C8-9068-E5BF050E7B2D",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "roleUserId"
                    }, {
                         "name": "prjRoleId",
                         "itemId": "prjRoleId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Role",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectRolesModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Role<font color='red'> *<\/font>",
                         "fieldId": "40BBBEBB-DBA0-426E-B82C-51C16AB410D7",
                         "restURL": "ProjectRoles",
                         "bindable": "prjRoleId",
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
                         "allowBlank": false,
                         "fieldLabel": "User<font color='red'> *<\/font>",
                         "fieldId": "42BC99A6-D986-4E1E-A1D2-78E0D4B5A9C2",
                         "restURL": "CoreContacts",
                         "bindable": "contactId",
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
                         "fieldId": "74F06CCC-A7D4-4D8C-9369-EA5CC76EFCEC",
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
                         "customId": 566,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 566,
                              "customId": 478
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 566,
                              "customId": 479,
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
                              "parentId": 566,
                              "customId": 480,
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
                    "displayName": "Role User Mapping",
                    "title": "Details Grid",
                    "name": "RoleUserMappingGrid",
                    "itemId": "RoleUserMappingGrid",
                    "restURL": "/RoleUserMapping",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Role User Id",
                         "dataIndex": "roleUserId",
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
                         "header": "Role",
                         "dataIndex": "prjRoleId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "User",
                         "dataIndex": "contactId",
                         "renderer": "renderFormValue",
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
               "displayName": "Role User Mapping",
               "title": "Role User Mapping",
               "name": "RoleUserMapping",
               "itemId": "RoleUserMappingForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "roleUserId",
                    "itemId": "roleUserId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Role User Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Role User Id<font color='red'> *<\/font>",
                    "fieldId": "0F4980E1-47A1-45C8-9068-E5BF050E7B2D",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "roleUserId"
               }, {
                    "name": "prjRoleId",
                    "itemId": "prjRoleId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Role",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Issuetracker.issuetracker.shared.com.model.issuetrackerboundedcontext.projectmanager.ProjectRolesModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Role<font color='red'> *<\/font>",
                    "fieldId": "40BBBEBB-DBA0-426E-B82C-51C16AB410D7",
                    "restURL": "ProjectRoles",
                    "bindable": "prjRoleId",
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
                    "allowBlank": false,
                    "fieldLabel": "User<font color='red'> *<\/font>",
                    "fieldId": "42BC99A6-D986-4E1E-A1D2-78E0D4B5A9C2",
                    "restURL": "CoreContacts",
                    "bindable": "contactId",
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
                    "fieldId": "74F06CCC-A7D4-4D8C-9369-EA5CC76EFCEC",
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
                    "customId": 566,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 566,
                         "customId": 478
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 566,
                         "customId": 479,
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
                         "parentId": 566,
                         "customId": 480,
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