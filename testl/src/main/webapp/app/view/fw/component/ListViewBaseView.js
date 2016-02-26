
/********************************************************************************************************

 * File Name:-ListViewBaseView.js

 * Date Created:-29-Sept-2015

 * Author:- Shrikrishna

 * Purpose :-

 
 *********************************************************************************************************
 Version   |	Date Modified    |  	Author 	   |	Modifications	

 * 1.0			29-Sept-2015 			 Shrikrishna			
								
 *********************************************************************************************************/


Ext.define('Testl.view.fw.component.ListViewBaseView', {
     extend : 'Ext.form.Panel',
     requires : ["Testl.view.fw.frameworkController.ListViewBaseController"],
     controller : "ListViewBaseController",
     isListPanel : true,
     autoScroll: true,
     xtype : 'listViewBaseView',
	
	 items : [{
	        	 xtype :"panel",
	        	 itemId : "containerPanel",
	        	 autoScroll : true
	          },{
	        	 xtype : "button",
	        	 text : "Show More Results",
	        	 itemId : "showMoreButton",
	        	 hidden : true,
	        	 handler : "onShowMoreResultClick",
	        	 margin : "0 400 0 400"
	         }]
});