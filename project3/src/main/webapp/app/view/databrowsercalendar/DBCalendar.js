Ext.define('Project3.view.databrowsercalendar.DBCalendar', {
	extend : 'Project3.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Project3.view.databrowsercalendar.DBCalendarController',
	             'Project3.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
