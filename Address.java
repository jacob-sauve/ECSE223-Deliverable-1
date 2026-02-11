/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 31 "FashionProjectManagementApp.ump"
public class Address
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Address Attributes
  private String addressLineOne;
  private String postalCode;
  private String city;
  private String country;

  //Address Associations
  private Customer customer;
  private List<Order> orders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Address(String aAddressLineOne, String aPostalCode, String aCity, String aCountry, Customer aCustomer)
  {
    addressLineOne = aAddressLineOne;
    postalCode = aPostalCode;
    city = aCity;
    country = aCountry;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create shippingAddress due to customer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    orders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddressLineOne(String aAddressLineOne)
  {
    boolean wasSet = false;
    addressLineOne = aAddressLineOne;
    wasSet = true;
    return wasSet;
  }

  public boolean setPostalCode(String aPostalCode)
  {
    boolean wasSet = false;
    postalCode = aPostalCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountry(String aCountry)
  {
    boolean wasSet = false;
    country = aCountry;
    wasSet = true;
    return wasSet;
  }

  public String getAddressLineOne()
  {
    return addressLineOne;
  }

  public String getPostalCode()
  {
    return postalCode;
  }

  public String getCity()
  {
    return city;
  }

  public String getCountry()
  {
    return country;
  }
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
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
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    //Must provide customer to shippingAddress
    if (aCustomer == null)
    {
      return wasSet;
    }

    if (customer != null && customer.numberOfShippingAddresses() <= Customer.minimumNumberOfShippingAddresses())
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      boolean didRemove = existingCustomer.removeShippingAddress(this);
      if (!didRemove)
      {
        customer = existingCustomer;
        return wasSet;
      }
    }
    customer.addShippingAddress(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(int aOrderNumber, int aShippingDelay, Customer aCustomer, Manager aManager, Employee aItemGatherer, Cart aPaidCart)
  {
    return new Order(aOrderNumber, aShippingDelay, aCustomer, aManager, aItemGatherer, aPaidCart, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Address existingDeliveryAddress = aOrder.getDeliveryAddress();
    boolean isNewDeliveryAddress = existingDeliveryAddress != null && !this.equals(existingDeliveryAddress);
    if (isNewDeliveryAddress)
    {
      aOrder.setDeliveryAddress(this);
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
    //Unable to remove aOrder, as it must always have a deliveryAddress
    if (!this.equals(aOrder.getDeliveryAddress()))
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
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removeShippingAddress(this);
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "addressLineOne" + ":" + getAddressLineOne()+ "," +
            "postalCode" + ":" + getPostalCode()+ "," +
            "city" + ":" + getCity()+ "," +
            "country" + ":" + getCountry()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}