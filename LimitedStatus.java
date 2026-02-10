/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 62 "FashionProjectManagementApp.ump"
public abstract class LimitedStatus
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LimitedStatus Attributes
  private Date startDate;
  private Date endDate;

  //LimitedStatus Associations
  private ClothingItem limitedItem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LimitedStatus(Date aStartDate, Date aEndDate, ClothingItem aLimitedItem)
  {
    startDate = aStartDate;
    endDate = aEndDate;
    boolean didAddLimitedItem = setLimitedItem(aLimitedItem);
    if (!didAddLimitedItem)
    {
      throw new RuntimeException("Unable to create limitedStatus due to limitedItem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartDate(Date aStartDate)
  {
    boolean wasSet = false;
    startDate = aStartDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndDate(Date aEndDate)
  {
    boolean wasSet = false;
    endDate = aEndDate;
    wasSet = true;
    return wasSet;
  }

  public Date getStartDate()
  {
    return startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }
  /* Code from template association_GetOne */
  public ClothingItem getLimitedItem()
  {
    return limitedItem;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setLimitedItem(ClothingItem aNewLimitedItem)
  {
    boolean wasSet = false;
    if (aNewLimitedItem == null)
    {
      //Unable to setLimitedItem to null, as limitedStatus must always be associated to a limitedItem
      return wasSet;
    }
    
    LimitedStatus existingLimitedStatus = aNewLimitedItem.getLimitedStatus();
    if (existingLimitedStatus != null && !equals(existingLimitedStatus))
    {
      //Unable to setLimitedItem, the current limitedItem already has a limitedStatus, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    ClothingItem anOldLimitedItem = limitedItem;
    limitedItem = aNewLimitedItem;
    limitedItem.setLimitedStatus(this);

    if (anOldLimitedItem != null)
    {
      anOldLimitedItem.setLimitedStatus(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ClothingItem existingLimitedItem = limitedItem;
    limitedItem = null;
    if (existingLimitedItem != null)
    {
      existingLimitedItem.setLimitedStatus(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endDate" + "=" + (getEndDate() != null ? !getEndDate().equals(this)  ? getEndDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "limitedItem = "+(getLimitedItem()!=null?Integer.toHexString(System.identityHashCode(getLimitedItem())):"null");
  }
}