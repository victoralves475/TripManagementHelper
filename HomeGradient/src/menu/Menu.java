/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author antoniovictoralvesdacosta
 */
public class Menu extends JComponent {

    /**
     * @return the event
     */
    public MenuEvent getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(MenuEvent event) {
        this.event = event;
    }
    
    private MigLayout layout;
    private MenuEvent event;
    
    private String[][] menuItems = new String[][]{
        {"Menu"},
        {"Criar Reserva"},
        {"Cancelar Reserva", "Individual", "Grupo"},
        {"Listar Reserva", "CPF", "Por nome"}
    };
    
    
    public Menu() {
        init();
        addMouseListener(new MouseAdapter() {
        
        @Override
            public void mouseEntered(MouseEvent e) {
                setOpaque(false); // torna o componente transparente
                repaint(); // repinta o componente para refletir a mudança
            }

        @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(true); // torna o componente opaco novamente
                repaint(); // repinta o componente
            }   
        });
    }
    
    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 0", "fill");
        setLayout(layout);
        setOpaque(true);

        // Init MenuItem
        
        for(int i = 0; i < menuItems.length; i++) {
           addMenu(menuItems[i][0], i); 
        }
        
    }
    
    private Icon getIcon(int index) {
        URL url = getClass().getResource("/img/"+ index + ".png");
        if (url != null) {
            return new ImageIcon(url);
        }
        else {
            return null;
        }
    }
    
    
    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName, index, length > 1);
        if (index != 0) {
            Icon icon = getIcon(index);
            if (icon != null) {
                item.setIcon(icon);
            }
        }
        
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (length > 1){
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    }
                    else {
                        // Hide Menu
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                } else {
                    if (event != null) {
                        event.selected(index, 0);
                    }
                }
            }
        });
        add(item);
        revalidate();
        repaint();
    }

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, gapy 0, inset 0", "fill"));
        panel.setName(index + "");
        panel.setOpaque(false);
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItems[index][i], i, false);
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (event != null) {
                        event.selected(index, subItem.getIndex());
                    }
                }
            }
            
            );
            subItem.initSubMenu(i, length);
            panel.add(subItem);
        }
        add(panel, "h 0!", indexZorder+1);
        revalidate();
        repaint();
        MenuAnimation.showMenu(panel, item, layout, true);
        
    }
    
    
    private void hideMenu(MenuItem item, int index) {
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                com.setName(null);
                MenuAnimation.showMenu(com, item, layout, false);
                break;
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
    super.paintComponent(grphcs); // mova esta chamada para o início
    Graphics2D g2 = (Graphics2D) grphcs.create();
    g2.setPaint(new GradientPaint(0, 0, new Color(51,102,255), 0, getHeight(), new Color(51,102,255)));
    g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
}

    
//    @Override
//    protected void paintComponent(Graphics grphcs) {
//        Graphics2D g2 = (Graphics2D) grphcs.create();
//        g2.setPaint(new GradientPaint(0, 0, new Color(156, 0, 255), 0, getHeight(), new Color(32, 0, 255)));
//        g2.fill(new Rectangle2D.Double( 0, 0, getWidth(), getHeight()));
//        super.paintComponent(grphcs);
//    }
    
}
