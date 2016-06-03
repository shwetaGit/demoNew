Ext.define('Testbp.view.databrowsercalendar.DBCalendar', {
	extend : 'Testbp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testbp.view.databrowsercalendar.DBCalendarController',
	             'Testbp.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
