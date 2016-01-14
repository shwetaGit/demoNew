Ext.define('Testpro.view.databrowsercalendar.DBCalendar', {
	extend : 'Testpro.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testpro.view.databrowsercalendar.DBCalendarController',
	             'Testpro.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
