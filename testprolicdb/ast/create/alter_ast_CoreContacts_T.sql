

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_c4303fb10 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_4683227fa FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_1bff17621 FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_bfec00d30 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;