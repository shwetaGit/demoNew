Ext.define('Testse.view.databrowsercalendar.DBCalendar', {
	extend : 'Testse.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testse.view.databrowsercalendar.DBCalendarController',
	             'Testse.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
