
package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author antoniovictoralvesdacosta
 */
public class MenuItem extends JButton{
    
    private int index;
    private boolean subMenuAble;
    //  Submenu
    private int subMenuIndex;
    private int length;

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the subMenuAble
     */
    public boolean isSubMenuAble() {
        return subMenuAble;
    }

    /**
     * @param subMenuAble the subMenuAble to set
     */
    public void setSubMenuAble(boolean subMenuAble) {
        this.subMenuAble = subMenuAble;
    }

    /**
     * @return the subMenuIndex
     */
    public int getSubMenuIndex() {
        return subMenuIndex;
    }

    /**
     * @param subMenuIndex the subMenuIndex to set
     */
    public void setSubMenuIndex(int subMenuIndex) {
        this.subMenuIndex = subMenuIndex;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }
    
   
    public MenuItem(String name, int index, boolean subMenuAble) {
        super(name);
        this.index = index;
        this.subMenuAble = subMenuAble;
        setContentAreaFilled(false);
        setForeground(new Color(0,0,0));
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(9, 10, 9, 10));
        setIconTextGap(10);
        
    }
    
    
    public void initSubMenu( int subMenuIndex, int length) {
        this.subMenuIndex = subMenuIndex;
        this.length = length;
        setBorder(new EmptyBorder(9, 33, 9, 10));
        setBackground(new Color(244, 244, 244));
        setOpaque(true);
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D)grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (length != 0) {
            g2.setColor(new Color(0, 0, 0));
            if (subMenuIndex == 1) {
                g2.drawLine(18, 0, 18, getHeight());
                g2.drawLine(18, getHeight()/2, 26, getHeight()/2);
            } else if (subMenuIndex == length -1) {
                g2.drawLine(18, 0, 18, getHeight()/2);
                g2.drawLine(18, getHeight()/2, 26, getHeight()/2); 
            } else {
                g2.drawLine(18, 0, 18, getHeight());
                g2.drawLine(18, getHeight()/2, 26, getHeight()/2);
            }
            
        }    
        g2.dispose();
    }
        
}
