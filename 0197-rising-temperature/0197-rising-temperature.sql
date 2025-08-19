select w2.id
from weather w1
join weather w2
on Datediff(w2.recordDate,w1.recordDate)=1
And w1.temperature<w2.temperature;