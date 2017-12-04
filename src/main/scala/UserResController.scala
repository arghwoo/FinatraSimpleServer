
package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class UserResController extends Controller {

  get("/user") { request: Request =>
    info("hi")
    "Hello " + request.params.getOrElse("name", "unnamed") + "Method is get"
  }

  put("/user") { request: Request =>
    info("hi")
    "Hello " + request.params.getOrElse("name", "unamed") + "Method is Put"

  }

  post("/user") { hiRequest: HiRequest =>
    "Hello " + hiRequest.name + " with id " + hiRequest.id + "Method is post"
  }

  delete("/user") { request: Request =>
    info("hi")
    "Hello " + request.params.getOrElse("name", "unamed") + " method is delete"
  }
}
