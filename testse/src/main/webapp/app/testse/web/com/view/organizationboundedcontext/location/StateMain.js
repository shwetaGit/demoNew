Ext.define('Testse.testse.web.com.view.organizationboundedcontext.location.StateMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "StateMainController",
     "restURL": "/State",
     "defaults": {
          "split": true
     },
     "requires": ["Testse.testse.shared.com.model.organizationboundedcontext.location.StateModel", "Testse.testse.web.com.controller.organizationboundedcontext.location.StateMainController", "Testse.testse.shared.com.model.organizationboundedcontext.location.CountryModel", "Testse.testse.shared.com.viewmodel.organizationboundedcontext.location.StateViewModel"],
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
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testse.testse.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "fieldLabel": "Country Code",
                         "fieldId": "F90396B5-7A0C-4530-86E2-E466FE1DB737",
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
                         "fieldId": "5101B59D-CE86-4BFF-9673-FF59A6BC5BEC",
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
                         "fieldId": "C28C889B-D2D7-4C89-9588-EF76CE918750",
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
                         "fieldId": "877ECF6B-C90D-4FEE-8A49-FB031F38E5F8",
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
                         "fieldId": "3F8C32A1-B9EC-47C8-A108-74F426E36936",
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
                    "viewModel": "StateViewModel",
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
                         "fieldId": "BF6EFDF2-4BD7-43E5-BD1B-EC125F54CC3F",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "stateId",
                         "bind": "{stateId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testse.testse.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "fieldId": "F90396B5-7A0C-4530-86E2-E466FE1DB737",
                         "restURL": "Country",
                         "bindable": "countryId",
                         "bind": "{countryId}",
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
                         "fieldId": "5101B59D-CE86-4BFF-9673-FF59A6BC5BEC",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "stateName",
                         "bind": "{stateName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCode",
                         "itemId": "stateCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "State Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code",
                         "fieldId": "C28C889B-D2D7-4C89-9588-EF76CE918750",
                         "minValue": "0",
                         "maxValue": "2",
                         "bindable": "stateCode",
                         "bind": "{stateCode}",
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
                         "fieldId": "877ECF6B-C90D-4FEE-8A49-FB031F38E5F8",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar2",
                         "bind": "{stateCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCodeChar3",
                         "itemId": "stateCodeChar3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 3",
                         "fieldId": "3F8C32A1-B9EC-47C8-A108-74F426E36936",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar3",
                         "bind": "{stateCodeChar3}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateDescription",
                         "itemId": "stateDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "State Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Description",
                         "fieldId": "6AEA8467-5B93-4F80-BBD2-EB3965A6517B",
                         "bindable": "stateDescription",
                         "bind": "{stateDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateFlag",
                         "itemId": "stateFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "4EF93A7E-8E67-4845-8DD5-0E6CE77697C0",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateFlag",
                         "bind": "{stateFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapital",
                         "itemId": "stateCapital",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Capital",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital",
                         "fieldId": "D396ED60-E6A4-4B90-B900-2DE5290F18CE",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateCapital",
                         "bind": "{stateCapital}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLatitude",
                         "itemId": "stateCapitalLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Latitude",
                         "fieldId": "3B544013-AB5D-4415-BCAF-3FA948FB9183",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLatitude",
                         "bind": "{stateCapitalLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLongitude",
                         "itemId": "stateCapitalLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Longitude",
                         "fieldId": "1D53DD90-D15E-49AD-AC3A-A5A0C268FAED",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLongitude",
                         "bind": "{stateCapitalLongitude}",
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
                         "fieldId": "FF4F2DD8-8E6D-40F4-882C-322C4210B06C",
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
                         "customId": 335,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 335,
                              "customId": 182
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 335,
                              "customId": 183,
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
                              "parentId": 335,
                              "customId": 184,
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
               "viewModel": "StateViewModel",
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
                    "fieldId": "BF6EFDF2-4BD7-43E5-BD1B-EC125F54CC3F",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "stateId",
                    "bind": "{stateId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testse.testse.shared.com.model.organizationboundedcontext.location.CountryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "fieldId": "F90396B5-7A0C-4530-86E2-E466FE1DB737",
                    "restURL": "Country",
                    "bindable": "countryId",
                    "bind": "{countryId}",
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
                    "fieldId": "5101B59D-CE86-4BFF-9673-FF59A6BC5BEC",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "stateName",
                    "bind": "{stateName}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCode",
                    "itemId": "stateCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "State Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code",
                    "fieldId": "C28C889B-D2D7-4C89-9588-EF76CE918750",
                    "minValue": "0",
                    "maxValue": "2",
                    "bindable": "stateCode",
                    "bind": "{stateCode}",
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
                    "fieldId": "877ECF6B-C90D-4FEE-8A49-FB031F38E5F8",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar2",
                    "bind": "{stateCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCodeChar3",
                    "itemId": "stateCodeChar3",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Code 3",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code 3",
                    "fieldId": "3F8C32A1-B9EC-47C8-A108-74F426E36936",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar3",
                    "bind": "{stateCodeChar3}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateDescription",
                    "itemId": "stateDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "State Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Description",
                    "fieldId": "6AEA8467-5B93-4F80-BBD2-EB3965A6517B",
                    "bindable": "stateDescription",
                    "bind": "{stateDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateFlag",
                    "itemId": "stateFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "4EF93A7E-8E67-4845-8DD5-0E6CE77697C0",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateFlag",
                    "bind": "{stateFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapital",
                    "itemId": "stateCapital",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Capital",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital",
                    "fieldId": "D396ED60-E6A4-4B90-B900-2DE5290F18CE",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateCapital",
                    "bind": "{stateCapital}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLatitude",
                    "itemId": "stateCapitalLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Latitude",
                    "fieldId": "3B544013-AB5D-4415-BCAF-3FA948FB9183",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLatitude",
                    "bind": "{stateCapitalLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLongitude",
                    "itemId": "stateCapitalLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Longitude",
                    "fieldId": "1D53DD90-D15E-49AD-AC3A-A5A0C268FAED",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLongitude",
                    "bind": "{stateCapitalLongitude}",
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
                    "fieldId": "FF4F2DD8-8E6D-40F4-882C-322C4210B06C",
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
                    "customId": 335,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 335,
                         "customId": 182
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 335,
                         "customId": 183,
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
                         "parentId": 335,
                         "customId": 184,
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