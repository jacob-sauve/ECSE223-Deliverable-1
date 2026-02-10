/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 53 "FashionProjectManagementApp.ump"
public class InventoryItem
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Size { S, M, L, XL }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InventoryItem Attributes
  private int quantity;
  private Size size;

  //InventoryItem Associations
  private ClothingItem catalogItem;
  private FashionStoreManagementApp system;
  private List<Shipment> shipments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InventoryItem(int aQuantity, Size aSize, ClothingItem aCatalogItem)
  {
    quantity = aQuantity;
    size = aSize;
    boolean didAddCatalogItem = setCatalogItem(aCatalogItem);
    if (!didAddCatalogItem)
    {
      throw new RuntimeException("Unable to create stockedSize due to catalogItem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    shipments = new ArrayList<Shipment>();
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
  public ClothingItem getCatalogItem()
  {
    return catalogItem;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getSystem()
  {
    return system;
  }

  public boolean hasSystem()
  {
    boolean has = system != null;
    return has;
  }
  /* Code from template association_GetMany */
  public Shipment getShipment(int index)
  {
    Shipment aShipment = shipments.get(index);
    return aShipment;
  }

  public List<Shipment> getShipments()
  {
    List<Shipment> newShipments = Collections.unmodifiableList(shipments);
    return newShipments;
  }

  public int numberOfShipments()
  {
    int number = shipments.size();
    return number;
  }

  public boolean hasShipments()
  {
    boolean has = shipments.size() > 0;
    return has;
  }

  public int indexOfShipment(Shipment aShipment)
  {
    int index = shipments.indexOf(aShipment);
    return index;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setCatalogItem(ClothingItem aCatalogItem)
  {
    boolean wasSet = false;
    //Must provide catalogItem to stockedSize
    if (aCatalogItem == null)
    {
      return wasSet;
    }

    //catalogItem already at maximum (4)
    if (aCatalogItem.numberOfStockedSizes() >= ClothingItem.maximumNumberOfStockedSizes())
    {
      return wasSet;
    }
    
    ClothingItem existingCatalogItem = catalogItem;
    catalogItem = aCatalogItem;
    if (existingCatalogItem != null && !existingCatalogItem.equals(aCatalogItem))
    {
      boolean didRemove = existingCatalogItem.removeStockedSize(this);
      if (!didRemove)
      {
        catalogItem = existingCatalogItem;
        return wasSet;
      }
    }
    catalogItem.addStockedSize(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setSystem(FashionStoreManagementApp aSystem)
  {
    boolean wasSet = false;
    FashionStoreManagementApp existingSystem = system;
    system = aSystem;
    if (existingSystem != null && !existingSystem.equals(aSystem))
    {
      existingSystem.removeStockedItem(this);
    }
    if (aSystem != null)
    {
      aSystem.addStockedItem(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfShipments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addShipment(Shipment aShipment)
  {
    boolean wasAdded = false;
    if (shipments.contains(aShipment)) { return false; }
    shipments.add(aShipment);
    if (aShipment.indexOfUpdatedInventoryItem(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aShipment.addUpdatedInventoryItem(this);
      if (!wasAdded)
      {
        shipments.remove(aShipment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeShipment(Shipment aShipment)
  {
    boolean wasRemoved = false;
    if (!shipments.contains(aShipment))
    {
      return wasRemoved;
    }

    int oldIndex = shipments.indexOf(aShipment);
    shipments.remove(oldIndex);
    if (aShipment.indexOfUpdatedInventoryItem(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aShipment.removeUpdatedInventoryItem(this);
      if (!wasRemoved)
      {
        shipments.add(oldIndex,aShipment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addShipmentAt(Shipment aShipment, int index)
  {  
    boolean wasAdded = false;
    if(addShipment(aShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipments()) { index = numberOfShipments() - 1; }
      shipments.remove(aShipment);
      shipments.add(index, aShipment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShipmentAt(Shipment aShipment, int index)
  {
    boolean wasAdded = false;
    if(shipments.contains(aShipment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShipments()) { index = numberOfShipments() - 1; }
      shipments.remove(aShipment);
      shipments.add(index, aShipment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShipmentAt(aShipment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ClothingItem placeholderCatalogItem = catalogItem;
    this.catalogItem = null;
    if(placeholderCatalogItem != null)
    {
      placeholderCatalogItem.removeStockedSize(this);
    }
    if (system != null)
    {
      FashionStoreManagementApp placeholderSystem = system;
      this.system = null;
      placeholderSystem.removeStockedItem(this);
    }
    ArrayList<Shipment> copyOfShipments = new ArrayList<Shipment>(shipments);
    shipments.clear();
    for(Shipment aShipment : copyOfShipments)
    {
      aShipment.removeUpdatedInventoryItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "size" + "=" + (getSize() != null ? !getSize().equals(this)  ? getSize().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "catalogItem = "+(getCatalogItem()!=null?Integer.toHexString(System.identityHashCode(getCatalogItem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "system = "+(getSystem()!=null?Integer.toHexString(System.identityHashCode(getSystem())):"null");
  }
}