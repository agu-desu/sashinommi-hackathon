create table IF NOT EXISTS match (
    matchid integer auto_increment primary key,
    matchname varchar(15) not null,
    matchfeeling integer not null,
    matchurl varchar(150) not null
)

create table IF NOT EXISTS chat (
    chatid integer auto_increment primary key,
    chatname varchar(15) not null,
    chatmessage varchar(200) not null,
    chattime TIMESTAMP not null
)
