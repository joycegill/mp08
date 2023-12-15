import java.io.PrintWriter;

/**
 * Takes in two command-line parameters (target character set & source chars) that translates the text
 * Contains the main class
 * 
 * @author Joyce Gill
 */

public class BrailleASCII {
  public static void main (String [] args) {
    PrintWriter pen = new PrintWriter (System.out, true);

    /* Error checking for valid number of arguments */
    if (args.length != 2) {
      System.err.println("Error: Incorrect number of arguments");
    } // if

    /* Match arguments */
    String targetChar = args[0];
    String sourceChar = args[1];

    /* Perform correct conversions based on given command */
    switch (targetChar.toLowerCase()) {
      case "braille":
        for (char c : sourceChar.toCharArray()) {
          String brailles = BrailleASCIITables.toBraille(c);
          pen.println(brailles);
        } // for
        break;
      case "ascii": 
        String asciiChar = BrailleASCIITables.toASCII(sourceChar);
        pen.println(asciiChar);
        break;
      case "unicode": 
        String unicodeChar = BrailleASCIITables.toUnicode(sourceChar);
        pen.println(unicodeChar);
        break;
      default:
        System.err.println("Error: Invalid target character set");
    } // switch
  } // main
    
} // class BrailleASCII
