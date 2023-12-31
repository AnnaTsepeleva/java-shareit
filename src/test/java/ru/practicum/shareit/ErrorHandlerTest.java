package ru.practicum.shareit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.practicum.shareit.exceptions.AlreadyExistsException;
import ru.practicum.shareit.exceptions.ErrorHandler;
import ru.practicum.shareit.exceptions.NotFoundException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ErrorHandlerTest {
    @InjectMocks
    private ErrorHandler errorHandler;

    @Test
    void testHandleNotFound() {
        NotFoundException notFoundException = new NotFoundException("Не найден");
        Map<String, String> result = errorHandler.handleNotFound(notFoundException);
        assertEquals("Не найден", result.get("error"));
    }

    @Test
    void testHandleConflict() {
        AlreadyExistsException alreadyExistsException = new AlreadyExistsException("Уже существует");
        Map<String, String> result = errorHandler.handleAlreadyExists(alreadyExistsException);
        assertEquals("Уже существует", result.get("error"));
    }

    @Test
    void testHandleInternalError() {
        Throwable throwable = new Throwable("Ошибка приложения");
        Map<String, String> result = errorHandler.handleThrowable(throwable);
        assertEquals("Ошибка приложения", result.get("error"));
    }
}