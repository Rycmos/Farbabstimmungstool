package Arbeit;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
// Es werden verschiedene Pakete und Klasse importiert, die für das Graphical User Interface (GUI) und die Verwendung und Veränderung der Farben benötigt werden.
// Java Swing ist zum Beispiel ein Toolkit/Bibliothek für grafische Anwendungen.

class Hauptfarbe {  //Eine Klasse 'Hauptfarbe' wird erstell.
    private Color color;   //Das Attribut 'color' wird mit dem Datentypen Color aus dem importierten Java.awt.Color definiert.

    public Hauptfarbe(int red, int green, int blue) { //Ein Konstruktor für die Klasse mit den drei RGB-Werten als Paramenter (Integer).
        color = new Color(red, green, blue);  //Es wird ein neues Color-Objekt erstellt und der Variable 'color' zugeordnet. Dafür werden die RGB Werte verwendet, die dem Konstruktor übergeben werden.
        
    }

    public Hauptfarbe(Color color) { //Es wird ein weiter Konstruktor erstellt, mit einem 'Color'-Objekt als Parameter. 
        this.color = color; //Der Variable 'color' wird das Color-Objekt aus dem Konstruktor übergeben. Dabei wird das this.'' genutzt um zwischen Variable und Parameter zu unterschieden.
    }		//Mit diesem Konstruktor kann die Farbe, die als Parameter übergeben wurde, in der Variable 'color' gespeichert werden. Auf diese Farbe kann dann später zugegriffen werden, um sie in anderen Teilen der Klasse zu verwenden.

    public Color getColor() {  //Eine Methode 'getColor()' wird in der Klasse definiert.
        return color;		//Die Methode gibt den Wert der 'color' Variable zurück und ermöglicht einen Zugriff in anderen Teilen des Programms, ohne auf die Varaible direkt zugreifen zu müssen.
    }

    public int getRed() { //Eine Methode 'getRed()' wird definiert. 
        return color.getRed(); //Diese gibt den Rotwert der Farbe des Farbobjekts 'color' als integer (ganzzahligen Wert) zurück. Dieser kann dann in anderen Teilen des Programms genutzt werden, ohne extra auf das Farbobjekt zugreifen zu müssen.
    }		

    public int getGreen() {  //Eine Methode 'getGreen()' wird definiert.
        return color.getGreen(); //Diese gibt den Grünwert der Farbe des Farbobjekts 'color' als integer zurück. Dieser kann dann in anderen Teilen des Programms genutzt werden, ohne extra auf das Farbobjekt zugreifen zu müssen. 
    } 

    public int getBlue() {  //Eine Methode 'getBlue()' wird definiert.
        return color.getBlue();  //Diese gibt den Blauwert der Farbe des Farbobjekts 'color' als integer zurück. Dieser kann dann in anderen Teilen des Programms genutzt werden, ohne extra auf das Farbobjekt zugreifen zu müssen. 
    }		
    /* 
    Mit diesen Methoden können die RGB-Werte der Hauptfarbe einzeln abgerufen und in anderen Teilen des Programms verwendet werden, ohne direkt auf das Farbobjekt zugreifen zu müssen.
    */
    public String getColorName(Map<String, Color> colorMap) { //Die Methode 'getColorName()' wird definiert.
        for (Map.Entry<String, Color> entry : colorMap.entrySet()) {
            if (entry.getValue().equals(color)) {
                return entry.getKey();
            }
        }
        return "";
    }
/*	Methode sucht in colorMap nach Farbnamen, der dem Color-Objekt der 'Hauptfarbe' Instanz entspricht.
  	Dabei durchläuft eine Schleife  alle Entries (Einträge) und vergleicht für jeden Eintrag das Color-Objekt der 'Hauptfarbe' mit dem Color-Objekt des EIntrags.
 	Wenn dabei eine Übereinstimmung gefunden wird, wird der zugehörige Farbname des Eintrags (Key) zurückgegeben.
 	Falls keine Übereinstimmung gefunden wird, wird eine leere Zeichenkette zurückgegeben.
  */
    public Color getContrastColor() {
        int brightness = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        return brightness < 128 ? Color.WHITE : Color.BLACK;
    } 
    /*
    Es wird die Methode getContrastColor() definiert. Da der Name der Farbe bei der Ausgabe im Graphical User Interface im gleichen Feld ist, wie die grafische Darstellung der Farbe
    muss zwischen den beiden Farben ein Kontrast herrschen, damit der Text lesbar bleibt. Deshalb wird diese Methode erstellt, die für jede Hauptfarbe die Kontrastfarbe bestimmt.
    Dafür wird zunächst mit der Variable "brightness" (Integer) die Helligkeit der Hauptfarbe bestimmt. Dafür werden mit der 'Color.get...()' die jeweiligen RGB-Werte
    der Hauptfarbe zusammenaddiert und davon der Durchschnitt gebildet. Anschließend wird eine Bedingung eingebaut, die bei einem Helligkeitswert unter 128 die Schriftfarbe Weiß ('Color.WHITE')
    und bei einer Helligkeit größer als 127 die Schriftfarbe Schwarz ('Color.BLACK') festlegt. Damit kann für jede Hauptfarbe die passende Konstrastschriftfarbe bestimmt werden.
    */ 
}	
	/*
	Damit ist die Klasse 'Hauptfarbe' abgeschlossen. In dieser werden die RBG-Werte der Hauptfarbe gespeichert und Methode definiert, die das abrufen dieser Werte in anderen Teilen des Programms ermöglicht. Außerdem wurde 
	die Kontrastfarbe für die grafische Darstellung mittels einer eigenen Methode ermittelt.
	*/
