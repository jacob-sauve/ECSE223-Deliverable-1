/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Date;

// line 69 "FashionProjectManagementApp.ump"
public class SeasonalItem extends LimitedStatus
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Season { Winter, Spring, Summer, Fall }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SeasonalItem Attributes
  private Season season;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SeasonalItem(Date aStartDate, Date aEndDate, ClothingItem aLimitedItem, Season aSeason)
  {
    super(aStartDate, aEndDate, aLimitedItem);
    season = aSeason;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSeason(Season aSeason)
  {
    boolean wasSet = false;
    season = aSeason;
    wasSet = true;
    return wasSet;
  }

  public Season getSeason()
  {
    return season;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "season" + "=" + (getSeason() != null ? !getSeason().equals(this)  ? getSeason().toString().replaceAll("  ","    ") : "this" : "null");
  }
}