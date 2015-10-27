/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Oneee',

    extend: 'Oneee.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Oneee.view.mainleftmenutree.MainPanel':'Oneee.view.mobileview.login.LoginPage',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Oneee.view.login.LoginPage':'Oneee.view.mobileview.login.LoginPage',//'Oneee.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Oneee.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
