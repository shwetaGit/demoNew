Ext.define('Proj14mar.view.databrowsercalendar.DBCalendar', {
	extend : 'Proj14mar.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Proj14mar.view.databrowsercalendar.DBCalendarController',
	             'Proj14mar.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
