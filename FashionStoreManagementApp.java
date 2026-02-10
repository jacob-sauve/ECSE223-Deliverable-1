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
  private List<User> users;
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
    users = new ArrayList<User>();
    shipments = new ArrayList<Shipment>();
  }

  public FashionStoreManagementApp()
  {
    inventory = new Inventory(this);
    users = new ArrayList<User>();
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
    FashionStoreManagementApp existingApp = aUser.getApp();
    boolean isNewApp = existingApp != null && !this.equals(existingApp);
    if (isNewApp)
    {
      aUser.setApp(this);
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
    //Unable to remove aUser, as it must always have a app
    if (!this.equals(aUser.getApp()))
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
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
    while (shipments.size() > 0)
    {
      Shipment aShipment = shipments.get(shipments.size() - 1);
      aShipment.delete();
      shipments.remove(aShipment);
    }
    
  }

}