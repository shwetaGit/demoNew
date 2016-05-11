Ext.define('Testse.view.fw.component.CustomCheckBoxGroup', {
    extend:'Ext.form.CheckboxGroup',
    xtype : 'customcheckboxgroup',
    
    getCmpValue : function(){
    	var value = this.getValue();
    	if(this.name && value[this.name])
    		return value[this.name];
    	return value ;
    }

});