/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 77 "FashionProjectManagementApp.ump"
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
  private List<ShipmentItem> itemsInShipment;
  private Manager shipmentManager;
  private List<InventoryItem> updatedInventoryItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shipment(boolean aShipped, Manager aShipmentManager)
  {
    shipped = aShipped;
    itemsInShipment = new ArrayList<ShipmentItem>();
    boolean didAddShipmentManager = setShipmentManager(aShipmentManager);
    if (!didAddShipmentManager)
    {
      throw new RuntimeException("Unable to create shipment due to shipmentManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    updatedInventoryItems = new ArrayList<InventoryItem>();
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
  public ShipmentItem getItemsInShipment(int index)
  {
    ShipmentItem aItemsInShipment = itemsInShipment.get(index);
    return aItemsInShipment;
  }

  public List<ShipmentItem> getItemsInShipment()
  {
    List<ShipmentItem> newItemsInShipment = Collections.unmodifiableList(itemsInShipment);
    return newItemsInShipment;
  }

  public int numberOfItemsInShipment()
  {
    int number = itemsInShipment.size();
    return number;
  }

  public boolean hasItemsInShipment()
  {
    boolean has = itemsInShipment.size() > 0;
    return has;
  }

  public int indexOfItemsInShipment(ShipmentItem aItemsInShipment)
  {
    int index = itemsInShipment.indexOf(aItemsInShipment);
    return index;
  }
  /* Code from template association_GetOne */
  public Manager getShipmentManager()
  {
    return shipmentManager;
  }
  /* Code from template association_GetMany */
  public InventoryItem getUpdatedInventoryItem(int index)
  {
    InventoryItem aUpdatedInventoryItem = updatedInventoryItems.get(index);
    return aUpdatedInventoryItem;
  }

  public List<InventoryItem> getUpdatedInventoryItems()
  {
    List<InventoryItem> newUpdatedInventoryItems = Collections.unmodifiableList(updatedInventoryItems);
    return newUpdatedInventoryItems;
  }

  public int numberOfUpdatedInventoryItems()
  {
    int number = updatedInventoryItems.size();
    return number;
  }

  public boolean hasUpdatedInventoryItems()
  {
    boolean has = updatedInventoryItems.size() > 0;
    return has;
  }

  public int indexOfUpdatedInventoryItem(InventoryItem aUpdatedInventoryItem)
  {
    int index = updatedInventoryItems.indexOf(aUpdatedInventoryItem);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItemsInShipment()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ShipmentItem addItemsInShipment(Size aSize, int aQuantity, ClothingItem aItemToShip)
  {
    return new ShipmentItem(aSize, aQuantity, this, aItemToShip);
  }

  public boolean addItemsInShipment(ShipmentItem aItemsInShipment)
  {
    boolean wasAdded = false;
    if (itemsInShipment.contains(aItemsInShipment)) { return false; }
    Shipment existingOrderedShipment = aItemsInShipment.getOrderedShipment();
    boolean isNewOrderedShipment = existingOrderedShipment != null && !this.equals(existingOrderedShipment);
    if (isNewOrderedShipment)
    {
      aItemsInShipment.setOrderedShipment(this);
    }
    else
    {
      itemsInShipment.add(aItemsInShipment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItemsInShipment(ShipmentItem aItemsInShipment)
  {
    boolean wasRemoved = false;
    //Unable to remove aItemsInShipment, as it must always have a orderedShipment
    if (!this.equals(aItemsInShipment.getOrderedShipment()))
    {
      itemsInShipment.remove(aItemsInShipment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemsInShipmentAt(ShipmentItem aItemsInShipment, int index)
  {  
    boolean wasAdded = false;
    if(addItemsInShipment(aItemsInShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemsInShipment()) { index = numberOfItemsInShipment() - 1; }
      itemsInShipment.remove(aItemsInShipment);
      itemsInShipment.add(index, aItemsInShipment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemsInShipmentAt(ShipmentItem aItemsInShipment, int index)
  {
    boolean wasAdded = false;
    if(itemsInShipment.contains(aItemsInShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItemsInShipment()) { index = numberOfItemsInShipment() - 1; }
      itemsInShipment.remove(aItemsInShipment);
      itemsInShipment.add(index, aItemsInShipment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemsInShipmentAt(aItemsInShipment, index);
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUpdatedInventoryItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addUpdatedInventoryItem(InventoryItem aUpdatedInventoryItem)
  {
    boolean wasAdded = false;
    if (updatedInventoryItems.contains(aUpdatedInventoryItem)) { return false; }
    updatedInventoryItems.add(aUpdatedInventoryItem);
    if (aUpdatedInventoryItem.indexOfShipment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUpdatedInventoryItem.addShipment(this);
      if (!wasAdded)
      {
        updatedInventoryItems.remove(aUpdatedInventoryItem);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeUpdatedInventoryItem(InventoryItem aUpdatedInventoryItem)
  {
    boolean wasRemoved = false;
    if (!updatedInventoryItems.contains(aUpdatedInventoryItem))
    {
      return wasRemoved;
    }

    int oldIndex = updatedInventoryItems.indexOf(aUpdatedInventoryItem);
    updatedInventoryItems.remove(oldIndex);
    if (aUpdatedInventoryItem.indexOfShipment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUpdatedInventoryItem.removeShipment(this);
      if (!wasRemoved)
      {
        updatedInventoryItems.add(oldIndex,aUpdatedInventoryItem);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUpdatedInventoryItemAt(InventoryItem aUpdatedInventoryItem, int index)
  {  
    boolean wasAdded = false;
    if(addUpdatedInventoryItem(aUpdatedInventoryItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpdatedInventoryItems()) { index = numberOfUpdatedInventoryItems() - 1; }
      updatedInventoryItems.remove(aUpdatedInventoryItem);
      updatedInventoryItems.add(index, aUpdatedInventoryItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUpdatedInventoryItemAt(InventoryItem aUpdatedInventoryItem, int index)
  {
    boolean wasAdded = false;
    if(updatedInventoryItems.contains(aUpdatedInventoryItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUpdatedInventoryItems()) { index = numberOfUpdatedInventoryItems() - 1; }
      updatedInventoryItems.remove(aUpdatedInventoryItem);
      updatedInventoryItems.add(index, aUpdatedInventoryItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUpdatedInventoryItemAt(aUpdatedInventoryItem, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (itemsInShipment.size() > 0)
    {
      ShipmentItem aItemsInShipment = itemsInShipment.get(itemsInShipment.size() - 1);
      aItemsInShipment.delete();
      itemsInShipment.remove(aItemsInShipment);
    }
    
    Manager placeholderShipmentManager = shipmentManager;
    this.shipmentManager = null;
    if(placeholderShipmentManager != null)
    {
      placeholderShipmentManager.removeShipment(this);
    }
    ArrayList<InventoryItem> copyOfUpdatedInventoryItems = new ArrayList<InventoryItem>(updatedInventoryItems);
    updatedInventoryItems.clear();
    for(InventoryItem aUpdatedInventoryItem : copyOfUpdatedInventoryItems)
    {
      aUpdatedInventoryItem.removeShipment(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "shipped" + ":" + getShipped()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "shipmentManager = "+(getShipmentManager()!=null?Integer.toHexString(System.identityHashCode(getShipmentManager())):"null");
  }
}