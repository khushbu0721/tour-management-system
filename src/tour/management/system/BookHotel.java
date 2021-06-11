


package tour.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
public class BookHotel extends JFrame {
    
    Choice c1,c2,c3;
    JTextField t1,t2;
    JLabel l12,l18,l19,l110, l111;
    JButton b1,b2,b3;
    public BookHotel(String username){
        
        getContentPane().setBackground(Color.white);
        setBounds(550, 240, 1100, 600);
        setLayout(null);
        
        
          ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("tour/management/system/icons/book.jpg"));
                Image i3 = i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l123 = new JLabel(i2);
                l123.setBounds(500,50,600,400);
                add(l123);
        
        JLabel l1 = new JLabel("BOOK HOTEL");
	l1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
	l1.setBounds(100, 0, 300, 30);
	add(l1);
        
        
       JLabel l2 = new JLabel("Username :");
	l2.setBounds(20, 70, 200, 30);
	add(l2);
                
       JLabel l12 = new JLabel();
	l12.setBounds(250, 70, 150, 30);
	add(l12);
        
         JLabel l3 = new JLabel("Select Hotel:");
	l3.setBounds(20, 110, 200, 30);
	add(l3);
        
        c1 = new Choice();
        try{
          Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
                    while(rs.next()){
                        c1.add(rs.getString("name"));
                    }
            
        }catch(Exception e){
            
        }
   
	c1.setBounds(250, 110, 150, 30);
        add(c1);
        
        JLabel l4 = new JLabel("Total Persons:");
	l4.setBounds(20, 150, 100, 30);
	add(l4);
        
        t1 = new JTextField();
        t1.setBounds(250, 150, 150, 30);
        add(t1);
        
        JLabel l5 = new JLabel("No Of Days:");
	l5.setBounds(20, 190, 100, 30);
	add(l5);
        
        t2 = new JTextField();
        t2.setBounds(250, 190, 150, 30);
        add(t2);
        
         JLabel l6 = new JLabel("Ac/ Non-Ac:");
	l6.setBounds(20, 230, 200, 30);
	add(l6);
        
        c2 = new Choice();
        c2.add(" Yes");
        c2.add(" No");
	c2.setBounds(250, 230, 150, 30);
        add(c2);
        
        JLabel l7 = new JLabel("Food Included:");
	l7.setBounds(20, 270, 200, 30);
	add(l7);
        
        c3 = new Choice();
        c3.add(" Yes");
        c3.add(" No");
	c3.setBounds(250, 270, 150, 30);
        add(c3);
        
        
         
       JLabel l8 = new JLabel("ID:");
	l8.setBounds(20, 310, 200, 30);
	add(l8);
                
        l18 = new JLabel();
	l18.setBounds(250, 310, 150, 30);
	add(l18);
        
         
       JLabel l9 = new JLabel(" Number:");
	l9.setBounds(20, 350, 200, 30);
	add(l9);
                
       l19 = new JLabel();
	l19.setBounds(250, 350, 150, 30);
	add(l19);
        
        JLabel l10 = new JLabel(" Phone:");
	l10.setBounds(20, 390, 200, 30);
	add(l10);
                
       l110 = new JLabel();
	l110.setBounds(250, 390, 150, 30);
	add(l110);
        
         JLabel l11 = new JLabel(" Total Price:");
	l11.setBounds(20, 430, 200, 30);
	add(l11);
                
       l111= new JLabel();
	 l111.setBounds(250, 430, 150, 30);
         l111.setForeground(Color.red);
	add( l111);
        
     
        
         try{
             Conn c = new Conn();

                    ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
                    while(rs.next()){
                          l12.setText(rs.getString("username"));
                        l18.setText(rs.getString("id"));
                        l19.setText(rs.getString("number"));
                        l110.setText(rs.getString("phone"));
                      
                        
                    }

                    rs.close();
                }catch(SQLException e){}
                
                b1 = new JButton("Check Price");
		b1.setBounds(50, 470, 120, 30);
                b1.setBackground(Color.BLACK);
                b1.setForeground(Color.WHITE);
                b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                            try{
	    			 
                                
                                String q1 = "select * from hotel where name = '"+c1.getSelectedItem()+"'";
                                ResultSet rs = c.s.executeQuery(q1);
                                if(rs.next()){
                                    
                                    int cost = Integer.parseInt(rs.getString("cost_per_day"));
                                    int food = Integer.parseInt(rs.getString("food_charges"));
                                    int ac = Integer.parseInt(rs.getString("ac_charges"));
                                    
                                    int persons = Integer.parseInt(t1.getText());
                                    int days = Integer.parseInt(t2.getText());
                                    
                                    String acprice = c2.getSelectedItem();
                                    String foodprice = c3.getSelectedItem();
                                    
                                    
                                    if(persons * days > 0) {
                                        int total = 0;
                                        total += acprice.equals("AC") ? ac : 1;
                                        total += foodprice.equals("Yes") ? food : 1;
                                        total += cost;
                                        total = total * persons * days;
                                        l111.setText("Rs "+total);
                                    }
                                    else{
                                        l111.setText("Please Enter Valid Number");
                                    }
                                    
                                }
                                
	    		}catch(Exception ee){
	    			System.out.println(ee.getMessage());
	    		}
                        }
		});
		add(b1);
		

		b2= new JButton("Book");
		b2.setBounds(200, 470, 120, 30);
               b2.setBackground(Color.BLACK);
               b2.setForeground(Color.WHITE);
               b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			
                                
                                String q1 = "insert into bookHotel values('"+l12.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+t2.getText()+"', '"+c2.getSelectedItem()+"', '"+c3.getSelectedItem()+"', '"+l18.getText()+"', '"+l19.getText()+"', '"+l110.getText()+"', '"+l111.getText()+"')";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                                setVisible(false);
                            }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                            }
                            
			}
		});
	       add(b2);
		
		b3 = new JButton("Back");
	        b3.setBounds(350, 470, 120, 30);
                b3.setBackground(Color.BLACK);
                b3.setForeground(Color.WHITE);
                b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		add(b3);
        
    }
    public static void main(String[] args){
        new BookHotel(" ").setVisible(true);
    }
    
}
