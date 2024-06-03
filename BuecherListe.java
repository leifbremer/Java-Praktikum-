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
    private HashMap<Integer,Buch> buecher;
    
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
        buecher = new HashMap<Integer, Buch>();
        assert (filename != null && filename.contains(".json"));
        JSONParser parser = new JSONParser();
        JSONArray booksJSON = 
            (JSONArray) parser.parse(new java.io.FileReader(filename));
        for( Object obj: booksJSON){ 
            JSONObject jsonObject = (JSONObject) obj;
            // following code is bad, replace!S
            // must delegate book details to book,why?
            // since changes are made in the book class, e.g. add year etc.
            // replace by calling constructor Buch(JSONObject obj)!
            //String autor = (String) jsonObject.get("author");
            // String titel = (String) jsonObject.get("title");
            // buecher.add(new Buch(autor, titel));
            // better code:
            buecher.put(keyValue++, new Buch(jsonObject));
        }
    }

    public void fuegeBuchHinzu(Buch buch)
    {
        buecher.put(keyValue, buch);
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
