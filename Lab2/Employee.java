
import java.util.Arrays;

public class Employee 
{
//Declare instance variables of Employee class
	private String 		EmployeeName; 		
	private int 		EmployeeNumber; 	
	private int 		EmployeeAge; 		
	private String 		EmployeeState; 		
	private int 		EmployeeZipCode; 	
	private Integer[]	EmployeeAdvisors = new Integer[3]; 	

/*
FUNCTIONALITY: 	Constructor method that creates an Employee object
PARAMETERS: 	No parameters
RETURN VALUES: 	No return vales
PRE-CONDITIONS: None
*/	
	public Employee()
	{
		EmployeeName = null;
		EmployeeNumber = 0;
		EmployeeAge = 0;
		EmployeeState = null;
		EmployeeZipCode = 0;
		EmployeeAdvisors[0] = null;
		EmployeeAdvisors[1] = null;
		EmployeeAdvisors[2] = null;
	}
	
/*
FUNCTIONALITY: 	Copy constructor for an Employee class
PARAMETERS: 	object of type Object
RETURN VALUES: 	No return vales
PRE-CONDITIONS: object should not be null. It should be an instance of Employee
*/	
	public Employee (Object obj)
	{
		if ((obj != null) && (obj instanceof Employee))
		{
			//we proceed to create a new instance of Employee object
			Employee Empl = (Employee) obj;
			this.EmployeeName = new String(Empl.EmployeeName);
			this.EmployeeNumber = Empl.EmployeeNumber;
			this.EmployeeAge = Empl.EmployeeAge;
			this.EmployeeState = new String(Empl.EmployeeState);
			this.EmployeeZipCode = Empl.EmployeeZipCode;
			
			for(int i = 0; i < 3; i++)
			{
				this.EmployeeAdvisors[i] = Empl.EmployeeAdvisors[i];
			}
		}
		else
		{
			System.out.println("Unable to activate copy constructor. Object to be copied from is either a null object or is not an Employee type of data");
		}
	}

/*
FUNCTIONALITY: 	Get method that returns employee's name
PARAMETERS: 	No parameters
RETURN VALUES: 	Employee's name as a string
PRE-CONDITIONS: None
*/	
	public String getEmployeeName()
	{
		return EmployeeName;
	}		
	
/*
FUNCTIONALITY: 	Get method that returns employee's number
PARAMETERS: 	No parameters
RETURN VALUES: 	Employee's number as an int
PRE-CONDITIONS: None
*/		
	public int getEmployeeNumber()
	{
		return EmployeeNumber;
	}		
	
/*
FUNCTIONALITY: 	Get method that returns employee's age
PARAMETERS: 	No parameters
RETURN VALUES: 	Employee's age as an int
PRE-CONDITIONS: None
*/	
	public int getEmployeeAge()
	{
		return EmployeeAge;	
	}	
	
/*
FUNCTIONALITY: 	Get method that returns employee's state
PARAMETERS: 	No parameters
RETURN VALUES: 	Employee's state as a string
PRE-CONDITIONS: None
*/		
	public String getEmployeeState()
	{
		return EmployeeState;		
	}	
	
/*
FUNCTIONALITY: 	Get method that returns employee's zip code
PARAMETERS: 	No parameters
RETURN VALUES: 	Employee's zipcode as an int
PRE-CONDITIONS: None
*/			
	public int getEmployeeZipCode()
	{
		return EmployeeZipCode;
	}		
	
/*
FUNCTIONALITY: 	Get methods that return each employee's advisors
PARAMETERS: 	No parameters
RETURN VALUES: 	Each of the employee's advisors
PRE-CONDITIONS: None
*/		
	public Integer getEmployeeAdvisors1()
	{
		return EmployeeAdvisors[0];
	}	
	
	public Integer getEmployeeAdvisors2()
	{
		return EmployeeAdvisors[1];
	}	
	
