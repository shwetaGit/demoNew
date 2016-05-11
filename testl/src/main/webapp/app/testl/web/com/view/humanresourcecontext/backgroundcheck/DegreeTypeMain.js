Ext.define('Testl.testl.web.com.view.humanresourcecontext.backgroundcheck.DegreeTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "DegreeTypeMainController",
     "restURL": "/DegreeType",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.DegreeTypeModel", "Testl.testl.web.com.controller.humanresourcecontext.backgroundcheck.DegreeTypeMainController", "Testl.testl.shared.com.viewmodel.humanresourcecontext.backgroundcheck.DegreeTypeViewModel"],
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
               "displayName": "Degree Type",
               "name": "DegreeTypeTreeContainer",
               "itemId": "DegreeTypeTreeContainer",
               "restURL": "/DegreeType",
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
                    "itemId": "DegreeTypeTree",
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
                         "name": "degreeDesc",
                         "itemId": "degreeDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Degree",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Degree",
                         "fieldId": "706ACB22-167D-468E-BB1F-16EF5DF4A320",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "degreeDesc"
                    }, {
                         "name": "degreeHelp",
                         "itemId": "degreeHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Degree Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Degree Details",
                         "fieldId": "8BB967FB-8B36-4E26-B848-7760F2FD086F",
                         "bindable": "degreeHelp"
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
                    "viewModel": "DegreeTypeViewModel",
                    "xtype": "form",
                    "displayName": "Degree Type",
                    "title": "Degree Type",
                    "name": "DegreeType",
                    "itemId": "DegreeType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "degreeCode",
                         "itemId": "degreeCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "degreeCode",
                         "margin": "5 5 5 5",
                         "fieldLabel": "degreeCode<font color='red'> *<\/font>",
                         "fieldId": "735485C4-FAE4-4CBD-9E59-00B5FE46F4A8",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "degreeCode",
                         "bind": "{degreeCode}"
                    }, {
                         "name": "degreeDesc",
                         "itemId": "degreeDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Degree",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Degree<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "706ACB22-167D-468E-BB1F-16EF5DF4A320",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "degreeDesc",
                         "bind": "{degreeDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "degreeHelp",
                         "itemId": "degreeHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Degree Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Degree Details<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8BB967FB-8B36-4E26-B848-7760F2FD086F",
                         "bindable": "degreeHelp",
                         "bind": "{degreeHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "degreeIcon",
                         "itemId": "degreeIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "degreeIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "degreeIcon",
                         "fieldId": "4698DE6C-0A91-46A7-9F45-96CE0619221B",
                         "minLength": "0",
                         "bindable": "degreeIcon",
                         "bind": "{degreeIcon}",
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
                         "fieldId": "4CBE510A-1502-40B4-9950-684EDE2F203D",
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
                         "customId": 893,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 893,
                              "customId": 673
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 893,
                              "customId": 674,
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
                              "parentId": 893,
                              "customId": 675,
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
                    "displayName": "Degree Type",
                    "title": "Details Grid",
                    "name": "DegreeTypeGrid",
                    "itemId": "DegreeTypeGrid",
                    "restURL": "/DegreeType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "degreeCode",
                         "dataIndex": "degreeCode",
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
                         "header": "Degree",
                         "dataIndex": "degreeDesc",
                         "flex": 1
                    }, {
                         "header": "Degree Details",
                         "dataIndex": "degreeHelp",
                         "flex": 1
                    }, {
                         "header": "degreeIcon",
                         "dataIndex": "degreeIcon",
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
               "viewModel": "DegreeTypeViewModel",
               "xtype": "form",
               "displayName": "Degree Type",
               "title": "Degree Type",
               "name": "DegreeType",
               "itemId": "DegreeType",
               "bodyPadding": 10,
               "items": [{
                    "name": "degreeCode",
                    "itemId": "degreeCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "degreeCode",
                    "margin": "5 5 5 5",
                    "fieldLabel": "degreeCode<font color='red'> *<\/font>",
                    "fieldId": "735485C4-FAE4-4CBD-9E59-00B5FE46F4A8",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "degreeCode",
                    "bind": "{degreeCode}"
               }, {
                    "name": "degreeDesc",
                    "itemId": "degreeDesc",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Degree",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Degree<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "706ACB22-167D-468E-BB1F-16EF5DF4A320",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "degreeDesc",
                    "bind": "{degreeDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "degreeHelp",
                    "itemId": "degreeHelp",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Degree Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Degree Details<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8BB967FB-8B36-4E26-B848-7760F2FD086F",
                    "bindable": "degreeHelp",
                    "bind": "{degreeHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "degreeIcon",
                    "itemId": "degreeIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "degreeIcon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "degreeIcon",
                    "fieldId": "4698DE6C-0A91-46A7-9F45-96CE0619221B",
                    "minLength": "0",
                    "bindable": "degreeIcon",
                    "bind": "{degreeIcon}",
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
                    "fieldId": "4CBE510A-1502-40B4-9950-684EDE2F203D",
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
                    "customId": 893,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 893,
                         "customId": 673
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 893,
                         "customId": 674,
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
                         "parentId": 893,
                         "customId": 675,
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