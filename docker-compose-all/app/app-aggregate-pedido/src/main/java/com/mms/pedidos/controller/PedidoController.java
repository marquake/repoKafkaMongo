package com.mms.pedidos;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PedidoController extends URLs {

    // Crea una instancia de RestTemplate
    private RestTemplate restTemplate = new RestTemplate();

    PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService =  pedidoService;
    }

    @GetMapping(value ="/aggregate-pedido")
    public ResponseEntity<List<PedidoDTO>> getListaPedidos(){
        getClientes();
        getRepartidores();
        getPedidos();
        return ResponseEntity.ok().build();
    }

    public void getClientes(){
        ResponseEntity<List<ClienteDTO>> responseCliente = restTemplate.exchange(
                getUrlCliente(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ClienteDTO>>() {});

        responseCliente.getBody().stream().forEach(System.out::println);
    }
    public void getRepartidores(){
        ResponseEntity<List<RepartidorDTO>> responseRepartidor = restTemplate.exchange(
                getUrlRepartidor(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RepartidorDTO>>() {});

        responseRepartidor.getBody().stream().forEach(System.out::println);
    }
    public void getPedidos(){
        ResponseEntity<List<PedidoDTO>> responsePedido = restTemplate.exchange(
                getUrlPedido(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PedidoDTO>>() {});

        responsePedido.getBody().stream().forEach(System.out::println);
    }

}

