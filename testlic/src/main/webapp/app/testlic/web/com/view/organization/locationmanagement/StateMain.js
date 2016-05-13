Ext.define('Testlic.testlic.web.com.view.organization.locationmanagement.StateMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "StateMainController",
     "restURL": "/State",
     "defaults": {
          "split": true
     },
     "requires": ["Testlic.testlic.shared.com.model.organization.locationmanagement.StateModel", "Testlic.testlic.web.com.controller.organization.locationmanagement.StateMainController", "Testlic.testlic.shared.com.model.organization.locationmanagement.CountryModel", "Testlic.testlic.shared.com.viewmodel.organization.locationmanagement.StateViewModel"],
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
               "displayName": "State",
               "name": "StateTreeContainer",
               "itemId": "StateTreeContainer",
               "restURL": "/State",
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
                    "itemId": "StateTree",
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
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testlic.testlic.shared.com.model.organization.locationmanagement.CountryModel"
                         },
                         "fieldLabel": "Country Code",
                         "fieldId": "05299DA4-CC1B-46B7-812B-13A2A1DB0008",
                         "restURL": "Country",
                         "bindable": "countryId"
                    }, {
                         "name": "stateName",
                         "itemId": "stateName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Name",
                         "fieldId": "123D1930-3A0E-43A5-B02B-CEC4CBD8FC02",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "stateName"
                    }, {
                         "name": "stateCode",
                         "itemId": "stateCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "State Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code",
                         "fieldId": "7ABEFDCF-034A-4A42-89F0-75A5BEBF9490",
                         "minValue": "0",
                         "maxValue": "2",
                         "bindable": "stateCode"
                    }, {
                         "name": "stateCodeChar2",
                         "itemId": "stateCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 2",
                         "fieldId": "465EF2B0-679C-4B69-BEC5-CE5606190502",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar2"
                    }, {
                         "name": "stateCodeChar3",
                         "itemId": "stateCodeChar3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 3",
                         "fieldId": "5CC92E11-9F6B-4DB6-8FC4-C3A670D0DBFB",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar3"
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
                    "xtype": "form",
                    "displayName": "State",
                    "title": "State",
                    "name": "State",
                    "itemId": "StateForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Id<font color='red'> *<\/font>",
                         "fieldId": "45448DD3-6046-4AC6-B918-D4C1C147F6A2",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "stateId"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testlic.testlic.shared.com.model.organization.locationmanagement.CountryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "fieldId": "05299DA4-CC1B-46B7-812B-13A2A1DB0008",
                         "restURL": "Country",
                         "bindable": "countryId",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateName",
                         "itemId": "stateName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "123D1930-3A0E-43A5-B02B-CEC4CBD8FC02",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "stateName",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCode",
                         "itemId": "stateCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "State Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code",
                         "fieldId": "7ABEFDCF-034A-4A42-89F0-75A5BEBF9490",
                         "minValue": "0",
                         "maxValue": "2",
                         "bindable": "stateCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCodeChar2",
                         "itemId": "stateCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "465EF2B0-679C-4B69-BEC5-CE5606190502",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar2",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCodeChar3",
                         "itemId": "stateCodeChar3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 3",
                         "fieldId": "5CC92E11-9F6B-4DB6-8FC4-C3A670D0DBFB",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar3",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateDescription",
                         "itemId": "stateDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "State Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Description",
                         "fieldId": "133D55E0-7B62-4F3C-8FAD-363E2A297DF6",
                         "bindable": "stateDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateFlag",
                         "itemId": "stateFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "697646F8-8D89-4292-9113-3D3B9C7A7A76",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateFlag",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapital",
                         "itemId": "stateCapital",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Capital",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital",
                         "fieldId": "55DC5821-D9C8-4A50-927F-9BF97184C528",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateCapital",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLatitude",
                         "itemId": "stateCapitalLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Latitude",
                         "fieldId": "8DECE938-5D65-4D25-A7FE-C9A6F72104E7",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLatitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLongitude",
                         "itemId": "stateCapitalLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Longitude",
                         "fieldId": "61648AB8-E44E-4318-B82E-BDAB9156FAD4",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLongitude",
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
                         "fieldId": "E1FBF223-D199-43FA-A71E-C250DB3860DB",
                         "bindable": "versionId",
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
                         "customId": 520,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 520,
                              "customId": 938
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 520,
                              "customId": 939,
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
                              "parentId": 520,
                              "customId": 940,
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
                    "displayName": "State",
                    "title": "Details Grid",
                    "name": "StateGrid",
                    "itemId": "StateGrid",
                    "restURL": "/State",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "State Id",
                         "dataIndex": "stateId",
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
                         "header": "Country Code",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State Name",
                         "dataIndex": "stateName",
                         "flex": 1
                    }, {
                         "header": "State Code",
                         "dataIndex": "stateCode",
                         "flex": 1
                    }, {
                         "header": "State Code 2",
                         "dataIndex": "stateCodeChar2",
                         "flex": 1
                    }, {
                         "header": "State Code 3",
                         "dataIndex": "stateCodeChar3",
                         "flex": 1
                    }, {
                         "header": "State Description",
                         "dataIndex": "stateDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "stateFlag",
                         "flex": 1
                    }, {
                         "header": "Capital",
                         "dataIndex": "stateCapital",
                         "flex": 1
                    }, {
                         "header": "Capitial Latitude",
                         "dataIndex": "stateCapitalLatitude",
                         "flex": 1
                    }, {
                         "header": "Capitial Longitude",
                         "dataIndex": "stateCapitalLongitude",
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
               "xtype": "form",
               "displayName": "State",
               "title": "State",
               "name": "State",
               "itemId": "StateForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Id<font color='red'> *<\/font>",
                    "fieldId": "45448DD3-6046-4AC6-B918-D4C1C147F6A2",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "stateId"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testlic.testlic.shared.com.model.organization.locationmanagement.CountryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "fieldId": "05299DA4-CC1B-46B7-812B-13A2A1DB0008",
                    "restURL": "Country",
                    "bindable": "countryId",
                    "columnWidth": 0.5
               }, {
                    "name": "stateName",
                    "itemId": "stateName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "123D1930-3A0E-43A5-B02B-CEC4CBD8FC02",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "stateName",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCode",
                    "itemId": "stateCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "State Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code",
                    "fieldId": "7ABEFDCF-034A-4A42-89F0-75A5BEBF9490",
                    "minValue": "0",
                    "maxValue": "2",
                    "bindable": "stateCode",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCodeChar2",
                    "itemId": "stateCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code 2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "465EF2B0-679C-4B69-BEC5-CE5606190502",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar2",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCodeChar3",
                    "itemId": "stateCodeChar3",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Code 3",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code 3",
                    "fieldId": "5CC92E11-9F6B-4DB6-8FC4-C3A670D0DBFB",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar3",
                    "columnWidth": 0.5
               }, {
                    "name": "stateDescription",
                    "itemId": "stateDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "State Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Description",
                    "fieldId": "133D55E0-7B62-4F3C-8FAD-363E2A297DF6",
                    "bindable": "stateDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "stateFlag",
                    "itemId": "stateFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "697646F8-8D89-4292-9113-3D3B9C7A7A76",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateFlag",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapital",
                    "itemId": "stateCapital",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Capital",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital",
                    "fieldId": "55DC5821-D9C8-4A50-927F-9BF97184C528",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateCapital",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLatitude",
                    "itemId": "stateCapitalLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Latitude",
                    "fieldId": "8DECE938-5D65-4D25-A7FE-C9A6F72104E7",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLatitude",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLongitude",
                    "itemId": "stateCapitalLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Longitude",
                    "fieldId": "61648AB8-E44E-4318-B82E-BDAB9156FAD4",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLongitude",
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
                    "fieldId": "E1FBF223-D199-43FA-A71E-C250DB3860DB",
                    "bindable": "versionId",
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
                    "customId": 520,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 520,
                         "customId": 938
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 520,
                         "customId": 939,
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
                         "parentId": 520,
                         "customId": 940,
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