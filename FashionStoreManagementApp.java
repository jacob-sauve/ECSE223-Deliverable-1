/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 1 "FashionProjectManagementApp.ump"
public class FashionStoreManagementApp
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FashionStoreManagementApp Associations
  private Manager storeManager;
  private List<ClothingItem> catalogItems;
  private List<InventoryItem> stockedItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FashionStoreManagementApp(Manager aStoreManager)
  {
    if (aStoreManager == null || aStoreManager.getSystem() != null)
    {
      throw new RuntimeException("Unable to create FashionStoreManagementApp due to aStoreManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    storeManager = aStoreManager;
    catalogItems = new ArrayList<ClothingItem>();
    stockedItems = new ArrayList<InventoryItem>();
  }

  public FashionStoreManagementApp(String aUsernameForStoreManager, String aPasswordForStoreManager, User aPersonForStoreManager)
  {
    storeManager = new Manager(aUsernameForStoreManager, aPasswordForStoreManager, aPersonForStoreManager, this);
    catalogItems = new ArrayList<ClothingItem>();
    stockedItems = new ArrayList<InventoryItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Manager getStoreManager()
  {
    return storeManager;
  }
  /* Code from template association_GetMany */
  public ClothingItem getCatalogItem(int index)
  {
    ClothingItem aCatalogItem = catalogItems.get(index);
    return aCatalogItem;
  }

  public List<ClothingItem> getCatalogItems()
  {
    List<ClothingItem> newCatalogItems = Collections.unmodifiableList(catalogItems);
    return newCatalogItems;
  }

  public int numberOfCatalogItems()
  {
    int number = catalogItems.size();
    return number;
  }

  public boolean hasCatalogItems()
  {
    boolean has = catalogItems.size() > 0;
    return has;
  }

  public int indexOfCatalogItem(ClothingItem aCatalogItem)
  {
    int index = catalogItems.indexOf(aCatalogItem);
    return index;
  }
  /* Code from template association_GetMany */
  public InventoryItem getStockedItem(int index)
  {
    InventoryItem aStockedItem = stockedItems.get(index);
    return aStockedItem;
  }

  public List<InventoryItem> getStockedItems()
  {
    List<InventoryItem> newStockedItems = Collections.unmodifiableList(stockedItems);
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

  public int indexOfStockedItem(InventoryItem aStockedItem)
  {
    int index = stockedItems.indexOf(aStockedItem);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCatalogItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ClothingItem addCatalogItem(String aName, double aPrice, int aLoyaltyPoints)
  {
    return new ClothingItem(aName, aPrice, aLoyaltyPoints, this);
  }

  public boolean addCatalogItem(ClothingItem aCatalogItem)
  {
    boolean wasAdded = false;
    if (catalogItems.contains(aCatalogItem)) { return false; }
    FashionStoreManagementApp existingCatalog = aCatalogItem.getCatalog();
    boolean isNewCatalog = existingCatalog != null && !this.equals(existingCatalog);
    if (isNewCatalog)
    {
      aCatalogItem.setCatalog(this);
    }
    else
    {
      catalogItems.add(aCatalogItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCatalogItem(ClothingItem aCatalogItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aCatalogItem, as it must always have a catalog
    if (!this.equals(aCatalogItem.getCatalog()))
    {
      catalogItems.remove(aCatalogItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCatalogItemAt(ClothingItem aCatalogItem, int index)
  {  
    boolean wasAdded = false;
    if(addCatalogItem(aCatalogItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCatalogItems()) { index = numberOfCatalogItems() - 1; }
      catalogItems.remove(aCatalogItem);
      catalogItems.add(index, aCatalogItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCatalogItemAt(ClothingItem aCatalogItem, int index)
  {
    boolean wasAdded = false;
    if(catalogItems.contains(aCatalogItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCatalogItems()) { index = numberOfCatalogItems() - 1; }
      catalogItems.remove(aCatalogItem);
      catalogItems.add(index, aCatalogItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCatalogItemAt(aCatalogItem, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStockedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addStockedItem(InventoryItem aStockedItem)
  {
    boolean wasAdded = false;
    if (stockedItems.contains(aStockedItem)) { return false; }
    FashionStoreManagementApp existingInventory = aStockedItem.getInventory();
    if (existingInventory == null)
    {
      aStockedItem.setInventory(this);
    }
    else if (!this.equals(existingInventory))
    {
      existingInventory.removeStockedItem(aStockedItem);
      addStockedItem(aStockedItem);
    }
    else
    {
      stockedItems.add(aStockedItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStockedItem(InventoryItem aStockedItem)
  {
    boolean wasRemoved = false;
    if (stockedItems.contains(aStockedItem))
    {
      stockedItems.remove(aStockedItem);
      aStockedItem.setInventory(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStockedItemAt(InventoryItem aStockedItem, int index)
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

  public boolean addOrMoveStockedItemAt(InventoryItem aStockedItem, int index)
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
    Manager existingStoreManager = storeManager;
    storeManager = null;
    if (existingStoreManager != null)
    {
      existingStoreManager.delete();
    }
    while (catalogItems.size() > 0)
    {
      ClothingItem aCatalogItem = catalogItems.get(catalogItems.size() - 1);
      aCatalogItem.delete();
      catalogItems.remove(aCatalogItem);
    }
    
    while (stockedItems.size() > 0)
    {
      InventoryItem aStockedItem = stockedItems.get(stockedItems.size() - 1);
      aStockedItem.delete();
      stockedItems.remove(aStockedItem);
    }
    
  }

}