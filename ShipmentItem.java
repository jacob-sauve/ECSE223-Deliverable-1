/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 81 "FashionProjectManagementApp.ump"
public class ShipmentItem
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ShipmentItem Attributes
  private Size size;
  private int quantity;

  //ShipmentItem Associations
  private Shipment orderedShipment;
  private ClothingItem itemToShip;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ShipmentItem(Size aSize, int aQuantity, Shipment aOrderedShipment, ClothingItem aItemToShip)
  {
    size = aSize;
    quantity = aQuantity;
    boolean didAddOrderedShipment = setOrderedShipment(aOrderedShipment);
    if (!didAddOrderedShipment)
    {
      throw new RuntimeException("Unable to create itemsInShipment due to orderedShipment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddItemToShip = setItemToShip(aItemToShip);
    if (!didAddItemToShip)
    {
      throw new RuntimeException("Unable to create specificItem due to itemToShip. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSize(Size aSize)
  {
    boolean wasSet = false;
    size = aSize;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public Size getSize()
  {
    return size;
  }

  public int getQuantity()
  {
    return quantity;
  }
  /* Code from template association_GetOne */
  public Shipment getOrderedShipment()
  {
    return orderedShipment;
  }
  /* Code from template association_GetOne */
  public ClothingItem getItemToShip()
  {
    return itemToShip;
  }
  /* Code from template association_SetOneToMany */
  public boolean setOrderedShipment(Shipment aOrderedShipment)
  {
    boolean wasSet = false;
    if (aOrderedShipment == null)
    {
      return wasSet;
    }

    Shipment existingOrderedShipment = orderedShipment;
    orderedShipment = aOrderedShipment;
    if (existingOrderedShipment != null && !existingOrderedShipment.equals(aOrderedShipment))
    {
      existingOrderedShipment.removeItemsInShipment(this);
    }
    orderedShipment.addItemsInShipment(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setItemToShip(ClothingItem aItemToShip)
  {
    boolean wasSet = false;
    //Must provide itemToShip to specificItem
    if (aItemToShip == null)
    {
      return wasSet;
    }

    //itemToShip already at maximum (4)
    if (aItemToShip.numberOfSpecificItem() >= ClothingItem.maximumNumberOfSpecificItem())
    {
      return wasSet;
    }
    
    ClothingItem existingItemToShip = itemToShip;
    itemToShip = aItemToShip;
    if (existingItemToShip != null && !existingItemToShip.equals(aItemToShip))
    {
      boolean didRemove = existingItemToShip.removeSpecificItem(this);
      if (!didRemove)
      {
        itemToShip = existingItemToShip;
        return wasSet;
      }
    }
    itemToShip.addSpecificItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Shipment placeholderOrderedShipment = orderedShipment;
    this.orderedShipment = null;
    if(placeholderOrderedShipment != null)
    {
      placeholderOrderedShipment.removeItemsInShipment(this);
    }
    ClothingItem placeholderItemToShip = itemToShip;
    this.itemToShip = null;
    if(placeholderItemToShip != null)
    {
      placeholderItemToShip.removeSpecificItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "size" + "=" + (getSize() != null ? !getSize().equals(this)  ? getSize().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderedShipment = "+(getOrderedShipment()!=null?Integer.toHexString(System.identityHashCode(getOrderedShipment())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "itemToShip = "+(getItemToShip()!=null?Integer.toHexString(System.identityHashCode(getItemToShip())):"null");
  }
}