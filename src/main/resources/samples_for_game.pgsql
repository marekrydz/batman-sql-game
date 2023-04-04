-- Samples for game (Heroku)

insert into answers(id, answer_sql,answer_hql, game_lvl )
VALUES (177,
        'select * from heroes',
        'select h.id, h.name, h.realName, h.power from Hero h ',
        '1.0'),
       (181,
        'select * from heroes where name = ''Batman''',
        'select h.id, h.name, h.realName, h.power from Hero h where h.name=''Batman''',
        '1.1'),
       (182,
        'select * from heroes where real_name like ''S%''',
        'select h.id, h.name, h.realName, h.power from Hero h where h.realName like ''S%''',
        '1.2'),
       (183,
        'select * from heroes where name in (''Batman'',''Robin'')',
        'select h.id, h.name, h.realName, h.power from Hero h where h.name in (''Batman'',''Robin'')',
        '1.3'),
       (184,
        'select * from heroes h where h.power between 20 and 80',
        'select h.id, h.name, h.realName, h.power from Hero h where h.power between 20 and 80',
        '1.4'),
       (288,
        'select h.name, h.real_name, bs.how, bs.place from heroes as h full join become_stories as bs on h.become_story_id= bs.id',
        'select h.name, h.realName, bs.how, bs.place from Hero h full join h.becomeStory bs' ,
        '2.0'),
       (218,
        'select h.name, bs.how, bs.place from heroes as h join become_stories bs on h.become_story_id = bs.id where h.name= ''Batman''',
        'select h.name, bs.how, bs.place from Hero h join h.becomeStory bs where h.name=''Batman''',
        '2.1'),
       (388,
        'select h.name, h.real_name, w.weapons_names, w.characteristic from heroes as h left join weapons w on h.id = w.hero_id',
        'select h.name, h.realName, w.weaponName, w.characteristic from Hero h left join h.weapons w',
        '3.0'),
       (488,
        'select h.name, h.real_name, e.nick, e.enemy_real_name from  heroes h
              inner join heroes_enemies  he on h.id = he.hero_id
              inner join enemies e on e.id = he.enemy_id',
        'select h.name, h.realName, e.nick, e.enemyRealName from Hero h left join h.enemies e',
        '4.0');

-- Add become stories
insert into become_stories (id, place, how)
values (1, 'On a sidewalk in Crime Alley, in Gotham City', 'After his parents killed he start training'),
       (2, 'On the Gotham City streets', 'Training martial arts to perfect her skills in cat burglary');

-- Add heroes
insert into heroes (id, name, real_name, become_story_id)
values (1, 'Batman', 'Bruce Wayne', 1),
       (2, 'Catwoman', 'Selina Kyle', 2),
       (3, 'Robin', 'Dick Grayson ',null);

-- Add weapons
insert into weapons (id, weapons_names, characteristic, hero_id)
values (1, 'Batarang', 'specialized throwing star', 1),
       (2, 'Batmobile', 'self driving, bulletproof super car', 1),
       (3, 'Whip', 'long whip to defend and transport', 2),
       (4, 'Claws', 'Made from strong steel, very sharp', 2);

-- Add enemies
insert into enemies (id, nick, enemy_real_name )
values (1, 'Joker', 'Arthur Fleck'),
       (2, 'Poison Ivy', 'Pamela Lillian Isley'),
       (3, 'Mr. Freeze', 'Victor Fries'),
       (4, 'Harley Quinn', 'Harleen Frances Quinzel');

--Connect enemies with heroes
insert into heroes_enemies(hero_id, enemy_id)
VALUES (1,1),(1,2),(1,3),(1,4),
       (2,1),(2,2),(2,3),(2,4);


select * from answers;