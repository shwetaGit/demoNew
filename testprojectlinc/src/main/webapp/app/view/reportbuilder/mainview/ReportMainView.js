Ext.define('Testprojectlinc.view.reportbuilder.mainview.ReportMainView', {
	extend : 'Ext.panel.Panel',
    requires:[
             'Testprojectlinc.view.reportbuilder.reportlist.ReportListPanelView',
             'Testprojectlinc.view.reportbuilder.reportBuilder.ReportBuilderView',
             'Testprojectlinc.view.reportbuilder.mainview.ReportMainController'
             ],
    xtype: 'apps-reportview',
    itemId:'mainReportBuilderView',
    controller: 'reportMainController',
    layout: {
        type: 'border'
    },
    items:[
           	{
           		xtype:'reports-left-panel',
           		region:'west',
    		},
    		{ 
    			region : 'center',
    			xtype:'tabpanel', 		//No Ext.define Page is created for this tabpanel
    			itemId:'reportsTabPanel',
    			// Add default tab with view
    			items:[
    			       {
    			    	   title:'New Report',
    			    	   closable:true,
    			    	   xtype :'report-builder-panel',
    			    	   iconCls:'newTabIcon',
    			    	   reportName:'New Report',
    			    	   synopsis:'',
    			    	   help:'',
    			    	   displayType:0,
    			    	   queryId:'',
    			    	   jpqlQuery:'',
    			    	   queryJson:''
    			    	   
    			       }
    			],
    			bodyStyle:'background-image:url("resources/square.gif");',
    		}
    	]
});
