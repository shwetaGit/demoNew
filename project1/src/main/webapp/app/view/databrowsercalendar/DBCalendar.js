Ext.define('Project1.view.databrowsercalendar.DBCalendar', {
	extend : 'Project1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Project1.view.databrowsercalendar.DBCalendarController',
	             'Project1.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
