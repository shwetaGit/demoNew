Ext.define('Project2.project2.web.project2.view.organizationboundedcontext.contacts.CommunicationTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CommunicationTypeMainController",
     "restURL": "/CommunicationType",
     "defaults": {
          "split": true
     },
     "requires": ["Project2.project2.shared.project2.model.organizationboundedcontext.contacts.CommunicationTypeModel", "Project2.project2.web.project2.controller.organizationboundedcontext.contacts.CommunicationTypeMainController", "Project2.project2.shared.project2.model.organizationboundedcontext.contacts.CommunicationGroupModel", "Project2.project2.shared.project2.viewmodel.organizationboundedcontext.contacts.CommunicationTypeViewModel"],
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
               "displayName": "Communication Type",
               "name": "CommunicationTypeTreeContainer",
               "itemId": "CommunicationTypeTreeContainer",
               "restURL": "/CommunicationType",
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
                    "itemId": "CommunicationTypeTree",
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
                         "name": "commTypeName",
                         "itemId": "commTypeName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Type Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Name",
                         "fieldId": "B51173CB-44BF-4B84-9CE3-E4CB552D8DFF",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication type",
                         "bindable": "commTypeName"
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
                    "displayName": "Communication Type",
                    "title": "Communication Type",
                    "name": "CommunicationType",
                    "itemId": "CommunicationTypeForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "commType",
                         "itemId": "commType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "commType",
                         "margin": "5 5 5 5",
                         "fieldLabel": "commType<font color='red'> *<\/font>",
                         "fieldId": "8505F1A6-7F85-4F34-B4ED-FB5EE67BEFE2",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "commType"
                    }, {
                         "name": "commTypeName",
                         "itemId": "commTypeName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Type Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B51173CB-44BF-4B84-9CE3-E4CB552D8DFF",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication type",
                         "bindable": "commTypeName",
                         "columnWidth": 0.5
                    }, {
                         "name": "commTypeDescription",
                         "itemId": "commTypeDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Communication Type Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Description",
                         "fieldId": "3C009C9A-1F34-42BA-8FAF-F2ADF006158D",
                         "bindable": "commTypeDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "commGroupId",
                         "itemId": "commGroupId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Communication Group",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project2.project2.shared.project2.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                         "fieldId": "C4CB546C-5A55-4352-A292-B018EEE9904D",
                         "restURL": "CommunicationGroup",
                         "bindable": "commGroupId",
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
                         "fieldId": "27B2E7AD-FC6A-4C20-A9E0-B92F90CDC6CD",
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
                              "customId": 481
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
                              "customId": 482,
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
                              "customId": 483,
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
                    "displayName": "Communication Type",
                    "title": "Details Grid",
                    "name": "CommunicationTypeGrid",
                    "itemId": "CommunicationTypeGrid",
                    "restURL": "/CommunicationType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "commType",
                         "dataIndex": "commType",
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
                         "header": "Communication Type Name",
                         "dataIndex": "commTypeName",
                         "flex": 1
                    }, {
                         "header": "Communication Type Description",
                         "dataIndex": "commTypeDescription",
                         "flex": 1
                    }, {
                         "header": "Communication Group",
                         "dataIndex": "commGroupId",
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
               "displayName": "Communication Type",
               "title": "Communication Type",
               "name": "CommunicationType",
               "itemId": "CommunicationTypeForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "commType",
                    "itemId": "commType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "commType",
                    "margin": "5 5 5 5",
                    "fieldLabel": "commType<font color='red'> *<\/font>",
                    "fieldId": "8505F1A6-7F85-4F34-B4ED-FB5EE67BEFE2",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "commType"
               }, {
                    "name": "commTypeName",
                    "itemId": "commTypeName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Communication Type Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Type Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B51173CB-44BF-4B84-9CE3-E4CB552D8DFF",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter communication type",
                    "bindable": "commTypeName",
                    "columnWidth": 0.5
               }, {
                    "name": "commTypeDescription",
                    "itemId": "commTypeDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Communication Type Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Type Description",
                    "fieldId": "3C009C9A-1F34-42BA-8FAF-F2ADF006158D",
                    "bindable": "commTypeDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "commGroupId",
                    "itemId": "commGroupId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Communication Group",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project2.project2.shared.project2.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                    "fieldId": "C4CB546C-5A55-4352-A292-B018EEE9904D",
                    "restURL": "CommunicationGroup",
                    "bindable": "commGroupId",
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
                    "fieldId": "27B2E7AD-FC6A-4C20-A9E0-B92F90CDC6CD",
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
                         "customId": 481
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
                         "customId": 482,
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
                         "customId": 483,
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