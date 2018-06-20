INSERT INTO addresses (address_id, city, street, postal, house, apartment) VALUES (1, 'Wroclaw','Wojrowicka', '54-436', '36', 26)
INSERT INTO addresses (address_id, city, street, postal, house, apartment) VALUES (2, 'Boleslawiec','Starzynskiego', '59-700', '74', 1)
INSERT INTO addresses (address_id, city, street, postal, house, apartment) VALUES (3, 'Warszawa','Pileckiego', '01-200', '32', 3)
INSERT INTO patients (patient_id, first_name, last_name, pesel, address_id) VALUES (1, 'Damian','Petryk', 87112608270, 1)
INSERT INTO patients (patient_id, first_name, last_name, pesel, address_id) VALUES (2, 'Anna','Kowal', 83112608270, 2)
INSERT INTO visits (visit_id, visit_date, patient_id) VALUES (1, TO_DATE( '2-12-2006', 'DD-MM-YYYY' ), 1)
INSERT INTO visits (visit_id, visit_date, patient_id) VALUES (2, TO_DATE( '3-11-2007', 'DD-MM-YYYY' ), 1)
INSERT INTO notes (note_id, note, note_date, visit_id) VALUES (2, 'test note',TO_DATE( '2-12-2006', 'DD-MM-YYYY'), 1)
INSERT INTO notes (note_id, note, note_date, visit_id) VALUES (1, 'test note',TO_DATE( '2-12-2006', 'DD-MM-YYYY'), 1)