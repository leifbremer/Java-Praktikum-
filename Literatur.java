import java.util.ArrayList;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

/**
 * Eine Klasse, deren Exemplare Informationen �ber ein Buch enthalten.
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
        ausgeliehen = 0; // Initialwert f�r die Anzahl der Ausleihvorg�nge wird am Anfang auf 0 gesetzt.
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
     * Methode gibLeihvorg�nge
     *
     * Der R�ckgabewert der Leihvorg�nge wird zur�ckgegeben.
     */
    public int gibLeihvorg�nge()

    {
        return ausgeliehen;
    }

    /**
     * Methode gibAutor
     *
     * Der String mit dem Namen des Autors wird zur�ckgegeben.
     */
    public String gibAutor()
    {
        return autor;
    }

    /**
     * Methode gibTitel
     *
     * Der String mit dem Namend des Titels wird zur�ckgegeben.
     */
    public String gibTitel()
    {
        return titel;
    }

    /**
     * Methode ausgeben
     *
     * Autor, Titel, Leihvorg�nge, Erscheinungsjahr und Kommentar werden
     * ausgegeben.
     */
    public void ausgeben()
    {
        System.out.println("Autor: " + autor + ", Titel: " + titel + ", Anzahl der Leihv�rg�nge: " + ausgeliehen + 
            ", Erscheinungsjahr: " + ( (jahr==-1)?"unbekannt":jahr ) + ", Kommentar: " + comment);
    }

    /**
     * Methode gibJahr
     *
     * Der Wert der Instanzvariable jahr wird zur�ckgegeben.
     */
    public long gibJahr()
    {
        return jahr;
    }
}

