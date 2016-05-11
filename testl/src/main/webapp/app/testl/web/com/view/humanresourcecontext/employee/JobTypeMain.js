Ext.define('Testl.testl.web.com.view.humanresourcecontext.employee.JobTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "JobTypeMainController",
     "restURL": "/JobType",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.employee.JobTypeModel", "Testl.testl.web.com.controller.humanresourcecontext.employee.JobTypeMainController", "Testl.testl.shared.com.viewmodel.humanresourcecontext.employee.JobTypeViewModel"],
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
               "displayName": "Job Type",
               "name": "JobTypeTreeContainer",
               "itemId": "JobTypeTreeContainer",
               "restURL": "/JobType",
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
                    "itemId": "JobTypeTree",
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
                         "name": "jobDesc",
                         "itemId": "jobDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Job Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Job Type",
                         "fieldId": "2AFF4574-BBA4-4B5E-9B3C-07FC6BF51136",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "jobDesc"
                    }, {
                         "name": "jobHelp",
                         "itemId": "jobHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Job Type Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Job Type Details",
                         "fieldId": "2441043E-9776-4457-AB08-CBB1703D67CD",
                         "bindable": "jobHelp"
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
                    "viewModel": "JobTypeViewModel",
                    "xtype": "form",
                    "displayName": "Job Type",
                    "title": "Job Type",
                    "name": "JobType",
                    "itemId": "JobType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "jobCode",
                         "itemId": "jobCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "jobCode",
                         "margin": "5 5 5 5",
                         "fieldLabel": "jobCode<font color='red'> *<\/font>",
                         "fieldId": "EB7560BC-142B-4701-BED2-5E119DB40356",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "jobCode",
                         "bind": "{jobCode}"
                    }, {
                         "name": "jobDesc",
                         "itemId": "jobDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Job Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Job Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2AFF4574-BBA4-4B5E-9B3C-07FC6BF51136",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "jobDesc",
                         "bind": "{jobDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "jobHelp",
                         "itemId": "jobHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Job Type Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Job Type Details<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2441043E-9776-4457-AB08-CBB1703D67CD",
                         "bindable": "jobHelp",
                         "bind": "{jobHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "jobIcon",
                         "itemId": "jobIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "jobIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "jobIcon",
                         "fieldId": "8891B1C3-F4DB-4C7C-9B24-A43C3513CE2B",
                         "minLength": "0",
                         "bindable": "jobIcon",
                         "bind": "{jobIcon}",
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
                         "fieldId": "3DF0C57C-1620-4078-81A9-438C3443E4EB",
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
                         "customId": 335,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 335,
                              "customId": 5
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 335,
                              "customId": 6,
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
                              "parentId": 335,
                              "customId": 7,
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
                    "displayName": "Job Type",
                    "title": "Details Grid",
                    "name": "JobTypeGrid",
                    "itemId": "JobTypeGrid",
                    "restURL": "/JobType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "jobCode",
                         "dataIndex": "jobCode",
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
                         "header": "Job Type",
                         "dataIndex": "jobDesc",
                         "flex": 1
                    }, {
                         "header": "Job Type Details",
                         "dataIndex": "jobHelp",
                         "flex": 1
                    }, {
                         "header": "jobIcon",
                         "dataIndex": "jobIcon",
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
               "viewModel": "JobTypeViewModel",
               "xtype": "form",
               "displayName": "Job Type",
               "title": "Job Type",
               "name": "JobType",
               "itemId": "JobType",
               "bodyPadding": 10,
               "items": [{
                    "name": "jobCode",
                    "itemId": "jobCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "jobCode",
                    "margin": "5 5 5 5",
                    "fieldLabel": "jobCode<font color='red'> *<\/font>",
                    "fieldId": "EB7560BC-142B-4701-BED2-5E119DB40356",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "jobCode",
                    "bind": "{jobCode}"
               }, {
                    "name": "jobDesc",
                    "itemId": "jobDesc",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Job Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Job Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2AFF4574-BBA4-4B5E-9B3C-07FC6BF51136",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "jobDesc",
                    "bind": "{jobDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "jobHelp",
                    "itemId": "jobHelp",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Job Type Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Job Type Details<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2441043E-9776-4457-AB08-CBB1703D67CD",
                    "bindable": "jobHelp",
                    "bind": "{jobHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "jobIcon",
                    "itemId": "jobIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "jobIcon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "jobIcon",
                    "fieldId": "8891B1C3-F4DB-4C7C-9B24-A43C3513CE2B",
                    "minLength": "0",
                    "bindable": "jobIcon",
                    "bind": "{jobIcon}",
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
                    "fieldId": "3DF0C57C-1620-4078-81A9-438C3443E4EB",
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
                    "customId": 335,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 335,
                         "customId": 5
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 335,
                         "customId": 6,
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
                         "parentId": 335,
                         "customId": 7,
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