import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
/**
 * Die Klasse Buch ist eine Unterklasse von Unveroeffentlicht
 * und repräsentiert ein Buch mit zusätzlichen Eigenschaften
 * wie Verlag, Adresse und ISBN.
 * 
 * @author (Leif Bremer, Nicolas Lyer) 
 * @version (09.06.2024)
 */
public class Buch extends Unveroeffentlicht
{
    private String publisher;
    private String address;
    private String isbn;

    /**
     * Buch Konstruktor
     *
     * Erstellt eine neue Buch-Instanz anhand des angegebenen Dateinamens.
     * 
     * @param filename Der Dateiname der JSON-Datei, die die Buch-Daten enthält.
     * @throws Exception Wenn ein Fehler beim Einlesen der Datei auftritt.
    */
    public Buch(String filename) throws Exception
    {
        super(filename);
    }

    /**
     * Buch Konstruktor
     *
     * Erstellt eine neue Buch-Instanz anhand des angegebenen JSON-Objekts.
     *
     * @param jsonObject Ein JSONObject, das die Buch-Daten enthält.
     * @throws Exception Wenn ein Fehler beim Parsen des JSON-Objekts auftritt.
     */
    public Buch(JSONObject jsonObject) throws Exception {
        super(jsonObject);
    }

    /**
     * Methode fromJsonObject
     *
     * Überträgt die Daten des Buches aus einem JSONObject.
     *
     * @param jsonObject Ein JSONObject, das die Website-Daten enthält.
     * @throws Exception Wenn ein Fehler beim Parsen des JSON-Objekts auftritt.r*/
    @Override
    protected void fromJsonObject(JSONObject jsonObject) throws Exception
    {
        super.fromJsonObject(jsonObject);
        this.publisher = (String) jsonObject.get("publisher");
        this.address = (String) jsonObject.get("address");
        this.isbn = (String) jsonObject.get("isbn");
    }

    /**
     * Methode ausgeben
     * 
     * Gibt die Details des Buches auf der Konsole aus.
     * Die schon gegebenen Eigeenschaften von Unveroeffentlicht +
     * publisher, Adresse und ISBN.

     */
    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Publizist: "+publisher+ ", Addresse: "+address+", ISBN: " +isbn);
    }
    
    /**
     * Methode bibString
     * 
     * Erstellt einen Eintrag nach BibTeX-Format für die Buch.
     * @return Der String mit dem BibTeX-Eintrag.
     */
    @Override
    public String bibString()
    {
        return "@" + "book" + "{" + citekey + ",\n" + 
        "author= \"" + autor + "\",\n" +
        "title= \"" + titel + "\",\n" +
        "publisher = \"" + publisher + "\",\n" +
        "address= \"" + address + "\",\n" +
        "year= \"" + jahr + "\"\n" + "}";
    }
}