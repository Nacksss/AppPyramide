--
-- Fichier g?n?r? par SQLiteStudio v3.3.3 sur jeu. nov. 18 22:07:06 2021
--
-- Encodage texte utilis? : System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table : Utilisateur
CREATE TABLE Utilisateur (Nom TEXT PRIMARY KEY, NombreDeParticipants INTEGER NOT NULL);
INSERT INTO Utilisateur (Nom, NombreDeParticipants) VALUES ('Jacque', 2);
INSERT INTO Utilisateur (Nom, NombreDeParticipants) VALUES ('Bob', 3);
INSERT INTO Utilisateur (Nom, NombreDeParticipants) VALUES ('Famille', 4);
INSERT INTO Utilisateur (Nom, NombreDeParticipants) VALUES ('Louis', 3);
INSERT INTO Utilisateur (Nom, NombreDeParticipants) VALUES ('Nico', 2);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
