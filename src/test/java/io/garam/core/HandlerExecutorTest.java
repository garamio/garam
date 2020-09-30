package io.garam.core;

import io.garam.core.handlers.RequestHandler;
import io.garam.core.http.Context;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("HandlerExecutor test")
class HandlerExecutorTest {

    @DisplayName("핸들러 실행 여부 테스트")
    @Test
    void testExecuteGivenHandler() throws Exception {

        // given
        final RequestHandler mockHandler = mock(RequestHandler.class);
        final Context mockContext = mock(Context.class);

        // when
        final HandlerExecutor executor = new HandlerExecutor(mockHandler);
        executor.execute(mockContext);

        // then
        verify(mockHandler).handle(any(Context.class));
    }
}