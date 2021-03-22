/**
  *  Copyright © 2021 Boris Unckel
  *
  *  This file is part of jsmshowcase.
  *
  *  Foobar is free software: you can redistribute it and/or modify
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

import org.springframework.core.NestedRuntimeException;

/**
 * @author borisunckel
 *
 */
public class UncheckedSpringClientException extends NestedRuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 5434223241951952125L;

    /**
     * @param msg
     */
    public UncheckedSpringClientException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param cause
     */
    public UncheckedSpringClientException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
