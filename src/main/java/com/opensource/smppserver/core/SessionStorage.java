package com.opensource.smppserver.core;

import com.opensource.smppserver.dto.SessionWrapper;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionStorage {

    /**
     * key - unique sessionId, that generated by cloudhopper library.
     * value - wrapper object that contains managed session object and incoming request handler.
     */
    private final Map<Long, SessionWrapper> sessions = new ConcurrentHashMap<>();

    public void addSession(Long sessionId, SessionWrapper sessionWrapper) {
        sessions.putIfAbsent(sessionId, sessionWrapper);
    }

    public void removeSessionById(Long sessionId) {
        sessions.remove(sessionId);
    }

    public SessionWrapper getSessionById(Long sessionId) {
        return sessions.get(sessionId);
    }
}
