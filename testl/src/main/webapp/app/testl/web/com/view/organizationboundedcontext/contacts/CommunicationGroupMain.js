Ext.define('Testl.testl.web.com.view.organizationboundedcontext.contacts.CommunicationGroupMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CommunicationGroupMainController",
     "restURL": "/CommunicationGroup",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel", "Testl.testl.web.com.controller.organizationboundedcontext.contacts.CommunicationGroupMainController", "Testl.testl.shared.com.viewmodel.organizationboundedcontext.contacts.CommunicationGroupViewModel"],
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
                         "fieldId": "B81AA88E-E047-4F89-BDDB-DC25BEFCA3A2",
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
                    "viewModel": "CommunicationGroupViewModel",
                    "xtype": "form",
                    "displayName": "Communication Group",
                    "title": "Communication Group",
                    "name": "CommunicationGroup",
                    "itemId": "CommunicationGroup",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "commGroupId",
                         "itemId": "commGroupId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "commType",
                         "margin": "5 5 5 5",
                         "fieldLabel": "commType<font color='red'> *<\/font>",
                         "fieldId": "26817625-137A-49A3-A52D-8B21488D30EF",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "commGroupId",
                         "bind": "{commGroupId}"
                    }, {
                         "name": "commGroupName",
                         "itemId": "commGroupName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Group",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B81AA88E-E047-4F89-BDDB-DC25BEFCA3A2",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication group",
                         "bindable": "commGroupName",
                         "bind": "{commGroupName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "commGroupDescription",
                         "itemId": "commGroupDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Communication Goupr Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Goupr Description",
                         "fieldId": "0B36FC71-79B8-4DC2-8CB4-403409B1B202",
                         "bindable": "commGroupDescription",
                         "bind": "{commGroupDescription}",
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
                         "fieldId": "3912E1BC-CE04-4EB8-8569-BB8D3FFD4F23",
                         "bindable": "versionId",
                         "bind": "{versionId}",
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
                              "customId": 572
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
                              "customId": 573,
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
                              "customId": 574,
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
               "viewModel": "CommunicationGroupViewModel",
               "xtype": "form",
               "displayName": "Communication Group",
               "title": "Communication Group",
               "name": "CommunicationGroup",
               "itemId": "CommunicationGroup",
               "bodyPadding": 10,
               "items": [{
                    "name": "commGroupId",
                    "itemId": "commGroupId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "commType",
                    "margin": "5 5 5 5",
                    "fieldLabel": "commType<font color='red'> *<\/font>",
                    "fieldId": "26817625-137A-49A3-A52D-8B21488D30EF",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "commGroupId",
                    "bind": "{commGroupId}"
               }, {
                    "name": "commGroupName",
                    "itemId": "commGroupName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Communication Group",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B81AA88E-E047-4F89-BDDB-DC25BEFCA3A2",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter communication group",
                    "bindable": "commGroupName",
                    "bind": "{commGroupName}",
                    "columnWidth": 0.5
               }, {
                    "name": "commGroupDescription",
                    "itemId": "commGroupDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Communication Goupr Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Goupr Description",
                    "fieldId": "0B36FC71-79B8-4DC2-8CB4-403409B1B202",
                    "bindable": "commGroupDescription",
                    "bind": "{commGroupDescription}",
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
                    "fieldId": "3912E1BC-CE04-4EB8-8569-BB8D3FFD4F23",
                    "bindable": "versionId",
                    "bind": "{versionId}",
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
                         "customId": 572
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
                         "customId": 573,
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
                         "customId": 574,
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