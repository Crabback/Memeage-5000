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
 * This class represents the color of a single pixel within an image
 * 
 * @author Zhengjia Mao
 *
 */
public class Color extends FourBytes {

  /**
   * Constructor of the Color class, create a new Color object which is the child class of the
   * FourBytes class when pass in 1 integer parameter.
   * 
   * @param argb, the decimal form of 32-bit binary contains 4 color elements
   */
  public Color(int argb) {
    super(argb);
  }

  /**
   * Overloading constructor of the Color class, create a new Color object which is the child class
   * of the FourBytes class when pass in 4 integer parameters, and act like a FourBytes class.
   * Initialize the FourBytes object by setting the four color elements
   * 
   * @param alpha, the decimal form of 8-bit binary contains alpha
   * @param red, the decimal form of 8-bit binary contains red
   * @param green, the decimal form of 8-bit binary contains green
   * @param blue, the decimal form of 8-bit binary contains blue
   */
  public Color(int alpha, int red, int green, int blue) {
    super(0);
    //pass in color bits
    super.setBits(8, 0, blue);
    super.setBits(8, 8, green);
    super.setBits(8, 16, red);
    super.setBits(8, 24, alpha);
  }

  /**
   * Overloading constructor of the Color class, create a new FourBytes object when pass in 1 Color
   * object, and has the same content.
   * 
   * @param other, another Color object
   */
  public Color(Color other) {
    super(other.getInt());
  }

  /**
   * Accessor of the Color class
   * 
   * @return the decimal form of the 32-bit binary contains 4 color elements
   */
  public int getARGB() {
    return super.getInt();
  }

  /**
   * Accessor of the Color class
   * 
   * @return the decimal form of 8-bit binary contains alpha
   */
  public int getAlpha() {
    return super.getBits(8, 24);
  }

  /**
   * Accessor of the Color class
   * 
   * @return the decimal form of 8-bit binary contains red
   */
  public int getRed() {
    return super.getBits(8, 16);
  }

  /**
   * Accessor of the Color class
   * 
   * @return the decimal form of 8-bit binary contains green
   */
  public int getGreen() {
    return super.getBits(8, 8);
  }

  /**
   * Accessor of the Color class
   * 
   * @return the decimal form of 8-bit binary contains blue
   */
  public int getBlue() {
    return super.getBits(8, 0);
  }

  /**
   * Mutator of the Color class
   * 
   * @param the decimal form of 32-bit binary contains 4 color elements
   */
  public void setARGB(int argb) {
    super.setBits(32, 0, argb);
  }

  /**
   * Mutator of the Color class
   * 
   * @param the decimal form of 8-bit binary contains alpha
   */
  public void setAlpha(int alpha) {
    super.setBits(8, 24, alpha);
  }

  /**
   * Mutator of the Color class
   * 
   * @param the decimal form of 8-bit binary contains red
   */
  public void setRed(int red) {
    super.setBits(8, 16, red);
  }

  /**
   * Mutator of the Color class
   * 
   * @param the decimal form of 8-bit binary contains green
   */
  public void setGreen(int green) {
    super.setBits(8, 8, green);
  }

  /**
   * Mutator of the Color class
   * 
   * @param the decimal form of 8-bit binary contains blue
   */
  public void setBlue(int blue) {
    super.setBits(8, 0, blue);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
