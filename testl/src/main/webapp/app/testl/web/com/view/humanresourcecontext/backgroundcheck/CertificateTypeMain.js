Ext.define('Testl.testl.web.com.view.humanresourcecontext.backgroundcheck.CertificateTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CertificateTypeMainController",
     "restURL": "/CertificateType",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.CertificateTypeModel", "Testl.testl.web.com.controller.humanresourcecontext.backgroundcheck.CertificateTypeMainController", "Testl.testl.shared.com.viewmodel.humanresourcecontext.backgroundcheck.CertificateTypeViewModel"],
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
               "displayName": "Certificate Type",
               "name": "CertificateTypeTreeContainer",
               "itemId": "CertificateTypeTreeContainer",
               "restURL": "/CertificateType",
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
                    "itemId": "CertificateTypeTree",
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
                         "name": "certDesc",
                         "itemId": "certDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Certification",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Certification",
                         "fieldId": "E17561E0-7DFC-4CFA-BF31-FE3F58C9B1AE",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "certDesc"
                    }, {
                         "name": "certHelp",
                         "itemId": "certHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Certification Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Certification Details",
                         "fieldId": "6A7D7AD3-E7CB-49DF-99E3-40BAF22AC569",
                         "bindable": "certHelp"
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
                    "viewModel": "CertificateTypeViewModel",
                    "xtype": "form",
                    "displayName": "Certificate Type",
                    "title": "Certificate Type",
                    "name": "CertificateType",
                    "itemId": "CertificateType",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "certCode",
                         "itemId": "certCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "certCode",
                         "margin": "5 5 5 5",
                         "fieldLabel": "certCode<font color='red'> *<\/font>",
                         "fieldId": "9EAE9836-52B9-418E-A65F-3A4058DB631E",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "certCode",
                         "bind": "{certCode}"
                    }, {
                         "name": "certDesc",
                         "itemId": "certDesc",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Certification",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Certification<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E17561E0-7DFC-4CFA-BF31-FE3F58C9B1AE",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "certDesc",
                         "bind": "{certDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "certHelp",
                         "itemId": "certHelp",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Certification Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Certification Details<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6A7D7AD3-E7CB-49DF-99E3-40BAF22AC569",
                         "bindable": "certHelp",
                         "bind": "{certHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "certIcon",
                         "itemId": "certIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "certIcon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "certIcon",
                         "fieldId": "F5C590A5-2F68-4BF3-AD1E-ED16B9C69741",
                         "minLength": "0",
                         "bindable": "certIcon",
                         "bind": "{certIcon}",
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
                         "fieldId": "2DF014E9-8146-465F-AF92-90D91B67DDCD",
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
                         "customId": 668,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 668,
                              "customId": 357
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 668,
                              "customId": 358,
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
                              "parentId": 668,
                              "customId": 359,
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
                    "displayName": "Certificate Type",
                    "title": "Details Grid",
                    "name": "CertificateTypeGrid",
                    "itemId": "CertificateTypeGrid",
                    "restURL": "/CertificateType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "certCode",
                         "dataIndex": "certCode",
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
                         "header": "Certification",
                         "dataIndex": "certDesc",
                         "flex": 1
                    }, {
                         "header": "Certification Details",
                         "dataIndex": "certHelp",
                         "flex": 1
                    }, {
                         "header": "certIcon",
                         "dataIndex": "certIcon",
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
               "viewModel": "CertificateTypeViewModel",
               "xtype": "form",
               "displayName": "Certificate Type",
               "title": "Certificate Type",
               "name": "CertificateType",
               "itemId": "CertificateType",
               "bodyPadding": 10,
               "items": [{
                    "name": "certCode",
                    "itemId": "certCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "certCode",
                    "margin": "5 5 5 5",
                    "fieldLabel": "certCode<font color='red'> *<\/font>",
                    "fieldId": "9EAE9836-52B9-418E-A65F-3A4058DB631E",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "certCode",
                    "bind": "{certCode}"
               }, {
                    "name": "certDesc",
                    "itemId": "certDesc",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Certification",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Certification<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E17561E0-7DFC-4CFA-BF31-FE3F58C9B1AE",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "certDesc",
                    "bind": "{certDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "certHelp",
                    "itemId": "certHelp",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Certification Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Certification Details<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6A7D7AD3-E7CB-49DF-99E3-40BAF22AC569",
                    "bindable": "certHelp",
                    "bind": "{certHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "certIcon",
                    "itemId": "certIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "certIcon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "certIcon",
                    "fieldId": "F5C590A5-2F68-4BF3-AD1E-ED16B9C69741",
                    "minLength": "0",
                    "bindable": "certIcon",
                    "bind": "{certIcon}",
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
                    "fieldId": "2DF014E9-8146-465F-AF92-90D91B67DDCD",
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
                    "customId": 668,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 668,
                         "customId": 357
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 668,
                         "customId": 358,
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
                         "parentId": 668,
                         "customId": 359,
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