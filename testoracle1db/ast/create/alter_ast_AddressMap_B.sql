

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_40307b29d FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_8ee93981b FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;