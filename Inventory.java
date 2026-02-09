/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 65 "FashionProjectManagementApp.ump"
public class Inventory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Inventory Associations
  private FashionStoreManagementApp app;
  private List<ClothingItem> items;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Inventory(FashionStoreManagementApp aApp)
  {
    if (aApp == null || aApp.getInventory() != null)
    {
      throw new RuntimeException("Unable to create Inventory due to aApp. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    app = aApp;
    items = new ArrayList<ClothingItem>();
  }

  public Inventory()
  {
    app = new FashionStoreManagementApp(this);
    items = new ArrayList<ClothingItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getApp()
  {
    return app;
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
  public ClothingItem addItem(String aName, double aPrice, ClothingItem.Size aSize, int aPoints, Cart aCart)
  {
    return new ClothingItem(aName, aPrice, aSize, aPoints, aCart, this);
  }

  public boolean addItem(ClothingItem aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    Inventory existingInventory = aItem.getInventory();
    boolean isNewInventory = existingInventory != null && !this.equals(existingInventory);
    if (isNewInventory)
    {
      aItem.setInventory(this);
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
    //Unable to remove aItem, as it must always have a inventory
    if (!this.equals(aItem.getInventory()))
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
    FashionStoreManagementApp existingApp = app;
    app = null;
    if (existingApp != null)
    {
      existingApp.delete();
    }
    for(int i=items.size(); i > 0; i--)
    {
      ClothingItem aItem = items.get(i - 1);
      aItem.delete();
    }
  }

}