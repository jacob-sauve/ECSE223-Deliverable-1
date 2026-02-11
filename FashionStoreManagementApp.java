/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.8072.d3fbfafbc modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Team 13 - The PolyMorphans
 * Deliverable 1 Umple code
 * v.3.0
 * 2026-02-10
 */
// line 7 "model.ump"
// line 127 "model.ump"
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
  private List<Order> loggedOrders;
  private List<Cart> carts;
  private List<Shipment> shipments;
  private List<Address> savedAddresses;
  private List<AccountType> accounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FashionStoreManagementApp(Manager aStoreManager)
  {
    if (aStoreManager == null || aStoreManager.getSystem() != null)
    {
      throw new RuntimeException("Unable to create FashionStoreManagementApp due to aStoreManager. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    storeManager = aStoreManager;
    catalogItems = new ArrayList<ClothingItem>();
    stockedItems = new ArrayList<InventoryItem>();
    users = new ArrayList<User>();
    loggedOrders = new ArrayList<Order>();
    carts = new ArrayList<Cart>();
    shipments = new ArrayList<Shipment>();
    savedAddresses = new ArrayList<Address>();
    accounts = new ArrayList<AccountType>();
  }

  public FashionStoreManagementApp(String aUsernameForStoreManager, String aPasswordForStoreManager, User aPersonForStoreManager)
  {
    storeManager = new Manager(aUsernameForStoreManager, aPasswordForStoreManager, aPersonForStoreManager, this, this);
    catalogItems = new ArrayList<ClothingItem>();
    stockedItems = new ArrayList<InventoryItem>();
    users = new ArrayList<User>();
    loggedOrders = new ArrayList<Order>();
    carts = new ArrayList<Cart>();
    shipments = new ArrayList<Shipment>();
    savedAddresses = new ArrayList<Address>();
    accounts = new ArrayList<AccountType>();
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
  public Order getLoggedOrder(int index)
  {
    Order aLoggedOrder = loggedOrders.get(index);
    return aLoggedOrder;
  }

  public List<Order> getLoggedOrders()
  {
    List<Order> newLoggedOrders = Collections.unmodifiableList(loggedOrders);
    return newLoggedOrders;
  }

  public int numberOfLoggedOrders()
  {
    int number = loggedOrders.size();
    return number;
  }

  public boolean hasLoggedOrders()
  {
    boolean has = loggedOrders.size() > 0;
    return has;
  }

  public int indexOfLoggedOrder(Order aLoggedOrder)
  {
    int index = loggedOrders.indexOf(aLoggedOrder);
    return index;
  }
  /* Code from template association_GetMany */
  public Cart getCart(int index)
  {
    Cart aCart = carts.get(index);
    return aCart;
  }

  public List<Cart> getCarts()
  {
    List<Cart> newCarts = Collections.unmodifiableList(carts);
    return newCarts;
  }

  public int numberOfCarts()
  {
    int number = carts.size();
    return number;
  }

  public boolean hasCarts()
  {
    boolean has = carts.size() > 0;
    return has;
  }

  public int indexOfCart(Cart aCart)
  {
    int index = carts.indexOf(aCart);
    return index;
  }
  /* Code from template association_GetMany */
  public Shipment getShipment(int index)
  {
    Shipment aShipment = shipments.get(index);
    return aShipment;
  }

  public List<Shipment> getShipments()
  {
    List<Shipment> newShipments = Collections.unmodifiableList(shipments);
    return newShipments;
  }

  public int numberOfShipments()
  {
    int number = shipments.size();
    return number;
  }

  public boolean hasShipments()
  {
    boolean has = shipments.size() > 0;
    return has;
  }

  public int indexOfShipment(Shipment aShipment)
  {
    int index = shipments.indexOf(aShipment);
    return index;
  }
  /* Code from template association_GetMany */
  public Address getSavedAddress(int index)
  {
    Address aSavedAddress = savedAddresses.get(index);
    return aSavedAddress;
  }

  public List<Address> getSavedAddresses()
  {
    List<Address> newSavedAddresses = Collections.unmodifiableList(savedAddresses);
    return newSavedAddresses;
  }

  public int numberOfSavedAddresses()
  {
    int number = savedAddresses.size();
    return number;
  }

  public boolean hasSavedAddresses()
  {
    boolean has = savedAddresses.size() > 0;
    return has;
  }

  public int indexOfSavedAddress(Address aSavedAddress)
  {
    int index = savedAddresses.indexOf(aSavedAddress);
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
  public static int minimumNumberOfLoggedOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addLoggedOrder(int aOrderNumber, int aShippingDelay, Customer aCustomer, Manager aManager, Employee aItemGatherer, Cart aPaidCart, Address aDeliveryAddress)
  {
    return new Order(aOrderNumber, aShippingDelay, aCustomer, aManager, aItemGatherer, aPaidCart, aDeliveryAddress, this);
  }

  public boolean addLoggedOrder(Order aLoggedOrder)
  {
    boolean wasAdded = false;
    if (loggedOrders.contains(aLoggedOrder)) { return false; }
    FashionStoreManagementApp existingSystem = aLoggedOrder.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aLoggedOrder.setSystem(this);
    }
    else
    {
      loggedOrders.add(aLoggedOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLoggedOrder(Order aLoggedOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aLoggedOrder, as it must always have a system
    if (!this.equals(aLoggedOrder.getSystem()))
    {
      loggedOrders.remove(aLoggedOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLoggedOrderAt(Order aLoggedOrder, int index)
  {  
    boolean wasAdded = false;
    if(addLoggedOrder(aLoggedOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLoggedOrders()) { index = numberOfLoggedOrders() - 1; }
      loggedOrders.remove(aLoggedOrder);
      loggedOrders.add(index, aLoggedOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLoggedOrderAt(Order aLoggedOrder, int index)
  {
    boolean wasAdded = false;
    if(loggedOrders.contains(aLoggedOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLoggedOrders()) { index = numberOfLoggedOrders() - 1; }
      loggedOrders.remove(aLoggedOrder);
      loggedOrders.add(index, aLoggedOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLoggedOrderAt(aLoggedOrder, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCarts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Cart addCart(Customer aCustomer)
  {
    return new Cart(aCustomer, this);
  }

  public boolean addCart(Cart aCart)
  {
    boolean wasAdded = false;
    if (carts.contains(aCart)) { return false; }
    FashionStoreManagementApp existingSystem = aCart.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aCart.setSystem(this);
    }
    else
    {
      carts.add(aCart);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCart(Cart aCart)
  {
    boolean wasRemoved = false;
    //Unable to remove aCart, as it must always have a system
    if (!this.equals(aCart.getSystem()))
    {
      carts.remove(aCart);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCartAt(Cart aCart, int index)
  {  
    boolean wasAdded = false;
    if(addCart(aCart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCarts()) { index = numberOfCarts() - 1; }
      carts.remove(aCart);
      carts.add(index, aCart);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCartAt(Cart aCart, int index)
  {
    boolean wasAdded = false;
    if(carts.contains(aCart))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCarts()) { index = numberOfCarts() - 1; }
      carts.remove(aCart);
      carts.add(index, aCart);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCartAt(aCart, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfShipments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Shipment addShipment(boolean aShipped, Date aShippingDate, Manager aShipmentManager)
  {
    return new Shipment(aShipped, aShippingDate, aShipmentManager, this);
  }

  public boolean addShipment(Shipment aShipment)
  {
    boolean wasAdded = false;
    if (shipments.contains(aShipment)) { return false; }
    FashionStoreManagementApp existingSystem = aShipment.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aShipment.setSystem(this);
    }
    else
    {
      shipments.add(aShipment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShipment(Shipment aShipment)
  {
    boolean wasRemoved = false;
    //Unable to remove aShipment, as it must always have a system
    if (!this.equals(aShipment.getSystem()))
    {
      shipments.remove(aShipment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addShipmentAt(Shipment aShipment, int index)
  {  
    boolean wasAdded = false;
    if(addShipment(aShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipments()) { index = numberOfShipments() - 1; }
      shipments.remove(aShipment);
      shipments.add(index, aShipment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShipmentAt(Shipment aShipment, int index)
  {
    boolean wasAdded = false;
    if(shipments.contains(aShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipments()) { index = numberOfShipments() - 1; }
      shipments.remove(aShipment);
      shipments.add(index, aShipment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShipmentAt(aShipment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSavedAddresses()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Address addSavedAddress(String aAddressLineOne, String aPostalCode, String aCity, String aCountry, Customer aCustomer)
  {
    return new Address(aAddressLineOne, aPostalCode, aCity, aCountry, aCustomer, this);
  }

  public boolean addSavedAddress(Address aSavedAddress)
  {
    boolean wasAdded = false;
    if (savedAddresses.contains(aSavedAddress)) { return false; }
    FashionStoreManagementApp existingSystem = aSavedAddress.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aSavedAddress.setSystem(this);
    }
    else
    {
      savedAddresses.add(aSavedAddress);
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
      savedAddresses.remove(aSavedAddress);
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
      if(index > numberOfSavedAddresses()) { index = numberOfSavedAddresses() - 1; }
      savedAddresses.remove(aSavedAddress);
      savedAddresses.add(index, aSavedAddress);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSavedAddressAt(Address aSavedAddress, int index)
  {
    boolean wasAdded = false;
    if(savedAddresses.contains(aSavedAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSavedAddresses()) { index = numberOfSavedAddresses() - 1; }
      savedAddresses.remove(aSavedAddress);
      savedAddresses.add(index, aSavedAddress);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSavedAddressAt(aSavedAddress, index);
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
    
    while( !stockedItems.isEmpty() )
    {
      stockedItems.get(0).setInventory(null);
    }
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
    while (loggedOrders.size() > 0)
    {
      Order aLoggedOrder = loggedOrders.get(loggedOrders.size() - 1);
      aLoggedOrder.delete();
      loggedOrders.remove(aLoggedOrder);
    }
    
    while (carts.size() > 0)
    {
      Cart aCart = carts.get(carts.size() - 1);
      aCart.delete();
      carts.remove(aCart);
    }
    
    while (shipments.size() > 0)
    {
      Shipment aShipment = shipments.get(shipments.size() - 1);
      aShipment.delete();
      shipments.remove(aShipment);
    }
    
    while (savedAddresses.size() > 0)
    {
      Address aSavedAddress = savedAddresses.get(savedAddresses.size() - 1);
      aSavedAddress.delete();
      savedAddresses.remove(aSavedAddress);
    }
    
    while (accounts.size() > 0)
    {
      AccountType aAccount = accounts.get(accounts.size() - 1);
      aAccount.delete();
      accounts.remove(aAccount);
    }
    
  }

}