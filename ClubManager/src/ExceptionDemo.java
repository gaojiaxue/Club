import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;



public class ExceptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//file
		//two pieces of data(int)(manual)
		//file of filereader
		//scanner
		//read data
		//sum
		//print result on console
		
		//a=b+c;1.positive 
		try {
			Scanner scan= new Scanner(new FileReader("C:\\siily.txt"));
			int sum=0;
			while(scan.hasNextInt())
			{int t=scan.nextInt();
			sum+=t;}System.out.println(sum);
			
			scan.close();
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

}
