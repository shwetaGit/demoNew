Ext.define('Testbp.testbp.smartdevice.com.view.testbc.testingdomain.DpRUI', {
     "xtype": "dpRUI",
     "items": [{
          "xtype": "reportView",
          "name": "dp",
          "title": "Dp Report",
          "isCustomReport": true,
          "reportWidgets": ["1", "2", "3"],
          "refId": "4FE5AE1D-8579-4BD0-A604-9E9C84A438A7",
          "margin": 5,
          "itemId": "reportView_ext_18011"
     }],
     "border": true,
     "autoScroll": false,
     "layout": "fit",
     "title": "Fit Layout",
     "margin": 5,
     "itemId": "panel_ext_18001",
     "dockedItems": [],
     "requires": ["Testbp.view.smartdevice.reportview.ReportMainView", "Testbp.testbp.smartdevice.com.controller.testbc.testingdomain.DpRUIController", "Testbp.testbp.shared.com.viewmodel.testbc.testingdomain.DpRUIViewModel", "Testbp.testbp.shared.com.model.testbc.testingdomain.DpRUIModel"],
     "extend": "Ext.panel.Panel",
     "viewModel": "DpRUIViewModel",
     "controller": "DpRUIController"
});