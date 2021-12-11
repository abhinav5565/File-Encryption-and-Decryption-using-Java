import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*; 
import java.sql.*;
import javax.swing.filechooser.*;
class main implements ActionListener
{
JFrame f;
JButton b,b1,b2,b3;
JTextField t;
JFileChooser fc;
main()
{
f=new JFrame("Crypt files");
f.setSize(400,400);
f.setResizable(false);
f.setLocation(700,300);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLayout(null);
t=new JTextField("Choose file");
b=new JButton("Encrypt");
b1=new JButton("Decrypt");
b2=new JButton("Logout");
b3=new JButton("...");
b.setBounds(50,300,90,30);
b1.setBounds(250,300,90,30);
b2.setBounds(150,300,90,30);
t.setBounds(50,50,250,30);
b3.setBounds(310,50,50,28);
f.add(b);
f.add(b1);
f.add(b2);
f.add(t);
f.add(b3);
f.setVisible(true);
b.addActionListener(this);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b.setBackground(Color.black);
b.setForeground(Color.white);
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b2.setBackground(Color.black);
b2.setForeground(Color.white);
b3.setBackground(Color.black);
b3.setForeground(Color.white);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b)
{
 File file=fc.getSelectedFile();    
        String s=file.getPath(); 
String type="";
String name=file.getName();
 if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0)
        type=name.substring(name.lastIndexOf(".")+1);
        else
       type= "";  
JFrame f1=new JFrame("Enet Key"); 
Integer code=new Integer(JOptionPane.showInputDialog(f1,"Enter the secret pin to continue ","Secret code needed",JOptionPane.WARNING_MESSAGE));
try
{
File f=new File(file.getParent()+"\\"+"aa1."+type);
OutputStream out=new FileOutputStream(f);
InputStream inp=new FileInputStream(file);
int i=inp.read();
while(i!=-1)
{
out.write((char)i-code);
i=inp.read();
}
inp.close();
out.close();
File f2=file;
file.delete();
f.renameTo(f2);
}
catch(Exception e)
{
System.out.println(e);
}
}
if(ae.getSource()==b1)
{
File file=fc.getSelectedFile();    
String s=file.getPath(); 
String dir=file.getParent();
String type="";
String name=file.getName();
 if(name.lastIndexOf(".") != -1 && name.lastIndexOf(".") != 0)
        type=name.substring(name.lastIndexOf(".")+1);
        else
       type= "";   
    
try
{
File f=new File(file.getParent()+"\\"+"aa."+type);
OutputStream out=new FileOutputStream(f);
InputStream inp=new FileInputStream(file);
int i=inp.read();
JFrame f1=new JFrame("Enet Key"); 
Integer code=new Integer(JOptionPane.showInputDialog(f1,"Enter the secret pin to continue ","Secret code needed",JOptionPane.WARNING_MESSAGE));
while(i!=-1)
{
out.write((char)i+code);
i=inp.read();
}
inp.close();
out.close();
File f2=file;
file.delete();
file.delete();
f.renameTo(f2);

}
catch(Exception e)
{
System.out.println(e);
}
}

if(ae.getSource()==b3)
{
fc=new JFileChooser(FileSystemView.getFileSystemView());    
int i=  fc.showSaveDialog(null); 
  if(i==JFileChooser.APPROVE_OPTION)
    {    
        File file=fc.getSelectedFile();    
        String s=file.getPath();    
      t.setText(s);           
    }    
}

if(ae.getSource()==b2)
{
login lo=new login();
f.setVisible(false);
}

}
public static void main(String[] arg)
{
	main m= new main();
}}