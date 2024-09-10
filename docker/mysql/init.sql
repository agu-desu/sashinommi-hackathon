create table IF NOT EXISTS todo (
    todoid   integer auto_increment primary key,
    todoname varchar (255) not null
);

create table IF NOT EXISTS match (
    matchid integer auto_increment primary key,
    matchname varchar(15) not null,
    matchfeeling integer not null,
    
)