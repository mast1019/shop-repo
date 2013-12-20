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
-- Check-Constraints fuer Enums
--
ALTER TABLE lieferung ADD CONSTRAINT check_transporttype CHECK (TransportType IN ('ST', 'SCH', 'L', 'W'));
ALTER TABLE kunde ADD CONSTRAINT check_geschlecht CHECK (geschlecht IN ('M', 'W'));
