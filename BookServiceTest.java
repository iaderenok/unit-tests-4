package seminars.fourth.book;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {
    BookRepository bookRepository = mock(BookRepository.class);
    BookService bookService = new BookService(bookRepository);
    @Test
    void findBookFromID() {
        bookService.findBookById("1");
        when(bookRepository.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));
        verify(bookRepository, times(1)).findById("1");

        String result = "1";
        String actualResult = bookService.findBookById("1").getId();
        assertEquals(actualResult, result);
    }
    @Test
    void findAllBooks() {
        when(bookRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(
                new Book("1"),
                new Book("2")
        )));
        verify(bookRepository, times(1)).findAll();


        int result = 2;
        int actualResult = bookService.findAllBooks().size();
        assertEquals(actualResult, result);
    }
}