Ext.define('Oneee.view.databrowsercalendar.DBCalendar', {
	extend : 'Oneee.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Oneee.view.databrowsercalendar.DBCalendarController',
	             'Oneee.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
