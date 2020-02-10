//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P05 Memeage 5000
// Files: Color.java, ColorPlusChar.java, Memeage.java, MemeageTests.java
// Course: CS 300
//
// Author: Zhengjia Mao
// Email: zmao27@wisc.edu
// Lecturer's Name: Gary DAHL
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _YES__ Write-up states that pair programming is allowed for this assignment.
// _YES__ We have both read and understand the course Pair Programming Policy.
// _YES__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: ULC tutors
// Online Sources: beginnersbook.com, www.tutorialspoint.com
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This Class is to hide a single 8-bit ASCII character code within the two least significant bits
 * of each color component (alpha, red, green, and blue).
 * 
 * @author Zhengjia Mao
 *
 */
public class ColorPlusChar extends Color {

  /**
   * Constructor of the ColorPlusChar, create a new ColorPlusChar Object, which is the child class
   * of the Color class, when pass in a Color object parameter and a character parameter
   * 
   * @param A Color object
   * @param A 8-bit ASCII character to hide
   */
  public ColorPlusChar(Color color, char character) {
    super(color);
    hideChar(character);
  }

  /**
   * Overloading constructor of the ColorPlusChar, create a new ColorPlusChar Object, which is the
   * child class of the Color class, when pass in a Color object parameter only
   * 
   * @param A Color object
   */
  public ColorPlusChar(Color color) {
    super(color);
  }

  /**
   * This method stores 8-bit character within the least significant bits of color components
   * 
   * @param A 8-bit ASCII character to hide
   */
  public void hideChar(char character) {
    FourBytes x = new FourBytes(character);
    // divide the 8-bit ASCII character into 4 pieces of 2 bits
    int aValue = x.getBits(2, 6);
    int rValue = x.getBits(2, 4);
    int gValue = x.getBits(2, 2);
    int bValue = x.getBits(2, 0);
    // store the 4 pieces of 2-bit character into the 4 color components
    super.setBits(2, 24, aValue);
    super.setBits(2, 16, rValue);
    super.setBits(2, 8, gValue);
    super.setBits(2, 0, bValue);
  }

  /**
   * This method retrieves 8-bit character from the least significant bits of color components
   * 
   * @return the 8-bit ASCII character retrieved from the color components
   */
  public char revealChar() {
    FourBytes bits = new FourBytes(0);
    // take the last 2 bits from each of the color components and store them into one 8-bit
    // FourBytes object
    bits.setBits(2, 6, super.getBits(2, 24));
    bits.setBits(2, 4, super.getBits(2, 16));
    bits.setBits(2, 2, super.getBits(2, 8));
    bits.setBits(2, 0, super.getBits(2, 0));
    //return the characters from the object
    return bits.getChar();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
