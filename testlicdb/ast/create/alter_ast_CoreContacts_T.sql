

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_70c9c52af FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_33e97ec39 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_0a8e3b096 FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_3dca3b39e FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;