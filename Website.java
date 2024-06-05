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
    
    public Website(JSONObject jsonObject) throws Exception {
        super(jsonObject);
        this.howpublished = (String) jsonObject.get("howpublished");
    }
}
