/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.auth.sqlclient;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.ext.auth.authentication.AuthenticationProvider;
import io.vertx.ext.auth.hashing.HashingStrategy;
import io.vertx.ext.auth.sqlclient.impl.SqlAuthenticationImpl;
import io.vertx.sqlclient.SqlClient;

import java.util.Map;

/**
 * Factory interface for creating {@link io.vertx.ext.auth.authentication.AuthenticationProvider} instances that use the Vert.x SQL client.
 *
 * @author <a href="mailto:plopes@redhat.com">Paulo Lopes</a>
 */
@VertxGen
public interface SqlAuthentication extends AuthenticationProvider {

  /**
   * Create a JDBC auth provider implementation
   *
   * @param client the JDBC client instance
   * @return the auth provider
   */
  static SqlAuthentication create(SqlClient client) {
    return create(client, new SqlAuthenticationOptions());
  }

  /**
   * Create a JDBC auth provider implementation
   *
   * @param client  the JDBC client instance
   * @param options authentication options
   * @return the auth provider
   */
  static SqlAuthentication create(SqlClient client, SqlAuthenticationOptions options) {
    return new SqlAuthenticationImpl(client, options);
  }

  /**
   * Hashes a password to be stored.
   * <p>
   * See: {@link HashingStrategy#hash(String, Map, String, String)}
   */
  String hash(String id, Map<String, String> params, String salt, String password);

  /**
   * Hashes a password to be stored.
   * <p>
   * See: {@link HashingStrategy#hash(String, Map, String, String)}
   */
  default String hash(String id, String salt, String password) {
    return hash(id, null, salt, password);
  }
}
