class Solution:
    def findRestaurant(self, list1: List[str], list2: List[str]) -> List[str]:
        list=[]
        val=float('inf')
        for i in range(len(list1)):
            if(list1[i] in list2):
                idx=list2.index(list1[i])
                com = i+idx
                if(com<val):
                    val=com
                    list=[list1[i]]
                elif com==val:
                    list.append(list1[i])
        return list
        