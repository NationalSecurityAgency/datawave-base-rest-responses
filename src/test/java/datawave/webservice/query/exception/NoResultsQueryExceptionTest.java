package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NoResultsQueryExceptionTest {
    
    private NoResultsQueryException nrqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "404-1";
    private final DatawaveErrorCode code = DatawaveErrorCode.QUERY_NAME_REQUIRED;
    
    private final String assertMsg = "Param queryName is required. Bad query exception";
    private final String assertMsg2 = "Param queryName is required.";
    
    @Test
    public void testEmptyConstructor() {
        nrqe = new NoResultsQueryException();
        Assertions.assertEquals(500, nrqe.getStatusCode());
        Assertions.assertEquals("500-1", nrqe.getErrorCode());
        Assertions.assertNull(nrqe.getMessage());
        Assertions.assertNull(nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        nrqe = new NoResultsQueryException(message);
        Assertions.assertEquals(500, nrqe.getStatusCode());
        Assertions.assertEquals("500-1", nrqe.getErrorCode());
        Assertions.assertEquals(message, nrqe.getMessage());
        Assertions.assertEquals(message, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        nrqe = new NoResultsQueryException(message, throwable);
        Assertions.assertEquals(500, nrqe.getStatusCode());
        Assertions.assertEquals("500-1", nrqe.getErrorCode());
        Assertions.assertEquals(message, nrqe.getMessage());
        Assertions.assertEquals(message, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        nrqe = new NoResultsQueryException(throwable, strErrCode);
        Assertions.assertEquals(404, nrqe.getStatusCode());
        Assertions.assertEquals("404-1", nrqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), nrqe.getMessage());
        Assertions.assertEquals(throwable.toString(), nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        nrqe = new NoResultsQueryException(code, throwable);
        Assertions.assertEquals(400, nrqe.getStatusCode());
        Assertions.assertEquals("400-1", nrqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, nrqe.getMessage());
        Assertions.assertEquals(assertMsg2, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        nrqe = new NoResultsQueryException(code, message);
        Assertions.assertEquals(400, nrqe.getStatusCode());
        Assertions.assertEquals("400-1", nrqe.getErrorCode());
        Assertions.assertEquals(assertMsg, nrqe.getMessage());
        Assertions.assertEquals(assertMsg, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        nrqe = new NoResultsQueryException(code, throwable, message);
        Assertions.assertEquals(400, nrqe.getStatusCode());
        Assertions.assertEquals("400-1", nrqe.getErrorCode());
        Assertions.assertEquals(assertMsg, nrqe.getMessage());
        Assertions.assertEquals(assertMsg, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        nrqe = new NoResultsQueryException(code);
        Assertions.assertEquals(400, nrqe.getStatusCode());
        Assertions.assertEquals("400-1", nrqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, nrqe.getMessage());
        Assertions.assertEquals(assertMsg2, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        nrqe = new NoResultsQueryException(message, 400);
        Assertions.assertEquals(400, nrqe.getStatusCode());
        Assertions.assertEquals("400", nrqe.getErrorCode());
        Assertions.assertEquals(message, nrqe.getMessage());
        Assertions.assertEquals(message, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        nrqe = new NoResultsQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(404, nrqe.getStatusCode());
        Assertions.assertEquals("404-1", nrqe.getErrorCode());
        Assertions.assertEquals(message, nrqe.getMessage());
        Assertions.assertEquals(message, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        nrqe = new NoResultsQueryException(message, strErrCode);
        Assertions.assertEquals(404, nrqe.getStatusCode());
        Assertions.assertEquals("404-1", nrqe.getErrorCode());
        Assertions.assertEquals(message, nrqe.getMessage());
        Assertions.assertEquals(message, nrqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        nrqe = new NoResultsQueryException(throwable);
        Assertions.assertEquals(500, nrqe.getStatusCode());
        Assertions.assertEquals("500-1", nrqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), nrqe.getMessage());
        Assertions.assertEquals(throwable.toString(), nrqe.getLocalizedMessage());
    }
}
