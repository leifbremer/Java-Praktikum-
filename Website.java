import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
/**
 * Beschreiben Sie hier die Klasse Website.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Website extends Unveroeffentlicht
{
    private String howpublished;
    
    public Website(String filename) throws Exception
    {
        super(filename);
    }
    
    public Website(JSONObject jsonObject) throws Exception {
        super(jsonObject);
    }
    
    @Override
    protected void fromJsonObject(JSONObject jsonObject) throws Exception
    {
        super.fromJsonObject(jsonObject);
        this.howpublished = (String) jsonObject.get("howpublished");
    }
    
    @Override
    public void ausgeben()
    {
        super.ausgeben();
        System.out.println("Link: "+howpublished);
    }
    
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