/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 65 "FashionProjectManagementApp.ump"
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Cart(Customer aCustomer)
  {
    if (aCustomer == null || aCustomer.getCart() != null)
    {
      throw new RuntimeException("Unable to create Cart due to aCustomer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    customer = aCustomer;
    cartItems = new ArrayList<CartItem>();
  }

  public Cart(String aUsernameForCustomer, String aPasswordForCustomer, User aPersonForCustomer, int aLoyaltyPointsForCustomer)
  {
    customer = new Customer(aUsernameForCustomer, aPasswordForCustomer, aPersonForCustomer, aLoyaltyPointsForCustomer, this);
    cartItems = new ArrayList<CartItem>();
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
    
  }

}