package AlgoExpert.Easy;
import java.util.*;
public class CaesarCipherEncrypter {
	public static String caesarCypherEncryptor(String str, int key) {
		key%=26;
		String strNew="";
	    for(int i=0;i<str.length();i++) {
	    	int asciiVal=str.charAt(i);
	    	asciiVal+=key;
	    	if(asciiVal>122) {
	    		asciiVal-=26;
	    	}
	    	strNew+=(char)asciiVal;
	    }
	    
	    return strNew;
	  }

}
