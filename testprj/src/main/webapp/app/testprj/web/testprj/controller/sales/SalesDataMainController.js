Ext.define('Testprj.testprj.web.testprj.controller.sales.SalesDataMainController', {
     extend: 'Testprj.view.fw.frameworkController.AggregateViewController',
     alias: 'controller.SalesDataMainController',
     init: function() {
          var but = this.view.down('#resetFormButton');
          but.up('form').reset();
          if (this.view.disableDB != null && this.view.disableDB) {
               this.hideDataBrowser();
          } else {
               this.renderTreeGridData();
          }
          this.reatilercodeLoad();
          this.categoryLoad();
          this.brandcodeLoad();
          this.channelIdLoad();
     },
     reatilercodeLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Retailer/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#reatilercode');
                    scope.sender.controller.assignAllComboData(scope.sender, 'reatilercode', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#reatilercode');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     categoryLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Category/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#category');
                    scope.sender.controller.assignAllComboData(scope.sender, 'category', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#category');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     brandcodeLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Brand/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#brandcode');
                    scope.sender.controller.assignAllComboData(scope.sender, 'brandcode', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#brandcode');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     channelIdLoad: function() {
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Channel/findAll',
               method: 'GET',
               sender: scope,
               jsonData: {},
               success: function(response, scope) {
                    var compRef = scope.sender.down('#channelId');
                    scope.sender.controller.assignAllComboData(scope.sender, 'channelId', response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, compRef);
               },
               failure: function(response, scope) {
                    var compRef = scope.sender.down('#channelId');
                    scope.sender.controller.addCommunicationLog(response, false, compRef);
               }
          }, scope);
     },
     onBrandcodeChange: function(me, newValue, oldValue, eOpts) {
          this.onBrandcodeChangeMaterialcode(me, newValue, oldValue, eOpts);
     },
     onBrandcodeChangeMaterialcode: function(me, newValue, oldValue, eOpts) {
          var scope = this.getView();
          Ext.Ajax.request({
               async: false,
               url: 'secure/Material/findByBrandcode',
               method: 'POST',
               jsonData: {
                    findKey: newValue
               },
               sender: scope,
               element: me,
               success: function(response, scope) {
                    var materialcodeCombo = scope.element.up('form').down('#materialcode');
                    scope.sender.controller.assignComboData(materialcodeCombo, response.responseText);
                    scope.sender.controller.addCommunicationLog(response, true, materialcodeCombo);
               },
               failure: function(response, scope) {
                    scope.sender.controller.addCommunicationLog(response, false);
               }
          }, scope);
     },
     renderTreeGridData: function(responseData) {
          if (responseData == null) {
               responseData = this.fetchDataAjaxCall();
          }
          if (responseData.response.success) {
               var data = responseData.response.data;
               var tree = this.view.down('#SalesDataTree');
               var rootNode = tree.getRootNode();
               rootNode.removeAll();
               for (var index = 0; index < data.length; index++) {
                    var childNode = {
                         text: data[index].primaryDisplay,
                         bConfig: data[index],
                         leaf: true,
                         icon: 'images/table_icon.png'
                    };
                    rootNode.appendChild(childNode);
               }
               tree.getStore().sort('text', 'ASC');
               this.setGridData(data);
               var compRef = this.view.down('#SalesDataTree');
          } else if (!sessionTimeOutFlag) {
               Ext.Msg.alert('Server Response', responseData.response.message);
          }
     },
     /*********************Main Controller Functions*********************************/
     onDeleteActionColumnClickMainGrid: function(grid, rowIndex) {
          var recordId = grid.store.data.items[rowIndex].data.autoid;
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
          Ext.Ajax.request({
               url: url,
               method: 'DELETE',
               jsonData: {},
               success: function(response, opts) {
                    if (response.status == 204) {
                         Ext.Msg.alert('Server Response', 'Record Deleted Sucessfully');
                         me.refreshMainForm(but, responseData.response.data);
                    } else {
                         responseData = Ext.JSON.decode(response.responseText);
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
          var form = but.up('form');
          form.reset();
          var data = form.viewModel.getData();
          for (var element in data) {
               data[element] = '';
          }
     },
     hideDataBrowser: function() {
          var form = this.view.down('#SalesData');
          var grid = this.view.down('#SalesDataGrid');
          var tree = this.view.down('#SalesDataTreeContainer');
          this.view.down('#addNewForm').destroy();
          grid.setHidden(true);
          tree.setHidden(true);
          if (this.view.primaryKey != null) {
               this.findById(this.view.primaryKey);
          }
     },
     fetchDataAjaxCall: function() {
          var url = this.getView().restURL;
          var me = this;
          var data = null;
          Ext.Ajax.request({
               url: 'secure' + url + '/findAll',
               method: 'GET',
               maskEnable: true,
               async: false,
               jsonData: {},
               success: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    data = responseData;
                    me.addCommunicationLog(response, true);
               },
               failure: function(response, scope) {
                    var responseData = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseData.response.message);
                    me.addCommunicationLog(response, false);
               }
          }, this);
          return data;
     },
     onTreeRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          var tree = this.view.down('#SalesDataTree');
          var rootNode = tree.getRootNode();
          rootNode.removeAll();
          for (var index = 0; index < data.length; index++) {
               var childNode = {
                    text: data[index].primaryDisplay,
                    bConfig: data[index],
                    leaf: true,
                    icon: 'images/table_icon.png'
               };
               rootNode.appendChild(childNode);
          }
          tree.getStore().sort('text', 'ASC');
     },
     onGridRefreshClick: function(event, toolEl, panelHeader) {
          var responseData = this.fetchDataAjaxCall();
          var data = responseData.response.data;
          this.setGridData(data);
     },
     refreshMainForm: function(but, data) {
          if (but != null) {
               this.resetForm(but);
          } else {
               var but = this.view.down('#resetFormButton');
               this.resetForm(but);
          } /** Adding data to tree and grid */
          if (data != null && data instanceof Object) {
               var grid = this.view.down('#SalesDataGrid');
               grid.store.add(data);
               var tree = this.view.down('#SalesDataTree');
               var rootNode = tree.getRootNode();
               var childNode = {
                    text: data.primaryDisplay,
                    bConfig: data,
                    leaf: true,
                    icon: 'images/table_icon.png'
               };
               rootNode.appendChild(childNode);
          }
     },
     /********************************Tree Controller Functions**********************************/
     onFilterClick: function(but, evt) {
          var currentObject = this.getView();
          var data = but.up('form').getForm().getValues();
          var searchData = {};
          for (key in data) {
               if (data[key] != null && data[key] != '') {
                    searchData[key] = data[key];
               }
          }
          Ext.Ajax.request({
               url: 'secure' + currentObject.restURL + '/search',
               method: 'POST',
               maskEnable: true,
               maskEle: currentObject,
               view: currentObject,
               jsonData: Ext.JSON.encode(searchData),
               success: function(response, currentObject) {
                    currentObject.view.controller.renderTreeGridData(response);
               },
               failure: function(response, currentObject) {
                    Ext.MessageBox.show({
                         title: 'Error',
                         msg: response.statusText,
                         icon: Ext.MessageBox.ERROR
                    });
                    var currentView = currentObject.view;
                    var compRef = scope.sender.view.down('#SalesDataTree');
                    currentView.controller.addCommunicationLog(response, false, compRef);
               }
          });
     },
     treeClick: function(me, record, item, index, e, eOpts) {
          if (record.data.leaf) {
               var SalesData = this.view.down('#SalesDataForm');
               SalesData.reset();
               var gridPanel = this.view.down('#SalesDataGrid');
               var foundRecord = gridPanel.store.findRecord('primaryKey', record.data.bConfig.primaryKey);
               if (gridPanel && foundRecord) {
                    gridPanel.setSelection(foundRecord);
               }
          }
          var formPanel = this.getView().up().down('#SalesDataForm');
          var vm = formPanel.getViewModel(); /** Finding record by id */
          var data = this.findRecordById(this.view.restURL, record.data.bConfig.primaryKey);
          vm.setData(data);
          for (var key in data) {
               if (formPanel.down('#' + key) != null && (formPanel.down('#' + key).xtype == 'datefield' || formPanel.down('#' + key).xtype == 'customdatetimefield')) {
                    var res = data[key].replace(' ' + Ext.util.Cookies.get('XA_TID'), '');
                    var dt = Ext.Date.parse(res, 'd-j-Y H:i:s');
                    formPanel.down('#' + key).setValue(dt);
               }
          }
          this.showFirstCard(formPanel);
          tabPanel = formPanel.up('tabpanel');
          tabPanel.setActiveTab(0);
     },
     /********************************Grid Controller Functions***********************************/
     onGridItemClick: function(me, record, item, index, e, eOpts) { /** Finding record by id */
          record.data = this.findRecordById(this.view.restURL, record.data.primaryKey);
          var treePanel = this.view.up().up().down('#SalesDataTree');
          var foundNode = this.findChild(treePanel.getRootNode(), 'primaryKey', record.data.primaryKey);
          if (treePanel && foundNode) {
               treePanel.setSelection(foundNode);
          }
          var formPanel = this.getView().up().down('#SalesDataForm');
          var vm = formPanel.getViewModel();
          var data = record.data;
          vm.setData(data);
          for (var key in data) {
               if (formPanel.down('#' + key) != null && (formPanel.down('#' + key).xtype == 'datefield' || formPanel.down('#' + key).xtype == 'customdatetimefield')) {
                    var res = data[key].replace(' ' + Ext.util.Cookies.get('XA_TID'), '');
                    var dt = Ext.Date.parse(res, 'd-j-Y H:i:s');
                    formPanel.down('#' + key).setValue(dt);
               }
          }
          this.showFirstCard(formPanel);
          tabPanel = formPanel.up('tabpanel');
          tabPanel.setActiveTab(0);
     },
     renderFormValue: function(val, me) {
          store = this.view.up().down('#SalesData').down('#' + me.column.dataIndex + '').store;
          if (store.data.length == 0) {
               return '';
          }
          var displayValue = store.findRecord('primaryKey', val).data.primaryDisplay;
          return displayValue != null ? displayValue : '';
     },
     setGridData: function(data) {
          var gridStore = this.view.down('#SalesDataGrid').store;
          gridStore.removeAll();
          gridStore.add(data);
          gridStore.sort('primaryDisplay', 'ASC');
     },
     /********************************Form Controller Functions***********************************/
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
          this.view.down('#SalesDataForm').getViewModel().setData(responseData.response.data);
     },
     fetchDataFromStore: function(store) {
          storeItems = store.data.items;
          obj = {};
          arr = [];
          for (counter in storeItems) {
               arr.push(storeItems[counter].data);
          }
          return obj['objArr'] = arr;
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
          var firstCard = form.down('#form0');
          if (!firstCard.getForm().isValid()) {
               this.showCard(form, firstCard);
               return;
          }
          var jsonData = this.getData(form);
          var method;
          if (jsonData.autoid == null) {
               method = 'POST'
          } else {
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
                         me.refreshMainForm(but, responseData.response.data);
                         Ext.Msg.alert('Server Response', responseData.response.message);
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
});