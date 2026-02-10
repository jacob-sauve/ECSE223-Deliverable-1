/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;
import java.sql.Date;

// line 35 "FashionProjectManagementApp.ump"
public class Customer extends UserAccount
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String address;
  private int loyaltyPoints;

  //Customer Associations
  private Cart cart;
  private List<Order> orders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aUsername, String aPassword, User aUser, FashionStoreManagementApp aApp, String aAddress, int aLoyaltyPoints, Cart aCart)
  {
    super(aUsername, aPassword, aUser, aApp);
    address = aAddress;
    loyaltyPoints = aLoyaltyPoints;
    if (aCart == null || aCart.getShopper() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aCart. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cart = aCart;
    orders = new ArrayList<Order>();
  }

  public Customer(String aUsername, String aPassword, User aUser, FashionStoreManagementApp aApp, String aAddress, int aLoyaltyPoints, double aTotalPriceForCart)
  {
    super(aUsername, aPassword, aUser, aApp);
    address = aAddress;
    loyaltyPoints = aLoyaltyPoints;
    cart = new Cart(aTotalPriceForCart, this);
    orders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setLoyaltyPoints(int aLoyaltyPoints)
  {
    boolean wasSet = false;
    loyaltyPoints = aLoyaltyPoints;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }

  public int getLoyaltyPoints()
  {
    return loyaltyPoints;
  }
  /* Code from template association_GetOne */
  public Cart getCart()
  {
    return cart;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(Date aDateOrdered, int aDaysUntilDelivery, Employee aItemGatherer)
  {
    return new Order(aDateOrdered, aDaysUntilDelivery, this, aItemGatherer);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Customer existingCustomer = aOrder.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);
    if (isNewCustomer)
    {
      aOrder.setCustomer(this);
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
    //Unable to remove aOrder, as it must always have a customer
    if (!this.equals(aOrder.getCustomer()))
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

  public void delete()
  {
    Cart existingCart = cart;
    cart = null;
    if (existingCart != null)
    {
      existingCart.delete();
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "," +
            "loyaltyPoints" + ":" + getLoyaltyPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cart = "+(getCart()!=null?Integer.toHexString(System.identityHashCode(getCart())):"null");
  }
}