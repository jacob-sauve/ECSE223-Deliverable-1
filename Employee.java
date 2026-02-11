/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.8072.d3fbfafbc modeling language!*/


import java.util.*;

// line 22 "model.ump"
// line 142 "model.ump"
public class Employee extends AccountType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Associations
  private List<Order> ordersToAssemble;
  private Manager storeManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aUsername, String aPassword, User aPerson, FashionStoreManagementApp aSystem, Manager aStoreManager)
  {
    super(aUsername, aPassword, aPerson, aSystem);
    ordersToAssemble = new ArrayList<Order>();
    boolean didAddStoreManager = setStoreManager(aStoreManager);
    if (!didAddStoreManager)
    {
      throw new RuntimeException("Unable to create managedEmployee due to storeManager. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Order getOrdersToAssemble(int index)
  {
    Order aOrdersToAssemble = ordersToAssemble.get(index);
    return aOrdersToAssemble;
  }

  public List<Order> getOrdersToAssemble()
  {
    List<Order> newOrdersToAssemble = Collections.unmodifiableList(ordersToAssemble);
    return newOrdersToAssemble;
  }

  public int numberOfOrdersToAssemble()
  {
    int number = ordersToAssemble.size();
    return number;
  }

  public boolean hasOrdersToAssemble()
  {
    boolean has = ordersToAssemble.size() > 0;
    return has;
  }

  public int indexOfOrdersToAssemble(Order aOrdersToAssemble)
  {
    int index = ordersToAssemble.indexOf(aOrdersToAssemble);
    return index;
  }
  /* Code from template association_GetOne */
  public Manager getStoreManager()
  {
    return storeManager;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrdersToAssemble()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrdersToAssemble(int aOrderNumber, int aShippingDelay, Customer aCustomer, Manager aManager, Cart aPaidCart, Address aDeliveryAddress, FashionStoreManagementApp aSystem)
  {
    return new Order(aOrderNumber, aShippingDelay, aCustomer, aManager, this, aPaidCart, aDeliveryAddress, aSystem);
  }

  public boolean addOrdersToAssemble(Order aOrdersToAssemble)
  {
    boolean wasAdded = false;
    if (ordersToAssemble.contains(aOrdersToAssemble)) { return false; }
    Employee existingItemGatherer = aOrdersToAssemble.getItemGatherer();
    boolean isNewItemGatherer = existingItemGatherer != null && !this.equals(existingItemGatherer);
    if (isNewItemGatherer)
    {
      aOrdersToAssemble.setItemGatherer(this);
    }
    else
    {
      ordersToAssemble.add(aOrdersToAssemble);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrdersToAssemble(Order aOrdersToAssemble)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrdersToAssemble, as it must always have a itemGatherer
    if (!this.equals(aOrdersToAssemble.getItemGatherer()))
    {
      ordersToAssemble.remove(aOrdersToAssemble);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrdersToAssembleAt(Order aOrdersToAssemble, int index)
  {  
    boolean wasAdded = false;
    if(addOrdersToAssemble(aOrdersToAssemble))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrdersToAssemble()) { index = numberOfOrdersToAssemble() - 1; }
      ordersToAssemble.remove(aOrdersToAssemble);
      ordersToAssemble.add(index, aOrdersToAssemble);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrdersToAssembleAt(Order aOrdersToAssemble, int index)
  {
    boolean wasAdded = false;
    if(ordersToAssemble.contains(aOrdersToAssemble))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrdersToAssemble()) { index = numberOfOrdersToAssemble() - 1; }
      ordersToAssemble.remove(aOrdersToAssemble);
      ordersToAssemble.add(index, aOrdersToAssemble);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrdersToAssembleAt(aOrdersToAssemble, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setStoreManager(Manager aStoreManager)
  {
    boolean wasSet = false;
    if (aStoreManager == null)
    {
      return wasSet;
    }

    Manager existingStoreManager = storeManager;
    storeManager = aStoreManager;
    if (existingStoreManager != null && !existingStoreManager.equals(aStoreManager))
    {
      existingStoreManager.removeManagedEmployee(this);
    }
    storeManager.addManagedEmployee(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=ordersToAssemble.size(); i > 0; i--)
    {
      Order aOrdersToAssemble = ordersToAssemble.get(i - 1);
      aOrdersToAssemble.delete();
    }
    Manager placeholderStoreManager = storeManager;
    this.storeManager = null;
    if(placeholderStoreManager != null)
    {
      placeholderStoreManager.removeManagedEmployee(this);
    }
    super.delete();
  }

}