package de.dsg.foglight.rest;

import org.apache.wink.server.internal.servlet.RestServlet;
import org.apache.wink.server.utils.RegistrationUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Application;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: stefan
 * Date: 12.06.13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class ServerServlet extends RestServlet {
    private static ThreadLocal<ServerServlet> _instance = new ThreadLocal<ServerServlet>() ;
    private static ServerServlet _servletInstance;

    public static ServerServlet getInstance() {
        return _servletInstance;
    }
    public static ServerServlet getCurrent() {
        return _instance.get();
    }

    public ServerServlet() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void init() throws ServletException {
        super.init();    //To change body of overridden methods use File | Settings | File Templates.
        _servletInstance = this;

    }

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        _instance.set(this);
        super.service(httpServletRequest, httpServletResponse);    //To change body of overridden methods use File | Settings | File Templates.
    }



    // TEST
    //
    public static void registerSingleton(Object resource) {
        System.out.println("Singleton registered");

        RegistrationUtils.registerInstances(getInstance().getServletContext(),resource);

   }



    public void registerApplication(Application app) {
        RegistrationUtils.registerApplication(app,getInstance().getServletContext());
    }
}
