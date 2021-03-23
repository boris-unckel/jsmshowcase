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
package net.unckel.jsm.showcase.earpartweb.rs;

import java.io.Serializable;
import java.util.Objects;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import net.unckel.jsm.showcase.earpart.ejb.GreeterLocal;

/**
 * @author borisunckel
 *
 */
@Path("/")
@SessionScoped
public class GreaterInEar implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3454125203501928322L;

    /**
     * Injected GreeterEJB client
     */
    //@EJB(lookup = "java:global/earpart/earpart-ejb/thegreeter!net.unckel.jsm.showcase.earpart.ejb.GreeterLocal")
    //@EJB(beanName = "thegreeter")
    @Inject
    private GreeterLocal greeterEJB;

    /**
     * 
     */
    public GreaterInEar() {

    }

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
        Objects.requireNonNull(greeterEJB, "greeterEJB");
        return "{\"result\":\"" + greeterEJB.greet("from a war in a ear.") + "\"}";
    }

}
