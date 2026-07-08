SELECT ROUND(
    COUNT(DISTINCT a1.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
    2
) AS fraction
FROM Activity AS a1
JOIN (
    -- This subquery finds the first login date for each player
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) AS a2 
ON a1.player_id = a2.player_id 
AND DATEDIFF(a1.event_date, a2.first_login) = 1;
