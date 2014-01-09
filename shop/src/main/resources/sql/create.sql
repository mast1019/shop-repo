-- ===============================================================================
-- Jede SQL-Anweisung muss in genau 1 Zeile
-- Kommentare durch -- am Zeilenanfang
-- ===============================================================================

--
-- hibernate_sequence
--
DROP SEQUENCE hibernate_sequence;
CREATE SEQUENCE hibernate_sequence START WITH 5000;

--
-- CONSTRAINTS
--
ALTER TABLE LIEFERUNG ADD CONSTRAINT check_transportart CHECK (TRANSPORT_ART IN ('ST', 'SCH', 'L', 'W'));
ALTER TABLE KUNDE ADD CONSTRAINT check_geschlecht CHECK (GESCHLECHT IN(0,1));