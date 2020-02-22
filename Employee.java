
import java.text.DecimalFormat;
public class Employee{
   DecimalFormat DF = new DecimalFormat("0.00");

   private int EmpNo;
   private String EmpLast;
   private String EmpFirst;
   private char EmpMi;
   private char EmpStatus;
   private char EmptStatus;
   private int hrs;
   private double Tax;
   private double Rate;
   private double GP;
   private double OT;
   private double BP;
   private double SSS;
   private double PH;
   private double PI;
   private double NP;
   private double TD;
   
   
   public Employee(int EmpNo, String EmpLast, String EmpFirst, char EmpMi, char EmpStatus, char EmptStatus, int hrs)
   {
      this.EmpNo = EmpNo;
      this.EmpLast = EmpLast;
      this.EmpFirst = EmpFirst;
      this.EmpMi = EmpMi;
      this.EmpStatus = EmpStatus;
      this.EmptStatus = EmptStatus;
      this.hrs = hrs;
   }
   public Employee()
   {
      
   }
   
   //Setters
   public void setEmpno(int EmpNo)
   {
   if(EmpNo < 0)
   {
      this.EmpNo = 0;
   }
   else
   {
      this.EmpNo = EmpNo;
   }
   }
   
   public void setEmplast(String EmpLast)
   {
    while(true)
    {
      boolean check = true;
      this.EmpLast = EmpLast;
      for(int i = 0 ; i < EmpLast.length(); i++)
      {
         if(Character.isDigit(EmpLast.charAt(i)))
         {
            check = false;
         }
      }
         if(check)
         {
         break;
         }
    }

   }
   
   public void setEmpfirst(String EmpFirst)
   {
     while(true)
    {
      boolean check = true;
      this.EmpFirst = EmpFirst;
      for(int i = 0 ; i < EmpFirst.length(); i++)
      {
         if(Character.isDigit(EmpFirst.charAt(i)))
         {
            check = false;
         }
      }
         if(check)
         {
         break;
         }
    }
         
   }
   
   public void setEmpmi(char EmpMi)
   {
         this.EmpMi= EmpMi;
   }
   
   public void setEmpstatus(char EmpStatus)
   {
   if (EmpStatus != 'S' &&
       EmpStatus != 'M' &&
       EmpStatus != 'W' &&
       EmpStatus != 'R')
       {
         this.EmpStatus = ' ';
       }
   else
      {
         this.EmpStatus = EmpStatus;
      }
   }
        
   public void setEmptstatus(char EmptStatus)
   {
   if(EmptStatus != 'R' &&
      EmptStatus != 'P' &&
      EmptStatus != 'C' &&
      EmptStatus != 'T')
      {
         this.EmptStatus = ' ';
      }
   else      
      {
        this.EmptStatus = EmptStatus;
      }
      
   }
      
   public void setEmpHrs(int hrs)
   {
   if(hrs<0)
   {
      this.hrs = 0;
   }
   else
   {
      this.hrs = hrs;
   }
   }
         


//getters

 public int getEmpno()
 {
   return EmpNo;
 }
 
  public String getEmplast()
 {
   return EmpLast;
 }
 
  public String getEmpfirst()
 {
   return EmpFirst;
 }
 
  public char getEmpmi()
 {
   return EmpMi;
 }
 
  public char getEmpstatus()
 {
   return EmpStatus;
 }
 
  public char getEmptstatus()
 {
   return EmpStatus;
 }
 
  public int getEmpHrs()
 {
   return hrs;
 }
 
 public double GrossPay()
   {
      GP = BP + OT;
      return GP;
   } 
   
 public double StatusTax()
      {
      
      switch(EmpStatus)
      {
         case 'S':
         Tax = GP * .1575;
         break;
         
         case 'M':
         Tax = GP * .1012;
         break;
         
         case 'W':       
         Tax = GP * .1235;
         break;
         
          case 'R':        
         Tax = GP * .1260;
         break;
         
         default:
         Tax = 0;
         break;
         
      }
      return Tax;
   }

 public double StatusRate()
   {     
      
      switch(EmptStatus)
      {
         case 'R':
         Rate = 590.88;
         break;
         
         case 'C':
         Rate = 488.56;
         break;
         
         case 'T':
         Rate = 525.38;
         break;
         
         case 'P':
         Rate = 415.10;
         break;
         
         default:
         Rate = 0;
         break;
         
      }
      return Rate;
   }

 

 public double OverTime()
   { 
         if(hrs > 120)
         {
            OT = (hrs-120)*((Rate/8) * 1.5);
         }
         else
         {
          OT = 0;
         }
      return OT;
   }
   
   public double BasicPay()
   {
      if(hrs >= 120)
      {
         BP = (120 / 8) * Rate;
      }
      else
      {
         BP = (hrs / 8) * Rate;
      }
      return BP;
   }   

   public double getSSS()
   {
      if(GP >= 12000)
      {
         SSS = GP * .115;
      }
      else if(GP < 12000 && GP >=9500)
      {
         SSS = GP * .105;
      }
      else
      {
         SSS = GP * .0916;
      }
      return SSS;
   }
   
   public double PhilHealth()
   {
      if(GP >= 12000)
      {
         PH = 420;
      }
      else if(GP < 12000 && GP >=9500)
      {
         PH = 290;
      }
      else if(GP < 9500)
      {
         PH = 380;
      }
      return PH;
   }
   
   public double PagIbig()
   {
      switch(EmpStatus)
      {
         case 'S':
         PI = GP * .0275;
         break;
         
         case 'M':
         PI = GP * .0375;
         break;
         
         case 'W':
         PI = GP * .0255;
         break;
         
         case 'R':
         PI = GP * .0255;
         break;

         
         default:
         PI = 0;
         break;
         
      }
      return PI;
   }
   
   public double Net()
   {
      NP = GP - TD;
      return NP;
   }
   public double TD()
   {
      TD = Tax + SSS + PH + PI;
      return TD;
   }
 

  //to String
 public String toString()
 {
 return  "\nEmployee Number:"+EmpNo+"\n"+"Employee Lastname: "+EmpLast+"\n"+"Employee Firstname: "+EmpFirst+"\n"
 +"Employee Middle Initial: "+EmpMi+"\n"+"Employee Status: "+EmpStatus+"\n"+"Employment Status: "+EmptStatus+"\n"
 +"Hours Work: "+hrs+"\n"+"Basic Pay: "+DF.format(BP)+"\n"+"OverTime Pay: "+DF.format(OT) +"\n"+"Gross Pay: "+
 DF.format(GP)+"\n"+"Rate: "+DF.format(Rate)+"\n"+"Tax: "+DF.format(Tax)+"\n"+"SSS deduction: "+DF.format(SSS)+"\n"
 +"PhilHealth deduction: "+DF.format(PH)+"\n"+"Pag-Ibig deduction: "+DF.format(PI)+"\n"+"Total Deduction: "+
 DF.format(TD)+"\n"+"Net Earnings: "+DF.format(NP)+"\n\n";
 }
     
}  