import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.HashMap;

/**
 * Stores mappings from bits to values
 *
 * @author Joyce Gill
 */
class BitTreeNode {
  BitTreeNode left;
  BitTreeNode right;
} // class BitTreeNode

class BitTreeLeaf extends BitTreeNode {
  String value;

  BitTreeLeaf(String value) {
    this.value = value;
  } // BitTreeLeaf
} // class BitTreeLeaf

public class BitTree {
  int bitLength;
  BitTreeNode root;

  public BitTree (int n) {
    this.bitLength = n;
    this.root = null;
  } // BitTree (int)

  public void set(String bits, String value) {
    if (bits.length() != bitLength || !isValidBits(bits)) {
      throw new IllegalArgumentException("Invalid bits");
    } // if

    root = setHelper(root, bits, value, 0);
  } // set (String, String)
  
  private BitTreeNode setHelper(BitTreeNode node, String bits, String value, int index) {
    if (node == null) {
        node = new BitTreeLeaf(null);
    }

    if (index == bitLength) {
        ((BitTreeLeaf) node).value = value;
    } else {
        char bit = bits.charAt(index);

        if (bit == '0') {
        node.left = setHelper(node.left, bits, value, index + 1);
        } else if (bit == '1') {
        node.right = setHelper(node.right, bits, value, index + 1);
        } else {
        throw new IllegalArgumentException("Invalid bit value");
        }
    }
    return node;
  } // setHelper (BitTreeNode, String, String, int)

  private boolean isValidBits(String bits) {
    for (char bit : bits.toCharArray()) {
      if (bit != '0' && bit != '1') {
        return false;
      }
    }
    return true;
  } // isValidBits (String)

  public String get(String bits) {
    // STUB
    return "";
  }

  public void dump(PrintWriter pen) {
    // STUB
  }

  public void load(InputStream source) {
    // STUB
  }

} // class BitTree
