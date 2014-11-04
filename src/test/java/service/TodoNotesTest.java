package service;

import dao.TodoDao;
import model.DBNote;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoNotesTest {

    @InjectMocks
    private TodoNotes todoNotes;

    @Mock
    private TodoDao todoDaoMock;

    @Mock
    private DBNote noteMock;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetTodo() throws Exception {
        when(todoDaoMock.getTodo(0)).thenReturn(noteMock);
        assertEquals(todoNotes.getTodo(0), noteMock);
    }

}