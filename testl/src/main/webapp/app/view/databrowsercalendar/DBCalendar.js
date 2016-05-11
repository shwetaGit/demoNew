Ext.define('Testl.view.databrowsercalendar.DBCalendar', {
	extend : 'Testl.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testl.view.databrowsercalendar.DBCalendarController',
	             'Testl.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
