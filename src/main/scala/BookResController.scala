package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class BookResController extends Controller{
  val uriPattern : String = "/books/:book_id"
  val resEndpoint : String = "bookId"

  get(uriPattern) { request: Request =>
    info("hi")
    val userName:String = request.uri
    "Hello " + request.params("bookId") + ", method is " + request.method.name
  }

  put(uriPattern){ request: BookRequest =>
    "BookId in uri is " + request.bookId + ", bookId in body is " + request.id + ", book name is " + request.name
  }

  post(uriPattern) { request: BookRequest =>
    "BookId in uri is " + request.bookId + ", bookId in body is " + request.id + ", book name is " + request.name
  }

  delete(uriPattern) { request: Request =>
    info("hi")
    "Hello " + request.params("id") + ", method is " + request.method.name
  }
}
