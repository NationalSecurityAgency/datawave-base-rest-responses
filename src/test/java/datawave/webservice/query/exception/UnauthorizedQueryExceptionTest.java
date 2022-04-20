package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnauthorizedQueryExceptionTest {
    
    private UnauthorizedQueryException tqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "401-1";
    private final DatawaveErrorCode code = DatawaveErrorCode.QUERY_OWNER_MISMATCH;
    
    private final String assertMsg = "Current user does not match user that defined query. Bad query exception";
    private final String assertMsg2 = "Current user does not match user that defined query.";
    
    @Test
    public void testEmptyConstructor() {
        tqe = new UnauthorizedQueryException();
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertNull(tqe.getMessage());
        Assertions.assertNull(tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        tqe = new UnauthorizedQueryException(message);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        tqe = new UnauthorizedQueryException(message, throwable);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        tqe = new UnauthorizedQueryException(throwable, strErrCode);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401-1", tqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), tqe.getMessage());
        Assertions.assertEquals(throwable.toString(), tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        tqe = new UnauthorizedQueryException(code, throwable);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401-1", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, tqe.getMessage());
        Assertions.assertEquals(assertMsg2, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        tqe = new UnauthorizedQueryException(code, message);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401-1", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg, tqe.getMessage());
        Assertions.assertEquals(assertMsg, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        tqe = new UnauthorizedQueryException(code, throwable, message);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401-1", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg, tqe.getMessage());
        Assertions.assertEquals(assertMsg, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        tqe = new UnauthorizedQueryException(code);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401-1", tqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, tqe.getMessage());
        Assertions.assertEquals(assertMsg2, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        tqe = new UnauthorizedQueryException(message, 401);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        tqe = new UnauthorizedQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401-1", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        tqe = new UnauthorizedQueryException(message, strErrCode);
        Assertions.assertEquals(401, tqe.getStatusCode());
        Assertions.assertEquals("401-1", tqe.getErrorCode());
        Assertions.assertEquals(message, tqe.getMessage());
        Assertions.assertEquals(message, tqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        tqe = new UnauthorizedQueryException(throwable);
        Assertions.assertEquals(500, tqe.getStatusCode());
        Assertions.assertEquals("500-1", tqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), tqe.getMessage());
        Assertions.assertEquals(throwable.toString(), tqe.getLocalizedMessage());
    }
    
}