class Komplementaerfarbe { //Es wird die Klasse 'Komplementaerfarbe' definiert.
    private Hauptfarbe mainColor; //Es wird eine Instanzvariable vom Typ 'Hauptfarbe' erstellt, die das Hauptfarbobjekt speichert.
    private Hauptfarbe complementColor; // Es wird eine Instanzvariable vom Typ 'Hauptfarbe' erstellt, die das Komplementärfarbobjekt speichert.
    

    /* 
     Durch diese Variablen kann man auf die Haupt- und Komplementärfarbe zugreifen. Das kann dann dafür genutzt werden Methoden und Funktionen in der Klasse zu erstellen
     , wie zum Beispiel die Methode 'getComplementColor()'.
     * */
    public Komplementaerfarbe(Hauptfarbe mainColor) { //Der Konstruktor der Klasse 'Komplementaerfarbe' wird erstellt und nimmt das 'mainColor' Objekt der 'Hauptfarbe' als Parameter entgegen.
        this.mainColor = mainColor; // Der Instanzvariable 'mainColor' des aktuellen Objekts wird der Wert der übergebenen Variable 'mainColor' zugeordnet. Dadurch wird der die Hauptfarbe gespeichert und kann in Methoden genutzt werden. 
        calculateComplementColor(); // Die in der Klasse 'Hauptfarbe' definierte Methode 'calculateComplementColor()' wird aufgerufen. Diese Methode soll das Komplementärfarbobjekt basierend auf dem Hauptfarbobjekt berechnen.
    } 	/*
    Durch den Konstruktor kann eine 'Komplementaerfarbe'-Instanz erstellt und and die übergebene Hauptfarbe wird in einer Instanzvariable initialisiert, damit sie in der späteren Anwendung verwendet werden kann. 
    */

	    private void calculateComplementColor() { 		 		//Die Methode zur Berechnung des Komplementärfarbobjekts basierend auf dem Hauptfarbobjekt wird definiert.
	    int red = 255 - mainColor.getRed();						//Die Methode 'getRed()' des 'mainColor'-Objekts wird aufgerufen um den Rotwert des Hauptfarbobjekts zu erhalten. Wenn man diesen Wert von 255 subtrahiert, erhält man den Rotwert der Komplementärfarbe. Dieser wird in der Variable 'red' gespeichert (Integer).
        int green = 255 - mainColor.getGreen(); 				//Die Methode 'getGreen()' des 'mainColor'-Objekts wird aufgerufen um den Grünwert des Hauptfarbobjekts zu erhalten. Wenn man diesen Wert von 255 subtrahiert, erhält man den Grünwert der Komplementärfarbe. Dieser wird in der Variable 'green' gespeichert (Integer).
        int blue = 255 - mainColor.getBlue(); 					//Die Methode 'getBlue()' des 'mainColor'-Objekts wird aufgerufen um den Blauwert des Hauptfarbobjekts zu erhalten. Wenn man diesen Wert von 255 subtrahiert, erhält man den Blauwert der Komplementärfarbe. Dieser wird in der Variable 'blue' gespeichert (Integer).
        complementColor = new Hauptfarbe(red, green, blue); 	// Ein neues 'Hauptfarbe'-Objekt wird erstellt und mit den neuen berechneten RGB-Werten der Komplementärfarbe initialisiert. Dieses Objekt wird der Variable 'complementColor' zugewiesen.
    }
	 /*
     Diese Methode berechnet das Komplementärfarbobjekt auf Basis des Hauptfarbobjekts und speichert es in der Variable 'complementColor'. Dafür werden recht simpel die Farbwerte von 255 subtrahiert und die neuen Werte in Variablen für die Farbwerte der neuen berechneten Komplementärfarbe gespeichert. 
     Damit sind die Farbwerte der Hauptfarbe für die Berechnung mittels der Farbwerteingabe gepeichert.
     */

