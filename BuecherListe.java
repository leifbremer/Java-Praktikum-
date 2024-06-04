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
 * @author Wolfgang Renz
 * @version April 2024
 * der lauch
 */
class BuecherListe
{
    // konstante Klassenvariable, die unabhängig von Instanzen existiert
    private static final String DefaultFILE = "books.json";

    // Instanzvariablen
    private HashMap<Integer,Unveroeffentlicht> buecher;
    
    private int keyValue =0;

    /**
     * default constructor
     * 
     */
    public BuecherListe() throws Exception
    {
        this(DefaultFILE);
    }

    /**
     * constructor by reading booklist from JSON file.
     */
    public BuecherListe(String filename) throws Exception
    {
        buecher = new HashMap<Integer, Unveroeffentlicht>();
        assert (filename != null && filename.contains(".json"));
        JSONParser parser = new JSONParser();
        JSONArray booksJSON = 
            (JSONArray) parser.parse(new java.io.FileReader(filename));
        for( Object obj: booksJSON){ 
            JSONObject jsonObject = (JSONObject) obj;
            buecher.put(keyValue++, new Unveroeffentlicht(jsonObject));
        }
    }

    public void fuegeBuchHinzu(Unveroeffentlicht unveroeffentlicht)
    {
        buecher.put(keyValue, unveroeffentlicht);
    }

    public void ausgeben()
    {
        System.out.println("Buecherliste:");
        for(int b: buecher.keySet()){
            System.out.println(""+b);
            buecher.get(b).ausgeben();
        }
    }
}
