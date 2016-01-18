Ext.define('Project3.project3.web.project3.view.location.VillageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "VillageMainController",
     "restURL": "/Village",
     "defaults": {
          "split": true
     },
     "requires": ["Project3.project3.shared.project3.model.location.VillageModel", "Project3.project3.web.project3.controller.location.VillageMainController", "Project3.project3.shared.project3.model.location.CountryModel", "Project3.project3.shared.project3.model.location.StateModel", "Project3.project3.shared.project3.model.location.RegionModel", "Project3.project3.shared.project3.model.location.DistrictModel", "Project3.project3.shared.project3.model.location.TalukaModel", "Project3.project3.shared.project3.viewmodel.location.VillageViewModel"],
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
               "displayName": "Village",
               "name": "VillageTreeContainer",
               "itemId": "VillageTreeContainer",
               "restURL": "/Village",
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
                    "itemId": "VillageTree",
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
                    "items": []
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
                    "viewModel": "VillageViewModel",
                    "xtype": "form",
                    "displayName": "Village",
                    "title": "Village",
                    "name": "Village",
                    "itemId": "Village",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "villageId",
                         "itemId": "villageId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Id<font color='red'> *<\/font>",
                         "fieldId": "72B9BBFE-1764-4CAF-A293-A9369B38E43A",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "villageId",
                         "bind": "{villageId}"
                    }, {
                         "name": "villageName",
                         "itemId": "villageName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "EDAA86B2-68A7-4A8F-B3D6-426CC0277ACB",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "villageName",
                         "bind": "{villageName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageDescription",
                         "itemId": "villageDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Village Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Description",
                         "fieldId": "ECB6BCF7-6059-4072-A1BB-5ED83320BD34",
                         "bindable": "villageDescription",
                         "bind": "{villageDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageFlag",
                         "itemId": "villageFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village taluka",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village taluka",
                         "fieldId": "5C3A5E89-D825-4AC6-8915-165894A8D8A5",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "villageFlag",
                         "bind": "{villageFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AA08E0DD-A897-46E9-B28A-E7E84B301DAB",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project3.project3.shared.project3.model.location.CountryModel"
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
                         "fieldId": "249A3783-A507-4EE4-AC4D-513860E3FADC",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project3.project3.shared.project3.model.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "858202D1-0E4B-4699-B25C-85A85D539F8F",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project3.project3.shared.project3.model.location.RegionModel"
                         },
                         "bindable": "regionId",
                         "bind": "{regionId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onRegionIdChange"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "26BF430D-99E2-46CA-9514-CF0375C67C32",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project3.project3.shared.project3.model.location.DistrictModel"
                         },
                         "bindable": "districtId",
                         "bind": "{districtId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onDistrictIdChange"
                         }
                    }, {
                         "name": "talukaaId",
                         "itemId": "talukaaId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "talukaa",
                         "margin": "5 5 5 5",
                         "fieldLabel": "talukaa<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "17279079-33DA-4865-B158-9CA3BF1B47E7",
                         "restURL": "Taluka",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Project3.project3.shared.project3.model.location.TalukaModel"
                         },
                         "bindable": "talukaaId",
                         "bind": "{talukaaId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageCode",
                         "itemId": "villageCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "67FC4805-2106-4701-96F0-B53376387ED6",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "villageCode",
                         "bind": "{villageCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageLatitude",
                         "itemId": "villageLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Village Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Latitude",
                         "fieldId": "47DA33E0-75C9-4055-AB57-9BC2A568BE15",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "villageLatitude",
                         "bind": "{villageLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageLongtitude",
                         "itemId": "villageLongtitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Village Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Longitude",
                         "fieldId": "CA000B75-8713-4FE1-BCC8-984D2E2E2E3D",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "villageLongtitude",
                         "bind": "{villageLongtitude}",
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
                         "fieldId": "F264CB2B-75C2-41D5-B9D7-C5E213B961B9",
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
                         "customId": 764,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 764,
                              "customId": 262
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 764,
                              "customId": 263,
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
                              "parentId": 764,
                              "customId": 264,
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
                    "displayName": "Village",
                    "title": "Details Grid",
                    "name": "VillageGrid",
                    "itemId": "VillageGrid",
                    "restURL": "/Village",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Village Id",
                         "dataIndex": "villageId",
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
                         "header": "Village Name",
                         "dataIndex": "villageName",
                         "flex": 1
                    }, {
                         "header": "Village Description",
                         "dataIndex": "villageDescription",
                         "flex": 1
                    }, {
                         "header": "Village taluka",
                         "dataIndex": "villageFlag",
                         "flex": 1
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
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District",
                         "dataIndex": "districtId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "talukaa",
                         "dataIndex": "talukaaId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Village Code",
                         "dataIndex": "villageCode",
                         "flex": 1
                    }, {
                         "header": "Village Latitude",
                         "dataIndex": "villageLatitude",
                         "flex": 1
                    }, {
                         "header": "Village Longitude",
                         "dataIndex": "villageLongtitude",
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
               "viewModel": "VillageViewModel",
               "xtype": "form",
               "displayName": "Village",
               "title": "Village",
               "name": "Village",
               "itemId": "Village",
               "bodyPadding": 10,
               "items": [{
                    "name": "villageId",
                    "itemId": "villageId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Id<font color='red'> *<\/font>",
                    "fieldId": "72B9BBFE-1764-4CAF-A293-A9369B38E43A",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "villageId",
                    "bind": "{villageId}"
               }, {
                    "name": "villageName",
                    "itemId": "villageName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "EDAA86B2-68A7-4A8F-B3D6-426CC0277ACB",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "villageName",
                    "bind": "{villageName}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageDescription",
                    "itemId": "villageDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Village Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Description",
                    "fieldId": "ECB6BCF7-6059-4072-A1BB-5ED83320BD34",
                    "bindable": "villageDescription",
                    "bind": "{villageDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageFlag",
                    "itemId": "villageFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village taluka",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village taluka",
                    "fieldId": "5C3A5E89-D825-4AC6-8915-165894A8D8A5",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "villageFlag",
                    "bind": "{villageFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "AA08E0DD-A897-46E9-B28A-E7E84B301DAB",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project3.project3.shared.project3.model.location.CountryModel"
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
                    "fieldId": "249A3783-A507-4EE4-AC4D-513860E3FADC",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project3.project3.shared.project3.model.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "858202D1-0E4B-4699-B25C-85A85D539F8F",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project3.project3.shared.project3.model.location.RegionModel"
                    },
                    "bindable": "regionId",
                    "bind": "{regionId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onRegionIdChange"
                    }
               }, {
                    "name": "districtId",
                    "itemId": "districtId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "District",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "26BF430D-99E2-46CA-9514-CF0375C67C32",
                    "restURL": "District",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project3.project3.shared.project3.model.location.DistrictModel"
                    },
                    "bindable": "districtId",
                    "bind": "{districtId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onDistrictIdChange"
                    }
               }, {
                    "name": "talukaaId",
                    "itemId": "talukaaId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "talukaa",
                    "margin": "5 5 5 5",
                    "fieldLabel": "talukaa<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "17279079-33DA-4865-B158-9CA3BF1B47E7",
                    "restURL": "Taluka",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Project3.project3.shared.project3.model.location.TalukaModel"
                    },
                    "bindable": "talukaaId",
                    "bind": "{talukaaId}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageCode",
                    "itemId": "villageCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "67FC4805-2106-4701-96F0-B53376387ED6",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "villageCode",
                    "bind": "{villageCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageLatitude",
                    "itemId": "villageLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Village Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Latitude",
                    "fieldId": "47DA33E0-75C9-4055-AB57-9BC2A568BE15",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "villageLatitude",
                    "bind": "{villageLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageLongtitude",
                    "itemId": "villageLongtitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Village Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Longitude",
                    "fieldId": "CA000B75-8713-4FE1-BCC8-984D2E2E2E3D",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "villageLongtitude",
                    "bind": "{villageLongtitude}",
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
                    "fieldId": "F264CB2B-75C2-41D5-B9D7-C5E213B961B9",
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
                    "customId": 764,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 764,
                         "customId": 262
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 764,
                         "customId": 263,
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
                         "parentId": 764,
                         "customId": 264,
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