	public Integer getEmployeeAdvisors3()
	{
		return EmployeeAdvisors[2];
	}		
	
// SET METHODS //
/*
FUNCTIONALITY: 	Method that sets an employee's name
PARAMETERS: 	Employee name to be set
RETURN VALUES: 	none (void)
PRE-CONDITIONS: None
*/	
	public void setEmployeeName(String newEmployeeName)
	{
		EmployeeName = newEmployeeName;
	}		
	
/*
FUNCTIONALITY: 	Method that sets the employee's number
PARAMETERS: 	Employee number to be set
RETURN VALUES: 	none (void)
PRE-CONDITIONS: None
*/		
	public void setEmployeeNumber(int newEmployeeNumber)
	{
		EmployeeNumber = newEmployeeNumber;
	}		
	
/*
FUNCTIONALITY: 	Method that sets the employee's age
PARAMETERS: 	Employee's age to be set
RETURN VALUES: 	none (void)
PRE-CONDITIONS: None
*/	
	public void setEmployeeAge(int newEmployeeAge)
	{
		EmployeeAge = newEmployeeAge;	
	}	
	
/*
FUNCTIONALITY: 	Method that sets the employee's state
PARAMETERS: 	Employee's state to be set
RETURN VALUES: 	none (void)
PRE-CONDITIONS: None
*/		
	public void setEmployeeState(String newEmployeeState)
	{
		EmployeeState = newEmployeeState;		
	}	
	
/*
FUNCTIONALITY: 	Method that sets employee's zipcode
PARAMETERS: 	Employee's zip code to be set
RETURN VALUES: 	none (void)
PRE-CONDITIONS: None
*/			
	public void setEmployeeZipCode(int newEmployeeZipCode)
	{
		EmployeeZipCode = newEmployeeZipCode;
	}		
	
/*
FUNCTIONALITY: 	Method that sets employee's advisors
PARAMETERS: 	Employee's advisor's numbers
RETURN VALUES: 	none (void)
PRE-CONDITIONS: None
*/		
	public void setEmployeeAdvisors(Integer advisor0, Integer advisor1, Integer advisor2)
	{
		EmployeeAdvisors[0] = advisor0;
		EmployeeAdvisors[1] = advisor1;
		EmployeeAdvisors[2] = advisor2;
	}
	
/*
FUNCTIONALITY: 	Method that generates a string representation of an employee
PARAMETERS: 	No parameters
RETURN VALUES: 	String containing employee information in the order of:
				employee name, employee number, age, state, zipcode and list of
				advisor's numbers
PRE-CONDITIONS: None
*/		
	public String toString()
	{
		return 	"Employee name:\t\t" + EmployeeName + "\n" + "Employee number:\t" + EmployeeNumber + "\n" +
				"Employee age:\t\t" + EmployeeAge + "\n" + "Employee state:\t\t" + EmployeeState + "\n" + 
				"Employee zipcode:\t" + EmployeeZipCode + "\n" + 
				"Employee advisor #1:\t" + EmployeeAdvisors[0] + "\n" + 
				"Employee advisor #2:\t" + EmployeeAdvisors[1] + "\n" + 
				"Employee advisor #3:\t" + EmployeeAdvisors[2]; 
	}		
	
/*
FUNCTIONALITY: 	Compare an employee's object to another in order to determie if both are equal generates a string representation of an employee
PARAMETERS: 	No parameters
RETURN VALUES: 	String containing employee information in the order of:
				employee name, employee number, age, state, zipcode and list of
				advisor's numbers
PRE-CONDITIONS: obj is required to be an instance of Employee type. obj should not be null
*/		
	public boolean equals(Object obj)	
	{		
		if ((obj != null) && (obj instanceof Employee))
		{
			Employee myEmployee = (Employee) obj;
						
			return 	(myEmployee.EmployeeNumber == EmployeeNumber);
		}
		else
			return false;	 
	}
	

///*
//FUNCTIONALITY: 	Function to remove one element from an array
//PARAMETERS: 		the array and the element to remove
//RETURN VALUES: 	a newly created array without the element that was to be removed
//PRE-CONDITIONS: 	none
//*/		
	public static int[] removeArrayElement(int[] receivedArray, int indexToRemove)
	{
		//Create the final array without the element to be removed
		int[] newArray = new int[receivedArray.length - 1];
		
		//We copy each element of the received array into the new array and stop at the specified index
		for(int i= 0; i < indexToRemove; i++)
		{
			newArray[i] = receivedArray[i];
		}
		
		//We continue copying each element of the received array into the new array but
		//skip the element that we want to remove
		for(int i= indexToRemove; i < receivedArray.length - 1; i++)
		{
			newArray[i] = receivedArray[i + 1];
		}
		return newArray;
	}
	
///*
//FUNCTIONALITY: 	Static method in order to return all the distinct advisors from two employees
//PARAMETERS: 	two objects of type Employee
//RETURN VALUES: 	array of integers  with the advisor's numbers
//PRE-CONDITIONS: neither e1 nor e2 should be null
//*/		
	
	  public static int[] getAllAdvisors(Employee e1, Employee e2) 
	  { 
		  int[] newAdvisorArray = new int[6];
		  int totalElementsPerAray = 3;
	  
	  //Check whether one of the objects is null 
	  if ((e1 != null) && (e2 != null))
	  {
	  
		  //We proceed to add together all the elements from both arrays
		  for (int i = 0; i < e1.EmployeeAdvisors.length; i++) 
		  {	
			  newAdvisorArray[i] = e1.EmployeeAdvisors[i];
		  }
		  
		  for (int i = totalElementsPerAray, j = 0; i < e2.EmployeeAdvisors.length + totalElementsPerAray; i++, j++) 
		  {	
			  newAdvisorArray[i] = e2.EmployeeAdvisors[j];
		  }
		  		  
		  //proceed to find differences in the newly created array, then create a final array out of those differences
		  for(int i = 0; i < newAdvisorArray.length; i++)
			  for(int j = i + 1; j < newAdvisorArray.length; j++)
				  if(newAdvisorArray[i] == newAdvisorArray[j])
				  {
					newAdvisorArray = removeArrayElement(newAdvisorArray, j);
		  			newAdvisorArray = removeArrayElement(newAdvisorArray, i);
		  			
				  }
		  	
		  return newAdvisorArray; 
	  }
	  else
	  {
		  return newAdvisorArray = null;
	  }
	  
	  }
	 	
