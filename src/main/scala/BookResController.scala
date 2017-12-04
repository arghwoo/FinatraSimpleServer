package io.arghwoo.simpleapiserver

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class BookResController extends Controller{
  get("/book") { request: Request =>
    info("hi")
    "Book is " + request.params.getOrElse("book", "unnamed") + ", method is get"
  }

  put("/book") { request: Request =>
    info("hi")
    "Book is " + request.params.getOrElse("book", "unnamed") + ",  method is put"
  }

  post("/book") { request: Request =>
    "Book is " + request.params.getOrElse("book", "unnamed") + ", method is post"
  }

  delete("/book") { request: Request=>
    "Try to delete book" + request.params.getOrElse("book", "unamed") + ", method is delete"
  }
}
