
/********************************************************************************************************

 * File Name:-ListViewBaseController.js

 * Date Created:-29-Sept-2015

 * Author:- Shrikrishna

 * Purpose :-

 
 *********************************************************************************************************
 Version   |	Date Modified    |  	Author 	   |	Modifications	

 * 1.0			29-Sept-2015 			 Shrikrishna			
								
 *********************************************************************************************************/


Ext.define('Testprj.view.fw.frameworkController.ListViewBaseController', {
    extend: 'Testprj.view.fw.frameworkController.FrameworkViewController',
    alias : 'controller.ListViewBaseController',
    /**
		 * *******************Main Controller
		 * Functions********************************
		 */
    
    componentArray: [],
    templateDataStore: [],
    recordCount: -1,
    activeRecord: 0,
    PAGE_SIZE : 25,
    
    uiClass : null,

    init : function(){
   	if(this.view.templateConfig){
   		this.componentArray = new Array();	
   		this.setListData(this.view.templateConfig);
   	} else {
   		Ext.Msg.alert('Error', "List view panel rendering failed.");
   	}
   },
   
   setListData : function(templateConfig){

   	this.uiClass = templateConfig.uiClass;
		var jsonData = {};
		var scope = this.getView();
		Ext.Ajax.request({
			url : templateConfig.url,
			method : templateConfig.requestMethodType,
			sender : scope,
			jsonData : jsonData,
			success : function(response, scope) {
				var responseData = Ext.JSON
						.decode(response.responseText);
				scope.sender.controller
						.configForm(responseData);
			},
			failure : function(response, scope) {
			}
		}, scope);
	},
   
   configForm : function(responseData){
       if (this.componentArray == null) {
           this.componentArray = new Array();
      }
      responseData = responseData.response.data;
      for (var index = 0; index < responseData.length; index = index + this.PAGE_SIZE) {
           var item = {
                data: responseData.slice(index, index + this.PAGE_SIZE)
           }
           this.templateDataStore.push(item);
           this.recordCount++;
      }
      for (var index = 0; index < responseData.length; index++) {
           var component = Ext.create(this.uiClass,{
           	itemId : 'tempItemId'+index
           });
           
           var componentConfigData = responseData[index];
           component.controller.modifyComponents(componentConfigData);
           this.componentArray.push(component);
           // this.view.add(component);
      }
      
      for(var index = 0 ; index< this.PAGE_SIZE; index ++){
   	   
   	   if(this.componentArray[index]== null){
   		   	this.view.down('#showMoreButton').setText("No more result to display");
		 		this.view.down('#showMoreButton').setDisabled(true);
		 		break;
			 }
   	   
   	   this.view.down('#container').add(this.componentArray[index]);
      }
   },
   
	 getValues : function(){
		 var jsonData = [];
		 for (var index = 0; index < this.componentArray.length; index++) {
			 // if(this.componentArray[index].viewModel){
			 // jsonData.push(this.componentArray[index].getViewModel().getData());
			 // }
			 if(this.componentArray[index]){
				 jsonData.push(this.getData(this.componentArray[index]));
				 // jsonData.push(this.componentArray[index].getValues());
			}	
		 }
			return jsonData;
	   },
	    
	  onShowMoreResultClick : function(but){
		 but.setDisabled(true);
	     this.activeRecord++;
		 var counter = this.activeRecord * this.PAGE_SIZE;	
		 for(var index = counter ; index< counter+this.PAGE_SIZE; index ++){
   	   		
			 	if(this.componentArray[index]== null){
			 		but.setText("No more result to display");
			 		but.setDisabled(true);
			 		break;
				 }
			 	this.view.down('#container').add(this.componentArray[index]);
     	 }
		 
		 but.setDisabled(false);
		 if(this.templateDataStore[this.activeRecord+1] == null){
			 but.setText("No more result to display");
			 but.setDisabled(true);
		 }
	  }    
});