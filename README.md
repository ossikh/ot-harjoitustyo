# Ohjelmistotekniikka 2021 / ICT Hardware Manager

Ohjelman avulla voi pitää kirjaa ATK-komponenteista ja oheislaitteista.



## Dokumentaatio
[Käyttöohje](https://github.com/ossikh/ot-harjoitustyo/blob/master/dokumentaatio/kayttohje.md)

[Arkkitehtuurikuvaus](https://github.com/ossikh/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Vaatimusmäärittely](https://github.com/ossikh/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Tuntikirjanpito](https://github.com/ossikh/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Releaset
[Viikko 6](https://github.com/ossikh/ot-harjoitustyo/releases/tag/viikko6)  
[Viikko 5](https://github.com/ossikh/ot-harjoitustyo/releases/tag/viikko5)

### Asennus- ja testaustoiminnot

Ohjelman käynnistäminen onnistuu komennolla:
```
mvn compile exec:java -Dexec.mainClass=hardwaremanager.Hardman
```


Ohjelman paketointi suoritettavaksi jar-tiedostoksi onnistuu komennolla:
```
mvn package
```

Alihakemistoon _/target/_ luotu jar-tiedosto voidaan käynnistää komennolla:
```
java -jar hardwaremanager-1.0-SNAPSHOT.jar
```

Ohjelman testien suoritus onnistuu komennolla:
```
mvn test
```

Ohjelman JaCoCo -testikattavuusraportin luonti onnistuu komennolla:

```
mvn jacoco:report
```

Ohjelman checkstyle-tarkistukset voidaan suorittaa komennolla:
```
mvn jxr:jxr checkstyle:checkstyle
```

Javadoc voidaan luoda kommenolla:
```
mvn javadoc:javadoc
```
