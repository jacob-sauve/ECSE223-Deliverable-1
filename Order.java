/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 13 "FashionProjectManagementApp.ump"
public class Order
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextOrderNumber = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private Date dateOrdered;
  private int daysUntilDelivery;

  //Autounique Attributes

  /**
   * auto-incremented unique Integer
   */
  private int orderNumber;

  //Order Associations
  private Customer customer;
  private List<ClothingItem> requestedItems;
  private Employee itemGatherer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(Date aDateOrdered, int aDaysUntilDelivery, Customer aCustomer, Employee aItemGatherer)
  {
    dateOrdered = aDateOrdered;
    daysUntilDelivery = aDaysUntilDelivery;
    orderNumber = nextOrderNumber++;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create order due to customer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    requestedItems = new ArrayList<ClothingItem>();
    boolean didAddItemGatherer = setItemGatherer(aItemGatherer);
    if (!didAddItemGatherer)
    {
      throw new RuntimeException("Unable to create assignedOrder due to itemGatherer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aDaysUntilDelivery<0||aDaysUntilDelivery>3)
    {
      throw new RuntimeException("Please provide a valid daysUntilDelivery [daysUntilDelivery>=0&&daysUntilDelivery<=3]");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDateOrdered(Date aDateOrdered)
  {
    boolean wasSet = false;
    dateOrdered = aDateOrdered;
    wasSet = true;
    return wasSet;
  }

  public boolean setDaysUntilDelivery(int aDaysUntilDelivery)
  {
    boolean wasSet = false;
    if (aDaysUntilDelivery>=0&&aDaysUntilDelivery<=3)
    {
    daysUntilDelivery = aDaysUntilDelivery;
    wasSet = true;
    }
    return wasSet;
  }

  public Date getDateOrdered()
  {
    return dateOrdered;
  }

  public int getDaysUntilDelivery()
  {
    return daysUntilDelivery;
  }

  /**
   * auto-incremented unique Integer
   */
  public int getOrderNumber()
  {
    return orderNumber;
  }
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
  }
  /* Code from template association_GetMany */
  public ClothingItem getRequestedItem(int index)
  {
    ClothingItem aRequestedItem = requestedItems.get(index);
    return aRequestedItem;
  }

  public List<ClothingItem> getRequestedItems()
  {
    List<ClothingItem> newRequestedItems = Collections.unmodifiableList(requestedItems);
    return newRequestedItems;
  }

  public int numberOfRequestedItems()
  {
    int number = requestedItems.size();
    return number;
  }

  public boolean hasRequestedItems()
  {
    boolean has = requestedItems.size() > 0;
    return has;
  }

  public int indexOfRequestedItem(ClothingItem aRequestedItem)
  {
    int index = requestedItems.indexOf(aRequestedItem);
    return index;
  }
  /* Code from template association_GetOne */
  public Employee getItemGatherer()
  {
    return itemGatherer;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeOrder(this);
    }
    customer.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRequestedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addRequestedItem(ClothingItem aRequestedItem)
  {
    boolean wasAdded = false;
    if (requestedItems.contains(aRequestedItem)) { return false; }
    requestedItems.add(aRequestedItem);
    if (aRequestedItem.indexOfOrder(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRequestedItem.addOrder(this);
      if (!wasAdded)
      {
        requestedItems.remove(aRequestedItem);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeRequestedItem(ClothingItem aRequestedItem)
  {
    boolean wasRemoved = false;
    if (!requestedItems.contains(aRequestedItem))
    {
      return wasRemoved;
    }

    int oldIndex = requestedItems.indexOf(aRequestedItem);
    requestedItems.remove(oldIndex);
    if (aRequestedItem.indexOfOrder(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRequestedItem.removeOrder(this);
      if (!wasRemoved)
      {
        requestedItems.add(oldIndex,aRequestedItem);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRequestedItemAt(ClothingItem aRequestedItem, int index)
  {  
    boolean wasAdded = false;
    if(addRequestedItem(aRequestedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRequestedItems()) { index = numberOfRequestedItems() - 1; }
      requestedItems.remove(aRequestedItem);
      requestedItems.add(index, aRequestedItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRequestedItemAt(ClothingItem aRequestedItem, int index)
  {
    boolean wasAdded = false;
    if(requestedItems.contains(aRequestedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRequestedItems()) { index = numberOfRequestedItems() - 1; }
      requestedItems.remove(aRequestedItem);
      requestedItems.add(index, aRequestedItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRequestedItemAt(aRequestedItem, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setItemGatherer(Employee aItemGatherer)
  {
    boolean wasSet = false;
    if (aItemGatherer == null)
    {
      return wasSet;
    }

    Employee existingItemGatherer = itemGatherer;
    itemGatherer = aItemGatherer;
    if (existingItemGatherer != null && !existingItemGatherer.equals(aItemGatherer))
    {
      existingItemGatherer.removeAssignedOrder(this);
    }
    itemGatherer.addAssignedOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removeOrder(this);
    }
    ArrayList<ClothingItem> copyOfRequestedItems = new ArrayList<ClothingItem>(requestedItems);
    requestedItems.clear();
    for(ClothingItem aRequestedItem : copyOfRequestedItems)
    {
      aRequestedItem.removeOrder(this);
    }
    Employee placeholderItemGatherer = itemGatherer;
    this.itemGatherer = null;
    if(placeholderItemGatherer != null)
    {
      placeholderItemGatherer.removeAssignedOrder(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "daysUntilDelivery" + ":" + getDaysUntilDelivery()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOrdered" + "=" + (getDateOrdered() != null ? !getDateOrdered().equals(this)  ? getDateOrdered().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "itemGatherer = "+(getItemGatherer()!=null?Integer.toHexString(System.identityHashCode(getItemGatherer())):"null");
  }
}