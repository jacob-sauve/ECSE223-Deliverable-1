/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 38 "FashionProjectManagementApp.ump"
public class ClothingItem
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, ClothingItem> clothingitemsByName = new HashMap<String, ClothingItem>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClothingItem Attributes
  private String name;
  private double price;
  private int loyaltyPoints;

  //ClothingItem Associations
  private List<InventoryItem> stockedSizes;
  private List<CartItem> cartItems;
  private FashionStoreManagementApp catalog;
  private List<ShipmentItem> specificReceivedItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClothingItem(String aName, double aPrice, int aLoyaltyPoints, FashionStoreManagementApp aCatalog)
  {
    price = aPrice;
    loyaltyPoints = aLoyaltyPoints;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    stockedSizes = new ArrayList<InventoryItem>();
    cartItems = new ArrayList<CartItem>();
    boolean didAddCatalog = setCatalog(aCatalog);
    if (!didAddCatalog)
    {
      throw new RuntimeException("Unable to create catalogItem due to catalog. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    specificReceivedItems = new ArrayList<ShipmentItem>();
    if (aLoyaltyPoints<1||aLoyaltyPoints>5)
    {
      throw new RuntimeException("Please provide a valid loyaltyPoints [loyaltyPoints>=1&&loyaltyPoints<=5]");
    }
    if (aLoyaltyPoints<1||aLoyaltyPoints>5)
    {
      throw new RuntimeException("Please provide a valid loyaltyPoints [loyaltyPoints>=1&&loyaltyPoints<=5]");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    String anOldName = getName();
    if (anOldName != null && anOldName.equals(aName)) {
      return true;
    }
    if (hasWithName(aName)) {
      return wasSet;
    }
    name = aName;
    wasSet = true;
    if (anOldName != null) {
      clothingitemsByName.remove(anOldName);
    }
    clothingitemsByName.put(aName, this);
    return wasSet;
  }

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setLoyaltyPoints(int aLoyaltyPoints)
  {
    boolean wasSet = false;
    if (aLoyaltyPoints>=1&&aLoyaltyPoints<=5)
    {
    if (aLoyaltyPoints>=1&&aLoyaltyPoints<=5)
    {
    loyaltyPoints = aLoyaltyPoints;
    wasSet = true;
    }
    }
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  public static ClothingItem getWithName(String aName)
  {
    return clothingitemsByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
  }

  public double getPrice()
  {
    return price;
  }

  public int getLoyaltyPoints()
  {
    return loyaltyPoints;
  }
  /* Code from template association_GetMany */
  public InventoryItem getStockedSize(int index)
  {
    InventoryItem aStockedSize = stockedSizes.get(index);
    return aStockedSize;
  }

  public List<InventoryItem> getStockedSizes()
  {
    List<InventoryItem> newStockedSizes = Collections.unmodifiableList(stockedSizes);
    return newStockedSizes;
  }

  public int numberOfStockedSizes()
  {
    int number = stockedSizes.size();
    return number;
  }

  public boolean hasStockedSizes()
  {
    boolean has = stockedSizes.size() > 0;
    return has;
  }

  public int indexOfStockedSize(InventoryItem aStockedSize)
  {
    int index = stockedSizes.indexOf(aStockedSize);
    return index;
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
  public FashionStoreManagementApp getCatalog()
  {
    return catalog;
  }
  /* Code from template association_GetMany */
  public ShipmentItem getSpecificReceivedItem(int index)
  {
    ShipmentItem aSpecificReceivedItem = specificReceivedItems.get(index);
    return aSpecificReceivedItem;
  }

  public List<ShipmentItem> getSpecificReceivedItems()
  {
    List<ShipmentItem> newSpecificReceivedItems = Collections.unmodifiableList(specificReceivedItems);
    return newSpecificReceivedItems;
  }

  public int numberOfSpecificReceivedItems()
  {
    int number = specificReceivedItems.size();
    return number;
  }

  public boolean hasSpecificReceivedItems()
  {
    boolean has = specificReceivedItems.size() > 0;
    return has;
  }

  public int indexOfSpecificReceivedItem(ShipmentItem aSpecificReceivedItem)
  {
    int index = specificReceivedItems.indexOf(aSpecificReceivedItem);
    return index;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfStockedSizesValid()
  {
    boolean isValid = numberOfStockedSizes() >= minimumNumberOfStockedSizes() && numberOfStockedSizes() <= maximumNumberOfStockedSizes();
    return isValid;
  }
  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfStockedSizes()
  {
    return 4;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStockedSizes()
  {
    return 4;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfStockedSizes()
  {
    return 4;
  }
  /* Code from template association_AddMNToOnlyOne */
  public InventoryItem addStockedSize(int aQuantity, Size aSize)
  {
    if (numberOfStockedSizes() >= maximumNumberOfStockedSizes())
    {
      return null;
    }
    else
    {
      return new InventoryItem(aQuantity, aSize, this);
    }
  }

  public boolean addStockedSize(InventoryItem aStockedSize)
  {
    boolean wasAdded = false;
    if (stockedSizes.contains(aStockedSize)) { return false; }
    if (numberOfStockedSizes() >= maximumNumberOfStockedSizes())
    {
      return wasAdded;
    }

    ClothingItem existingCatalogItem = aStockedSize.getCatalogItem();
    boolean isNewCatalogItem = existingCatalogItem != null && !this.equals(existingCatalogItem);

    if (isNewCatalogItem && existingCatalogItem.numberOfStockedSizes() <= minimumNumberOfStockedSizes())
    {
      return wasAdded;
    }

    if (isNewCatalogItem)
    {
      aStockedSize.setCatalogItem(this);
    }
    else
    {
      stockedSizes.add(aStockedSize);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStockedSize(InventoryItem aStockedSize)
  {
    boolean wasRemoved = false;
    //Unable to remove aStockedSize, as it must always have a catalogItem
    if (this.equals(aStockedSize.getCatalogItem()))
    {
      return wasRemoved;
    }

    //catalogItem already at minimum (4)
    if (numberOfStockedSizes() <= minimumNumberOfStockedSizes())
    {
      return wasRemoved;
    }
    stockedSizes.remove(aStockedSize);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCartItems()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCartItems()
  {
    return 4;
  }
  /* Code from template association_AddOptionalNToOne */
  public CartItem addCartItem(int aQuantity, Size aSize, Cart aCart)
  {
    if (numberOfCartItems() >= maximumNumberOfCartItems())
    {
      return null;
    }
    else
    {
      return new CartItem(aQuantity, aSize, aCart, this);
    }
  }

  public boolean addCartItem(CartItem aCartItem)
  {
    boolean wasAdded = false;
    if (cartItems.contains(aCartItem)) { return false; }
    if (numberOfCartItems() >= maximumNumberOfCartItems())
    {
      return wasAdded;
    }

    ClothingItem existingClothingItem = aCartItem.getClothingItem();
    boolean isNewClothingItem = existingClothingItem != null && !this.equals(existingClothingItem);
    if (isNewClothingItem)
    {
      aCartItem.setClothingItem(this);
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
    //Unable to remove aCartItem, as it must always have a clothingItem
    if (!this.equals(aCartItem.getClothingItem()))
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
  public boolean setCatalog(FashionStoreManagementApp aCatalog)
  {
    boolean wasSet = false;
    if (aCatalog == null)
    {
      return wasSet;
    }

    FashionStoreManagementApp existingCatalog = catalog;
    catalog = aCatalog;
    if (existingCatalog != null && !existingCatalog.equals(aCatalog))
    {
      existingCatalog.removeCatalogItem(this);
    }
    catalog.addCatalogItem(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSpecificReceivedItems()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfSpecificReceivedItems()
  {
    return 4;
  }
  /* Code from template association_AddOptionalNToOne */
  public ShipmentItem addSpecificReceivedItem(Size aSize, int aQuantity, Shipment aOrderedShipment)
  {
    if (numberOfSpecificReceivedItems() >= maximumNumberOfSpecificReceivedItems())
    {
      return null;
    }
    else
    {
      return new ShipmentItem(aSize, aQuantity, aOrderedShipment, this);
    }
  }

  public boolean addSpecificReceivedItem(ShipmentItem aSpecificReceivedItem)
  {
    boolean wasAdded = false;
    if (specificReceivedItems.contains(aSpecificReceivedItem)) { return false; }
    if (numberOfSpecificReceivedItems() >= maximumNumberOfSpecificReceivedItems())
    {
      return wasAdded;
    }

    ClothingItem existingItemTypeToShip = aSpecificReceivedItem.getItemTypeToShip();
    boolean isNewItemTypeToShip = existingItemTypeToShip != null && !this.equals(existingItemTypeToShip);
    if (isNewItemTypeToShip)
    {
      aSpecificReceivedItem.setItemTypeToShip(this);
    }
    else
    {
      specificReceivedItems.add(aSpecificReceivedItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSpecificReceivedItem(ShipmentItem aSpecificReceivedItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aSpecificReceivedItem, as it must always have a itemTypeToShip
    if (!this.equals(aSpecificReceivedItem.getItemTypeToShip()))
    {
      specificReceivedItems.remove(aSpecificReceivedItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSpecificReceivedItemAt(ShipmentItem aSpecificReceivedItem, int index)
  {  
    boolean wasAdded = false;
    if(addSpecificReceivedItem(aSpecificReceivedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificReceivedItems()) { index = numberOfSpecificReceivedItems() - 1; }
      specificReceivedItems.remove(aSpecificReceivedItem);
      specificReceivedItems.add(index, aSpecificReceivedItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSpecificReceivedItemAt(ShipmentItem aSpecificReceivedItem, int index)
  {
    boolean wasAdded = false;
    if(specificReceivedItems.contains(aSpecificReceivedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSpecificReceivedItems()) { index = numberOfSpecificReceivedItems() - 1; }
      specificReceivedItems.remove(aSpecificReceivedItem);
      specificReceivedItems.add(index, aSpecificReceivedItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSpecificReceivedItemAt(aSpecificReceivedItem, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    clothingitemsByName.remove(getName());
    for(int i=stockedSizes.size(); i > 0; i--)
    {
      InventoryItem aStockedSize = stockedSizes.get(i - 1);
      aStockedSize.delete();
    }
    for(int i=cartItems.size(); i > 0; i--)
    {
      CartItem aCartItem = cartItems.get(i - 1);
      aCartItem.delete();
    }
    FashionStoreManagementApp placeholderCatalog = catalog;
    this.catalog = null;
    if(placeholderCatalog != null)
    {
      placeholderCatalog.removeCatalogItem(this);
    }
    for(int i=specificReceivedItems.size(); i > 0; i--)
    {
      ShipmentItem aSpecificReceivedItem = specificReceivedItems.get(i - 1);
      aSpecificReceivedItem.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "," +
            "loyaltyPoints" + ":" + getLoyaltyPoints()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "catalog = "+(getCatalog()!=null?Integer.toHexString(System.identityHashCode(getCatalog())):"null");
  }
}