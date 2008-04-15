package org.pentaho.ui.xul.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dom4j.Attribute;
import org.pentaho.ui.xul.swing.SwingXulRunner;


public final class XulUtil {
	
	public static Map <String, String> AttributesToMap(List <Attribute> attMap){
		
		Map <String, String> map = new HashMap <String, String>();
		for (int i = 0; i < attMap.size(); i++) {
			Attribute node = attMap.get(i);
			map.put(node.getName(), node.getValue());
		}
		return map;
		
	}
	

  public static List<org.pentaho.ui.xul.dom.Attribute> convertAttributes(List <Attribute> inList){
    List<org.pentaho.ui.xul.dom.Attribute>  outList = new ArrayList<org.pentaho.ui.xul.dom.Attribute>();
    
    for(Attribute attr : inList){
      outList.add(new org.pentaho.ui.xul.dom.Attribute(attr.getName(), attr.getValue()));
    }
    return outList;
  }
  
  public static InputStream getResourceFromClassPath(String file){
    
    //try to find localized resource
    InputStream in = XulUtil.class.getClassLoader().getResourceAsStream(XulUtil.formatResourceName(file));
    if(in == null){
      //revert to default
      in = XulUtil.class.getClassLoader().getResourceAsStream(String.format(file));
    }
    return in;
  }
  
  public static String formatResourceName(String name){
    return name.replace(".xul", "-"+Locale.getDefault().toString()+".xul");
    
  }

}
