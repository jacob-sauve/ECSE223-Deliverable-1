/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;
import java.util.*;

// line 45 "FashionProjectManagementApp.ump"
public class LimitedItem extends ClothingItem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LimitedItem Attributes
  private Date startDate;
  private Date endDate;
  private boolean isSeasonal;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LimitedItem(String aName, double aPrice, int aLoyaltyPoints, FashionStoreManagementApp aCatalog, Date aStartDate, Date aEndDate, boolean aIsSeasonal)
  {
    super(aName, aPrice, aLoyaltyPoints, aCatalog);
    startDate = aStartDate;
    endDate = aEndDate;
    isSeasonal = aIsSeasonal;
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

  public boolean setIsSeasonal(boolean aIsSeasonal)
  {
    boolean wasSet = false;
    isSeasonal = aIsSeasonal;
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

  /**
   * if is seasonal, kept in system with shifted start/end dates
   */
  public boolean getIsSeasonal()
  {
    return isSeasonal;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsSeasonal()
  {
    return isSeasonal;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "isSeasonal" + ":" + getIsSeasonal()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startDate" + "=" + (getStartDate() != null ? !getStartDate().equals(this)  ? getStartDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endDate" + "=" + (getEndDate() != null ? !getEndDate().equals(this)  ? getEndDate().toString().replaceAll("  ","    ") : "this" : "null");
  }
}