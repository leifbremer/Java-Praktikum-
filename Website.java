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
    
    
   public Website(JSONObject jsonObject) throws Exception 
    {
        super(jsonObject);
        this.autor = (String) jsonObject.get("author");
        this.titel = (String) jsonObject.get("title");
        this.jahr = (Long) jsonObject.get("year");
        this.comment = (String) jsonObject.get("comment");

    }
}
