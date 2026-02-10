/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 21 "FashionProjectManagementApp.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String name;
  private int phoneNumber;

  //User Associations
  private List<UserAccount> userAccounts;
  private FashionStoreManagementApp app;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(FashionStoreManagementApp aApp)
  {
    name = null;
    phoneNumber = 0;
    userAccounts = new ArrayList<UserAccount>();
    boolean didAddApp = setApp(aApp);
    if (!didAddApp)
    {
      throw new RuntimeException("Unable to create user due to app. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(int aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }
  /* Code from template association_GetMany */
  public UserAccount getUserAccount(int index)
  {
    UserAccount aUserAccount = userAccounts.get(index);
    return aUserAccount;
  }

  public List<UserAccount> getUserAccounts()
  {
    List<UserAccount> newUserAccounts = Collections.unmodifiableList(userAccounts);
    return newUserAccounts;
  }

  public int numberOfUserAccounts()
  {
    int number = userAccounts.size();
    return number;
  }

  public boolean hasUserAccounts()
  {
    boolean has = userAccounts.size() > 0;
    return has;
  }

  public int indexOfUserAccount(UserAccount aUserAccount)
  {
    int index = userAccounts.indexOf(aUserAccount);
    return index;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getApp()
  {
    return app;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUserAccounts()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfUserAccounts()
  {
    return 3;
  }
  /* Code from template association_AddOptionalNToOne */


  public boolean addUserAccount(UserAccount aUserAccount)
  {
    boolean wasAdded = false;
    if (userAccounts.contains(aUserAccount)) { return false; }
    if (numberOfUserAccounts() >= maximumNumberOfUserAccounts())
    {
      return wasAdded;
    }

    User existingUser = aUserAccount.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aUserAccount.setUser(this);
    }
    else
    {
      userAccounts.add(aUserAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUserAccount(UserAccount aUserAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aUserAccount, as it must always have a user
    if (!this.equals(aUserAccount.getUser()))
    {
      userAccounts.remove(aUserAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAccountAt(UserAccount aUserAccount, int index)
  {  
    boolean wasAdded = false;
    if(addUserAccount(aUserAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserAccounts()) { index = numberOfUserAccounts() - 1; }
      userAccounts.remove(aUserAccount);
      userAccounts.add(index, aUserAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAccountAt(UserAccount aUserAccount, int index)
  {
    boolean wasAdded = false;
    if(userAccounts.contains(aUserAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserAccounts()) { index = numberOfUserAccounts() - 1; }
      userAccounts.remove(aUserAccount);
      userAccounts.add(index, aUserAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAccountAt(aUserAccount, index);
    }
    return wasAdded;
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
      existingApp.removeUser(this);
    }
    app.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=userAccounts.size(); i > 0; i--)
    {
      UserAccount aUserAccount = userAccounts.get(i - 1);
      aUserAccount.delete();
    }
    FashionStoreManagementApp placeholderApp = app;
    this.app = null;
    if(placeholderApp != null)
    {
      placeholderApp.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "app = "+(getApp()!=null?Integer.toHexString(System.identityHashCode(getApp())):"null");
  }
}