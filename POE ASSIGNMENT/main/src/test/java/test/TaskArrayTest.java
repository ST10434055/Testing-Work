package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import st10434055poe.AddingTask;
import st10434055poe.TaskArray;

class TaskTest {
    @Test
    void checkTaskDescriptionfail() {
        String taskdescription = "task description is above 50 characters";
        boolean description = AddingTask.DescriptionCheck(taskdescription);
        assertFalse(description);
    }

    @Test
    void checkTaskDescriptionpass() {
        String taskdescription = "task description is below or equal to 50 characters";
        boolean description = AddingTask.DescriptionCheck(taskdescription);
        assertTrue(description);
    }

    @Test
    void checkTaskId() {
        String taskId = TaskArray.idMaker("add", "Robyn Harrison", TaskArray.TaskCount +1 );
        assertEquals(taskId, "AD:1:BYN");
        System.out.println(taskId + " = " + "AD:1:BYN");
    }

    @Test
    void TotalHoursCurrent() {
        TaskArray[] tasks ={
                new TaskArray("Login Feature","Create Login to authenticate users ", TaskArray.TaskCount+1,8,"Robyn","Harrison",TaskArray.idMaker("Robyn Harrison","Login Feature"
                        ,TaskArray.TaskCount), "To Do"),
                new TaskArray("Add Task Feature","Create Add Task feature to add task users ", TaskArray.TaskCount+2,10,"Mike","Smith",TaskArray.idMaker("Mike Smith","Add task Feature",
                        TaskArray.TaskCount+1), "Doing ")
        };
        TaskArray.TaskArr[0] = tasks[0];
        TaskArray.TaskArr[1] = tasks[1];
        int total = TaskArray.TotalHours();
        assertEquals(total,18);

    }
    @Test
    void TotalHours() {
        TaskArray[] tasks = {
                new TaskArray(" "," ", 1, 10," "," "," ", "To Do"),
                new TaskArray(" "," ", 2, 12," "," "," ", "Doing"),
                new TaskArray(" "," ", 3, 55," "," "," ", "Doing"),
                new TaskArray(" "," ", 4, 11," "," "," ", "Doing"),
                new TaskArray(" "," ", 5, 1," "," "," ", "Doing"),

        };

        TaskArray.TaskArr[0] = tasks[0];
        TaskArray.TaskArr[1] = tasks[1];
        TaskArray.TaskArr[2] = tasks[2];
        TaskArray.TaskArr[3] = tasks[3];
        TaskArray.TaskArr[4] = tasks[4];
        int total = TaskArray.TotalHours();
        assertEquals(total,89);

    }

    @Test
    public void testTotalDurationWithNonNullTasks() {
        // Creates an array of tasks with known durations
        TaskArray[] tasks = new TaskArray[3];
        tasks[0] = new TaskArray("Task 1"," ", 1, 10, " ", "Developer 1", "ID1", "Doing");
        tasks[1] = new TaskArray("Task 2"," ", 2, 20, " ", "Developer 2", "ID2", "Done");
        tasks[2] = new TaskArray("Task 3"," ", 3, 30, " ", "Developer 3", "ID3", "To Do");

        // Sets the TaskArr in task class to the array of tasks
        TaskArray.TaskArr = tasks;

        // Call the totalDuration method
        int total = TaskArray.TotalHours();

        // Verify that the total duration is calculated correctly
        assertEquals(60, total); // Total should be 10 + 20 + 30 = 60
    }

    @Test
    public void testTotalDurationWithNullTasks() {
        // Set the taskArr in Task class to an array with null elements
        TaskArray.TaskArr = new TaskArray[3];

        // Call the totalDuration method
        int total = TaskArray.TotalHours();

        // Verify that the total duration is 0 when taskArr has null elements
        assertEquals(0, total); // Total should be 0
    }
}








