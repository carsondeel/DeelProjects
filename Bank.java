import java.io.*;

import java.util.Random;

class Bank
{
 static String name,typeacc,phone;

 static int accno,bal,amt,with,autho,pin;

 static void accept()throws Exception
 {

    BufferedReader ip
    = new BufferedReader(new InputStreamReader(System.in));

 try
 {

  System.out.print("Enter Full Name :");

  name=ip.readLine(); 

  System.out.print("Enter Contact Number (10 digits) :");

  phone=ip.readLine();

  Random r=new Random();

  System.out.print("Type of account :");

  typeacc=ip.readLine();

  System.out.print("Enter Balance :");

  bal=Integer.parseInt(ip.readLine());  

  accno=r.nextInt(1000);
	
  System.out.println("\n\tAccount Created Successfully!");
  System.out.println("\n\t###################### NOTE ######################");
	
  System.out.println("\n\tYour unique account number :"+accno);

  pin=r.nextInt(100);

  System.out.println("\n\tSystem generated Personal Identification Number (PIN):"+pin);

  System.out.println("\n\t###################### *** ######################");

 }//tryend

catch(Exception ex){}

}//catchend

 static void deposit()throws Exception
 {
  DataInputStream ip=new DataInputStream(System.in);

  System.out.print("\nEnter the amount you wish to Deposite :");

  amt=Integer.parseInt(ip.readLine());

  bal=bal+amt;

  System.out.println("Revised Balance (post deposit) :"+bal);

 }

static void withdraw()throws Exception
 {
  DataInputStream ip=new DataInputStream(System.in);

  int lpp=0;

  reent:

  while(lpp==0)

  {

  System.out.print("\nEnter the amount you wish to Withdraw :");

  with=Integer.parseInt(ip.readLine());

  if(with>=bal-100)

  {

   System.out.println("\tERROR !");

   System.out.println("Cannot withdraw ! Entered Amount exceeds Minimun balance.");

   System.out.println("\nPlease Re-enter !");

   continue reent;

  }
  else
  {
   bal=bal-with;

   System.out.println("Revised Balance (post withdrawal) :"+bal);  

   lpp=1;
  }
 }
}

 static void display()
 {
   //DataInputStream ip=new DataInputStream(System.in);

   System.out.println("\n\tAccount holders details :\n");

   System.out.println("Name :"+name);
 
   System.out.println("Phone number :+91"+phone);

   System.out.println("Account number:"+accno);

   System.out.println("Account type :"+typeacc);

   System.out.println("Balance :"+bal);
 }

 static void forgotpass()throws Exception
 {
     DataInputStream ip=new DataInputStream(System.in);
     int cnt=0;
     System.out.println("\n\tForgot PIN ?");
     System.out.println("Authentication process");
     System.out.println("\nStep 1");
     System.out.print("\nEnter your Unique account Number :");
     int pinacc=Integer.parseInt(ip.BufferedReader.readLine());
     
     if(pinacc==accno)
     {
      System.out.println("\nStep 2");
      System.out.print("\nYour registered Mobile Number :");
      System.out.print("####");
      for(int j=4;j<10;j++)
      {
       System.out.print(phone.charAt(j));
      }
      System.out.print("\nEnter the FIRST 4 digits of your registered phone number :");
      String pinphone=ip.readLine();
      for(int jk=0;jk<4;jk++)
      { 
       if(pinphone.charAt(jk)==phone.charAt(jk))
      {
       cnt++; 
      }
      }
      if(cnt==4)
      {
       System.out.println("\nUser Authentication Successful");
       System.out.println("The PIN for your account is :"+pin);
      }
      else
      {
       //System.out.println(cnt);
       System.out.println("\nYour phone number DOES NOT MATCH");
      }
     }
     else
     {
      System.out.println("\nINVALID ACCOUNT NUMBER");
     }    
}

static void changeaccname()throws Exception
{
 DataInputStream ip=new DataInputStream(System.in);

     int namevar=0;

      namechange:

      while(namevar==0)
      {
      System.out.println("\nChange account name !\n");
      System.out.print("Enter new account name :");
      String fstattempt=ip.readLine();
      System.out.print("Re-Enter account name  :");
      String sndattempt=ip.readLine();

       if (fstattempt.equals(sndattempt))
       {
        namevar=1;
        name=fstattempt;
        System.out.println("\nAccount name changed Succesfully !");
      
       }
     
       else
       {
         System.out.println("\nStrings Mismatch\n");
         System.out.println("Re-enter correct strings to continue !\n");  
         continue namechange;
       } 
     }
}

//************************************************************************************************************************//

