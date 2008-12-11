package org.pentaho.ui.xul.swing;

import org.pentaho.ui.xul.XulContainer;
import org.pentaho.ui.xul.util.Align;

public abstract class AbstractSwingContainer extends SwingElement implements XulContainer{

  protected Align alignment;
  
  public AbstractSwingContainer(String tagName){
    super(tagName);
  }

  public Align getAlign() {
    return alignment;
  }

  public void setAlign(String align) {
    try{
      this.alignment = Align.valueOf(align.toUpperCase());
    } catch(Exception e){
      System.out.println("could not parse ["+align+"] as Align value");
      
    }
  }
  
  
  
  
}

  