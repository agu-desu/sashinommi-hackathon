create table IF NOT EXISTS matching (
    match_id integer auto_increment primary key,
    match_name varchar(15) not null,
    match_emotion_id integer not null,
    match_url varchar(150) not null
);
create table IF NOT EXISTS emotion (
    emotion_id integer auto_increment primary key,
    emotion_name varchar(15) not null
);


create table IF NOT EXISTS chat (
    chat_id integer auto_increment primary key,
    chat_name varchar(15) not null,
    chat_message varchar(200) not null,
    chat_time TIMESTAMP not null
);

delete from emotion;

insert into emotion (emotion_id, emotion_name)
values (1,'リラックスしたい'), (2,'楽しく騒ぎたい'),(3,'悩み相談'),(4,'恋愛トーク');