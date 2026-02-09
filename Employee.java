/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 5 "FashionProjectManagementApp.ump"
public class Employee extends UserAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Associations
  private List<Order> assignedOrders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aUsername, String aPassword, FashionStoreManagementApp aApp)
  {
    super(aUsername, aPassword, aApp);
    assignedOrders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Order getAssignedOrder(int index)
  {
    Order aAssignedOrder = assignedOrders.get(index);
    return aAssignedOrder;
  }

  public List<Order> getAssignedOrders()
  {
    List<Order> newAssignedOrders = Collections.unmodifiableList(assignedOrders);
    return newAssignedOrders;
  }

  public int numberOfAssignedOrders()
  {
    int number = assignedOrders.size();
    return number;
  }

  public boolean hasAssignedOrders()
  {
    boolean has = assignedOrders.size() > 0;
    return has;
  }

  public int indexOfAssignedOrder(Order aAssignedOrder)
  {
    int index = assignedOrders.indexOf(aAssignedOrder);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssignedOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addAssignedOrder(Date aDateOrdered, int aDaysUntilDelivery, Customer aCustomer)
  {
    return new Order(aDateOrdered, aDaysUntilDelivery, aCustomer, this);
  }

  public boolean addAssignedOrder(Order aAssignedOrder)
  {
    boolean wasAdded = false;
    if (assignedOrders.contains(aAssignedOrder)) { return false; }
    Employee existingItemGatherer = aAssignedOrder.getItemGatherer();
    boolean isNewItemGatherer = existingItemGatherer != null && !this.equals(existingItemGatherer);
    if (isNewItemGatherer)
    {
      aAssignedOrder.setItemGatherer(this);
    }
    else
    {
      assignedOrders.add(aAssignedOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssignedOrder(Order aAssignedOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aAssignedOrder, as it must always have a itemGatherer
    if (!this.equals(aAssignedOrder.getItemGatherer()))
    {
      assignedOrders.remove(aAssignedOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssignedOrderAt(Order aAssignedOrder, int index)
  {  
    boolean wasAdded = false;
    if(addAssignedOrder(aAssignedOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedOrders()) { index = numberOfAssignedOrders() - 1; }
      assignedOrders.remove(aAssignedOrder);
      assignedOrders.add(index, aAssignedOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssignedOrderAt(Order aAssignedOrder, int index)
  {
    boolean wasAdded = false;
    if(assignedOrders.contains(aAssignedOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignedOrders()) { index = numberOfAssignedOrders() - 1; }
      assignedOrders.remove(aAssignedOrder);
      assignedOrders.add(index, aAssignedOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssignedOrderAt(aAssignedOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=assignedOrders.size(); i > 0; i--)
    {
      Order aAssignedOrder = assignedOrders.get(i - 1);
      aAssignedOrder.delete();
    }
    super.delete();
  }

}