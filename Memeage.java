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
 * This Class represents an image that may possibly include a String meme hidden within its colors
 * 
 * @author Zhengjia Mao
 *
 */
public class Memeage extends Image {

  /**
   * Constructor, create a new Memeage object when pass in a file path only
   * 
   * @param file path
   * @throws IOException if no file founded
   */
  public Memeage(File file) throws IOException {
    super(file);
  }

  /**
   * Overloading Constructor, create a new Memeage object and hide the characters of the String meme
   * pass in into the Memeage pixel, when pass in a file path and a string
   * 
   * @param file   path
   * @param String meme
   * @throws IOException              if no file founded
   * @throws IllegalArgumentException if exceptions detected in the setMeme step
   */
  public Memeage(File file, String meme) throws IOException, IllegalArgumentException {
    super(file);
    setMeme(meme);
  }

  /**
   * Hide the characters of the passed in String meme into the each color pixel of the Memeage
   * object
   * 
   * @param String meme
   * @throws IllegalArgumentException if 1) when the number of characters in the String meme is
   *                                  greater than or equal to the number of Colors/pixel locations
   *                                  within the image; 2) when any character within the meme
   *                                  message has a character code that is greater than 127
   */
  public void setMeme(String meme) throws IllegalArgumentException {
    // detect the first IllegalArgumentException
    if ((getHeight()) * (getWidth()) <= meme.length()) {
      throw new IllegalArgumentException("meme too long");
    }
    int count = 0;
    // run a for loop to go through each color pixel
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        // if finishing hiding the last character of the String, add a null character
        if (count == meme.length()) {
          Color end = new ColorPlusChar(super.getColor(x, y), '\0');
          setColor(x, y, end);
          break;
        }
        // keep updating the ColorPlusChar object and hide the characters
        Color updated = new ColorPlusChar(super.getColor(x, y), meme.charAt(count));
        setColor(x, y, updated);
        // detect the second IllegalArgumentException
        if ((int) meme.charAt(count) > 127) {
          throw new IllegalArgumentException("non-ASCII characters");
        }
        count++;
      }
    }
  }

  /**
   * Output a String by retrieving the characters from each color pixel of the Memeage
   * 
   * @return a String
   * @throws IllegalStateException if 1) a character with a character code that is greater than 127
   *                               is extracted from a Color within the memeage; 2) none of the
   *                               characters extracted from this image contain the null character
   *                               that should exist to mark the end of the meme message: '\0'.
   */
  public String getMeme() throws IllegalStateException {
    String meme = "";
    boolean testNull = false;
    // run a for loop to go through each color pixel
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        // keep updating the ColorPlusChar object and use its method below
        ColorPlusChar updated = new ColorPlusChar(super.getColor(x, y));
        // detect the first IllegalStateException
        if ((int) updated.revealChar() > 127) {
          throw new IllegalStateException("non-ASCII characters");
        }
        // break in the end
        if (updated.revealChar() == '\0') {
          // add the null character to the String testNull
          testNull = true;
          break;
        }
        // keep adding character to the String as the loop is going
        meme += updated.revealChar();
      }
    }
    // detect the second IllegalStateException
    if (!testNull) {
      throw new IllegalStateException("the memeage should end with null");
    }
    return meme;
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
