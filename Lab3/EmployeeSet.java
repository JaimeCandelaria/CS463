//Student: 	Jaime Candelaria
//Date:		09/16/2019
//Course:	CS463
//Code:	Employeeset.java (employee collection)

import java.io.*;

public class EmployeeSet {
//Declare instance variables for this class.
//We keep track of the number of employees.
//We also crate an Employee array
	private int 			numOfEmployees;
	private Employee[]		employeeData;
	
	
/*
FUNCTIONALITY: 	No-argument constructor method that initializes an 
employee set instance, sets it's capacity to 10 and creates an array
to store 10 Employee objects.
PARAMETERS: 	No parameters
RETURN VALUES: 	No return vales
PRE-CONDITIONS: None
*/	
	public EmployeeSet()
	{
		numOfEmployees = 0;
		employeeData = new Employee[10];
	}
	
	
/*
FUNCTIONALITY: 	Copy constructor that creates a new employee set and
copies the contents of the given object to an instance.
PARAMETERS: 	Object of type object
RETURN VALUES: 	No return vales
PRE-CONDITIONS: Object should not be null. It should be an instance
of EmployeeSet
*/	
	public EmployeeSet(Object obj)
	{
		if((obj != null) && (obj instanceof EmployeeSet))
		{
			//proceed to create a new instance of EmployeeSet
			EmployeeSet copiedEmployeeSet = (EmployeeSet) obj;
			this.employeeData = copiedEmployeeSet.employeeData;
			this.numOfEmployees = copiedEmployeeSet.numOfEmployees;
		}
		else
		{
			//throw new IllegalArgumentException("Unable to activate copy constructor. Object to be copied from is either a null object or is not an EmployeeSet object");
			System.out.println("ERROR: Unable to activate copy constructor. Object to be copied from is either a null object or is not an EmployeeSet object");
		}
	}

	
/*
FUNCTIONALITY: 	Returns the actual number of elements in the EmployeeSet collection
PARAMETERS: 	none
RETURN VALUES: 	actual number of elements in the array as an integer
PRE-CONDITIONS: none
*/	
	public int size()
	{
		return numOfEmployees;
	}
	
	
/*
FUNCTIONALITY: 	Returns the capacity of the EmployeeSet collection
PARAMETERS: 	none
RETURN VALUES: 	The capacity of the EmployeeSet collection as an integer
PRE-CONDITIONS: none
*/	
	public int capacity()
	{
		return employeeData.length;
	}
	
	
/*
FUNCTIONALITY: 	Adds an employee object to the first available space in the EmployeeSet collection
PARAMETERS: 	Employee object
RETURN VALUES: 	none
PRE-CONDITIONS: Employee object should not be null
*/	
	public void add(Employee a)
	{
		if(a == null)
			System.out.println("ERROR: Object parameter must not be null!");
			//throw new IllegalArgumentException("ERROR: Object parameter must not be null!");
		else 
		{
			if(employeeData.length == numOfEmployees)
			{
				ensureCapacity(numOfEmployees * 2);
			}
			
			employeeData[numOfEmployees] = a;
			numOfEmployees++;	
		}
	}
	
	
/*
FUNCTIONALITY: 	This method checks whether the collection contains the input parameter
PARAMETERS: 	Employee object
RETURN VALUES: 	boolean if employee is found
PRE-CONDITIONS: Employee object should not be null. If it is then return false
*/	
	public boolean contains (Employee a)
	{
		boolean employeeFound = false;
		if(a == null)
			{
			System.out.println("ERROR: Object parameter must not be null!");
			return false;
			}
			//throw new IllegalArgumentException("ERROR: Object parameter must not be null!");
		else
		{
			for(int i= 0; i < employeeData.length; i++)
			{
				if(employeeData[i] == a)
				{
					employeeFound = true;
				}
			}
		}
		
		return employeeFound;
	}
	
	
/*
FUNCTIONALITY: 	Removes from the collection an employee with the given employee number
PARAMETERS: 	integer employee number
RETURN VALUES: 	boolean if employee with employee number is found
PRE-CONDITIONS: none
*/	
	public boolean remove(int eNumber)
	{
		boolean employeeRemoved = false;
		
		for(int i = 0; i < numOfEmployees; i++)
		{
			if(employeeData[i].getEmployeeNumber() == eNumber)
			{
				employeeData[i] = employeeData[numOfEmployees - 1];
				numOfEmployees--;
				employeeRemoved = true;
				break;
			}
		}
		
		if(employeeRemoved == false)
			System.out.println("Employee number entered is not associated with an employee in the array!");
		return employeeRemoved;
	}
	
	
/*
FUNCTIONALITY: 	Guarantees the capacity of the collection
PARAMETERS: 	integer minimumCapacity
RETURN VALUES: 	none
PRE-CONDITIONS: parameter minimumCapacity should be positive
*/	
	public void ensureCapacity(int minimumCapacity)
	{
		Employee[] newBigArray;
		
		if(minimumCapacity > 0)
		{
			if(employeeData.length < minimumCapacity)
			{
				newBigArray = new Employee [minimumCapacity];
				for(int i = 0; i < numOfEmployees; i++ )
				{
					newBigArray[i] = employeeData[i];
				}
				 employeeData = newBigArray;
			}
		}
		else
		{
			System.out.println("ERROR: The capacity of the array should be a positive number!");
		}
			
	}
	
	
/*
FUNCTIONALITY: 	Arranges employee's array in ascending order
PARAMETERS: 	none
RETURN VALUES: 	none
PRE-CONDITIONS: none
*/	
	public void sortEmployeeArray()
	    {
			Employee employeeTmp = new Employee();
	        for(int i = 0; i < numOfEmployees - 1; i++)
	        {
	            for(int j = 0; j < numOfEmployees - 1; j++)
	            {
	                if (employeeData[j].getEmployeeNumber() > employeeData[j+1].getEmployeeNumber())
	                {
	                	employeeTmp = employeeData[j+1];
	                	employeeData[j+1] = employeeData[j];
	                	employeeData[j] = employeeTmp;
	                }
	            }
	        }

	    }	

/*
FUNCTIONALITY: 	Adds an employee object to an EmployeeSet collection that is already in ascending order of employee numbers
PARAMETERS: 	Employee object
RETURN VALUES: 	none
PRE-CONDITIONS: Employee object should not be null
*/	
		public void addOrdered(Employee a)
		{
			if(a == null)
				System.out.println("ERROR: Object parameter must not be null!");
				//throw new IllegalArgumentException("ERROR: Object parameter must not be null!");
			else 
			{
				sortEmployeeArray();
				
				if(employeeData.length == numOfEmployees)
				{
					ensureCapacity(numOfEmployees * 2);
				}
				
				employeeData[numOfEmployees] = a;
				numOfEmployees++;	
				
				sortEmployeeArray();
				
			}
		}

/*
FUNCTIONALITY: 	Method allows to read a file that contains employee information
PARAMETERS: 	.csv file
RETURN VALUES: 	none
PRE-CONDITIONS: File must exist
*/			
	//Read information from a file
	public void read(String fileName)
	{
		String line = "";
		int headCount = 0;
		Employee helperEmployee;
		
		try
		{
			//FileReader is in charge of reading text files
			FileReader fileReader = new FileReader(fileName);
			
			//Wrapping FileReader in BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			//Continue reading until we reach end of file
			while( (line = bufferedReader.readLine()) != null)
			{
				String[] lineString = line.split(",");
				//Get the header information and arrange it just once, then read the rest of the information
				if(headCount == 0)
				{
				
				}
				else
				{
					helperEmployee = new Employee();
					helperEmployee.setEmployeeName(lineString[0] + "" + lineString[1]); 
					helperEmployee.setEmployeeNumber(Integer.parseInt(lineString[2]));
					helperEmployee.setEmployeeState(lineString[3]);
					helperEmployee.setEmployeeZipCode(Integer.parseInt(lineString[4]));
					helperEmployee.setEmployeeAge(Integer.parseInt(lineString[6]));
					add(helperEmployee);
				}
	
				//Keep track of number of employees
				headCount++;
			}
			
			//Close file as good practice
			bufferedReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("Unable to open the file named '" + fileName + "'");
		}
		catch(IOException ex)
		{
			System.out.println("Error when reading the file " + fileName + "'");
		}
	}		

