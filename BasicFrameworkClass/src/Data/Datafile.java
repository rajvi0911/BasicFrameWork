package Data;

import utilities.Xls_Reader;

public class Datafile {
	
	Xls_Reader xls = new Xls_Reader("/Users/rajvi/Desktop/Testing/FrameWorkTest.xlsx");
	
	public String EmptyEmail="";
	public String EmptyPass="";
	public String SpcCharEmail=xls.getCellData("Data1", 1, 4);
	public String pass=xls.getCellData("Data1", 2, 2);
	public String wrongEmail=xls.getCellData("Data1",1,2);
	public String globalErr=xls.getCellData("Data1",5,2);
	public String passError = xls.getCellData("Data1",4,3);
	public String emailError = xls.getCellData("Data1",3,4) ;
	public String SpecialCharError = xls.getCellData("Data1",3,5);

}
