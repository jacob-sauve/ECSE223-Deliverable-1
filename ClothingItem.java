/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 44 "FashionProjectManagementApp.ump"
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

  //ClothingItem Associations
  private Cart cart;
  private Inventory inventory;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClothingItem(String aName, double aPrice, Size aSize, int aPoints, Cart aCart, Inventory aInventory)
  {
    price = aPrice;
    size = aSize;
    points = aPoints;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddCart = setCart(aCart);
    if (!didAddCart)
    {
      throw new RuntimeException("Unable to create item due to cart. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddInventory = setInventory(aInventory);
    if (!didAddInventory)
    {
      throw new RuntimeException("Unable to create item due to inventory. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aPoints<1||aPoints>5)
    {
      throw new RuntimeException("Please provide a valid points [points>=1&&points<=5]");
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
    if (aPoints>=1&&aPoints<=5)
    {
    points = aPoints;
    wasSet = true;
    }
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
  /* Code from template association_GetOne */
  public Cart getCart()
  {
    return cart;
  }
  /* Code from template association_GetOne */
  public Inventory getInventory()
  {
    return inventory;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCart(Cart aCart)
  {
    boolean wasSet = false;
    if (aCart == null)
    {
      return wasSet;
    }

    Cart existingCart = cart;
    cart = aCart;
    if (existingCart != null && !existingCart.equals(aCart))
    {
      existingCart.removeItem(this);
    }
    cart.addItem(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setInventory(Inventory aInventory)
  {
    boolean wasSet = false;
    if (aInventory == null)
    {
      return wasSet;
    }

    Inventory existingInventory = inventory;
    inventory = aInventory;
    if (existingInventory != null && !existingInventory.equals(aInventory))
    {
      existingInventory.removeItem(this);
    }
    inventory.addItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    clothingitemsByName.remove(getName());
    Cart placeholderCart = cart;
    this.cart = null;
    if(placeholderCart != null)
    {
      placeholderCart.removeItem(this);
    }
    Inventory placeholderInventory = inventory;
    this.inventory = null;
    if(placeholderInventory != null)
    {
      placeholderInventory.removeItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "," +
            "points" + ":" + getPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "size" + "=" + (getSize() != null ? !getSize().equals(this)  ? getSize().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cart = "+(getCart()!=null?Integer.toHexString(System.identityHashCode(getCart())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "inventory = "+(getInventory()!=null?Integer.toHexString(System.identityHashCode(getInventory())):"null");
  }
}