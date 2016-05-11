Ext.define('Testoracle1.testoracle1.web.com.controller.appinsight.health.SuinewController', {
     extend: 'Testoracle1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.SuinewController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_22408')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.ano = this.view.down('#textfield_ext_22408').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/DnewQDsWS/proDnewQDs',
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
                         scope.sender.down('#displayfield_ext_22418').setValue(responseData.tNm);
                    } else {
                         scope.sender.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    scope.sender.responseHandler(responseText);
               }
          }, scope);
     }
});