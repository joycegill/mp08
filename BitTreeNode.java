/**
 * Nodes in a bit tree. 
 * 
 * @author Joyce Gill
 */

public class BitTreeNode{

  // +--------+---------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The character represented by the tree. Null if not a leaf.
   */
  String value;

  /**
   * The left subtree.
   */
  BitTreeNode left;

  /**
   * The right subtree.
   */
  BitTreeNode right;

  // +--------------+---------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node.
   */
  public BitTreeNode(){
    this(null);
  } // BitTreeNode()

  /**
   * Create a new node with given value.
   */
  public BitTreeNode(String value){
    this.value = value;
    this.left = null;
    this.right = null;
  } // BitTreeNode()

} // class BitTreeNode