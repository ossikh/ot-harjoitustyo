# Käyttöohje:

Ohjelmaa käytetään tekstikäyttöliittymän avulla. Käyttöliittymä tarjoaa seuraavat toiminnot, joita pääsee käyttämään syöttämällä hakasuluissa ilmoitetun komennon ja painamalla rivinvaihtoa, eli Enter -näppäintä.

## Komennot:
`[1]` - Listaa kaikki järjestelmästä löytyvät komponentit  
`[2]` - Lisää järjestelmään komponentin. Jokaisen komponentin ominaisuuksiin kuuluu nimi (title), tyyppi (type) ja sijainti (location). Jokainen ominaisuus syötetään erikseen komponenttia lisättäessä.  
`[3]` - Haku nimen perusteella. Listaa kaikki komponentit joiden nimestä löytyy annettu teksti.  
`[4]` - Haku tyypin perusteella. Listaa kaikki komponentit joiden tyypissä on annettu teksti.  
`[5]` - Haku sijainnin perusteella. Listaa kaikki komponentit joiden sijainnista löytyy annettu teksti.  
`[M]` - Komponentin tietuiden muokkaus. Alivalikossa voi muokata minkä vain komponentin kaikkia tietoja halutusti.  
`[R]` - Poistaa komponentin. Poistaminen tapahtuu syöttämällä listauksessa annettu komponentin järjestysnumero.  
`[L]` - Komponenttilistan lataus tiedostosta. Ladattavan tiedoston nimi syötetään ohjelmaan.  
`[S]` - Komponenttilistan tallennus tiedostoon annetulla tiedostonimellä  
`[Q]` - Lopettaa ohjelman suorituksen.  
  
## Tiedoston automaattinen avaus ohjelman käynnistyksessä:
Tallennettu komponenttilistaus on mahdollista avata myös suoraan komentoriviparametrina ohjelmaa käynnistäessä. Ohjelma tallentaa ja lukee .hwm 
-tiedostoja, päätettä ei tule antaa syötteessä vaan se prosessoidaan automaattisesti. Esimerkiksi uudetkomponentit.hwm -tiedosto avautuisi seuraavasti:

`java -jar hardwaremanager-1.0-SNAPSHOT.jar uudetkomponentit`
