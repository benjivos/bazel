// Copyright 2016 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.packages;

import com.google.devtools.build.lib.cmdline.Label;
import com.google.devtools.build.lib.events.EventHandler;
import net.starlark.java.eval.StarlarkValue;
import net.starlark.java.syntax.Location;

/**
 * {@link StarlarkValue}s that need special handling when they are exported from an extension file.
 * For example, rule definitions receive their name at the end of the execution of the .bzl file.
 */
public interface StarlarkExportable extends StarlarkValue {

  /**
   * Is this value already exported?
   */
  boolean isExported();

  /**
   * Notify the value that it is exported from {@code extensionLabel} extension with name {@code
   * exportedName} at {@code exportedLocation}.
   */
  void export(
      EventHandler handler, Label extensionLabel, String exportedName, Location exportedLocation);
}
