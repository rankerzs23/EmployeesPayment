import java.util.Scanner;
public class Test{
   public static void main(String[]args){
      Scanner sc = new Scanner(System.in);

      System.out.print("Size of employees? ");
      int size = sc.nextInt();
      Employee EmpArray[] = new Employee[size];
      int EmpNo[] = new int[size];
      String EmpLast[] = new String[size];
      String EmpFirst[] = new String[size];
      char EmpMi[] = new char[size];
      char EmpStatus[] = new char[size];
      char EmptStatus[] = new char[size];
      int hrs[] = new int[size];
      int Menu;
      int tempInt;
      String tempString;
      char tempChar;
      int tempInt2;
      do{
      System.out.print("\nMenu\n1. Create\n2. View\n3. Sort\n4. Search\n5. Delete\n6. Quit\n\n");
      System.out.print("Input Menu: ");
      Menu = sc.nextInt();
      
      if(Menu==1){
      for(int i=0;i<EmpArray.length;i++){
      if(i==0){
         System.out.print("Input "+(i+1)+" Employee ID number");
         }
      else{
      System.out.print("Input "+(i+1)+" Employee ID number");
      }
      EmpNo[i]=-1;
      while(EmpNo[i]<0){
         System.out.print("\nEmployee Number: ");
         EmpNo[i] = sc.nextInt();
      }
      sc = new Scanner(System.in);
      
      System.out.print("Employee Lastname: ");
      EmpLast[i] = sc.nextLine();
      System.out.print("Employee Firstname: ");
      EmpFirst[i] = sc.nextLine();
      System.out.print("Employee Middle Initial: ");
      EmpMi[i] = sc.nextLine().charAt(0);
      EmpStatus[i] = '\0';
      
      while(      
                  EmpStatus[i] != 'S' &&
                  EmpStatus[i] != 'M' &&
                  EmpStatus[i] != 'W' &&
                  EmpStatus[i] != 'R' 
           )
      {
     System.out.print("Select Employee Status: ");
     System.out.println("Single(S), Married(M), Widow(W), Widower(R)");
     EmpStatus[i] = sc.nextLine().charAt(0);
     EmpStatus[i] = Character.toUpperCase(EmpStatus[i]);
      }
      EmptStatus[i] = '\0';
      while(      
                  EmptStatus[i] != 'R' &&
                  EmptStatus[i] != 'P' &&
                  EmptStatus[i] != 'C' &&
                  EmptStatus[i] != 'T'
           )
      {
         System.out.print("Select Emploment Status: ");
         System.out.println("Regular(R), Probationary(P), Casual(C), PartTimer(T)");
         EmptStatus[i] = sc.nextLine().charAt(0);
         EmptStatus[i] = Character.toUpperCase(EmptStatus[i]);
      }
      hrs[i]=-1;
      while(hrs[i]<0){
         System.out.print("Hours Worked: ");
         hrs[i] = sc.nextInt();
      }
      }
      }
      else if(Menu==2){
      for(int i=0;i<EmpArray.length;i++){
      EmpArray[i].StatusRate();
      EmpArray[i].OverTime();
      EmpArray[i].BasicPay();
      EmpArray[i].GrossPay();
      EmpArray[i].StatusTax();
      EmpArray[i].getSSS();
      EmpArray[i].PhilHealth();
      EmpArray[i].PagIbig();
      EmpArray[i].TD();
      EmpArray[i].Net();
      }
      for(int ctr=0;ctr<EmpArray.length;ctr++){
         if(ctr==0){
            System.out.print("Input "+(ctr+1)+" Employee ID Number");
            System.out.print(EmpArray[ctr]);
         }
         else{
            System.out.print("Input "+(ctr+1)+" Employee ID Number");
            System.out.print(EmpArray[ctr]);
         }
      }
      }
      else if(Menu==3){
      for(int i=0;i<EmpArray.length;i++){
         for(int ctr=i+1;ctr<EmpArray.length;ctr++){
         if(EmpNo[i]>EmpNo[ctr]){
            tempInt = EmpNo[i];
            EmpNo[i] = EmpNo[ctr];
            EmpNo[ctr] = tempInt;
            
            tempString = EmpLast[i];
            EmpLast[i] = EmpLast[ctr];
            EmpLast[ctr] = tempString;
            
            tempString = EmpFirst[i];
            EmpFirst[i] = EmpFirst[ctr];
            EmpFirst[ctr] = tempString;
            
            tempChar = EmpMi[i];
            EmpMi[i] = EmpMi[ctr];
            EmpMi[ctr] = tempChar;
            
            tempChar = EmpStatus[i];
            EmpStatus[i] = EmpStatus[ctr];
            EmpStatus[ctr] = tempChar;
            
            tempChar = EmptStatus[i];
            EmptStatus[i] = EmptStatus[ctr];
            EmptStatus[ctr] = tempChar;
            
            tempInt2 = hrs[i];
            hrs[i] = hrs[ctr];
            hrs[ctr] = tempInt2;
         }
         }
      }
      for(int i=0;i<EmpArray.length;i++){
          EmpArray[i] = new Employee(EmpNo[i],EmpLast[i],EmpFirst[i],EmpMi[i],EmpStatus[i],EmptStatus[i],hrs[i]);
          EmpArray[i].StatusRate();
          EmpArray[i].OverTime();
          EmpArray[i].BasicPay();
          EmpArray[i].GrossPay();
          EmpArray[i].StatusTax();
          EmpArray[i].getSSS();
          EmpArray[i].PhilHealth();
          EmpArray[i].PagIbig();
          EmpArray[i].TD();
          EmpArray[i].Net();
      }
      for(int ctr=0;ctr<EmpArray.length;ctr++){
         if(ctr==0){
            System.out.print("Input "+(ctr+1)+" Employee ID Number");
            System.out.print(EmpArray[ctr]);
         }
         else{
            System.out.print("Input "+(ctr+1)+" Employee ID Number");
            System.out.print(EmpArray[ctr]);
          }
      }
      }
      else if(Menu==4){
         System.out.print("Enter an employee number you want to search: ");
         int Search = sc.nextInt();
         boolean check=false;
         for(int j=0;j<EmpArray.length;j++){
            if(Search==EmpNo[j]){
               check = true;
               break;
            }
        }
        if(check){
            System.out.print("It is in the array\n");
        }
        else{
            System.out.print("It is not in the array\n");
        }
      }
      }while(Menu>0&&Menu<6);
   }
}