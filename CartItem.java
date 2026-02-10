/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



/**
 * class Inventory {}
 */
// line 60 "FashionProjectManagementApp.ump"
public class CartItem
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CartItem Attributes
  private int quantity;
  private Size size;

  //CartItem Associations
  private Cart cart;
  private ClothingItem clothingItem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CartItem(int aQuantity, Size aSize, Cart aCart, ClothingItem aClothingItem)
  {
    quantity = aQuantity;
    size = aSize;
    boolean didAddCart = setCart(aCart);
    if (!didAddCart)
    {
      throw new RuntimeException("Unable to create cartItem due to cart. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddClothingItem = setClothingItem(aClothingItem);
    if (!didAddClothingItem)
    {
      throw new RuntimeException("Unable to create cartItem due to clothingItem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public boolean setSize(Size aSize)
  {
    boolean wasSet = false;
    size = aSize;
    wasSet = true;
    return wasSet;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public Size getSize()
  {
    return size;
  }
  /* Code from template association_GetOne */
  public Cart getCart()
  {
    return cart;
  }
  /* Code from template association_GetOne */
  public ClothingItem getClothingItem()
  {
    return clothingItem;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCart(Cart aCart)
  {
    boolean wasSet = false;
    if (aCart == null)
    {
      return wasSet;
    }

    Cart existingCart = cart;
    cart = aCart;
    if (existingCart != null && !existingCart.equals(aCart))
    {
      existingCart.removeCartItem(this);
    }
    cart.addCartItem(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setClothingItem(ClothingItem aClothingItem)
  {
    boolean wasSet = false;
    //Must provide clothingItem to cartItem
    if (aClothingItem == null)
    {
      return wasSet;
    }

    //clothingItem already at maximum (4)
    if (aClothingItem.numberOfCartItems() >= ClothingItem.maximumNumberOfCartItems())
    {
      return wasSet;
    }
    
    ClothingItem existingClothingItem = clothingItem;
    clothingItem = aClothingItem;
    if (existingClothingItem != null && !existingClothingItem.equals(aClothingItem))
    {
      boolean didRemove = existingClothingItem.removeCartItem(this);
      if (!didRemove)
      {
        clothingItem = existingClothingItem;
        return wasSet;
      }
    }
    clothingItem.addCartItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Cart placeholderCart = cart;
    this.cart = null;
    if(placeholderCart != null)
    {
      placeholderCart.removeCartItem(this);
    }
    ClothingItem placeholderClothingItem = clothingItem;
    this.clothingItem = null;
    if(placeholderClothingItem != null)
    {
      placeholderClothingItem.removeCartItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "size" + "=" + (getSize() != null ? !getSize().equals(this)  ? getSize().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "cart = "+(getCart()!=null?Integer.toHexString(System.identityHashCode(getCart())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "clothingItem = "+(getClothingItem()!=null?Integer.toHexString(System.identityHashCode(getClothingItem())):"null");
  }
}