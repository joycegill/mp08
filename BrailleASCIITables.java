import java.io.File;
import java.io.FileInputStream;

/**
 * Converts bits, Braille, ASCII, and unicode with each other
 * 
 * @author Joyce Gill
 */

public class BrailleASCIITables {
  /* Fields */
  static BitTree asciiToBrailleTree = new BitTree(8);
  static BitTree brailleToAsciiTree = new BitTree(6);
  static BitTree brailleToUnicodeTree = new BitTree(6);

  /* Constructor */
  public BrailleASCIITables() throws Exception{
    asciiToBrailleTree.load(new FileInputStream(new File("ASCIIToBraille.txt")));
    brailleToAsciiTree.load(new FileInputStream(new File("BrailleToASCII.txt")));
    brailleToUnicodeTree.load(new FileInputStream(new File("BrailleToUnicode.txt")));
  } // BrailleASCIITables()

  /*
   * Converts an ASCII character to a string of bits representing the corresponding braille character..
   */
  public static String toBraille(char letter){
    // Conversion
    try {
      return asciiToBrailleTree.get("0" + Integer.toBinaryString((int)letter));
    } catch (Exception e) {
      return "Error";
    } // try/catch
  } // toBraille(char)

  /* 
   * Converts a string of bits representing a braille character to the corresponding ASCII character.
   */
  public static String toASCII(String bits){
    // Conversion
    try {
      return brailleToAsciiTree.get(bits);
    } catch (Exception e) {
      return "Error";
    } // try/catch
  } // toASCII(String)

  /* 
   * Converts a string of bits representing a braille character to the corresponding Unicode braille character for those bits.
   */
  public static String toUnicode(String bits){
    // Conversion
    try {
      String uni = brailleToUnicodeTree.get(bits);
      int hex = Integer.parseInt(uni, 16);
      char c = (char) hex;
      return Character.toString(c);
    } catch (Exception e) {
      return "Error";
    } // try/catch
  } // toUnicode(String)
} // class BrailleASCIITables