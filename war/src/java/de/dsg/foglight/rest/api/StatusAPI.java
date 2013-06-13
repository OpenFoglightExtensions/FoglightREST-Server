package de.dsg.foglight.rest.api;

import com.quest.nitro.service.sl.ServiceLocatorFactory;
import com.quest.nitro.service.sl.interfaces.monitor.IServerSelfMonitor;
import com.quest.nitro.service.sl.interfaces.scripting.PreparedScript;
import com.quest.nitro.service.sl.interfaces.scripting.ScriptDefinition;
import com.quest.nitro.service.sl.interfaces.scripting.ScriptingException;
import com.quest.nitro.service.sl.interfaces.topology.TopologyServiceInterface;
import de.dsg.foglight.rest.ServerServlet;
import de.dsg.foglight.rest.data.StatusData;
import org.apache.wink.common.AbstractDynamicResource;
import org.apache.wink.common.annotations.Workspace;
import org.apache.wink.server.utils.RegistrationUtils;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: stefan
 * Date: 12.06.13
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */

@Workspace(workspaceTitle = "status", collectionTitle = "Title")
@Path("status")
public class StatusAPI {

    @GET
    @Path("short")
    @Produces(MediaType.APPLICATION_JSON)
    public StatusData getBooksBadger()
    {
        return new StatusData(0,"Fine!", "Overall Status is fine no Problems.")   ;
    }

    @GET
    @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    public StatusData getBooksBadger2()
    {
        return new StatusData(0,"FineXML!", "Overall Status is fine no Problems.")   ;
    }

    @GET
    @Path("/enable/{b}")
    public String invokeWithBookIdAndLanguage(@PathParam("b") String flag) {
        /* get the info for bookId */
        if (flag.equals("register")) {
            ServerServlet.getCurrent().registerSingleton(new PingAPI());
        }
        return "TESTER: "+flag;
    }

    @GET
    @Path("server")
    public String getServerStatus() {
        TopologyServiceInterface topologyService = ServiceLocatorFactory.getLocator().getTopologyService();
        long numTypes = topologyService.getTypeNames().size();
     return "NU;:"+numTypes;
    }



}
