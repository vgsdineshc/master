package Firstproject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LockersPvtLtd {
	
	FileOutputStream fileOutputStream;
	FileInputStream fileInputStream;
	Scanner scanner = new Scanner(System.in);	
	String fileName;
	String path = "D:\\Temp\\";
	
	
	public static boolean isNumeric(String string) {
	    String regex = "[0-9]+[\\.]?[0-9]*";
	    return Pattern.matches(regex, string); 
	}
	
	public void addFile() throws IOException
	{
		System.out.println("Please enter the File name to Create");
		fileName = scanner.next();
		File fi = new File(path+fileName);
		if(fi.exists())
		{
			System.out.println("File Already Found Please try another filename");
		}
		else
		{
			fi.createNewFile();
			System.out.println("File Added Successfully");
		}
		selectBusinessOperation();
	}
	
	public void searchFile() throws IOException
	{
		System.out.println("Please enter the File name to Search");
		fileName = scanner.next();
		File file = new File(path);
		int flag=0;
		for(File file2 : file.listFiles())
		{
			String fileNames = file2+"";
			String[] ss = fileNames.split("\\\\");
			if(fileName.equals(ss[ss.length-1]))
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			System.out.println(fileName+" File Found!! in this path "+path);
		}
		else 
		{
			System.out.println("File Not Found");
		}	
		selectBusinessOperation();
	}
	
	//To List All Files
	public void listAllFile()
	{
		File file = new File(path);
		ArrayList<String> arrayList = new ArrayList<String>();
		for(File file2 : file.listFiles())
		{
			String fileNames = file2+"";
			String[] ss = fileNames.split("\\\\");
			arrayList.add(ss[ss.length-1]);
		}	
		Collections.sort(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
		System.out.println(arrayList.get(i));	
		}
	}
	
	//To Delete the File
	public void deleteFile() throws IOException
	{
		System.out.println("Please enter the File name to Delete");
		fileName = scanner.next();
		File fi = new File(path+fileName);
		if(fi.exists())
		{
			fi.delete();
			System.out.println("File Deleted Successfully");
		}
		else
		{
			System.out.println("File Not Exsist to Delete");
		}
		selectBusinessOperation();
	}
	
	//To Close the Application
	public void closeApplication() throws IOException
	{
		System.out.println("Closed the Application");
		System.exit(0);
	}
	
	//This is the Business Operation Menu
	public void selectBusinessOperation() throws IOException
	{
		System.out.println("Enter 1 Option to add a user specified file to the application");
		System.out.println("Enter 2 Option to search a user specified file from the application");
		System.out.println("Enter 3 Option to delete a user specified file from the application");
		System.out.println("Enter 4 option to close the current execution context and return to the main context");
		String getvalue = scanner.next();
		if(isNumeric(getvalue))
		{
			int option = Integer.parseInt(getvalue);
			switch (option) {
			case 1:
				addFile();
				break;
			case 2:
				searchFile();
				break;
			case 3:
				deleteFile();
				break;
			case 4:
				FileFeatures();
				break;

			default:
				System.out.println("Select the Correct Option");
				selectBusinessOperation();
				break;
			}	
		}
		else
		{
			System.out.println("Please Enter the Numeric Value");
			selectBusinessOperation();
		}
		
	}
	
	//This is FileFeature Main Menu
	public void FileFeatures() throws IOException
	{
		System.out.println("Enter 1 to Retrieving the file names in an ascending order");
		System.out.println("Enter 2 to perform Business-level operations");
		System.out.println("Enter 3 Option to close the application");
		String getvalue = scanner.next();
		if(isNumeric(getvalue))
		{
			int option = Integer.parseInt(getvalue);
			switch (option) {
			case 1:
				listAllFile();
				break;
			case 2:
				selectBusinessOperation();
				break;
			case 3:
				closeApplication();
				break;
			default:
				System.out.println("Select the Correct Option");
				break;
			}	
		}
		else
		{
			System.out.println("Please Enter the Numeric Value");
		}
		
	}
	
	
	
	//Single Parameter Constructor to execute main Menu
	LockersPvtLtd(boolean b) throws IOException
	{
		//Checking Folder Exist or not. If not folder will be created
		File file = new File(path);
		if(file.mkdir())
		{
			
		}
		LockersPvtLtd lockersPvtLtd = new LockersPvtLtd();
		while (b) {
			lockersPvtLtd.FileFeatures();
		}
	}
	LockersPvtLtd()
	{
		
	}
	
public static void main(String[] args) throws IOException {
	
	System.out.println("----Project Name : File Lockers Pvt Ltd----");
	System.out.println("----Developed By : Dinesh Chandrasekar-----");
	System.out.println();
	
	//Main Menu Execution
	LockersPvtLtd lockersPvtLtd = new LockersPvtLtd(true);
}
}
