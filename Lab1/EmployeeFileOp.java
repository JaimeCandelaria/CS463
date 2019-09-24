
import java.io.*;

//Employee class with attributes to be read and copied
class employee
{
	String EmployeeName;
	String EmployeeNumber;
	String State;
	String Zip;
	String Age;
	String Sex;
}

public class EmployeeFileOp 
{
	//create employeeInfo array in order to store employee's information
	private static employee[] employeeInfo = new employee[305];
	
	private static int headCount = 0;
	
	//Read information from a file
	public static void read(String fileName)
	{
		String line = "";
		
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
					employeeInfo[headCount] = new employee();
					employeeInfo[headCount].EmployeeName 	= lineString[0];
					employeeInfo[headCount].EmployeeNumber 	= lineString[1];
					employeeInfo[headCount].State 			= lineString[2];
					employeeInfo[headCount].Zip 			= lineString[3];
					employeeInfo[headCount].Age 			= lineString[5];
					employeeInfo[headCount].Sex 			= lineString[6];
					//System.out.println(lineString[0] + "\t" + lineString[1] + "\t" + lineString[2] + "\t" + lineString[3] + "\t" + lineString[5] + "\t" + lineString[6]);
				}
				else
				{
					employeeInfo[headCount] = new employee();
					employeeInfo[headCount].EmployeeName 	= lineString[0] + "" + lineString[1];
					employeeInfo[headCount].EmployeeNumber 	= lineString[2];
					employeeInfo[headCount].State 			= lineString[3];
					employeeInfo[headCount].Zip 			= lineString[4];
					employeeInfo[headCount].Age 			= lineString[6];
					employeeInfo[headCount].Sex 			= lineString[7];
					//System.out.println(employeeInfo[headCount].EmployeeName + "\t" + employeeInfo[headCount].EmployeeNumber + "\t" + employeeInfo[headCount].State + "\t" + employeeInfo[headCount].Zip  + "\t" + employeeInfo[headCount].Age  + "\t" + employeeInfo[headCount].Sex);
				}
				//Keep track of number of employees
				headCount++;
			}
			//System.out.println(headCount);
			
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
	
	public static void write(String fileName)
	{
		int employeeAge = 0;
		
		try 
		{
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
		
			bw.write(employeeInfo[0].EmployeeName + "," + employeeInfo[0].EmployeeNumber + "," + employeeInfo[0].State + "," + employeeInfo[0].Zip + "," + employeeInfo[0].Age + "," + employeeInfo[0].Sex + "\n"); 
			
			for(int i = 1; i < headCount; i++)
			{
				//Check if employee age is less thank 30. Call for an explicit cast from string to int
				if( Integer.parseInt(employeeInfo[i].Age) <= 30)
				{
					bw.write(employeeInfo[i].EmployeeName + "," + employeeInfo[i].EmployeeNumber + "," + employeeInfo[i].State + "," + employeeInfo[i].Zip + "," + employeeInfo[i].Age + "," + employeeInfo[i].Sex + "\n"); 
					//System.out.println(employeeInfo[i].EmployeeName + " Age is less than or equal to 30");
				}
			}
			bw.close();
			fw.close();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Finished writing data to " + fileName);
	}
	
	public static void main(String[] args) 
	{
		//Read function for csv file
		read("core_dataset.csv");
		
		//Write information to a csv file
		write("young_employee.csv");

	}

}
