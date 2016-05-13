

ALTER TABLE ast_City_M ADD CONSTRAINT fk_4307ccd2f FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_f294af450 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;