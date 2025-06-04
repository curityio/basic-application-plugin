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

import se.curity.identityserver.sdk.http.HttpStatus
import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.web.Produces
import se.curity.identityserver.sdk.web.Produces.ContentType.JSON
import se.curity.identityserver.sdk.web.Request
import se.curity.identityserver.sdk.web.RequestHandler
import se.curity.identityserver.sdk.web.Response

class BasicIndexRequestHandler(private val exceptionFactory: ExceptionFactory) : RequestHandler<Request> {
    override fun preProcess(request: Request, response: Response): Request = request

    override fun post(requestModel: Request, response: Response) = throw exceptionFactory.methodNotAllowed()

    @Produces(JSON)
    override fun get(requestModel: Request, response: Response) {
        response.putViewData("hello", "world", HttpStatus.OK)
    }

}
