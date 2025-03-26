SELECT email
FROM Person
GROUP BY 1
having count(1) >= 2;