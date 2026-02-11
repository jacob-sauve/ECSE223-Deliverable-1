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
  private List<Order> orders;
  private List<AccountType> accounts;
  private List<Shipment> loggedShipments;
  private List<Address> savedAddress;

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
    orders = new ArrayList<Order>();
    accounts = new ArrayList<AccountType>();
    loggedShipments = new ArrayList<Shipment>();
    savedAddress = new ArrayList<Address>();
  }

  public FashionStoreManagementApp(String aUsernameForStoreManager, String aPasswordForStoreManager, User aPersonForStoreManager)
  {
    storeManager = new Manager(aUsernameForStoreManager, aPasswordForStoreManager, aPersonForStoreManager, this, this);
    catalogItems = new ArrayList<ClothingItem>();
    stockedItems = new ArrayList<InventoryItem>();
    users = new ArrayList<User>();
    orders = new ArrayList<Order>();
    accounts = new ArrayList<AccountType>();
    loggedShipments = new ArrayList<Shipment>();
    savedAddress = new ArrayList<Address>();
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
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }
  /* Code from template association_GetMany */
  public AccountType getAccount(int index)
  {
    AccountType aAccount = accounts.get(index);
    return aAccount;
  }

  public List<AccountType> getAccounts()
  {
    List<AccountType> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(AccountType aAccount)
  {
    int index = accounts.indexOf(aAccount);
    return index;
  }
  /* Code from template association_GetMany */
  public Shipment getLoggedShipment(int index)
  {
    Shipment aLoggedShipment = loggedShipments.get(index);
    return aLoggedShipment;
  }

  public List<Shipment> getLoggedShipments()
  {
    List<Shipment> newLoggedShipments = Collections.unmodifiableList(loggedShipments);
    return newLoggedShipments;
  }

  public int numberOfLoggedShipments()
  {
    int number = loggedShipments.size();
    return number;
  }

  public boolean hasLoggedShipments()
  {
    boolean has = loggedShipments.size() > 0;
    return has;
  }

  public int indexOfLoggedShipment(Shipment aLoggedShipment)
  {
    int index = loggedShipments.indexOf(aLoggedShipment);
    return index;
  }
  /* Code from template association_GetMany */
  public Address getSavedAddress(int index)
  {
    Address aSavedAddress = savedAddress.get(index);
    return aSavedAddress;
  }

  public List<Address> getSavedAddress()
  {
    List<Address> newSavedAddress = Collections.unmodifiableList(savedAddress);
    return newSavedAddress;
  }

  public int numberOfSavedAddress()
  {
    int number = savedAddress.size();
    return number;
  }

  public boolean hasSavedAddress()
  {
    boolean has = savedAddress.size() > 0;
    return has;
  }

  public int indexOfSavedAddress(Address aSavedAddress)
  {
    int index = savedAddress.indexOf(aSavedAddress);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(int aOrderNumber, int aShippingDelay, Customer aCustomer, Manager aManager, Employee aItemGatherer, Cart aPaidCart, Address aDeliveryAddress)
  {
    return new Order(aOrderNumber, aShippingDelay, aCustomer, aManager, aItemGatherer, aPaidCart, aDeliveryAddress, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    FashionStoreManagementApp existingSystem = aOrder.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aOrder.setSystem(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a system
    if (!this.equals(aOrder.getSystem()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addAccount(AccountType aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    FashionStoreManagementApp existingSystem = aAccount.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aAccount.setSystem(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(AccountType aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a system
    if (!this.equals(aAccount.getSystem()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAccountAt(AccountType aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(AccountType aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLoggedShipments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Shipment addLoggedShipment(boolean aShipped, Manager aShipmentManager)
  {
    return new Shipment(aShipped, aShipmentManager, this);
  }

  public boolean addLoggedShipment(Shipment aLoggedShipment)
  {
    boolean wasAdded = false;
    if (loggedShipments.contains(aLoggedShipment)) { return false; }
    FashionStoreManagementApp existingSystem = aLoggedShipment.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aLoggedShipment.setSystem(this);
    }
    else
    {
      loggedShipments.add(aLoggedShipment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLoggedShipment(Shipment aLoggedShipment)
  {
    boolean wasRemoved = false;
    //Unable to remove aLoggedShipment, as it must always have a system
    if (!this.equals(aLoggedShipment.getSystem()))
    {
      loggedShipments.remove(aLoggedShipment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLoggedShipmentAt(Shipment aLoggedShipment, int index)
  {  
    boolean wasAdded = false;
    if(addLoggedShipment(aLoggedShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLoggedShipments()) { index = numberOfLoggedShipments() - 1; }
      loggedShipments.remove(aLoggedShipment);
      loggedShipments.add(index, aLoggedShipment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLoggedShipmentAt(Shipment aLoggedShipment, int index)
  {
    boolean wasAdded = false;
    if(loggedShipments.contains(aLoggedShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLoggedShipments()) { index = numberOfLoggedShipments() - 1; }
      loggedShipments.remove(aLoggedShipment);
      loggedShipments.add(index, aLoggedShipment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLoggedShipmentAt(aLoggedShipment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSavedAddress()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Address addSavedAddress(String aAddressLineOne, String aPostalCode, String aCity, String aCountry)
  {
    return new Address(aAddressLineOne, aPostalCode, aCity, aCountry, this);
  }

  public boolean addSavedAddress(Address aSavedAddress)
  {
    boolean wasAdded = false;
    if (savedAddress.contains(aSavedAddress)) { return false; }
    FashionStoreManagementApp existingSystem = aSavedAddress.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aSavedAddress.setSystem(this);
    }
    else
    {
      savedAddress.add(aSavedAddress);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSavedAddress(Address aSavedAddress)
  {
    boolean wasRemoved = false;
    //Unable to remove aSavedAddress, as it must always have a system
    if (!this.equals(aSavedAddress.getSystem()))
    {
      savedAddress.remove(aSavedAddress);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSavedAddressAt(Address aSavedAddress, int index)
  {  
    boolean wasAdded = false;
    if(addSavedAddress(aSavedAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSavedAddress()) { index = numberOfSavedAddress() - 1; }
      savedAddress.remove(aSavedAddress);
      savedAddress.add(index, aSavedAddress);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSavedAddressAt(Address aSavedAddress, int index)
  {
    boolean wasAdded = false;
    if(savedAddress.contains(aSavedAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSavedAddress()) { index = numberOfSavedAddress() - 1; }
      savedAddress.remove(aSavedAddress);
      savedAddress.add(index, aSavedAddress);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSavedAddressAt(aSavedAddress, index);
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
    
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
    while (orders.size() > 0)
    {
      Order aOrder = orders.get(orders.size() - 1);
      aOrder.delete();
      orders.remove(aOrder);
    }
    
    while (accounts.size() > 0)
    {
      AccountType aAccount = accounts.get(accounts.size() - 1);
      aAccount.delete();
      accounts.remove(aAccount);
    }
    
    while (loggedShipments.size() > 0)
    {
      Shipment aLoggedShipment = loggedShipments.get(loggedShipments.size() - 1);
      aLoggedShipment.delete();
      loggedShipments.remove(aLoggedShipment);
    }
    
    while (savedAddress.size() > 0)
    {
      Address aSavedAddress = savedAddress.get(savedAddress.size() - 1);
      aSavedAddress.delete();
      savedAddress.remove(aSavedAddress);
    }
    
  }

}