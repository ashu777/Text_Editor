import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class note extends JFrame implements ActionListener
{
	int n=5;int c=0,k=5;
    MenuBar mbar,mbar1;
    Menu file,edit,format,font,font1,font2,color,about;
    MenuItem item1,item2,item3,item4,color1,color2,color3,about1;
    MenuItem item5,item6,item7,item8,item9,item10;
    MenuItem fname1,fname2,fname3,fname4;
    MenuItem fstyle1,fstyle2,fstyle3,fstyle4;
    MenuItem fsize1,fsize2,fsize3,fsize4;
    //JPanel pan=new JPanel();
    JTextArea text=new JTextArea();
    JScrollPane sup=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    Font f;
    //JButton but=new JButton("exit");
    String months[]={
        "Jan","Feb","Mar","Apr",
        "May","Jun","Jul","Aug",
        "Sep","Oct","Nov","Dec"};
    GregorianCalendar  gcalendar;
    
    String command=" ";
    String str=" ";

    String str1=" ",str2=" ",str3=" ";
    String str4=" ";

    String str6=" ";
    String str7=" ",str8=" ",str9=" ";

    int len1;

    int i=0;
    int pos1;
    int len;

    public note(String str)
    {
    super(str);
   // System.out.print(c);
    //JPanel mainpanel = new JPanel();
    //mainpanel=(JPanel)getContentPane();
    //mainpanel.setLayout(new FlowLayout());
    mbar=new MenuBar();
    //mbar1=new MenuBar();
    
    //setMenuBar(mbar1);
    setMenuBar(mbar);
    //mbar.add(but);
    file=new Menu("File");
    edit=new Menu("Edit");
    format=new Menu("Format");
    font=new Menu("Font");
    font1=new Menu("Font Style");
    font2=new Menu("Size");
    color=new Menu("Color");
    about=new Menu("About");
    file.add(item1=new MenuItem("New..."));
    file.add(item2=new MenuItem("Open"));
    file.add(item3=new MenuItem("Save As..."));
    file.add(item4=new MenuItem("Exit"));
    mbar.add(file);

    edit.add(item5=new MenuItem("Cut"));
    edit.add(item6=new MenuItem("Copy"));
    edit.add(item7=new MenuItem("Paste"));
    edit.add(item8=new MenuItem("Delete"));
    edit.add(item10=new MenuItem("Select All"));
    edit.add(item9=new MenuItem("Time/Date"));
    mbar.add(edit);

    format.add(font);
    format.add(font1);
    format.add(font2);

    font.add(fname1=new MenuItem("Courier"));
    font.add(fname2=new MenuItem("Sans Serif"));
    font.add(fname3=new MenuItem("Monospaced"));
    font.add(fname4=new MenuItem("Times New Roman"));

    font1.add(fstyle1=new MenuItem("Regular"));
    font1.add(fstyle2=new MenuItem("Bold"));
    font1.add(fstyle3=new MenuItem("Italic"));
    font1.add(fstyle4=new MenuItem("Bold Italic"));

    font2.add(fsize1=new MenuItem("12"));
    font2.add(fsize2=new MenuItem("15"));
    font2.add(fsize3=new MenuItem("20"));
    font2.add(fsize4=new MenuItem("30"));

    mbar.add(format);
    color.add(color1=new MenuItem("Red"));
    color.add(color2=new MenuItem("Blue"));
    color.add(color3=new MenuItem("Green"));
    mbar.add(color);
    about.add(about1=new MenuItem("About Us!"));
    mbar.add(about);


    item1.addActionListener(this);
    item2.addActionListener(this);
    item3.addActionListener(this);
    item4.addActionListener(this);
    item5.addActionListener(this);
    item6.addActionListener(this);
    item7.addActionListener(this);
    item8.addActionListener(this);
    item9.addActionListener(this);
    item10.addActionListener(this);
    fname1.addActionListener(this);
    fname2.addActionListener(this);
    fname3.addActionListener(this);
    fname4.addActionListener(this);
    fstyle1.addActionListener(this);
    fstyle2.addActionListener(this);
    fstyle3.addActionListener(this);
    fstyle4.addActionListener(this);
    fsize1.addActionListener(this);
    fsize2.addActionListener(this);
    fsize3.addActionListener(this);
    fsize4.addActionListener(this);
    color1.addActionListener(this);
    color2.addActionListener(this);
    color3.addActionListener(this);
    about1.addActionListener(this);

    
    // add(text);
    sup.setBounds(400,400, 10,20);
    add(sup);
    f=new Font("Monotype Corsiva",Font.PLAIN,25);
    text.setFont(f);
    text.setSelectedTextColor(Color.RED);
    }




    public void actionPerformed(ActionEvent ae)
    {


        command=(String)ae.getActionCommand();

        if(command.equals("New..."))
        {
        	Object[] options = {"Save",
                    "Don't Save",};
        	n = JOptionPane.showOptionDialog(null,
    "Do you want to save changes",
    "Text Editor",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
     //System.out.print(n);
		if(n==1)
       {
		dispose();
        note note1 = new note("Untitled-notepad1");
        note1.setSize(500,500);
        note1.setVisible(true);
       }
		else
		{
			command="Save As...";
		}
        }

        try
        {

        if(command.equals("Open"))
        {

        str4=" ";
        FileDialog dialog=new FileDialog(this,"Open");
        dialog.setVisible(true);

        str1=dialog.getDirectory();
        str2=dialog.getFile();
        str3=str1+str2;
        File f=new File(str3);
        FileInputStream fobj=new FileInputStream(f);
        len=(int)f.length();
        for(int j=0;j<len;j++)
        {
            char str5=(char)fobj.read();
            str4=str4+str5;

        }

        text.setText(str4);

        }
        }
        catch(IOException e)
        {}
        if(command.equals("Exit"))
        {
        	Object[] options = {"Save",
                    "Don't Save",};
        	n = JOptionPane.showOptionDialog(null,
    "Do you want to save changes",
    "Text Editor",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
        	if(n==1)
        System.exit(0);
        	else
        	{
        		command="Save As...";
        		k=1;
        	}
        }

        try
        {

        if(command.equals("Save As..."))
        {
        FileDialog dialog1=new FileDialog(this,"Save As",FileDialog.SAVE);
        dialog1.setVisible(true);

        str7=dialog1.getDirectory();
        str8=dialog1.getFile();
        str9=str7+str8;


        str6=text.getText();
        len1=str6.length();
        byte buf[]=str6.getBytes();

        File f1=new File(str9);
        FileOutputStream fobj1=new FileOutputStream(f1);
        for(int k=0;k<len1;k++)
        {
        fobj1.write(buf[k]);
        }
        fobj1.close();
        if(n==0)
        {
 		dispose();
         note note1 = new note("Untitled-notepad1");
         note1.setSize(500,500);
         note1.setVisible(true);
         n=5;
        }
        if(k==1)
        {
        	System.exit(0);
        }
        }

        this.setTitle(str8);

        }
        catch(IOException e){}



        

        if(command.equals("Cut"))
        {
        str=text.getSelectedText();
        i=text.getText().indexOf(str);
       // System.out.print(i);
        text.replaceRange("",i,i+str.length());
        }

        if(command.equals("Copy"))
        {
        str=text.getSelectedText();
        }

        if(command.equals("Paste"))
        {
        pos1=text.getCaretPosition();
        text.insert(str,pos1);
        }
        if(command.equals("Delete"))
        {
        String msg=text.getSelectedText();
        i=text.getText().indexOf(msg);
        text.replaceRange("",i,i+msg.length());
        }
        if(command.equals("Time/Date"))
        {
        gcalendar=new GregorianCalendar();
        String h=String.valueOf(gcalendar.get(Calendar.HOUR));
        String m=String.valueOf(gcalendar.get(Calendar.MINUTE));
        String s=String.valueOf(gcalendar.get(Calendar.SECOND));
        String date=String.valueOf(gcalendar.get(Calendar.DATE));
        String mon=months[gcalendar.get(Calendar.MONTH)];
        String year=String.valueOf(gcalendar.get(Calendar.YEAR));
        String hms="Time"+" - "+h+":"+m+":"+s+"  Date"+"-"+date+""+mon+""+year;
        int loc=text.getCaretPosition();
        text.insert(hms,loc);
        }
        if(command.equals("Courier"))
        {
        	//setText("sup");
        	//String sup=text.getSelectedText();
        	//text.getSelectedText().
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();
        f=new Font("Courier",fontStyle,fontSize);
        text.setFont(f);
        }
        if(command.equals("Sans Serif"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font("Sans Serif",fontStyle,fontSize);
        text.setFont(f);
        }
        if(command.equals("Monospaced"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font("Monospaced",fontStyle,fontSize);
        text.setFont(f);
        }

        if(command.equals("Times New Roman"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font("Times New Roman",fontStyle,fontSize);
        text.setFont(f);
        //System.out.println(f.getFamily());
        }
        if(command.equals("Regular"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font(fontName,Font.PLAIN,fontSize);
        text.setFont(f);
        }
        if(command.equals("Bold"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();
        
        f=new Font(fontName,Font.BOLD,fontSize);
        text.setFont(f);
        }
        if(command.equals("Italic"))
        {
        	
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font(fontName,Font.ITALIC,fontSize);
        text.setFont(f);
        }
        if(command.equals("Bold Italic"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();
        f=new Font(fontName,Font.BOLD|Font.ITALIC,fontSize);
        text.setFont(f);
        }

        if(command.equals("12"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font(fontName,fontStyle,12);
        text.setFont(f);
        }

        if(command.equals("15"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font(fontName,fontStyle,15);
        text.setFont(f);
        }
        if(command.equals("20"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font(fontName,fontStyle,20);
        text.setFont(f);
        }
        if(command.equals("30"))
        {
        String fontName=f.getName();
        String fontFamily=f.getFamily();
        int fontSize=f.getSize();
        int fontStyle=f.getStyle();

        f=new Font(fontName,fontStyle,30);
        text.setFont(f);
        }
        if(command.equals("Select All"))
        {
        String strText=text.getText();
        int strLen=strText.length();
        text.select(0,strLen);
        }
        if(command.equals("Red"))
        {
        	c=1;
        	text.setForeground(Color.RED);
        }
        if(command.equals("Blue"))
        {
        	c=2;
        	text.setForeground(Color.BLUE);
        }
        if(command.equals("Green"))
        {
        	c=3;
        	text.setForeground(Color.GREEN);
        }
       if(command.equals("About Us!"))
        {
        	
        	JOptionPane jp=new JOptionPane();
        	jp.showMessageDialog(null,"This is a Java Project created by us for our Endsem Java Project Evaluation "+ " Our Details : SATYAM AGRAWAAL > BE/10072/16 "+ " ASHUTOSH KESHRI > BE/10047/16");
        }


    }



    public static void main(String args[])
    {
    note note = new note("Untitled-notepad");
    note.setSize(500,500);
    note.setVisible(true);
    }
}
