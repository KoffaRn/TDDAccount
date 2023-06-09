# Projektrapport
Kristoffer Larsson

##Beskrivning av projektet
Ett projekt för att göra en klass som kan hantera insättning och uttag samt testa detta med Junit.
###Arbetet och dess genomförande
Själva klassen och testerna var inte så svåra. Jag använde BigDecimal för att kunna ha så stora nummer som möjligt. Har gjort en liknande klass innan så hade lite pejl på vad som kan vara bra att kolla efter, t.ex. negativ balans, null-värden (i och med att BigDecimal kan vara null till skillnad från doouble), att inte kunna ta ut negativa värden, att inte kunna starta konton med negativ balans etc.
Jag valde att göra en egen exception type för detta (NegativeBalanceException) för jag hade en klasskompis som ville se hur man gjorde det.

###Vad som varit svårt
Var inte något som var särskilt svårt.

###Beskriv lite olika lösningar du gjort
Man hade som sagt kunnat använda double som är en primitiv typ istället för BigDecimal för att slippa null-värden, men vill minnas att jag läst/hört någonstans att BigDecimal alltid ska användas vid pengahantering.

##Slutsatser
##Vad gick bra
Fick ihop ett projekt ganska fort och testerna gick bra att skriva.
##Vad gick dåligt
Tror jag lyckades nå målen
##Vad har du lärt dig
Bättre koll på JUnit.
##Vilka möjligheter ser du med de kunskaper du fått under kursen.
Bra att se hur tester skrivs, svårt att tänka TDD när man redan har börjat tänka på hur själva metoderna ska fungera och tänker ut testerna utifrån det.
