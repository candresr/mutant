#Prueba practica Mutant

## Overview: Alerta de Mutantes


*Autor: Cesar Andres Ramirez candresramirez@gmail.com*

*Fecha: 20/06/2021*

*Versión: 1.0*


### Depenencias Aplicacion:

- java 8
- maven 3.6
- H2 Database

### Instalación

- Compilacion y despliegue mutant, dentro de este directorio 

    * mvn clean instal
    * java -jar target/practical-test-0.0.1-SNAPSHOT.jar

1. CONTEXTO
-----------

Este documento describe la funcionalidad de la API Mutant el cual comprende los siguientes módulos:

1. Servicio Mutant
    * Se pueda detectar si un humano es mutante enviando la secuencia de ADN

2. Servicio stats
    * Las estadísticas de las verificaciones de ADN


2. CAPA DE DATOS
----------------

 |**Tabla**|**Llave primaria**|**Tabla Relacionada**|**Llave foránea**|**Descripción**|
 |--|--|--|--|--|
 |AVERAGE|Id|||Se guardan los ADN verificados por la api|
&nbsp;
&nbsp;

  |**Campo**        |**Seccion**      |**obligatoriedad**   |**Tipo Input**   |**Tipo Dato**   |**Campo Dependiente**   |**Observaciones**|
  |--|--|--|--|--|--|--|
  |id |mutant   |si |number| Integer|no||
  |countAdnMutant |mutant   |si |number| Integer|no||
  |countAdnHuman |mutant   |si |number| Integer|no||
  |ratio |mutant   |si |decimal| BigDecimal|no||
&nbsp;
&nbsp;

3. SERVICIOS
------------

  |Título                      | Buscar Adn Mutante|
  |--|--|
  |**Descripción**             | Consulta del adn de acuerdo a la matriz enviada|
  |**URL**                     |/mutant|
  |**Método**                  |POST|
  |**Url Params**              |N/A|
  |**Data Params / Entradas**  |{“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}|
  |**Respuesta / Salida**      |{"success": true,"message": "OK","status": "OK"}|
  |**Respuesta Error** |{"success": false,"message": "FAIL","status": "FORBIDDEN"}|
  |**Notas**	||

&nbsp;

  |Título                      | Estadisticas Adn mutante|
  |--|--|
  |**Descripción**             | Consulta de las estadisticas de ADN|
  |**URL**                     |/stats|
  |**Método**                  |GET|
  |**Url Params**              |N/A|
  |**Data Params / Entradas**  |N/A|
  |**Respuesta / Salida**      |{"data":[{"id": 1,"countAdnMutant": 4,"countAdnHuman": 41,"ratio": 0.09}],"success": true,"status": "OK"}|
  |**Respuesta Error** |{"success": false,"message": "FAIL","status": "FORBIDDEN"}|
  |**Notas**	||