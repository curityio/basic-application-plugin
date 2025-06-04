/*
 * Copyright 2025 Curity AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.curity.identityserver.application.basic

import se.curity.identityserver.sdk.config.Configuration
import se.curity.identityserver.sdk.plugin.descriptor.ApplicationPluginDescriptor

interface BasicApplicationConfiguration : Configuration {
    // No config needed
}

class BasicApplicationPluginDescriptor : ApplicationPluginDescriptor<BasicApplicationConfiguration> {
    override fun getPluginImplementationType(): String = "basic-app"

    override fun getConfigurationType() = BasicApplicationConfiguration::class.java

    override fun getAnonymousRequestHandlerTypes() = mapOf("index" to BasicIndexRequestHandler::class.java)
}