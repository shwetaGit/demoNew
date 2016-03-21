Ext.define('Newol.newol.web.com.controller.defaultcontext.defaultdomain.TestUiController', {
     extend: 'Newol.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.TestUiController',
     onButtonClick: function(me, e, eOpts) {
          var jsonData = {};
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/FetchItemDetailsServiceWS/fetchItemDetails',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                         var responseData = responseText.response.data;
                         scope.sender.down('#textfield_ext_9201').setValue(responseData.itemName);
                         scope.sender.down('#numberfield_ext_9217').setValue(responseData.itemPrice);
                         var combo_ext_8266 = scope.sender.down('#combo_ext_8266');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_8266, '', 'brandName');
                         var combo_ext_8254 = scope.sender.down('#combo_ext_8254');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_8254, '', 'categoryName');
                         var combo_ext_8244 = scope.sender.down('#combo_ext_8244');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_8244, '', 'productName');
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     },
     onSaveClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#combo_ext_8244'), this.view.down('#combo_ext_8254'), this.view.down('#combo_ext_8266'), this.view.down('#textfield_ext_9201'), this.view.down('#numberfield_ext_9217'), this.view.down('#numberfield_ext_9236'), this.view.down('#fileupload_ext_9488')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.productId = this.view.down('#combo_ext_8244').getValue();
          jsonData.categoryId = this.view.down('#combo_ext_8254').getValue();
          jsonData.brandId = this.view.down('#combo_ext_8266').getValue();
          jsonData.itemName = this.view.down('#textfield_ext_9201').getValue();
          jsonData.itemPrice = this.view.down('#numberfield_ext_9217').getValue();
          jsonData.itemStock = this.view.down('#numberfield_ext_9236').getValue();
          jsonData.itemIcon = this.view.down('#fileupload_ext_9488').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Item/',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                         var responseData = responseText.response.data;
                         var Grid = scope.sender.down('#gridpanel_ext_10842');
                         Grid.store.setData(responseData);
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     },
     onResetClick: function(me, e, eOpts) {
          this.view.down('#combo_ext_8244').reset();
          this.view.down('#combo_ext_8254').reset();
          this.view.down('#combo_ext_8266').reset();
          this.view.down('#textfield_ext_9201').reset();
          this.view.down('#numberfield_ext_9217').reset();
          this.view.down('#numberfield_ext_9236').reset();
          this.view.down('#fileupload_ext_9488').reset();
     }
});