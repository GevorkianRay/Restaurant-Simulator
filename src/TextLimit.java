
import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.NavigationFilter.FilterBypass;
import javax.swing.text.PlainDocument;
/**
 * Sets a limit on the amount of text one can input in the UI.
 * Attributions to Aaron Lee for explaining how helpful setting a text field limit can be.
 * Attributions to: http://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
 *
 */
public class TextLimit extends PlainDocument 
{
  private int max;
  
  TextLimit(int max) {
   super();
   this.max = max;
   }

  public void insertString( int offset, String  str, javax.swing.text.AttributeSet attr ) throws BadLocationException {
    if (str == null) return;
    if ((getLength() + str.length()) <= max) {
    	super.insertString(offset, str, attr);
    }
  }
}
