# PricingEngine-Java-Jade-Jess
Proyecto para la clase de Inteligencia artificial donde reutilizo el ejemplo PricingEngine de Jess y lo adapto para cumplir con las especificaciones de mi maestro.

## Requisitos:
* Java
* JDK8
* Sistema de gestión de bases de datos MySQL o MariaDB

## Antes de Empezar: 
### Configuracion de conexion de Hibernate con la base de datos en MySQL o MariaDB
Configura el usuario y contraseña para acceder a tu base de datos en el archivo que se encuanetra en la ruta del proyecto [/src/hibernate.cfg.xml](https://github.com/yorologo/PricingEngine-Java-Jade-Jess/blob/master/src/hibernate.cfg.xml) 

### Codigo SQL para la base de datos en MySQL o MariaDB de la aplicacion
_Ejecutalo en tu motor de base de datos antes de ejecutar la aplicacion_
```sql 
CREATE DATABASE IF NOT EXISTS `Catalog` DEFAULT CHARACTER SET latin1 DEFAULT COLLATE latin1_swedish_ci;
USE `Catalog`;
DROP TABLE IF EXISTS `CatalogItem`;
CREATE TABLE IF NOT EXISTS `CatalogItem` (
        `partNumber` INT UNSIGNED NOT NULL AUTO_INCREMENT,
        `description` VARCHAR(255) NOT NULL,
        `price` DOUBLE PRECISION(10, 2) NOT NULL,
        `quantity` INTEGER(10) NOT NULL,
        PRIMARY KEY (`partNumber`)
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1 COLLATE = latin1_swedish_ci AUTO_INCREMENT = 1;

INSERT INTO CatalogItem(description, price, quantity) 
VALUES
("CDWriter"          ,  199.99 ,    206),
("CD-RWDisks"        ,  5.99   ,    184),
("AABatteries"       ,  4.99   ,    289),
("Gold-tippedcable"  ,  19.99  ,    288),
("Amplifier"         ,  399.99 ,    198),
("IncrediblesDVD"    ,  29.99  ,    368),
("iPhone11ProbyApple",  4200.99,    239),
("Note11bySamsung"   ,  2600.99,    18 ),
("MacBookAirbyApple" ,  1700.99,    394);
```
