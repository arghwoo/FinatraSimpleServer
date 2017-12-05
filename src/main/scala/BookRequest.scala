package io.arghwoo.simpleapiserver

import com.twitter.finatra.request.RouteParam

case class BookResPutRequest(
                        @RouteParam("isbn") isbn:String,
                        name: String,
                        category: String)

case class BookResPostRequest(
                              isbn:String,
                              name: String,
                              category: String)