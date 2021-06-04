package $package$.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class IndexController {

  private final Environment environment;


  public IndexController(Environment environment) {
    this.environment = environment;
  }

  @GetMapping("/")
  public String world() {
    String index =
      "<h1>Proyecto $project$ (" + environment.getActiveProfiles() + ") <h1>" +
        "<h2>Aplicacion $application$</h2><br/>" +
        "<ul>" +
        "  <li><a href=\"/swagger-ui.html\">/swagger-ui.html</a></li>" +
        "  <li><a href=\"/$module1_format$/44005500\">/$module1_format$/44005500</a></li>" +
        "</ul>"
      ;

    return index;
  }

}
