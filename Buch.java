import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
/**
 * Beschreiben Sie hier die Klasse Buch.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Buch extends Unveroeffentlicht
{
    private String publisher;
    private String address;
    private String isbn;
    
    public Buch(String filename) throws Exception
    {
        super(filename);
        assert (filename != null && filename.contains(".json"));
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new java.io.FileReader(filename));

        this.publisher = (String) jsonObject.get("publisher");
        this.address = (String) jsonObject.get("address");
        this.isbn = (String) jsonObject.get("isbn");
    }
    
    public Buch(JSONObject jsonObject) throws Exception {
        super(jsonObject);
        this.publisher = (String) jsonObject.get("publisher");
        this.address = (String) jsonObject.get("address");
        this.isbn = (String) jsonObject.get("isbn");
    }
    
    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("\nPublizist: "+publisher+ ", Addresse: "+address+", ISBN: " +isbn +"\n");
    }
}
