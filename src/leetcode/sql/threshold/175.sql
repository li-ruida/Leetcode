select firstName ,lastName ,city ,state
from Person p left join Address a on p.personId =a.personId