    public Hauptfarbe getComplementColor() {	//Die Methode 'getComplementColor' wird definiert.
        return complementColor;
    } /*
     Die Methode 'getComplementColor()' gibt das Komplementärfarbobjekt zurück, welches von der 'Komplementaerfarbe'-Instanz gehalten wird; Die Methode hat dabei den Rückgabetyp 'Hauptfarbe', also wird ein 'Hauptfarbe'-Objekt zurückgegeben.
     In dieser Methode wird einfach die 'complementColor'-Variable zurückgegeben.
     */

    public Hauptfarbe getMainColor() {
        return mainColor;
    } /* 
    Die Methode 'getMainColor()' gibt das Hauptfarbobjekt zurück, welches von der 'Komplementaerfarbe'-Instanz gehalten wird; Die Methode hat dabei den Rückgabetyp 'Hauptfarbe', also wird ein 'Hauptfarbe'-Objekt  zurückgegeben.
   	In dieser Methode wird einfach die 'mainColor'-Variable zurückgegeben.
    */

    public Color getContrastColor() {
        return mainColor.getContrastColor();
    } /*
    Die Methode 'getContrastColor()' gibt die kontrastreiche Schriftfarbe zum Hauptfarbeobjekt zurück, welches von der 'Komplementaerfarbe'- Instanz gehalten wird. Die Methode gibt ein 'Color'-Objekt zurück. Dabei wird in dieser Methode die Methode 'getContrastColor()' auf dem 'mainColor'-Objekt aufgerufen.
    Die Methode greift dabei auf die 'getContrastColor()'-Methode der 'Hauptfarbe'-Klasse zu. 
     */
}

public class FarbenTool implements ActionListener { // Die Klasse 'Farbentool' wird definiert und implementiert das 'ActionListener'-Interface. Das Interface wird verwendet um auf das Klicken von Schaltflächen zu reagieren.  
    private JButton btnBerechnenFarbwerte; // Variable vom Typ 'JButton'. Diese Variable stellt die Schaltfläche mit der Aufschrift 'Berechnen (Farbwerte)' dar. 
    private JButton btnBerechnenListe; // Variable vom Typ 'JButton'. Diese Variable stellt die Schaltfläche mit der Aufschrift 'Berechnen (Liste)' dar. 
    private JTextField txtRed, txtGreen, txtBlue; // Definiert 3 Variablen vom Typ 'JTextField'. Diese Textfelder werden genutzt, damit der Nutzer die RGB-Werte eingeben kann.
    private JComboBox<String> colorList; // Variable vom Typ 'JComboBox<String>'. Erstellt eine Dropdown-Liste, die die Farben enthält die vom Nutzer aufgewählt werden können. 
    private JLabel lblMainColor, lblComplementColor;  // Definiert 2 Variablen vom Typ 'JLabel'. Diese kreieren die Beschriftungen für die Hauptfarbe und Komplementärfarbe.
    private JLabel lblMainColorCode, lblComplementColorCode; //Definiert 2 Variablen vom Typ 'JLabel'. Diese repräsentieren die Beschriftungen, die den Farbcode der Hauptfarbe und Komplementärfarbe anzeigen. 
    
    private Map<String, Color> colorMap; // Eine Variable vom Typ 'Map<String, Color>' wird definiert. Dies steht für die Zuordnung der Farbnamen (String) zu den entsprechenden Farben (Color) im Programm.
    
