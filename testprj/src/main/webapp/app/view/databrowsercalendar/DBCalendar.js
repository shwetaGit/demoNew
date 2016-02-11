Ext.define('Testprj.view.databrowsercalendar.DBCalendar', {
	extend : 'Testprj.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testprj.view.databrowsercalendar.DBCalendarController',
	             'Testprj.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
