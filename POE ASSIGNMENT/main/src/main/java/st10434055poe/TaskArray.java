package st10434055poe;

import javax.swing.JOptionPane;

public class TaskArray {

   String Tname;
   String Tdescription;
   int Tduration;
   int Number;
   String DevName;
   String DevSurname;
   String ID;
   String Status;
   static int ArrayLength = 5;
   public static TaskArray[] TaskArr = new TaskArray[ArrayLength];
   public static int TaskCount = 0;

public TaskArray(String _Tname, String _Tdescription, int _Tduration, int _Number, String _DevName, String _DevSurname, String _ID, String _Status) {
        this.Tname = _Tname;
        this.Tdescription = _Tdescription;
        this.Tduration = _Tduration;
        this.Number = _Number;
        this.DevName = _DevName;
        this.DevSurname = _DevSurname;
        this.ID = _ID;
        this.Status = _Status;

   }

    public static void addNewTask(TaskArray Task) {
     TaskArr[TaskCount] = Task;
     TaskCount++;
 }

public static void printAdded() {

     JOptionPane.showMessageDialog(null, TaskArr[TaskCount-1].Tname +"\n"+ 
     TaskArr[TaskCount-1].Number +"\n"+ TaskArr[TaskCount-1].Tdescription+"\n"
     +TaskArr[TaskCount-1].DevName+"\n"+TaskArr[TaskCount-1].DevSurname+"\n"+ 
     TaskArr[TaskCount-1].Tduration +"\n"+ TaskArr[TaskCount-1].ID +"\n"+ TaskArr[TaskCount-1].Status);

}


public static String idMaker(String TaskName, String DevSurname, int Number) {
     int len = DevSurname.length();
     String N = TaskName.substring(0,2);
     String D = DevSurname.substring(len -3, len);
     return String.format("%s:%d:%s", N,Number,D);
}

public static int TotalHours(){
     int totalhours = 0 ;
     for (int i = 0; i < TaskArr.length; i++) {
          if (TaskArr[i]!=null) {
              totalhours = TaskArr[i].Tduration +totalhours;
          } 
     }
     return totalhours;
}


}
