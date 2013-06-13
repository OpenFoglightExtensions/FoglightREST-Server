package de.dsg.foglight.rest.service.impl;

import com.quest.nitro.extension.*;
import com.quest.nitro.service.sl.interfaces.lifecycle.LifecycleAware;
import com.quest.nitro.service.sl.interfaces.lifecycle.LifecycleException;

import de.dsg.foglight.rest.ServerServlet;
import de.dsg.foglight.rest.service.RESTServer;
import de.dsg.foglight.rest.service.RestApplication;

/**
 * Created with IntelliJ IDEA.
 * User: stefan
 * Date: 13.06.13
 * Time: 10:44
 * To change this template use File | Settings | File Templates.
 */
public class RESTServerImpl implements RESTServer,ExtensionRegistrationListener<RestApplication>, LifecycleAware,
        ExtensionContextAware, ExtensionBroadcasterAware {


    private ExtensionBroadcaster _broadcaster;
    private ExtensionContext _ctx;



    public RESTServerImpl() {

    }


    @Override
    public void setExtensionBroadcaster(ExtensionBroadcaster extensionBroadcaster) {
        _broadcaster = extensionBroadcaster;
    }

    @Override
    public void setExtensionContext(ExtensionContext extensionContext) {
        _ctx = extensionContext;
    }

    @Override
    public void extensionRegistered(RestApplication restApplication) {
        // TODO Need to do something with this
    }

    @Override
    public void extensionUnregistered(RestApplication restApplication) {
        // TODO Need to do something with this
    }

    @Override
    public void enable() throws LifecycleException {
    }

    @Override
    public void start() throws LifecycleException {
        _ctx.register(this);
    }

    @Override
    public void stop() throws LifecycleException {
        _ctx.unregister(this);
    }

    @Override
    public void disable() throws LifecycleException {
    }


    @Override
    public ServerServlet getService() {
        return ServerServlet.getInstance();
    }
}