 public static void main(String args[])throws Exception
 {
  DataInputStream ip=new DataInputStream(System.in);

  int ch,inch;

  System.out.println("\n\t\f Welcome to DEEL bank pvt.ltd \f\n ");

  System.out.println("New customer ?\t\tAlready have an account ?");

  System.out.println("Press 1 to SIGN-UP\tPress 2 to SIGN-IN  ");

  System.out.print("\n\t    You would like to ?  :");

  inch=Integer.parseInt(ip.readLine());

  switch(inch)

  {

   case 1:

   System.out.println("\nTo create a new account fill in the follwing details:");

   accept();

   System.out.println("\nAccount created succesfully !");

   case 2:

   int inside=0;

   relog:

   while(inside==0) //lable while
   {
   System.out.println("\n\tEnter Login details");

   System.out.print("\nEnter account number :");

   autho=Integer.parseInt(ip.readLine());

   System.out.print("\nEnter PIN :");

   int authopin=Integer.parseInt(ip.readLine());

  if(autho==9999 && authopin==6666)
  {
    System.out.println("\n\tWelcome ADMIN : Carson Deel A.K.A");
    break;
  }

  else if(autho==accno && pin==authopin)
  {
    System.out.println("\n\tAccess Granted !\n");

  do
  {

  inside=1;

  System.out.println("\nSelect any of the following Options");

  System.out.println("\n1.Deposit");

  System.out.println("2.Withdraw");

  System.out.println("3.Display account Details");

  System.out.println("4.Settings");

  System.out.println("5.Exit");

  System.out.print("Enter your choice :");

  ch=Integer.parseInt(ip.readLine());

 switch(ch)
 {
     case 1:

     deposit();

     break;

     case 2:

     withdraw();

     break;

     case 3:

     display();
     
     break;

    case 4:
    int editopt;
    do
    {
    System.out.println("\n\n\tEdit your bank Details :\n");
    System.out.print("1.Change Account name ?");
    System.out.println("\t\t2.Forgot PIN ?");
    System.out.print("\n3.Need assistance ?");
    System.out.println("\t\t4.Back to the previous menu ?");
    System.out.print("\n\tEnter corresponding option :");
    editopt=Integer.parseInt(ip.readLine());
     
    switch(editopt)
    {
     case 1:
     changeaccname();
     break;     
       
     case 2:
     forgotpass();
     break;

     case 3:
     System.out.println("\nOur customer care executive will call you shortly on the following number :+91"+phone);
     break;

     case 4:
     inside=0;
     continue relog;

     default:
     System.out.println("Wrong option");
     break;
    } 
   }while(editopt!=4);

     break;

      case 5:

      System.out.println("\nThank you for Banking with us !");

      System.out.println("Deel Bank Pvt.Ltd");

      break;

     default:

     System.out.println("Wrong choice");

     break;
  
  }  //switch

 }while(ch!=5);

}

else if(autho==accno && pin!=authopin)

{

  System.out.println("You've entered the wrong PIN");

  System.out.println("Please Re-enter\n");

  continue relog;

}

else if(autho!=accno && pin==authopin)

{

  System.out.println("You've entered the wrong Account Number");

  System.out.println("Please Re-enter\n");

  continue relog;

}

else

{

  System.out.print("\n\tAccess Denied !");
  System.out.println("\tINVALID Inputs !");
  inside=1;

}

}//while for label
 break;
}//outer switch//


}

}
