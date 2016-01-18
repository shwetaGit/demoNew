Ext.define('Testone.testone.web.testone.view.defaultdomain.ReportView', {
     "xtype": "reportView",
     "items": [{
          "xtype": "panel",
          "items": [],
          "border": true,
          "layout": "fit",
          "title": "Fit Layout",
          "margin": 5,
          "itemId": "nphabhi"
     }, {
          "xtype": "reportview",
          "name": "Report",
          "title": "country",
          "reportWidgets": ["2", "3"],
          "refId": "26872148-4E64-46FA-BD2D-AD93BB691DF0",
          "margin": 5,
          "itemId": "pdkofai"
     }],
     "margin": 5,
     "border": true,
     "autoScroll": true,
     "title": "Panel",
     "itemId": "fjphhpi",
     "dockedItems": [],
     "requires": ["Testone.view.reportui.ReportView", "Testone.testone.web.testone.controller.defaultdomain.ReportViewController", "Testone.testone.shared.testone.viewmodel.defaultdomain.ReportViewViewModel", "Testone.testone.shared.testone.model.defaultdomain.ReportViewModel"],
     "extend": "Ext.panel.Panel",
     "viewModel": "ReportViewViewModel",
     "controller": "ReportViewController"
});