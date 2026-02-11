/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 10 "FashionProjectManagementApp.ump"
public abstract class AccountType
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, AccountType> accounttypesByUsername = new HashMap<String, AccountType>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AccountType Attributes
  private String username;
  private String password;

  //AccountType Associations
  private User person;
  private FashionStoreManagementApp system;

  //Helper Variables
  private boolean canSetUsername;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AccountType(String aUsername, String aPassword, User aPerson, FashionStoreManagementApp aSystem)
  {
    canSetUsername = true;
    password = aPassword;
    if (!setUsername(aUsername))
    {
      throw new RuntimeException("Cannot create due to duplicate username. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create storeRole due to person. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddSystem = setSystem(aSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create account due to system. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetImmutable */
  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    if (!canSetUsername) { return false; }
    String anOldUsername = getUsername();
    if (anOldUsername != null && anOldUsername.equals(aUsername)) {
      return true;
    }
    if (hasWithUsername(aUsername)) {
      return wasSet;
    }
    canSetUsername = false;
    username = aUsername;
    wasSet = true;
    if (anOldUsername != null) {
      accounttypesByUsername.remove(anOldUsername);
    }
    accounttypesByUsername.put(aUsername, this);
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }
  /* Code from template attribute_GetUnique */
  public static AccountType getWithUsername(String aUsername)
  {
    return accounttypesByUsername.get(aUsername);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithUsername(String aUsername)
  {
    return getWithUsername(aUsername) != null;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template association_GetOne */
  public User getPerson()
  {
    return person;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getSystem()
  {
    return system;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setPerson(User aPerson)
  {
    boolean wasSet = false;
    //Must provide person to storeRole
    if (aPerson == null)
    {
      return wasSet;
    }

    //person already at maximum (3)
    if (aPerson.numberOfStoreRoles() >= User.maximumNumberOfStoreRoles())
    {
      return wasSet;
    }
    
    User existingPerson = person;
    person = aPerson;
    if (existingPerson != null && !existingPerson.equals(aPerson))
    {
      boolean didRemove = existingPerson.removeStoreRole(this);
      if (!didRemove)
      {
        person = existingPerson;
        return wasSet;
      }
    }
    person.addStoreRole(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setSystem(FashionStoreManagementApp aSystem)
  {
    boolean wasSet = false;
    if (aSystem == null)
    {
      return wasSet;
    }

    FashionStoreManagementApp existingSystem = system;
    system = aSystem;
    if (existingSystem != null && !existingSystem.equals(aSystem))
    {
      existingSystem.removeAccount(this);
    }
    system.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    accounttypesByUsername.remove(getUsername());
    User placeholderPerson = person;
    this.person = null;
    if(placeholderPerson != null)
    {
      placeholderPerson.removeStoreRole(this);
    }
    FashionStoreManagementApp placeholderSystem = system;
    this.system = null;
    if(placeholderSystem != null)
    {
      placeholderSystem.removeAccount(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "system = "+(getSystem()!=null?Integer.toHexString(System.identityHashCode(getSystem())):"null");
  }
}