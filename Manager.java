/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 25 "FashionProjectManagementApp.ump"
public class Manager extends AccountType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Attributes
  private String username;
  private String password;

  //Manager Associations
  private FashionStoreManagementApp system;
  private List<Order> ordersToAssign;
  private List<Shipment> shipments;
  private List<Employee> managedEmployees;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager(String aUsername, String aPassword, User aPerson, FashionStoreManagementApp aSystem, FashionStoreManagementApp aSystem)
  {
    super(aUsername, aPassword, aPerson, aSystem);
    username = "manager";
    password = "manager";
    if (aSystem == null || aSystem.getStoreManager() != null)
    {
      throw new RuntimeException("Unable to create Manager due to aSystem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    system = aSystem;
    ordersToAssign = new ArrayList<Order>();
    shipments = new ArrayList<Shipment>();
    managedEmployees = new ArrayList<Employee>();
  }

  public Manager(String aUsername, String aPassword, User aPerson)
  {
    super(aUsername, aPassword, aPerson, aSystem);
    username = "manager";
    password = "manager";
    system = new FashionStoreManagementApp(this);
    ordersToAssign = new ArrayList<Order>();
    shipments = new ArrayList<Shipment>();
    managedEmployees = new ArrayList<Employee>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getSystem()
  {
    return system;
  }
  /* Code from template association_GetMany */
  public Order getOrdersToAssign(int index)
  {
    Order aOrdersToAssign = ordersToAssign.get(index);
    return aOrdersToAssign;
  }

  public List<Order> getOrdersToAssign()
  {
    List<Order> newOrdersToAssign = Collections.unmodifiableList(ordersToAssign);
    return newOrdersToAssign;
  }

  public int numberOfOrdersToAssign()
  {
    int number = ordersToAssign.size();
    return number;
  }

  public boolean hasOrdersToAssign()
  {
    boolean has = ordersToAssign.size() > 0;
    return has;
  }

  public int indexOfOrdersToAssign(Order aOrdersToAssign)
  {
    int index = ordersToAssign.indexOf(aOrdersToAssign);
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
  public Employee getManagedEmployee(int index)
  {
    Employee aManagedEmployee = managedEmployees.get(index);
    return aManagedEmployee;
  }

  public List<Employee> getManagedEmployees()
  {
    List<Employee> newManagedEmployees = Collections.unmodifiableList(managedEmployees);
    return newManagedEmployees;
  }

  public int numberOfManagedEmployees()
  {
    int number = managedEmployees.size();
    return number;
  }

  public boolean hasManagedEmployees()
  {
    boolean has = managedEmployees.size() > 0;
    return has;
  }

  public int indexOfManagedEmployee(Employee aManagedEmployee)
  {
    int index = managedEmployees.indexOf(aManagedEmployee);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrdersToAssign()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrdersToAssign(int aOrderNumber, int aShippingDelay, Customer aCustomer, Employee aItemGatherer, Cart aPaidCart, Address aDeliveryAddress, FashionStoreManagementApp aSystem)
  {
    return new Order(aOrderNumber, aShippingDelay, aCustomer, this, aItemGatherer, aPaidCart, aDeliveryAddress, aSystem);
  }

  public boolean addOrdersToAssign(Order aOrdersToAssign)
  {
    boolean wasAdded = false;
    if (ordersToAssign.contains(aOrdersToAssign)) { return false; }
    Manager existingManager = aOrdersToAssign.getManager();
    boolean isNewManager = existingManager != null && !this.equals(existingManager);
    if (isNewManager)
    {
      aOrdersToAssign.setManager(this);
    }
    else
    {
      ordersToAssign.add(aOrdersToAssign);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrdersToAssign(Order aOrdersToAssign)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrdersToAssign, as it must always have a manager
    if (!this.equals(aOrdersToAssign.getManager()))
    {
      ordersToAssign.remove(aOrdersToAssign);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrdersToAssignAt(Order aOrdersToAssign, int index)
  {  
    boolean wasAdded = false;
    if(addOrdersToAssign(aOrdersToAssign))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrdersToAssign()) { index = numberOfOrdersToAssign() - 1; }
      ordersToAssign.remove(aOrdersToAssign);
      ordersToAssign.add(index, aOrdersToAssign);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrdersToAssignAt(Order aOrdersToAssign, int index)
  {
    boolean wasAdded = false;
    if(ordersToAssign.contains(aOrdersToAssign))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrdersToAssign()) { index = numberOfOrdersToAssign() - 1; }
      ordersToAssign.remove(aOrdersToAssign);
      ordersToAssign.add(index, aOrdersToAssign);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrdersToAssignAt(aOrdersToAssign, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfShipments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Shipment addShipment(boolean aShipped, FashionStoreManagementApp aSystem)
  {
    return new Shipment(aShipped, this, aSystem);
  }

  public boolean addShipment(Shipment aShipment)
  {
    boolean wasAdded = false;
    if (shipments.contains(aShipment)) { return false; }
    Manager existingShipmentManager = aShipment.getShipmentManager();
    boolean isNewShipmentManager = existingShipmentManager != null && !this.equals(existingShipmentManager);
    if (isNewShipmentManager)
    {
      aShipment.setShipmentManager(this);
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
    //Unable to remove aShipment, as it must always have a shipmentManager
    if (!this.equals(aShipment.getShipmentManager()))
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
  public static int minimumNumberOfManagedEmployees()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Employee addManagedEmployee(String aUsername, String aPassword, User aPerson, FashionStoreManagementApp aSystem)
  {
    return new Employee(aUsername, aPassword, aPerson, aSystem, this);
  }

  public boolean addManagedEmployee(Employee aManagedEmployee)
  {
    boolean wasAdded = false;
    if (managedEmployees.contains(aManagedEmployee)) { return false; }
    Manager existingStoreManager = aManagedEmployee.getStoreManager();
    boolean isNewStoreManager = existingStoreManager != null && !this.equals(existingStoreManager);
    if (isNewStoreManager)
    {
      aManagedEmployee.setStoreManager(this);
    }
    else
    {
      managedEmployees.add(aManagedEmployee);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeManagedEmployee(Employee aManagedEmployee)
  {
    boolean wasRemoved = false;
    //Unable to remove aManagedEmployee, as it must always have a storeManager
    if (!this.equals(aManagedEmployee.getStoreManager()))
    {
      managedEmployees.remove(aManagedEmployee);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addManagedEmployeeAt(Employee aManagedEmployee, int index)
  {  
    boolean wasAdded = false;
    if(addManagedEmployee(aManagedEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManagedEmployees()) { index = numberOfManagedEmployees() - 1; }
      managedEmployees.remove(aManagedEmployee);
      managedEmployees.add(index, aManagedEmployee);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveManagedEmployeeAt(Employee aManagedEmployee, int index)
  {
    boolean wasAdded = false;
    if(managedEmployees.contains(aManagedEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManagedEmployees()) { index = numberOfManagedEmployees() - 1; }
      managedEmployees.remove(aManagedEmployee);
      managedEmployees.add(index, aManagedEmployee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addManagedEmployeeAt(aManagedEmployee, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    FashionStoreManagementApp existingSystem = system;
    system = null;
    if (existingSystem != null)
    {
      existingSystem.delete();
    }
    for(int i=ordersToAssign.size(); i > 0; i--)
    {
      Order aOrdersToAssign = ordersToAssign.get(i - 1);
      aOrdersToAssign.delete();
    }
    for(int i=shipments.size(); i > 0; i--)
    {
      Shipment aShipment = shipments.get(i - 1);
      aShipment.delete();
    }
    for(int i=managedEmployees.size(); i > 0; i--)
    {
      Employee aManagedEmployee = managedEmployees.get(i - 1);
      aManagedEmployee.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "system = "+(getSystem()!=null?Integer.toHexString(System.identityHashCode(getSystem())):"null");
  }
}