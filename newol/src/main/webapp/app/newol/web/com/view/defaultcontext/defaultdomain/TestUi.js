Ext.define('Newol.newol.web.com.view.defaultcontext.defaultdomain.TestUi', {
     "xtype": "testUi",
     "items": [{
          "xtype": "combo",
          "name": "productId",
          "margin": 5,
          "bindable": "productId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "product",
          "displayField": "productName",
          "valueField": "Product",
          "itemId": "combo_ext_8244",
          "isRelatedWith": "kpkalhimi",
          "store": {
               "model": "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.ProductModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "productName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Product/findAll",
                    "serviceId": "AD0548CF-7F7A-4603-B45A-F20DCB7FAA23",
                    "serviceOperationId": "F5C781E0-C58F-48BF-A7B1-EAABC64463B0",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "combo",
          "name": "categoryId",
          "margin": 5,
          "bindable": "categoryId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "category",
          "displayField": "categoryName",
          "valueField": "Category",
          "itemId": "combo_ext_8254",
          "isRelatedWith": "kpkalhimi",
          "store": {
               "model": "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.CategoryModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "categoryName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Category/findAll",
                    "serviceId": "54EC3BEA-7AC2-466A-A1CF-4E48DC8CF4B7",
                    "serviceOperationId": "04E3A419-A621-4307-8085-162F0C568411",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "combo",
          "name": "brandId",
          "margin": 5,
          "bindable": "brandId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "brand",
          "displayField": "brandName",
          "valueField": "Brand",
          "itemId": "combo_ext_8266",
          "isRelatedWith": "kpkalhimi",
          "store": {
               "model": "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.BrandModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "brandName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Brand/findAll",
                    "serviceId": "3BA17D23-EDF6-4583-A221-41D994F8C10A",
                    "serviceOperationId": "7AFCCC01-9D7B-46C1-9BCD-DFC7E496AA4C",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "textfield",
          "fieldLabel": "itemName",
          "margin": 5,
          "bindable": "itemName",
          "name": "itemName",
          "itemId": "textfield_ext_9201"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "itemPrice",
          "name": "itemPrice",
          "margin": 5,
          "bindable": "itemPrice",
          "itemId": "numberfield_ext_9217"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "itemStock",
          "name": "itemStock",
          "margin": 5,
          "bindable": "itemStock",
          "itemId": "numberfield_ext_9236"
     }, {
          "items": [{
               "name": "filePathHidden",
               "xtype": "hidden",
               "itemId": "filePathHidden"
          }, {
               "title": "itemIcon",
               "xtype": "fileupload",
               "name": "itemIcon",
               "border": 2,
               "margin": 5,
               "bindable": "itemIcon",
               "itemId": "fileupload_ext_9488"
          }]
     }, {
          "xtype": "button",
          "name": "Save",
          "text": "Save",
          "margin": 5,
          "itemId": "button_ext_9595",
          "listeners": {
               "click": "onSaveClick"
          }
     }, {
          "xtype": "button",
          "text": "Reset",
          "isResetButton": true,
          "margin": 5,
          "name": "Reset",
          "itemId": "button_ext_9822",
          "listeners": {
               "click": "onResetClick"
          }
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_10323",
          "listeners": {
               "click": "onButtonClick"
          }
     }, {
          "xtype": "grids",
          "name": "Grid",
          "title": "Grid",
          "hiddenName": "Grid",
          "margin": 5,
          "collapseMode": "header",
          "border": true,
          "editTools": false,
          "features": [],
          "plugins": [{
               "ptype": "cellediting",
               "clicksToEdit": 1
          }],
          "columns": [{
               "xtype": "gridcolumn",
               "header": "itemId",
               "hidden": true,
               "dataIndex": "itemId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "productId",
               "dataIndex": "productId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "categoryId",
               "dataIndex": "categoryId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "brandId",
               "dataIndex": "brandId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "itemName",
               "dataIndex": "itemName",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "itemPrice",
               "dataIndex": "itemPrice",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "itemStock",
               "dataIndex": "itemStock",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "itemIcon",
               "dataIndex": "itemIcon",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "createdBy",
               "hidden": true,
               "dataIndex": "createdBy",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "createdDate",
               "hidden": true,
               "dataIndex": "createdDate",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "updatedBy",
               "hidden": true,
               "dataIndex": "updatedBy",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "updatedDate",
               "hidden": true,
               "dataIndex": "updatedDate",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "versionId",
               "hidden": true,
               "dataIndex": "versionId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "activeStatus",
               "hidden": true,
               "dataIndex": "activeStatus",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "txnAccessCode",
               "hidden": true,
               "dataIndex": "txnAccessCode",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "primaryDisplay",
               "hidden": true,
               "dataIndex": "primaryDisplay",
               "flex": 1
          }],
          "itemId": "gridpanel_ext_10842",
          "isRelatedWith": "egbjholmi",
          "store": {
               "model": "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.ItemModel",
               "autoLoad": true,
               "autoSync": true,
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Item/findAll",
                    "serviceId": "28994DB0-A367-4A32-9886-C4C97327CE77",
                    "serviceOperationId": "93050D04-17DD-4969-9C2A-57808D6B55A3",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          },
          "tools": [{
               "type": "refresh",
               "tooltip": "Refresh Grid Data",
               "handler": "onGridRefreshClick"
          }]
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_8236",
     "dockedItems": [],
     "requires": ["Newol.newol.shared.com.model.shoppingcontext.onlineshopping.ProductModel", "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.CategoryModel", "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.BrandModel", "Newol.newol.shared.com.model.shoppingcontext.onlineshopping.ItemModel", "Newol.newol.web.com.controller.defaultcontext.defaultdomain.TestUiController", "Newol.newol.shared.com.viewmodel.defaultcontext.defaultdomain.TestUiViewModel", "Newol.newol.shared.com.model.defaultcontext.defaultdomain.TestUiModel", "Newol.view.fw.component.FileUploadComponent", "Newol.view.fw.component.Grids"],
     "extend": "Ext.form.Panel",
     "viewModel": "TestUiViewModel",
     "controller": "TestUiController"
});