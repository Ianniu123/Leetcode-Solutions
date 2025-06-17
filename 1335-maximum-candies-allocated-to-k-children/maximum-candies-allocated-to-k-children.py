from typing import List

class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        minC = 1
        maxC = sum(candies) // k
        res = 0

        while minC <= maxC:
            c = (minC + maxC) // 2
            count = sum(pile // c for pile in candies)

            if count >= k:
                res = c  # this size is possible, try bigger
                minC = c + 1
            else:
                maxC = c - 1

        return res
