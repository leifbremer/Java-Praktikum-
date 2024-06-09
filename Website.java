import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
/**
 * Klasse Website
 * 
 * Die Klasse Website ist eine Unterklasse von Unveroeffentlicht
 * und repräsentiert eine Website mit zusätzlichen Eigenschaften wie z.B.
 * dei Eigenschaft "howpublished"
 * 
 * @author (Leif Bremer, Nicolas Lyer) 
 * @version (09.06.2024)
 */
public class Website extends Unveroeffentlicht
{
    private String howpublished;
    
    /**
     * Website Konstruktor
     *
     * Erstellt eine neue Instanz für die Website
     * anhand des gegebenen JSON-Objekts.
     *
     * @param jsonObject Ein JSONObject, das die Website-Daten enthält.
     * @throws Exception Wenn ein Fehler
     * beim Parsen des JSON-Objekts auftritt.
     */
    public Website(String filename) throws Exception
    {
        super(filename);
    }
    
    /**
     * Website Konstruktor
     * 
     * Erstellt eine neue Instanz für die Website
     * anhand des gegebenen JSON-Objekts.
     * 
     * @param jsonObject Ein JSONObject, das die Website-Daten enthält.
     * @throws Exception Wenn ein Fehler
     * beim Parsen des JSON-Objekts auftritt.
     */
    public Website(JSONObject jsonObject) throws Exception {
        super(jsonObject);
    }
    
    /**
     * Methode fromJsonObject
     * 
     * Überträgt die Daten der Website aus einem JSONObject.
     *
     * @param jsonObject Ein JSONObject, das die Website-Daten enthält.
     * @throws Exception Wenn ein Fehler beim Parsen des JSON-Objekts auftritt.
     */
    @Override
    protected void fromJsonObject(JSONObject jsonObject) throws Exception
    {
        super.fromJsonObject(jsonObject);
        this.howpublished = (String) jsonObject.get("howpublished");
    }
    
    /**
     * Methode ausgeben
     *
     * Gibt die Details der Website auf der Konsole aus. 
     * Die schon gegebenen Eigeenschaften von Unveroeffentlicht +
     * howpublished.
     */
    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Link: "+howpublished);
    }
    
    /**
     * Methode bibString
     * 
     * Erstellt einen Eintrag nach BibTeX-Format für die Website.
     * @return Der String mit dem BibTeX-Eintrag.
     */
    @Override
    public String bibString()
    {
        return "@" + "misc" + "{" + citekey + ",\n" + 
        "author= \"" + autor + "\",\n" +
        "title= \"" + titel + "\",\n" + 
        "howpublished= \"" + howpublished + "\",\n" + 
        "year= \"" + jahr + "\",\n" + 
        "note= \"" + "none" + "\"" + "}";
    }
}