

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_2c7db892c FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_6c0320b41 FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;