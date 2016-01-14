Ext.define('Testprj.testprj.web.testprj.view.sales.SalesDataMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "SalesDataMainController",
     "restURL": "/SalesData",
     "defaults": {
          "split": true
     },
     "requires": ["Testprj.testprj.shared.testprj.model.sales.SalesDataModel", "Testprj.testprj.web.testprj.controller.sales.SalesDataMainController", "Testprj.testprj.shared.testprj.model.sales.ChannelModel", "Testprj.testprj.shared.testprj.model.sales.RetailerModel", "Testprj.testprj.shared.testprj.model.sales.MaterialModel", "Testprj.testprj.shared.testprj.model.sales.BrandModel", "Testprj.testprj.shared.testprj.model.sales.CategoryModel", "Testprj.testprj.shared.testprj.viewmodel.sales.SalesDataViewModel"],
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
               "displayName": "SalesData",
               "name": "SalesDataTreeContainer",
               "itemId": "SalesDataTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "SalesDataTree",
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
                    "layout": "fit",
                    "autoScroll": false,
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick"
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
                    "xtype": "form",
                    "displayName": "SalesData",
                    "name": "SalesData",
                    "itemId": "SalesDataForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "autoid",
                                   "itemId": "autoid",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Auto Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Auto Id<font color='red'> *<\/font>",
                                   "fieldId": "CB4E4F2F-A3F6-4AE6-96B4-C96C5BE2FB11",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "autoid",
                                   "bind": "{autoid}"
                              }, {
                                   "name": "channelId",
                                   "itemId": "channelId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Channel",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Channel<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "69235F07-CA6F-48B8-9913-092FE24725C8",
                                   "restURL": "Channel",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.sales.ChannelModel"
                                   },
                                   "bindable": "channelId",
                                   "columnWidth": 0.5,
                                   "bind": "{channelId}"
                              }, {
                                   "name": "reatilercode",
                                   "itemId": "reatilercode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Retailer",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Retailer<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "68C4DC38-84AC-40D7-A713-D742CDBA0C1A",
                                   "restURL": "Retailer",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.sales.RetailerModel"
                                   },
                                   "bindable": "reatilercode",
                                   "columnWidth": 0.5,
                                   "bind": "{reatilercode}"
                              }, {
                                   "name": "retailername",
                                   "itemId": "retailername",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Retailer name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Retailer name",
                                   "fieldId": "75538A01-10ED-407C-85F3-6684E2D7F588",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "retailername",
                                   "columnWidth": 0.5,
                                   "bind": "{retailername}"
                              }, {
                                   "name": "salesdate",
                                   "itemId": "salesdate",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Sales Date",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales Date<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E4FE1D79-0861-45F3-8A84-1C358F970CB7",
                                   "bindable": "salesdate",
                                   "columnWidth": 0.5,
                                   "bind": "{salesdate}",
                                   "format": "d-m-Y H:m:s",
                                   "submitFormat": "d-m-Y H:m:s"
                              }, {
                                   "name": "salesmonth",
                                   "itemId": "salesmonth",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales Month",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales Month<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "966A927D-E344-4333-BBDB-223C9D7FC4F5",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "salesmonth",
                                   "columnWidth": 0.5,
                                   "bind": "{salesmonth}"
                              }, {
                                   "name": "salesyear",
                                   "itemId": "salesyear",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales Year",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales Year<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C5F056B0-27B8-435A-9842-378F66E04B56",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "salesyear",
                                   "columnWidth": 0.5,
                                   "bind": "{salesyear}"
                              }, {
                                   "name": "salesinvoicenbr",
                                   "itemId": "salesinvoicenbr",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Invoice Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Invoice Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "3F924A9A-2758-4EF8-9007-63A962B93890",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "salesinvoicenbr",
                                   "columnWidth": 0.5,
                                   "bind": "{salesinvoicenbr}"
                              }, {
                                   "name": "materialdesc",
                                   "itemId": "materialdesc",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Material Desc",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Material Desc",
                                   "fieldId": "CD45053C-65DD-461C-B841-3507BA81D8B7",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "materialdesc",
                                   "columnWidth": 0.5,
                                   "bind": "{materialdesc}"
                              }, {
                                   "name": "branddesc",
                                   "itemId": "branddesc",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Brand Desc",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Brand Desc",
                                   "fieldId": "E62CB6BC-4361-4A01-8C2A-8F3E4C113F72",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "branddesc",
                                   "columnWidth": 0.5,
                                   "bind": "{branddesc}"
                              }, {
                                   "name": "salesqty",
                                   "itemId": "salesqty",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sales Quantity",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sales Quantity<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "4445C31F-AFC3-418D-8CCC-CF9EAFF97E23",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "salesqty",
                                   "columnWidth": 0.5,
                                   "bind": "{salesqty}"
                              }, {
                                   "name": "netsalesamt",
                                   "itemId": "netsalesamt",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Net Sales",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Net Sales<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D4E22E4A-E8EC-43C5-BB2B-37F38D2DBE7D",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "netsalesamt",
                                   "columnWidth": 0.5,
                                   "bind": "{netsalesamt}"
                              }, {
                                   "name": "grosssalesamt",
                                   "itemId": "grosssalesamt",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Gross Sales",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Gross Sales<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "A96B5293-BC92-41EB-9CC7-BD6965A6709D",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "grosssalesamt",
                                   "columnWidth": 0.5,
                                   "bind": "{grosssalesamt}"
                              }, {
                                   "name": "materialcode",
                                   "itemId": "materialcode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Material",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Material<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "2C759C74-E1E4-4AA3-8CD7-430B95F47272",
                                   "restURL": "Material",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.sales.MaterialModel"
                                   },
                                   "bindable": "materialcode",
                                   "columnWidth": 0.5,
                                   "bind": "{materialcode}"
                              }, {
                                   "name": "brandcode",
                                   "itemId": "brandcode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Brand",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Brand<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "65EF61AA-EA3D-4B0E-A327-0C26CF37EB13",
                                   "restURL": "Brand",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.sales.BrandModel"
                                   },
                                   "bindable": "brandcode",
                                   "columnWidth": 0.5,
                                   "bind": "{brandcode}",
                                   "listeners": {
                                        "change": "onBrandcodeChange"
                                   }
                              }, {
                                   "name": "category",
                                   "itemId": "category",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Category",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Category<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "AE7D2EA2-DF66-40BB-A141-03D814A33949",
                                   "restURL": "Category",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.sales.CategoryModel"
                                   },
                                   "bindable": "category",
                                   "columnWidth": 0.5,
                                   "bind": "{category}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "7816DBBE-6C90-4D64-8AE2-B44754147364",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "viewModel": "SalesDataViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "SalesData",
                    "title": "Details Grid",
                    "name": "SalesDataGrid",
                    "itemId": "SalesDataGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Auto Id",
                         "dataIndex": "autoid",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Channel",
                         "dataIndex": "channelId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Retailer",
                         "dataIndex": "reatilercode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Retailer name",
                         "dataIndex": "retailername",
                         "flex": 1
                    }, {
                         "header": "Sales Date",
                         "dataIndex": "salesdate",
                         "flex": 1
                    }, {
                         "header": "Sales Month",
                         "dataIndex": "salesmonth",
                         "flex": 1
                    }, {
                         "header": "Sales Year",
                         "dataIndex": "salesyear",
                         "flex": 1
                    }, {
                         "header": "Invoice Number",
                         "dataIndex": "salesinvoicenbr",
                         "flex": 1
                    }, {
                         "header": "Material Desc",
                         "dataIndex": "materialdesc",
                         "flex": 1
                    }, {
                         "header": "Brand Desc",
                         "dataIndex": "branddesc",
                         "flex": 1
                    }, {
                         "header": "Sales Quantity",
                         "dataIndex": "salesqty",
                         "flex": 1
                    }, {
                         "header": "Net Sales",
                         "dataIndex": "netsalesamt",
                         "flex": 1
                    }, {
                         "header": "Gross Sales",
                         "dataIndex": "grosssalesamt",
                         "flex": 1
                    }, {
                         "header": "Material",
                         "dataIndex": "materialcode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Brand",
                         "dataIndex": "brandcode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Category",
                         "dataIndex": "category",
                         "renderer": "renderFormValue",
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
               "xtype": "form",
               "displayName": "SalesData",
               "name": "SalesData",
               "itemId": "SalesDataForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "autoid",
                              "itemId": "autoid",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Auto Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Auto Id<font color='red'> *<\/font>",
                              "fieldId": "CB4E4F2F-A3F6-4AE6-96B4-C96C5BE2FB11",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "hidden": true,
                              "value": "",
                              "bindable": "autoid",
                              "bind": "{autoid}"
                         }, {
                              "name": "channelId",
                              "itemId": "channelId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Channel",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Channel<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "69235F07-CA6F-48B8-9913-092FE24725C8",
                              "restURL": "Channel",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.sales.ChannelModel"
                              },
                              "bindable": "channelId",
                              "columnWidth": 0.5,
                              "bind": "{channelId}"
                         }, {
                              "name": "reatilercode",
                              "itemId": "reatilercode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Retailer",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Retailer<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "68C4DC38-84AC-40D7-A713-D742CDBA0C1A",
                              "restURL": "Retailer",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.sales.RetailerModel"
                              },
                              "bindable": "reatilercode",
                              "columnWidth": 0.5,
                              "bind": "{reatilercode}"
                         }, {
                              "name": "retailername",
                              "itemId": "retailername",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Retailer name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Retailer name",
                              "fieldId": "75538A01-10ED-407C-85F3-6684E2D7F588",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "retailername",
                              "columnWidth": 0.5,
                              "bind": "{retailername}"
                         }, {
                              "name": "salesdate",
                              "itemId": "salesdate",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Sales Date",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales Date<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E4FE1D79-0861-45F3-8A84-1C358F970CB7",
                              "bindable": "salesdate",
                              "columnWidth": 0.5,
                              "bind": "{salesdate}",
                              "format": "d-m-Y H:m:s",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "name": "salesmonth",
                              "itemId": "salesmonth",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales Month",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales Month<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "966A927D-E344-4333-BBDB-223C9D7FC4F5",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "salesmonth",
                              "columnWidth": 0.5,
                              "bind": "{salesmonth}"
                         }, {
                              "name": "salesyear",
                              "itemId": "salesyear",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales Year",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales Year<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C5F056B0-27B8-435A-9842-378F66E04B56",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "salesyear",
                              "columnWidth": 0.5,
                              "bind": "{salesyear}"
                         }, {
                              "name": "salesinvoicenbr",
                              "itemId": "salesinvoicenbr",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Invoice Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Invoice Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "3F924A9A-2758-4EF8-9007-63A962B93890",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "salesinvoicenbr",
                              "columnWidth": 0.5,
                              "bind": "{salesinvoicenbr}"
                         }, {
                              "name": "materialdesc",
                              "itemId": "materialdesc",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Material Desc",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Material Desc",
                              "fieldId": "CD45053C-65DD-461C-B841-3507BA81D8B7",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "materialdesc",
                              "columnWidth": 0.5,
                              "bind": "{materialdesc}"
                         }, {
                              "name": "branddesc",
                              "itemId": "branddesc",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Brand Desc",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Brand Desc",
                              "fieldId": "E62CB6BC-4361-4A01-8C2A-8F3E4C113F72",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "branddesc",
                              "columnWidth": 0.5,
                              "bind": "{branddesc}"
                         }, {
                              "name": "salesqty",
                              "itemId": "salesqty",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sales Quantity",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sales Quantity<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "4445C31F-AFC3-418D-8CCC-CF9EAFF97E23",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "salesqty",
                              "columnWidth": 0.5,
                              "bind": "{salesqty}"
                         }, {
                              "name": "netsalesamt",
                              "itemId": "netsalesamt",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Net Sales",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Net Sales<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "D4E22E4A-E8EC-43C5-BB2B-37F38D2DBE7D",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "netsalesamt",
                              "columnWidth": 0.5,
                              "bind": "{netsalesamt}"
                         }, {
                              "name": "grosssalesamt",
                              "itemId": "grosssalesamt",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Gross Sales",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Gross Sales<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "A96B5293-BC92-41EB-9CC7-BD6965A6709D",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "grosssalesamt",
                              "columnWidth": 0.5,
                              "bind": "{grosssalesamt}"
                         }, {
                              "name": "materialcode",
                              "itemId": "materialcode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Material",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Material<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "2C759C74-E1E4-4AA3-8CD7-430B95F47272",
                              "restURL": "Material",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.sales.MaterialModel"
                              },
                              "bindable": "materialcode",
                              "columnWidth": 0.5,
                              "bind": "{materialcode}"
                         }, {
                              "name": "brandcode",
                              "itemId": "brandcode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Brand",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Brand<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "65EF61AA-EA3D-4B0E-A327-0C26CF37EB13",
                              "restURL": "Brand",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.sales.BrandModel"
                              },
                              "bindable": "brandcode",
                              "columnWidth": 0.5,
                              "bind": "{brandcode}",
                              "listeners": {
                                   "change": "onBrandcodeChange"
                              }
                         }, {
                              "name": "category",
                              "itemId": "category",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Category",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Category<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "AE7D2EA2-DF66-40BB-A141-03D814A33949",
                              "restURL": "Category",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.sales.CategoryModel"
                              },
                              "bindable": "category",
                              "columnWidth": 0.5,
                              "bind": "{category}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "7816DBBE-6C90-4D64-8AE2-B44754147364",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "viewModel": "SalesDataViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});