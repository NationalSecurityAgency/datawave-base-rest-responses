package datawave.webservice.query.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PreConditionFailedQueryExceptionTest {
    
    private PreConditionFailedQueryException brqe;
    
    private final String message = "Bad query exception";
    private final Throwable throwable = new Throwable("throws");
    private final String strErrCode = "412-10";
    private final DatawaveErrorCode code = DatawaveErrorCode.QUERY_TERM_THRESHOLD_EXCEEDED;
    
    private final String assertMsg = "Query failed because it exceeded the query term threshold. Bad query exception";
    private final String assertMsg2 = "Query failed because it exceeded the query term threshold.";
    
    @Test
    public void testEmptyConstructor() {
        brqe = new PreConditionFailedQueryException();
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertNull(brqe.getMessage());
        Assertions.assertNull(brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageConstructor() {
        brqe = new PreConditionFailedQueryException(message);
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableConstructor() {
        brqe = new PreConditionFailedQueryException(message, throwable);
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowableErrorCodeConstructor() {
        brqe = new PreConditionFailedQueryException(throwable, strErrCode);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412-10", brqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), brqe.getMessage());
        Assertions.assertEquals(throwable.toString(), brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableConstructor() {
        brqe = new PreConditionFailedQueryException(code, throwable);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412-10", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, brqe.getMessage());
        Assertions.assertEquals(assertMsg2, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeDebugMsgConstructor() {
        brqe = new PreConditionFailedQueryException(code, message);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412-10", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg, brqe.getMessage());
        Assertions.assertEquals(assertMsg, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeThrowableDebugMsgConstructor() {
        brqe = new PreConditionFailedQueryException(code, throwable, message);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412-10", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg, brqe.getMessage());
        Assertions.assertEquals(assertMsg, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testDatawaveErrorCodeConstructor() {
        brqe = new PreConditionFailedQueryException(code);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412-10", brqe.getErrorCode());
        Assertions.assertEquals(assertMsg2, brqe.getMessage());
        Assertions.assertEquals(assertMsg2, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageResponseStatus() {
        brqe = new PreConditionFailedQueryException(message, 412);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageThrowableErrorCode() {
        brqe = new PreConditionFailedQueryException(message, throwable, strErrCode);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412-10", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testMessageErrorCode() {
        brqe = new PreConditionFailedQueryException(message, strErrCode);
        Assertions.assertEquals(412, brqe.getStatusCode());
        Assertions.assertEquals("412-10", brqe.getErrorCode());
        Assertions.assertEquals(message, brqe.getMessage());
        Assertions.assertEquals(message, brqe.getLocalizedMessage());
    }
    
    @Test
    public void testThrowable() {
        brqe = new PreConditionFailedQueryException(throwable);
        Assertions.assertEquals(500, brqe.getStatusCode());
        Assertions.assertEquals("500-1", brqe.getErrorCode());
        Assertions.assertEquals(throwable.toString(), brqe.getMessage());
        Assertions.assertEquals(throwable.toString(), brqe.getLocalizedMessage());
    }
}
