Ext.define('Testpro.testpro.web.com.view.defaultdomain.Testscreen', {
     "xtype": "testscreen",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "name",
          "margin": 5,
          "bindable": "name",
          "name": "name",
          "itemId": "mcfbapi"
     }, {
          "xtype": "textfield",
          "fieldLabel": "lastname",
          "margin": 5,
          "bindable": "lastname",
          "name": "lastname",
          "itemId": "ekbjlki"
     }, {
          "xtype": "datefield",
          "fieldLabel": "date",
          "name": "date",
          "bindable": "date",
          "margin": 5,
          "itemId": "idmhjmi",
          "submitFormat": "d-m-Y H:m:s"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "jadikei",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Testpro.testpro.web.com.controller.defaultdomain.TestscreenController", "Testpro.testpro.shared.com.viewmodel.defaultdomain.TestscreenViewModel", "Testpro.testpro.shared.com.model.defaultdomain.TestscreenModel"],
     "viewModel": "TestscreenViewModel",
     "controller": "TestscreenController"
});