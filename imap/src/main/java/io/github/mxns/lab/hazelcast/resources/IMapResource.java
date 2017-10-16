package io.github.mxns.lab.hazelcast.resources;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IMap;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("{mapId}")
public class IMapResource {
    private final IMap<String, String> data;

    public IMapResource(@PathParam("mapId") String mapId) {
        data = Hazelcast.getHazelcastInstanceByName("hazelcast-lab").getMap(mapId);
    }

    @POST
    public Response post(@FormParam("key") String key, @FormParam("value") String value) {
        data.put(key, value);
        return Response.ok().build();
    }

    @GET
    public Response get(@QueryParam("key") String key) {
        String value = data.get(key);
        if (value == null) {
            return Response.status(404).build();
        }
        return Response.ok(value).build();
    }

    @DELETE
    public Response delete(@QueryParam("key") String key) {
        String value = data.remove(key);
        if (value == null) {
            return Response.status(404).build();
        }
        return Response.ok().build();
    }
}
