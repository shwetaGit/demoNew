Ext.define('Testl.testl.web.com.view.humanresourcecontext.backgroundcheck.CertificationDetailsMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CertificationDetailsMainController",
     "restURL": "/CertificationDetails",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.CertificationDetailsModel", "Testl.testl.web.com.controller.humanresourcecontext.backgroundcheck.CertificationDetailsMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.CertificateTypeModel", "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.GradeTypeModel", "Testl.view.fw.component.Grids", "Testl.testl.shared.com.model.documentboundedcontext.documentmanager.DocumentTypeModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.backgroundcheck.CertificationDetailsViewModel"],
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
               "displayName": "Certification Details",
               "name": "CertificationDetailsTreeContainer",
               "itemId": "CertificationDetailsTreeContainer",
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
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CertificationDetailsTree",
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
                    "items": [{
                         "name": "empId",
                         "itemId": "empId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Employee",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel"
                         },
                         "fieldLabel": "Employee",
                         "fieldId": "ED0AA345-5CFA-42E4-8AB4-5E0A60B7C764",
                         "restURL": "EmpInformation",
                         "bindable": "empId"
                    }, {
                         "name": "certCode",
                         "itemId": "certCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Certification",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.CertificateTypeModel"
                         },
                         "fieldLabel": "Certification",
                         "fieldId": "967BC314-32F0-436A-B69A-F561B5E4EB7B",
                         "restURL": "CertificateType",
                         "bindable": "certCode"
                    }, {
                         "name": "grdCode",
                         "itemId": "grdCode",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Grade",
                         "margin": "5 5 5 5",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.GradeTypeModel"
                         },
                         "fieldLabel": "Grade",
                         "fieldId": "60B347C9-2381-4932-894B-D03553043805",
                         "restURL": "GradeType",
                         "bindable": "grdCode"
                    }, {
                         "name": "obtainedDuration",
                         "itemId": "obtainedDuration",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Obtained Duration",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Obtained Duration",
                         "fieldId": "754AC204-7C94-480C-9A9D-A902338FF7C2",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "obtainedDuration"
                    }, {
                         "name": "instituteName",
                         "itemId": "instituteName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Institute Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Institute Name",
                         "fieldId": "48E50A2D-62C1-4F67-A280-D708ACCCAB51",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "instituteName"
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
                    "xtype": "form",
                    "displayName": "Certification Details",
                    "name": "CertificationDetails",
                    "itemId": "CertificationDetailsForm",
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
                                   "name": "certPk",
                                   "itemId": "certPk",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "certPk",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "certPk<font color='red'> *<\/font>",
                                   "fieldId": "BF045661-25F7-4414-B2D4-4F45CCA55620",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "certPk",
                                   "bind": "{certPk}"
                              }, {
                                   "name": "empId",
                                   "itemId": "empId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Employee",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Employee<font color='red'> *<\/font>",
                                   "fieldId": "ED0AA345-5CFA-42E4-8AB4-5E0A60B7C764",
                                   "restURL": "EmpInformation",
                                   "bindable": "empId",
                                   "columnWidth": 0.5,
                                   "bind": "{empId}"
                              }, {
                                   "name": "certCode",
                                   "itemId": "certCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Certification",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.CertificateTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Certification<font color='red'> *<\/font>",
                                   "fieldId": "967BC314-32F0-436A-B69A-F561B5E4EB7B",
                                   "restURL": "CertificateType",
                                   "bindable": "certCode",
                                   "columnWidth": 0.5,
                                   "bind": "{certCode}"
                              }, {
                                   "name": "grdCode",
                                   "itemId": "grdCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Grade",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.GradeTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Grade<font color='red'> *<\/font>",
                                   "fieldId": "60B347C9-2381-4932-894B-D03553043805",
                                   "restURL": "GradeType",
                                   "bindable": "grdCode",
                                   "columnWidth": 0.5,
                                   "bind": "{grdCode}"
                              }, {
                                   "name": "obtainedDuration",
                                   "itemId": "obtainedDuration",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Obtained Duration",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Obtained Duration<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "754AC204-7C94-480C-9A9D-A902338FF7C2",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "obtainedDuration",
                                   "columnWidth": 0.5,
                                   "bind": "{obtainedDuration}"
                              }, {
                                   "name": "instituteName",
                                   "itemId": "instituteName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Institute Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Institute Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "48E50A2D-62C1-4F67-A280-D708ACCCAB51",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "instituteName",
                                   "columnWidth": 0.5,
                                   "bind": "{instituteName}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "24F55460-9AED-4DAF-AF83-9BD1330321EF",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Document List",
                         "title": "Document List",
                         "name": "DocumentList",
                         "itemId": "DocumentListForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
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
                                        "name": "docTypeCode",
                                        "itemId": "docTypeCode",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Doc Type Code",
                                        "margin": "5 5 5 5",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Testl.testl.shared.com.model.documentboundedcontext.documentmanager.DocumentTypeModel"
                                        },
                                        "allowBlank": false,
                                        "fieldLabel": "Doc Type Code<font color='red'> *<\/font>",
                                        "fieldId": "752647AF-F3D6-46C4-871B-A9DE53F5F8F9",
                                        "restURL": "DocumentType",
                                        "bindable": "documentList.docTypeCode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "docName",
                                        "itemId": "docName",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Doc Name",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Doc Name<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "D9AF22C0-0E00-45E3-858C-9B30AE4256CF",
                                        "minLength": "0",
                                        "maxLength": "512",
                                        "errorMessage": "Please enter valid Document Name",
                                        "bindable": "documentList.docName",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "docFile",
                                        "itemId": "docFile",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Doc File",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Doc File<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "1D7EC24E-AB5F-4E63-9CD6-70521E37651A",
                                        "minLength": "0",
                                        "maxLength": "128",
                                        "bindable": "documentList.docFile",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "docDesc",
                                        "itemId": "docDesc",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Doc Desc",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Doc Desc",
                                        "fieldId": "2F275FC5-4C24-427F-B926-F82AFDE662DF",
                                        "bindable": "documentList.docDesc",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "docDate",
                                        "itemId": "docDate",
                                        "xtype": "datefield",
                                        "customWidgetType": "vdDatefield",
                                        "displayName": "Doc Date",
                                        "margin": "5 5 5 5",
                                        "format": "d-m-Y",
                                        "submitFormat": "d-m-Y",
                                        "fieldLabel": "Doc Date",
                                        "fieldId": "B98ACC50-CB18-4849-A485-E0D771BA2C9A",
                                        "bindable": "documentList.docDate",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 187,
                              "text": "Add DocumentList",
                              "handler": "addDocumentList"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "DocumentList",
                              "columnWidth": 1,
                              "itemId": "DocumentListGrid",
                              "fieldLabel": "List",
                              "bindLevel": "documentList",
                              "bindable": "documentList",
                              "listeners": {
                                   "select": "onDocumentListGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Doc Id",
                                   "text": "Doc Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "docId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Doc Type Code",
                                   "text": "Doc Type Code",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "docTypeCode",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Doc Name",
                                   "text": "Doc Name",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "docName",
                                   "flex": 1
                              }, {
                                   "header": "Doc File",
                                   "text": "Doc File",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "docFile",
                                   "flex": 1
                              }, {
                                   "header": "Doc Desc",
                                   "text": "Doc Desc",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "docDesc",
                                   "flex": 1
                              }, {
                                   "header": "Doc Date",
                                   "text": "Doc Date",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "docDate",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
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
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "viewModel": "CertificationDetailsViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Certification Details",
                    "title": "Details Grid",
                    "name": "CertificationDetailsGrid",
                    "itemId": "CertificationDetailsGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "certPk",
                         "dataIndex": "certPk",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Employee",
                         "dataIndex": "empId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Certification",
                         "dataIndex": "certCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Grade",
                         "dataIndex": "grdCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Obtained Duration",
                         "dataIndex": "obtainedDuration",
                         "flex": 1
                    }, {
                         "header": "Institute Name",
                         "dataIndex": "instituteName",
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
               "displayName": "Certification Details",
               "name": "CertificationDetails",
               "itemId": "CertificationDetailsForm",
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
                              "name": "certPk",
                              "itemId": "certPk",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "certPk",
                              "margin": "5 5 5 5",
                              "fieldLabel": "certPk<font color='red'> *<\/font>",
                              "fieldId": "BF045661-25F7-4414-B2D4-4F45CCA55620",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "certPk",
                              "bind": "{certPk}"
                         }, {
                              "name": "empId",
                              "itemId": "empId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Employee",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Employee<font color='red'> *<\/font>",
                              "fieldId": "ED0AA345-5CFA-42E4-8AB4-5E0A60B7C764",
                              "restURL": "EmpInformation",
                              "bindable": "empId",
                              "columnWidth": 0.5,
                              "bind": "{empId}"
                         }, {
                              "name": "certCode",
                              "itemId": "certCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Certification",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.CertificateTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Certification<font color='red'> *<\/font>",
                              "fieldId": "967BC314-32F0-436A-B69A-F561B5E4EB7B",
                              "restURL": "CertificateType",
                              "bindable": "certCode",
                              "columnWidth": 0.5,
                              "bind": "{certCode}"
                         }, {
                              "name": "grdCode",
                              "itemId": "grdCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Grade",
                              "margin": "5 5 5 5",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.GradeTypeModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "Grade<font color='red'> *<\/font>",
                              "fieldId": "60B347C9-2381-4932-894B-D03553043805",
                              "restURL": "GradeType",
                              "bindable": "grdCode",
                              "columnWidth": 0.5,
                              "bind": "{grdCode}"
                         }, {
                              "name": "obtainedDuration",
                              "itemId": "obtainedDuration",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Obtained Duration",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Obtained Duration<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "754AC204-7C94-480C-9A9D-A902338FF7C2",
                              "minLength": "0",
                              "maxLength": "64",
                              "bindable": "obtainedDuration",
                              "columnWidth": 0.5,
                              "bind": "{obtainedDuration}"
                         }, {
                              "name": "instituteName",
                              "itemId": "instituteName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Institute Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Institute Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "48E50A2D-62C1-4F67-A280-D708ACCCAB51",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "instituteName",
                              "columnWidth": 0.5,
                              "bind": "{instituteName}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "24F55460-9AED-4DAF-AF83-9BD1330321EF",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Document List",
                    "title": "Document List",
                    "name": "DocumentList",
                    "itemId": "DocumentListForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
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
                                   "name": "docTypeCode",
                                   "itemId": "docTypeCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Doc Type Code",
                                   "margin": "5 5 5 5",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testl.testl.shared.com.model.documentboundedcontext.documentmanager.DocumentTypeModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "Doc Type Code<font color='red'> *<\/font>",
                                   "fieldId": "752647AF-F3D6-46C4-871B-A9DE53F5F8F9",
                                   "restURL": "DocumentType",
                                   "bindable": "documentList.docTypeCode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "docName",
                                   "itemId": "docName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Doc Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Doc Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D9AF22C0-0E00-45E3-858C-9B30AE4256CF",
                                   "minLength": "0",
                                   "maxLength": "512",
                                   "errorMessage": "Please enter valid Document Name",
                                   "bindable": "documentList.docName",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "docFile",
                                   "itemId": "docFile",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Doc File",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Doc File<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "1D7EC24E-AB5F-4E63-9CD6-70521E37651A",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "bindable": "documentList.docFile",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "docDesc",
                                   "itemId": "docDesc",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Doc Desc",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Doc Desc",
                                   "fieldId": "2F275FC5-4C24-427F-B926-F82AFDE662DF",
                                   "bindable": "documentList.docDesc",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "docDate",
                                   "itemId": "docDate",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Doc Date",
                                   "margin": "5 5 5 5",
                                   "format": "d-m-Y",
                                   "submitFormat": "d-m-Y",
                                   "fieldLabel": "Doc Date",
                                   "fieldId": "B98ACC50-CB18-4849-A485-E0D771BA2C9A",
                                   "bindable": "documentList.docDate",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 187,
                         "text": "Add DocumentList",
                         "handler": "addDocumentList"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "DocumentList",
                         "columnWidth": 1,
                         "itemId": "DocumentListGrid",
                         "fieldLabel": "List",
                         "bindLevel": "documentList",
                         "bindable": "documentList",
                         "listeners": {
                              "select": "onDocumentListGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Doc Id",
                              "text": "Doc Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "docId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Doc Type Code",
                              "text": "Doc Type Code",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "docTypeCode",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Doc Name",
                              "text": "Doc Name",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "docName",
                              "flex": 1
                         }, {
                              "header": "Doc File",
                              "text": "Doc File",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "docFile",
                              "flex": 1
                         }, {
                              "header": "Doc Desc",
                              "text": "Doc Desc",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "docDesc",
                              "flex": 1
                         }, {
                              "header": "Doc Date",
                              "text": "Doc Date",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "docDate",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
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
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "viewModel": "CertificationDetailsViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});