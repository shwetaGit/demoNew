Ext.define('Testl.testl.web.com.controller.humanresourcecontext.payroll.SalStrucFinWiseMainController', {
     extend: 'Testl.view.fw.frameworkController.RegistrationGridViewController',
     alias: 'controller.SalStrucFinWiseMainController',
     init: function() {
          var form = this.view.down('#SalStrucFinWise');
          this.updateFormUI(form, 'Save', true);
          form.reset();
          if (this.view.disableDB != null && this.view.disableDB) {
               this.hideDataBrowser();
          } else {
               this.fetchData();
          }
          this.empIdLoad();
     },
     empIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/EmpInformation/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#empId');
                    scope.sender.controller.assignAllComboData(scope.sender, 'empId', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#countryId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     /*********************Main Controller Functions*********************************/
     updateFormUI: function(form, status, butText) {
          for (var index = 0; index < form.items.items.length; index++) {
               var item = form.items.items[index];
               if (item.xtype == 'form' || item.xtype == 'panel') {
                    this.updateFormUI(item, status);
               }
               if (item.isCompositeKey) {
                    if (status == 'Save') {
                         item.setDisabled(false);
                    } else if (status == 'Update') {
                         item.setDisabled(true);
                    }
               }
          }
          if (butText) {
               if (status == 'Save') {
                    form.down('#saveFormButton').setText('Save');
               } else if (status == 'Update') {
                    form.down('#saveFormButton').setText('Update');
               }
          }
     },
     refreshMainForm: function(but, data, method) {
          if (but != null) {
               this.resetForm(but);
          } else {
               var but = this.view.down('#resetFormButton');
               this.resetForm(but);
          }
          var formPanel = this.view.down('#SalStrucFinWise');
          this.updateFormUI(formPanel, 'Save', true); /** Adding data to tree and grid */
          if (data != null) {
               var grid = this.view.down('#SalStrucFinWiseGrid');
               if (method == 'PUT') {
                    if (!(data instanceof Object)) {
                         var data = {
                              'findKey': data
                         };
                    }
                    data = this.findRecordById(this.view.restURL, data);
                    grid.getSelectionModel().selected.items[0].data = data;
                    grid.reconfigure();
               } else {
                    grid.store.add(data);
               }
          }
     },
     onGridRefreshClick: function(event, toolEl, panelHeader) {
          this.fetchData();
     },
     onDeleteActionColumnClickMainGrid: function(grid, rowIndex) {
          var recordId = grid.store.data.items[rowIndex].data.primaryKey;
          me = this;
          Ext.MessageBox.confirm({
               title: 'Confirm',
               msg: 'Delete Record',
               buttons: Ext.MessageBox.YESNO,
               fn: function(clickedButtonId) {
                    if (clickedButtonId == 'yes') {
                         me.deleteRecord(recordId);
                    }
               },
               animateTarget: this,
               icon: Ext.MessageBox.QUESTION
          })
     },
     deleteRecord: function(recordId) {
          var restURL = this.view.restURL;
          var url = 'secure' + restURL + '/' + recordId;
          var jsonData = {};
          Ext.Ajax.request({
               url: url,
               method: 'DELETE',
               jsonData: jsonData,
               success: function(response, opts) {
                    if (response.status == 204) {
                         Ext.Msg.alert('Server Response', 'Record Deleted Sucessfully');
                         me.refreshMainForm();
                    } else {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                         responseData = Ext.JSON.decode(response.responseText);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
     resetForm: function(but) {
          but.up('form').reset();
     },
     onFilterClick: function(but, evt) {
          var currentObject = this.getView();
          var form = but.up('form');
          if (!form.isValid()) {
               return;
          }
          var searchData = this.getData(form);
          Ext.Ajax.request({
               url: 'secure' + currentObject.restURL + '/search',
               method: 'POST',
               maskEnable: true,
               maskEle: currentObject,
               view: currentObject,
               jsonData: Ext.JSON.encode(searchData),
               success: function(response, currentObject) {
                    var jsonRespone = Ext.JSON.decode(response.responseText);
                    if (jsonRespone.response.success) {
                         var jsonRespone = Ext.JSON.decode(response.responseText);
                         var data = jsonRespone.response.data;
                         var currentView = currentObject.view;
                         currentView.controller.setGridData(data);
                    }
               },
               failure: function(response, eopts) {
                    Ext.MessageBox.show({
                         title: 'Error',
                         msg: response.statusText,
                         icon: Ext.MessageBox.ERROR
                    });
               }
          });
     },
     fetchData: function() {
          var url = this.getView().restURL;
          var scope = this;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + url + '/findAll',
               method: 'GET',
               sender: scope,
               maskEnable: true,
               jsonData: {},
               success: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         var data = responseData.response.data;
                         var currentView = scope.sender.getView();
                         me.setGridData(data);
                         scope.sender.addCommunicationLog(response, true);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    scope.sender.addCommunicationLog(response, false);
                    var responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
               }
          }, scope);
     },
     /********************************Grid Controller Functions***********************************/
     onGridItemClick: function(me, record, item, index, e, eOpts) { /** Finding record by id */
          var primaryKey = record.data.primaryKey;
          jsonData = {
               'findKey': primaryKey
          }
          record.data = this.findRecordById(this.view.restURL, jsonData);
          var formPanel = this.getView().down('#SalStrucFinWise');
          this.modifyComponents(record.data, formPanel);
          this.updateFormUI(formPanel, 'Update', true);
     },
     onTriggerfieldChange: function(me) {
          var grid = me.up().up();
          var v;
          try {
               grid.store.filter('primaryDisplay', new RegExp(me.value, 'i'));
          } catch (e) {
               me.markInvalid('Invalid regular expression');
          }
     },
     renderFormValue: function(val, me) {
          store = this.view.up().down('#SalStrucFinWise').down('#' + me.column.dataIndex + '').store;
          if (store.data.length == 0) {
               return '';
          }
          var displayValue = store.findRecord('primaryKey', val).data.primaryDisplay;
          return displayValue != null ? displayValue : '';
     },
     setGridData: function(data) {
          var gridStore = this.view.down('#SalStrucFinWiseGrid').store;
          gridStore.removeAll();
          gridStore.setData(data);
          gridStore.sort('primaryDisplay', 'ASC');
     },
     /********************************Form Controller Functions***********************************/
     afterFormRender: function(view) {
          if (view.primaryKey != null) {
               this.findById(view.primaryKey);
          }
     },
     findById: function(primaryKey) {
          var me = this;
          var restURL = this.view.restURL;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/findById',
               method: 'POST',
               controller: me,
               jsonData: {
                    'findKey': primaryKey
               },
               success: function(response, request) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         request.controller.loadData(responseData);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
               }
          }, this);
     },
     loadData: function(responseData) {
          this.view.getViewModel().setData(responseData.response.data);
     },
     renderFormValue: function(value, metaData, record, row, col, store, gridView) {
          try {
               var comboStore = this.getView().down('#' + metaData.column.dataIndex).getStore();
               var index = comboStore.findExact('primaryKey', value);
               return comboStore.getAt(index).data.primaryDisplay;
          } catch (e) {
               return value;
          }
     },
     saveForm: function(but, evt) {
          var form = but.up('form');
          if (!form.isValid()) {
               return;
          }
          var jsonData = this.getData(form);
          var method;
          if (but.text == 'Save') {
               method = 'POST'
          } else if (but.text == 'Update') {
               method = 'PUT';
               jsonData.systemInfo = {
                    'activeStatus': 1
               }
          }
          restURL = this.view.restURL;
          var me = this;
          Ext.Ajax.request({
               url: 'secure' + restURL + '/',
               but: but,
               method: method,
               maskEnable: true,
               maskEle: form,
               jsonData: jsonData,
               success: function(response, opts) {
                    responseData = Ext.JSON.decode(response.responseText);
                    if (responseData.response.success) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                         me.refreshMainForm(but, responseData.response.data, opts.method);
                    } else if (!sessionTimeOutFlag) {
                         Ext.Msg.alert('Server Response', responseData.response.message);
                    }
               },
               failure: function(response, scope) {
                    Ext.Msg.alert('Server Response', response.statusText);
                    me.addCommunicationLog(response, false);
               }
          }, this);
     },
     resetForm: function(but) {
          var formPanel = but.up('form');
          formPanel.reset();
          formPanel.down('#saveFormButton').setText('Save');
     },
});