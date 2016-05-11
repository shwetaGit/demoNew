Ext.define('Issuetracker.issuetracker.web.com.view.organizationboundedcontext.contacts.CommunicationGroupMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CommunicationGroupMainController",
     "restURL": "/CommunicationGroup",
     "defaults": {
          "split": true
     },
     "requires": ["Issuetracker.issuetracker.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel", "Issuetracker.issuetracker.web.com.controller.organizationboundedcontext.contacts.CommunicationGroupMainController", "Issuetracker.issuetracker.shared.com.viewmodel.organizationboundedcontext.contacts.CommunicationGroupViewModel"],
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
               "displayName": "Communication Group",
               "name": "CommunicationGroupTreeContainer",
               "itemId": "CommunicationGroupTreeContainer",
               "restURL": "/CommunicationGroup",
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
                    "itemId": "CommunicationGroupTree",
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
                         "name": "commGroupName",
                         "itemId": "commGroupName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Group",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Group",
                         "fieldId": "A5401206-D169-4F88-9394-F6EDB3A008FF",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication group",
                         "bindable": "commGroupName"
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
                    "displayName": "Communication Group",
                    "title": "Communication Group",
                    "name": "CommunicationGroup",
                    "itemId": "CommunicationGroupForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "commGroupId",
                         "itemId": "commGroupId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "commType",
                         "margin": "5 5 5 5",
                         "fieldLabel": "commType<font color='red'> *<\/font>",
                         "fieldId": "A35E04CA-8338-4C77-AC5D-8FD7AADEF50A",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "commGroupId"
                    }, {
                         "name": "commGroupName",
                         "itemId": "commGroupName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Group",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A5401206-D169-4F88-9394-F6EDB3A008FF",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication group",
                         "bindable": "commGroupName",
                         "columnWidth": 0.5
                    }, {
                         "name": "commGroupDescription",
                         "itemId": "commGroupDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Communication Goupr Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Goupr Description",
                         "fieldId": "38CFB813-6BC7-45B1-A73F-F6885DD9DDBD",
                         "bindable": "commGroupDescription",
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
                         "fieldId": "11AF1B5E-8837-4737-83AD-7E00F0C4A27D",
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
                         "customId": 57,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 57,
                              "customId": 902
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 57,
                              "customId": 903,
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
                              "parentId": 57,
                              "customId": 904,
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
                    "displayName": "Communication Group",
                    "title": "Details Grid",
                    "name": "CommunicationGroupGrid",
                    "itemId": "CommunicationGroupGrid",
                    "restURL": "/CommunicationGroup",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "commType",
                         "dataIndex": "commGroupId",
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
                         "header": "Communication Group",
                         "dataIndex": "commGroupName",
                         "flex": 1
                    }, {
                         "header": "Communication Goupr Description",
                         "dataIndex": "commGroupDescription",
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
               "displayName": "Communication Group",
               "title": "Communication Group",
               "name": "CommunicationGroup",
               "itemId": "CommunicationGroupForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "commGroupId",
                    "itemId": "commGroupId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "commType",
                    "margin": "5 5 5 5",
                    "fieldLabel": "commType<font color='red'> *<\/font>",
                    "fieldId": "A35E04CA-8338-4C77-AC5D-8FD7AADEF50A",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "commGroupId"
               }, {
                    "name": "commGroupName",
                    "itemId": "commGroupName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Communication Group",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A5401206-D169-4F88-9394-F6EDB3A008FF",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter communication group",
                    "bindable": "commGroupName",
                    "columnWidth": 0.5
               }, {
                    "name": "commGroupDescription",
                    "itemId": "commGroupDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Communication Goupr Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Goupr Description",
                    "fieldId": "38CFB813-6BC7-45B1-A73F-F6885DD9DDBD",
                    "bindable": "commGroupDescription",
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
                    "fieldId": "11AF1B5E-8837-4737-83AD-7E00F0C4A27D",
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
                    "customId": 57,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 57,
                         "customId": 902
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 57,
                         "customId": 903,
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
                         "parentId": 57,
                         "customId": 904,
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