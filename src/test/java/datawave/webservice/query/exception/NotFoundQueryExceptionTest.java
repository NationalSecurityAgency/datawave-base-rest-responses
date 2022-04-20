package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotFoundQueryExceptionTest {
    
    private NotFoundQueryException nfqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "204-5";
    private final DatawaveErrorCode code = DatawaveErrorCode.QUERY_OR_VIEW_NOT_FOUND;
    
    private final String assertMsg = "Query/view not found. Bad query exception";
    private final String assertMsg2 = "Query/view not found.";
    
    @Test
    public void testEmptyConstructor() {
        nfqe = new NotFoundQueryException();
        Assertions.assertEquals(500, nfqe.getStatusCode());
        Assertions.assertEquals("500-1", nfqe.getErrorCode());
        Assertions.assertNull(nfqe.getMessage());
        Assertions.assertNull(nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        nfqe = new NotFoundQueryException(message);
        Assertions.assertEquals(500, nfqe.getStatusCode());
        Assertions.assertEquals("500-1", nfqe.getErrorCode());
        Assertions.assertEquals(message, nfqe.getMessage());
        Assertions.assertEquals(message, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        nfqe = new NotFoundQueryException(message, throwable);
        Assertions.assertEquals(500, nfqe.getStatusCode());
        Assertions.assertEquals("500-1", nfqe.getErrorCode());
        Assertions.assertEquals(message, nfqe.getMessage());
        Assertions.assertEquals(message, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        nfqe = new NotFoundQueryException(throwable, strErrCode);
        Assertions.assertEquals(204, nfqe.getStatusCode());
        Assertions.assertEquals("204-5", nfqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), nfqe.getMessage());
        Assertions.assertEquals(throwable.toString(), nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        nfqe = new NotFoundQueryException(code, throwable);
        Assertions.assertEquals(404, nfqe.getStatusCode());
        Assertions.assertEquals("404-6", nfqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, nfqe.getMessage());
        Assertions.assertEquals(assertMsg2, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        nfqe = new NotFoundQueryException(code, message);
        Assertions.assertEquals(404, nfqe.getStatusCode());
        Assertions.assertEquals("404-6", nfqe.getErrorCode());
        Assertions.assertEquals(assertMsg, nfqe.getMessage());
        Assertions.assertEquals(assertMsg, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        nfqe = new NotFoundQueryException(code, throwable, message);
        Assertions.assertEquals(404, nfqe.getStatusCode());
        Assertions.assertEquals("404-6", nfqe.getErrorCode());
        Assertions.assertEquals(assertMsg, nfqe.getMessage());
        Assertions.assertEquals(assertMsg, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        nfqe = new NotFoundQueryException(code);
        Assertions.assertEquals(404, nfqe.getStatusCode());
        Assertions.assertEquals("404-6", nfqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, nfqe.getMessage());
        Assertions.assertEquals(assertMsg2, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        nfqe = new NotFoundQueryException(message, 404);
        Assertions.assertEquals(404, nfqe.getStatusCode());
        Assertions.assertEquals("404", nfqe.getErrorCode());
        Assertions.assertEquals(message, nfqe.getMessage());
        Assertions.assertEquals(message, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        nfqe = new NotFoundQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(204, nfqe.getStatusCode());
        Assertions.assertEquals("204-5", nfqe.getErrorCode());
        Assertions.assertEquals(message, nfqe.getMessage());
        Assertions.assertEquals(message, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        nfqe = new NotFoundQueryException(message, strErrCode);
        Assertions.assertEquals(204, nfqe.getStatusCode());
        Assertions.assertEquals("204-5", nfqe.getErrorCode());
        Assertions.assertEquals(message, nfqe.getMessage());
        Assertions.assertEquals(message, nfqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        nfqe = new NotFoundQueryException(throwable);
        Assertions.assertEquals(500, nfqe.getStatusCode());
        Assertions.assertEquals("500-1", nfqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), nfqe.getMessage());
        Assertions.assertEquals(throwable.toString(), nfqe.getLocalizedMessage());
    }
}
