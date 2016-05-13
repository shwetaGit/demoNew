

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_15dd9eae9 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_629ace5c1 FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;