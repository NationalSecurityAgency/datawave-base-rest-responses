package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShutdownQueryExceptionTest {
    
    private ShutdownQueryException sqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "500-26";
    private final DatawaveErrorCode code = DatawaveErrorCode.SERVER_SHUTDOWN;
    
    private final String assertMsg = "Server being shut down. Bad query exception";
    private final String assertMsg2 = "Server being shut down.";
    
    @Test
    public void testEmptyConstructor() {
        sqe = new ShutdownQueryException();
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-1", sqe.getErrorCode());
        Assertions.assertNull(sqe.getMessage());
        Assertions.assertNull(sqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        sqe = new ShutdownQueryException(message);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-1", sqe.getErrorCode());
        Assertions.assertEquals(message, sqe.getMessage());
        Assertions.assertEquals(message, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        sqe = new ShutdownQueryException(message, throwable);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-1", sqe.getErrorCode());
        Assertions.assertEquals(message, sqe.getMessage());
        Assertions.assertEquals(message, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        sqe = new ShutdownQueryException(throwable, strErrCode);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-26", sqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), sqe.getMessage());
        Assertions.assertEquals(throwable.toString(), sqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        sqe = new ShutdownQueryException(code, throwable);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-26", sqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, sqe.getMessage());
        Assertions.assertEquals(assertMsg2, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        sqe = new ShutdownQueryException(code, message);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-26", sqe.getErrorCode());
        Assertions.assertEquals(assertMsg, sqe.getMessage());
        Assertions.assertEquals(assertMsg, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        sqe = new ShutdownQueryException(code, throwable, message);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-26", sqe.getErrorCode());
        Assertions.assertEquals(assertMsg, sqe.getMessage());
        Assertions.assertEquals(assertMsg, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        sqe = new ShutdownQueryException(code);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-26", sqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, sqe.getMessage());
        Assertions.assertEquals(assertMsg2, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        sqe = new ShutdownQueryException(message, 500);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500", sqe.getErrorCode());
        Assertions.assertEquals(message, sqe.getMessage());
        Assertions.assertEquals(message, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        sqe = new ShutdownQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-26", sqe.getErrorCode());
        Assertions.assertEquals(message, sqe.getMessage());
        Assertions.assertEquals(message, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        sqe = new ShutdownQueryException(message, strErrCode);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-26", sqe.getErrorCode());
        Assertions.assertEquals(message, sqe.getMessage());
        Assertions.assertEquals(message, sqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        sqe = new ShutdownQueryException(throwable);
        Assertions.assertEquals(500, sqe.getStatusCode());
        Assertions.assertEquals("500-1", sqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), sqe.getMessage());
        Assertions.assertEquals(throwable.toString(), sqe.getLocalizedMessage());
    }
}
