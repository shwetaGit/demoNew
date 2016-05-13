Ext.define('Testlic.view.appreportui.chart.GroupChartPanel', {
	extend : 'Ext.panel.Panel',
	requires:['Testlic.view.appreportui.chart.GroupChartPanelController',
	          'Testlic.view.appreportui.chart.ChartPanel'],
	controller:'groupChartPanelController',
	xtype : 'groupChartPanel',
	groupChartJson:null,
	//title:'GPanel',
	plugins: 'responsive',
	responsiveConfig: {
       portrait: {
    	   layout: {
    	        type: 'table',
    	        columns : 1,
    	        tableAttrs: {
    	        	 style: {
    	        		 width: "100%"
    	        	 }
    	        },
    	        tdAttrs : {
    	            align : 'center',
    	            valign : 'middle',
    	        }
    		}
        },
        landscape: {
        	layout: {
                type: 'table',
                //columns :2,
                tableAttrs: {
                	 style: {
                		 width: "100%"
                	 }
                },
                tdAttrs : {
                    align : 'center',
                    valign : 'middle',
                }
        	}
        }
    },
    margin:10,
	header:{
				hidden:true,
 	},
	style:{
                    background:"#f6f6f6",
                    "box-shadow": "0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);"
    },
	listeners:{
		afterrender:'grpChartPanelAfterRender'
	}
});