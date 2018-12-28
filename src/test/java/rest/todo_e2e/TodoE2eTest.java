package rest.todo_e2e;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import rest.TestConfiguration;

import static junit.framework.TestCase.assertTrue;
import static rest.todo_e2e.assertions.TodoAssertions.*;
import static rest.todo_e2e.clients.TodoClients.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TodoE2eTest extends TestConfiguration {

    private static final int ID = 1;
    private static final int USER_ID = 1;
    private static final String TITLE = "go to work";
    private static final String UPDATED_TITLE = "go on vacation";


    @AfterClass

    public static void cleanUp() {

        deleteTodo();

        assert todoHasBeenDeleted();

    }

    @Test
    public void shouldTestTodoLifeCycle() {

        //when
        createTodo(TITLE, false, USER_ID);

        //then
        userTodoExists(TITLE, false, USER_ID);


    }


    @Test
    public void shouldUpdateATodo() {

        //given
        userTodoExists(TITLE, false, USER_ID);

        //then
        updateTodo(ID, TITLE, true, USER_ID);

        assertTrue(todoHasBeenUpdated(ID, TITLE, true, USER_ID));

    }

    @Test
    public void shouldModifyAPartOfTodo() {

        //given
        userTodoExists(TITLE, false, USER_ID);

        //then
        modifyTodo(UPDATED_TITLE);

        assertTrue(todoHasBeenModified(UPDATED_TITLE));

    }


}

