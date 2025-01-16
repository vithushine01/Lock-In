import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class TaskManagerTest {

    @Test
    void testAddTask() { // Tests if the addTask method adds a new task with a description and deadline
        // Arrange
        TaskManager taskManager = new TaskManager();
        String description = "Finish homework";
        String deadlineStr = "2025-01-20";

        // Act
        // Since in the code we have a try we have to add one here so it doesn't crash
        try {
            taskManager.addTask(description, deadlineStr);
        } catch (Exception e) {
            Assertions.fail("Exception was thrown: " + e.getMessage()); // if error a message will pop up
        }

        // Assert
        Assertions.assertEquals(1, taskManager.getTaskCount()); // Checks that there is 1 task
        Task task = taskManager.viewTasks().get(0); // Gets the first task in the list
        Assertions.assertEquals("Finish homework", task.getDescription()); // Checks the task description
        try {
            // Checks that the deadline matches the one that is expected
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expectedDeadline = sdf.parse(deadlineStr);
            Assertions.assertEquals(expectedDeadline, task.getDeadline());
        } catch (ParseException e) { // if there is an error a message will pop up
            Assertions.fail("ParseException was thrown: " + e.getMessage());
        }
    }

    @Test
    void testDisplayNextTaskInQueue() { // Tests if the displayNextTaskInQueue method returns the right task
        // Arrange
        // Two tasks are added, and the first one is marked as completed
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Math", "2025-01-18");
        taskManager.addTask("Science", "2025-01-19");
        taskManager.markTaskAsCompleted(1);

        // Act
        Task nextTask = taskManager.displayNextTaskInQueue(); 

        // Assert
        Assertions.assertNotNull(nextTask); // Checks that there is a task in the queue and that it is not just empty
        Assertions.assertEquals("Science", nextTask.getDescription()); // Checks the description of the next task and if its Science
    }

    @Test
    void testGetTaskCount() { // Tests if the getTaskCount method returns the number of tasks in the list
        // Arrange
        TaskManager taskManager = new TaskManager();

        // Act
        int startCount = taskManager.getTaskCount(); // Starting task count should be 0 
        taskManager.addTask("Homework", "2025-01-18");
        int updatedCount = taskManager.getTaskCount(); // Count should be 1 since a task was added

        // Assert
        Assertions.assertEquals(0, startCount); //  Checks that start count is 0
        Assertions.assertEquals(1, updatedCount); // Checks that updated count is 1
    }

    @Test
    void testMarkTaskAsCompleted() { // Tests if the markTaskAsCompleted works
        // Arrange
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Clean Window", "2025-01-18");

        // Act
        taskManager.markTaskAsCompleted(1);

        // Assert
        Task task = taskManager.viewTasks().get(0); // Gets the first task in the list
        Assertions.assertTrue(task.isCompleted()); // Checks if the task was marked as complete
    }

    @Test
    void testViewTasks() { // Tests if the viewTasks method returns all tasks
        // Arrange
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("Wash Clothes", "2025-01-18");
        taskManager.addTask("Fold Clothes", "");

        // Act
        List<Task> tasks = taskManager.viewTasks();

        // Assert
        Assertions.assertEquals(2, tasks.size()); // Checks that there are 2 tasks
        Assertions.assertEquals("Wash Clothes", tasks.get(0).getDescription()); // Checks the description of the first task
        Assertions.assertEquals("Fold Clothes", tasks.get(1).getDescription()); // Checks the description of the second task 
    }
}
