/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.8072.d3fbfafbc modeling language!*/


import java.util.*;

// line 73 "model.ump"
// line 187 "model.ump"
public class Order
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<Integer, Order> ordersByOrderNumber = new HashMap<Integer, Order>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int orderNumber;
  private int shippingDelay;

  //Order Associations
  private Customer customer;
  private Manager manager;
  private Employee itemGatherer;
  private Cart paidCart;
  private Address deliveryAddress;
  private FashionStoreManagementApp system;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(int aOrderNumber, int aShippingDelay, Customer aCustomer, Manager aManager, Employee aItemGatherer, Cart aPaidCart, Address aDeliveryAddress, FashionStoreManagementApp aSystem)
  {
    shippingDelay = aShippingDelay;
    if (!setOrderNumber(aOrderNumber))
    {
      throw new RuntimeException("Cannot create due to duplicate orderNumber. See https://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create paidOrder due to customer. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddManager = setManager(aManager);
    if (!didAddManager)
    {
      throw new RuntimeException("Unable to create ordersToAssign due to manager. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddItemGatherer = setItemGatherer(aItemGatherer);
    if (!didAddItemGatherer)
    {
      throw new RuntimeException("Unable to create ordersToAssemble due to itemGatherer. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPaidCart = setPaidCart(aPaidCart);
    if (!didAddPaidCart)
    {
      throw new RuntimeException("Unable to create placedOrder due to paidCart. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddDeliveryAddress = setDeliveryAddress(aDeliveryAddress);
    if (!didAddDeliveryAddress)
    {
      throw new RuntimeException("Unable to create order due to deliveryAddress. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddSystem = setSystem(aSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create loggedOrder due to system. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aShippingDelay<0||aShippingDelay>3)
    {
      throw new RuntimeException("Please provide a valid shippingDelay [shippingDelay>=0&&shippingDelay<=3]");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrderNumber(int aOrderNumber)
  {
    boolean wasSet = false;
    Integer anOldOrderNumber = getOrderNumber();
    if (anOldOrderNumber != null && anOldOrderNumber.equals(aOrderNumber)) {
      return true;
    }
    if (hasWithOrderNumber(aOrderNumber)) {
      return wasSet;
    }
    orderNumber = aOrderNumber;
    wasSet = true;
    if (anOldOrderNumber != null) {
      ordersByOrderNumber.remove(anOldOrderNumber);
    }
    ordersByOrderNumber.put(aOrderNumber, this);
    return wasSet;
  }

  public boolean setShippingDelay(int aShippingDelay)
  {
    boolean wasSet = false;
    if (aShippingDelay>=0&&aShippingDelay<=3)
    {
    shippingDelay = aShippingDelay;
    wasSet = true;
    }
    return wasSet;
  }

  public int getOrderNumber()
  {
    return orderNumber;
  }
  /* Code from template attribute_GetUnique */
  public static Order getWithOrderNumber(int aOrderNumber)
  {
    return ordersByOrderNumber.get(aOrderNumber);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithOrderNumber(int aOrderNumber)
  {
    return getWithOrderNumber(aOrderNumber) != null;
  }

  public int getShippingDelay()
  {
    return shippingDelay;
  }
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
  }
  /* Code from template association_GetOne */
  public Manager getManager()
  {
    return manager;
  }
  /* Code from template association_GetOne */
  public Employee getItemGatherer()
  {
    return itemGatherer;
  }
  /* Code from template association_GetOne */
  public Cart getPaidCart()
  {
    return paidCart;
  }
  /* Code from template association_GetOne */
  public Address getDeliveryAddress()
  {
    return deliveryAddress;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getSystem()
  {
    return system;
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
      existingCustomer.removePaidOrder(this);
    }
    customer.addPaidOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setManager(Manager aManager)
  {
    boolean wasSet = false;
    if (aManager == null)
    {
      return wasSet;
    }

    Manager existingManager = manager;
    manager = aManager;
    if (existingManager != null && !existingManager.equals(aManager))
    {
      existingManager.removeOrdersToAssign(this);
    }
    manager.addOrdersToAssign(this);
    wasSet = true;
    return wasSet;
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
      existingItemGatherer.removeOrdersToAssemble(this);
    }
    itemGatherer.addOrdersToAssemble(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setPaidCart(Cart aNewPaidCart)
  {
    boolean wasSet = false;
    if (aNewPaidCart == null)
    {
      //Unable to setPaidCart to null, as placedOrder must always be associated to a paidCart
      return wasSet;
    }
    
    Order existingPlacedOrder = aNewPaidCart.getPlacedOrder();
    if (existingPlacedOrder != null && !equals(existingPlacedOrder))
    {
      //Unable to setPaidCart, the current paidCart already has a placedOrder, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    Cart anOldPaidCart = paidCart;
    paidCart = aNewPaidCart;
    paidCart.setPlacedOrder(this);

    if (anOldPaidCart != null)
    {
      anOldPaidCart.setPlacedOrder(null);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDeliveryAddress(Address aDeliveryAddress)
  {
    boolean wasSet = false;
    if (aDeliveryAddress == null)
    {
      return wasSet;
    }

    Address existingDeliveryAddress = deliveryAddress;
    deliveryAddress = aDeliveryAddress;
    if (existingDeliveryAddress != null && !existingDeliveryAddress.equals(aDeliveryAddress))
    {
      existingDeliveryAddress.removeOrder(this);
    }
    deliveryAddress.addOrder(this);
    wasSet = true;
    return wasSet;
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
      existingSystem.removeLoggedOrder(this);
    }
    system.addLoggedOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ordersByOrderNumber.remove(getOrderNumber());
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removePaidOrder(this);
    }
    Manager placeholderManager = manager;
    this.manager = null;
    if(placeholderManager != null)
    {
      placeholderManager.removeOrdersToAssign(this);
    }
    Employee placeholderItemGatherer = itemGatherer;
    this.itemGatherer = null;
    if(placeholderItemGatherer != null)
    {
      placeholderItemGatherer.removeOrdersToAssemble(this);
    }
    Cart existingPaidCart = paidCart;
    paidCart = null;
    if (existingPaidCart != null)
    {
      existingPaidCart.setPlacedOrder(null);
    }
    Address placeholderDeliveryAddress = deliveryAddress;
    this.deliveryAddress = null;
    if(placeholderDeliveryAddress != null)
    {
      placeholderDeliveryAddress.removeOrder(this);
    }
    FashionStoreManagementApp placeholderSystem = system;
    this.system = null;
    if(placeholderSystem != null)
    {
      placeholderSystem.removeLoggedOrder(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderNumber" + ":" + getOrderNumber()+ "," +
            "shippingDelay" + ":" + getShippingDelay()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "itemGatherer = "+(getItemGatherer()!=null?Integer.toHexString(System.identityHashCode(getItemGatherer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "paidCart = "+(getPaidCart()!=null?Integer.toHexString(System.identityHashCode(getPaidCart())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "deliveryAddress = "+(getDeliveryAddress()!=null?Integer.toHexString(System.identityHashCode(getDeliveryAddress())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "system = "+(getSystem()!=null?Integer.toHexString(System.identityHashCode(getSystem())):"null");
  }
}