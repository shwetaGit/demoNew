Ext.define('Testprolic.view.databrowsercalendar.DBCalendar', {
	extend : 'Testprolic.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testprolic.view.databrowsercalendar.DBCalendarController',
	             'Testprolic.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	/*listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}*/
});
