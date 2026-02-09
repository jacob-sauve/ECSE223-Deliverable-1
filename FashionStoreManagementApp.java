/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 1 "FashionProjectManagementApp.ump"
public class FashionStoreManagementApp
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FashionStoreManagementApp Associations
  private Inventory inventory;
  private List<UserAccount> userAccounts;
  private List<Shipment> shipments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FashionStoreManagementApp(Inventory aInventory)
  {
    if (aInventory == null || aInventory.getApp() != null)
    {
      throw new RuntimeException("Unable to create FashionStoreManagementApp due to aInventory. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    inventory = aInventory;
    userAccounts = new ArrayList<UserAccount>();
    shipments = new ArrayList<Shipment>();
  }

  public FashionStoreManagementApp()
  {
    inventory = new Inventory(this);
    userAccounts = new ArrayList<UserAccount>();
    shipments = new ArrayList<Shipment>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Inventory getInventory()
  {
    return inventory;
  }
  /* Code from template association_GetMany */
  public UserAccount getUserAccount(int index)
  {
    UserAccount aUserAccount = userAccounts.get(index);
    return aUserAccount;
  }

  public List<UserAccount> getUserAccounts()
  {
    List<UserAccount> newUserAccounts = Collections.unmodifiableList(userAccounts);
    return newUserAccounts;
  }

  public int numberOfUserAccounts()
  {
    int number = userAccounts.size();
    return number;
  }

  public boolean hasUserAccounts()
  {
    boolean has = userAccounts.size() > 0;
    return has;
  }

  public int indexOfUserAccount(UserAccount aUserAccount)
  {
    int index = userAccounts.indexOf(aUserAccount);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUserAccounts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addUserAccount(UserAccount aUserAccount)
  {
    boolean wasAdded = false;
    if (userAccounts.contains(aUserAccount)) { return false; }
    FashionStoreManagementApp existingApp = aUserAccount.getApp();
    boolean isNewApp = existingApp != null && !this.equals(existingApp);
    if (isNewApp)
    {
      aUserAccount.setApp(this);
    }
    else
    {
      userAccounts.add(aUserAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUserAccount(UserAccount aUserAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aUserAccount, as it must always have a app
    if (!this.equals(aUserAccount.getApp()))
    {
      userAccounts.remove(aUserAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAccountAt(UserAccount aUserAccount, int index)
  {  
    boolean wasAdded = false;
    if(addUserAccount(aUserAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserAccounts()) { index = numberOfUserAccounts() - 1; }
      userAccounts.remove(aUserAccount);
      userAccounts.add(index, aUserAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAccountAt(UserAccount aUserAccount, int index)
  {
    boolean wasAdded = false;
    if(userAccounts.contains(aUserAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserAccounts()) { index = numberOfUserAccounts() - 1; }
      userAccounts.remove(aUserAccount);
      userAccounts.add(index, aUserAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAccountAt(aUserAccount, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfShipments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Shipment addShipment(Date aDateOrdered)
  {
    return new Shipment(aDateOrdered, this);
  }

  public boolean addShipment(Shipment aShipment)
  {
    boolean wasAdded = false;
    if (shipments.contains(aShipment)) { return false; }
    FashionStoreManagementApp existingApp = aShipment.getApp();
    boolean isNewApp = existingApp != null && !this.equals(existingApp);
    if (isNewApp)
    {
      aShipment.setApp(this);
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
    //Unable to remove aShipment, as it must always have a app
    if (!this.equals(aShipment.getApp()))
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

  public void delete()
  {
    Inventory existingInventory = inventory;
    inventory = null;
    if (existingInventory != null)
    {
      existingInventory.delete();
    }
    while (userAccounts.size() > 0)
    {
      UserAccount aUserAccount = userAccounts.get(userAccounts.size() - 1);
      aUserAccount.delete();
      userAccounts.remove(aUserAccount);
    }
    
    while (shipments.size() > 0)
    {
      Shipment aShipment = shipments.get(shipments.size() - 1);
      aShipment.delete();
      shipments.remove(aShipment);
    }
    
  }

}