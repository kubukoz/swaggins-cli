package swaggins.openapi.model

import swaggins.openapi.model.components.Components
import swaggins.openapi.model.paths.Paths
import scalaz.deriving
import io.circe.Decoder

@deriving(Decoder)
case class OpenAPI(
  openapi: String,
  info: Info,
  paths: Paths,
  components: Components
)

@deriving(Decoder)
case class Info(version: String, title: String)
