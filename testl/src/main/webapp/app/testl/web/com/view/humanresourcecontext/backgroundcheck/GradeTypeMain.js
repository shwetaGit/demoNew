Ext.define('Testl.testl.web.com.view.humanresourcecontext.backgroundcheck.GradeTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "GradeTypeMainController",
     "restURL": "/GradeType",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.GradeTypeModel", "Testl.testl.web.com.controller.humanresourcecontext.backgroundcheck.GradeTypeMainController", "Testl.testl.shared.com.viewmodel.humanresourcecontext.backgroundcheck.GradeTypeViewModel"],
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
               "displayName": "Grade Type",
               "name": "GradeTypeTreeContainer",
               "itemId": "GradeTypeTreeContainer",
               "restURL": "/GradeType",
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
                    "itemId": "GradeTypeTree",
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
                         "name": "grdDesc",
                         "itemId": "grdDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Grade",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Grade",
                         "fieldId": "40257AC4-1B8B-4D21-AF0E-AC80B2AAA331",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "grdDesc"
                    }, {
                         "name": "grdHelp",
                         "itemId": "grdHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Grade Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Grade Details",
                         "fieldId": "BA3E0256-F8C1-4589-AAFB-54ECBEDF3390",
                         "bindable": "grdHelp"
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
                    "viewModel": "GradeTypeViewModel",
                    "xtype": "form",
                    "displayName": "Grade Type",
                    "title": "Grade Type",
                    "name": "GradeType",
                    "itemId": "GradeType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "grdCode",
                         "itemId": "grdCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "grdCode",
                         "margin": "5 5 5 5",
                         "fieldLabel": "grdCode<font color='red'> *<\/font>",
                         "fieldId": "18BFFD82-377F-4C2B-A06B-8492076C356A",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "grdCode",
                         "bind": "{grdCode}"
                    }, {
                         "name": "grdDesc",
                         "itemId": "grdDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Grade",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Grade<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "40257AC4-1B8B-4D21-AF0E-AC80B2AAA331",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "grdDesc",
                         "bind": "{grdDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "grdHelp",
                         "itemId": "grdHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Grade Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Grade Details<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BA3E0256-F8C1-4589-AAFB-54ECBEDF3390",
                         "bindable": "grdHelp",
                         "bind": "{grdHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "grdIcon",
                         "itemId": "grdIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "grdIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "grdIcon",
                         "fieldId": "0CDF0542-237B-4D3E-8B17-7E0C54EB7BF7",
                         "minLength": "0",
                         "bindable": "grdIcon",
                         "bind": "{grdIcon}",
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
                         "fieldId": "472CB772-13EF-4D10-A7CB-893A0AE42788",
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
                         "customId": 693,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 693,
                              "customId": 389
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 693,
                              "customId": 390,
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
                              "parentId": 693,
                              "customId": 391,
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
                    "displayName": "Grade Type",
                    "title": "Details Grid",
                    "name": "GradeTypeGrid",
                    "itemId": "GradeTypeGrid",
                    "restURL": "/GradeType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "grdCode",
                         "dataIndex": "grdCode",
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
                         "header": "Grade",
                         "dataIndex": "grdDesc",
                         "flex": 1
                    }, {
                         "header": "Grade Details",
                         "dataIndex": "grdHelp",
                         "flex": 1
                    }, {
                         "header": "grdIcon",
                         "dataIndex": "grdIcon",
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
               "viewModel": "GradeTypeViewModel",
               "xtype": "form",
               "displayName": "Grade Type",
               "title": "Grade Type",
               "name": "GradeType",
               "itemId": "GradeType",
               "bodyPadding": 10,
               "items": [{
                    "name": "grdCode",
                    "itemId": "grdCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "grdCode",
                    "margin": "5 5 5 5",
                    "fieldLabel": "grdCode<font color='red'> *<\/font>",
                    "fieldId": "18BFFD82-377F-4C2B-A06B-8492076C356A",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "grdCode",
                    "bind": "{grdCode}"
               }, {
                    "name": "grdDesc",
                    "itemId": "grdDesc",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Grade",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Grade<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "40257AC4-1B8B-4D21-AF0E-AC80B2AAA331",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "grdDesc",
                    "bind": "{grdDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "grdHelp",
                    "itemId": "grdHelp",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Grade Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Grade Details<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BA3E0256-F8C1-4589-AAFB-54ECBEDF3390",
                    "bindable": "grdHelp",
                    "bind": "{grdHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "grdIcon",
                    "itemId": "grdIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "grdIcon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "grdIcon",
                    "fieldId": "0CDF0542-237B-4D3E-8B17-7E0C54EB7BF7",
                    "minLength": "0",
                    "bindable": "grdIcon",
                    "bind": "{grdIcon}",
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
                    "fieldId": "472CB772-13EF-4D10-A7CB-893A0AE42788",
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
                    "customId": 693,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 693,
                         "customId": 389
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 693,
                         "customId": 390,
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
                         "parentId": 693,
                         "customId": 391,
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