    public FarbenTool() {  //Ein parameterloser Konstruktor mit dem Namen 'FarbenTool' wird definiert.
       
    	JFrame frame = new JFrame("Farben Tool"); 							//Es wird ein 'JFrame'-Objekt mit dem Titel "Farben Tool" erstellt und der Variablen 'frame' zugewiesen.
        frame.setSize(400, 300); 											// Das Fenster wird auf eine Breite von 400 x 300 Pixeln festgelegt.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//Wenn das Fenster geschlossen wird, wird das gesamte Programm beschlossen.
        frame.setLayout(new FlowLayout()); 									//'FlowLayout' wird als Layout-Manager festgelegt. Dadurch werden die Komponenten des Fensters "fließend" angeordnet.
        																	/* In diesem Bereich wird das Hauptfenster des Interfaces erstellt und wichtige Operationen konfiguriert.
        																	 * */
        
        JLabel lblRot = new JLabel("Rotwert:"); 							//Es wird ein 'JLabel'-Objekt mit der Beschriftung "Rotwert" erstellt. Dieses dient dazu, den Benutzer aufzufordern,den Rotwert der Farbe einzugeben.
        JLabel lblGruen = new JLabel("Grünwert:"); 							// Es wird ein 'JLabel'-Objekt mit der Beschriftung "Grünwert" erstellt. Dieses dient dazu, den Benutzer aufzufordern, den Grünwert der Farbe einzugeben. 
        JLabel lblBlau = new JLabel("Blauwert:"); 							//Es wird ein 'JLabel'-Objekt mit der Beschriftung "Blauwert" erstellt. Dieses dient dazu, den Benutzer aufzufordern, den Blauwert der Farbe einzugeben.

        txtRed = new JTextField(3); //Es wird ein 'JTextField'-Objekt erstellt und die Variable 'txtRed' zugeorndet. Dieses fordert vom Benutzer den Rotwert der Farbe an. Die Breite des Textfeldes ist 3.
        txtGreen = new JTextField(3); //Es wird ein 'JTextField'-Objekt erstellt und die Variable 'txtGreen' zugeorndet. Dieses fordert vom Benutzer den Grünwert der Farbe an. Die Breite des Textfeldes ist 3
        txtBlue = new JTextField(3); //Es wird ein 'JTextField'-Objekt erstellt und die Variable 'txtBlue' zugeorndet. Dieses fordert vom Benutzer den Blauwert der Farbe an. Die Breite des Textfeldes ist 3

        btnBerechnenFarbwerte = new JButton("Berechnen (Farbwerte)"); //Eine Schaltfläche mit dem Namen "Berechnen (Farbwerte)" wird erstellt und der Variable 'btnBerechnenFarbwerte' zugeordnet. 
        btnBerechnenFarbwerte.addActionListener(this); // Dem 'btnBerechneFarbwerte'-Objekt wird ein ActionListener hinzugefügt, um auf das Klicken der Schaltfläche zu reagieren. Das Schlüsselwort 'this' sorgt dafür, dass der ActionListener in die aktuelle Klasse implementiert wird. 

        btnBerechnenListe = new JButton("Berechnen (Liste)"); //Eine Schaltfläche mit dem Namen "Berechnen (Liste)" wird erstellt und der Variable 'btnBerechnenListe' zugeordnet. 
        btnBerechnenListe.addActionListener(this); // Dem 'btnBerechnenListe'-Objekt wird ein ActionListener hinzugefügt, um auf das Klicken der Schaltfläche zu reagieren. Das Schlüsselwort 'this' sorgt dafür, dass der ActionListener in die aktuelle Klasse implementiert wird. 

        String[] colors = {"Rot", "Grün", "Blau", "Gelb", "Magenta", "Cyan"}; // Ein String-Array mit dem Namen 'colors' und den 6 Farbnamen als Elemente wird erstellt.
        colorList = new JComboBox<>(colors); // Es wird eine JComboBox erstellt und mit den Farbnamen aus dem 'colors'-Array initialisiert. Im GUI repräsentiert das eine Dropdown-Liste aus der vom Benutzer eine Farbe (bzw. Farbenname) ausgewählt werden kann.

        lblMainColor = new JLabel(); // Ein 'JLabel'-Objekt wird erstellt und der Variable 'lblMainColor' zugeordnet. Im GUI zeigt es die vom FarbenTool zu berechnende Hauptfarbe an 
        lblComplementColor = new JLabel(); // Ein 'JLabel'-Objekt wird erstellt und der VFariable 'lblComplementColor' zugeordnet. Im GUI zeigt es die vom FarbenTool berechnete Komplementärfarbe an. 

        lblMainColorCode = new JLabel(); // Ein 'JLabel'-Objekt wird erstellt und der Variable 'lblMainColorCode' zugeordnet. Im GUI gibt es den Farbcode (RGB) von der vom FarbenTool zu berechnende Hauptfarbe an. 
        lblComplementColorCode = new JLabel(); // Ein 'JLabel'-Objekt wird erstellt und der Variable 'lblComplementColorCorde' zugeordnet. Im GUI gibt es den Farbcode (RGB) von der vom FarbenTool berechneten Komplementärfarbe aus.
        

        frame.add(lblRot);
        frame.add(txtRed);
        frame.add(lblGruen);
        frame.add(txtGreen);
        frame.add(lblBlau);
        frame.add(txtBlue);
        frame.add(colorList);
        frame.add(btnBerechnenFarbwerte);
        frame.add(btnBerechnenListe);
        frame.add(lblMainColor);
        frame.add(lblComplementColor);
        frame.add(lblMainColorCode);
        frame.add(lblComplementColorCode);
        
        /* 
         In diesem Bereich werden die oben erstellten Objekte in das Fenster eingefügt. Dafür wird die 'add()'-Methode des 'frame'-Objekts verwendet. Durch die Konfiguration des Fensters mit einem flowLayout werden die Objekte in der Reihenfolge 
         eingefügt, in der sie dann in der Ausgabe auch angezeigt werden.  
         * */

        frame.setVisible(true); //Das Hauptfenster wird mit dieser Methode des 'frame'-Objekts sichtbar gemacht, damit der Benutzer damit interagieren kann. Standartmäßig würde das Hauptfenster nicht sichtbar sein. 
        
        // Die Farbzuordnungen für die 'colorMap' werden erstellt.
        colorMap = new HashMap<>(); //Die neue Instanz der 'HashMap'-Klasse wird erstellt. Diese kann Schlüssel-Wert-Paare speichern, in diesem Fall sind das die Farbnamen und die Farben.
        colorMap.put("Rot", Color.RED); // Ein Schlüssel-Wert-Paar wird hinzugefügt. Dabei ist der Name der Farbe ("Rot") der Schlüssel und das 'Color'-Objekt ('Color.RED') der Wert.
        colorMap.put("Grün", Color.GREEN); // Ein Schlüssel-Wert-Paar wird hinzugefügt. Dabei der der Name der Farbe ("Grün") der Schlüssel und das 'Color'-Objekt ('Color-GREEN') der Wert.
        colorMap.put("Blau", Color.BLUE); // Ein Schlüssel-Wert-Paar wird hinzugefügt. Dabei der der Name der Farbe ("Blau") der Schlüssel und das 'Color'-Objekt ('Color-BLUE') der Wert.
        colorMap.put("Gelb", Color.YELLOW); // Ein Schlüssel-Wert-Paar wird hinzugefügt. Dabei der der Name der Farbe ("Gelb") der Schlüssel und das 'Color'-Objekt ('Color-YELLOW') der Wert. 
        colorMap.put("Magenta", Color.MAGENTA); // Ein Schlüssel-Wert-Paar wird hinzugefügt. Dabei der der Name der Farbe ("Magenta") der Schlüssel und das 'Color'-Objekt ('Color-MAGENTA') der Wert.
        colorMap.put("Cyan", Color.CYAN); // Ein Schlüssel-Wert-Paar wird hinzugefügt. Dabei der der Name der Farbe ("Cyan") der Schlüssel und das 'Color'-Objekt ('Color-CYAN') der Wert.
    
   
    }
    	/*
    	 Die Map wird mit mehreren Farben und Namen Kombinationen gefüllt. Dabei ist der Farbname der Schlüssel und die zugehörige Farbe der Wert.
    	 Dadurch kann der Name einer Farbe übergeben werden und das passende 'Color'-Objekt wird abgerufen.
    	*/
    @Override
    public void actionPerformed(ActionEvent e) { // Methode die vom 'ActionListener'-Interface vorgegeben wird. Wird verwendet um auf Aktionen der Schaltfläche im Farbentool zu reagieren. Der Parameter 'e' vom Typ 'ActionEvent' enthält Informationen über die aufgetretene Aktion. 
        if (e.getSource() == btnBerechnenFarbwerte) { // Bedingung der 'actionPerformed()'-Methode. Sie wird aufgerufen, wenn die Schaltfläche "Berechnen (Farbwerte)" ausgelöst wird.
            String redText = txtRed.getText();
            String greenText = txtGreen.getText();
            String blueText = txtBlue.getText();
            /* Der Text aus den Textfeldern 'txtRot', 'txtGruen' und 'txtBlau' wird ausgelesen und in den entsprechenden Variablen gespeichert. Die vom Nutzer eingegeben Farbwerte werden abgerufen. 
               Dies passiert, sobald der das 'btnBerechnenFarbwerte' Ereignis ausgelöst wurde. Solange das nicht passiert, wird dieser Teil des Programms nicht durchgeführt. 
              */
            
            if (redText.isEmpty() || greenText.isEmpty() || blueText.isEmpty()) {
                showError("Mindestens ein Farbfeld ist leer. Bitte geben Sie alle Farbwerte ein.");
                return;
            } 
            /* Diese If-Bedingung prüft, ob mindestens eines dieser Farbwertefelder unausgefüllt ist. Wenn dies der Fall ist, dann wird eine Fehlermeldung mit der 'showError()'-Methode ausgegeben. 
               Wenn das nicht der Fall ist, wird das Programm einfach weiter ausgeführt. 
              */

            int redint = Integer.parseInt(redText);
            int greenint = Integer.parseInt(greenText);
            int blueint = Integer.parseInt(blueText);
            /* Der numerische Teil der für die Farbwerte eingegebenen Texte wird in Ganzzahlen (Integer) umgewandelt und den entsprechenden Variablen zugeordnet.
               Diese neuen Variablen können dann einfach in Berechnungen oder numerischen Operationen verwendet werden.
             */

            if (isValidColorValue(redint) && isValidColorValue(greenint) && isValidColorValue(blueint)) { 
    			Hauptfarbe mainColor = new Hauptfarbe(redint, greenint, blueint);
    			calculateAndShowComplementaryColor(mainColor); 
    			} 
    		else { showError("Ungültige Eingabe! Es müssen Zahlen  zwischen 0 und 255 eingegeben werden."); 
    		}
            }
            /* Diese Bedingung überprüft, ob die eingegebenen Farbwerte gültig sind. Dafür wird mittels der Methode 'isValidColorValue' bei jedem einzelnen Farbwert überprüft, ob sie passend sind (als Farbwert zwischen 0 und 255). 
               Dabei werden die neu definierten Integer Variablen verwendet. 
               Wenn alle Farbwerte gültig sind, wird ein 'Hauptfarbe'-Objekt mit diesen Farbwerte erstellt und die Methode 'calculateComplementaryColor()' auf dieses Objekt angewendet, um die Komplementärfarbe zu berechnen. 
               Wenn dagegen mindestens ein Farbwert nicht gültig ist, wird die 'showError()'-Methode aufgerufen, um dem Nutzer eine Fehlermeldung anzuzeigen.
              */
            
         else if (e.getSource() == btnBerechnenListe) { // Eine Bedingung der 'actionPerformed()'-Methode. Sie wird aufgerufen, wenn die Schaltfläche "Berechnen (Liste)" ausgelöst wird. 
            String selectedColor = (String) colorList.getSelectedItem(); //Der ausgewählt Farbname aus der Dropdown-Liste ('colorListÄ) wird ausgelesen und in der Variable 'selectedColor' gespeichert. Der ausgewählt Farbname wird in einen 'String' konvertiert. 
            if (selectedColor != null) {
                Color mainColor = colorMap.get(selectedColor);
                Hauptfarbe hauptfarbe = new Hauptfarbe(mainColor);
                calculateAndShowComplementaryColor(hauptfarbe);
            }
            /* Die Bedingung überprüft, ob ein Farbname ausgewählt. Dafür wird gefragt, ob die Variable für die ausgewählt Farbe 'null' ist. Wenn ein Farbname ausgewählt wurde, dann wird das entsprechende 'Color'-Objekt aus der 'colorMap' abgerufen und in der Variable 'mainColor' gespeichert. 
               Dann wird ein neues 'Hauptfarbe'-Objekt mit 'mainColor' erstellt und die Methode 'calculateAndShowComplementaryColor()' aufgerufen, damit die Komplementärfarbe berechnet und angezeigt wird. 
               In diesem Abschnitt wird die Berechnung für  die Komplementärfarbe für die aus der Liste ausgewhälte Farbe ausgelöst. 
              */
        }
    }
    public boolean isValidColorValue(int value) {
        return value >= 0 && value <= 255;
    } 
    /*  Die Methode 'isValidColorValue()' wird definiert. Dieser wird ein Wert eingegeben, in diesem Fall der jeweilige Farbwert, der dann zwischen größer gleich 0 und kleiner gleich 255 sein muss.
      */
      
