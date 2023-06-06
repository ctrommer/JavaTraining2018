package land;



// Als Hilfe: https://www.baeldung.com/mapstruct#Type
// Defaultwert f�r die Einwohnerzahl
// Datumsformat als: "dd-MM-yyyy HH:mm:ss"
// Testen mit:
// Rechte Maus auf zu testendes Projekt | Maven | Update Project...
// Rechte Maus auf Projekt | Run as | Maven clean install
// Die Unittests ausf�hren.

public interface CountryLandMapper {
	Land countryZuLand(Country country);
	Country landZuCountry(Land land);
}

