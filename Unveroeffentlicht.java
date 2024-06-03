
/**
 * Beschreiben Sie hier die Klasse Unveroeffentlich.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Unveroeffentlicht extends Literatur
{
    public Unveroffentlicht(JSONObject jsonObject) throws Exception 
    {

        this.autor = (String) jsonObject.get("author");
        this.titel = (String) jsonObject.get("title");
        this.jahr = (Long) jsonObject.get("year");
        this.comment = (String) jsonObject.get("comment");

    }
}

