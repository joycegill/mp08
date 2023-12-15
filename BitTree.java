import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Stores mappings from bits to values
 *
 * @author Joyce Gill
 */

public class BitTree {
  /* Fields */
  int size;
  BitTreeNode root;

  /* Constructor */
  public BitTree (int n) {
    this.size = n;
    this.root = new BitTreeNode();
  } // BitTree (int)

  /*
   * Follows the path through the tree given by bits and adds or replaces the value at the end with value
   */
  public void set(String bits, String value) throws Exception {
    // Throw exception for inappropriate length
    if (bits.length() != this.size){
      throw new Exception("Error: Inappropriate length");
    } // if 

    BitTreeNode current = this.root;

    // Traverse and add/replace the value at the end with value
    for (int i = 0; i < bits.length(); i++){
      // If the value is 0
      if (bits.charAt(i) == '0'){
        // Null left subtree
        if (current.left == null){
          current.left = new BitTreeNode();
        } // if 
        current = current.left;
      } // if 
      // If the value is 1
      else if (bits.charAt(i) == '1'){
        // Null right subtree
        if (current.right == null){
          current.right = new BitTreeNode();
        } // if 
        current = current.right;
      } else {
        throw new Exception("Error: Contains values other than 0s and 1s");
      } // else 
    } // for 
    current.value = value;
  } // set (String, String)

  /* 
   * Follows the path through the tree given by bits, returning the value at the end
   */
  public String get(String bits) throws Exception {
    int i = 0;
    BitTreeNode current = this.root;

    // If the root of this tree is null
    if(this.root == null){
      throw new Exception("Error: Null root");
    } // if

    // If bits and this tree are different sizes
    if(bits.length() != this.size){
      throw new Exception("Error: Inappropriate length");
    } // if 

    try{
      // While left/right subtree exists
      while (current.left != null || current.right != null) {
        // Left subtree
        if (bits.charAt(i) == '0') {
          current = current.left;
          i++;
        } // if 
        // Right subtree
        else if (bits.charAt(i) == '1') {
          current = current.right;
          i++;
        } else {
           throw new Exception("Error: Contains values other than 0s and 1s");
        } // else current bit is neither 0 nor 1
      } // while 
      return current.value;

    } catch(Exception e){
      return("Error: No such path");
    } // try/catch
  } // get(String)

  /*
   * Prints out the contents of the tree in CSV format
   */
  public void dump(PrintWriter pen){
    helper (this.root, "", pen);
  } // dump (PrintWriter)

  /*
   * Helper for dump
   */
  public void helper(BitTreeNode node, String result, PrintWriter pen) {
    pen.flush();
    // Print if thre are no subtrees
    if(node.left == null && node.right == null){
      pen.println(result + "," + node.value);
    } // if 
    else {
      helper(node.left, new String(result + "0"), pen);
      helper(node.right, new String(result + "1"), pen);
    } // else 
  } // dump (BitTreeNode, String, PrintWriter)

  /*
   * Reads a series of lines of the form bits,value and stores them in the tree.
   */
  public void load(InputStream source) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(source));
      String line;
      String[] reader;
      // Lines left to read in
      while((line = br.readLine()) != null){
        reader = line.split(",");
        this.set(reader[0], reader[1]);
      } // while 
    } catch (Exception e) {
      System.err.println("Error: Could not read from source");
    } // try/catch
  } // load (InputStream)
} // class BitTree
