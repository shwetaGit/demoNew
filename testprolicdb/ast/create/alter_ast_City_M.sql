

ALTER TABLE ast_City_M ADD CONSTRAINT fk_a1e257ea0 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_2a9c2efed FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;