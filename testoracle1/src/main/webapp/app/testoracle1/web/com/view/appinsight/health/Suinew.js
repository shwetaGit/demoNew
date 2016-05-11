Ext.define('Testoracle1.testoracle1.web.com.view.appinsight.health.Suinew', {
     "xtype": "suinew",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "No",
          "margin": 5,
          "bindable": "tno",
          "name": "tno",
          "itemId": "textfield_ext_22408"
     }, {
          "xtype": "displayfield",
          "margin": 5,
          "bindable": "tnm",
          "style": "word-break: break-word; word-wrap: break-word;",
          "name": "tnm",
          "itemId": "displayfield_ext_22418"
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_22431",
          "listeners": {
               "click": "onButtonClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_22398",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Testoracle1.testoracle1.web.com.controller.appinsight.health.SuinewController", "Testoracle1.testoracle1.shared.com.viewmodel.appinsight.health.SuinewViewModel", "Testoracle1.testoracle1.shared.com.model.appinsight.health.SuinewModel"],
     "viewModel": "SuinewViewModel",
     "controller": "SuinewController"
});