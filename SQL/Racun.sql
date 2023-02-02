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
    cijena  int,
    ukupno int
   
);




create table racuni(
    sifra int not null primary key auto_increment,
    ukupnaCijena decimal(10,2),
    brracuna int,
    datum datetime,
    blagajnik int
);

alter table stavkeRacuna add foreign key (proizvod) references proizvodi (sifra);
alter table racuni add foreign key (blagajnik) references blagajnik (sifra);
alter table stavkeRacuna add foreign key (brracuna) references racuni (sifra);
