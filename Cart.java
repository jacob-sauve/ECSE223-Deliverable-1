/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.8072.d3fbfafbc modeling language!*/


import java.util.*;

// line 69 "model.ump"
// line 182 "model.ump"
public class Cart
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Cart Associations
  private Customer customer;
  private Order placedOrder;
  private List<CartItem> cartItems;
  private FashionStoreManagementApp system;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cart(Customer aCustomer, FashionStoreManagementApp aSystem)
  {
    if (aCustomer == null || aCustomer.getCart() != null)
    {
      throw new RuntimeException("Unable to create Cart due to aCustomer. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    customer = aCustomer;
    cartItems = new ArrayList<CartItem>();
    boolean didAddSystem = setSystem(aSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create cart due to system. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Cart(String aUsernameForCustomer, String aPasswordForCustomer, User aPersonForCustomer, FashionStoreManagementApp aSystemForCustomer, int aLoyaltyPointsForCustomer, FashionStoreManagementApp aSystem)
  {
    customer = new Customer(aUsernameForCustomer, aPasswordForCustomer, aPersonForCustomer, aSystemForCustomer, aLoyaltyPointsForCustomer, this);
    cartItems = new ArrayList<CartItem>();
    boolean didAddSystem = setSystem(aSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create cart due to system. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
  }
  /* Code from template association_GetOne */
  public Order getPlacedOrder()
  {
    return placedOrder;
  }

  public boolean hasPlacedOrder()
  {
    boolean has = placedOrder != null;
    return has;
  }
  /* Code from template association_GetMany */
  public CartItem getCartItem(int index)
  {
    CartItem aCartItem = cartItems.get(index);
    return aCartItem;
  }

  public List<CartItem> getCartItems()
  {
    List<CartItem> newCartItems = Collections.unmodifiableList(cartItems);
    return newCartItems;
  }

  public int numberOfCartItems()
  {
    int number = cartItems.size();
    return number;
  }

  public boolean hasCartItems()
  {
    boolean has = cartItems.size() > 0;
    return has;
  }

  public int indexOfCartItem(CartItem aCartItem)
  {
    int index = cartItems.indexOf(aCartItem);
    return index;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getSystem()
  {
    return system;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setPlacedOrder(Order aNewPlacedOrder)
  {
    boolean wasSet = false;
    if (placedOrder != null && !placedOrder.equals(aNewPlacedOrder) && equals(placedOrder.getPaidCart()))
    {
      //Unable to setPlacedOrder, as existing placedOrder would become an orphan
      return wasSet;
    }

    placedOrder = aNewPlacedOrder;
    Cart anOldPaidCart = aNewPlacedOrder != null ? aNewPlacedOrder.getPaidCart() : null;

    if (!this.equals(anOldPaidCart))
    {
      if (anOldPaidCart != null)
      {
        anOldPaidCart.placedOrder = null;
      }
      if (placedOrder != null)
      {
        placedOrder.setPaidCart(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCartItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public CartItem addCartItem(int aQuantity, Size aSize, ClothingItem aClothingItem)
  {
    return new CartItem(aQuantity, aSize, this, aClothingItem);
  }

  public boolean addCartItem(CartItem aCartItem)
  {
    boolean wasAdded = false;
    if (cartItems.contains(aCartItem)) { return false; }
    Cart existingCart = aCartItem.getCart();
    boolean isNewCart = existingCart != null && !this.equals(existingCart);
    if (isNewCart)
    {
      aCartItem.setCart(this);
    }
    else
    {
      cartItems.add(aCartItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCartItem(CartItem aCartItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aCartItem, as it must always have a cart
    if (!this.equals(aCartItem.getCart()))
    {
      cartItems.remove(aCartItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCartItemAt(CartItem aCartItem, int index)
  {  
    boolean wasAdded = false;
    if(addCartItem(aCartItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCartItems()) { index = numberOfCartItems() - 1; }
      cartItems.remove(aCartItem);
      cartItems.add(index, aCartItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCartItemAt(CartItem aCartItem, int index)
  {
    boolean wasAdded = false;
    if(cartItems.contains(aCartItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCartItems()) { index = numberOfCartItems() - 1; }
      cartItems.remove(aCartItem);
      cartItems.add(index, aCartItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCartItemAt(aCartItem, index);
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
      existingSystem.removeCart(this);
    }
    system.addCart(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer existingCustomer = customer;
    customer = null;
    if (existingCustomer != null)
    {
      existingCustomer.delete();
    }
    Order existingPlacedOrder = placedOrder;
    placedOrder = null;
    if (existingPlacedOrder != null)
    {
      existingPlacedOrder.delete();
    }
    while (cartItems.size() > 0)
    {
      CartItem aCartItem = cartItems.get(cartItems.size() - 1);
      aCartItem.delete();
      cartItems.remove(aCartItem);
    }
    
    FashionStoreManagementApp placeholderSystem = system;
    this.system = null;
    if(placeholderSystem != null)
    {
      placeholderSystem.removeCart(this);
    }
  }

}