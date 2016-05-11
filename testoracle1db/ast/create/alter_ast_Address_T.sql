

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_5c8ab67ea FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_4b66e35b7 FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_68bc1523a FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_4134f6d03 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;