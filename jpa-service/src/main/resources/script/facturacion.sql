use facturacion;
create table cliente(
id int primary key auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null,
dni varchar(15) not null unique,
fecha_nacimiento Date not null
);

create table producto(
id int primary key auto_increment,
nombre_producto varchar(30) not null,
precio_compra double not null,
precio_venta double not null,
existencia int not null
);
create table ventas(
id int primary key auto_increment,
id_cliente int not null,
monto_total int not null,
fecha_pedido date,
constraint fk_cliente_id foreign key (id_cliente) references cliente(id)
);

USE facturacion;
create table detalle_ventas(
id int primary key auto_increment,
id_ventas int default null,
id_producto int not null,
cantidad int not null,
sub_total double,
constraint fk_ventas_id foreign key (id_ventas) references ventas(id), 
constraint fk_producto_id foreign key (id_producto) references producto(id) 
); 

