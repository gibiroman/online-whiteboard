/*
* @author  Oleg Varaksin (ovaraksin@googlemail.com)
* $$Id$$
*/

package com.googlecode.whiteboard.pubsub;

import org.atmosphere.annotation.Broadcast;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.jersey.SuspendResponse;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Path("/pubsub/{topic}/{sender}")
@Produces("text/html;charset=ISO-8859-1")
public class WhiteboardPubSub
{
    private
    @PathParam("topic")
    Broadcaster topic;

    @GET
    public SuspendResponse<String> subscribe() {
        return new SuspendResponse.SuspendResponseBuilder<String>().broadcaster(topic).outputComments(true).build();
    }

    @POST
    @Broadcast
    public String publish(@FormParam("message") String message, @PathParam("sender") String sender) {
        //System.out.println(message);

        // find current sender in all suspended resources and remove it from the notification
        Collection<AtmosphereResource<?, ?>> ars = topic.getAtmosphereResources();
        if (ars == null) {
            return "";
        }

        Set<AtmosphereResource<?, ?>> arsSubset = new HashSet<AtmosphereResource<?, ?>>();
        for (AtmosphereResource ar : ars) {
            Object req = ar.getRequest();
            if (req instanceof HttpServletRequest) {
                String pathInfo = ((HttpServletRequest) req).getPathInfo();
                String resSender = pathInfo.substring(pathInfo.lastIndexOf('/') + 1);
                if (!sender.equals(resSender)) {
                    arsSubset.add(ar);
                }
            }
        }

        topic.broadcast(message, arsSubset);

        return "";
    }
}
