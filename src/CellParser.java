import java.util.*;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class CellParser {
	SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
	private boolean isString(String input){
		return (Character.toString(input.charAt(0)).equals("\"") && Character.toString(input.charAt(input.length()-1)).equals("\"")); //check both start and end have "
	}
	private boolean isDouble(String input){
		  final String Digits     = "(\\p{Digit}+)";
		  final String HexDigits  = "(\\p{XDigit}+)";
		        // an exponent is 'e' or 'E' followed by an optionally 
		        // signed decimal integer.
		        final String Exp        = "[eE][+-]?"+Digits;
		        final String fpRegex    =
		            ("[\\x00-\\x20]*"+  // Optional leading "whitespace"
		             "[+-]?(" + // Optional sign character
		             "NaN|" +           // "NaN" string
		             "Infinity|" +      // "Infinity" string
		             // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		             "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

		             // . Digits ExponentPart_opt FloatTypeSuffix_opt
		             "(\\.("+Digits+")("+Exp+")?)|"+

		       // Hexadecimal strings
		       "((" +
		        // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		        "(0[xX]" + HexDigits + "(\\.)?)|" +

		        // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		        "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		        ")[pP][+-]?" + Digits + "))" +
		             "[fFdD]?))" +
		             "[\\x00-\\x20]*");// Optional trailing "whitespace"
		  return (Pattern.matches(fpRegex, input));
	}
	private boolean isDate(String input){
		try {
	        formatter.parse(input);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	public  Cell parseCell(String input) throws Exception{
		if(isString(input))
			return new StringCell(input);
		else if (isDouble(input)) //integer or decimal
				return new DoubleCell(Double.valueOf(input));
		else if (isDate(input))
			return new DateCell(formatter.parse(input));
		else throw new Exception("not yet implemented") ;
	}
}
