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

import java.io.File;
import java.io.IOException;

/**
 * Tester of the three other Class files created
 * 
 * @author Zhengjia Mao
 *
 */
public class MemeageTests {

  /**
   * Test getBits method in the FourBytes class
   * 
   * @return true if correctly returns the decimal form at the correct offset
   */
  public static boolean testFourBytesGetBits() {
    FourBytes bitstring = new FourBytes(13312);
    
    if (bitstring.getBits(4, 10) != 13) {
      return false;
    }
    
    return true;
  }

  /**
   * Test setBits method in FourBytes class
   * 
   * @return true if correctly changes the binary at the correct offset
   */
  public static boolean testFourBytesSetBits() {
    FourBytes bitstring = new FourBytes(0);
    bitstring.setBits(3, 8, 13);
    
    if (bitstring.getInt() != 1280) {
      return false;
    }
    
    return true;
  }

  /**
   * Test the constructor, the accessor, and the mutator of the Color class
   * 
   * @return true if all three methods work correctly
   */
  public static boolean testColor() {

    Color color1 = new Color(347383123);
    Color color2 = new Color(20, 180, 165, 83);
    Color color3 = new Color(347383123);
    color3.setBlue(180);

    if (color1.getInt() != color2.getInt()) {
      return false;
    }
    if (color1.getRed() != 180) {
      return false;
    }
    if (color3.getBlue() != 180) {
      return false;
    }
    
    return true;
  }

  /**
   * Test the Image class ensure the methods output the correct image size and correct color at the
   * corresponding pixel
   * 
   * @return true if all the methods outputs the correct results
   * @throws IOException if no image file founded
   */
  public static boolean testImage() throws IOException {
    try {
      Image imageObject = new Image(new File("testImage.png"));
      //test the size
      if (imageObject.getHeight() != 3)
        return false;
      if (imageObject.getWidth() != 3)
        return false;
      //test the color
      if (imageObject.getColor(1, 1).getGreen() != 255)
        return false;
      if (imageObject.getColor(1, 1).getBlue() != 255)
        return false;
    } catch (IOException e) {//if no file founded
      return false;
    }
    
    return true;
  }

  /**
   * Test the ColorPlusChar class ensure the
   * 
   * @return
   */
  public static boolean testColorPlusChar() {
    Color color = new Color(255, 255, 255, 255);
    Color color2 = new Color(347383123);
    char c = (char) 0b10101010;

    // test the hideChar method in this statement
    ColorPlusChar cpc2 = new ColorPlusChar(color, c);
    ColorPlusChar cpc3 = new ColorPlusChar(color2);

    // test the constructor correctly sets up these objects
    if (cpc3.getARGB() != 347383123)
      return false;
    if (cpc2.getRed() != 254)
      return false;
    // test the reveal method in this statement
    if (cpc2.revealChar() != c)
      return false;
    
    return true;
  }

  /**
   * Test the Memeage Class
   * Ensure the constructor, the accessor, and the mutator all work correctly
   * 
   * @return true if the constructor, the accessor, and the mutator all work correctly
   * @throws if no image file founded
   */
  public static boolean testMemeage() {
    File image01 = new File("image01.png");
    File image02 = new File("image02.png");
    File image03 = new File("image03.png");

    // test the Constructors
    try {
      Memeage memage01 = new Memeage(image01);
      // test the mutator method setMeme
      memage01.setMeme("haha");
      // test the accessor method getMeme
      if (memage01.getMeme().equals("haha") != true) {
        return false;
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      Memeage memage02 = new Memeage(image02);
      // test the mutator method setMeme
      memage02.setMeme("A");
      // test the accessor method getMeme
      if (memage02.getMeme().equals("A") != true) {
        return false;
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {
      Memeage memage03 = new Memeage(image03);
      // test the mutator method setMeme
      memage03.setMeme("123");
      // test the accessor method getMeme
      if (memage03.getMeme().equals("123") != true) {
        return false;
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

  /**
   * Tester
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    System.out.println(testFourBytesGetBits());
    System.out.println(testFourBytesSetBits());
    System.out.println(testColor());
    System.out.println(testImage());
    System.out.println(testColorPlusChar());
    System.out.println(testMemeage());
  }

}
