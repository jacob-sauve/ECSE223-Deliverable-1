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
  private List<User> users;

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
    users = new ArrayList<User>();
  }

  public FashionStoreManagementApp(String aUsernameForStoreManager, String aPasswordForStoreManager, User aPersonForStoreManager)
  {
    storeManager = new Manager(aUsernameForStoreManager, aPasswordForStoreManager, aPersonForStoreManager, this);
    catalogItems = new ArrayList<ClothingItem>();
    stockedItems = new ArrayList<InventoryItem>();
    users = new ArrayList<User>();
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
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public User addUser()
  {
    return new User(this);
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    FashionStoreManagementApp existingSystem = aUser.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aUser.setSystem(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a system
    if (!this.equals(aUser.getSystem()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
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
    
    for(int i=users.size(); i > 0; i--)
    {
      User aUser = users.get(i - 1);
      aUser.delete();
    }
  }

}