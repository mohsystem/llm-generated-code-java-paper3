package CoT.gemini;
import javax.servlet.http.*;
import java.util.*;

public class Task43 {

    public static class SessionManager {
        private final Map<String, HttpSession> sessions = new HashMap<>();

        public String createSession(HttpServletRequest request) {
            HttpSession session = request.getSession(true);
            String sessionId = generateSessionId();
            sessions.put(sessionId, session);
            return sessionId;
        }

        public HttpSession getSession(String sessionId) {
            return sessions.get(sessionId);
        }

        public void terminateSession(String sessionId) {
            HttpSession session = sessions.get(sessionId);
            if (session != null) {
                session.invalidate();
                sessions.remove(sessionId);
            }
        }

        private String generateSessionId() {
            return UUID.randomUUID().toString();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        // Test cases (Illustrative - would need a mock HttpServletRequest in real application)

        // Test 1: Create a session
        MockHttpServletRequest request1 = new MockHttpServletRequest();
        String sessionId1 = sm.createSession(request1);
        System.out.println("Session 1 created: " + sessionId1);


        // Test 2: Retrieve the session
        HttpSession session1 = sm.getSession(sessionId1);
        System.out.println("Session 1 retrieved: " + (session1 != null));

        // Test 3: Terminate the session
        sm.terminateSession(sessionId1);
        System.out.println("Session 1 terminated.");

        //Test 4: Try to retrieve terminated session
        session1 = sm.getSession(sessionId1);
        System.out.println("Session 1 retrieved after termination: " + (session1 != null));

        //Test 5: Create multiple sessions
        MockHttpServletRequest request2 = new MockHttpServletRequest();
        String sessionId2 = sm.createSession(request2);
        MockHttpServletRequest request3 = new MockHttpServletRequest();
        String sessionId3 = sm.createSession(request3);

        System.out.println("Session 2 created: " + sessionId2);
        System.out.println("Session 3 created: " + sessionId3);
    }


    // Mock HttpServletRequest for testing - replace with actual request object in a real application
    static class MockHttpServletRequest extends HttpServletRequestWrapper {
        private final Map<String, Object> attributes = new HashMap<>();


        public MockHttpServletRequest() {
            super(null); // No real request object for testing
        }


        @Override
        public HttpSession getSession(boolean create) {
            return new MockHttpSession();
        }


        @Override
        public Object getAttribute(String name) {
            return attributes.get(name);
        }


        @Override
        public void setAttribute(String name, Object o) {
            attributes.put(name, o);
        }
    }


    static class MockHttpSession implements HttpSession {
        private final Map<String, Object> attributes = new HashMap<>();

        @Override
        public long getCreationTime() {
            return 0;
        }

        @Override
        public String getId() {
            return UUID.randomUUID().toString();
        }


        @Override
        public long getLastAccessedTime() {
            return 0;
        }


        @Override
        public ServletContext getServletContext() {
            return null;
        }


        @Override
        public void setMaxInactiveInterval(int interval) {

        }


        @Override
        public int getMaxInactiveInterval() {
            return 0;
        }


        @Override
        public HttpSessionContext getSessionContext() {
            return null;
        }


        @Override
        public Object getAttribute(String name) {
            return attributes.get(name);
        }


        @Override
        public Object getValue(String name) {
            return null;
        }


        @Override
        public Enumeration<String> getAttributeNames() {
            return Collections.enumeration(attributes.keySet());
        }


        @Override
        public String[] getValueNames() {
            return new String[0];
        }


        @Override
        public void setAttribute(String name, Object value) {
            attributes.put(name, value);

        }


        @Override
        public void putValue(String name, Object value) {

        }


        @Override
        public void removeAttribute(String name) {
            attributes.remove(name);

        }


        @Override
        public void removeValue(String name) {

        }


        @Override
        public void invalidate() {

        }


        @Override
        public boolean isNew() {
            return false;
        }
    }

}