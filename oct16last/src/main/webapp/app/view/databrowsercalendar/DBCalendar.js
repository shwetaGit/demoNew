Ext.define('Oct16last.view.databrowsercalendar.DBCalendar', {
	extend : 'Oct16last.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Oct16last.view.databrowsercalendar.DBCalendarController',
	             'Oct16last.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
