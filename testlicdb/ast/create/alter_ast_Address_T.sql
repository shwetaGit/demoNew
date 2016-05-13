

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_0305b93af FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_60834632d FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_fa1746c72 FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_f7283c4ed FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;