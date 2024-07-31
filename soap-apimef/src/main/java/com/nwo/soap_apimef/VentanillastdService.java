package com.nwo.soap_apimef;


import com.nwo.soap_consumer.wsdl.ErrorDeServicio;
import com.nwo.soap_consumer.wsdl.IdValorDtoArray;
import com.nwo.soap_consumer.wsdl.Ventanillastd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentanillastdService {

  private final Ventanillastd ventanillastd;

  @Autowired
  public VentanillastdService(Ventanillastd ventanillastd) {
    this.ventanillastd = ventanillastd;
  }

  public IdValorDtoArray getEstadosExpediente() throws ErrorDeServicio {
    return ventanillastd.estadosExpediente();
  }
}