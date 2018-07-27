package swaggins.openapi.model
import monix.eval.Coeval
import swaggins.BaseTest

class OpenApiParsingTest extends BaseTest {
  "the parser" should {
    "parse the sample spec" in {
      val parser: OpenApiParser[Coeval] = new OpenApiParser[Coeval]

      parser.parse(filePath("/parsing-works.yml")).value shouldBe OpenAPI(
        "3.0.1",
        Info(
          "1.0.0",
          "My example project"
        ),
        Paths(
          Set(
            Path("/balance", PathItem(Map(HttpMethod.Get     -> Operation()))),
            Path("/transactions", PathItem(Map(HttpMethod.Post -> Operation())))
          ))
      )
    }
  }
}
