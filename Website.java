
/**
 * Beschreiben Sie hier die Klasse Website.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Website extends Literatur

{
   public Website(JSONObject jsonObject) throws Exception 
    {

        this.autor = (String) jsonObject.get("author");
        this.titel = (String) jsonObject.get("title");
        this.jahr = (Long) jsonObject.get("year");
        this.comment = (String) jsonObject.get("comment");

    }
}
