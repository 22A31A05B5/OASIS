import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[4];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<4;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,200,20);  
        jb[1].setBounds(50,110,200,20);  
        jb[2].setBounds(50,140,200,20);  
        jb[3].setBounds(50,170,200,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==5)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==5)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[0].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: What is the output of the following Java code snippet?\nint x = 5;\nSystem.out.println(++x);");  
            jb[0].setText("5");jb[1].setText("6");jb[2].setText("7");jb[3].setText("Compilation Error");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: What is the correct way to declare a constant variable in Java?");  
            jb[0].setText("const int MAX_VALUE = 100;");jb[1].setText("final int MAX_VALUE = 100;");jb[2].setText("static int MAX_VALUE = 100;");jb[3].setText("static final int MAX_VALUE = 100;");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which data structure in Java provides a last-in, first-out (LIFO) mechanism?");  
            jb[0].setText("Queue");jb[1].setText("ArrayList");jb[2].setText("Stack");jb[3].setText("LinkedList");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: What is the purpose of the 'break' statement in Java?");  
            jb[0].setText("To end the execution of a loop or switch statement");jb[1].setText("To skip the rest of the code block and continue with the next iteration of the loop");jb[2].setText("To exit the entire program");jb[3].setText("To define the exit condition for a recursive function");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which of the following statements is true about interfaces in Java?");  
            jb[0].setText("An interface can have method implementations.");jb[1].setText("An interface can extend multiple other interfaces.");jb[2].setText("An interface can be instantiated with the 'new' keyword.");jb[3].setText("An interface can have constructors.");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<80;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test");  
    }  
}  
