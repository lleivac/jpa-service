use facturacion;
insert into ventas (id_cliente, monto_total, fecha_pedido)values(1,1200, "2022-10-28");
insert into ventas (id_cliente, monto_total, fecha_pedido)values(2,500, "2022-10-28");
insert into ventas (id_cliente, monto_total, fecha_pedido)values(5,900, "2022-11-01");
insert into ventas (id_cliente, monto_total, fecha_pedido)values(6,900, "2022-11-02");

select * from facturacion.ventas;