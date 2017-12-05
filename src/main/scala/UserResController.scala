
package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class UserResController extends Controller {
  val uriPattern : String = "/users/:id"
  get(uriPattern) { request: Request =>
    info("hi")
    val userName:String = request.uri
    "Hello " + request.params("id") + ", method is " + request.method.name
  }

  put(uriPattern) { request: UserResRequest =>
    info("hi")
    "Hello " + request.first_name + " " + request.last_name + ", age is " + request.age + ", city is " + request.city
  }

  post(uriPattern) { request: UserResRequest =>
    "Hello " + request.first_name + " " + request.last_name + ", age is " + request.age + ", city is " + request.city
  }

  delete(uriPattern) { request: Request =>
    info("hi")
    "Hello " + request.params("id") + ", method is " + request.method.name
  }
}
