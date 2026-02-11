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
  private List<Customer> customers;
  private List<Order> orders;
  private FashionStoreManagementApp system;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Address(String aAddressLineOne, String aPostalCode, String aCity, String aCountry, FashionStoreManagementApp aSystem)
  {
    addressLineOne = aAddressLineOne;
    postalCode = aPostalCode;
    city = aCity;
    country = aCountry;
    customers = new ArrayList<Customer>();
    orders = new ArrayList<Order>();
    boolean didAddSystem = setSystem(aSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create savedAddress due to system. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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
  /* Code from template association_GetMany */
  public Customer getCustomer(int index)
  {
    Customer aCustomer = customers.get(index);
    return aCustomer;
  }

  public List<Customer> getCustomers()
  {
    List<Customer> newCustomers = Collections.unmodifiableList(customers);
    return newCustomers;
  }

  public int numberOfCustomers()
  {
    int number = customers.size();
    return number;
  }

  public boolean hasCustomers()
  {
    boolean has = customers.size() > 0;
    return has;
  }

  public int indexOfCustomer(Customer aCustomer)
  {
    int index = customers.indexOf(aCustomer);
    return index;
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
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getSystem()
  {
    return system;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfCustomersValid()
  {
    boolean isValid = numberOfCustomers() >= minimumNumberOfCustomers();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomers()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addCustomer(Customer aCustomer)
  {
    boolean wasAdded = false;
    if (customers.contains(aCustomer)) { return false; }
    customers.add(aCustomer);
    if (aCustomer.indexOfShippingAddress(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aCustomer.addShippingAddress(this);
      if (!wasAdded)
      {
        customers.remove(aCustomer);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeCustomer(Customer aCustomer)
  {
    boolean wasRemoved = false;
    if (!customers.contains(aCustomer))
    {
      return wasRemoved;
    }

    if (numberOfCustomers() <= minimumNumberOfCustomers())
    {
      return wasRemoved;
    }

    int oldIndex = customers.indexOf(aCustomer);
    customers.remove(oldIndex);
    if (aCustomer.indexOfShippingAddress(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aCustomer.removeShippingAddress(this);
      if (!wasRemoved)
      {
        customers.add(oldIndex,aCustomer);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setCustomers(Customer... newCustomers)
  {
    boolean wasSet = false;
    ArrayList<Customer> verifiedCustomers = new ArrayList<Customer>();
    for (Customer aCustomer : newCustomers)
    {
      if (verifiedCustomers.contains(aCustomer))
      {
        continue;
      }
      verifiedCustomers.add(aCustomer);
    }

    if (verifiedCustomers.size() != newCustomers.length || verifiedCustomers.size() < minimumNumberOfCustomers())
    {
      return wasSet;
    }

    ArrayList<Customer> oldCustomers = new ArrayList<Customer>(customers);
    customers.clear();
    for (Customer aNewCustomer : verifiedCustomers)
    {
      customers.add(aNewCustomer);
      if (oldCustomers.contains(aNewCustomer))
      {
        oldCustomers.remove(aNewCustomer);
      }
      else
      {
        aNewCustomer.addShippingAddress(this);
      }
    }

    for (Customer anOldCustomer : oldCustomers)
    {
      anOldCustomer.removeShippingAddress(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCustomerAt(Customer aCustomer, int index)
  {  
    boolean wasAdded = false;
    if(addCustomer(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCustomerAt(Customer aCustomer, int index)
  {
    boolean wasAdded = false;
    if(customers.contains(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCustomerAt(aCustomer, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(int aOrderNumber, int aShippingDelay, Customer aCustomer, Manager aManager, Employee aItemGatherer, Cart aPaidCart, FashionStoreManagementApp aSystem)
  {
    return new Order(aOrderNumber, aShippingDelay, aCustomer, aManager, aItemGatherer, aPaidCart, this, aSystem);
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
  /* Code from template association_SetOneToMany */
  public boolean setSystem(FashionStoreManagementApp aSystem)
  {
    boolean wasSet = false;
    if (aSystem == null)
    {
      return wasSet;
    }

    FashionStoreManagementApp existingSystem = system;
    system = aSystem;
    if (existingSystem != null && !existingSystem.equals(aSystem))
    {
      existingSystem.removeSavedAddress(this);
    }
    system.addSavedAddress(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Customer> copyOfCustomers = new ArrayList<Customer>(customers);
    customers.clear();
    for(Customer aCustomer : copyOfCustomers)
    {
      if (aCustomer.numberOfShippingAddresses() <= Customer.minimumNumberOfShippingAddresses())
      {
        aCustomer.delete();
      }
      else
      {
        aCustomer.removeShippingAddress(this);
      }
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    FashionStoreManagementApp placeholderSystem = system;
    this.system = null;
    if(placeholderSystem != null)
    {
      placeholderSystem.removeSavedAddress(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "addressLineOne" + ":" + getAddressLineOne()+ "," +
            "postalCode" + ":" + getPostalCode()+ "," +
            "city" + ":" + getCity()+ "," +
            "country" + ":" + getCountry()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "system = "+(getSystem()!=null?Integer.toHexString(System.identityHashCode(getSystem())):"null");
  }
}