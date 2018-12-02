CQRS Usecase

constraints/invariant/condities

product weg, orderregel: productnaam, aantal, stuksprijs
1: restfull app, zonder regels
probleem: nieuwe constraint : niet meer dan 10 orderregels
Hoe kun je dit controleren als je losstaande orderregels kunt toevoegen? 
 

2: orderregels als list in order, met validatie op order
Op order kun je een validatie doen, en dus de max 10 regels validaren.
probleem: nieuwe constraint: max 1000 euro per order
Hoe kun je dat garanderen als je ook de order regels kunt aanpassen?

3: Gebruik Aggregates: Alleen een repository voor Order (en Klant), niet meer voor regels.
Nu is het niet meer mogelijk om een order in de database te plaatsen als de constraints niet gelden.
(niet meer hele order in json, maar createOrder, addRegel(orderId, aantal) etc)
Probleem: nieuwe verzoek: maak een rest call die het totaalbedrag van alle orders van dit jaar.
Om de data consistent te houden doen we alles via het domain model en de repositories die daar bij horen.
Het maken van het totaal bedrag is wel erg onnodig complex.

4: csrs
aparte read/write.
Voor de write gaat alles via het domain model en hierdoor garanderen we dat de aggregate consistent is/blijft.
Voor de read kunnen we een apart model maken (of meerder) die efficient de data uit de database haalt. 
Je kunt dan ook alleen teruggeven wat de UI wil hebben en niets meer. En snelle queries gebruiken hiervoor.   

 



Doel:
- Rest interface voor order systeem:
 - rest call's voor het aanmaken van een order
 - rest call voor het ophalen van alle gebruikers
 - rest call voor het ophalen van alle orders van een gebruiker
 - rest call voor ophalen totaal bedrag van alle orders
- Domein consistincy | bean validatie  
    - Een order mag niet meer dan 10 regels bevatten
    - Een order mag geen hoger bedrag zijn dan 1000 euro


REST API APPROACH:
- voorwaarde: alles via domain model, repository per class
- validatie lukt helemaal niet (of alleen bij opslaan van de regels)
- totaal bedrag : haal alle regels op (in zn geheel) en tel alles bij elkaar op.  

DDD APPROACH:
- voorwaarde: ddd domain model met aggregate root / geen repo voor regels, alleen voor klant,order, product
- validate gaat prima
- totaal bedrag: nu moeten we alle orders ophalen en alles optellen
- dit zou je kunnen optimaliseren:
    - voeg aantalregels en totaalbedrag veld toe aan de order, voor de JPA kun je lazy loading gebruiken zodat de count alleen alle orders hoeft op te halen en op te tellen
    
DDD + CQRS:
- als DDD, maar met read query met een enkele SQL statement.    
     

####################################################
Oplossings richting: Voor elk domein object een rest interface en een repository.


echo add user, bestelling en bestelregels
curl -X POST -H "Content-Type:application/json" -d "{\"id\":1, \"naam\":\"user1\"}" http://localhost:8080/klant
curl -X POST -H "Content-Type:application/json" -d "{\"id\":1, \"klantId\":1}" http://localhost:8080/bestelling
curl -X POST -H "Content-Type:application/json" -d "{\"id\":1, \"product\":\"tafel\",\"aantal\":1,\"stuksPrijs\":300,\"orderId\":1,\"price\":10}" http://localhost:8080/bestelregel
curl -X POST -H "Content-Type:application/json" -d "{\"id\":2, \"product\":\"stoel\",\"aantal\":2,\"stuksPrijs\":100,\"orderId\":1,\"price\":10}" http://localhost:8080/bestelregel
curl -X POST -H "Content-Type:application/json" -d "{\"id\":3, \"product\":\"barkruk\",\"aantal\":4,\"stuksPrijs\":100,\"orderId\":1,\"price\":10}" http://localhost:8080/bestelregel

echo verhoog prijs van barkruk
curl -X POST -H "Content-Type:application/json" -d "{\"id\":3, \"product\":\"barkruk\",\"aantal\":4,\"stuksPrijs\":200,\"orderId\":1,\"price\":10}" http://localhost:8080/bestelregel


echo return all order regels
curl http://localhost:8080/bestelregel/all


Nieuwe uitdaging:
Een bestelling mag nooit meer dan 3 bestelregels bevatten.

Probleem: 
Waar voeg je die validatie toe?
Dat kan nu alleen bij de bestelregels, terwijl de validatie over de bestelling gaat.
De resource is ook een rare plek, dit zou in het domain object (of een domein service) moeten zitten. Maar in de bestelregel domein object heb je geen toegang tot de database om de check te doen.
