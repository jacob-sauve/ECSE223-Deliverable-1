/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 78 "FashionProjectManagementApp.ump"
public class Inventory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Inventory Associations
  private FashionStoreManagementApp app;
  private List<ClothingItem> stockedItems;

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
    stockedItems = new ArrayList<ClothingItem>();
  }

  public Inventory()
  {
    app = new FashionStoreManagementApp(this);
    stockedItems = new ArrayList<ClothingItem>();
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
  public ClothingItem getStockedItem(int index)
  {
    ClothingItem aStockedItem = stockedItems.get(index);
    return aStockedItem;
  }

  public List<ClothingItem> getStockedItems()
  {
    List<ClothingItem> newStockedItems = Collections.unmodifiableList(stockedItems);
    return newStockedItems;
  }

  public int numberOfStockedItems()
  {
    int number = stockedItems.size();
    return number;
  }

  public boolean hasStockedItems()
  {
    boolean has = stockedItems.size() > 0;
    return has;
  }

  public int indexOfStockedItem(ClothingItem aStockedItem)
  {
    int index = stockedItems.indexOf(aStockedItem);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStockedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ClothingItem addStockedItem(String aName, double aPrice, ClothingItem.Size aSize, int aPointValue, Cart aCart)
  {
    return new ClothingItem(aName, aPrice, aSize, aPointValue, aCart, this);
  }

  public boolean addStockedItem(ClothingItem aStockedItem)
  {
    boolean wasAdded = false;
    if (stockedItems.contains(aStockedItem)) { return false; }
    Inventory existingInventory = aStockedItem.getInventory();
    boolean isNewInventory = existingInventory != null && !this.equals(existingInventory);
    if (isNewInventory)
    {
      aStockedItem.setInventory(this);
    }
    else
    {
      stockedItems.add(aStockedItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStockedItem(ClothingItem aStockedItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aStockedItem, as it must always have a inventory
    if (!this.equals(aStockedItem.getInventory()))
    {
      stockedItems.remove(aStockedItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStockedItemAt(ClothingItem aStockedItem, int index)
  {  
    boolean wasAdded = false;
    if(addStockedItem(aStockedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStockedItems()) { index = numberOfStockedItems() - 1; }
      stockedItems.remove(aStockedItem);
      stockedItems.add(index, aStockedItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStockedItemAt(ClothingItem aStockedItem, int index)
  {
    boolean wasAdded = false;
    if(stockedItems.contains(aStockedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStockedItems()) { index = numberOfStockedItems() - 1; }
      stockedItems.remove(aStockedItem);
      stockedItems.add(index, aStockedItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStockedItemAt(aStockedItem, index);
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
    for(int i=stockedItems.size(); i > 0; i--)
    {
      ClothingItem aStockedItem = stockedItems.get(i - 1);
      aStockedItem.delete();
    }
  }

}