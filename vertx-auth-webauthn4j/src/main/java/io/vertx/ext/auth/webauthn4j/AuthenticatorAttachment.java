/*
 * Copyright 2019 Red Hat, Inc.
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
package io.vertx.ext.auth.webauthn4j;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;

/**
 * AuthenticatorAttachment
 * https://www.w3.org/TR/webauthn/#enumdef-authenticatorattachment
 */
@VertxGen
public enum AuthenticatorAttachment {
  PLATFORM("platform"),
  CROSS_PLATFORM("cross-platform");

  private final String value;

  AuthenticatorAttachment(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }

  @Nullable
  @GenIgnore(GenIgnore.PERMITTED_TYPE)
  public static AuthenticatorAttachment of(String string) {
    for (AuthenticatorAttachment el : values()) {
      if (el.toString().equals(string)) {
        return el;
      }
    }
    return null;
  }
}
