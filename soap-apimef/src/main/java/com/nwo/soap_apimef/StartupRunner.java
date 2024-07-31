package com.nwo.soap_apimef;


import com.nwo.soap_consumer.wsdl.ErrorDeServicio;
import com.nwo.soap_consumer.wsdl.IdValorDtoArray;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class StartupRunner implements ApplicationRunner {

  private final VentanillastdService ventanillastdService;

  public StartupRunner(VentanillastdService ventanillastdService) {
    this.ventanillastdService = ventanillastdService;
  }

  @Override
  public void run(ApplicationArguments args) throws ErrorDeServicio {
    IdValorDtoArray endereco = ventanillastdService.getEstadosExpediente();
    if (endereco != null) {
      System.out.println("Number of items: " + endereco.getItem().size());
    } else {
      System.out.println("No data available.");
    }
  }
}