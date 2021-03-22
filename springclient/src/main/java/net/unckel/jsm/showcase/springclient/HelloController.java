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
package net.unckel.jsm.showcase.springclient;

import org.springframework.web.bind.annotation.RestController;

import net.unckel.jsm.showcase.globalif.GreeterIf;

import java.util.Objects;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @author borisunckel
 *
 */
@RestController
public class HelloController {

    private static final Log LOG = LogFactory.getLog(HelloController.class);
    
    /**
     * 
     */
    public HelloController() {
    }

    @RequestMapping("/")
    public String index() {
        LOG.info("Entered HelloController index");
        final JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setResourceRef(true);
        bean.setJndiName("ejb:earpart/earpart-ejb/thegreeter!net.unckel.jsm.showcase.globalif.GreeterRemote");
        bean.setProxyInterface(GreeterIf.class);
        try {
            bean.afterPropertiesSet();
        } catch (IllegalArgumentException | NamingException e) {
            throw new UncheckedSpringClientException(e.getMessage(), e);
        }
        final GreeterIf aGreeter = Objects.requireNonNull((GreeterIf) bean.getObject(),"aGreeter");

        return aGreeter.greet("MySpringClient");
    }
}
