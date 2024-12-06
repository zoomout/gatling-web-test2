enablePlugins(GatlingPlugin)

scalaVersion := "3.4.2"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.12.0" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.12.0" % "test"
