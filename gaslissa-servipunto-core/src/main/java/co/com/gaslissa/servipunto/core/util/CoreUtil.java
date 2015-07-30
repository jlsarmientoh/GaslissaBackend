package co.com.gaslissa.servipunto.core.util;

import java.util.ArrayList;
import java.util.List;

public class CoreUtil {
	
	public static List<Integer> getIslas(int isla, String[] gruposIsla){
		List<Integer> islas = new ArrayList<Integer>(); 
        String[] grupo = gruposIsla[isla -1].split(",");
		
        for(String islaItem : grupo){
        	islas.add(Integer.decode(islaItem));
        }
        
        return islas;
	}

}
