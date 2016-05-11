Ext.define('Testone.view.databrowsercalendar.DBCalendar', {
	extend : 'Testone.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testone.view.databrowsercalendar.DBCalendarController',
	             'Testone.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
