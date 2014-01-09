-- ===============================================================================
-- Jede SQL-Anweisung muss in genau 1 Zeile
-- Kommentare durch -- am Zeilenanfang
-- ===============================================================================


--
-- adresse
--
INSERT INTO adresse (id, postleitzahl, strasse, hausnummer, stadt, erzeugt, aktualisiert) VALUES (200,'76133','Moltkestraﬂe', '30', 'Karlsruhe', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO adresse (id, postleitzahl, strasse, hausnummer, stadt, erzeugt, aktualisiert) VALUES (201,'76133','Moltkestraﬂe', '31', 'Karlsruhe', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO adresse (id, postleitzahl, strasse, hausnummer, stadt, erzeugt, aktualisiert) VALUES (202,'76133','Moltkestraﬂe', '32', 'Karlsruhe', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO adresse (id, postleitzahl, strasse, hausnummer, stadt, erzeugt, aktualisiert) VALUES (203,'76133','Moltkestraﬂe', '33', 'Karlsruhe', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO adresse (id, postleitzahl, strasse, hausnummer, stadt, erzeugt, aktualisiert) VALUES (204,'76133','Moltkestraﬂe', '34', 'Karlsruhe', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO adresse (id, postleitzahl, strasse, hausnummer, stadt, erzeugt, aktualisiert) VALUES (205,'76133','Moltkestraﬂe', '35', 'Karlsruhe', '01.10.2013 00:00:00','01.10.2013 00:00:00');

--
-- kunde
--
INSERT INTO kunde (id, nachname, vorname, adresse_fk, art, email, geschlecht, password, erzeugt, aktualisiert) VALUES (100,'Admin','Admin', 200, 'F', 'admin@hs-karlsruhe.de', null, 'passwort', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO kunde (id, nachname, vorname, adresse_fk, art, email, geschlecht, password, erzeugt, aktualisiert) VALUES (101,'Admin','Admin', 201, 'F', 'admin@hs-karlsruhe.de', null, 'passwort', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO kunde (id, nachname, vorname, adresse_fk, art, email, geschlecht, password, erzeugt, aktualisiert) VALUES (102,'Admin','Admin', 202, 'F', 'admin@hs-karlsruhe.de', null, 'passwort', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO kunde (id, nachname, vorname, adresse_fk, art, email, geschlecht, password, erzeugt, aktualisiert) VALUES (103,'Admin','Admin', 203, 'P', 'admin@hs-karlsruhe.de', 0, 'passwort', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO kunde (id, nachname, vorname, adresse_fk, art, email, geschlecht, password, erzeugt, aktualisiert) VALUES (104,'Admin','Admin', 204, 'P', 'admin@hs-karlsruhe.de', 0, 'passwort', '01.10.2013 00:00:00','01.10.2013 00:00:00');
INSERT INTO kunde (id, nachname, vorname, adresse_fk, art, email, geschlecht, password, erzeugt, aktualisiert) VALUES (105,'Admin','Admin', 205, 'P', 'admin@hs-karlsruhe.de', 1, 'passwort', '01.10.2013 00:00:00','01.10.2013 00:00:00');


--
-- artikel
--
INSERT INTO artikel (id, name, beschreibung, preis, gewicht, ausgesondert, erzeugt, aktualisiert) VALUES (300,'Fahrrad','Super schnell',100,10,0,'01.10.2013 00:00:00','07.10.2013 00:00:00');
INSERT INTO artikel (id, name, beschreibung, preis, gewicht, ausgesondert, erzeugt, aktualisiert) VALUES (301,'Fahrrad','gut und g¸nstig',200,11,0,'02.10.2013 00:00:00','08.10.2013 00:00:00');
INSERT INTO artikel (id, name, beschreibung, preis, gewicht, ausgesondert, erzeugt, aktualisiert) VALUES (302,'Fahrrad','Typ C',300,12,0,'03.10.2013 00:00:00','09.10.2013 00:00:00');
INSERT INTO artikel (id, name, beschreibung, preis, gewicht, ausgesondert, erzeugt, aktualisiert) VALUES (303,'Fahrrad','Typ D',400,13,0,'04.10.2013 00:00:00','10.10.2013 00:00:00');
INSERT INTO artikel (id, name, beschreibung, preis, gewicht, ausgesondert, erzeugt, aktualisiert) VALUES (304,'Fahrrad','Typ E',500,14,0,'05.10.2013 00:00:00','11.10.2013 00:00:00');
INSERT INTO artikel (id, name, beschreibung, preis, gewicht, ausgesondert, erzeugt, aktualisiert) VALUES (305,'Fahrrad','Typ F',600,15,0,'06.10.2013 00:00:00','12.10.2013 00:00:00');

--
-- bestellung
--
INSERT INTO bestellung (bestellnummer, kunde_fk, bpk, ausgeliefert, erzeugt, aktualisiert) VALUES (400, 100, 0, 0, '01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellung (bestellnummer, kunde_fk, bpk, ausgeliefert, erzeugt, aktualisiert) VALUES (401, 101, 0, 0, '01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellung (bestellnummer, kunde_fk, bpk, ausgeliefert, erzeugt, aktualisiert) VALUES (402, 102, 0, 0, '01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellung (bestellnummer, kunde_fk, bpk, ausgeliefert, erzeugt, aktualisiert) VALUES (403, 103, 0, 0, '01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellung (bestellnummer, kunde_fk, bpk, ausgeliefert, erzeugt, aktualisiert) VALUES (404, 104, 0, 0, '01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO bestellung (bestellnummer, kunde_fk, bpk, ausgeliefert, erzeugt, aktualisiert) VALUES (405, 104, 0, 0, '01.08.2006 00:00:00','01.08.2006 00:00:00');

--
-- posten
--
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (500,400,300,1,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (501,400,301,4,'01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (502,401,302,5,'02.08.2006 00:00:00','02.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (503,402,303,3,'03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (504,402,304,2,'03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (505,403,305,1,'04.08.2006 00:00:00','04.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (506,404,300,5,'05.08.2006 00:00:00','05.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (507,404,301,2,'05.08.2006 00:00:00','05.08.2006 00:00:00');
INSERT INTO posten (id, bestellung_fk, artikel_fk, anzahl, erzeugt, aktualisiert) VALUES (508,404,302,8,'05.08.2006 00:00:00','05.08.2006 00:00:00');

--
-- lieferung
--
INSERT INTO lieferung (id, transport_art, erzeugt, aktualisiert) VALUES (600,'ST','01.08.2006 00:00:00','01.08.2006 00:00:00');
INSERT INTO lieferung (id, transport_art, erzeugt, aktualisiert) VALUES (601,'SCH','02.08.2006 00:00:00','02.08.2006 00:00:00');
INSERT INTO lieferung (id, transport_art, erzeugt, aktualisiert) VALUES (602,'L','03.08.2006 00:00:00','03.08.2006 00:00:00');
INSERT INTO lieferung (id, transport_art, erzeugt, aktualisiert) VALUES (603,'W','04.08.2006 00:00:00','04.08.2006 00:00:00');

--
-- bestellung_lieferung
--
INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (400,600);
INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (401,600);
INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (402,601);
INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (402,602);
INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (403,602);
INSERT INTO bestellung_lieferung (bestellung_fk, lieferung_fk) VALUES (404,603);
