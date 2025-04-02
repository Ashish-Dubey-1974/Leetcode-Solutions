select firstName,lastName,city,state
from person
left join address
on person.personid=address.personid
union
select firstName,lastName,city,state
from person
inner join address
on person.personid=address.personid;

