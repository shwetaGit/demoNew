Ext.define('Testbp.testbp.smartdevice.com.view.testbc.testingdomain.MReportUi', {
     "xtype": "mReportUi",
     "items": [{
          "xtype": "reportView",
          "name": "Stud",
          "title": "Stud Report",
          "isCustomReport": true,
          "reportWidgets": ["2", "3"],
          "refId": "A9E83F01-6EBD-4645-B375-942D2ECA3884",
          "margin": 5,
          "itemId": "reportView_ext_16735"
     }],
     "border": true,
     "autoScroll": false,
     "layout": "fit",
     "title": "Fit Layout",
     "margin": 5,
     "itemId": "panel_ext_16727",
     "dockedItems": [],
     "requires": ["Testbp.view.smartdevice.reportview.ReportMainView", "Testbp.testbp.smartdevice.com.controller.testbc.testingdomain.MReportUiController", "Testbp.testbp.shared.com.viewmodel.testbc.testingdomain.MReportUiViewModel", "Testbp.testbp.shared.com.model.testbc.testingdomain.MReportUiModel"],
     "extend": "Ext.panel.Panel",
     "viewModel": "MReportUiViewModel",
     "controller": "MReportUiController"
});