	public static void main(String[] args) 
	{
		//----------------------EMPLOYEE INITIALIZATION----------------------
		System.out.println("----------------------EMPLOYEE INITIALIZATION LOGIC---------------------------");
		//Create new employees
		System.out.println("Create a new employee named John by activating the default employee constructor...");
		Employee John = new Employee();
		
		System.out.println("\nCreate a new employee named Will by activating the default employee constructor...");
		Employee Will = new Employee();
		
		System.out.println("\nCreate a new employee named Peter by activating the default employee constructor...");
		Employee Peter = new Employee();
		
		System.out.println("\nCreate a new employee named Mark by activating the default employee constructor...");
		Employee Mark = new Employee();
		
		System.out.println("\nCreate a new employee named Edward by activating the default employee constructor...");
		Employee Edward = new Employee();
		
		System.out.println("\nCreate a new employee named Alex by activating the default employee constructor...");
		Employee Alex = new Employee();
		
		System.out.println("\nCreate a new employee named Oswald by activating the default employee constructor...");
		Employee Oswald = new Employee();
		
		System.out.println("\nCreate a new employee named Joe by activating the default employee constructor...");
		Employee Joe = new Employee();
		
		System.out.println("\nCreate a new employee named Adam by activating the default employee constructor...");
		Employee Adam = new Employee();
		
		System.out.println("\nCreate a new employee named Sasha by activating the default employee constructor...");
		Employee Sasha = new Employee();
		
		System.out.println("\nCreate a new employee named Miranda by activating the default employee constructor...");
		Employee Miranda = new Employee();
		
		System.out.println("\nCreate a new employee named Selena by activating the default employee constructor...");
		Employee Selena = new Employee();
		
		System.out.println("\nCreate a new employee named Lucia by activating the default employee constructor...");
		Employee Lucia = new Employee();
		
		System.out.println("\nCreate a new employee named Esther by activating the default employee constructor...");
		Employee Esther = new Employee();
		
		System.out.println("\nCreate a new employee named Amy by activating the default employee constructor...");
		Employee Amy = new Employee();
		
		System.out.println("\nCreate a new employee named Penelope by activating the default employee constructor...");
		Employee Penelope = new Employee();
				
		
		//Proceed to enter details about the employees
		System.out.println("\n\nProceed to enter details about employee named John ...");
		John.setEmployeeName("John");
		John.setEmployeeNumber(3140);
		
		System.out.println("\nProceed to enter details about employee named Will ...");
		Will.setEmployeeName("Will");
		Will.setEmployeeNumber(2025);
		
		System.out.println("\nProceed to enter details about employee named Peter ...");
		Peter.setEmployeeName("Peter");
		Peter.setEmployeeNumber(4516);
		
		System.out.println("\nProceed to enter details about employee named Mark ...");
		Mark.setEmployeeName("Mark");
		Mark.setEmployeeNumber(7722);
		
		System.out.println("\nProceed to enter details about employee named Edward ...");
		Edward.setEmployeeName("Edward");
		Edward.setEmployeeNumber(6374);

		System.out.println("\nProceed to enter details about employee named Alex ...");
		Alex.setEmployeeName("Alex");
		Alex.setEmployeeNumber(2765);
		
		System.out.println("\nProceed to enter details about employee named Oswald ...");
		Oswald.setEmployeeName("Oswald");
		Oswald.setEmployeeNumber(2028);
		
		System.out.println("\nProceed to enter details about employee named Joe ...");
		Joe.setEmployeeName("Joe");
		Joe.setEmployeeNumber(1256);
		
		System.out.println("\nProceed to enter details about employee named Adam ...");
		Adam.setEmployeeName("Adam");
		Adam.setEmployeeNumber(7342);
		
		System.out.println("\nProceed to enter details about employee named Sasha ...");
		Sasha.setEmployeeName("Sasha");
		Sasha.setEmployeeNumber(6897);
		
		System.out.println("\nProceed to enter details about employee named Miranda ...");
		Miranda.setEmployeeName("Miranda");
		Miranda.setEmployeeNumber(2543);
		
		System.out.println("\nProceed to enter details about employee named Selena ...");
		Selena.setEmployeeName("Selena");
		Selena.setEmployeeNumber(7435);
		
		System.out.println("\nProceed to enter details about employee named Lucia ...");
		Lucia.setEmployeeName("Lucia");
		Lucia.setEmployeeNumber(7561);
		
		System.out.println("\nProceed to enter details about employee named Esther ...");
		Esther.setEmployeeName("Esther");
		Esther.setEmployeeNumber(6102);
		
		System.out.println("\nProceed to enter details about employee named Amy ...");
		Amy.setEmployeeName("Amy");
		Amy.setEmployeeNumber(5948);
		
		System.out.println("\nProceed to enter details about employee named Penelope ...");
		Penelope.setEmployeeName("Penelope");
		Penelope.setEmployeeNumber(9979);
		
		
		//Read employee data once set methods have been activated
		System.out.println("\nJohn's employee number is the following:\n" +John.getEmployeeNumber());	
		System.out.println("\nWills's employee number is the following:\n" +Will.getEmployeeNumber());	
		System.out.println("\nPeter's employee number is the following:\n" +Peter.getEmployeeNumber());	
		System.out.println("\nMark's employee number is the following:\n" +Mark.getEmployeeNumber());	
		System.out.println("\nEdward's employee number is the following:\n" +Edward.getEmployeeNumber());	
		System.out.println("\nAlex's employee number is the following:\n" +Alex.getEmployeeNumber());	
		System.out.println("\nOswald's employee number is the following:\n" +Oswald.getEmployeeNumber());	
		System.out.println("\nJoe's employee number is the following:\n" +Joe.getEmployeeNumber());	
		System.out.println("\nAdam's employee number is the following:\n" +Adam.getEmployeeNumber());	
		System.out.println("\nSasha's employee number is the following:\n" +Sasha.getEmployeeNumber());	
		System.out.println("\nMiranda's employee number is the following:\n" +Miranda.getEmployeeNumber());	
		System.out.println("\nSelena's employee number is the following:\n" +Selena.getEmployeeNumber());	
		System.out.println("\nLucia's employee number is the following:\n" +Lucia.getEmployeeNumber());	
		System.out.println("\nEsther's employee number is the following:\n" +Esther.getEmployeeNumber());	
		System.out.println("\nAmy's employee number is the following:" +Amy.getEmployeeNumber());	
		//----------------------END OF EMPLOYEE INITIALIZATION----------------------
		
		//----------------------DEFAULT CONSTRUCTOR LOGIC---------------------------
		System.out.println("\n\n----------------------DEFAULT CONSTRUCTOR LOGIC---------------------------");
		System.out.println("Create a new employee collection named \"star employees\" by activating the default EmployeeSet constructor...");
		EmployeeSet StarEmployees = new EmployeeSet();
		
		System.out.println("\nThe number of elements in the array after activating the default constructor is: " + StarEmployees.size());
		
		System.out.println("\nThe capacity of the array after activating the default constructor is: " + StarEmployees.capacity());
		
		System.out.println("\nAdd employees John, Will, Peter, Mark and Edward to the \"StarEmployees\" collection");
		StarEmployees.add(John);
		StarEmployees.add(Will);
		StarEmployees.add(Peter);
		StarEmployees.add(Mark);
		StarEmployees.add(Edward);
		
		System.out.println("\nThe number of elements in thearray after adding John, Will, Peter, Mark and Edward has increased to: " + StarEmployees.size());
		
		for(int i = 0; i < StarEmployees.numOfEmployees; i++)
		{
			System.out.println("\nData of employee #" + (i + 1) + " [" + i + "]" + " stored in \"StarEmployees\" collection is: \n" + StarEmployees.employeeData[i]);			
		}
		
		System.out.println("\nAdd employee Penelope to the \"StarEmployees\" collection by using the addOrdered method\n");
		StarEmployees.addOrdered(Penelope);
		
        System.out.println("Employee list in ascending order after adding employee named Penelope is: \n");
        for(int i = 0; i < StarEmployees.numOfEmployees; i++)
        {
        	System.out.println("\nData of employee #" + (i + 1) + " [" + i + "]" + " stored in \"StarEmployees\" collection is: \n" + StarEmployees.employeeData[i]);	
        }
		
		System.out.println("\nProceed to remove the employee named John by this employee number");
		StarEmployees.remove(3140);
		
		for(int i = 0; i < StarEmployees.numOfEmployees; i++)
		{
			System.out.println("\nData of employee #" + (i + 1) + " stored in \"StarEmployeesWannabees\" collection is: \n" + StarEmployees.employeeData[i]);			
		}
		
		System.out.println("\nThe number of elements in the array after removing one employee is: " + StarEmployees.size());
		
		System.out.println("\nProceed to remove the employee named Mark with an incorrect employee number");
		StarEmployees.remove(2547);
		
		for(int i = 0; i < StarEmployees.numOfEmployees; i++)
		{
			System.out.println("\nData of employee #" + (i + 1) + " stored in \"StarEmployeesWannabees\" collection is: \n" + StarEmployees.employeeData[i]);			
		}
		
		System.out.println("\nThe number of elements in the array after attemtping to remove with an incorrect employee numberis: " + StarEmployees.size());
		

		//----------------------COPY CONSTRUCTOR LOGIC---------------------------
		System.out.println("\n\n----------------------COPY CONSTRUCTOR LOGIC---------------------------");
		System.out.println("Proceed to activate the copy constructor in order to create a copy of the \"StarEmployes\" collection...");
		EmployeeSet StarEmployeesWannabees = new EmployeeSet (StarEmployees);

		System.out.println("\nThe number of elements in the array after activating the copy constructor is: " + StarEmployeesWannabees.size());
		
		System.out.println("\nThe capacity of the array after activating the copy constructor is: " + StarEmployeesWannabees.capacity());
		
		for(int i = 0; i < StarEmployeesWannabees.numOfEmployees; i++)
		{
			System.out.println("\nData of employee #" + (i + 1) + " stored in \"StarEmployeesWannabees\" collection is: \n" + StarEmployeesWannabees.employeeData[i]);			
		}
		
		System.out.println("\nAdd employees Alex, Oswald, Joe, Adam, Sasha, Miranda, Selena, Lucia, Esther and Amy to the \"StarEmployeesWannabees\" collection");
		StarEmployeesWannabees.add(Alex);
		StarEmployeesWannabees.add(Oswald);
		StarEmployeesWannabees.add(Joe);
		StarEmployeesWannabees.add(Adam);
		StarEmployeesWannabees.add(Sasha);
		StarEmployeesWannabees.add(Miranda);
		StarEmployeesWannabees.add(Selena);
		StarEmployeesWannabees.add(Lucia);
		StarEmployeesWannabees.add(Esther);
		StarEmployeesWannabees.add(Amy);
		
		System.out.println("\nUsing the contains method when searching for employee Alex in EmployeeSet: " + StarEmployeesWannabees.contains(Alex));			

		System.out.println("\nUsing the contains method when searching for employee Amy in EmployeeSet: " + StarEmployeesWannabees.contains(Amy));			
		
		System.out.println("\nUsing the contains method when searching for employee John, who is no longer in the collection in EmployeeSet: " + StarEmployeesWannabees.contains(John));			
				
		System.out.println("\nThe number of elements in the array after adding these employees is: " + StarEmployeesWannabees.size());			

		//----------------------TEST CASES LOGIC---------------------------
		System.out.println("\n\n----------------------TEST CASES LOGIC---------------------------");
		EmployeeSet MyNullEmployeeSet = null;
		
		System.out.println("TEST CASE #1: Result of activating copy constructor method with a null employee...");
		MyNullEmployeeSet = new EmployeeSet(MyNullEmployeeSet);
		
		System.out.println("\nTEST CASE #2: Result of activating copy constructor method with a parameter that is not an EmployeeSet...");
		MyNullEmployeeSet = new EmployeeSet(Alex);
		
		System.out.println("\nTEST CASE #3: Create a null employee and try to add it to an EmployeeSet collection...");
		Employee Carson = null;
		StarEmployeesWannabees.add(Carson);
		
		System.out.println("\nTEST CASE #4: Try to add a null employee to an employeeSet collection by activating the addOrdered method...");
		StarEmployeesWannabees.addOrdered(Carson);

		System.out.println("\nTEST CASE #5: Use a null employee as parameter to the \"contains\" method. The result is: " +	StarEmployeesWannabees.contains(Carson));
		
		System.out.println("\nTEST CASE #6: Test the \"contains method\" returns TRUE when employee obj is in the EmployeeSet collection. The result is: " + StarEmployees.contains(John));
		
		System.out.println("\nTEST CASE #7: Test the \"contains method\" returns FALSE when employee obj is not in the EmployeeSet collection. The result is: " + StarEmployees.contains(Amy));
		
		System.out.println("\nTEST CASE #8: Test ensureCapacity method with a negative parameter. The result is...");
		StarEmployees.ensureCapacity(-1);
		
		System.out.println("\nTEST CASE #9: Test ensureCapacity method in order to add a bigger array.");
		StarEmployees.ensureCapacity(25);
		System.out.println("The capacity of the array after activating the \'ensure capacity method\" is: " + StarEmployees.capacity());
		
		System.out.println("\nTEST CASE #10: Result of activating the contain method with a null employee");
		StarEmployees.contains(Carson);
		
		System.out.println("\n\n----------------------READ EMPLOYEES FROM FILE---------------------------");
		System.out.println("\nTEST CASE #11: Read employee information from data file \"core_dataset.csv\" and add them to employee set");
		System.out.println("\nCreate a new employee collection named \"employeesFromFile\" by activating the default EmployeeSet constructor...");
		
		EmployeeSet employeesFromFile = new EmployeeSet();
		employeesFromFile.read("core_dataset.csv");
		
		System.out.println("\nThe number of elements in the array after reading elements from the file has increased to: " + employeesFromFile.size());
		
		for(int i = 0; i < employeesFromFile.numOfEmployees; i++)
		{
		System.out.println("EmployeesFromFile[" + i + "] name is: " + employeesFromFile.employeeData[i].getEmployeeName() + "\tEmployee number is: " + employeesFromFile.employeeData[i].getEmployeeNumber());	
		}
		
		System.out.println("\nProceed to remove the employee named Leruth Giovanni with an incorrect employee number is: " + employeesFromFile.remove(1412981660));
		System.out.println("\nProceed to remove the employee named Leruth Giovanni by this employee collection is: " + employeesFromFile.remove(1412071660));
		
	}

}
