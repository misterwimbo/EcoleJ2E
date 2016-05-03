CREATE DATABASE IF NOT EXISTS `Ecole_projet` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Ecole_Projet`;



DROP TABLE IF EXISTS `Classe`;
CREATE TABLE IF NOT EXISTS `Classe` (
`idClasse` int(11) NOT NULL,
  `Niveau` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  `Nom_Classe` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre_Eleves_Max` int(11) NOT NULL,
  `Ecole_idEcole` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `Coordonnees`;
CREATE TABLE IF NOT EXISTS `Coordonnees` (
`idAdresse` int(11) NOT NULL,
  `Adresse_1` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Adresse_2` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Code_Postal` int(11) DEFAULT NULL,
  `Ville` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Telephone_1` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Telephone_2` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=562 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `Ecole`;
CREATE TABLE IF NOT EXISTS `Ecole` (
`idEcole` int(11) NOT NULL,
  `Nom` varchar(45) NOT NULL,
  `Personne_idPersonne` int(11) NOT NULL,
  `Coordonnees_idAdresse` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Personne`;
CREATE TABLE IF NOT EXISTS `Personne` (
`idPersonne` int(11) NOT NULL,
  `Nom` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Prenom` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Sexe` char(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Date_Naissance` date DEFAULT NULL,
  `Statut` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1123 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

DROP TABLE IF EXISTS `Pers_Classe`;
CREATE TABLE IF NOT EXISTS `Pers_Classe` (
  `Classe_idClasse` int(11) DEFAULT NULL,
  `Personne_idPersonne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Pers_Coord`;
CREATE TABLE IF NOT EXISTS `Pers_Coord` (
  `Personne_idPersonne` int(11) DEFAULT NULL,
  `Coordonnees_idAdresse` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Prevenir`;
CREATE TABLE IF NOT EXISTS `Prevenir` (
  `Personne_idPersonne` int(11) NOT NULL,
  `Personne_idPersonne_2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

ALTER TABLE `Classe`
 ADD PRIMARY KEY (`idClasse`), ADD KEY `fk_Classe_Ecole1_idx` (`Ecole_idEcole`), ADD KEY `Ecole_idEcole` (`Ecole_idEcole`);

--
-- Index pour la table `Coordonnees`
--
ALTER TABLE `Coordonnees`
 ADD PRIMARY KEY (`idAdresse`);

--
-- Index pour la table `Ecole`
--
ALTER TABLE `Ecole`
 ADD PRIMARY KEY (`idEcole`), ADD KEY `Nom` (`Nom`), ADD KEY `Personne_idPersonne` (`Personne_idPersonne`,`Coordonnees_idAdresse`), ADD KEY `Coordonnees_idAdresse` (`Coordonnees_idAdresse`);

--
-- Index pour la table `Personne`
--
ALTER TABLE `Personne`
 ADD PRIMARY KEY (`idPersonne`), ADD KEY `Personne_Nom_idx` (`Nom`), ADD KEY `Nom` (`Nom`), ADD KEY `Nom_2` (`Nom`);

--
-- Index pour la table `Pers_Classe`
--
ALTER TABLE `Pers_Classe`
 ADD KEY `fk_Pers_Classe_Classe1_idx` (`Classe_idClasse`), ADD KEY `fk_Pers_Classe_Personne1_idx` (`Personne_idPersonne`);

--
-- Index pour la table `Pers_Coord`
--
ALTER TABLE `Pers_Coord`
 ADD KEY `fk_Personne_Personne1_idx` (`Personne_idPersonne`), ADD KEY `fk_Personne_Coordonnees1_idx` (`Coordonnees_idAdresse`);

--
-- Index pour la table `Prevenir`
--
ALTER TABLE `Prevenir`
 ADD KEY `fk_Prevenir_Personne1_idx` (`Personne_idPersonne`), ADD KEY `fk_Prevenir_Personne2_idx` (`Personne_idPersonne_2`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Classe`
--
ALTER TABLE `Classe`
MODIFY `idClasse` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT pour la table `Coordonnees`
--
ALTER TABLE `Coordonnees`
MODIFY `idAdresse` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=562;
--
-- AUTO_INCREMENT pour la table `Ecole`
--
ALTER TABLE `Ecole`
MODIFY `idEcole` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `Personne`
--
ALTER TABLE `Personne`
MODIFY `idPersonne` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1123;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Classe`
--
ALTER TABLE `Classe`
ADD CONSTRAINT `fk_Classe_Ecole1` FOREIGN KEY (`Ecole_idEcole`) REFERENCES `Ecole` (`idEcole`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `Ecole`
--
ALTER TABLE `Ecole`
ADD CONSTRAINT `fk_Ecole_Coordonnees1` FOREIGN KEY (`Coordonnees_idAdresse`) REFERENCES `Coordonnees` (`idAdresse`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Ecole_Personne1` FOREIGN KEY (`Personne_idPersonne`) REFERENCES `Personne` (`idPersonne`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Contraintes pour la table `Pers_Classe`
--
ALTER TABLE `Pers_Classe`
ADD CONSTRAINT `fk_Pers_Classe_Personne1` FOREIGN KEY (`Personne_idPersonne`) REFERENCES `Personne` (`idPersonne`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Pers_Classe_Classe1` FOREIGN KEY (`Classe_idClasse`) REFERENCES `Classe` (`idClasse`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Pers_Coord`
--
ALTER TABLE `Pers_Coord`
ADD CONSTRAINT `fk_Personne_Coordonnees1` FOREIGN KEY (`Coordonnees_idAdresse`) REFERENCES `Coordonnees` (`idAdresse`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Personne_Personne1` FOREIGN KEY (`Personne_idPersonne`) REFERENCES `Personne` (`idPersonne`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `Prevenir`
--
ALTER TABLE `Prevenir`
ADD CONSTRAINT `fk_Prevenir_Personne2` FOREIGN KEY (`Personne_idPersonne_2`) REFERENCES `Personne` (`idPersonne`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Prevenir_Personne1` FOREIGN KEY (`Personne_idPersonne`) REFERENCES `Personne` (`idPersonne`) ON DELETE CASCADE ON UPDATE CASCADE;


