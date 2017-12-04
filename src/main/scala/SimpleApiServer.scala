package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{CommonFilters, LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.http.routing.HttpRouter

object SimpleApiServerMain extends SimpleApiServer

class SimpleApiServer extends HttpServer {

  override val defaultFinatraHttpPort: String = ":5566"

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[UserResController]
      .add[BookResController]
  }
}