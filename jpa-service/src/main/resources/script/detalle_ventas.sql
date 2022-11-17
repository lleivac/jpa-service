use facturacion;
insert into facturacion.detalle_ventas (id_ventas, id_producto, cantidad, sub_total) values(1,2, 1,900);
insert into facturacion.detalle_ventas (id_ventas, id_producto, cantidad, sub_total) values(1,4, 1,500);
insert into facturacion.detalle_ventas (id_ventas, id_producto, cantidad, sub_total) values(2,2,2,900);
insert into facturacion.detalle_ventas (id_ventas, id_producto, cantidad, sub_total) values(2,1,2,1800);

select * from facturacion.detalle_ventas;

