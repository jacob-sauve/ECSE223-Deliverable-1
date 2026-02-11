/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 73 "FashionProjectManagementApp.ump"
public class Shipment
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shipment Attributes
  private boolean shipped;

  //Shipment Associations
  private List<ShipmentItem> shippedItems;
  private Manager shipmentManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shipment(boolean aShipped, Manager aShipmentManager)
  {
    shipped = aShipped;
    shippedItems = new ArrayList<ShipmentItem>();
    boolean didAddShipmentManager = setShipmentManager(aShipmentManager);
    if (!didAddShipmentManager)
    {
      throw new RuntimeException("Unable to create shipment due to shipmentManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setShipped(boolean aShipped)
  {
    boolean wasSet = false;
    shipped = aShipped;
    wasSet = true;
    return wasSet;
  }

  public boolean getShipped()
  {
    return shipped;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isShipped()
  {
    return shipped;
  }
  /* Code from template association_GetMany */
  public ShipmentItem getShippedItem(int index)
  {
    ShipmentItem aShippedItem = shippedItems.get(index);
    return aShippedItem;
  }

  public List<ShipmentItem> getShippedItems()
  {
    List<ShipmentItem> newShippedItems = Collections.unmodifiableList(shippedItems);
    return newShippedItems;
  }

  public int numberOfShippedItems()
  {
    int number = shippedItems.size();
    return number;
  }

  public boolean hasShippedItems()
  {
    boolean has = shippedItems.size() > 0;
    return has;
  }

  public int indexOfShippedItem(ShipmentItem aShippedItem)
  {
    int index = shippedItems.indexOf(aShippedItem);
    return index;
  }
  /* Code from template association_GetOne */
  public Manager getShipmentManager()
  {
    return shipmentManager;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfShippedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ShipmentItem addShippedItem(Size aSize, int aQuantity, ClothingItem aItemTypeToShip)
  {
    return new ShipmentItem(aSize, aQuantity, this, aItemTypeToShip);
  }

  public boolean addShippedItem(ShipmentItem aShippedItem)
  {
    boolean wasAdded = false;
    if (shippedItems.contains(aShippedItem)) { return false; }
    Shipment existingOrderedShipment = aShippedItem.getOrderedShipment();
    boolean isNewOrderedShipment = existingOrderedShipment != null && !this.equals(existingOrderedShipment);
    if (isNewOrderedShipment)
    {
      aShippedItem.setOrderedShipment(this);
    }
    else
    {
      shippedItems.add(aShippedItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShippedItem(ShipmentItem aShippedItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aShippedItem, as it must always have a orderedShipment
    if (!this.equals(aShippedItem.getOrderedShipment()))
    {
      shippedItems.remove(aShippedItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addShippedItemAt(ShipmentItem aShippedItem, int index)
  {  
    boolean wasAdded = false;
    if(addShippedItem(aShippedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShippedItems()) { index = numberOfShippedItems() - 1; }
      shippedItems.remove(aShippedItem);
      shippedItems.add(index, aShippedItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShippedItemAt(ShipmentItem aShippedItem, int index)
  {
    boolean wasAdded = false;
    if(shippedItems.contains(aShippedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShippedItems()) { index = numberOfShippedItems() - 1; }
      shippedItems.remove(aShippedItem);
      shippedItems.add(index, aShippedItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShippedItemAt(aShippedItem, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setShipmentManager(Manager aShipmentManager)
  {
    boolean wasSet = false;
    if (aShipmentManager == null)
    {
      return wasSet;
    }

    Manager existingShipmentManager = shipmentManager;
    shipmentManager = aShipmentManager;
    if (existingShipmentManager != null && !existingShipmentManager.equals(aShipmentManager))
    {
      existingShipmentManager.removeShipment(this);
    }
    shipmentManager.addShipment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while (shippedItems.size() > 0)
    {
      ShipmentItem aShippedItem = shippedItems.get(shippedItems.size() - 1);
      aShippedItem.delete();
      shippedItems.remove(aShippedItem);
    }
    
    Manager placeholderShipmentManager = shipmentManager;
    this.shipmentManager = null;
    if(placeholderShipmentManager != null)
    {
      placeholderShipmentManager.removeShipment(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "shipped" + ":" + getShipped()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "shipmentManager = "+(getShipmentManager()!=null?Integer.toHexString(System.identityHashCode(getShipmentManager())):"null");
  }
}