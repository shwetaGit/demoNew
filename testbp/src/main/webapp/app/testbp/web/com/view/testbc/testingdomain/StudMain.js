Ext.define('Testbp.testbp.web.com.view.testbc.testingdomain.StudMain', {
     "xtype": "stud",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "StudMainController",
     "restURL": "/Stud",
     "defaults": {
          "split": true
     },
     "requires": ["Testbp.testbp.shared.com.model.testbc.testingdomain.StudModel", "Testbp.testbp.web.com.controller.testbc.testingdomain.StudMainController", "Testbp.view.fw.component.DateTimeField", "Testbp.view.fw.component.DateTimePicker", "Testbp.testbp.shared.com.viewmodel.testbc.testingdomain.StudViewModel"],
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
               "displayName": "Stud",
               "name": "StudTreeContainer",
               "itemId": "StudTreeContainer",
               "restURL": "/Stud",
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
                    "itemId": "StudTree",
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
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
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
                    "xtype": "form",
                    "displayName": "Stud",
                    "title": "Stud",
                    "name": "Stud",
                    "itemId": "StudForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "sid",
                         "itemId": "sid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "sid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "sid<font color='red'> *<\/font>",
                         "fieldId": "456B42D8-89ED-447B-B23F-A5029B0E5F97",
                         "hidden": true,
                         "value": "",
                         "bindable": "sid"
                    }, {
                         "name": "studName",
                         "itemId": "studName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "studName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "studName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D29A7656-D858-4108-939A-50405CDE1F77",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "studName",
                         "columnWidth": 0.5
                    }, {
                         "name": "dob",
                         "itemId": "dob",
                         "xtype": "customdatetimefield",
                         "customWidgetType": "customdatetimefield",
                         "displayName": "dob",
                         "margin": "5 5 5 5",
                         "submitFormat": "d-m-Y H:i:s",
                         "format": "d-m-Y H:i:s",
                         "fieldLabel": "dob<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FCBE9AEF-DC73-4769-9976-F1263711B3C8",
                         "bindable": "dob",
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
                         "fieldId": "E5009201-26CE-47E0-9F0A-80D9FD347722",
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
                         "isToolBar": true,
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 485,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 485,
                              "customId": 2
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 485,
                              "customId": 3,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": 5,
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 485,
                              "customId": 4,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }]
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
                    "displayName": "Stud",
                    "title": "Details Grid",
                    "name": "StudGrid",
                    "itemId": "StudGrid",
                    "restURL": "/Stud",
                    "store": [],
                    "columns": [{
                         "header": "sid",
                         "dataIndex": "sid",
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
                         "header": "studName",
                         "dataIndex": "studName",
                         "flex": 1
                    }, {
                         "header": "dob",
                         "dataIndex": "dob",
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
               "displayName": "Stud",
               "title": "Stud",
               "name": "Stud",
               "itemId": "StudForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "sid",
                    "itemId": "sid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "sid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "sid<font color='red'> *<\/font>",
                    "fieldId": "456B42D8-89ED-447B-B23F-A5029B0E5F97",
                    "hidden": true,
                    "value": "",
                    "bindable": "sid"
               }, {
                    "name": "studName",
                    "itemId": "studName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "studName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "studName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D29A7656-D858-4108-939A-50405CDE1F77",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "studName",
                    "columnWidth": 0.5
               }, {
                    "name": "dob",
                    "itemId": "dob",
                    "xtype": "customdatetimefield",
                    "customWidgetType": "customdatetimefield",
                    "displayName": "dob",
                    "margin": "5 5 5 5",
                    "submitFormat": "d-m-Y H:i:s",
                    "format": "d-m-Y H:i:s",
                    "fieldLabel": "dob<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FCBE9AEF-DC73-4769-9976-F1263711B3C8",
                    "bindable": "dob",
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
                    "fieldId": "E5009201-26CE-47E0-9F0A-80D9FD347722",
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
                    "isToolBar": true,
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 485,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 485,
                         "customId": 2
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 485,
                         "customId": 3,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": 5,
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 485,
                         "customId": 4,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }]
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