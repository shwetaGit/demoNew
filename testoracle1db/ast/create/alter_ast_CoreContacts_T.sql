

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_b8d14c508 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_10527936c FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_9084ac1af FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_05b1e0b56 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;