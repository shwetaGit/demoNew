Ext.define('Testl.testl.web.com.view.organizationboundedcontext.location.TimezoneMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TimezoneMainController",
     "restURL": "/Timezone",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.organizationboundedcontext.location.TimezoneModel", "Testl.testl.web.com.controller.organizationboundedcontext.location.TimezoneMainController", "Testl.testl.shared.com.viewmodel.organizationboundedcontext.location.TimezoneViewModel"],
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
                         "fieldId": "A4D38337-97F5-45C9-A0D3-F7AC8F2C66DB",
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
                         "fieldId": "AFE36523-7377-484E-8377-53158D87CE02",
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
                         "fieldId": "A4D38337-97F5-45C9-A0D3-F7AC8F2C66DB",
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
                         "fieldId": "719668E7-E729-4E7E-9AA0-4151665F91CB",
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
                         "fieldId": "8D8878E3-4EAC-4D9D-B9BD-F030B777C423",
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
                         "fieldId": "F88DD068-8429-42BC-A9A8-886B41584992",
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
                         "fieldId": "38C4ECB1-CAD7-4DF9-8C2B-06880B3988B2",
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
                         "fieldId": "1017CBF0-1F8E-47C3-A418-480A2965F7D3",
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
                         "customId": 488,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 488,
                              "customId": 115
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 488,
                              "customId": 116,
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
                              "parentId": 488,
                              "customId": 117,
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
                    "fieldId": "AFE36523-7377-484E-8377-53158D87CE02",
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
                    "fieldId": "A4D38337-97F5-45C9-A0D3-F7AC8F2C66DB",
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
                    "fieldId": "719668E7-E729-4E7E-9AA0-4151665F91CB",
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
                    "fieldId": "8D8878E3-4EAC-4D9D-B9BD-F030B777C423",
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
                    "fieldId": "F88DD068-8429-42BC-A9A8-886B41584992",
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
                    "fieldId": "38C4ECB1-CAD7-4DF9-8C2B-06880B3988B2",
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
                    "fieldId": "1017CBF0-1F8E-47C3-A418-480A2965F7D3",
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
                    "customId": 488,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 488,
                         "customId": 115
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 488,
                         "customId": 116,
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
                         "parentId": 488,
                         "customId": 117,
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