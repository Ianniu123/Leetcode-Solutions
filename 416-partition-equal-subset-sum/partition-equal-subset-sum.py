class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        cache = set()
        target = 0
        for num in nums:
            target += num
        
        if target % 2 != 0:
            return False
        
        target /= 2

        for num in nums:
            buffer = []
            for j in cache:
                if (j + num) == target:
                    return True
                
                buffer.append(j + num)

            if num == target:
                return True
            buffer.append(num)

            for n in buffer:
                cache.add(n)
        
        return False