package io.arghwoo.simpleapiserver

import com.twitter.finatra.request.RouteParam

case class UserResRequest(
                        @RouteParam("id") uri_id:String,
                        id: String,
                        first_name : String,
                        last_name : String,
                        age: Int,
                        city: String)