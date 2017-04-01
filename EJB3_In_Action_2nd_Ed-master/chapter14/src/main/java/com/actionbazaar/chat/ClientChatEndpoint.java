/**
 *  ClientChatEndpoint.java
 *  EJB 3 in Action
 *  Book: http://manning.com/panda2/
 *  Code: http://code.google.com/p/action-bazaar/
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.actionbazaar.chat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletContextListener;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import javax.websocket.server.ServerContainer;

/**
 * This is the endpoint which handles incoming chat messages from the user.
 * @author Ryan Cuprak
 */
public class ClientChatEndpoint extends Endpoint {
    
    /**
     * Serial UID
     */
    private static final long serialVersionUID = -821556242107966141L;
    
     /**
     * Logger
     */
    private static final Logger logger = Logger.getLogger("ChatService");
    
    /**
     * Creates a new chat client
     */
    public ClientChatEndpoint() {
        logger.log(Level.INFO, "ClientChat instance: {0}");
        ServerContainer sc;
       
        
    }
    
    /**
     * Reference to the chat server
     */
    @EJB
    private ChatServer chatServer;

    /**
     * Handles the open
     * @param session - new session
     * @param config - configuration
     */
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        chatServer.addClientSession(session);
        session.addMessageHandler(new CommandMessageHandler(chatServer,session));
    }

    @Override
    public void onError(Session session, Throwable thr) {
        chatServer.removeClientSession(session);
        logger.log(Level.SEVERE,"There was a fatal error",thr);
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        chatServer.removeClientSession(session);
    }
}
