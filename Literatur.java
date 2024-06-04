import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

/**
 * Eine Klasse, deren Exemplare Informationen über ein Buch enthalten.
 * @author (Nicolas Lyer)
 * @version (30.04.2024)
 */
class Literatur
{
    // Exemplarvariablen
    protected String autor;
    protected String titel;
    protected int ausgeliehen;
    protected long jahr;
    protected String comment;
    protected String citekey;

    /**
     * Setze den Autor und den Titel, wenn ein Exemplar erzeugt wird.
     */
    public Literatur(String buchautor, String buchtitel)
    {
        autor = buchautor;
        titel = buchtitel;
        ausgeliehen = 0; // Initialwert für die Anzahl der Ausleihvorgänge wird am Anfang auf 0 gesetzt.
        jahr = -1;       

    }

    /**
     * Buch Konstruktor
     *
     * Der Parameter buchautor wird der Instazvariable autor zugewiesen.
     * Der Parameter Buchtitel wird der Instazvariable titel zugewiesen.
     * Der Parameter erscheinungsjahr wird der Instazvariable jahr zugewiesen.
     * Die Instanzvariable ausgeliehen wird auf den Anfangswert 0 gesetzt.
    */
    public Literatur(String buchautor, String buchtitel, int erscheinungsjahr)
    {
        autor = buchautor;
        titel = buchtitel;
        jahr = erscheinungsjahr;
        ausgeliehen = 0;

    }

    /**
     * Buch Konstruktor
     *
     * @param jsonObject 
     */
    public Literatur(JSONObject jsonObject) throws Exception 
    {

        this.autor = (String) jsonObject.get("author");
        this.titel = (String) jsonObject.get("title");
        this.jahr = (Long) jsonObject.get("year");
        this.comment = (String) jsonObject.get("comment");

    }
    
    /**
     * Methode geliehen
     *
     */
    public void geliehen()
    {
        ausgeliehen++;
    }

    /**
     * Methode gibLeihvorgänge
     *
     * Der Rückgabewert der Leihvorgänge wird zurückgegeben.
     */
    public int gibLeihvorgänge()

    {
        return ausgeliehen;
    }

    /**
     * Methode gibAutor
     *
     * Der String mit dem Namen des Autors wird zurückgegeben.
     */
    public String gibAutor()
    {
        return autor;
    }

    /**
     * Methode gibTitel
     *
     * Der String mit dem Namend des Titels wird zurückgegeben.
     */
    public String gibTitel()
    {
        return titel;
    }

    /**
     * Methode ausgeben
     *
     * Autor, Titel, Leihvorgänge, Erscheinungsjahr und Kommentar werden
     * ausgegeben.
     */
    public void ausgeben()
    {
        System.out.println("Autor: " + autor + ", Titel: " + titel + ", Anzahl der Leihvörgänge: " + ausgeliehen + 
            ", Erscheinungsjahr: " + ( (jahr==-1)?"unbekannt":jahr ) + ", Kommentar: " + comment);
    }

    /**
     * Methode gibJahr
     *
     * Der Wert der Instanzvariable jahr wird zurückgegeben.
     */
    public long gibJahr()
    {
        return jahr;
    }
}

