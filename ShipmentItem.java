/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 77 "FashionProjectManagementApp.ump"
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
  private ClothingItem itemTypeToShip;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ShipmentItem(Size aSize, int aQuantity, Shipment aOrderedShipment, ClothingItem aItemTypeToShip)
  {
    size = aSize;
    quantity = aQuantity;
    boolean didAddOrderedShipment = setOrderedShipment(aOrderedShipment);
    if (!didAddOrderedShipment)
    {
      throw new RuntimeException("Unable to create shippedItem due to orderedShipment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddItemTypeToShip = setItemTypeToShip(aItemTypeToShip);
    if (!didAddItemTypeToShip)
    {
      throw new RuntimeException("Unable to create specificReceivedItem due to itemTypeToShip. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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
  public ClothingItem getItemTypeToShip()
  {
    return itemTypeToShip;
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
      existingOrderedShipment.removeShippedItem(this);
    }
    orderedShipment.addShippedItem(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setItemTypeToShip(ClothingItem aItemTypeToShip)
  {
    boolean wasSet = false;
    //Must provide itemTypeToShip to specificReceivedItem
    if (aItemTypeToShip == null)
    {
      return wasSet;
    }

    //itemTypeToShip already at maximum (4)
    if (aItemTypeToShip.numberOfSpecificReceivedItems() >= ClothingItem.maximumNumberOfSpecificReceivedItems())
    {
      return wasSet;
    }
    
    ClothingItem existingItemTypeToShip = itemTypeToShip;
    itemTypeToShip = aItemTypeToShip;
    if (existingItemTypeToShip != null && !existingItemTypeToShip.equals(aItemTypeToShip))
    {
      boolean didRemove = existingItemTypeToShip.removeSpecificReceivedItem(this);
      if (!didRemove)
      {
        itemTypeToShip = existingItemTypeToShip;
        return wasSet;
      }
    }
    itemTypeToShip.addSpecificReceivedItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Shipment placeholderOrderedShipment = orderedShipment;
    this.orderedShipment = null;
    if(placeholderOrderedShipment != null)
    {
      placeholderOrderedShipment.removeShippedItem(this);
    }
    ClothingItem placeholderItemTypeToShip = itemTypeToShip;
    this.itemTypeToShip = null;
    if(placeholderItemTypeToShip != null)
    {
      placeholderItemTypeToShip.removeSpecificReceivedItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "size" + "=" + (getSize() != null ? !getSize().equals(this)  ? getSize().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "orderedShipment = "+(getOrderedShipment()!=null?Integer.toHexString(System.identityHashCode(getOrderedShipment())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "itemTypeToShip = "+(getItemTypeToShip()!=null?Integer.toHexString(System.identityHashCode(getItemTypeToShip())):"null");
  }
}