Ext.define('Testpro.testpro.web.com.view.organizationboundedcontext.location.TimezoneMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TimezoneMainController",
     "restURL": "/Timezone",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro.testpro.shared.com.model.organizationboundedcontext.location.TimezoneModel", "Testpro.testpro.web.com.controller.organizationboundedcontext.location.TimezoneMainController", "Testpro.testpro.shared.com.viewmodel.organizationboundedcontext.location.TimezoneViewModel"],
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
               "displayName": "Timezone",
               "name": "TimezoneTreeContainer",
               "itemId": "TimezoneTreeContainer",
               "restURL": "/Timezone",
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
                    "itemId": "TimezoneTree",
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
                         "name": "utcdifference",
                         "itemId": "utcdifference",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "UTC Difference",
                         "margin": "5 5 5 5",
                         "fieldLabel": "UTC Difference",
                         "fieldId": "9B3AEDDD-53A3-431C-85E6-5797F1F35FB5",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "utcdifference"
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
                    "viewModel": "TimezoneViewModel",
                    "xtype": "form",
                    "displayName": "Timezone",
                    "title": "Timezone",
                    "name": "Timezone",
                    "itemId": "Timezone",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "timeZoneId",
                         "itemId": "timeZoneId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Time Zone Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Time Zone Id<font color='red'> *<\/font>",
                         "fieldId": "8258AC2B-4458-4418-BE97-9FEA20E3FA96",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "timeZoneId",
                         "bind": "{timeZoneId}"
                    }, {
                         "name": "utcdifference",
                         "itemId": "utcdifference",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "UTC Difference",
                         "margin": "5 5 5 5",
                         "fieldLabel": "UTC Difference<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9B3AEDDD-53A3-431C-85E6-5797F1F35FB5",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "utcdifference",
                         "bind": "{utcdifference}",
                         "columnWidth": 0.5
                    }, {
                         "name": "gmtLabel",
                         "itemId": "gmtLabel",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "GMT",
                         "margin": "5 5 5 5",
                         "fieldLabel": "GMT",
                         "fieldId": "7F76BA97-2C9A-4B7E-B9B3-C536FAEFA759",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "gmtLabel",
                         "bind": "{gmtLabel}",
                         "columnWidth": 0.5
                    }, {
                         "name": "timeZoneLabel",
                         "itemId": "timeZoneLabel",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Time Zone",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Time Zone",
                         "fieldId": "512F9428-DA25-4AFB-A117-115E17ADC7F4",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "timeZoneLabel",
                         "bind": "{timeZoneLabel}",
                         "columnWidth": 0.5
                    }, {
                         "name": "country",
                         "itemId": "country",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "06697E6C-7CD4-4E9A-9923-B37FE214AD56",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "country",
                         "bind": "{country}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cities",
                         "itemId": "cities",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City",
                         "fieldId": "DA8DC08E-2293-49C6-A487-B5BE9C8E1474",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "cities",
                         "bind": "{cities}",
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
                         "fieldId": "D4373A14-8DDB-45BA-8E02-E968C9C6C355",
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
                         "customId": 526,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 526,
                              "customId": 403
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 526,
                              "customId": 404,
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
                              "parentId": 526,
                              "customId": 405,
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
                    "displayName": "Timezone",
                    "title": "Details Grid",
                    "name": "TimezoneGrid",
                    "itemId": "TimezoneGrid",
                    "restURL": "/Timezone",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Time Zone Id",
                         "dataIndex": "timeZoneId",
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
                         "header": "UTC Difference",
                         "dataIndex": "utcdifference",
                         "flex": 1
                    }, {
                         "header": "GMT",
                         "dataIndex": "gmtLabel",
                         "flex": 1
                    }, {
                         "header": "Time Zone",
                         "dataIndex": "timeZoneLabel",
                         "flex": 1
                    }, {
                         "header": "Country",
                         "dataIndex": "country",
                         "flex": 1
                    }, {
                         "header": "City",
                         "dataIndex": "cities",
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
               "viewModel": "TimezoneViewModel",
               "xtype": "form",
               "displayName": "Timezone",
               "title": "Timezone",
               "name": "Timezone",
               "itemId": "Timezone",
               "bodyPadding": 10,
               "items": [{
                    "name": "timeZoneId",
                    "itemId": "timeZoneId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Time Zone Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Time Zone Id<font color='red'> *<\/font>",
                    "fieldId": "8258AC2B-4458-4418-BE97-9FEA20E3FA96",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "timeZoneId",
                    "bind": "{timeZoneId}"
               }, {
                    "name": "utcdifference",
                    "itemId": "utcdifference",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "UTC Difference",
                    "margin": "5 5 5 5",
                    "fieldLabel": "UTC Difference<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9B3AEDDD-53A3-431C-85E6-5797F1F35FB5",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "utcdifference",
                    "bind": "{utcdifference}",
                    "columnWidth": 0.5
               }, {
                    "name": "gmtLabel",
                    "itemId": "gmtLabel",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "GMT",
                    "margin": "5 5 5 5",
                    "fieldLabel": "GMT",
                    "fieldId": "7F76BA97-2C9A-4B7E-B9B3-C536FAEFA759",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "gmtLabel",
                    "bind": "{gmtLabel}",
                    "columnWidth": 0.5
               }, {
                    "name": "timeZoneLabel",
                    "itemId": "timeZoneLabel",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Time Zone",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Time Zone",
                    "fieldId": "512F9428-DA25-4AFB-A117-115E17ADC7F4",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "timeZoneLabel",
                    "bind": "{timeZoneLabel}",
                    "columnWidth": 0.5
               }, {
                    "name": "country",
                    "itemId": "country",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country",
                    "fieldId": "06697E6C-7CD4-4E9A-9923-B37FE214AD56",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "country",
                    "bind": "{country}",
                    "columnWidth": 0.5
               }, {
                    "name": "cities",
                    "itemId": "cities",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City",
                    "fieldId": "DA8DC08E-2293-49C6-A487-B5BE9C8E1474",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "cities",
                    "bind": "{cities}",
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
                    "fieldId": "D4373A14-8DDB-45BA-8E02-E968C9C6C355",
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
                    "customId": 526,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 526,
                         "customId": 403
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 526,
                         "customId": 404,
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
                         "parentId": 526,
                         "customId": 405,
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