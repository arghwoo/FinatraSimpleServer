package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import org.mongodb.scala.Document

class BookResController extends Controller{
  val uriPattern : String = "/books/:isbn"
  val resEndpoint : String = "bookId"

  get(uriPattern) { request: Request =>
    info("hi")
    val userName:String = request.uri
    "Hello " + request.params("isbn") + ", method is " + request.method.name
  }

  put(uriPattern){ request: BookResPutRequest =>
    val doc: Document = Document("isbn" -> request.isbn, "name" -> request.name,
      "category" -> request.category)
    "OK"
  }

  post(uriPattern) { request: BookResPostRequest =>
    val doc: Document = Document("isbn" -> request.isbn, "name" -> request.name,
      "category" -> request.category)
    "OK"
  }

  delete(uriPattern) { request: Request =>
    info("hi")
    "Hello " + request.params("isbn") + ", method is " + request.method.name
  }
}
