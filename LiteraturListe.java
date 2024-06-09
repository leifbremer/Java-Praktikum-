import java.util.HashMap;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Map;

/**
 * Eine Klasse, deren Instanzen Informationen über ein BuecherListe halten.
 * Dies könnte Teil einer größeren Anwendung sein, einer
 * Bibliothekssoftware beispielsweise.
 *
 * @author Leif Bremer, Nicolas Lyer
 * @version April 2024
 */
class LiteraturListe
{
    // konstante Klassenvariable, die unabhängig von Instanzen existiert
    private static final String DefaultFILE = "Literatur.json";

    // Instanzvariablen
    private HashMap<Integer,Unveroeffentlicht> literatur;
    
    private int keyValue =0;

    /**
     * default constructor
     * 
     */
    public LiteraturListe() throws Exception
    {
        this(DefaultFILE);
    }

    /**
     * constructor by reading literaturelist from JSON file.
     */
    public LiteraturListe(String filename) throws Exception
    {
        literatur = new HashMap<Integer, Unveroeffentlicht>();
        assert (filename != null && filename.contains(".json"));
        JSONParser parser = new JSONParser();
        JSONArray booksJSON = 
            (JSONArray) parser.parse(new java.io.FileReader(filename));
        for( Object obj: booksJSON){ 
            JSONObject jsonObject = (JSONObject) obj;
            String typ = (String) jsonObject.get("class");
            switch(typ){
                case "book":
                    literatur.put(keyValue++, new Buch(jsonObject));
                    break;
                
                case "unpublished":
                    literatur.put(keyValue++, new Unveroeffentlicht(jsonObject));
                    break;
                    
                case "misc":
                    literatur.put(keyValue++, new Website(jsonObject));
            }
        }
    }

    /**
     * Methode fuegeBuchHinzu
     *
     * nimmt Buchobjekt und fügt dieses der Liste hinzu.
     */
    public void fuegeBuchHinzu(Buch buch)
    {
        literatur.put(keyValue++, buch);
    }
    
    /**
     * Methode fuegeUnveroeffentlichtHinzu
     *
     * nimmt Unveroeffentlichtobjekt und fügt dieses der Liste hinzu.
     */
    public void fuegeUnveroeffentlichtHinzu(Unveroeffentlicht unver)
    {
        literatur.put(keyValue++, unver);
    }
    
    /**
     * Methode fuegeWebsiteHinzu
     *
     * nimmt Websiteobjekt und fügt dieses der Liste hinzu.
     */
    public void fuegeWebsiteHinzu(Website website)
    {
        literatur.put(keyValue++, website);
    }

    /**
     * Methode ausgeben
     * Gibt alle eingelesenen Literaturen nummeriert in einer Liste
     * in der Konsole aus
     */
    public void ausgeben()
    {
        System.out.println("Literaturliste:");
        for(int b: literatur.keySet()){
            System.out.println(""+(b+1));
            literatur.get(b).ausgeben();
        }
    }
}
