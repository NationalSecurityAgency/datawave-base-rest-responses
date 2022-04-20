package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BadRequestQueryExceptionTest {
    
    private BadRequestQueryException brqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "404-1";
    private final DatawaveErrorCode code = DatawaveErrorCode.QUERY_NAME_REQUIRED;
    
    private final String assertMsg = "Param queryName is required. Bad query exception";
    private final String assertMsg2 = "Param queryName is required.";
    
    @Test
    public void testEmptyConstructor() {
        brqe = new BadRequestQueryException();
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertNull(brqe.getMessage());
        Assertions.assertNull(brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        brqe = new BadRequestQueryException(message);
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        brqe = new BadRequestQueryException(message, throwable);
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        brqe = new BadRequestQueryException(throwable, strErrCode);
        Assertions.assertEquals(404, brqe.getStatusCode());
        Assertions.assertEquals("404-1", brqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), brqe.getMessage());
        Assertions.assertEquals(throwable.toString(), brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        brqe = new BadRequestQueryException(code, throwable);
        Assertions.assertEquals(400, brqe.getStatusCode());
        Assertions.assertEquals("400-1", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, brqe.getMessage());
        Assertions.assertEquals(assertMsg2, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        brqe = new BadRequestQueryException(code, message);
        Assertions.assertEquals(400, brqe.getStatusCode());
        Assertions.assertEquals("400-1", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg, brqe.getMessage());
        Assertions.assertEquals(assertMsg, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        brqe = new BadRequestQueryException(code, throwable, message);
        Assertions.assertEquals(400, brqe.getStatusCode());
        Assertions.assertEquals("400-1", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg, brqe.getMessage());
        Assertions.assertEquals(assertMsg, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        brqe = new BadRequestQueryException(code);
        Assertions.assertEquals(400, brqe.getStatusCode());
        Assertions.assertEquals("400-1", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, brqe.getMessage());
        Assertions.assertEquals(assertMsg2, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        brqe = new BadRequestQueryException(message, 400);
        Assertions.assertEquals(400, brqe.getStatusCode());
        Assertions.assertEquals("400", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        brqe = new BadRequestQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(404, brqe.getStatusCode());
        Assertions.assertEquals("404-1", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        brqe = new BadRequestQueryException(message, strErrCode);
        Assertions.assertEquals(404, brqe.getStatusCode());
        Assertions.assertEquals("404-1", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        brqe = new BadRequestQueryException(throwable);
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), brqe.getMessage());
        Assertions.assertEquals(throwable.toString(), brqe.getLocalizedMessage());
    }
}
