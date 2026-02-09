/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 44 "FashionProjectManagementApp.ump"
public class Shipment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shipment Attributes
  private Date dateOrdered;
  private Date deliveryDate;

  //Shipment Associations
  private FashionStoreManagementApp app;
  private List<ClothingItem> receivedItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shipment(Date aDateOrdered, FashionStoreManagementApp aApp)
  {
    dateOrdered = aDateOrdered;
    deliveryDate = null;
    boolean didAddApp = setApp(aApp);
    if (!didAddApp)
    {
      throw new RuntimeException("Unable to create shipment due to app. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    receivedItems = new ArrayList<ClothingItem>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDateOrdered(Date aDateOrdered)
  {
    boolean wasSet = false;
    dateOrdered = aDateOrdered;
    wasSet = true;
    return wasSet;
  }

  public boolean setDeliveryDate(Date aDeliveryDate)
  {
    boolean wasSet = false;
    deliveryDate = aDeliveryDate;
    wasSet = true;
    return wasSet;
  }

  public Date getDateOrdered()
  {
    return dateOrdered;
  }

  /**
   * always shipped next day
   */
  public Date getDeliveryDate()
  {
    return deliveryDate;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getApp()
  {
    return app;
  }
  /* Code from template association_GetMany */
  public ClothingItem getReceivedItem(int index)
  {
    ClothingItem aReceivedItem = receivedItems.get(index);
    return aReceivedItem;
  }

  public List<ClothingItem> getReceivedItems()
  {
    List<ClothingItem> newReceivedItems = Collections.unmodifiableList(receivedItems);
    return newReceivedItems;
  }

  public int numberOfReceivedItems()
  {
    int number = receivedItems.size();
    return number;
  }

  public boolean hasReceivedItems()
  {
    boolean has = receivedItems.size() > 0;
    return has;
  }

  public int indexOfReceivedItem(ClothingItem aReceivedItem)
  {
    int index = receivedItems.indexOf(aReceivedItem);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setApp(FashionStoreManagementApp aApp)
  {
    boolean wasSet = false;
    if (aApp == null)
    {
      return wasSet;
    }

    FashionStoreManagementApp existingApp = app;
    app = aApp;
    if (existingApp != null && !existingApp.equals(aApp))
    {
      existingApp.removeShipment(this);
    }
    app.addShipment(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReceivedItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addReceivedItem(ClothingItem aReceivedItem)
  {
    boolean wasAdded = false;
    if (receivedItems.contains(aReceivedItem)) { return false; }
    receivedItems.add(aReceivedItem);
    if (aReceivedItem.indexOfShipment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aReceivedItem.addShipment(this);
      if (!wasAdded)
      {
        receivedItems.remove(aReceivedItem);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeReceivedItem(ClothingItem aReceivedItem)
  {
    boolean wasRemoved = false;
    if (!receivedItems.contains(aReceivedItem))
    {
      return wasRemoved;
    }

    int oldIndex = receivedItems.indexOf(aReceivedItem);
    receivedItems.remove(oldIndex);
    if (aReceivedItem.indexOfShipment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aReceivedItem.removeShipment(this);
      if (!wasRemoved)
      {
        receivedItems.add(oldIndex,aReceivedItem);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addReceivedItemAt(ClothingItem aReceivedItem, int index)
  {  
    boolean wasAdded = false;
    if(addReceivedItem(aReceivedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceivedItems()) { index = numberOfReceivedItems() - 1; }
      receivedItems.remove(aReceivedItem);
      receivedItems.add(index, aReceivedItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReceivedItemAt(ClothingItem aReceivedItem, int index)
  {
    boolean wasAdded = false;
    if(receivedItems.contains(aReceivedItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceivedItems()) { index = numberOfReceivedItems() - 1; }
      receivedItems.remove(aReceivedItem);
      receivedItems.add(index, aReceivedItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReceivedItemAt(aReceivedItem, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    FashionStoreManagementApp placeholderApp = app;
    this.app = null;
    if(placeholderApp != null)
    {
      placeholderApp.removeShipment(this);
    }
    ArrayList<ClothingItem> copyOfReceivedItems = new ArrayList<ClothingItem>(receivedItems);
    receivedItems.clear();
    for(ClothingItem aReceivedItem : copyOfReceivedItems)
    {
      aReceivedItem.removeShipment(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "dateOrdered" + "=" + (getDateOrdered() != null ? !getDateOrdered().equals(this)  ? getDateOrdered().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "deliveryDate" + "=" + (getDeliveryDate() != null ? !getDeliveryDate().equals(this)  ? getDeliveryDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "app = "+(getApp()!=null?Integer.toHexString(System.identityHashCode(getApp())):"null");
  }
}