	public static void main(String[] args) 
	{
		//Create new employee
		System.out.println("Create a new employee by activating the default constructor...");
		Employee myEmployee = new Employee();
		
		//Read employee data with the no-argument constructor
		System.out.println("\nThe data of the employee that we just created, with the default constructor, is the following:\n" +myEmployee.toString());
		
		//Proceed to enter details about new employee
		System.out.println("\nProceed to enter details about the new employee...");
		myEmployee.setEmployeeName("Jerry");
		myEmployee.setEmployeeNumber(3140);
		myEmployee.setEmployeeAge(32);
		myEmployee.setEmployeeState("Texas");
		myEmployee.setEmployeeZipCode(79915);
		myEmployee.setEmployeeAdvisors(1530, 1234, 2500);
		
		//Read employee data once set methods have been activated
		System.out.println("\nThe data of the employee once it has been filled by activating \"set methods\" is the following:\n" +myEmployee.toString());
		
		//Read employee data by activating get methods
		System.out.println("\nEmployee's data after activating \"get methods\" is:");
		System.out.println("Employee name:\t\t" + myEmployee.getEmployeeName());
		System.out.println("Employee number:\t" + myEmployee.getEmployeeNumber());
		System.out.println("Employee age:\t\t" + myEmployee.getEmployeeAge());
		System.out.println("Employee state:\t\t" + myEmployee.getEmployeeState());
		System.out.println("Employee zipcode:\t" + myEmployee.getEmployeeZipCode());
		System.out.println("Employee advisor #1:\t" + myEmployee.getEmployeeAdvisors1());
		System.out.println("Employee advisor #2:\t" + myEmployee.getEmployeeAdvisors2());
		System.out.println("Employee advisor #3:\t" + myEmployee.getEmployeeAdvisors3());
		
		//Activate copy constructor
		System.out.println("\nWe proceed to activate the copy constructor...");
		Employee myCopiedEmployee = new Employee(myEmployee);
		System.out.println("\nThe data of the copied employee after the copy constructor was activated is the following:\n" +myCopiedEmployee.toString());
				
		//Rename the copied employee
		//Proceed to enter details about new employee and then print data
		myCopiedEmployee.setEmployeeName("Jennifer");
		myCopiedEmployee.setEmployeeNumber(8580);
		myCopiedEmployee.setEmployeeAge(28);
		myCopiedEmployee.setEmployeeState("Alabama");
		myCopiedEmployee.setEmployeeZipCode(35005);
		myCopiedEmployee.setEmployeeAdvisors(2458, 1530, 2090);
		System.out.println("\nThe data of the copied employee after changing his data is the following:\n" +myCopiedEmployee.toString());
		
		//Read employee data once set methods have been activated
		System.out.println("\nThe data of the original employee remains unchanged:\n" +myEmployee.toString());
		
		//In the following section, we proceed to test the "equals method"
		//Create new employee
		System.out.println("\nCreate a new employee and set it to null...");
		Employee myNullEmployee = null;
		
		System.out.println("\nTEST CASE #1: Result of activating equals method with a null employee: " + myCopiedEmployee.equals(myNullEmployee));
		
		String myString = "Hello All";
		System.out.println("\nTEST CASE #2: Result of acivating equals method with a type of data != than employee: " + myCopiedEmployee.equals(myString));
		
		myEmployee.setEmployeeNumber(8580);
		//myCopieEmployee.EmployeeNumber has 8580 as value
		System.out.println("\nTEST CASE #3: Call the equals method when both employee numbers are the same: " + myCopiedEmployee.equals(myEmployee));
		
		myEmployee.setEmployeeNumber(9005);
		//myCopieEmployee.EmployeeNumber has 9005 as value
		System.out.println("\nTEST CASE #4: Call the equals method when both employee numbers are different: " + myCopiedEmployee.equals(myEmployee));
		
		//Activate the get all advisors method
		System.out.println("\nActivate the \"get all advisors\" method. List of all different advisors from 2 different employees:");
		int [] advisorsArray = Employee.getAllAdvisors(myEmployee, myCopiedEmployee);
		System.out.println(Arrays.toString(advisorsArray));	
		
		myEmployee = null;
		//set first parameter to null in order to test the getAllAdvisor method
		System.out.println("\nTEST CASE #5: Activate the \\\"get all advisors\\\" method with the first parameter being null: " + Employee.getAllAdvisors(myEmployee, myCopiedEmployee));
		
		//set second parameter to null in order to test the getAllAdvisor method
		System.out.println("\nTEST CASE #6: Activate the \\\"get all advisors\\\" method with the second parameter being null: " + Employee.getAllAdvisors(myCopiedEmployee, myEmployee));			
	}

}
