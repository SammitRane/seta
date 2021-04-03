import enc.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
 
class Seta extends JFrame
 {
  Container cn;
  JLabel l1,l2,l3,l4,l5,l6;
  JTextField t1,t2,t3,t4,t5,t6;
  JButton b1,b2,b3;
  Ccip c=new Ccip();
 
  String ct=" ",enck=" ",pct=" ";
  int count=0;
  int j=0,i=0;
  int w=0,wl=0;
  String tct=" ";
  String pt=" ";
  char c1,c2;
  String enct,key,pct1=" ";
  int x,start=0,end=0;
  
  HashMap ka1=new HashMap();  
  Seta()
  {
   cn=getContentPane();
   cn.setLayout(null);
   l1=new JLabel("Plain Text");
   l2=new JLabel("Cipher Text");
   l3=new JLabel("Encrypted key"); 
   l4=new JLabel("Cipher Text"); 
   l5=new JLabel("Encrypted key");
   l6=new JLabel("Plain Text");
   t1=new JTextField(20);
   t2=new JTextField(20);
   t3=new JTextField(20);  
   t4=new JTextField(20);
   t5=new JTextField(20);
   t6=new JTextField(20);
   b1=new JButton("ENCRYPT");
   b2=new JButton("DECRYPT");
   b3=new JButton("CLEAR ALL");
   l1.setBounds(70,50,80,30);
   t1.setBounds(200,50,200,30);   
   b1.setBounds(200,100,120,30);
   l2.setBounds(70,150,80,30);
   t4.setBounds(200,150,200,30);
   t4.setEditable(false);
   l3.setBounds(70,200,80,30);
   t5.setEditable(false);
   t5.setBounds(200,200,200,30);
   l4.setBounds(70,265,80,30);
   t2.setBounds(200,265,200,30);
   l5.setBounds(70,325,80,30);
   t3.setBounds(200,325,200,30);
   b2.setBounds(200,370,120,30);
   l6.setBounds(70,290,80,300);
   t6.setBounds(200,425,200,30);
   t6.setEditable(false);
   b3.setBounds(200,500,120,30);
   cn.add(l1);
   cn.add(t1);
   cn.add(b1);
   cn.add(l2);
   cn.add(l3);
   cn.add(t4);  
   cn.add(t5);
   cn.add(l4);
   cn.add(t2);
   cn.add(l5);
   cn.add(t3);
   cn.add(b2);
   cn.add(l6); 
   cn.add(t6);
   cn.add(b3);
   b1.addActionListener(new Enc());
   b2.addActionListener(new Dec());
   b3.addActionListener(new Clr());
   }
  public static void main(String args[])
  {
   Seta s=new Seta();
   s.setResizable(false);
   s.setSize(500,600);
   s.setLocation(50,0);
   s.setTitle("Secured Encryption and Transmission Algorithm (S.E.T.A)");
   s.setVisible(true);
   s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 class Enc implements ActionListener
 {
  public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b1)
   {
    pt=t1.getText();
    w=c.countWords(pt);
    String[] words = pt.split(" ");
    wl=words.length;
    int kas[]=new int[wl];
	for(i=0;i<wl;i++)
	{
	for(j=0;j<(words[i].length());j++)
	 { 
  	int tempk=c.keygen(words[i]);
  	kas[i]=tempk;  
  	tct=c.encrypt(words[i],tempk);
          }
  	//System.out.println(" "+tct);
        ct=ct.concat(" ").concat(tct);
	}
	/*for(int k=0;k<kas.length;k++)
	{
 	System.out.println(" "+kas[k]);
	}*/
	enck=c.keyen(kas);
        enck=enck.trim();
        ct=ct.trim();
        t5.setText("");
        t5.setText(enck);
        t4.setText("");
        t4.setText(ct); 
      }
   }
 }
   
class Dec implements ActionListener
  {
 
  public void actionPerformed(ActionEvent ae)
  {
   if(ae.getSource()==b2)
   {
      ka1.put('a',1);
      ka1.put('b',2);
      ka1.put('c',3);
      ka1.put('d',4);
      ka1.put('e',5);
      ka1.put('f',6);
      ka1.put('g',7);
      ka1.put('h',8);
      ka1.put('i',9);
      ka1.put('j',10);
      ka1.put('k',11);
      ka1.put('l',12);
      ka1.put('m',13);
      ka1.put('n',14);
      ka1.put('o',15);
      ka1.put('p',16);
      ka1.put('q',17); 
      ka1.put('r',18); 
      ka1.put('s',19);
      ka1.put('t',20);
      ka1.put('u',21);
      ka1.put('v',22);
      ka1.put('w',23);
      ka1.put('x',24);
      ka1.put('y',25);
      ka1.put('z',26); 

//System.out.println("\n Enter the encrypted text>>\n");
enct=t2.getText();
//System.out.println("\n Enter the key>>\n");
key=t3.getText();
String enctar[]=enct.split(" ");
/*for(x=0;x<enctar.length;x++)
System.out.println(" \t"+enctar[x]);*/
int keyar[]=new int[enctar.length];
c1=key.charAt(end);
x=(int)ka1.get(c1);
     for(int j=1;j<((enctar.length)+1);j++)
     {
     c2=key.charAt(j);
     //System.out.println(" \t"+c2);
     int k=Math.abs(x-((int)ka1.get(c2))+1);
     keyar[j-1]=k;   
}
/*System.out.println("\n The key array is>>\n");
for(x=0;x<keyar.length;x++)
{
 System.out.println(" \n"+keyar[x]);
}*/
for(x=0;x<keyar.length;x++)
{
String tpct=c.decrypt(enctar[x],keyar[x]);
pct=pct.concat(" ").concat(tpct);
}
//System.out.println("\n The plain text returned is>> "+pct);
t6.setText("");
pct=pct.trim();
 t6.setText(pct);
   }
  }
 }
class Clr implements ActionListener
{
 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==b3)
  {
   ct=" ";
   enck=" ";
   pct=" ";
   tct=" ";
   pt=" ";
   t6.setText("");
   t5.setText("");
   t4.setText("");
   t3.setText("");
   t2.setText("");
   t1.setText("");
   t1.requestFocus();
   }
  }
  }
         
}