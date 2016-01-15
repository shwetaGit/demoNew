Ext.define('Testproject1.view.databrowsercalendar.DBCalendar', {
	extend : 'Testproject1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testproject1.view.databrowsercalendar.DBCalendarController',
	             'Testproject1.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
