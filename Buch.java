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
    }

    public Buch(JSONObject jsonObject) throws Exception {
        super(jsonObject);
    }

    @Override
    protected void fromJsonObject(JSONObject jsonObject) throws Exception
    {
        super.fromJsonObject(jsonObject);
        this.publisher = (String) jsonObject.get("publisher");
        this.address = (String) jsonObject.get("address");
        this.isbn = (String) jsonObject.get("isbn");
    }

    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Publizist: "+publisher+ ", Addresse: "+address+", ISBN: " +isbn);
    }
    
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
