/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.35.0.8072.d3fbfafbc modeling language!*/


import java.util.*;

// line 11 "model.ump"
// line 132 "model.ump"
public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String name;
  private String phoneNumber;

  //User Associations
  private List<AccountType> storeRoles;
  private FashionStoreManagementApp system;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(FashionStoreManagementApp aSystem)
  {
    name = null;
    phoneNumber = null;
    storeRoles = new ArrayList<AccountType>();
    boolean didAddSystem = setSystem(aSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create user due to system. See https://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setPhoneNumber(String aPhoneNumber)
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

  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  /* Code from template association_GetMany */
  public AccountType getStoreRole(int index)
  {
    AccountType aStoreRole = storeRoles.get(index);
    return aStoreRole;
  }

  public List<AccountType> getStoreRoles()
  {
    List<AccountType> newStoreRoles = Collections.unmodifiableList(storeRoles);
    return newStoreRoles;
  }

  public int numberOfStoreRoles()
  {
    int number = storeRoles.size();
    return number;
  }

  public boolean hasStoreRoles()
  {
    boolean has = storeRoles.size() > 0;
    return has;
  }

  public int indexOfStoreRole(AccountType aStoreRole)
  {
    int index = storeRoles.indexOf(aStoreRole);
    return index;
  }
  /* Code from template association_GetOne */
  public FashionStoreManagementApp getSystem()
  {
    return system;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStoreRoles()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfStoreRoles()
  {
    return 3;
  }
  /* Code from template association_AddOptionalNToOne */


  public boolean addStoreRole(AccountType aStoreRole)
  {
    boolean wasAdded = false;
    if (storeRoles.contains(aStoreRole)) { return false; }
    if (numberOfStoreRoles() >= maximumNumberOfStoreRoles())
    {
      return wasAdded;
    }

    User existingPerson = aStoreRole.getPerson();
    boolean isNewPerson = existingPerson != null && !this.equals(existingPerson);
    if (isNewPerson)
    {
      aStoreRole.setPerson(this);
    }
    else
    {
      storeRoles.add(aStoreRole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStoreRole(AccountType aStoreRole)
  {
    boolean wasRemoved = false;
    //Unable to remove aStoreRole, as it must always have a person
    if (!this.equals(aStoreRole.getPerson()))
    {
      storeRoles.remove(aStoreRole);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStoreRoleAt(AccountType aStoreRole, int index)
  {  
    boolean wasAdded = false;
    if(addStoreRole(aStoreRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStoreRoles()) { index = numberOfStoreRoles() - 1; }
      storeRoles.remove(aStoreRole);
      storeRoles.add(index, aStoreRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStoreRoleAt(AccountType aStoreRole, int index)
  {
    boolean wasAdded = false;
    if(storeRoles.contains(aStoreRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStoreRoles()) { index = numberOfStoreRoles() - 1; }
      storeRoles.remove(aStoreRole);
      storeRoles.add(index, aStoreRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStoreRoleAt(aStoreRole, index);
    }
    return wasAdded;
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
      existingSystem.removeUser(this);
    }
    system.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=storeRoles.size(); i > 0; i--)
    {
      AccountType aStoreRole = storeRoles.get(i - 1);
      aStoreRole.delete();
    }
    FashionStoreManagementApp placeholderSystem = system;
    this.system = null;
    if(placeholderSystem != null)
    {
      placeholderSystem.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "system = "+(getSystem()!=null?Integer.toHexString(System.identityHashCode(getSystem())):"null");
  }
}