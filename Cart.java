/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 9 "FashionProjectManagementApp.ump"
public class Cart
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cart Attributes
  private double totalPrice;

  //Cart Associations
  private Customer shopper;
  private List<ClothingItem> items;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cart(double aTotalPrice, Customer aShopper)
  {
    totalPrice = aTotalPrice;
    if (aShopper == null || aShopper.getCart() != null)
    {
      throw new RuntimeException("Unable to create Cart due to aShopper. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    shopper = aShopper;
    items = new ArrayList<ClothingItem>();
  }

  public Cart(double aTotalPrice, String aUsernameForShopper, String aPasswordForShopper, User aUserForShopper, String aAddressForShopper, int aLoyaltyPointsForShopper)
  {
    totalPrice = aTotalPrice;
    shopper = new Customer(aUsernameForShopper, aPasswordForShopper, aUserForShopper, aAddressForShopper, aLoyaltyPointsForShopper, this);
    items = new ArrayList<ClothingItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTotalPrice(double aTotalPrice)
  {
    boolean wasSet = false;
    totalPrice = aTotalPrice;
    wasSet = true;
    return wasSet;
  }

  public double getTotalPrice()
  {
    return totalPrice;
  }
  /* Code from template association_GetOne */
  public Customer getShopper()
  {
    return shopper;
  }
  /* Code from template association_GetMany */
  public ClothingItem getItem(int index)
  {
    ClothingItem aItem = items.get(index);
    return aItem;
  }

  public List<ClothingItem> getItems()
  {
    List<ClothingItem> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(ClothingItem aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ClothingItem addItem(String aName, double aPrice, ClothingItem.Size aSize, int aPointValue, Inventory aInventory)
  {
    return new ClothingItem(aName, aPrice, aSize, aPointValue, this, aInventory);
  }

  public boolean addItem(ClothingItem aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    Cart existingCart = aItem.getCart();
    boolean isNewCart = existingCart != null && !this.equals(existingCart);
    if (isNewCart)
    {
      aItem.setCart(this);
    }
    else
    {
      items.add(aItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(ClothingItem aItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aItem, as it must always have a cart
    if (!this.equals(aItem.getCart()))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemAt(ClothingItem aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(ClothingItem aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Customer existingShopper = shopper;
    shopper = null;
    if (existingShopper != null)
    {
      existingShopper.delete();
    }
    for(int i=items.size(); i > 0; i--)
    {
      ClothingItem aItem = items.get(i - 1);
      aItem.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "totalPrice" + ":" + getTotalPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "shopper = "+(getShopper()!=null?Integer.toHexString(System.identityHashCode(getShopper())):"null");
  }
}