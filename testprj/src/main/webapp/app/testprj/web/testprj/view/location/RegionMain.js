Ext.define('Testprj.testprj.web.testprj.view.location.RegionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "RegionMainController",
     "restURL": "/Region",
     "defaults": {
          "split": true
     },
     "requires": ["Testprj.testprj.shared.testprj.model.location.RegionModel", "Testprj.testprj.web.testprj.controller.location.RegionMainController", "Testprj.testprj.shared.testprj.model.location.CountryModel", "Testprj.testprj.shared.testprj.model.location.StateModel", "Testprj.testprj.shared.testprj.viewmodel.location.RegionViewModel"],
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
                         "fieldId": "90E3D4E3-E22A-4ED9-9F87-B1C931CA2771",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprj.testprj.shared.testprj.model.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "1D90E571-4451-4E83-A388-2AA8A4FA5DEF",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprj.testprj.shared.testprj.model.location.StateModel"
                         }
                    }, {
                         "name": "regionName",
                         "itemId": "regionName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Region Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region Name",
                         "fieldId": "6EFB7729-4B08-49FC-9B42-705BCE2F2925",
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
                         "fieldId": "5DC5ADED-BE9B-4AB4-9AA2-C3967218F5C5",
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
                         "fieldId": "FD15ABFD-AD32-4600-8D8E-B1A3E2BBA311",
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
                         "fieldId": "0BA34A03-503C-4483-B962-3E880DE6DA04",
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
                         "fieldId": "90E3D4E3-E22A-4ED9-9F87-B1C931CA2771",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprj.testprj.shared.testprj.model.location.CountryModel"
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
                         "fieldId": "1D90E571-4451-4E83-A388-2AA8A4FA5DEF",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testprj.testprj.shared.testprj.model.location.StateModel"
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
                         "fieldId": "6EFB7729-4B08-49FC-9B42-705BCE2F2925",
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
                         "fieldId": "5DC5ADED-BE9B-4AB4-9AA2-C3967218F5C5",
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
                         "fieldId": "FD15ABFD-AD32-4600-8D8E-B1A3E2BBA311",
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
                         "fieldId": "1820DC86-3554-409F-940D-EAEE4AABFDB7",
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
                         "fieldId": "0DC66E59-397A-4D97-A58A-2EB6F0C828C7",
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
                         "fieldId": "0EB21043-7DA6-4389-A668-322C9891F93D",
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
                         "fieldId": "D9375377-12B6-4737-B76D-491DB623F05F",
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
                         "fieldId": "90E015B1-1BCB-4DF6-A1DE-03A91419445F",
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
                         "customId": 505,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 505,
                              "customId": 227
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 505,
                              "customId": 228,
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
                              "parentId": 505,
                              "customId": 229,
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
                    "fieldId": "0BA34A03-503C-4483-B962-3E880DE6DA04",
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
                    "fieldId": "90E3D4E3-E22A-4ED9-9F87-B1C931CA2771",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testprj.testprj.shared.testprj.model.location.CountryModel"
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
                    "fieldId": "1D90E571-4451-4E83-A388-2AA8A4FA5DEF",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testprj.testprj.shared.testprj.model.location.StateModel"
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
                    "fieldId": "6EFB7729-4B08-49FC-9B42-705BCE2F2925",
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
                    "fieldId": "5DC5ADED-BE9B-4AB4-9AA2-C3967218F5C5",
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
                    "fieldId": "FD15ABFD-AD32-4600-8D8E-B1A3E2BBA311",
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
                    "fieldId": "1820DC86-3554-409F-940D-EAEE4AABFDB7",
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
                    "fieldId": "0DC66E59-397A-4D97-A58A-2EB6F0C828C7",
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
                    "fieldId": "0EB21043-7DA6-4389-A668-322C9891F93D",
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
                    "fieldId": "D9375377-12B6-4737-B76D-491DB623F05F",
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
                    "fieldId": "90E015B1-1BCB-4DF6-A1DE-03A91419445F",
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
                    "customId": 505,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 505,
                         "customId": 227
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 505,
                         "customId": 228,
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
                         "parentId": 505,
                         "customId": 229,
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