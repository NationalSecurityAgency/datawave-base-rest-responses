package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeoutQueryExceptionTest {
    
    private TimeoutQueryException tqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "500-26";
    private final DatawaveErrorCode code = DatawaveErrorCode.QUERY_TIMEOUT;
    
    private final String assertMsg = "Query timed out. Bad query exception";
    private final String assertMsg2 = "Query timed out.";
    
    @Test
    public void testEmptyConstructor() {
        tqe = new TimeoutQueryException();
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertNull(tqe.getMessage());
        Assertions.assertNull(tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        tqe = new TimeoutQueryException(message);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        tqe = new TimeoutQueryException(message, throwable);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        tqe = new TimeoutQueryException(throwable, strErrCode);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-26", tqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), tqe.getMessage());
        Assertions.assertEquals(throwable.toString(), tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        tqe = new TimeoutQueryException(code, throwable);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-27", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, tqe.getMessage());
        Assertions.assertEquals(assertMsg2, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        tqe = new TimeoutQueryException(code, message);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-27", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg, tqe.getMessage());
        Assertions.assertEquals(assertMsg, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        tqe = new TimeoutQueryException(code, throwable, message);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-27", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg, tqe.getMessage());
        Assertions.assertEquals(assertMsg, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        tqe = new TimeoutQueryException(code);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-27", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, tqe.getMessage());
        Assertions.assertEquals(assertMsg2, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        tqe = new TimeoutQueryException(message, 500);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        tqe = new TimeoutQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-26", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        tqe = new TimeoutQueryException(message, strErrCode);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-26", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        tqe = new TimeoutQueryException(throwable);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), tqe.getMessage());
        Assertions.assertEquals(throwable.toString(), tqe.getLocalizedMessage());
    }
}
