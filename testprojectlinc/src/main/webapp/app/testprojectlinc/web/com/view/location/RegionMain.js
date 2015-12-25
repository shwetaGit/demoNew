Ext.define('Testprojectlinc.testprojectlinc.web.com.view.location.RegionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "RegionMainController",
     "restURL": "/Region",
     "defaults": {
          "split": true
     },
     "requires": ["Testprojectlinc.testprojectlinc.shared.com.model.location.RegionModel", "Testprojectlinc.testprojectlinc.web.com.controller.location.RegionMainController", "Testprojectlinc.testprojectlinc.shared.com.model.location.CountryModel", "Testprojectlinc.testprojectlinc.shared.com.model.location.StateModel", "Testprojectlinc.testprojectlinc.shared.com.viewmodel.location.RegionViewModel"],
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
               "displayName": "Region",
               "name": "RegionTreeContainer",
               "itemId": "RegionTreeContainer",
               "restURL": "/Region",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "RegionTree",
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
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "5FB765FA-2C32-43A4-9188-23C4C69F9DAE",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprojectlinc.testprojectlinc.shared.com.model.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "31920251-7EA8-47B0-8FAF-78B7A6B33F8F",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprojectlinc.testprojectlinc.shared.com.model.location.StateModel"
                         }
                    }, {
                         "name": "regionName",
                         "itemId": "regionName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Name",
                         "fieldId": "CE6C6F7F-AD09-4853-A375-DAEE88312FD3",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "regionCode1",
                         "itemId": "regionCode1",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 1",
                         "fieldId": "68C8B1B5-AE03-45C3-878E-327DCF33F9B3",
                         "minValue": "0",
                         "maxValue": "3"
                    }, {
                         "name": "regionCodeChar2",
                         "itemId": "regionCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 2",
                         "fieldId": "6DBDEDF6-76A7-42A3-A9A1-5E5132AD14F8",
                         "minLength": "0",
                         "maxLength": "32"
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
                    "viewModel": "RegionViewModel",
                    "xtype": "form",
                    "displayName": "Region",
                    "title": "Region",
                    "name": "Region",
                    "itemId": "Region",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Id<font color='red'> *<\/font>",
                         "fieldId": "8028E6A0-A197-4874-95DA-826B9E264EB2",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "regionId",
                         "bind": "{regionId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5FB765FA-2C32-43A4-9188-23C4C69F9DAE",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprojectlinc.testprojectlinc.shared.com.model.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "31920251-7EA8-47B0-8FAF-78B7A6B33F8F",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprojectlinc.testprojectlinc.shared.com.model.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionName",
                         "itemId": "regionName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CE6C6F7F-AD09-4853-A375-DAEE88312FD3",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "regionName",
                         "bind": "{regionName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionCode1",
                         "itemId": "regionCode1",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "68C8B1B5-AE03-45C3-878E-327DCF33F9B3",
                         "minValue": "0",
                         "maxValue": "3",
                         "bindable": "regionCode1",
                         "bind": "{regionCode1}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionCodeChar2",
                         "itemId": "regionCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Code 2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6DBDEDF6-76A7-42A3-A9A1-5E5132AD14F8",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "regionCodeChar2",
                         "bind": "{regionCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionDescription",
                         "itemId": "regionDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Region Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Description",
                         "fieldId": "87519A57-9EE1-4202-A6FA-2C2924A9B9F4",
                         "bindable": "regionDescription",
                         "bind": "{regionDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionFlag",
                         "itemId": "regionFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "311DF33A-3940-4748-9BC7-6C8DA14C01E5",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "regionFlag",
                         "bind": "{regionFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionLatitude",
                         "itemId": "regionLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Latitude",
                         "fieldId": "EDFABF3D-1055-4030-BA5F-B366BBF9A049",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "regionLatitude",
                         "bind": "{regionLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "regionLongitude",
                         "itemId": "regionLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Region Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Longitude",
                         "fieldId": "E9B98A35-8490-43EA-8A8A-9A640883F45D",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "regionLongitude",
                         "bind": "{regionLongitude}",
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
                         "fieldId": "880FC0DD-0A04-4EC0-BD96-9AF9DE014401",
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
                         "customId": 711,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 711,
                              "customId": 491
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 711,
                              "customId": 492,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 711,
                              "customId": 493,
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
                    "displayName": "Region",
                    "title": "Details Grid",
                    "name": "RegionGrid",
                    "itemId": "RegionGrid",
                    "restURL": "/Region",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Region Id",
                         "dataIndex": "regionId",
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
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region Name",
                         "dataIndex": "regionName",
                         "flex": 1
                    }, {
                         "header": "Region Code 1",
                         "dataIndex": "regionCode1",
                         "flex": 1
                    }, {
                         "header": "Region Code 2",
                         "dataIndex": "regionCodeChar2",
                         "flex": 1
                    }, {
                         "header": "Region Description",
                         "dataIndex": "regionDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "regionFlag",
                         "flex": 1
                    }, {
                         "header": "Region Latitude",
                         "dataIndex": "regionLatitude",
                         "flex": 1
                    }, {
                         "header": "Region Longitude",
                         "dataIndex": "regionLongitude",
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
               "viewModel": "RegionViewModel",
               "xtype": "form",
               "displayName": "Region",
               "title": "Region",
               "name": "Region",
               "itemId": "Region",
               "bodyPadding": 10,
               "items": [{
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Id<font color='red'> *<\/font>",
                    "fieldId": "8028E6A0-A197-4874-95DA-826B9E264EB2",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "regionId",
                    "bind": "{regionId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5FB765FA-2C32-43A4-9188-23C4C69F9DAE",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testprojectlinc.testprojectlinc.shared.com.model.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "31920251-7EA8-47B0-8FAF-78B7A6B33F8F",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testprojectlinc.testprojectlinc.shared.com.model.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionName",
                    "itemId": "regionName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CE6C6F7F-AD09-4853-A375-DAEE88312FD3",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "regionName",
                    "bind": "{regionName}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionCode1",
                    "itemId": "regionCode1",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Code 1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Code 1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "68C8B1B5-AE03-45C3-878E-327DCF33F9B3",
                    "minValue": "0",
                    "maxValue": "3",
                    "bindable": "regionCode1",
                    "bind": "{regionCode1}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionCodeChar2",
                    "itemId": "regionCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Region Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Code 2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6DBDEDF6-76A7-42A3-A9A1-5E5132AD14F8",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "regionCodeChar2",
                    "bind": "{regionCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionDescription",
                    "itemId": "regionDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Region Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Description",
                    "fieldId": "87519A57-9EE1-4202-A6FA-2C2924A9B9F4",
                    "bindable": "regionDescription",
                    "bind": "{regionDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionFlag",
                    "itemId": "regionFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "311DF33A-3940-4748-9BC7-6C8DA14C01E5",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "regionFlag",
                    "bind": "{regionFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionLatitude",
                    "itemId": "regionLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Latitude",
                    "fieldId": "EDFABF3D-1055-4030-BA5F-B366BBF9A049",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "regionLatitude",
                    "bind": "{regionLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "regionLongitude",
                    "itemId": "regionLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Region Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region Longitude",
                    "fieldId": "E9B98A35-8490-43EA-8A8A-9A640883F45D",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "regionLongitude",
                    "bind": "{regionLongitude}",
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
                    "fieldId": "880FC0DD-0A04-4EC0-BD96-9AF9DE014401",
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
                    "customId": 711,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 711,
                         "customId": 491
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 711,
                         "customId": 492,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 711,
                         "customId": 493,
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