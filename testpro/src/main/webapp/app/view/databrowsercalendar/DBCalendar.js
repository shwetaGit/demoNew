Ext.define('Testpro.view.databrowsercalendar.DBCalendar', {
	extend : 'Testpro.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testpro.view.databrowsercalendar.DBCalendarController',
	             'Testpro.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
