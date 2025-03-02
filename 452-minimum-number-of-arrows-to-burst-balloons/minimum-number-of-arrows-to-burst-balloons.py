class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda x: x[1])
        count = 1
        prev = points[0][1]
        for i in range(1, len(points)):
            if points[i][0] > prev:
                count += 1
                prev = points[i][1]

        return count