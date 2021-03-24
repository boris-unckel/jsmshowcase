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
package net.unckel.jsm.showcase.earpart.ejb;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import net.unckel.jsm.showcase.globalif.GreeterRemote;

/**
 * Session Bean implementation class Greeter
 */
@Stateless(name = "thegreeter")
public class Greeter implements GreeterLocal, GreeterRemote {

    private static final Logger LOG = LogManager.getLogManager().getLogger(Greeter.class.getCanonicalName());
    private static final String RESOURCE1 = "net/unckel/jsm/showcase/earpart/resources/file1.properties";
    private static final String RESOURCE2 = "net/unckel/jsm/showcase/earpart/resources/file2.properties";

    /**
     * Default constructor.
     */
    public Greeter() {
    }

    @PostConstruct
    private void initialize() {
        LOG.info("EJB Greeter initialize");
        final Properties props = new Properties();
        try (final InputStream is = Objects.requireNonNull(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(RESOURCE1), RESOURCE1);) {
            props.load(is);
        } catch (final IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
        LOG.info("key: " + props.getProperty("key"));
        // LOG.log(Level.FINE,"Analysis only, not thrown.", new RuntimeException());
    }

    @Override
    public String greet(final String name) {
        Objects.requireNonNull(name, "name");
        LOG.info("EJB Greeter greet");
        final Properties props = new Properties();
        try (final InputStream is = Objects.requireNonNull(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(RESOURCE2), RESOURCE2);) {
            props.load(is);
        } catch (final IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
        LOG.info("key: " + props.getProperty("key"));
        return "Hello " + name;
    }

}
