/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 20 "FashionProjectManagementApp.ump"
public class Customer extends AccountType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private int loyaltyPoints;

  //Customer Associations
  private List<Address> shippingAddresses;
  private Cart cart;
  private List<Order> paidOrders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aUsername, String aPassword, User aPerson, FashionStoreManagementApp aSystem, int aLoyaltyPoints, Cart aCart)
  {
    super(aUsername, aPassword, aPerson, aSystem);
    loyaltyPoints = aLoyaltyPoints;
    shippingAddresses = new ArrayList<Address>();
    if (aCart == null || aCart.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aCart. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cart = aCart;
    paidOrders = new ArrayList<Order>();
  }

  public Customer(String aUsername, String aPassword, User aPerson, FashionStoreManagementApp aSystem, int aLoyaltyPoints)
  {
    super(aUsername, aPassword, aPerson, aSystem);
    loyaltyPoints = aLoyaltyPoints;
    shippingAddresses = new ArrayList<Address>();
    cart = new Cart(this);
    paidOrders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLoyaltyPoints(int aLoyaltyPoints)
  {
    boolean wasSet = false;
    loyaltyPoints = aLoyaltyPoints;
    wasSet = true;
    return wasSet;
  }

  public int getLoyaltyPoints()
  {
    return loyaltyPoints;
  }
  /* Code from template association_GetMany */
  public Address getShippingAddress(int index)
  {
    Address aShippingAddress = shippingAddresses.get(index);
    return aShippingAddress;
  }

  public List<Address> getShippingAddresses()
  {
    List<Address> newShippingAddresses = Collections.unmodifiableList(shippingAddresses);
    return newShippingAddresses;
  }

  public int numberOfShippingAddresses()
  {
    int number = shippingAddresses.size();
    return number;
  }

  public boolean hasShippingAddresses()
  {
    boolean has = shippingAddresses.size() > 0;
    return has;
  }

  public int indexOfShippingAddress(Address aShippingAddress)
  {
    int index = shippingAddresses.indexOf(aShippingAddress);
    return index;
  }
  /* Code from template association_GetOne */
  public Cart getCart()
  {
    return cart;
  }
  /* Code from template association_GetMany */
  public Order getPaidOrder(int index)
  {
    Order aPaidOrder = paidOrders.get(index);
    return aPaidOrder;
  }

  public List<Order> getPaidOrders()
  {
    List<Order> newPaidOrders = Collections.unmodifiableList(paidOrders);
    return newPaidOrders;
  }

  public int numberOfPaidOrders()
  {
    int number = paidOrders.size();
    return number;
  }

  public boolean hasPaidOrders()
  {
    boolean has = paidOrders.size() > 0;
    return has;
  }

  public int indexOfPaidOrder(Order aPaidOrder)
  {
    int index = paidOrders.indexOf(aPaidOrder);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfShippingAddressesValid()
  {
    boolean isValid = numberOfShippingAddresses() >= minimumNumberOfShippingAddresses();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfShippingAddresses()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addShippingAddress(Address aShippingAddress)
  {
    boolean wasAdded = false;
    if (shippingAddresses.contains(aShippingAddress)) { return false; }
    shippingAddresses.add(aShippingAddress);
    if (aShippingAddress.indexOfCustomer(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aShippingAddress.addCustomer(this);
      if (!wasAdded)
      {
        shippingAddresses.remove(aShippingAddress);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeShippingAddress(Address aShippingAddress)
  {
    boolean wasRemoved = false;
    if (!shippingAddresses.contains(aShippingAddress))
    {
      return wasRemoved;
    }

    if (numberOfShippingAddresses() <= minimumNumberOfShippingAddresses())
    {
      return wasRemoved;
    }

    int oldIndex = shippingAddresses.indexOf(aShippingAddress);
    shippingAddresses.remove(oldIndex);
    if (aShippingAddress.indexOfCustomer(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aShippingAddress.removeCustomer(this);
      if (!wasRemoved)
      {
        shippingAddresses.add(oldIndex,aShippingAddress);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setShippingAddresses(Address... newShippingAddresses)
  {
    boolean wasSet = false;
    ArrayList<Address> verifiedShippingAddresses = new ArrayList<Address>();
    for (Address aShippingAddress : newShippingAddresses)
    {
      if (verifiedShippingAddresses.contains(aShippingAddress))
      {
        continue;
      }
      verifiedShippingAddresses.add(aShippingAddress);
    }

    if (verifiedShippingAddresses.size() != newShippingAddresses.length || verifiedShippingAddresses.size() < minimumNumberOfShippingAddresses())
    {
      return wasSet;
    }

    ArrayList<Address> oldShippingAddresses = new ArrayList<Address>(shippingAddresses);
    shippingAddresses.clear();
    for (Address aNewShippingAddress : verifiedShippingAddresses)
    {
      shippingAddresses.add(aNewShippingAddress);
      if (oldShippingAddresses.contains(aNewShippingAddress))
      {
        oldShippingAddresses.remove(aNewShippingAddress);
      }
      else
      {
        aNewShippingAddress.addCustomer(this);
      }
    }

    for (Address anOldShippingAddress : oldShippingAddresses)
    {
      anOldShippingAddress.removeCustomer(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addShippingAddressAt(Address aShippingAddress, int index)
  {  
    boolean wasAdded = false;
    if(addShippingAddress(aShippingAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShippingAddresses()) { index = numberOfShippingAddresses() - 1; }
      shippingAddresses.remove(aShippingAddress);
      shippingAddresses.add(index, aShippingAddress);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShippingAddressAt(Address aShippingAddress, int index)
  {
    boolean wasAdded = false;
    if(shippingAddresses.contains(aShippingAddress))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShippingAddresses()) { index = numberOfShippingAddresses() - 1; }
      shippingAddresses.remove(aShippingAddress);
      shippingAddresses.add(index, aShippingAddress);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShippingAddressAt(aShippingAddress, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPaidOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addPaidOrder(int aOrderNumber, int aShippingDelay, Manager aManager, Employee aItemGatherer, Cart aPaidCart, Address aDeliveryAddress, FashionStoreManagementApp aSystem)
  {
    return new Order(aOrderNumber, aShippingDelay, this, aManager, aItemGatherer, aPaidCart, aDeliveryAddress, aSystem);
  }

  public boolean addPaidOrder(Order aPaidOrder)
  {
    boolean wasAdded = false;
    if (paidOrders.contains(aPaidOrder)) { return false; }
    Customer existingCustomer = aPaidOrder.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);
    if (isNewCustomer)
    {
      aPaidOrder.setCustomer(this);
    }
    else
    {
      paidOrders.add(aPaidOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePaidOrder(Order aPaidOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aPaidOrder, as it must always have a customer
    if (!this.equals(aPaidOrder.getCustomer()))
    {
      paidOrders.remove(aPaidOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPaidOrderAt(Order aPaidOrder, int index)
  {  
    boolean wasAdded = false;
    if(addPaidOrder(aPaidOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPaidOrders()) { index = numberOfPaidOrders() - 1; }
      paidOrders.remove(aPaidOrder);
      paidOrders.add(index, aPaidOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePaidOrderAt(Order aPaidOrder, int index)
  {
    boolean wasAdded = false;
    if(paidOrders.contains(aPaidOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPaidOrders()) { index = numberOfPaidOrders() - 1; }
      paidOrders.remove(aPaidOrder);
      paidOrders.add(index, aPaidOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPaidOrderAt(aPaidOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Address> copyOfShippingAddresses = new ArrayList<Address>(shippingAddresses);
    shippingAddresses.clear();
    for(Address aShippingAddress : copyOfShippingAddresses)
    {
      if (aShippingAddress.numberOfCustomers() <= Address.minimumNumberOfCustomers())
      {
        aShippingAddress.delete();
      }
      else
      {
        aShippingAddress.removeCustomer(this);
      }
    }
    Cart existingCart = cart;
    cart = null;
    if (existingCart != null)
    {
      existingCart.delete();
    }
    for(int i=paidOrders.size(); i > 0; i--)
    {
      Order aPaidOrder = paidOrders.get(i - 1);
      aPaidOrder.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "loyaltyPoints" + ":" + getLoyaltyPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "cart = "+(getCart()!=null?Integer.toHexString(System.identityHashCode(getCart())):"null");
  }
}