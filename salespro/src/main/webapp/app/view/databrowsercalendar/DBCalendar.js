Ext.define('Salespro.view.databrowsercalendar.DBCalendar', {
	extend : 'Salespro.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Salespro.view.databrowsercalendar.DBCalendarController',
	             'Salespro.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