    private void calculateAndShowComplementaryColor(Hauptfarbe mainColor) { //Die Methode, die verwendet wird um die Komplementärfarbe zu berechnen und anzuzeigen, wird definiert. 
        Komplementaerfarbe complementColor = new Komplementaerfarbe(mainColor); //Ein 'Komplementaerfarbe'-Objekt mit 'mainColor' als Parameter wird erstellt. Dadurch wird die Komplementärfarbe zur 'mainColor' berechnet. 

        lblMainColor.setText("Hauptfarbe: " + mainColor.getColorName(colorMap));
        lblMainColor.setOpaque(true);
        lblMainColor.setBackground(mainColor.getColor());
        lblMainColor.setForeground(mainColor.getContrastColor());
        /* 
          Der Text wird aktualisiert, damit hinter dem Textfeld "Hauptfarbe:" der richtige Hauptfarbenname angezeigt wird. 
          Das 'lblMainColor'-Label wird auf sichtbar gesetzt.
          Der Hintergrund wird auf die Farbe der Hauptfarbe festgelegt und die Vordergrundfarbe auf die passende Kontrastfarbe festgesetzt. Dafür werden die 
          */
        
        lblComplementColor.setText("Komplementärfarbe: " + complementColor.getComplementColor().getColorName(colorMap));
        lblComplementColor.setOpaque(true);
        lblComplementColor.setBackground(complementColor.getComplementColor().getColor());
        lblComplementColor.setForeground(complementColor.getComplementColor().getContrastColor());
        /* 
          Der Text wird aktualisiert, damit hinter dem Textfeld "Komplementärfarbe:" der richtige Komplementärfarbenname angezeigt wird.
          Das 'lblComplementColor'-Label wird auf sichtbar gesetzt. 
          Der Hintergrund wird auf die Farbe der Komplementärfarbe festgelegt und die Vordergrundfarbe auf die passende Kontrastfarbe festgesetzt. 
          */
        
        
        lblMainColorCode.setText("Farbcode (Hauptfarbe): R:" + mainColor.getRed() + " G:" + mainColor.getGreen() + " B:" + mainColor.getBlue());
        lblComplementColorCode.setText("Farbcode (Komplementärfarbe): R:" + complementColor.getComplementColor().getRed() + " G:" + complementColor.getComplementColor().getGreen() + " B:" + complementColor.getComplementColor().getBlue());
        /* Die Label 'lblMainColorCode' und 'lblComplementColorCode' werden aktualisiert, damit die RGB-Werte hinter den entsprechenden Textfeldern passend sind. Der text wird dabei durch die Kombination aus Textfeldern und den Farbwerten 
           erzeugt. Dafür werden die vorher definierten Methoden genutzt. 
          */
    }



    private void showError(String errorMessage) { //Die Fehlermeldungs Methode wird definiert. 
        JOptionPane.showMessageDialog(null, errorMessage, "Fehler", JOptionPane.ERROR_MESSAGE);
    } /*In dieser Methode wird eine Dialogbox erstellt, die die entsprechenden Fehlermeldungen anzeigt. Diese Methode wird an mehreren Stellen im Quelltext verwendet, um Fehlermeldungen anzuzeigen. 
    	Die entsprechende Fehlernachricht der Methode kann abhängig vom Einsatzgrund erstellt werden.
     	*/ 

    public static void main(String[] args) { // Die 'main()'-Methode, die den Startpunkt des Programms darstellt.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FarbenTool();
            }
        }); /* Die Anwendung wird initialisiert und gestartet, indem eine Instanz der Klasse 'FarbenTool' erzeugt wird. 
               Die Main-Methode startet das Farben-Tool in dem die Anwendung initialisiert und das Fenster angezeigt wird. Das 'SwingUtilities.invokeLater()' stellt sicher, dass der Swing-Code richtig ausgegeführt wird und um Probleme mit der Benutzeroberfläche (dem GUI) zu vermeiden. 
         		
         	*/
    }
}

