SELECT * FROM `nbateam` WHERE   `id`  =  (SELECT    `nbateamid` FROM `user`  WHERE `first_name` = 'zzzz');

SELECT `user`.`first_name` , `nbateam`.`fullname` , `nbateam`.`abbreviation` , `nbateam`.`city`
FROM `user`
LEFT JOIN `nbateam`
ON `user`.`nbateamid` = `nbateam`.`id`;