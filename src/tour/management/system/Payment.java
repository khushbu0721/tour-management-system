
package tour.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Prity
 */
public class Payment extends JFrame implements  ActionListener{
    
     JButton b1,b2 ;
     
    public Payment(){
        
        setLayout(null);
        setBounds(650, 240, 800, 600);
        getContentPane().setBackground(Color.white);
        
      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tour/management/system/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0, 800, 600);
        add(l1);
        
         b1 = new JButton("Pay");
         b1.setBounds(420,0, 80, 40);
            b1.addActionListener(this);
       l1.add(b1);
        
        
         b2 = new JButton("Back");
         b2.setBounds(520,0, 80, 40);
         b2.addActionListener(this);
        l1.add(b2);
        
        
          JLabel label=new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);
        
        
        
        
}
    public void actionPerformed(ActionEvent ae) {
               
        if(ae.getSource()==b1){
          
       this.setVisible(false);
     
       new Paytm().setVisible(true);
       
        }else if(ae.getSource()==b2){
          
      this.setVisible(false);
            
        }
            }
    
    
     public static void main(String[] args){
        new Payment().setVisible(true);
    }
}
