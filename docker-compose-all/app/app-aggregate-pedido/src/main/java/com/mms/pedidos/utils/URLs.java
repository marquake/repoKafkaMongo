package com.mms.pedidos;

import org.springframework.beans.factory.annotation.Value;

public class URLs {

    private static final String http = "http://";

    private static final String host_cliente = "app-cliente";
    private static final String host_repartidor = "app-repartidor";
    private static final String host_pedido = "app-pedido";

    @Value("${puerto-cliente}")
    private static final String port_cliente = "8080";
    @Value("${puerto-repartidor}")
    private static final String port_repartidor = "8081";
    @Value("${puerto-pedido}")
    private static final String port_pedido = "8082";

//    String urlCliente = "http://app-cliente:8080/cliente";
//    String urlRepartidor = "http://app-repartidor:8081/repartidor";
//    String urlPedido = "http://app-pedido:8082/pedido";

    private static final String urlCliente = http + host_cliente+":" + port_cliente + "/cliente";
    private static final String urlRepartidor = http + host_repartidor + ":" + port_repartidor + "/repartidor";
    private static final String urlPedido = http + host_pedido + ":" + port_pedido + "/pedido";

    protected String getUrlCliente(){
        return urlCliente;
    }
    protected String getUrlRepartidor(){
        return urlRepartidor;
    }
    protected String getUrlPedido(){
        return urlPedido;
    }

}
