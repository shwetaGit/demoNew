Ext.define('Testl.testl.web.com.view.humanresourcecontext.employee.VisaMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "VisaMainController",
     "restURL": "/Visa",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.employee.VisaModel", "Testl.testl.web.com.controller.humanresourcecontext.employee.VisaMainController", "Testl.testl.shared.com.viewmodel.humanresourcecontext.employee.VisaViewModel"],
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
               "displayName": "Visa",
               "name": "VisaTreeContainer",
               "itemId": "VisaTreeContainer",
               "restURL": "/Visa",
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
                    "itemId": "VisaTree",
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
                         "name": "visaDesc",
                         "itemId": "visaDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Visa Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Visa Type",
                         "fieldId": "7A6FC155-2B3C-4BD0-AE65-C9C7DB85E16C",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "visaDesc"
                    }, {
                         "name": "visaHelp",
                         "itemId": "visaHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Visa Type Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Visa Type Details",
                         "fieldId": "1D77617D-86F0-49E2-BEA0-466C287D679B",
                         "bindable": "visaHelp"
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
                    "viewModel": "VisaViewModel",
                    "xtype": "form",
                    "displayName": "Visa",
                    "title": "Visa",
                    "name": "Visa",
                    "itemId": "Visa",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "visaCode",
                         "itemId": "visaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "visaCode",
                         "margin": "5 5 5 5",
                         "fieldLabel": "visaCode<font color='red'> *<\/font>",
                         "fieldId": "A59E6B25-2EF3-4233-9355-2622FC8B7AD0",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "visaCode",
                         "bind": "{visaCode}"
                    }, {
                         "name": "visaDesc",
                         "itemId": "visaDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Visa Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Visa Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7A6FC155-2B3C-4BD0-AE65-C9C7DB85E16C",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "visaDesc",
                         "bind": "{visaDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "visaHelp",
                         "itemId": "visaHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Visa Type Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Visa Type Details<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "1D77617D-86F0-49E2-BEA0-466C287D679B",
                         "bindable": "visaHelp",
                         "bind": "{visaHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "visaIcon",
                         "itemId": "visaIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "visaIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "visaIcon",
                         "fieldId": "BB03236E-4CB8-4DF8-8BA9-8B3853F07356",
                         "minLength": "0",
                         "bindable": "visaIcon",
                         "bind": "{visaIcon}",
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
                         "fieldId": "9DA5CEEA-C377-40BB-925B-5D39303E721F",
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
                         "customId": 999,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 999,
                              "customId": 733
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 999,
                              "customId": 734,
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
                              "parentId": 999,
                              "customId": 735,
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
                    "displayName": "Visa",
                    "title": "Details Grid",
                    "name": "VisaGrid",
                    "itemId": "VisaGrid",
                    "restURL": "/Visa",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "visaCode",
                         "dataIndex": "visaCode",
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
                         "header": "Visa Type",
                         "dataIndex": "visaDesc",
                         "flex": 1
                    }, {
                         "header": "Visa Type Details",
                         "dataIndex": "visaHelp",
                         "flex": 1
                    }, {
                         "header": "visaIcon",
                         "dataIndex": "visaIcon",
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
               "viewModel": "VisaViewModel",
               "xtype": "form",
               "displayName": "Visa",
               "title": "Visa",
               "name": "Visa",
               "itemId": "Visa",
               "bodyPadding": 10,
               "items": [{
                    "name": "visaCode",
                    "itemId": "visaCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "visaCode",
                    "margin": "5 5 5 5",
                    "fieldLabel": "visaCode<font color='red'> *<\/font>",
                    "fieldId": "A59E6B25-2EF3-4233-9355-2622FC8B7AD0",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "visaCode",
                    "bind": "{visaCode}"
               }, {
                    "name": "visaDesc",
                    "itemId": "visaDesc",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Visa Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Visa Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7A6FC155-2B3C-4BD0-AE65-C9C7DB85E16C",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "visaDesc",
                    "bind": "{visaDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "visaHelp",
                    "itemId": "visaHelp",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Visa Type Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Visa Type Details<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "1D77617D-86F0-49E2-BEA0-466C287D679B",
                    "bindable": "visaHelp",
                    "bind": "{visaHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "visaIcon",
                    "itemId": "visaIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "visaIcon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "visaIcon",
                    "fieldId": "BB03236E-4CB8-4DF8-8BA9-8B3853F07356",
                    "minLength": "0",
                    "bindable": "visaIcon",
                    "bind": "{visaIcon}",
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
                    "fieldId": "9DA5CEEA-C377-40BB-925B-5D39303E721F",
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
                    "customId": 999,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 999,
                         "customId": 733
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 999,
                         "customId": 734,
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
                         "parentId": 999,
                         "customId": 735,
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