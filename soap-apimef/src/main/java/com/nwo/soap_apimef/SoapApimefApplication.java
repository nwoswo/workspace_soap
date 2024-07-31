package com.nwo.soap_apimef;

import com.nwo.soap_consumer.wsdl.ErrorDeServicio;
import com.nwo.soap_consumer.wsdl.IdValorDtoArray;
import com.nwo.soap_consumer.wsdl.Ventanillastd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;



import jakarta.xml.ws.Service;


@SpringBootApplication
public class SoapApimefApplication {

	public static void main(String[] args) throws ErrorDeServicio, MalformedURLException {


		SpringApplication.run(SoapApimefApplication.class, args);


		URL urlCooreios = new URL("http://sisadm.mef.gob.pe:8280/tramite/webservice/ventanillastd?wsdl");

		QName qnameCorreios = new QName("http://ws.web.bs.std.mef.gob.pe/", "ventanillastd");

		Service serviceCorreios = Service.create(urlCooreios, qnameCorreios);

		Ventanillastd correios = serviceCorreios.getPort(Ventanillastd.class);

		IdValorDtoArray endereco = correios.estadosExpediente();
		System.out.println(endereco.getItem().size());


	}

}
