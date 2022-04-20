package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueryCanceledQueryExceptionTest {
    
    private QueryCanceledQueryException qcqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "204-3";
    private final DatawaveErrorCode code = DatawaveErrorCode.QUERY_CANCELED;
    
    private final String assertMsg = "Query was canceled. Bad query exception";
    private final String assertMsg2 = "Query was canceled.";
    
    @Test
    public void testEmptyConstructor() {
        qcqe = new QueryCanceledQueryException();
        Assertions.assertEquals(500, qcqe.getStatusCode());
        Assertions.assertEquals("500-1", qcqe.getErrorCode());
        Assertions.assertNull(qcqe.getMessage());
        Assertions.assertNull(qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        qcqe = new QueryCanceledQueryException(message);
        Assertions.assertEquals(500, qcqe.getStatusCode());
        Assertions.assertEquals("500-1", qcqe.getErrorCode());
        Assertions.assertEquals(message, qcqe.getMessage());
        Assertions.assertEquals(message, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        qcqe = new QueryCanceledQueryException(message, throwable);
        Assertions.assertEquals(500, qcqe.getStatusCode());
        Assertions.assertEquals("500-1", qcqe.getErrorCode());
        Assertions.assertEquals(message, qcqe.getMessage());
        Assertions.assertEquals(message, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        qcqe = new QueryCanceledQueryException(throwable, strErrCode);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204-3", qcqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), qcqe.getMessage());
        Assertions.assertEquals(throwable.toString(), qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        qcqe = new QueryCanceledQueryException(code, throwable);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204-3", qcqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, qcqe.getMessage());
        Assertions.assertEquals(assertMsg2, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        qcqe = new QueryCanceledQueryException(code, message);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204-3", qcqe.getErrorCode());
        Assertions.assertEquals(assertMsg, qcqe.getMessage());
        Assertions.assertEquals(assertMsg, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        qcqe = new QueryCanceledQueryException(code, throwable, message);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204-3", qcqe.getErrorCode());
        Assertions.assertEquals(assertMsg, qcqe.getMessage());
        Assertions.assertEquals(assertMsg, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        qcqe = new QueryCanceledQueryException(code);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204-3", qcqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, qcqe.getMessage());
        Assertions.assertEquals(assertMsg2, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        qcqe = new QueryCanceledQueryException(message, 204);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204", qcqe.getErrorCode());
        Assertions.assertEquals(message, qcqe.getMessage());
        Assertions.assertEquals(message, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        qcqe = new QueryCanceledQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204-3", qcqe.getErrorCode());
        Assertions.assertEquals(message, qcqe.getMessage());
        Assertions.assertEquals(message, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        qcqe = new QueryCanceledQueryException(message, strErrCode);
        Assertions.assertEquals(204, qcqe.getStatusCode());
        Assertions.assertEquals("204-3", qcqe.getErrorCode());
        Assertions.assertEquals(message, qcqe.getMessage());
        Assertions.assertEquals(message, qcqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        qcqe = new QueryCanceledQueryException(throwable);
        Assertions.assertEquals(500, qcqe.getStatusCode());
        Assertions.assertEquals("500-1", qcqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), qcqe.getMessage());
        Assertions.assertEquals(throwable.toString(), qcqe.getLocalizedMessage());
    }
}
