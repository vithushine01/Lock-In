import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskTest {

    @Test
    void testGetDeadline() throws ParseException { // throws ParseException is a quick fix
        // Arrange
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expectedDeadline = sdf.parse("2025-01-20");
            Task task = new Task("Complete assignment", expectedDeadline);

            // Act
            Date actualDeadline = task.getDeadline();

            // Assert
            // Verify that the deadline matches the expected date
            Assertions.assertEquals(expectedDeadline, actualDeadline);
        
    }

    @Test
    void testIsCompleted() {
        // Arrange
        Task task = new Task("Finish project", null); // Task that is initially not completed

        // Act
        boolean actualCompletionStatus = task.isCompleted(); // Checks the starting status of the task

        // Assert
        // Checks that the task is not completed by default the user has to put it into the system
        Assertions.assertFalse(actualCompletionStatus, "New tasks should not be completed");
    }

    @Test
    void testMarkAsCompleted() {
        // Arrange
        Task task = new Task("Prepare for meeting", null);

        // Act
        task.markAsCompleted();
        boolean actualCompletionStatus = task.isCompleted();

        // Assert
        Assertions.assertTrue(actualCompletionStatus, "Task marked as complete");
    }

    @Test
    void testToString() throws ParseException { // quick fixed
        // Arrange
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date expectedDeadline = sdf.parse("2025-01-25");
            Task task = new Task("Read book for english", expectedDeadline);

            // Act
            String actualString = task.toString();

            // Assert
            // Checks that the string representation includes the correct status, description, and deadline
            String expectedString = "Not Completed - Read book for english (Deadline: 2025-01-25)";
            Assertions.assertEquals(expectedString, actualString);
        
    }
}
