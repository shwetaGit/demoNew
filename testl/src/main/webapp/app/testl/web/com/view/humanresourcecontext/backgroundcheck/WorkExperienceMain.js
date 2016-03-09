Ext.define('Testl.testl.web.com.view.humanresourcecontext.backgroundcheck.WorkExperienceMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "WorkExperienceMainController",
     "restURL": "/WorkExperience",
     "defaults": {
          "split": true
     },
     "requires": ["Testl.testl.shared.com.model.humanresourcecontext.backgroundcheck.WorkExperienceModel", "Testl.testl.web.com.controller.humanresourcecontext.backgroundcheck.WorkExperienceMainController", "Testl.testl.shared.com.model.humanresourcecontext.employee.EmpInformationModel", "Testl.view.fw.component.Grids", "Testl.testl.shared.com.model.documentboundedcontext.documentmanager.DocumentTypeModel", "Testl.testl.shared.com.viewmodel.humanresourcecontext.backgroundcheck.WorkExperienceViewModel"],
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
               "displayName": "Work Experience",
               "name": "WorkExperienceTreeContainer",
               "itemId": "WorkExperienceTreeContainer",
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
                    "itemId": "WorkExperienceTree",
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
                         "fieldId": "D7B70DD5-08FB-4864-A9E4-D0A5B066A468",
                         "restURL": "EmpInformation",
                         "bindable": "empId"
                    }, {
                         "name": "previousCompany",
                         "itemId": "previousCompany",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Previous Company",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Previous Company",
                         "fieldId": "247EE6A6-6376-41EB-8817-A8E477AA266A",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "previousCompany"
                    }, {
                         "name": "duration",
                         "itemId": "duration",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Duration",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Duration",
                         "fieldId": "C9299167-941E-4E32-8A98-F9597E31C4C0",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "duration"
                    }, {
                         "name": "immediateSupervisor",
                         "itemId": "immediateSupervisor",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Immediate Supervisor",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Immediate Supervisor",
                         "fieldId": "075863D7-DAB6-4F9F-84C8-B321C1A8EAFE",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "immediateSupervisor"
                    }, {
                         "name": "supervisorContactNo",
                         "itemId": "supervisorContactNo",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Supervisor Contact No",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Supervisor Contact No",
                         "fieldId": "D18B52CD-A3F1-4B13-9744-DBBBC2ECAD9E",
                         "minValue": "0",
                         "maxValue": "10",
                         "bindable": "supervisorContactNo"
                    }, {
                         "name": "worknResponsibilities",
                         "itemId": "worknResponsibilities",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Work And Responsibilities",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Work And Responsibilities",
                         "fieldId": "BC5438D8-9E3D-4008-A3A8-7C560952B181",
                         "bindable": "worknResponsibilities"
                    }, {
                         "name": "jobTitle",
                         "itemId": "jobTitle",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Job Title",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Job Title",
                         "fieldId": "422B5E3A-9FA4-4AD5-9EC2-0136DAA0E0E9",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "jobTitle"
                    }, {
                         "name": "reasonForLeaving",
                         "itemId": "reasonForLeaving",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Reason For Leaving",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Reason For Leaving",
                         "fieldId": "36005839-41A7-4FA3-89C4-9200BA92E270",
                         "bindable": "reasonForLeaving"
                    }, {
                         "name": "salaryPerAanum",
                         "itemId": "salaryPerAanum",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Salary Per Annum",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Salary Per Annum",
                         "fieldId": "DB738AC9-670D-41DE-BE50-FED2590FB3E7",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "salaryPerAanum"
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
                    "displayName": "Work Experience",
                    "name": "WorkExperience",
                    "itemId": "WorkExperienceForm",
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
                                   "name": "workPk",
                                   "itemId": "workPk",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "workPk",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "workPk<font color='red'> *<\/font>",
                                   "fieldId": "C227CC8E-D748-43FB-905F-1934D3113264",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "workPk",
                                   "bind": "{workPk}"
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
                                   "fieldId": "D7B70DD5-08FB-4864-A9E4-D0A5B066A468",
                                   "restURL": "EmpInformation",
                                   "bindable": "empId",
                                   "columnWidth": 0.5,
                                   "bind": "{empId}"
                              }, {
                                   "name": "previousCompany",
                                   "itemId": "previousCompany",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Previous Company",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Previous Company<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "247EE6A6-6376-41EB-8817-A8E477AA266A",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "previousCompany",
                                   "columnWidth": 0.5,
                                   "bind": "{previousCompany}"
                              }, {
                                   "name": "duration",
                                   "itemId": "duration",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Duration",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Duration<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C9299167-941E-4E32-8A98-F9597E31C4C0",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "bindable": "duration",
                                   "columnWidth": 0.5,
                                   "bind": "{duration}"
                              }, {
                                   "name": "immediateSupervisor",
                                   "itemId": "immediateSupervisor",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Immediate Supervisor",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Immediate Supervisor<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "075863D7-DAB6-4F9F-84C8-B321C1A8EAFE",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "bindable": "immediateSupervisor",
                                   "columnWidth": 0.5,
                                   "bind": "{immediateSupervisor}"
                              }, {
                                   "name": "supervisorContactNo",
                                   "itemId": "supervisorContactNo",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Supervisor Contact No",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Supervisor Contact No<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D18B52CD-A3F1-4B13-9744-DBBBC2ECAD9E",
                                   "minValue": "0",
                                   "maxValue": "10",
                                   "bindable": "supervisorContactNo",
                                   "columnWidth": 0.5,
                                   "bind": "{supervisorContactNo}"
                              }, {
                                   "name": "worknResponsibilities",
                                   "itemId": "worknResponsibilities",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Work And Responsibilities",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Work And Responsibilities<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "BC5438D8-9E3D-4008-A3A8-7C560952B181",
                                   "bindable": "worknResponsibilities",
                                   "columnWidth": 0.5,
                                   "bind": "{worknResponsibilities}"
                              }, {
                                   "name": "jobTitle",
                                   "itemId": "jobTitle",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Job Title",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Job Title<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "422B5E3A-9FA4-4AD5-9EC2-0136DAA0E0E9",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "bindable": "jobTitle",
                                   "columnWidth": 0.5,
                                   "bind": "{jobTitle}"
                              }, {
                                   "name": "reasonForLeaving",
                                   "itemId": "reasonForLeaving",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Reason For Leaving",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Reason For Leaving<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "36005839-41A7-4FA3-89C4-9200BA92E270",
                                   "bindable": "reasonForLeaving",
                                   "columnWidth": 0.5,
                                   "bind": "{reasonForLeaving}"
                              }, {
                                   "name": "salaryPerAanum",
                                   "itemId": "salaryPerAanum",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Salary Per Annum",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Salary Per Annum<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "DB738AC9-670D-41DE-BE50-FED2590FB3E7",
                                   "minLength": "0",
                                   "maxLength": "128",
                                   "bindable": "salaryPerAanum",
                                   "columnWidth": 0.5,
                                   "bind": "{salaryPerAanum}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "EA6CA361-4E01-4978-B997-918EB593DB78",
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
                    "viewModel": "WorkExperienceViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Work Experience",
                    "title": "Details Grid",
                    "name": "WorkExperienceGrid",
                    "itemId": "WorkExperienceGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "workPk",
                         "dataIndex": "workPk",
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
                         "header": "Previous Company",
                         "dataIndex": "previousCompany",
                         "flex": 1
                    }, {
                         "header": "Duration",
                         "dataIndex": "duration",
                         "flex": 1
                    }, {
                         "header": "Immediate Supervisor",
                         "dataIndex": "immediateSupervisor",
                         "flex": 1
                    }, {
                         "header": "Supervisor Contact No",
                         "dataIndex": "supervisorContactNo",
                         "flex": 1
                    }, {
                         "header": "Work And Responsibilities",
                         "dataIndex": "worknResponsibilities",
                         "flex": 1
                    }, {
                         "header": "Job Title",
                         "dataIndex": "jobTitle",
                         "flex": 1
                    }, {
                         "header": "Reason For Leaving",
                         "dataIndex": "reasonForLeaving",
                         "flex": 1
                    }, {
                         "header": "Salary Per Annum",
                         "dataIndex": "salaryPerAanum",
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
               "displayName": "Work Experience",
               "name": "WorkExperience",
               "itemId": "WorkExperienceForm",
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
                              "name": "workPk",
                              "itemId": "workPk",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "workPk",
                              "margin": "5 5 5 5",
                              "fieldLabel": "workPk<font color='red'> *<\/font>",
                              "fieldId": "C227CC8E-D748-43FB-905F-1934D3113264",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "workPk",
                              "bind": "{workPk}"
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
                              "fieldId": "D7B70DD5-08FB-4864-A9E4-D0A5B066A468",
                              "restURL": "EmpInformation",
                              "bindable": "empId",
                              "columnWidth": 0.5,
                              "bind": "{empId}"
                         }, {
                              "name": "previousCompany",
                              "itemId": "previousCompany",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Previous Company",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Previous Company<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "247EE6A6-6376-41EB-8817-A8E477AA266A",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "previousCompany",
                              "columnWidth": 0.5,
                              "bind": "{previousCompany}"
                         }, {
                              "name": "duration",
                              "itemId": "duration",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Duration",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Duration<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C9299167-941E-4E32-8A98-F9597E31C4C0",
                              "minLength": "0",
                              "maxLength": "128",
                              "bindable": "duration",
                              "columnWidth": 0.5,
                              "bind": "{duration}"
                         }, {
                              "name": "immediateSupervisor",
                              "itemId": "immediateSupervisor",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Immediate Supervisor",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Immediate Supervisor<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "075863D7-DAB6-4F9F-84C8-B321C1A8EAFE",
                              "minLength": "0",
                              "maxLength": "128",
                              "bindable": "immediateSupervisor",
                              "columnWidth": 0.5,
                              "bind": "{immediateSupervisor}"
                         }, {
                              "name": "supervisorContactNo",
                              "itemId": "supervisorContactNo",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Supervisor Contact No",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Supervisor Contact No<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "D18B52CD-A3F1-4B13-9744-DBBBC2ECAD9E",
                              "minValue": "0",
                              "maxValue": "10",
                              "bindable": "supervisorContactNo",
                              "columnWidth": 0.5,
                              "bind": "{supervisorContactNo}"
                         }, {
                              "name": "worknResponsibilities",
                              "itemId": "worknResponsibilities",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Work And Responsibilities",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Work And Responsibilities<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "BC5438D8-9E3D-4008-A3A8-7C560952B181",
                              "bindable": "worknResponsibilities",
                              "columnWidth": 0.5,
                              "bind": "{worknResponsibilities}"
                         }, {
                              "name": "jobTitle",
                              "itemId": "jobTitle",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Job Title",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Job Title<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "422B5E3A-9FA4-4AD5-9EC2-0136DAA0E0E9",
                              "minLength": "0",
                              "maxLength": "128",
                              "bindable": "jobTitle",
                              "columnWidth": 0.5,
                              "bind": "{jobTitle}"
                         }, {
                              "name": "reasonForLeaving",
                              "itemId": "reasonForLeaving",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Reason For Leaving",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Reason For Leaving<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "36005839-41A7-4FA3-89C4-9200BA92E270",
                              "bindable": "reasonForLeaving",
                              "columnWidth": 0.5,
                              "bind": "{reasonForLeaving}"
                         }, {
                              "name": "salaryPerAanum",
                              "itemId": "salaryPerAanum",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Salary Per Annum",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Salary Per Annum<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "DB738AC9-670D-41DE-BE50-FED2590FB3E7",
                              "minLength": "0",
                              "maxLength": "128",
                              "bindable": "salaryPerAanum",
                              "columnWidth": 0.5,
                              "bind": "{salaryPerAanum}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "EA6CA361-4E01-4978-B997-918EB593DB78",
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
               "viewModel": "WorkExperienceViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});