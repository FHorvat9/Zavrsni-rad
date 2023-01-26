drop database if exists Racun;
create database Racun;
use Racun;

create table proizvodi(
    sifra int not null primary key auto_increment,
    ime varchar(50),
    cijena decimal(10,2)
);

create table blagajnik(
    sifra int not null primary key auto_increment,
    ime varchar(20)    
);

create table stavkeRacuna(
    sifra int not null primary key auto_increment,
    brracuna int,
    proizvod int,
    kolicina int,
    cijena	int,
    ukupno int
   
);
alter table stavkeRacuna add foreign key (proizvod) references proizvodi (sifra);
alter table stavkeRacuna add foreign key (cijena) references proizvodi (sifra);


create table racuni(
    sifra int not null primary key auto_increment,
    ukupnaCijena decimal(10,2),
    brracuna int,
    datum datetime,
    blagajnik int
);

alter table racuni add foreign key (brracuna) references stavkeRacuna (sifra);
alter table racuni add foreign key (blagajnik) references blagajnik (sifra);




insert into proizvodi(sifra,ime,cijena)
values
    (null,'Kruska',1.1),
    (null,'Jabuka',2.2),
    (null,'Sljiva',3.3),
    (null,'Kruh',4.4),
    (null,'Margarin',5.5),
    (null,'Mlijeko',6.6);

insert into stavkeRacuna(sifra,brracuna,proizvod,kolicina,cijena,ukupno)
values
    
    (null, 1, 1, 2, 1, 1.1),
    (null, 1, 2, 2, 2, 4.4),
    (null, 1, 3, 4, 3, 13.2),

    (null, 2, 4, 5, 4, 22),
    (null, 2, 5, 5, 5, 27.75),
    (null, 2, 6, 5, 6, 39.96);
    


insert into blagajnik(sifra,ime)
values
(null,'Filip Horvat'),
(null,'Ivan Markotic');

insert into racuni(sifra,ukupnaCijena,brracuna,datum,blagajnik)
values
    
    (null,18.7, 1, '2019-08-20 10:22:34', 1),
    (null, 89.71, 2,'2019-08-20 10:22:34', 2);
    
    





