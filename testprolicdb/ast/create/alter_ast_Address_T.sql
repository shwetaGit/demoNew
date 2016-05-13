

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_cb0da447a FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_1272c891c FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_25098854c FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_fca9247b0 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;