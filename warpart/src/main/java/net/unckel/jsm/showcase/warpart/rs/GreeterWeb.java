/**
  *  Copyright © 2021 Boris Unckel
  *
  *  This file is part of jsmshowcase.
  *
  *  jsmshowcase is free software: you can redistribute it and/or modify
  *  it under the terms of the GNU General Public License as published by
  *  the Free Software Foundation, either version 3 of the License, or
  *  (at your option) any later version.
  *
  *  jsmshowcase is distributed in the hope that it will be useful,
  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  *  GNU General Public License for more details.
  *
  *  You should have received a copy of the GNU General Public License
  *  along with jsmshowcase.  If not, see <https://www.gnu.org/licenses/>.
  */
package net.unckel.jsm.showcase.warpart.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import net.unckel.jsm.showcase.globalif.GreeterIf;

//import net.unckel.jsm.showcase.globalif.GreeterRemote;

import java.io.Serializable;
import java.util.Objects;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

/**
 * @author borisunckel
 *
 */
@Path("/")
@SessionScoped
public class GreeterWeb implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3618860108232411005L;

    /**
     * Injected GreeterEJB client
     */
    @EJB(lookup = "ejb:earpart/earpart-ejb/thegreeter!net.unckel.jsm.showcase.globalif.GreeterRemote")
    //@EJB(lookup = "java:global/earpart/earpart-ejb/thegreeter!net.unckel.jsm.showcase.globalif.GreeterRemote")
    private GreeterIf greeterEJB;

    /**
     * 
     */
    public GreeterWeb() {
    }

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
        Objects.requireNonNull(greeterEJB, "greeterEJB");
        return "{\"result\":\"" + greeterEJB.greet("World") + "\"}";
    }
}
