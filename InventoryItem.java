/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.8072.d3fbfafbc modeling language!*/



// line 59 "model.ump"
// line 172 "model.ump"
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
  private FashionStoreManagementApp inventory;

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
      throw new RuntimeException("Unable to create stockedSize due to catalogItem. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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
  public ClothingItem getCatalogItem()
  {
    return catalogItem;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getInventory()
  {
    return inventory;
  }

  public boolean hasInventory()
  {
    boolean has = inventory != null;
    return has;
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
  public boolean setInventory(FashionStoreManagementApp aInventory)
  {
    boolean wasSet = false;
    FashionStoreManagementApp existingInventory = inventory;
    inventory = aInventory;
    if (existingInventory != null && !existingInventory.equals(aInventory))
    {
      existingInventory.removeStockedItem(this);
    }
    if (aInventory != null)
    {
      aInventory.addStockedItem(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ClothingItem placeholderCatalogItem = catalogItem;
    this.catalogItem = null;
    if(placeholderCatalogItem != null)
    {
      placeholderCatalogItem.removeStockedSize(this);
    }
    if (inventory != null)
    {
      FashionStoreManagementApp placeholderInventory = inventory;
      this.inventory = null;
      placeholderInventory.removeStockedItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "size" + "=" + (getSize() != null ? !getSize().equals(this)  ? getSize().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "catalogItem = "+(getCatalogItem()!=null?Integer.toHexString(System.identityHashCode(getCatalogItem())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "inventory = "+(getInventory()!=null?Integer.toHexString(System.identityHashCode(getInventory())):"null");
  }
}