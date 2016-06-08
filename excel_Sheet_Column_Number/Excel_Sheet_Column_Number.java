package excel_Sheet_Column_Number;

public class Excel_Sheet_Column_Number {
	
	public static int titleToNumber(String s) {
		
		if(!s.matches("[a-zA-Z]+"))	return 0;
		
		int columnNumber = 0;
		char[] a = s.toUpperCase().toCharArray();
		for (int i = 0; i < a.length; i++) {
			columnNumber += ((int) a[i] - 64) * (int) Math.pow(26, a.length - i - 1);
		}
		return columnNumber;
    }
	
	public static void main(String[] args) {
		System.out.println("'C' has colume number: " + titleToNumber("C"));
		System.out.println("'AB' has colume number: " + titleToNumber("AB"));
		System.out.println("'CD' has colume number: " + titleToNumber("CD"));
		System.out.println("'FH' has colume number: " + titleToNumber("FH"));
		System.out.println("'aa' has colume number: " + titleToNumber("aa"));
		System.out.println((int)'a');
	}

}
