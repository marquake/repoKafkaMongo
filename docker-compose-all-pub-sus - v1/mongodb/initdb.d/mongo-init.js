
// Se crea la base de datos
db = db.getSiblingDB("dbpepdidos");

// Creo el usuario que usare para gestionarla y sus permisos
db.createUser({
    user: "mmsuser",
    pwd: "ygritte",
    roles: [
      {
        role: 'readWrite', 
        db: 'dbpepdidos'
      },
    ],
  });

//db.createCollection("got_seasons_collection");
db.createCollection("cliente");
db.createCollection("repartidor");
db.createCollection("pedido");
db.createCollection("items-pedidos");
db.createCollection("estado_pedido");

db.cliente.insertMany([
    {
        id_cliente: 887,
        nom_cliente: "cliente-mms-887"
    },
    {
        id_cliente: 888,
        nom_cliente: "cliente-mms-888"
    }
]);

db.repartidor.insertMany([
    {
        id_repartidor: 776,
        nom_repartidor: "repartidor-mms-776"
    },
    {
        id_repartidor: 777,
        nom_repartidor: "repartidor-mms-777"
    }
]);

db.pedido.insertMany([
    {
        pedido: 998,
        num_ref: "nf998",
        id_cliente: 887,
        id_repartidor: 776
    },
    {
        pedido: 999,
        num_ref: "nf999",
        id_cliente: 888,
        id_repartidor: 777
    }
]);

//PENDIENTE
//EN PROCESO
//ENTREGADO
//CANCELADO
db.estado_pedido.insertMany([
    {
        id_estado_pedido : 554,
        id_pedido: 998,
        estado_pedido: "PENDIENTE"
    },
    {
        id_estado_pedido : 555,
        id_pedido: 999,
        estado_pedido: "PENDIENTE"
    }
]);