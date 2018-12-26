package rest.todo_e2e;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import rest.TestConfiguration;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static rest.todo_e2e.assertions.TodoAssertions.*;
import static rest.todo_e2e.clients.TodoClients.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TodoE2eTest extends TestConfiguration {

    private static final int ID = 1;
    private static final int USER_ID = 1;
    private static final String TITLE = "go to work";
    private static final String UPDATED_TITLE = "go on vacation";
    private static boolean UPDATED_COMPLETED_STATUS = false;
    private static boolean COMPLETED_STATUS = true;




    @AfterClass

    public static void cleanUp(){

        deleteTodo();
        //assertFalse(userTodoExists(TITLE, COMPLETED_STATUS, USER_ID));
    }

    @Test
    public void shouldTestTodoLifeCycle(){

        //when
        createTodo(TITLE, COMPLETED_STATUS, USER_ID);

        //then
        userTodoExists(TITLE, COMPLETED_STATUS, USER_ID);


    }


    @Test
    public void shouldUpdateATodo(){

        //given
        userTodoExists(TITLE, COMPLETED_STATUS, USER_ID);

        //then
        updateTodo(ID, TITLE, UPDATED_COMPLETED_STATUS, USER_ID);

        assertTrue(todoHasBeenUpdated(ID, TITLE, UPDATED_COMPLETED_STATUS, USER_ID));

    }

    @Test
    public void shouldModifyAPartOfTodo(){

        //given
        userTodoExists(TITLE, COMPLETED_STATUS, USER_ID);

        //then
        modifyTodo(UPDATED_TITLE);

        assertTrue(todoHasBeenModified(UPDATED_TITLE));

    }


}

