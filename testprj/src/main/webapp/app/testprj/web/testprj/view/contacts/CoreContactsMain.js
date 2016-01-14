Ext.define('Testprj.testprj.web.testprj.view.contacts.CoreContactsMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CoreContactsMainController",
     "restURL": "/CoreContacts",
     "defaults": {
          "split": true
     },
     "requires": ["Testprj.testprj.shared.testprj.model.contacts.CoreContactsModel", "Testprj.testprj.web.testprj.controller.contacts.CoreContactsMainController", "Testprj.testprj.shared.testprj.model.contacts.TitleModel", "Testprj.testprj.shared.testprj.model.location.LanguageModel", "Testprj.testprj.shared.testprj.model.contacts.GenderModel", "Testprj.view.fw.component.Grids", "Testprj.testprj.shared.testprj.model.contacts.CommunicationGroupModel", "Testprj.testprj.shared.testprj.model.contacts.CommunicationTypeModel", "Testprj.view.fw.component.Grids", "Testprj.testprj.shared.testprj.model.location.AddressTypeModel", "Testprj.testprj.shared.testprj.model.location.CountryModel", "Testprj.testprj.shared.testprj.model.location.StateModel", "Testprj.testprj.shared.testprj.model.location.CityModel", "Testprj.testprj.shared.testprj.viewmodel.contacts.CoreContactsViewModel"],
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
               "displayName": "Core Contacts",
               "name": "CoreContactsTreeContainer",
               "itemId": "CoreContactsTreeContainer",
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
                    "itemId": "CoreContactsTree",
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
                    "displayName": "Core Contacts",
                    "name": "CoreContacts",
                    "itemId": "CoreContactsForm",
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
                                   "name": "contactId",
                                   "itemId": "contactId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Contact Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                   "fieldId": "F2F595F5-069B-4046-972A-CD4D7296BE9D",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "contactId",
                                   "bind": "{contactId}"
                              }, {
                                   "name": "titleId",
                                   "itemId": "titleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Title",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Title<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "26B99004-C0AB-4E24-A31A-2660F4F0F7BA",
                                   "errorMessage": "Please enter title",
                                   "restURL": "Title",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.contacts.TitleModel"
                                   },
                                   "bindable": "titleId",
                                   "columnWidth": 0.5,
                                   "bind": "{titleId}"
                              }, {
                                   "name": "firstName",
                                   "itemId": "firstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "First Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "B7525042-0A35-40D2-B313-D2B7AAFFF132",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter First Name",
                                   "bindable": "firstName",
                                   "columnWidth": 0.5,
                                   "bind": "{firstName}"
                              }, {
                                   "name": "middleName",
                                   "itemId": "middleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Middle Name",
                                   "fieldId": "F8B9EE0C-3327-41C4-9131-9ECC28F6D5A9",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "middleName",
                                   "columnWidth": 0.5,
                                   "bind": "{middleName}"
                              }, {
                                   "name": "lastName",
                                   "itemId": "lastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Last Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Last Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "B7A54689-9239-48AD-992C-16F056C3B3F8",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Last Name",
                                   "bindable": "lastName",
                                   "columnWidth": 0.5,
                                   "bind": "{lastName}"
                              }, {
                                   "name": "nativeLanguageCode",
                                   "itemId": "nativeLanguageCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Language Code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Language Code",
                                   "fieldId": "73F819B2-897D-4D86-82ED-CB82D4BA4CCC",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Language",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.location.LanguageModel"
                                   },
                                   "bindable": "nativeLanguageCode",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeLanguageCode}"
                              }, {
                                   "name": "nativeTitle",
                                   "itemId": "nativeTitle",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Title",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Title",
                                   "fieldId": "4667141B-8290-4221-881E-545FF1FE5C16",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "bindable": "nativeTitle",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeTitle}"
                              }, {
                                   "name": "nativeFirstName",
                                   "itemId": "nativeFirstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native First Name",
                                   "fieldId": "B0F0394C-C29A-41F5-8490-3BDFCF63BC36",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeFirstName",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeFirstName}"
                              }, {
                                   "name": "nativeMiddleName",
                                   "itemId": "nativeMiddleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Middle Name",
                                   "fieldId": "321EC3B0-73A7-4564-946C-2F5411B11D52",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeMiddleName",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeMiddleName}"
                              }, {
                                   "name": "nativeLastName",
                                   "itemId": "nativeLastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native LastName",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native LastName",
                                   "fieldId": "530EF361-2E11-427C-A958-9FD2DD2FC999",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeLastName",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeLastName}"
                              }, {
                                   "name": "genderId",
                                   "itemId": "genderId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Gender",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Gender<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "EBDCF904-2620-4085-917E-E027C7BB0DA7",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Gender",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.contacts.GenderModel"
                                   },
                                   "bindable": "genderId",
                                   "columnWidth": 0.5,
                                   "bind": "{genderId}"
                              }, {
                                   "name": "dateofbirth",
                                   "itemId": "dateofbirth",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "DOB",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "DOB",
                                   "fieldId": "9200CBC4-FF2A-49AD-8120-8E6C0C03D5A5",
                                   "errorMessage": "Please enter Date of birth",
                                   "bindable": "dateofbirth",
                                   "columnWidth": 0.5,
                                   "bind": "{dateofbirth}",
                                   "format": "d-m-Y H:m:s",
                                   "submitFormat": "d-m-Y H:m:s"
                              }, {
                                   "name": "age",
                                   "itemId": "age",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Age",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Age",
                                   "fieldId": "B2C1A1F9-87C9-4340-84AF-13F79B7F0F00",
                                   "minValue": "0",
                                   "maxValue": "125",
                                   "bindable": "age",
                                   "columnWidth": 0.5,
                                   "bind": "{age}"
                              }, {
                                   "name": "approximateDOB",
                                   "itemId": "approximateDOB",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Approx DOB",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Approx DOB",
                                   "fieldId": "F9DDA524-A339-4042-8A86-8F75255DA013",
                                   "bindable": "approximateDOB",
                                   "columnWidth": 0.5,
                                   "bind": "{approximateDOB}",
                                   "format": "d-m-Y H:m:s",
                                   "submitFormat": "d-m-Y H:m:s"
                              }, {
                                   "name": "emailId",
                                   "itemId": "emailId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Email ID",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Email ID<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "3676C4F8-D849-46C9-9C1E-A3565450DD37",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Email ID",
                                   "bindable": "emailId",
                                   "columnWidth": 0.5,
                                   "bind": "{emailId}"
                              }, {
                                   "name": "phoneNumber",
                                   "itemId": "phoneNumber",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Phone Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "BA5FE9A0-DA35-4E94-A6C0-B5C451C629B5",
                                   "minLength": "0",
                                   "maxLength": "20",
                                   "errorMessage": "Please enter Phone Number",
                                   "bindable": "phoneNumber",
                                   "columnWidth": 0.5,
                                   "bind": "{phoneNumber}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "0018310E-B6FB-478A-A8DB-E1E2F7FAE4FB",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Communication Data",
                         "title": "Communication Data",
                         "name": "CommunicationData",
                         "itemId": "CommunicationDataForm",
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
                                        "name": "commGroupId",
                                        "itemId": "commGroupId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Group",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "D5A45943-0707-4846-B9FD-32DAB9EA4E2E",
                                        "restURL": "CommunicationGroup",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Testprj.testprj.shared.testprj.model.contacts.CommunicationGroupModel"
                                        },
                                        "bindable": "communicationData.commGroupId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCommGroupIdChange"
                                        }
                                   }, {
                                        "name": "commType",
                                        "itemId": "commType",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Type",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "C4911BEC-40E5-4470-9544-D0A67857F8F6",
                                        "restURL": "CommunicationType",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Testprj.testprj.shared.testprj.model.contacts.CommunicationTypeModel"
                                        },
                                        "bindable": "communicationData.commType",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "commData",
                                        "itemId": "commData",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Communication Data",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "321DE6E3-733C-4AE8-87FB-B49ABB4E2F17",
                                        "minLength": "0",
                                        "errorMessage": "please enter communication details",
                                        "bindable": "communicationData.commData",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 242,
                              "text": "Add CommunicationData",
                              "handler": "addCommunicationData"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "CommunicationData",
                              "columnWidth": 1,
                              "itemId": "CommunicationDataGrid",
                              "fieldLabel": "List",
                              "bindLevel": "communicationData",
                              "bindable": "communicationData",
                              "listeners": {
                                   "select": "onCommunicationDataGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "commType",
                                   "text": "commType",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commDataId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Communication Group",
                                   "text": "Communication Group",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commGroupId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Type",
                                   "text": "Communication Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commType",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Data",
                                   "text": "Communication Data",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commData",
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
                    }, {
                         "xtype": "form",
                         "displayName": "Address",
                         "title": "Address",
                         "name": "Address",
                         "itemId": "AddressForm",
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
                                        "name": "addressTypeId",
                                        "itemId": "addressTypeId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Address Type",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "049174CB-1513-4420-8464-65A45F813A6F",
                                        "errorMessage": "Please enter valid Address type",
                                        "restURL": "AddressType",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Testprj.testprj.shared.testprj.model.location.AddressTypeModel"
                                        },
                                        "bindable": "address.addressTypeId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "addressLabel",
                                        "itemId": "addressLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Label",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Label",
                                        "fieldId": "8DA1912D-7B40-4134-9CAE-9E4C7D9C421B",
                                        "minLength": "0",
                                        "maxLength": "11",
                                        "bindable": "address.addressLabel",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address1",
                                        "itemId": "address1",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address1",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address1",
                                        "fieldId": "9A3DC176-0C34-4CEE-B126-03DC07ADFFEA",
                                        "bindable": "address.address1",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address2",
                                        "itemId": "address2",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address2",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address2",
                                        "fieldId": "E94C03A9-87C5-49E6-9FE9-71F9BFD545DD",
                                        "bindable": "address.address2",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address3",
                                        "itemId": "address3",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address3",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address3",
                                        "fieldId": "10F151B5-475B-4C6D-8E37-ED040CF55C5D",
                                        "bindable": "address.address3",
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
                                        "fieldId": "CBF82F9C-AD3D-4E44-B8BA-383E6C995251",
                                        "errorMessage": "Please enter Country",
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
                                        "bindable": "address.countryId",
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
                                        "fieldId": "ACDA2509-7697-4974-9166-3E6473047A72",
                                        "errorMessage": "Please enter State",
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
                                        "bindable": "address.stateId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onStateIdChange"
                                        }
                                   }, {
                                        "name": "cityId",
                                        "itemId": "cityId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "City",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "City<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "AA015E0F-887F-4EC0-9011-8818658BC700",
                                        "errorMessage": "Please enter City",
                                        "restURL": "City",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Testprj.testprj.shared.testprj.model.location.CityModel"
                                        },
                                        "bindable": "address.cityId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "zipcode",
                                        "itemId": "zipcode",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Postal Code",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "18B7409C-746A-4CC2-8899-F95C5561F826",
                                        "minLength": "0",
                                        "maxLength": "6",
                                        "errorMessage": "Please enter postal code",
                                        "bindable": "address.zipcode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "latitude",
                                        "itemId": "latitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Latitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Latitude",
                                        "fieldId": "8FB56CA1-556D-42B1-9C14-299D0A0C8719",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.latitude",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "longitude",
                                        "itemId": "longitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Longitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Longitude",
                                        "fieldId": "2E112B79-5AB7-47F4-93FD-E2D269042496",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.longitude",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 132,
                              "text": "Add Address",
                              "handler": "addAddress"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "Address",
                              "columnWidth": 1,
                              "itemId": "AddressGrid",
                              "fieldLabel": "List",
                              "bindLevel": "address",
                              "bindable": "address",
                              "listeners": {
                                   "select": "onAddressGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Address Id",
                                   "text": "Address Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Address Type",
                                   "text": "Address Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressTypeId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Address Label",
                                   "text": "Address Label",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressLabel",
                                   "flex": 1
                              }, {
                                   "header": "Address1",
                                   "text": "Address1",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address1",
                                   "flex": 1
                              }, {
                                   "header": "Address2",
                                   "text": "Address2",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address2",
                                   "flex": 1
                              }, {
                                   "header": "Address3",
                                   "text": "Address3",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address3",
                                   "flex": 1
                              }, {
                                   "header": "Country",
                                   "text": "Country",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "countryId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "State",
                                   "text": "State",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "stateId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "City",
                                   "text": "City",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "cityId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Postal Code",
                                   "text": "Postal Code",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "zipcode",
                                   "flex": 1
                              }, {
                                   "header": "Latitude",
                                   "text": "Latitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "latitude",
                                   "flex": 1
                              }, {
                                   "header": "Longitude",
                                   "text": "Longitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "longitude",
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
                    }, {
                         "xtype": "form",
                         "displayName": "Timezone",
                         "title": "Timezone",
                         "name": "Timezone",
                         "itemId": "TimezoneForm",
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
                                        "name": "utcdifference",
                                        "itemId": "utcdifference",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "UTC Difference",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "UTC Difference<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "E89954FA-7FF2-4AE8-97E4-D6710C649D31",
                                        "minValue": "0",
                                        "maxValue": "11",
                                        "bindable": "timezone.utcdifference",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.utcdifference}"
                                   }, {
                                        "name": "gmtLabel",
                                        "itemId": "gmtLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "GMT",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "GMT",
                                        "fieldId": "0D8F4328-A9C2-4D3A-B603-0AC97133958C",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.gmtLabel",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.gmtLabel}"
                                   }, {
                                        "name": "timeZoneLabel",
                                        "itemId": "timeZoneLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Time Zone",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Time Zone",
                                        "fieldId": "0E2E98D9-E462-41C0-82E2-E2663CB3E4F0",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.timeZoneLabel",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.timeZoneLabel}"
                                   }, {
                                        "name": "country",
                                        "itemId": "country",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Country",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Country",
                                        "fieldId": "ABEC6B33-C8B3-4FF9-BB48-B5A28F8C54B2",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.country",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.country}"
                                   }, {
                                        "name": "cities",
                                        "itemId": "cities",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "City",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "City",
                                        "fieldId": "FA23D73E-C189-4624-BE19-E8E845CA6D00",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.cities",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.cities}"
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
                    "viewModel": "CoreContactsViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Core Contacts",
                    "title": "Details Grid",
                    "name": "CoreContactsGrid",
                    "itemId": "CoreContactsGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Contact Id",
                         "dataIndex": "contactId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Title",
                         "dataIndex": "titleId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "First Name",
                         "dataIndex": "firstName",
                         "flex": 1
                    }, {
                         "header": "Middle Name",
                         "dataIndex": "middleName",
                         "flex": 1
                    }, {
                         "header": "Last Name",
                         "dataIndex": "lastName",
                         "flex": 1
                    }, {
                         "header": "Native Language Code",
                         "dataIndex": "nativeLanguageCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Native Title",
                         "dataIndex": "nativeTitle",
                         "flex": 1
                    }, {
                         "header": "Native First Name",
                         "dataIndex": "nativeFirstName",
                         "flex": 1
                    }, {
                         "header": "Native Middle Name",
                         "dataIndex": "nativeMiddleName",
                         "flex": 1
                    }, {
                         "header": "Native LastName",
                         "dataIndex": "nativeLastName",
                         "flex": 1
                    }, {
                         "header": "Gender",
                         "dataIndex": "genderId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "DOB",
                         "dataIndex": "dateofbirth",
                         "flex": 1
                    }, {
                         "header": "Age",
                         "dataIndex": "age",
                         "flex": 1
                    }, {
                         "header": "Approx DOB",
                         "dataIndex": "approximateDOB",
                         "flex": 1
                    }, {
                         "header": "Email ID",
                         "dataIndex": "emailId",
                         "flex": 1
                    }, {
                         "header": "Phone Number",
                         "dataIndex": "phoneNumber",
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
               "displayName": "Core Contacts",
               "name": "CoreContacts",
               "itemId": "CoreContactsForm",
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
                              "name": "contactId",
                              "itemId": "contactId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Contact Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                              "fieldId": "F2F595F5-069B-4046-972A-CD4D7296BE9D",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "contactId",
                              "bind": "{contactId}"
                         }, {
                              "name": "titleId",
                              "itemId": "titleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Title",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Title<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "26B99004-C0AB-4E24-A31A-2660F4F0F7BA",
                              "errorMessage": "Please enter title",
                              "restURL": "Title",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.contacts.TitleModel"
                              },
                              "bindable": "titleId",
                              "columnWidth": 0.5,
                              "bind": "{titleId}"
                         }, {
                              "name": "firstName",
                              "itemId": "firstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "First Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "B7525042-0A35-40D2-B313-D2B7AAFFF132",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter First Name",
                              "bindable": "firstName",
                              "columnWidth": 0.5,
                              "bind": "{firstName}"
                         }, {
                              "name": "middleName",
                              "itemId": "middleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Middle Name",
                              "fieldId": "F8B9EE0C-3327-41C4-9131-9ECC28F6D5A9",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "middleName",
                              "columnWidth": 0.5,
                              "bind": "{middleName}"
                         }, {
                              "name": "lastName",
                              "itemId": "lastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Last Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Last Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "B7A54689-9239-48AD-992C-16F056C3B3F8",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Last Name",
                              "bindable": "lastName",
                              "columnWidth": 0.5,
                              "bind": "{lastName}"
                         }, {
                              "name": "nativeLanguageCode",
                              "itemId": "nativeLanguageCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Language Code",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Language Code",
                              "fieldId": "73F819B2-897D-4D86-82ED-CB82D4BA4CCC",
                              "errorMessage": "Please enter gender",
                              "restURL": "Language",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.location.LanguageModel"
                              },
                              "bindable": "nativeLanguageCode",
                              "columnWidth": 0.5,
                              "bind": "{nativeLanguageCode}"
                         }, {
                              "name": "nativeTitle",
                              "itemId": "nativeTitle",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Title",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Title",
                              "fieldId": "4667141B-8290-4221-881E-545FF1FE5C16",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "bindable": "nativeTitle",
                              "columnWidth": 0.5,
                              "bind": "{nativeTitle}"
                         }, {
                              "name": "nativeFirstName",
                              "itemId": "nativeFirstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native First Name",
                              "fieldId": "B0F0394C-C29A-41F5-8490-3BDFCF63BC36",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeFirstName",
                              "columnWidth": 0.5,
                              "bind": "{nativeFirstName}"
                         }, {
                              "name": "nativeMiddleName",
                              "itemId": "nativeMiddleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Middle Name",
                              "fieldId": "321EC3B0-73A7-4564-946C-2F5411B11D52",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeMiddleName",
                              "columnWidth": 0.5,
                              "bind": "{nativeMiddleName}"
                         }, {
                              "name": "nativeLastName",
                              "itemId": "nativeLastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native LastName",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native LastName",
                              "fieldId": "530EF361-2E11-427C-A958-9FD2DD2FC999",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeLastName",
                              "columnWidth": 0.5,
                              "bind": "{nativeLastName}"
                         }, {
                              "name": "genderId",
                              "itemId": "genderId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Gender",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Gender<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "EBDCF904-2620-4085-917E-E027C7BB0DA7",
                              "errorMessage": "Please enter gender",
                              "restURL": "Gender",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Testprj.testprj.shared.testprj.model.contacts.GenderModel"
                              },
                              "bindable": "genderId",
                              "columnWidth": 0.5,
                              "bind": "{genderId}"
                         }, {
                              "name": "dateofbirth",
                              "itemId": "dateofbirth",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "DOB",
                              "margin": "5 5 5 5",
                              "fieldLabel": "DOB",
                              "fieldId": "9200CBC4-FF2A-49AD-8120-8E6C0C03D5A5",
                              "errorMessage": "Please enter Date of birth",
                              "bindable": "dateofbirth",
                              "columnWidth": 0.5,
                              "bind": "{dateofbirth}",
                              "format": "d-m-Y H:m:s",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "name": "age",
                              "itemId": "age",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Age",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Age",
                              "fieldId": "B2C1A1F9-87C9-4340-84AF-13F79B7F0F00",
                              "minValue": "0",
                              "maxValue": "125",
                              "bindable": "age",
                              "columnWidth": 0.5,
                              "bind": "{age}"
                         }, {
                              "name": "approximateDOB",
                              "itemId": "approximateDOB",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Approx DOB",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Approx DOB",
                              "fieldId": "F9DDA524-A339-4042-8A86-8F75255DA013",
                              "bindable": "approximateDOB",
                              "columnWidth": 0.5,
                              "bind": "{approximateDOB}",
                              "format": "d-m-Y H:m:s",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "name": "emailId",
                              "itemId": "emailId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Email ID",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Email ID<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "3676C4F8-D849-46C9-9C1E-A3565450DD37",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Email ID",
                              "bindable": "emailId",
                              "columnWidth": 0.5,
                              "bind": "{emailId}"
                         }, {
                              "name": "phoneNumber",
                              "itemId": "phoneNumber",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Phone Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "BA5FE9A0-DA35-4E94-A6C0-B5C451C629B5",
                              "minLength": "0",
                              "maxLength": "20",
                              "errorMessage": "Please enter Phone Number",
                              "bindable": "phoneNumber",
                              "columnWidth": 0.5,
                              "bind": "{phoneNumber}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "0018310E-B6FB-478A-A8DB-E1E2F7FAE4FB",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Communication Data",
                    "title": "Communication Data",
                    "name": "CommunicationData",
                    "itemId": "CommunicationDataForm",
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
                                   "name": "commGroupId",
                                   "itemId": "commGroupId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Group",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D5A45943-0707-4846-B9FD-32DAB9EA4E2E",
                                   "restURL": "CommunicationGroup",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.contacts.CommunicationGroupModel"
                                   },
                                   "bindable": "communicationData.commGroupId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCommGroupIdChange"
                                   }
                              }, {
                                   "name": "commType",
                                   "itemId": "commType",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Type",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C4911BEC-40E5-4470-9544-D0A67857F8F6",
                                   "restURL": "CommunicationType",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.contacts.CommunicationTypeModel"
                                   },
                                   "bindable": "communicationData.commType",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "commData",
                                   "itemId": "commData",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Communication Data",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "321DE6E3-733C-4AE8-87FB-B49ABB4E2F17",
                                   "minLength": "0",
                                   "errorMessage": "please enter communication details",
                                   "bindable": "communicationData.commData",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 242,
                         "text": "Add CommunicationData",
                         "handler": "addCommunicationData"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "CommunicationData",
                         "columnWidth": 1,
                         "itemId": "CommunicationDataGrid",
                         "fieldLabel": "List",
                         "bindLevel": "communicationData",
                         "bindable": "communicationData",
                         "listeners": {
                              "select": "onCommunicationDataGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "commType",
                              "text": "commType",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commDataId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Communication Group",
                              "text": "Communication Group",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commGroupId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Type",
                              "text": "Communication Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commType",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Data",
                              "text": "Communication Data",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commData",
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
               }, {
                    "xtype": "form",
                    "displayName": "Address",
                    "title": "Address",
                    "name": "Address",
                    "itemId": "AddressForm",
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
                                   "name": "addressTypeId",
                                   "itemId": "addressTypeId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Address Type",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "049174CB-1513-4420-8464-65A45F813A6F",
                                   "errorMessage": "Please enter valid Address type",
                                   "restURL": "AddressType",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.location.AddressTypeModel"
                                   },
                                   "bindable": "address.addressTypeId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "addressLabel",
                                   "itemId": "addressLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Label",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Label",
                                   "fieldId": "8DA1912D-7B40-4134-9CAE-9E4C7D9C421B",
                                   "minLength": "0",
                                   "maxLength": "11",
                                   "bindable": "address.addressLabel",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address1",
                                   "itemId": "address1",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address1",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address1",
                                   "fieldId": "9A3DC176-0C34-4CEE-B126-03DC07ADFFEA",
                                   "bindable": "address.address1",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address2",
                                   "itemId": "address2",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address2",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address2",
                                   "fieldId": "E94C03A9-87C5-49E6-9FE9-71F9BFD545DD",
                                   "bindable": "address.address2",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address3",
                                   "itemId": "address3",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address3",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address3",
                                   "fieldId": "10F151B5-475B-4C6D-8E37-ED040CF55C5D",
                                   "bindable": "address.address3",
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
                                   "fieldId": "CBF82F9C-AD3D-4E44-B8BA-383E6C995251",
                                   "errorMessage": "Please enter Country",
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
                                   "bindable": "address.countryId",
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
                                   "fieldId": "ACDA2509-7697-4974-9166-3E6473047A72",
                                   "errorMessage": "Please enter State",
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
                                   "bindable": "address.stateId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onStateIdChange"
                                   }
                              }, {
                                   "name": "cityId",
                                   "itemId": "cityId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "City",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "City<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "AA015E0F-887F-4EC0-9011-8818658BC700",
                                   "errorMessage": "Please enter City",
                                   "restURL": "City",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Testprj.testprj.shared.testprj.model.location.CityModel"
                                   },
                                   "bindable": "address.cityId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "zipcode",
                                   "itemId": "zipcode",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Postal Code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "18B7409C-746A-4CC2-8899-F95C5561F826",
                                   "minLength": "0",
                                   "maxLength": "6",
                                   "errorMessage": "Please enter postal code",
                                   "bindable": "address.zipcode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "latitude",
                                   "itemId": "latitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Latitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Latitude",
                                   "fieldId": "8FB56CA1-556D-42B1-9C14-299D0A0C8719",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.latitude",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "longitude",
                                   "itemId": "longitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Longitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Longitude",
                                   "fieldId": "2E112B79-5AB7-47F4-93FD-E2D269042496",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.longitude",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 132,
                         "text": "Add Address",
                         "handler": "addAddress"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "Address",
                         "columnWidth": 1,
                         "itemId": "AddressGrid",
                         "fieldLabel": "List",
                         "bindLevel": "address",
                         "bindable": "address",
                         "listeners": {
                              "select": "onAddressGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Address Id",
                              "text": "Address Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Address Type",
                              "text": "Address Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressTypeId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Address Label",
                              "text": "Address Label",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressLabel",
                              "flex": 1
                         }, {
                              "header": "Address1",
                              "text": "Address1",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address1",
                              "flex": 1
                         }, {
                              "header": "Address2",
                              "text": "Address2",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address2",
                              "flex": 1
                         }, {
                              "header": "Address3",
                              "text": "Address3",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address3",
                              "flex": 1
                         }, {
                              "header": "Country",
                              "text": "Country",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "countryId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "State",
                              "text": "State",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "stateId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "City",
                              "text": "City",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "cityId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Postal Code",
                              "text": "Postal Code",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "zipcode",
                              "flex": 1
                         }, {
                              "header": "Latitude",
                              "text": "Latitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "latitude",
                              "flex": 1
                         }, {
                              "header": "Longitude",
                              "text": "Longitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "longitude",
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
               }, {
                    "xtype": "form",
                    "displayName": "Timezone",
                    "title": "Timezone",
                    "name": "Timezone",
                    "itemId": "TimezoneForm",
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
                                   "name": "utcdifference",
                                   "itemId": "utcdifference",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "UTC Difference",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "UTC Difference<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E89954FA-7FF2-4AE8-97E4-D6710C649D31",
                                   "minValue": "0",
                                   "maxValue": "11",
                                   "bindable": "timezone.utcdifference",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.utcdifference}"
                              }, {
                                   "name": "gmtLabel",
                                   "itemId": "gmtLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "GMT",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "GMT",
                                   "fieldId": "0D8F4328-A9C2-4D3A-B603-0AC97133958C",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.gmtLabel",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.gmtLabel}"
                              }, {
                                   "name": "timeZoneLabel",
                                   "itemId": "timeZoneLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Time Zone",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Time Zone",
                                   "fieldId": "0E2E98D9-E462-41C0-82E2-E2663CB3E4F0",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.timeZoneLabel",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.timeZoneLabel}"
                              }, {
                                   "name": "country",
                                   "itemId": "country",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Country",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Country",
                                   "fieldId": "ABEC6B33-C8B3-4FF9-BB48-B5A28F8C54B2",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.country",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.country}"
                              }, {
                                   "name": "cities",
                                   "itemId": "cities",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "City",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "City",
                                   "fieldId": "FA23D73E-C189-4624-BE19-E8E845CA6D00",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.cities",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.cities}"
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
               "viewModel": "CoreContactsViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});