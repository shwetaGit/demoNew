Ext.define('Testl.testl.web.com.view.humanresourcecontext.employee.DesignationTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "DesignationTypeMainController",
     "restURL": "/DesignationType",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.employee.DesignationTypeModel", "Testl.testl.web.com.controller.humanresourcecontext.employee.DesignationTypeMainController", "Testl.testl.shared.com.viewmodel.humanresourcecontext.employee.DesignationTypeViewModel"],
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
               "displayName": "Designation Type",
               "name": "DesignationTypeTreeContainer",
               "itemId": "DesignationTypeTreeContainer",
               "restURL": "/DesignationType",
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
                    "itemId": "DesignationTypeTree",
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
                         "name": "designatnTypeDesc",
                         "itemId": "designatnTypeDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Designation",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Designation",
                         "fieldId": "F56D91F6-621F-482A-B361-98E9FA0AC8B6",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "designatnTypeDesc"
                    }, {
                         "name": "designatnTypeHelp",
                         "itemId": "designatnTypeHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Designatn Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Designatn Details",
                         "fieldId": "FCEB6F82-9828-4C1E-8897-4501EB0226E6",
                         "bindable": "designatnTypeHelp"
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
                    "viewModel": "DesignationTypeViewModel",
                    "xtype": "form",
                    "displayName": "Designation Type",
                    "title": "Designation Type",
                    "name": "DesignationType",
                    "itemId": "DesignationType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "designatnTypeCode",
                         "itemId": "designatnTypeCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "designatnTypeCode",
                         "margin": "5 5 5 5",
                         "fieldLabel": "designatnTypeCode<font color='red'> *<\/font>",
                         "fieldId": "BCA0C39C-84FD-4812-ACDC-CD7FEFA99EB1",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "designatnTypeCode",
                         "bind": "{designatnTypeCode}"
                    }, {
                         "name": "designatnTypeDesc",
                         "itemId": "designatnTypeDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Designation",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Designation<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F56D91F6-621F-482A-B361-98E9FA0AC8B6",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "designatnTypeDesc",
                         "bind": "{designatnTypeDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "designatnTypeHelp",
                         "itemId": "designatnTypeHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Designatn Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Designatn Details<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FCEB6F82-9828-4C1E-8897-4501EB0226E6",
                         "bindable": "designatnTypeHelp",
                         "bind": "{designatnTypeHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "designatnTypeIcon",
                         "itemId": "designatnTypeIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "designatnTypeIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "designatnTypeIcon",
                         "fieldId": "ED46EF49-3E9F-4C2E-9E73-15B992D93329",
                         "minLength": "0",
                         "bindable": "designatnTypeIcon",
                         "bind": "{designatnTypeIcon}",
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
                         "fieldId": "64A7BB2E-BC1B-47DA-B60F-C2F1FC49C3D2",
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
                         "customId": 465,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 465,
                              "customId": 658
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 465,
                              "customId": 659,
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
                              "parentId": 465,
                              "customId": 660,
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
                    "displayName": "Designation Type",
                    "title": "Details Grid",
                    "name": "DesignationTypeGrid",
                    "itemId": "DesignationTypeGrid",
                    "restURL": "/DesignationType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "designatnTypeCode",
                         "dataIndex": "designatnTypeCode",
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
                         "header": "Designation",
                         "dataIndex": "designatnTypeDesc",
                         "flex": 1
                    }, {
                         "header": "Designatn Details",
                         "dataIndex": "designatnTypeHelp",
                         "flex": 1
                    }, {
                         "header": "designatnTypeIcon",
                         "dataIndex": "designatnTypeIcon",
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
               "viewModel": "DesignationTypeViewModel",
               "xtype": "form",
               "displayName": "Designation Type",
               "title": "Designation Type",
               "name": "DesignationType",
               "itemId": "DesignationType",
               "bodyPadding": 10,
               "items": [{
                    "name": "designatnTypeCode",
                    "itemId": "designatnTypeCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "designatnTypeCode",
                    "margin": "5 5 5 5",
                    "fieldLabel": "designatnTypeCode<font color='red'> *<\/font>",
                    "fieldId": "BCA0C39C-84FD-4812-ACDC-CD7FEFA99EB1",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "designatnTypeCode",
                    "bind": "{designatnTypeCode}"
               }, {
                    "name": "designatnTypeDesc",
                    "itemId": "designatnTypeDesc",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Designation",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Designation<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F56D91F6-621F-482A-B361-98E9FA0AC8B6",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "designatnTypeDesc",
                    "bind": "{designatnTypeDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "designatnTypeHelp",
                    "itemId": "designatnTypeHelp",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Designatn Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Designatn Details<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FCEB6F82-9828-4C1E-8897-4501EB0226E6",
                    "bindable": "designatnTypeHelp",
                    "bind": "{designatnTypeHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "designatnTypeIcon",
                    "itemId": "designatnTypeIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "designatnTypeIcon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "designatnTypeIcon",
                    "fieldId": "ED46EF49-3E9F-4C2E-9E73-15B992D93329",
                    "minLength": "0",
                    "bindable": "designatnTypeIcon",
                    "bind": "{designatnTypeIcon}",
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
                    "fieldId": "64A7BB2E-BC1B-47DA-B60F-C2F1FC49C3D2",
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
                    "customId": 465,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 465,
                         "customId": 658
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 465,
                         "customId": 659,
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
                         "parentId": 465,
                         "customId": 660,
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