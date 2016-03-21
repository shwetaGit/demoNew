Ext.define('Newol.newol.web.com.view.shoppingcontext.onlineshopping.ItemCatalogue', {
     "xtype": "itemCatalogue",
     "name": "itemcatalogue",
     "items": [{
          "xtype": "listViewBaseView",
          "name": "items",
          "isListPanel": true,
          "autoScroll": true,
          "border": false,
          "layout": "column",
          "defaults": {
               "columnWidth": "1.0"
          },
          "templateConfig": {
               "uiId": "A8A17935-8603-4C0D-BE29-8B3FE71383F5",
               "uiClass": "Newol.newol.web.com.view.shoppingcontext.onlineshopping.ItemTemplate",
               "uiType": 2,
               "url": "secure/FetchItemDetailsServiceWS/fetchItemDetails",
               "requestMethodType": "POST"
          },
          "title": "Items",
          "padding": 0,
          "margin": 5,
          "itemId": "gpijmgi",
          "dockedItems": []
     }],
     "border": true,
     "autoScroll": true,
     "title": "Item Catalogue",
     "margin": 5,
     "itemId": "fioboci",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Newol.newol.web.com.controller.shoppingcontext.onlineshopping.ItemCatalogueController", "Newol.newol.shared.com.viewmodel.shoppingcontext.onlineshopping.ItemCatalogueViewModel", "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.ItemCatalogueModel", "Newol.view.fw.component.ListViewBaseView"],
     "viewModel": "ItemCatalogueViewModel",
     "controller": "ItemCatalogueController"
});