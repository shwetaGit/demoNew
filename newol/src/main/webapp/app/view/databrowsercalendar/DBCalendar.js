Ext.define('Newol.view.databrowsercalendar.DBCalendar', {
	extend : 'Newol.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Newol.view.databrowsercalendar.DBCalendarController',
	             'Newol.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
