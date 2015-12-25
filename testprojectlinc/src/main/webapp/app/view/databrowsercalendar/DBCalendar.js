Ext.define('Testprojectlinc.view.databrowsercalendar.DBCalendar', {
	extend : 'Testprojectlinc.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testprojectlinc.view.databrowsercalendar.DBCalendarController',
	             'Testprojectlinc.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
