import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
/**
 * Beschreiben Sie hier die Klasse Unveroeffentlich.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Unveroeffentlicht extends Literatur
{
    public Unveroeffentlicht(JSONObject jsonObject) throws Exception 
    {

        this.autor = (String) jsonObject.get("author");
        this.titel = (String) jsonObject.get("title");
        this.jahr = (Long) jsonObject.get("year");
        this.comment = (String) jsonObject.get("comment");

    }
}

