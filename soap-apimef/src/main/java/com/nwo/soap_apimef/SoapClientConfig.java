package com.nwo.soap_apimef;

import com.nwo.soap_consumer.wsdl.Ventanillastd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;


@Configuration
public class SoapClientConfig {

  private static final String WSDL_URL = "http://sisadm.mef.gob.pe:8280/tramite/webservice/ventanillastd?wsdl";
  private static final String NAMESPACE_URI = "http://ws.web.bs.std.mef.gob.pe/";
  private static final String SERVICE_NAME = "ventanillastd";

  @Bean
  public Ventanillastd ventanillastdClient() throws Exception {
    URL url = new URL(WSDL_URL);
    QName qname = new QName(NAMESPACE_URI, SERVICE_NAME);
    Service service = Service.create(url, qname);
    return service.getPort(Ventanillastd.class);
  }
}