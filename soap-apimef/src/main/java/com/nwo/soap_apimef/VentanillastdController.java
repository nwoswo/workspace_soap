package com.nwo.soap_apimef;



import com.nwo.soap_consumer.wsdl.ErrorDeServicio;
import com.nwo.soap_consumer.wsdl.IdValorDtoArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VentanillastdController {

  private final VentanillastdService ventanillastdService;

  @Autowired
  public VentanillastdController(VentanillastdService ventanillastdService) {
    this.ventanillastdService = ventanillastdService;
  }

  @GetMapping("/estados")
  public IdValorDtoArray getEstadosExpediente() throws ErrorDeServicio {
    IdValorDtoArray result = ventanillastdService.getEstadosExpediente();
    if (result != null) {
      System.out.println("Number of items: " + result.getItem().size());
    } else {
      System.out.println("No data available.");
    }
    return result;
  }
}