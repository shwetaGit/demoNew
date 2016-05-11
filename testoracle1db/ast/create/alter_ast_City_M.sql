

ALTER TABLE ast_City_M ADD CONSTRAINT fk_19adefc9f FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_e0bd9117d FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;