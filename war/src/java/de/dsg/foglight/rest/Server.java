package de.dsg.foglight.rest;

import de.dsg.foglight.rest.api.StatusAPI;
import org.apache.wink.common.WinkApplication;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: stefan
 * Date: 12.06.13
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class Server extends WinkApplication {

    private Set<Object> _singletons;

    public Server() {
        super();

    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(StatusAPI.class);
        return classes;
    }

}
