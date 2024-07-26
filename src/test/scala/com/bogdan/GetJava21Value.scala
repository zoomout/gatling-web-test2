package com.bogdan

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

import scala.concurrent.duration._

class GetJava21Value extends BaseSimulation {

  private val httpProtocol = http
    .baseUrl(baseUrl)
    .contentTypeHeader("application/json")
    .shareConnections

  val scn: ScenarioBuilder = scenario("getJava21Value")
    .exec(http("getJava21Value")
      .get("/java-21-value")
      .check(
        status is 200
      ))

  val users = 1000;

  setUp(scn.inject(
    rampUsersPerSec(10) to users during (1 seconds),
    constantUsersPerSec(users) during (2 minutes),
    rampUsersPerSec(users) to 10 during (1 seconds),
  )).protocols(httpProtocol)
}