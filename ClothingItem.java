/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 41 "FashionProjectManagementApp.ump"
public class ClothingItem
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, ClothingItem> clothingitemsByName = new HashMap<String, ClothingItem>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClothingItem Attributes
  private String name;
  private double price;
  private Size size;
  private int points;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClothingItem(String aName, double aPrice, Size aSize, int aPoints)
  {
    price = aPrice;
    size = aSize;
    points = aPoints;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    if (aPoints<1||aPoints>5)
    {
      throw new RuntimeException("Please provide a valid points [points>=1&&points<=5]");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    String anOldName = getName();
    if (anOldName != null && anOldName.equals(aName)) {
      return true;
    }
    if (hasWithName(aName)) {
      return wasSet;
    }
    name = aName;
    wasSet = true;
    if (anOldName != null) {
      clothingitemsByName.remove(anOldName);
    }
    clothingitemsByName.put(aName, this);
    return wasSet;
  }

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setSize(Size aSize)
  {
    boolean wasSet = false;
    size = aSize;
    wasSet = true;
    return wasSet;
  }

  public boolean setPoints(int aPoints)
  {
    boolean wasSet = false;
    if (aPoints>=1&&aPoints<=5)
    {
    points = aPoints;
    wasSet = true;
    }
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  public static ClothingItem getWithName(String aName)
  {
    return clothingitemsByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
  }

  public double getPrice()
  {
    return price;
  }

  public Size getSize()
  {
    return size;
  }

  public int getPoints()
  {
    return points;
  }

  public void delete()
  {
    clothingitemsByName.remove(getName());
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "," +
            "points" + ":" + getPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "size" + "=" + (getSize() != null ? !getSize().equals(this)  ? getSize().toString().replaceAll("  ","    ") : "this" : "null");
  }
}